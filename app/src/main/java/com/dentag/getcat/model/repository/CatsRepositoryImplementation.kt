package com.dentag.getcat.model.repository

import androidx.paging.PagingSource
import com.dentag.getcat.model.entities.Cat
import com.dentag.getcat.model.pagingsource.CatsPagingSource

class CatsRepositoryImplementation : CatsRepository {
    override fun getCatsPage(): PagingSource<Int, Cat> = CatsPagingSource()
}
