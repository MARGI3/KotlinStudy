package com.margi.kotlinstudy.collectiont

/**
 * author : maji
 * date   : 19/1/11
 * mail   : maji@bilibili.com
 */
class CollectionT {

    //collection map filter 会生成中间临时 list 来对应map 和 filter
    fun collectionChain() {
        println("collection chain invoke")
        listOf(1, 2, 3, 4, 5)
            .map {
                println("map($it) ")
                it * it
            }.filter {
                println("filter($it) ")
                it % 2 == 0
            }
    }

    //sequence 的 懒处理
    //在调用 toList (terminal operation) 之前 并不会触发 map  filter （intermediate operation） 操作
    //terminal operation 指得到最后结果的一次操作
    fun sequenceChain() {
        println("sequence chain invoke")
        listOf(1, 2, 3, 4, 5).asSequence()
            .map {
                println("map($it) ")
                it * it
            }.filter {
                println("filter($it) ")
                it % 2 == 0
            }.toList()
    }

    /**
     * collection 操作对应 eager operation
     *
     * sequence 操作对应 lazy operation
     */

    /**
     * The naive approach would be to call the map function on
     * each element first and then call the filter function on each element of the resulting
     * sequence. That’s how map and filter work on collections
     *
     * but not on sequences. For
     * sequences, all operations are applied to each element sequentially: the first element is
     * processed (mapped, then filtered), then the second element is processed, and so on
     */

    /**
     * collection sequence 中间操作（intermediate operation）的执行顺序
     *
     * collection 的 map filter 执行顺序
     * map(1) map(2) map(3) ... -> filter(1) filter(2) filter (3) ...
     *
     * sequence 的 map filter 执行顺序
     * map(1) filter(1)  map(2) filter(2) map(3) filter(3) ...
     */


}