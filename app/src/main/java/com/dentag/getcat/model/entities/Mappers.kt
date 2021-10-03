package com.dentag.getcat.model.entities

fun CatDto.mapToCat(): Cat = Cat(
    id = this.id ?: "",
    url = this.url ?: "",
    width = this.width ?: 0,
    height = this.height ?: 0
)
