package sorting

fun main(){
    val data = Array<Int?>(10){ 0 }
    for (i in 0 until 10){
        data[i] = (Math.random() * 10).toInt()
    }
    data[6] = null

    println(data.joinToString())
    println(data.sumOf { it?: 0 })

    data.sortBySelection{ (it?:-1 )}

    println(data.joinToString())
    println(data.sumOf { it?:0 })
}

fun <T, R : Comparable<R>> Array<T>.sortBySelection(
    selector: (T) -> R?
) : Array<T>{

    val data = this

    for ((currentIndex ,i) in data.withIndex()){
        var min = i
        var maxIndex = currentIndex

        //ищем максимальный элемент и его индекс
        for (index in currentIndex until size){
            val currentComparable = selector(data[index])
            val minComparable = selector(min)



            if ( //Стоит ли обновить min?
                when {
                    currentComparable == null -> true
                    minComparable == null -> false
                    else -> currentComparable < minComparable
                }
            ) {
                min = data[index]
                maxIndex = index
            }
        }

        //меняем местами текущий и максимальный элемент
        data[maxIndex] = i
        data[currentIndex] = min
    }

    return this
}