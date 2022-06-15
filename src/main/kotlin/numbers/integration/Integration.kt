package numbers.integration

fun main (){
    val function: (Float) -> Float = { it * it }
    val xMin = 0f
    val xMax = 100f
    val numIntervals = 20

    val res = integrationByLeftRectangle(
        function = function,
        xMin = xMin,
        xMax = xMax,
        numIntervals = numIntervals
    )

    println(res)

    val res1 = integrationByTrapezoid(
        function = function,
        xMin = xMin,
        xMax = xMax,
        numIntervals = numIntervals
    )

    println(res1)

    val res2 = integrationByAdaptiveMidpoint(
        function = function,
        xMin = xMin,
        xMax = xMax,
        numIntervals = numIntervals,
        maxSliceError = 10f
    )
    println(res2)
}