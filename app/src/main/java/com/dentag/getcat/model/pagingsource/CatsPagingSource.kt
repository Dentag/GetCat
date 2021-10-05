package com.dentag.getcat.model.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.dentag.getcat.api.CatApi
import com.dentag.getcat.api.getCatApi
import com.dentag.getcat.model.entities.Cat
import com.dentag.getcat.model.entities.mapToCat
import retrofit2.HttpException

class CatsPagingSource(
    private val catApi: CatApi = getCatApi()
) : PagingSource<Int, Cat>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Cat> {
        try {
            val pageNumber = params.key ?: INITIAL_PAGE_NUMBER
            val pageSize = params.loadSize
            val response = catApi.getCatsPage(pageSize.toString(), pageNumber.toString())

            return if (response.isSuccessful) {
                val catList = response.body()?.map { it.mapToCat() } ?: listOf()
                val nexPageNumber = if (catList.isEmpty()) null else pageNumber + 1
                val prevPageNumber = if (pageNumber > 1) pageNumber - 1 else null
                LoadResult.Page(catList, prevPageNumber, nexPageNumber)
            } else {
                LoadResult.Error(HttpException(response))
            }
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Cat>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val anchorPage = state.closestPageToPosition(anchorPosition) ?: return null
        return anchorPage.prevKey?.plus(1) ?: anchorPage.nextKey?.minus(1)
    }

    companion object {
        private const val INITIAL_PAGE_NUMBER = 0
    }
}
