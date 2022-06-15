package numbers.findSimpleNumber

import kotlin.math.sqrt

fun simpleNumbersByEratosthenes(n: Int) : List<Int>{
    val isComposite = BooleanArray(n + 1)

    for (i in 4..n step 2){
        isComposite[i] = true
    }

    var nextPrime = 3
    val stopAt = sqrt(n.toDouble())

    while (nextPrime <= stopAt){
        for (i in nextPrime * 2..n step nextPrime){
            isComposite[i] = true
        }
        nextPrime += 2
        while (nextPrime <= n && isComposite[nextPrime]){
            nextPrime += 2
        }
    }
    val primes = mutableListOf<Int>()

    for (i in 2..n){
        if (!isComposite[i]) primes.add(i)
    }

    return primes
}