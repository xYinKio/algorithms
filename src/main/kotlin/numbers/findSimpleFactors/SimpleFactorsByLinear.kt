package numbers.findSimpleFactors

fun simpleFactorsByLinear(n: Long) : List<Long>{

    val factors = mutableListOf<Long>()

    var i = 2L


    var number = n
    while (i < number){
        while (number % i == 0L){
            factors.add(i)
            number /= i
        }
        ++i
    }
    if (number > 1) factors.add(number)

    return factors
}