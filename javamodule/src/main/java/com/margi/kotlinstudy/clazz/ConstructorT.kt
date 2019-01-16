package com.margi.kotlinstudy.clazz

/**
 *
 * 1. 类的声明
 *
 *    类名  类头(指定其类型参数，主构造函数)  类体
 *
 * 2. 在 Kotlin 中的⼀个类可以有⼀个主构造函数以及⼀个或多个次构造函数。主构造函数是类头的⼀部分： 它跟在类名（与可选的类型参数）后
 */

class ConstructorT constructor(prop1: String, prop2: Int) {}


/** 如果主构造函数没有任何 注解 或者 可见性修饰符， 可以省略 constructor 关键字 */
class ConstructorT2(var prop1: String, var prop2: Int) {

    /** 主构造函数不能包含任何代码，初始化代码 可以放到 init 代码块中 */
    init {
        prop1 = "abc"
        prop2 = 1
    }

}

class ConstructorT3(prop1: String, prop2: Int) {

    /**
     *
     * 1. 实例初始化期间 initializer blocks 与 属性初始化器 依次按照代码顺序执行
     * 2. 主构造函数可以在初始化块中使用，也可以在 类体 内部的属性初始化器中使用
     * */
    val firstProperty = "First property : $prop2 ".also(::println)

    init {
        println("First initializer block that prints $prop2 ")
    }

    val secondProperty = "Second property: ${prop1.length}".also(::println)

    init {
        println("Second initializer block that prints ${prop1.length}")
    }


    /**
     * 如果构造函数有注解或可⻅性修饰符，这个 constructor 关键字是必需的，并且这些修饰符在它前⾯：
     */
//     class ConstructorT public @annatation constructor()


    /**
     * 类也可以声明前缀有 constructor 的 次构造函数
     */
//    constructor(var prop1: String) {
//
//    }

}


class ConstructorT4(prop1: String, prop2: Int) {
    /**
     * 1. 如果类有⼀个主构造函数，每个次构造函数需要委托给主构造函数，可以直接委托或者通过别的次构造函数间接委托。
     * 委托到同⼀个类的另⼀个构造函数⽤ this 关键字即可
     *
     * 2. 初始化块中的代码块实际上会成为主构造函数的一部分。委托给主构造函数 会作为次构造函数的第一条语句
     * --> 初始化块中的代码会在次构造函数的体之前完成， 即使这个类没有主构造函数，这种委托仍然会隐式发生，并且仍然会执行 init blocks
     *
     *  main constructor >> init blocks >> sub constructor
     */
    constructor(prop1: String, prop2: Int, prop3: Int) : this(prop1, prop2) {
        println(" constructor ")
    }


    /**
     * 如果⼀个⾮抽象类没有声明任何（主或次）构造函数，它会有⼀个⽣成的不带参数的主构造函数。
     * 构造函数的可⻅性是 public。
     * 如果你不希望你的类有⼀个公有构造函数，你需要声明⼀个带有⾮默认可⻅性的空的主构造函数：
     */
//    class ConstructorT private constructor()
}



