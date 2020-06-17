package mall.amez.com.kotlinapp

import android.widget.Button
import android.widget.TextView

/**
 * @USER NEIL.Z
 * @TIME 2020/4/2 16:13
 * @DESC 集合
 */
class TestArray {
    fun test() {
        var i = 1
        var s = "a"

        // 方式1：使用arrayOf创建1个数组：[1,2,3]
        val a = arrayOf(1, 2, 3)
        // 方式2：使用工厂函数创建1个数组[0,2,4]
        val b = Array(3, { i -> (i * 2) })
        // 特别注意：除了类Array，还有ByteArray, ShortArray, IntArray用来表示各个类型的数组,优点：省去了装箱操作，因此效率更高
        val x: IntArray = intArrayOf(1, 2, 3)

        //List 以固定顺序存储一组元素，元素可以重复。
        val strlist = listOf("a", "b", "c")//不可变
        val strlist1 = mutableListOf("a", "b", "c")//可变

        //Set 存储一组互不相等的元素，通常没有固定顺序。
        val strSet = setOf("a", "b", "c")//不可变
        val strSet1 = strSet.toMutableSet()//返回的是一个新建的集合，原有的集合还是不可变的，所以只能对函数返回的集合修改

        //Map 存储 键-值 对的数据集合，键互不相等，但不同的键可以对应相同的值。
        val strMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3)//不可变
        val strMap1 = mutableMapOf("key1" to 1, "key2" to 2, "key3" to 3)//可变
        strMap1.put("key1", 4)

        //forEach：遍历每一个元素
        strlist.forEach {
            print(it)
        }
        strlist.forEach { i -> print(i) }//lambda 表达式

        //filter：对每个元素进行过滤操作
        var xNew = x.filter {
            it != 1
        }
        xNew = x.filter { i -> i != 1 }//lambda 表达式

        //map：遍历每个元素并执行给定表达式，最终形成新的集合
        xNew = x.map {
            it + 1
        }
        xNew = x.map { i -> i + 1 }//lambda 表达式

        //flatMap：遍历每个元素，并为每个元素创建新的集合，最后合并到一个集合中
        x.flatMap {
            listOf("${it + 1}", "a") //生成新集合
        }
        x.flatMap { i ->
            listOf("${i + 1}", "a") //生成新集合
        }

        //Range 表示区间
        var range: IntRange = 0..1000//包括1000
        var range1: IntRange = 0 until 1000//不包括 1000
        //默认步长为 1，输出：0, 1, 2, 3, 4, 5, 6, 7....1000,
        for (i in range) {
            print("$i, ")
        }
        //步长为 2，输出：0, 2, 4, 6, 8, 10,....1000,
        for (i in range step 2) {
            print("$i, ")
        }
        //递减 输出：4, 3, 2, 1,
        for (i in 4 downTo 1) {
            print("$i, ")
        }

        /**
         * Sequence 惰性集合操作
         * 和 Iterable 一样用来遍历一组数据并可以对每个元素进行特定的处理
         * 代码运行时不会立即执行，它只是定义了一个执行流程，只有 result 被使用到的时候才会执行
         * 当出现满足条件的第一个元素的时候，Sequence 就不会执行后面的元素遍历了
         * List 是没有惰性的特性的
         */
        var slist = a.asSequence();
        slist = sequenceOf(1, 2, 3)
        //lambda 表达式创建 0:第一个元素 表达式负责生成第二个及以后的元素，it 表示前一个元素
        val slist1 = generateSequence(0) { it + 1 }
        val result = slist.map { i ->
            i * 2
        }.filter {
            it % 3 == 0
        }
        println(result.first()) // 只取集合的第一个元素

        //if/else
        var max = if (i > i) i else i
        max = if (i > i) {
            println("max:a")
            i // 返回 a
        } else {
            println("max:b")
            i // 返回 b
        }

        /**
         * when
         * 类似switch
         * 省略了 case 和 break，前自动为每个分支加上了 break
         */
        when (i) {
            1 -> {
                println("1")
            }
            2 -> {
                println("2")
            }
            else -> {
                println("else")
            }
        }
        val value: Int = when (i) {
            1 -> {
                i + 1
            }
            2 -> {
                i * 2
            }
            else -> {
                i + 5
            }
        }
        //多条件
        when (i) {
            1, 2 -> print("x == 1 or x == 2")
            else -> print("else")
        }
        //使用 in 检测是否在一个区间或者集合中：
        when (i) {
            in 1..10 -> print("x 在区间 1..10 中")
            in listOf(1, 2) -> print("x 在集合中")
            // not in
            !in 10..20 -> print("x 不在区间 10..20 中")
            else -> print("不在任何区间上")
        }
        //使用 is 进行特定类型的检测：
        val isString = when (s) {
            is String -> true
            else -> false
        }
        //可以省略 when 后面的参数，每一个分支条件都可以是一个布尔表达式：
        when {
            s.contains("a") -> print("字符串 str1 包含 a")
            s.length == 3 -> print("字符串 str2 的长度为 3")
        }

        //try-catch
        val at: Int? = try {
            1
        } catch (e: NumberFormatException) {
            null
        }

        //Elvis 操作符 ?:
        val str: String? = "Hello"
        //length 非空接收报错
//        var length: Int = str?.length
        //左侧表达式 str?.length 结果为空，则返回右侧的值 -1
        var length: Int = str?.length ?: -1
        fun validate(a: Int?) {
            val id = a ?: return // 验证 a 是否为空，为空时 return
        }

        /**
         * 泛型
         * 使用关键字 out 来支持协变，等同于 Java 中的上界通配符 ? extends。
         * 使用关键字 in 来支持逆变，等同于 Java 中的下界通配符 ? super。
         * out 表示，我这个变量或者参数只用来输出，不用来输入，你只能读我不能写我；in 就反过来，表示它只用来输入，不用来输出，你只能写我不能读我
         */
        val producer1: Producer<TextView> = Producer<Button>() //  这里不写 out 也不会报错
        val producer2: Producer<out TextView> = Producer<Button>() //  out 可以但没必要
        val consumer1: Consumer<Button> = Consumer<TextView>() //  这里不写 in 也不会报错
        val consumer2: Consumer<in Button> = Consumer<TextView>() //in 可以但没必要

        //* 号，相当于  out Any
        var list: List<*>
    }
}

class Producer<out T> {
}

class Consumer<in T> {
}

//T 的类型必须是 Producer 的子类型
class Monster<T : Producer<T>> {

}

//设置多个边界可以使用
class Monster1<T> where T : Producer<T> {

}