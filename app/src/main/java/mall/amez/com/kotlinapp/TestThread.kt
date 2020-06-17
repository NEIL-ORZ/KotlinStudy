package mall.amez.com.kotlinapp

import kotlinx.coroutines.*
import java.lang.Runnable

/**
 * @USER NEIL.Z
 * @TIME 2020/4/3 9:45
 * @DESC 协程
 */
class TestThread {

    fun test() {

        //完整写法
        Thread(object : Runnable {
            override fun run() {
            }
        })
        //SAM简化
        Thread({

        })
        //闭包简化
        Thread {

        }

        // 方法一，使用 runBlocking 顶层函数  适用于单元测试
        runBlocking { }

        // 方法二，使用 GlobalScope 单例对象，可以直接调用 launch 开启协程
        GlobalScope.launch {
        }

        // 方法三，自行通过 CoroutineContext 创建一个 CoroutineScope 对象 需要一个类型为 CoroutineContext 的参数
//        val coroutineScope = CoroutineScope(Dispatchers.Main)
        val coroutineScope = MainScope()
        coroutineScope.launch {
        }
        coroutineScope.launch(Dispatchers.IO) {
            //IO线程
        }
        coroutineScope.launch(Dispatchers.Main) {
            // 在主线程开启协程
//            val user = api.getUser() // IO 线程执行网络请求
//            nameTv.text = user.name  // 主线程更新 UI
        }
        coroutineScope.launch(Dispatchers.Main) {
            // 在 UI 线程开始
            val image = withContext(Dispatchers.IO) {
                // 切换到 IO 线程，并在执行完成后切回 UI 线程
//                getImage(imageId)                      // 将会运行在 IO 线程
            }
//            avatarIv.setImageBitmap(image)             // 回到 UI 线程更新 UI
        }
        coroutineScope.launch(Dispatchers.Main) {
            //在 UI 线程开始
            val image = getImage(0)     //withContext 放进一个单独的函数
//            avatarIv.setImageBitmap(image)     // 执行结束后，自动切换回 UI 线程
        }
    }

    /**
     * suspend
     * 代码执行到 suspend 函数的时候会『挂起』，并且这个『挂起』是非阻塞式的，它不会阻塞你当前的线程。
     * 从当前线程挂起。换句话说，就是这个协程从正在执行它的线程上脱离
     * 当线程执行到协程的 suspend 函数的时候，暂时不继续执行协程代码了
     * 执行在主线程的协程，它实质上会往你的主线程 post 一个 Runnable，这个 Runnable 就是你的协程代码
     * 当这个协程被挂起的时候，就是主线程 post 的这个 Runnable 提前结束，然后继续执行它界面刷新的任务
     * 线程的代码在到达 suspend 函数的时候被掐断，接下来协程会从这个 suspend 函数开始继续往下执行，不过是在指定的线程， withContext 传入的 Dispatchers.IO 所指定的 IO 线程

     * 常用的 Dispatchers ，有以下三种：
     * Dispatchers.Main：Android 中的主线程
     * Dispatchers.IO：针对磁盘和网络 IO 进行了优化，适合 IO 密集型的任务，比如：读写文件，操作数据库以及网络请求
     * Dispatchers.Default：适合 CPU 密集型的任务，比如计算
     */
    suspend fun getImage(imageId: Int) = withContext(Dispatchers.IO) {
    }

    /**
     * 自定义 suspend
     */
    suspend fun suspendUntilDone() {
        delay(5)
    }
}