package com.margi.kotlinstudy.properties

/**
 * reference: https://www.itcodemonkey.com/article/8849.html
 */
class BackingField {

//    /**在Kotlin中，getter、setter 是属性声明的一部分，声明一个属性默认提供getter和setter*/
//    var prop1: String = "abc"
//    val prop2: Int = 3
//
//    /**
//     * 假设现在我们想自定义 getter 和 setter， 并且自定义的 setter getter 中使用到了 属性自身的值
//     */
//    var prop3: String
//        set(value) {
//            println(this.prop3)
//            //自定义 prop3 setter 为自动 添加字符串操作， 发现这里 IDE 提示递归操作
//            prop3 = value + "setter"
//        }
//        get() {
//            //自定义 prop3 getter 为自动 添加字符串操作， 发现这里 IDE 提示递归操作
//            return prop3 + "getter"
//        }
//
//    val prop4: Int
//        get() {
//            //自定义 prop4 getter 为自动 添加字符串操作， 发现这里 IDE 提示递归操作
//            return prop4 + 1
//        }

    /**
     * tools -> kotlin -> show kotlin byte code -> decompile
     * 得到 java 代码如下，发现 kotlin 中在 setter， getter 中访问属性自身时
     * 其实是 调用的 setter getter 来完成的，所以这里就会出现 递归调用, 最终无线循环 stack over flow
     *
     * 当然这就不是我们预期达到的效果，
     *
     * 所以我们要在 setter getter 中正确的 使用 属性自身的 value 该如何完成呢？
     *
     * ->>>>  backing field 幕后字段
   */

//    @NotNull
//    public final String getProp3() {
//        return this.getProp3() + "getter";
//    }
//
//    public final void setProp3(@NotNull String value) {
//        Intrinsics.checkParameterIsNotNull(value, "value");
//        String var2 = this.getProp3();
//        System.out.println(var2);
//        this.setProp3(value + "setter");
//    }
//
//    public final int getProp4() {
//        return this.getProp4() + 1;
//    }


    /**
     * -------- backing field ---------
     *
     * 还是来实现之前的目的，使用幕后字段代码如下
     */
    var prop5: String = "abc"
        set(value) {
            println(field)
            //自定义 prop5 setter 为自动 添加字符串操作， 发现这里 IDE 提示递归操作
            field += "setter"
        }
        get() {
            //自定义 prop3 getter 为自动 添加字符串操作， 发现这里 IDE 提示递归操作
            return field + "getter"
        }

    val prop6: Int = 0
        get() {
            //自定义 prop6 getter 为自动 添加字符串操作， 发现这里 IDE 提示递归操作
            return field + 1
        }


    /**
     * 转换成 java 代码发现 这里才是我们预期的效果
     */
//    @NotNull
//    public final String getProp5() {
//        return this.prop5 + "getter";
//    }
//
//    public final void setProp5(@NotNull String value) {
//        Intrinsics.checkParameterIsNotNull(value, "value");
//        String var2 = this.prop5;
//        System.out.println(var2);
//        String var10001 = this.prop5;   // ---NOTE--  这里出现的临时变量 var10001 就是一个幕后的字段的实际 ---NOTE----
//        this.prop5 = var10001 + "setter";
//    }
//
//    public final int getProp6() {
//        return this.prop6 + 1;
//    }

    /**
     * 以上我们知道了 幕后字段的存在意义是什么
     *
     * 现在来看看 幕后字段的一些规则
     */

    /**
     * 在 Kotlin 类中不能直接声明字段。然⽽，当⼀个属性需要⼀个幕后字段时，Kotlin 会⾃动提供。
     * 这个幕后字段可以使⽤ field 标识符在访问器中引⽤
     */
    var counter = 0 // 注意：这个初始器直接为幕后字段赋值
        set(value) {
            /** field 标识符只能⽤在属性的访问器内 */
            if (value >= 0) field = value
        }

    /**
     * 幕后字段在某些情况下才会存在
     *
     * 1. 使用默认 getter / setter 的属性，一定有幕后字段。对于 var 属性来说，只要 getter / setter 中有一个使用默认实现，就会生成幕后字段
     * 2. 在自定义 getter / setter 中使用了 field 的属性
     *
     * Note: field 是幕后字段的引用
     *
     * 根据 第 99 行注释可以看出来 临时变量 var10001 完成了效果
     *
     * NOTE:  有幕后字段的属性转换成Java代码一定有一个对应的Java变量
     */
    private val size: Int = 1

    //isEmpty 没有幕后字段
    val isEmpty: Boolean
        get() = this.size == 0
}