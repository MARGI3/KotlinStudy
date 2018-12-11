package com.margi.kotlinstudy.clazz

/**
 * author : maji
 * date   : 18/12/11
 * mail   : maji@bilibili.com
 */


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
class DerivedClass2() : BaseClass() {
    final override fun fun1() {
        super.fun1()
    }
}


