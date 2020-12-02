package br.com.emanuel.desafiomarvelhqs.comicdetail.model

import br.com.emanuel.desafiomarvelhqs.comics.model.ThumbnailModel

data class ComicDetailModel(
    val id: Int,
    val thumbnail: ThumbnailModel,
    val title: String,
    val description: String,
    val dates: List<DateModel>,
    val prices: List<PriceModel>,
    val pageCount: Int
)