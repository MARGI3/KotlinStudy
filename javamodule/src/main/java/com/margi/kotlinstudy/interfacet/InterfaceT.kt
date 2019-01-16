package com.margi.kotlinstudy.interfacet

interface MyInterface {
    fun bar()
    fun foo() {
        //可选的方法体
    }
    /** 与抽象类不同的是，接⼝⽆法保存状态。它可以有属性但必须声明为抽象或提供访问器实现 */
    var prop1: Int// 接口中声明的属性 默认就是抽象的，子类实现接口时 必须 实现该属性
}

class Implement : MyInterface {

    override fun bar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /** 也可以将这个属性实现 放在 类的 主构造函数中  */
    override var prop1: Int
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}

}

