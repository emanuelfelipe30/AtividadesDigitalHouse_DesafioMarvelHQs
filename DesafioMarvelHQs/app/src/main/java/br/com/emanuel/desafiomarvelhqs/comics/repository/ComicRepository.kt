package br.com.emanuel.desafiomarvelhqs.comics.repository

import br.com.emanuel.desafiomarvelhqs.data.api.NetworkUtils

class ComicRepository {

    private val client = ComicEndpoint.endpoint

    suspend fun getComics() = client.getComics(
        NetworkUtils.getTimestamp(),
        NetworkUtils.PUBLIC_KEY,
        NetworkUtils.getHash()
    )

}