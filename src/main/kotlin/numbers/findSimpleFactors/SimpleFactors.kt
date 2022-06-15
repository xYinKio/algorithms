package numbers.findSimpleFactors

import kotlin.system.measureTimeMillis

fun main(){
    val number = 5892681651684L

    val time = measureTimeMillis { simpleFactorsByLinear(number).forEach { print("$it ") } }
    println()
    println(time)

    val time1 = measureTimeMillis { simpleFactorsBySqrt(number).forEach { print("$it ") } }
    println()
    println(time1)

}