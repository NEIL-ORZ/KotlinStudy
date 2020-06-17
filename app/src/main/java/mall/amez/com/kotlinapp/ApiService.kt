package mall.amez.com.kotlinapp

import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @USER NEIL.Z
 * @TIME 2020/4/7 10:37
 * @DESC
 */
interface ApiService {

    @GET("users/{login}")
    fun getUser(@Path("login") login: String): Call<User>

    @GET("users/{login}")
    fun getUser1(@Path("login") login: String): Deferred<User>

    @GET("users/{login}")
    suspend fun getUser2(@Path("login") login: String): User
}

data class User(val id: String, val name: String, val url: String)