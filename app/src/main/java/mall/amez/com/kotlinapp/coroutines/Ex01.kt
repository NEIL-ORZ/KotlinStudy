package mall.amez.com.kotlinapp.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


/**
 * @USER NEIL.Z
 * @TIME 2020/6/17 0017 10:37
 * @DESC 启动协程
 */
fun main(args: Array<String>) {
    log(1)
    GlobalScope.launch {
        log(-1)
        delay(1000L)
        log(-2)
    }
    log(2)
    Thread.sleep(5000L)
    log(3)
}