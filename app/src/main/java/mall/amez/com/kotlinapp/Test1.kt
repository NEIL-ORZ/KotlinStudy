package mall.amez.com.kotlinapp

/**
 * @USER NEIL.Z
 * @TIME 2020/4/2 11:00
 * @DESC 类使用
 */
class Test1 {
    fun test() {
        var test = Test2("name")
        var test1 = Test3()//有默认参数可不带参
        var test2 = Test3(2, "2")//带所有参数
        var test3 = Test3(arg1 = 3)//指定参数名带参，位置参数

        //使用属性
        Test2("李").name
        Test2("张").sex

        //内部类
        var test4 = Test5().Test6()

        //匿名类
        val listen = object : A {
            override fun getName(): String {
                return ""
            }
        }

        //数据类
        var test5 = Test9("Test9", 20)

        //单例
        Test10.name
        //部分静态，使用嵌套对象
        Test11.Test12.name
        //伴生对象可以省去中间对象名
        Test13.name14
    }
}

//主构造函数 注：若主构造函数无任何注解 / 可见性修饰符，可省略 constructor 关键字
//class 类名 constructor（参数名：参数类型）{
//init {
//初始化的代码
//}
//}
class Test2 constructor(userName: String) {
    init {
        //初始化代码块，先于构造器执行
    }

    var name = userName
        get() = name
    val sex: String = "男"

}

//class 类名（参数名1：参数类型，参数名2：参数类型...）{
//}
//若一个默认参数在一个无默认值的参数前，那么该默认值只能通过使用命名参数调用该函数来使用
class Test3(var arg1: Int = 0, val arg2: String = "默认参数") {
}

//次构造函数
//constructor(参数名：参数类型) :{函数体}
class Test4(userName: String) {
    // 主构造函数
    init {
        println(userName)
    }

    // 次构造函数1：通过this调主构造函数，依赖主构造函数
    constructor() : this("hjc")

    // 次构造函数2：可通过this调主构造函数
    constructor(age: Int) : this("hjc") {
        println(age)
    }

    // 次构造函数3：通过this调主构造函数
    constructor(sex: String, age: Int) : this("hjc") {
        println("$sex$age")
    }
}

//继承 类默认不可继承 用open关键字标识该类允许被继承
open class Food {
    //方法也是默认不可重写的 open关键字标识可重写
    open fun banana() {}
}

// 类Fruits继承类Food 重写父类方法
class Fruits : Food() {
    override fun banana() {
        super.banana()
    }
}

/**
 * 1. 嵌套类（内部类）
 * 标识：关键字inner
 * 使用：通过外部类的实例调用嵌套类
 */
class Test5 {
    inner class Test6 {

    }
}

/**
 * 2. 接口
 * 标识：关键字interface
 */
// 声明
interface A {
    fun getName(): String // 无默认方法体，必须重写
    fun getAge(): Int {    // 有默认方法体，可不重写
        return 22
    }
}

// 实现接口：冒号:
class Test7 : A {
    override fun getName(): String {
        return "Test6"
    }
}

// 继承 + 实现接口
class Test8 : Food(), A {
    override fun getName(): String {
        return "Test6"
    }
}

/**
 * 3. 数据类
 * 作用：保存数据
 * 标识：关键字data
 */
// 使用：创建类时会自动创建以下方法：
//      1. getter/setter方法；
//      2. equals() / hashCode() 对；
//      3. toString() ：输出"类名(参数+参数值)"；
//      4. copy() 函数：复制一个对象&改变它的一些属性，但其余部分保持不变
// 特别注意
// 1. 主构造方法至少要有一个参数，且参数必须标记为val或var
// 2. 数据类不能用open、abstract、sealed(封闭类)、inner标识
data class Test9(var userName: String, var age: Int)

/**
 * 4. 枚举类
 * 标识：关键字enum
 */
// 定义
enum class Color1 {
    RED, GREEN, BLUE
}

// 为枚举类指定值
enum class Color2(rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF)
}

/**
 * 静态方法
 * object
 * 饿汉式的单例，线程安全
 * 创建一个类，并且创建一个这个类的对象。这个就是 object 的意思：对象
 * 通过类直接引用
 */
object Test10 {
    val name = "test10"
}

//部分静态
class Test11 {
    //嵌套对象
    object Test12 {
        //静态变量
        val name = "test12"
    }
}

class Test13 {
    //companion  伴生对象,表示修饰的对象和外部类绑定。
    companion object Test14 {
        //静态变量
        val name14 = "test14"
    }

    //一个类中最多只可以有一个伴生对象，但可以有多个嵌套对象
    object Test15 {
        //静态变量
        val name15 = "test15"
    }
}

class Test16 {
    //companion object 修饰时，对象的名字也可以省略掉
    companion object {
        //静态方法

        init {

            //静态初始化

        }

        //静态变量
        val name16 = "test16"
    }

}

/**
 * 顶层声明
 * 和静态变量、静态方法一样是全局
 */
// 属于 package，不在 class/object 内
fun topLevelFuncion() {
}

/**
 *  常量
 *  只有基本类型和 String 类型可以声明成常量
 */
const val CONST_SECOND_NUMBER = 2