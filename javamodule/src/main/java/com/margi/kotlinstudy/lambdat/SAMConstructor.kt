package com.margi.kotlinstudy.lambdat

class SAMConstructor {

    /**
     * SAM 构造方法是编译器生成的函数，让你执行从 lambda 到函数式接口实例的显式转换
     */

    /**
     * 可 以在编译器不会自动应用转换的上下文中使用它
     * 例如，如果有方法返回 是一个函数式接口 的实例，不能直接返回 lambda ，
     * 要用 SAM 构造方法把它包装起来。
     * 这里有一个简单的例子
     */
    fun createAllDoneRunnable(): Runnable {
        return Runnable { println("All Done") }
    }

    /**
     * 除了返回值外， SAM 造方法还可 用在需要把从 ambd 生成的函数式接口实例存储在一个变量中
     * 假设 要在多个按钮上重用同一个监昕器，就像下的代码清单一样（在 Android 这段代码可以作为 Activity.a Create方法 一部分)
     */
//    val listener = one ickListener { view ->
//    val text = when (view.id) {
//        R.id.button1 ->” First button”
//        R.id.button2 ->”Second button"
//        else ->”Unknown button ”
//    }
//    button1.setOnClickListener(listener)
//    button2.setOnClickListener(l stener)

    /**
     * Lambda 和添加／移除监昕器
     * 注意 lambda 内部没有匿名对象那样的 this ：没有办法引用到 lambda 转换成的匿名类实例 从编译器的角度来看， lambda 是一个代码块，不是一个对象，而且也不能把它当成对象引用
     * Lambda 中的 this 引用指向的是包围它的类。
     *
     * 如果你的事件监听器在处理事件时还需要取消它自己，不能使用 lambda
     * 这样做 这种情况使用实现了接口的匿名对象 在匿名对象内， this 指向该对象
     * 实例，可以把它传给移除监听器的 API
     */

}