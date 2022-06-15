package numbers.checkSimpleNumber

import kotlin.math.pow

fun isSimpleByFerm(p: Int, maxTests: Int) : Boolean{
    repeat(maxTests){
        val a = (1 until p).random()
        if(a.toDouble().pow(p - 1) % p == 1.0) return true
    }
    return false
}