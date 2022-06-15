package numbers.integration

fun integrationByTrapezoid(
    function: (x: Float) -> Float,
    xMin: Float,
    xMax: Float,
    numIntervals: Int
) : Float{
    val dx = (xMax - xMin) / numIntervals

    var totalArea = 0f

    var x = xMin
    for (i in 1..numIntervals){
        totalArea += dx * (function(x) + function(x + dx)) / 2
        x += dx
    }

    return totalArea

}