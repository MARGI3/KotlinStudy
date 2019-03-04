package com.margi.kotlinstudy.properties

/**
 *
 * 幕后属性
 *
 * 幕后属性的使用场景：
 *
 * 我们希望一个属性：对外表现为只读，对内表现为可读可写  这样的属性就是  幕后属性
 *
 */
class BackingProperties {

    private var _table: Map<String, Int>? = null
    public val table: Map<String, Int>
        get() {
            if (_table == null) {
                _table = HashMap() // 类型参数已推断出
            }
            return _table ?: throw AssertionError("Set to null by another thread")
        }

    /***
     * 将_table属性声明为private,因此外部是不能访问的，内部可以访问，外部访问通过table属性，而table属性的值取决于_table，这里_table就是幕后属性
     */


    /**
     * 幕后属性这中设计在Kotlin 的的集合Collection中用得非常多
     * Collection 中有个size字段，size 对外是只读的，size的值的改变根据集合的元素的变换而改变
     * 这是在集合内部进行的，这用幕后属性来实现非常方便
     *
     */

    /** 如Kotlin AbstractList中SubList源码 **/
//    private class SubList<out E>(private val list: AbstractList<E>, private val fromIndex: Int, toIndex: Int) : AbstractList<E>(), RandomAccess {
//        // 幕后属性
//        private var _size: Int = 0
//
//        init {
//            checkRangeIndexes(fromIndex, toIndex, list.size)
//            this._size = toIndex - fromIndex
//        }
//
//        override fun get(index: Int): E {
//            checkElementIndex(index, _size)
//
//            return list[fromIndex + index]
//        }
//
//        override val size: Int get() = _size
//    }


    /** AbstractMap 源码中的keys 和 values 也用到了幕后属性 */

//    /**
//     * Returns a read-only [Set] of all keys in this map.
//     *
//     * Accessing this property first time creates a keys view from [entries].
//     * All subsequent accesses just return the created instance.
//     */
//    override val keys: Set<K>
//        get() {
//            if (_keys == null) {
//                _keys = object : AbstractSet<K>() {
//                    override operator fun contains(element: K): Boolean = containsKey(element)
//
//                    override operator fun iterator(): Iterator<K> {
//                        val entryIterator = entries.iterator()
//                        return object : Iterator<K> {
//                            override fun hasNext(): Boolean = entryIterator.hasNext()
//                            override fun next(): K = entryIterator.next().key
//                        }
//                    }
//
//                    override val size: Int get() = this@AbstractMap.size
//                }
//            }
//            return _keys!!
//        }
//
//    @kotlin.jvm.Volatile
//    private var _keys: Set<K>? = null


}