package numbers.findSimpleNumber

import kotlin.math.pow

/**
 * Скорость выполнения O(N * [C / N]?)
 * Потребление памяти O([C / N]?)
 * */

fun simpleNumbersBy24(n: Int) : List<Int>{
    val simpleNumbers = mutableListOf<Int>()
    if (n <= 3){
        for (i in 2..n){ simpleNumbers.add(i) }
    } else {
        for (i in 2..3){ simpleNumbers.add(i) }
    }

    for (i in 5..n){
        val powed = i.toDouble().pow(2.0) - 1
        if (powed % 24 == 0.0){
            var isSimple = false
            if (simpleNumbers.isEmpty()) isSimple = true

            for ((index, it) in simpleNumbers.withIndex()){
                if (i % it == 0){
                    break
                }
                if (simpleNumbers.size-1 == index && i % it != 0) isSimple = true
            }

            if (isSimple){
                simpleNumbers.add(i)
            }
        }
    }

    return simpleNumbers
}