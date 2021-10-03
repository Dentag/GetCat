package com.dentag.getcat.model.repository

import java.util.*

interface InternalStorageRepository {
    fun saveImage(imageByteArray: ByteArray)
}
