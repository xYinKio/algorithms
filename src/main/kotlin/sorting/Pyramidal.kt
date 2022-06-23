package sorting

import compareToWithNull

fun main(){

    val data = Array<Pair<Int, Int>?>(10){ Pair(0,0) }
    for (i in data.indices){
        data[i] = Pair((Math.random() * 10).toInt(),0)
    }
    data[5] = null
    println(data.joinToString())

    data.sortByPyramidal{ (it?.first?:-1) }

    println(data.joinToString())
}



fun <T, R : Comparable<R>> Array<T>.sortByPyramidal(
    selector: (T) -> R?
) : Array<T>{
    makeHeap(selector)
    for (i in indices){
        val top = removeTopItem(selector,size - i)
        this[size - 1 - i] = top
    }
    return this
}

private fun <T, R : Comparable<R>>Array<T>.makeHeap(
    selector: (T) -> R?
){
    val values = this
    for (i in values.indices){
        var index = i
        while (index != 0){

            val parentIndex = (index - 1) / 2
            val child = selector(values[index])
            val parent = selector(values[parentIndex])

            if (child.compareToWithNull(parent) <= 0) break

            val temp = values[index]
            values[index] = values[parentIndex]
            values[parentIndex] = temp
            index = parentIndex
        }
    }
}

private fun <T, R : Comparable<R>>Array<T>.removeTopItem(
    selector: (T) -> R?,
    count: Int
) : T{
    val values = this
    val result = values[0]

    values[0] = values[count - 1]

    var parentIndex = 0
    while (true){
        var child1Index = 2 * parentIndex + 1
        var child2Index = 2 * parentIndex + 2

        if (child1Index >= count) child1Index = parentIndex
        if (child2Index >= count) child2Index = parentIndex

        val parent = selector(values[parentIndex])
        val child1 = selector(values[child1Index])
        val child2 = selector(values[child2Index])


        if (parent.compareToWithNull(child1) >= 0
            && parent.compareToWithNull(child2) >= 0) break



        val swapChild = if (child1.compareToWithNull(child2) > 0) child1Index else child2Index

        val temp = values[parentIndex]
        values[parentIndex] = values[swapChild]
        values[swapChild] = temp

        parentIndex = swapChild
    }
    return result
}