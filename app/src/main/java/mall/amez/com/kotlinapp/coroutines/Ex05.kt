package mall.amez.com.kotlinapp.coroutines

import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext


/**
 * @USER NEIL.Z
 * @TIME 2020/6/17 0017 10:37
 * @DESC 协程返回结果
 */
fun main(args: Array<String>) = runBlocking() {
    log(1)
    val result: Deferred<String> = async {
        log(-1)
        loadForResult().also {
            log(-2)
        }
    }
    log(2)
    log("result:${result.await()}")
    log(3)
}

suspend fun loadForResult(): String {
    delay(1000)
    return "Helloworld"
}