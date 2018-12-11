package com.margi.kotlinstudy.clazz

/**
 * author : maji
 * date   : 18/12/11
 * mail   : maji@bilibili.com
 */

/**
 * 在 Kotlin 中所有类都有⼀个共同的超类 Any ，这对于没有超类型声明的类是默认超类
 */
class Example {} // 从 Any 隐式继承

/**
 * 1. 要声明⼀个显式的超类型，我们把类型放到类头的冒号之后
 *
 * 2. 如果子类有一个主构造函数， 其基类型可以并且必须 使用基类型的主构造函数参数 就地初始化
 * */
open class Base(p: Int)

class Derived(p: Int) : Base(p)


/**
 * 如果类没有主构造函数，那么每个次构造函数必须使⽤ super 关键字初始化其基类型，或委托给另⼀个构造函数做到这⼀点。
 * 注意，在这种情况下，不同的次构造函数可以调⽤基类型的不同的构造函数
 * */
open class BaseView(p1: Int) {

    constructor(p1: Int, p2: String) : this(p1)
}

class DerivedView : BaseView {

    constructor(p1: Int) : super(p1)

    constructor(p1: Int, p2: String) : super(p1, p2)
}