package numbers.integration

fun integrationByLeftRectangle(
    function: (x: Float) -> Float,
    xMin: Float,
    xMax: Float,
    numIntervals: Int
) : Float{
    val dx = (xMax - xMin) / numIntervals

    var totalArea = 0f

    var x = xMin
    for (i in 1..numIntervals){
        totalArea += dx * function(x)
        x += dx
    }

    return totalArea
}