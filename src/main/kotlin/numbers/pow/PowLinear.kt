package numbers.pow

import kotlin.math.abs

fun powLinear(n: Double, pow: Int) : Double {
    val absPow = abs(pow)
    var res = 1.0
    repeat(absPow){
        res *= n
    }
    return if (pow < 0) 1 / res else res
}