package com.margi.kotlinstudy.controlflow

class ControlFlow {

    fun fun1(a: Int, b: Int) {

        //传统用法
        var max1 = a
        if (a < b) max1 = b

        val max2: Int
        if (a > b) {
            max2 = a
        } else {
            max2 = b
        }

        val max = if (a > b) a else b

    }

    fun fun2(a: Int, b: Int) {
        val max = if (a > b) {
            println("choose a")
            a
        } else {
            println("choose b")
            b
        }

        //if 作为表达式赋值时， 必须要有else分支
//        val max = if (a > b) {
//            a
//        }

        val min = if (a > b) {
            a
        } else {
            b
        }
    }


    fun fun3() {

        labelt@ for (i in 1..10) {
            println("outer i is $i")

            for (j in 1..10) {
                println("inner j is $j")
                if (j == 5) {
                    break@labelt
                }
            }
        }
        // outer 循环 1 次， inner 循环 5 次
    }

    fun fun4() {

        labelt@ for (i in 1..10) {
            println("outer j is $i")

            for (j in 1..10) {
                println("inner j is $j")
                if (j == 3) {
                    println()
                    continue@labelt
                }
            }
        }
        // outer 循环 10 次， inner 每次循环 3 次
    }


    fun fun5() {

        /**标签限制的 return 允许我们从外层函数返回。最重要的⼀个⽤途就是从 lambda 表达式中返回*/
        listOf(1, 2, 3, 4, 5).forEach({index: Int ->
            if (index == 3) return // ⾮局部直接返回到 fun5() 的调⽤者
            print(index)
        })
        println("this point is unreachable")


//        listOf(1, 2, 3, 4, 5).forEach(loop@ {index: Int ->
//            if (index == 3) return@loop // 自定义 label 局部返回到 lambda 表达式调用者
//            print(index)
//        })
//        println(" done with explicit label ")


//        listOf(1, 2, 3, 4, 5).forEach( {index: Int ->
//            if (index == 3) return@forEach // 默认 label 局部返回到 lambda 表达式调用者
//            print(index)
//        })
//        println(" done with implicit label ")


        /** 用 匿名函数 替代lambda 表达式， 匿名函数内部 return 将从匿名函数自身返回 */
//        listOf(1, 2, 3, 4, 5).forEach(fun(value: Int) {
//            if (value == 3) return
//            print(value)
//        })
//        println(" done with anonymous function ")


        /**增加嵌套另一层 lambda 表达式 改变非局部返回 */
//        run( loop@ {
//            listOf(1, 2, 3, 4, 5).forEach({index: Int ->
//                if (index == 3) return@loop
//                print(index)
//            })
//        })
//        print(" done with nested loop ")

    }

    fun fun6() : Int {

        /** 从标签处 处理返回值*/

        loopA@ for (i in 1..10) {
            for (j in 1..10) {
                if (j == 3) return@loopA 1000 //return 到 loopA 标签位置，并且返回值是 1000
            }
        }
        return 1
    }



}