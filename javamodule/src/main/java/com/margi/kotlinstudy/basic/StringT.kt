package com.margi.kotlinstudy.basic

/**
 * author : maji
 * date   : 18/12/10
 * mail   : maji@bilibili.com
 */
class StringT {

    fun fun1() {
        val str = "abcdefgh"
        for (c in str) {
            println(c)
        }
    }

    fun fun2() {

        // val str1 = 1 + "abc"
        // error
        // + 也可以连接字符串和其他类型值，要求表达式中第一个元素是字符串
        val str = "abc" + 1
        println(str + "def")
    }

    fun fun3() {
        val text = """ for (c in "foo") print(c) """"
        println(text)//原始字符串，三个引号表示
    }

    fun fun4() {
        val i = 10
        println(" i = $i ") // 字符串模板表达式 以 美元符 $ 开头

        //${} 括起任意表达式
        val s = "abc"
        println("$s.length is ${s.length}") // "abc.length is 3"

        //原始字符串 转义字符串 内部都支持 字符串模板
        // $ 不支持转义，如果需要在 原始字符串中使用 $， 采用以下写法
        val price = """ ${'$'}9.99 """
    }


}