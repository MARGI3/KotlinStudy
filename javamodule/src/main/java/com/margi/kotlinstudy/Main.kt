package com.margi.kotlinstudy

import com.margi.kotlinstudy.clazz.ConstructorT
import com.margi.kotlinstudy.clazz.SubClass2
import com.margi.kotlinstudy.collectiont.CollectionT
import com.margi.kotlinstudy.controlflow.ControlFlow

/**
 * author : maji
 * date   : 18/12/11
 * mail   : maji@bilibili.com
 */
object Main {

    @JvmStatic
    fun main(args: Array<String>) {
//        val flow = ControlFlow()
//        flow.fun4()

//        val constructorT = ConstructorT("def", 2)

        val subClass2 = SubClass2("abc", "haha")

        val collection = CollectionT()
        collection.collectionChain()
        collection.sequenceChain()
    }
}