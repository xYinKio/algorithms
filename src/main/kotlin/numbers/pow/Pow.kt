package numbers.pow

import kotlin.math.pow
import kotlin.system.measureTimeMillis

const val DELAY = 1L

fun main(){
    val pow = -1023

    val time = measureTimeMillis {
        val a = powLinear(2.0, pow)
        println(a)
    }
    println("time: $time")

    val time1 = measureTimeMillis {
        val a = powLog(2.0, pow)
        println(a)
    }
    println("time: $time1")

    val time2 = measureTimeMillis {
        val a = 2.0.pow(pow.toDouble())
        println(a)
    }
    println("time: $time2")

}