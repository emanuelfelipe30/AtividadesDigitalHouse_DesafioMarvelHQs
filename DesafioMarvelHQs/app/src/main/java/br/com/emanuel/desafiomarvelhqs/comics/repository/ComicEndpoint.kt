package br.com.emanuel.desafiomarvelhqs.comics.repository

import br.com.emanuel.desafiomarvelhqs.comics.model.ComicModel
import br.com.emanuel.desafiomarvelhqs.data.api.NetworkUtils
import br.com.emanuel.desafiomarvelhqs.data.model.ResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ComicEndpoint {
    @GET("comics")
    suspend fun getComics(@Query("ts") ts: String?, @Query("apikey") apiKey: String, @Query("hash") hash: String): ResponseModel<ComicModel>

    companion object {
        val endpoint: ComicEndpoint by lazy {
            NetworkUtils.getRetrofitInstance().create(ComicEndpoint::class.java)
        }
    }
}