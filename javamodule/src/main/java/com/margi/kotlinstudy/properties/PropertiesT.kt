package com.margi.kotlinstudy.properties

import org.jetbrains.annotations.Nullable

/**
 * 属性
 */
class Address {
//属性可以⽤关键字var 声明为可变的，否则使⽤只读关键字val
    var name: String = ""
    var street: String = ""
    var city: String = ""
    var state: String? = ""
    var zip: String = ""
}

fun copyAddress(address: Address): Address {
    val result = Address() // Kotlin 中没有“new”关键字
    result.name = address.name // 将调⽤访问器
    result.street = address.street
    return result
}

/**
 * Getters 与 Setters
 *
 * 声明⼀个属性的完整语法是
 *
 * //可变属性
 * var <propertyName>[: <PropertyType>] [= <property_initializer>]
 *     [<getter>]
 *     [<setter>]
 *
 * //只读属性
 * val <propertyName>[: <PropertyType>] [= <property_initializer>]
 *     [<getter>]
 */

class PropertiesT1 {

    /**其初始器（initializer）、getter 和 setter 都是可选的。属性类型如果可以从初始器（或者从其 getter 返回值，如下⽂所⽰）中推断出来，也可以省略**/
    // 错误：需要显式初始化器，隐含默认 getter 和 setter
//    var allByDefault: Int?
    var initialized = 1 // 类型 Int、默认 getter 和 setter

    /**只读属性不允许 setter */
//    val simple: Int? // 类型 Int、默认 getter、必须在构造函数中初始化
    val inferredType = 1 // 类型 Int 、默认 getter


    /**
     * 我们可以为属性定义⾃定义的访问器。如果我们定义了⼀个⾃定义的 getter，那么每次访问该属性时都会调⽤它（这让我们可以实现计算出的属性）。
     */
    private var size: Int = 0

    val isEmpty: Boolean
        get() = this.size == 0

    /**
     * 如果我们定义了⼀个⾃定义的 setter，那么每次给属性赋值时都会调⽤它。
     * */
    var stringRepresentation: String
        get() = this.toString()
        set(value) {
            //按照惯例，setter 参数的名称是 value ，但是如果你喜欢你可以选择⼀个不同的名称
            println("setter value is : $value") // do something here
        }

    /**⾃ Kotlin 1.1 起，如果可以从 getter 推断出属性类型，则可以省略它*/
    val isEmpty2 get() = this.size == 0


    /**
     * 如果你需要改变⼀个访问器的可⻅性或者对其注解，但是不需要改变默认的实现，你可以定义访问器⽽不定义其实现
     */
    var setterVisibility: String = "abc"
        private set // 此 setter 是私有的并且有默认实现
    var setterWithAnnotation: Any? = null
        @Nullable set // ⽤ Nullable (任意合法注解均可) 注解此 setter

}
