package numbers.checkSimpleNumber

fun main(){
    var isSimple = 0
    var isNotSimple = 0

    val repeats = 100
    repeat(repeats){
        if (isSimpleByFerm(99991, 300000)) ++isSimple else ++isNotSimple
    }
    println("${isSimple.toFloat() / repeats.toFloat()}")
}