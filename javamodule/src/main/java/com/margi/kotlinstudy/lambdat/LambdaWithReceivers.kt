package com.margi.kotlinstudy.lambdat

class LambdaWithReceivers {

    /**
     * with 得到 receiver 的执行结果
     */
    fun alphabetWith(): String {
        val builder = StringBuilder()
        return with(builder) {
            for (letter in 'A' .. 'Z') {
                this.append(letter)
            }
            append(" \n now i know the alphabet ")
            this.toString()
        }
    }

    /**
     * 方法名冲突
     *
     * 如果 当前类 内部有一个 methodA 然后 with 接收者 receiver 也有一个同名函数 methodA
     * 可以通过 this.methodA() 表明使用 receiver 的方法
     * 通过 this@OuterClass.methodA() 表明使用 当前持有receiver对象的类的方法
     */

    /**
     * 表达式函数体 省去变量声明
     */
    fun alphabetWith2() = with(StringBuilder()) {
        for (letter in 'A' .. 'Z') {
            append(letter)
        }
        append(" \n now i know the alphabet ")
        toString()
    }

    /**
     * apply 得到 receiver 本身
     */
    fun alphabetApply(): String {
        val builder = StringBuilder()
        return builder.apply {
            for (letter in 'A' .. 'Z') {
                this.append(letter)
            }
            append(" \n now i know the alphabet ")
        }.toString()
    }

    fun alphabetApply2() = StringBuilder().apply {
        for (letter in 'A' .. 'Z') {
            this.append(letter)
        }
        append(" \n now i know the alphabet ")
    }.toString()


    //通过apply 使任意对象 都能实现 Builder 模式
    //TextView(context).apply {
    //   text = "content"
    //   textSize = 20.0
    //   setPadding(10, 0, 0, 0)
    // }
}