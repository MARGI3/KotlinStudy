package com.margi.kotlinstudy.lambdat;

class JavaSAMFunction {

    /**
     * 参考  {@link JavaFunctionalInterface} 中的调用详解
     *
     * java中定义的携带 SAM 作为参数的方法，在kotlin在调用时会提供两种 方式
     *
     * 1. doSomething( Long, Runnable! )
     * 2. doSomething( Long, (() -> Unit)! )
     *
     * 第一种方式 java中常见的 对象表达式 （函数式接口类型）
     * 第二种方式 kotlin提供的 lambda 表达式 调用方式
     */
    void doSomething(long delay, Runnable action) {
        //这里不关心delay参数，只关心 SAM （single abstract method）参数
        action.run();
    }

}
