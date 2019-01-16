package com.margi.kotlinstudy.clazz

open class BaseClass {
    open fun fun1() {}
    fun fun2() {}
}

/**
 * Kotlin ⼒求清晰显式。与 Java 不同，Kotlin 对于可覆盖的成员（我们称之为开放）以及覆盖后的成员需要显式修饰符
 */
class DerivedClass() : BaseClass() {

    override fun fun1() {}

    /**
     * 如果父类函数 没有标注 open,子类不允许定义相同签名函数，不论加不加 override
     */
//    override fun fun2() {}
}

/**
 * 标记为 override 的成员本⾝是开放的，也就是说，它可以在⼦类中覆盖。如果你想禁⽌再次覆盖，使⽤final 关键字
 */
open class DerivedClass2() : BaseClass() {
    final override fun fun1() {
        super.fun1()
    }
}

class DerivedClass2Sub() : DerivedClass2() {
//    override fun fun1() {}
}



/**
 * 属性覆盖
 *
 * 属性覆盖与⽅法覆盖类似；在超类中声明然后在派⽣类中重新声明的属性必须以 override 开头，并且
 * 它们必须具有兼容的类型。每个声明的属性可以由具有初始化器的属性或者具有 getter ⽅法的属性覆盖。
 * */

open class Foo {
    open val x: Int get() {return 0}
}

class Bar1 : Foo() {
    override val x: Int
        get() = super.x
}



interface InterfaceClass {
    val prop1: Int
}
/** 你可以在主构造函数中使⽤ override 关键字作为属性声明的⼀部分 **/
class Class1(override val prop1: Int) : InterfaceClass

class Class2 : InterfaceClass {
    /**
     * 也可以用var属性覆盖val属性，反之则不行。
     * val属性本质声明了一个 getter
     * var属性本质声明了一个 getter 和 setter
     */
    override var prop1: Int = -1
}


/**
 * 派生类 初始化顺序
 */
open class BaseClass2(val prop1: String) {
    init {
        println(" initializing BaseClass2 ")
    }

    open val size: Int = prop1.length.also { println(" initializing prop1 in BaseClass2 length : $it , value : $prop1 ") }

}

class SubClass2(
        prop1: String,
        val prop2: String
) : BaseClass2(prop1.capitalize().also { println(" Argument for BaseClass2 : $it ") }) {

    init {
        println(" Initializing SubClass2")
    }

    override val size: Int =
            (super.size + prop2.length).also { println(" Initializing size in SubClass2 : $it ") }

    /**
     *   Argument for BaseClass2 : Abc
     *   initializing BaseClass2
     *   initializing prop1 in BaseClass2 : 3
     *   Initializing SubClass2
     *   Initializing size in SubClass2 : 7
     */
}




open class BaseClass3 {
    open fun fun1() {
        println("BaseClass3.fun1()")
    }
    open val x: Int get() = 1
}
/**派⽣类中的代码可以使⽤ super 关键字调⽤其超类的函数与属性访问器的实现*/
class SubClass3 : BaseClass3() {
    override fun fun1() {
        super.fun1()
        println("SubClass3.fun1()")
    }

    override val x: Int get() = super.x + 1

    /**在⼀个内部类中访问外部类的超类，可以通过由外部类名限定的 super 关键字来实现 super@Outer */
    inner class InnerSubClass3 {
        fun fun2() {
            super@SubClass3.fun1()
            println(super@SubClass3.x)
        }
    }
}


/**
 * 多继承 指定调用方法
 */
open class A {
    open fun f() { println("A") }
    fun a() { println("") }
}

interface B {
    fun f() { println("B") }
    fun b() { println("b") }
}

class C() : A(), B {

    override fun f() {
        super<B>.f() // 调用 A.f()
        super<A>.f() // 调用 B.f()
    }

}




