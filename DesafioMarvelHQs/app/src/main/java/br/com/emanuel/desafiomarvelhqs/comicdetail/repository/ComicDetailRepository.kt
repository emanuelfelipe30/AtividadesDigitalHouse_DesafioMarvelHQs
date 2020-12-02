package br.com.emanuel.desafiomarvelhqs.comicdetail.repository

import br.com.emanuel.desafiomarvelhqs.data.api.NetworkUtils

class ComicDetailRepository {

    private val client = ComicDetailEndpoint.endpoint

    suspend fun getComicById(id: Int) = client.getComicById(
        id,
        NetworkUtils.getTimestamp(),
        NetworkUtils.PUBLIC_KEY,
        NetworkUtils.getHash()
    )

}