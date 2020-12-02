package br.com.emanuel.desafiomarvelhqs.data.api

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.MessageDigest

class NetworkUtils {

    companion object {
        private const val CRYPTO_MOD = "MD5"

        private const val BASE_URL = "https://gateway.marvel.com/v1/public/"
        private const val PRIVATE_KEY = "9024a98498dc0dc9eb6ac28484e6a0fd0effc315"
        const val PUBLIC_KEY = "de74c8eb8ecc0046b983135f2477c889"
        private var timestamp = ""

        fun getRetrofitInstance(baseUrl: String = BASE_URL): Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        fun getTimestamp(): String {
            timestamp = System.currentTimeMillis().toString()
            return timestamp
        }

        fun getHash(): String {
            val textToCrypto = timestamp + PRIVATE_KEY + PUBLIC_KEY
            return textToCrypto.toMD5()
        }

        private fun String.toMD5(): String {
            val bytes = MessageDigest.getInstance(CRYPTO_MOD).digest(this.toByteArray())
            return bytes.toHex()
        }

        private fun ByteArray.toHex(): String {
            return joinToString("") { "%02x".format(it) }
        }
    }

}