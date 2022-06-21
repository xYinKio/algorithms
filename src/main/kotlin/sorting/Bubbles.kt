package sorting

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main(){

    val data = Array(100){0}
    for (i in data.indices){
        data[i] = (Math.random() * 100).toInt()
    }

    println(data.joinToString())
    println(data.sumOf { it })

    data.sortByBubbles{ -it }

    println(data.joinToString())
    println(data.sumOf { it })
}

fun <T, R : Comparable<R>> Array<T>.sortByBubbles(
    selector: (T) -> R?
) : Array<T>{

    val data = this
    var notSorted = true

    var sign = 1
    var leftSortedBorder = 0
    var rightSortedBorder = data.size - 1

    while (notSorted){
        notSorted = false

        var counter = 0
        val min = min(leftSortedBorder * sign, rightSortedBorder * sign)
        val max = max(leftSortedBorder * sign, rightSortedBorder * sign)

        for (_i in min..max){
            val index = abs(_i)
            val inset = when (val inset = index + sign) {
                data.size -> data.size - 1
                - 1 -> 0
                else -> inset
            }

            val left = selector(data[index])
            val right = selector(data[inset])

            val shouldChange = when{
                sign > 0 && left == null -> false
                sign > 0 && right == null -> true
                sign > 0 && left != null && right !=  null -> left > right
                left == null -> true
                right == null -> false
                else -> left < right
            }


            if (shouldChange){
                val temp = data[inset]
                data[inset] = data[index]
                data[index] = temp

                notSorted = true
                counter = 0
            } else {
                ++counter
            }
        }

        when{
            counter > 0 && sign > 0 -> rightSortedBorder -= counter
            counter > 0 && sign < 0 ->  leftSortedBorder += counter
            counter == 0 && sign > 0 -> --rightSortedBorder
            counter == 0 && sign < 0 ->  ++leftSortedBorder
        }

        sign *= -1
    }

    return this
}