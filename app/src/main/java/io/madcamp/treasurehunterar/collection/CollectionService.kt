package io.madcamp.treasurehunterar.collection

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.Deferred
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface CollectionService {
    @GET("/collection/{collectionNum}")
    suspend fun getCollectionById(@Path("id") id: String): Collection

    @GET("/collections")
    suspend fun getCollections(): List<Collection>


}

private const val BASE_URL = "http://172.10.5.178"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()


object CollectionApi {
    val retrofitService : CollectionService by lazy {
        retrofit.create(CollectionService::class.java)
    }
}
