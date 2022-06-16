package numbers.pow

import kotlin.math.abs

fun powLog(n: Double, pow: Int) : Double {
    val absPow = abs(pow)
    if (absPow == 0) return 1.0
    if (absPow == 1) return n

    var buff = n

    var currentPow = 2

    while (currentPow <= absPow){
        buff *= buff
        currentPow *= 2
    }

    val res = buff * powLog(n, absPow - currentPow / 2)

    return if (pow < 0) 1 / res else res
}