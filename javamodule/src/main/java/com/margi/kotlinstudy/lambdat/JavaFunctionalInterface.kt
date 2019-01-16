package com.margi.kotlinstudy.lambdat

class JavaFunctionalInterface {

    @Suppress("ObjectLiteralToLambda")
    fun lambdaAsParam1() {
        val function = JavaSAMFunction()
        function.doSomething(100, object : Runnable {
            override fun run() {
                println("anonymous object : ")
            }
        })
    }

    fun lambdaAsParam2() {
        val function = JavaSAMFunction()
        function.doSomething(100) { println("lambda invoke : ") }

        /**
         * 这里通过lambda表达式当做参数， kotlin 编译器会帮你创建一个 实现了 Runnable 接口的匿名类
         */
    }

    fun lambdaAsParam3() {
        val function = JavaSAMFunction()
        val captureVariable = 10
        function.doSomething(100) { println("lambda invoke with capture $captureVariable : ") }
    }


    /**
     *
     * lambdaAsParam1 中通过 object 关键字创建的对象 在每一次方法调用 doSomething 的时候 都会创建新的实例
     *
     * lambdaAsParam2 通过lambda 表达式，并且Runnable未使用外部变量，多次调用 doSomething lambda对应的匿名类 可以复用
     *
     * lambdaAsParam2 通过lambda 表达式，但是Runnable使用了外部变量，每一次调用 doSomething 都会新建一个 lambada 对应的匿名类实例
     *
     */

}