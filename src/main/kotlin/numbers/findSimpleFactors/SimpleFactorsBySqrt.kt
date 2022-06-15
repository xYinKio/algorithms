package numbers.findSimpleFactors

import kotlin.math.sqrt

fun simpleFactorsBySqrt(n: Long) : List<Long>{
    val factors = mutableListOf<Long>()

    val number = findHonestAndGetRest(n, factors)
    findOdd(number, factors)

    return factors
}

private fun findOdd(n: Long, factors: MutableList<Long>) {
    var number = n
    var i = 3L
    var maxFactor = sqrt(number.toDouble())
    while (i < maxFactor) {
        while (number % i == 0L) {
            factors.add(i)
            number /= i
            maxFactor = sqrt(number.toDouble())
        }

        i += 2
    }
    if (number > 1) factors.add(number)
}

private fun findHonestAndGetRest(n: Long, factors: MutableList<Long>): Long {
    var muteN = n
    while (muteN % 2L == 0L) {
        factors.add(2)
        muteN /= 2
    }
    return muteN
}
