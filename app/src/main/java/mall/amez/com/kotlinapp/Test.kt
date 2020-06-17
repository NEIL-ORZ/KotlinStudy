package mall.amez.com.kotlinapp

import android.util.Log

/**
 * @USER NEIL.Z
 * @TIME 2020/4/1 15:18
 * @DESC 语法
 *
 * public：公开，可见性最大，哪里都可以引用。
 * private：私有，可见性最小，根据声明位置不同可分为类中可见和文件中可见。
 * protected：保护，相当于 private + 子类可见。
 * internal：内部，仅对 module 内可见。
 */
class Test {

    //延迟初始化
    lateinit var strTest: String

    /**
     * 无参方法
     */
    fun test() {

        strTest = "str"

        // 模板： var 变量名：数据类型 = 具体赋值数值
        // 规则：
        //      1. 采用 “var” 标识
        //      2. 变量名跟在var后；数据类型在最后
        //      3. 变量名与数据类型采用冒号 ":" 隔开
        var a: Int = 1

        // 模板： val 常量名：数据类型 = 具体赋值数值
        // 规则：
        //      1. 采用 “val” 标识
        //      2. 常量名跟在val后；数据类型在最后
        //      3. 常量名与数据类型采用冒号 ":" 隔开
        val str: String = "test"
        //解除非空
        val str1: String? = null


        // 将字符类型转换成数字
        val ch: Char = '8'
        val ca: Int = ch.toInt()

        //可使用三个引号 """拼接多行字符串，不会转义
        val text = """
        字符串1
        字符串2
         """
        // 注：可通过 trimMargin()删除多余空白
        val text1 = """
        | str1
        |str2
        |多行字符串
        |bbbbbb
        """.trimMargin()

        // $：表示一个变量名 / 变量值
        val i = 10
        val si = "i = $i" // 表示 "i = 10"

        // ${varName.fun()}：表示变量的方法返回值
        val s = "abc"
        val si1 = "$s.length is ${s.length}" //识别为 "abc.length is 3"

    }

    /**
     * 带参方法
     * arg1带默认值
     */
    fun test1(arg1: Int = 1, arg2: String) {

    }

    /**
     * 带返回方法
     */
    fun test2(arg1: Int): String {
        return "a"
    }

    /**
     * 带参方法
     * 参数可空
     * 传递参数可空状态必须一致
     */
    fun test3(arg1: Int?) {

    }

    fun testIf() {

        val i = 1

        /**
         *  1. in
         *  作用：在...范围内
         **/
        // 表示：若i在1-5范围内，则执行下面代码
        if (i in 1..5) {
            println("i 在 1-5 内")
        }

        // 表示：若i不在1-5范围内，则执行下面代码
        // !in表示不在...范围内
        if (i !in 1..5) {
            println("i 不在 1-5 内")
        }

        /**
         *  2. until
         *  作用：表示开区间
         **/
        // 输出1234
        for (i in 1 until 5) {
            println(i)
        }

        /**
         *  3. downTo
         *  作用：倒序判断
         **/
        for (i in 5 downTo 1) {
            println(i)
        }

        /**
         *  4. step
         *  作用：调整步长
         **/
        // 设置步长为2，顺序输出1、3、5
        for (i in 1..5 step 2) println(i)

        // 设置步长为2，倒序输出5、3、1
        for (i in 1 downTo 5 step 2) println(i)
    }

    fun testCheck() {
        /**
         *  1. is
         *  作用：判断一个对象与指定的类型是否一致
         **/
        var a: Any = "a"
        if (a is String) {
            println("a是String类型")
        }
        if (a !is Int) {
            println("a不是Int类型")
        }

        /**
         *  2. 智能转换
         *  说明： kotlin不必使用显式类型转换操作，因为编译器会跟踪不可变值的is检查以及显式转换，并在需要时自动插入（安全的）转换
         **/
        if (a is String) {
            println("a是String类型")
            println(a.length) // a 自动转换为String类型
            //输出结果为：1
        }
        // 反向检查： a自动转换为String类型
        if (a !is String) {
            print(a)
        }

        // 在 && 和 || 的右侧也可以智能转换：
        // `&&` 右侧的 a 自动转换为String
        if (a is String && a.length > 0) {
        }
        // `||` 右侧的 a 自动转换为String
//        if (a is String || a.length > 0) {
//        }

        // 在when表达式和while循环里也能智能转换：
        when (a) {
            is String -> a.length
            is Int -> a + 1
        }

        /**
         *  3. 强制类型转换：as
         **/
        var any: Any = "abc"
        var str1: String = any as String

        // 强制类型转换是不安全的，若类型不兼容则会抛出一个异常
        var int: Int = 123
        var str2: String = int as String
        // 抛出ClassCastException

        /**
         *  4. 可空转换操作符：as？
         *  作用：null不能转换为String，因该类型不是可空的，此时使用可空转换操作符as?
         **/
        var str3 = null
        var str4 = str3 as String
        // 抛出TypeCastException

        // 使用安全转换操作符as?可以在转换失败时返回null，避免了抛出异常。
        var str5 = null
        var str6 = str5 as? String
        println(str2) //输出结果为：null
    }

    fun testEquals() {
        /**
         *  1. 结构相等：equals()或 ==
         *  作用：判断两个结构是否相等
         **/
        var a = "1"
        var b = "1"
        if (a.equals(b)) {
            println("a 和 b 结构相等")
            // 输出结果为：a 和 b 结构相等
        }
        if (a == b) {
            println("a 和 b 结构相等")
            // 输出结果为：a 和 b 结构相等
        }

        /**
         *  2. 引用相等：===
         *  作用：判断两个引用是否指向同一对象
         */
        // 设置一个类如下
        data class User(var name: String, var age: Int)

        // 设置值
        var aU = User("Czh", 22)
        var bU = User("Czh", 22)
        var c = aU
        var d = bU

        // 对比两个对象的结构
        if (c == d) {
            println("a 和 b 结构相等")
        } else {
            println("a 和 b 结构不相等")
        }

        // 对比两个对象的的引用
        if (c === d) {
            println("a 和 b 引用相等")
        } else {
            println("a 和 b 引用不相等")
        }

        // 输出结果： a 和 b 结构相等 / a 和 b 引用不相等
    }

    fun testNull() {
        /**
         *  1. 可空类型与非空类型
         *  在Kotlin中，有两种情况最可能导致出现NullPointerException
         **/

        // 情况1：显式调用 throw NullPointerException()
        // 情况2：使用!! 操作符
        // 说明：!!操作符将任何值转换为非空类型，保证这里的 a 一定是非空的，若该值为空则抛出异常
        var a = null
        a!!
        // 抛出KotlinNullPointerException

        // 情况3：数据类型不能为null
        // 在 Kotlin 中，类型系统区分一个引用可以容纳 null （可空引用） 和 不能容纳（非空引用）
        // 如：String类型变量不能容纳null
        // 若要允许为空，可声明一个变量为可空字符串：在字符串类型后面加一个问号? 对于String，则是写作：String?
        var b: String? = "b"
        b = null

        /**
         *  2. 安全调用操作符
         *  作用：表示如果若不为null才继续调用
         **/
        b?.length
        // 表示：若b不为null，才调用b.length

        // 注：安全调用符还可以链式调用 a?.b?.c?.d
        // 假设a不为null，才继续往下调用，以此类推
        // 若该链式调用中任何一个属性为null，整个表达式都会返回null。
        // 若只对非空值执行某个操作，可与let一起使用 a?.b?.let { println(it) }
    }
}