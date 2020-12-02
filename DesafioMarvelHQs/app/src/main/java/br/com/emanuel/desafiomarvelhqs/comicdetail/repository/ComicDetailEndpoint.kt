package br.com.emanuel.desafiomarvelhqs.comicdetail.repository

import br.com.emanuel.desafiomarvelhqs.comicdetail.model.ComicDetailModel
import br.com.emanuel.desafiomarvelhqs.data.api.NetworkUtils
import br.com.emanuel.desafiomarvelhqs.data.model.ResponseModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ComicDetailEndpoint {
    @GET("comics/{id}")
    suspend fun getComicById(
        @Path("id") id: Int,
        @Query("ts") ts: String?,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): ResponseModel<ComicDetailModel>

    companion object {
        val endpoint: ComicDetailEndpoint by lazy {
            NetworkUtils.getRetrofitInstance().create(ComicDetailEndpoint::class.java)
        }
    }
}