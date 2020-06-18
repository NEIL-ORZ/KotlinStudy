package mall.amez.com.kotlinapp.coroutines

import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext


/**
 * @USER NEIL.Z
 * @TIME 2020/6/17 0017 10:37
 * @DESC 协程取消
 */

fun main(args: Array<String>) = runBlocking() {
    log(1)
    val job: Job = launch {
        log(-1)
//        delay(10000)
        for (i in 0..100) {
            if (!isActive) break
            log("in loop:${i}")
        }
        log(-2)
    }
    log(2)
    job.cancel()
    log(3)
    job.join()
    log(4)
}