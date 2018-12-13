package com.margi.kotlinstudy.properties

/**
 * author : maji
 * date   : 18/12/13
 * mail   : maji@bilibili.com
 */

/**
 * 编译期常量 可以使用 const 修饰符标记，这些属性必须满足以下要求
 *
 * 1. 位于顶层 或者是 object声明 或 companion object 的一个成员
 * 2. 以 String 或者原生类型初始化
 * 3. 没有自定义 getter
 */
const val CONST_VALUE_1: Int = 1

object PropertiesTT1 {
    const val CONST_VALUE_3: Int = 3
}

class PropertiesTT {
    private companion object {
        const val CONST_VALUE_2: Int = 2


        /** const 编译期常量属性 可以用在注解中 */
        private const val ANNATATION_CONST: String = " this is deprecated "

        @Deprecated(ANNATATION_CONST)
        private fun fun1() {}

    }

    /**
     * 延迟初始化属性与变量
     * */

//    ⼀般地，属性声明为⾮空类型必须在构造函数中初始化。然⽽，这经常不⽅便。例如：属性可以通过依赖
//    注⼊来初始化，或者在单元测试的 setup ⽅法中初始化。这种情况下，你不能在构造函数内提供⼀个⾮
//    空初始器。但你仍然想在类体中引⽤该属性时避免空检查。
//    为处理这种情况，你可以⽤ lateinit 修饰符标记该属性

    /**
     * lateinit modifier is not allowed to on properties of primitive type
     */
//    lateinit var laterVar: Int

    lateinit var lateVar: String

}