package mall.amez.com.kotlinapp.coroutines

import kotlinx.coroutines.*
import java.lang.Exception


/**
 * @USER NEIL.Z
 * @TIME 2020/6/17 0017 10:37
 * @DESC 协程 网络回调
 */

interface Callback {
    fun onSuccess(result: String)
    fun onError(e: Throwable)
}

fun loadAsync(callback: Callback) {
    Thread {
        try {
            Thread.sleep(1000)
            if (Math.random() > 0.5f) {
                callback.onSuccess("Helloworld")
            } else {
                throw IllegalStateException("This is a error")
            }
        } catch (e: Throwable) {
            callback.onError(e)
        }
    }.start()
}

suspend fun load(): String {
    val completableDeferred = CompletableDeferred<String>()
    loadAsync(object : Callback {
        override fun onSuccess(result: String) {
            completableDeferred.complete(result)
        }

        override fun onError(e: Throwable) {
            completableDeferred.completeExceptionally(e)
        }

    })
    return completableDeferred.await()
}

fun main(args: Array<String>) = runBlocking {
    log(1)
    launch {
        log(-1)
        try {
            val result = load()
            log(result)
        } catch (e: Exception) {
            log(e)
        }
        log(-2)
    }.join()
    log(2)
}