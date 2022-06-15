package numbers.integration

import kotlin.math.abs

fun integrationByAdaptiveMidpoint(
    function: (x: Float) -> Float,
    xMin: Float,
    xMax: Float,
    numIntervals: Int,
    maxSliceError: Float
) : Float{
    val dx = (xMax - xMin) / numIntervals

    var totalArea = 0f
    var x = xMin

    for (i in 1..numIntervals){
        totalArea += sliceArea(function, x, x + dx, maxSliceError)
        x += dx
    }
    return totalArea
}

fun sliceArea(
    function: (x: Float) -> Float,
    x1: Float,
    x2: Float,
    maxSliceError: Float
) : Float {

    val y1 = function(x1)
    val y2 = function(x2)
    val xm = (x1 + x2) / 2
    val ym = function(xm)

    val area12 = (x2 - x1) * (y1 + y2) / 2
    val area1m = (xm - x1) * (y1 + ym) / 2
    val aream2 = (x2 - xm) * (ym + y2) / 2
    val area1m2 = area1m + aream2

    val error = (area1m2 - area12) / area12

    if (abs(error) < maxSliceError) return area1m2

    return sliceArea(function, x1, xm, maxSliceError) + sliceArea(function, xm, x2, maxSliceError)
}