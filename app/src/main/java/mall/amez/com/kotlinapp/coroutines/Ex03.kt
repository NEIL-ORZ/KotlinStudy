package mall.amez.com.kotlinapp.coroutines

import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext


/**
 * @USER NEIL.Z
 * @TIME 2020/6/17 0017 10:37
 * @DESC 协程dispatcher
 */
private val threadPoolDispatcher = newSingleThreadContext("MyThreadPool")

fun main(args: Array<String>) = runBlocking() {
    log(1)
    val job: Job = launch(threadPoolDispatcher) {
        log(-1)
        delay(1000L)
        log(-2)
    }
    log(2)
    job.join()
    log(3)
}