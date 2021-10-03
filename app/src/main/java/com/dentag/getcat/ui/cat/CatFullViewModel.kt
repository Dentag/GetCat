package com.dentag.getcat.ui.cat

import androidx.lifecycle.ViewModel
import com.dentag.getcat.model.repository.InternalStorageRepository
import com.dentag.getcat.model.repository.InternalStorageRepositoryImplementation

class CatFullViewModel(
    private val internalStorageRepository: InternalStorageRepository = InternalStorageRepositoryImplementation()
) : ViewModel() {
    fun saveImage(imageByteArray: ByteArray) {
        internalStorageRepository.saveImage(imageByteArray)
    }
}
