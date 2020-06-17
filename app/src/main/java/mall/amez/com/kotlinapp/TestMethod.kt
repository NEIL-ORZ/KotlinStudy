package mall.amez.com.kotlinapp


/**
 * @USER NEIL.Z
 * @TIME 2020/4/2 14:16
 * @DESC 内置函数
 */
class TestMethod {

    fun test() {
        //接口回调
        setTest(object : LambdaTest.Test5 {

            override fun test5(a: Int) {
            }
        })
        //接口回调使用lambda表达式
        setTest(LambdaTest.Test5 { })

        //解除非空
        var testClass: TestClass? = null
        testClass = TestClass()

        /**
         * let函数：作用域
         * 定义一个变量在特定的作用域内
         * 注：返回值 = 最后一行 / return的表达式
         */
        testClass.let {
            // 作用1：使用it替代object对象去访问其公有的属性 & 方法
            it.fun1()
            it.fun2()
        }
        // 作用2：判断object为null的操作
        testClass?.let {
            //表示object不为null的条件下，才会去执行let函数体
            it.fun1()
            it.fun2()
        }

        /**
         * also函数：类似let函数
         * 区别：返回值 = 传入的对象的本身
         */
        var result = testClass?.let {
            it.fun1()
            it.fun2()
            999
        }
        var result1 = testClass?.also {
            it.fun1()
            it.fun2()
            999
        }

        /**
         * with函数
         * 调用多个方法 / 属性时，可以省去对象名重复，直接调用方法名 / 属性即可
         */
        with(testClass) {
            fun1()
            fun2()
        }

        /**
         * run函数
         * 结合了let、with两个函数的作用
         */
        testClass?.run {
            fun1()
            fun2()
            999
        }

        /**
         * apply函数
         * 结合了also、with两个函数的作用
         */
        testClass?.apply {
            fun1()
            fun2()
            999
        }
    }

    fun setTest(arg: LambdaTest.Test5) {
    }

}

class TestClass {
    fun fun1() {

    }

    fun fun2() {

    }

    fun fun3() {

    }

    //方法简化
    fun area(width: Int, height: Int): Int = width * height

    fun sayHi(name: String) = println("Hi " + name)

    //嵌套函数
    fun login(user: String, password: String, illegalStr: String) {

        //方式1
        fun validate(value: String) {
            if (value.isEmpty()) {
                throw IllegalArgumentException(illegalStr)
            }
        }
        validate(user)
        validate(password)

        //方式2：Kotlin 内置的 require 函数
        require(user.isNotEmpty()) { illegalStr }
        require(password.isNotEmpty()) { illegalStr }
    }
}