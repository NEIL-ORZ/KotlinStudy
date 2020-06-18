package mall.amez.com.kotlinapp.coroutines

import java.text.SimpleDateFormat
import java.util.*

/**
 * @USER NEIL.Z
 * @TIME 2020/6/17 0017 10:46
 * @DESC
 */
val dateFormat = SimpleDateFormat("HH:mm:ss:SSSS")

val now = {
    dateFormat.format(Date(System.currentTimeMillis()))
}

fun log(msg: Any?) = println("${now()}[${Thread.currentThread().name}] $msg")