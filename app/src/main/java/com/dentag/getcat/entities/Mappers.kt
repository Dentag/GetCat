package com.dentag.getcat.entities

fun CatApiResponse.mapToCat(): Cat = Cat(
    id = this.id ?: "",
    url = this.url ?: "",
    width = this.width ?: 0,
    height = this.height ?: 0
)
