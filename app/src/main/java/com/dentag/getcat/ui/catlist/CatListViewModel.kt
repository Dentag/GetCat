package com.dentag.getcat.ui.catlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.dentag.getcat.model.repository.CatsRepository
import com.dentag.getcat.model.repository.CatsRepositoryImplementation

class CatListViewModel(
    private val catsRepository: CatsRepository = CatsRepositoryImplementation()
) : ViewModel() {

    val pager = Pager(
        PagingConfig(pageSize = 20)
    ) {
        catsRepository.getCatsPage()
    }.flow.cachedIn(viewModelScope).asLiveData()
}
