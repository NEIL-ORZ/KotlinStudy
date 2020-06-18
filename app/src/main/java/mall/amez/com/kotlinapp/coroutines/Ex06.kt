package mall.amez.com.kotlinapp.coroutines

import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicInteger


/**
 * @USER NEIL.Z
 * @TIME 2020/6/17 0017 10:37
 * @DESC 协程 线程安全 引用外部变量问题
 */
var foo1 = 0
var foo2 = AtomicInteger(0)

fun main(args: Array<String>) = runBlocking {
    log(1)
    List(10000) {
        launch {
            repeat(10000) {
                foo1++
                foo2.incrementAndGet()
            }
        }
    }.forEach {
        it.join()
    }
    log(2)
    log("foo1:${foo1}")
    log(3)
    log("foo2:${foo2}")
}