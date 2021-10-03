package com.dentag.getcat.model.repository

import androidx.paging.PagingSource
import com.dentag.getcat.model.entities.Cat

interface CatsRepository {
    fun getCatsPage(): PagingSource<Int, Cat>
}
