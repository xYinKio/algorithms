package numbers.findSimpleNumber

import kotlin.system.measureTimeMillis


fun main(){

    val n = 100000

    val time = measureTimeMillis {  simpleNumbersBy24(n).forEach { print("$it ") } }
    println()
    println(time)


    val time1 = measureTimeMillis {  simpleNumbersByEratosthenes(n).forEach { print("$it ") } }
    println()
    println(time1)



}



