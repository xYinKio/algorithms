package sorting

fun main(){
    val elementsCount = 10
    val data = Array<Int?>(elementsCount){0}
    for (i in 0 until elementsCount){
        data[i] = (Math.random() * elementsCount).toInt()
    }
    data[9] = null

    println(data.joinToString())
    println(data.sumOf { it ?: 0 })

    data.sortByInsertion { (it?:-1 )}

    println(data.joinToString())
    println(data.sumOf { it ?: 0 })
}


fun <T, R : Comparable<R>>Array<T>.sortByInsertion(
    selector: (current: T) -> R?
) : Array<T>{

    val data = this

    for ((currentIndex, currentItem) in data.withIndex()){

        for (i in 1 .. currentIndex){
            val prevIndex = currentIndex - i
            val prevItem = data[prevIndex]


            val prev = selector(prevItem)
            val current = selector(currentItem)

            when{
                prev == null -> break
                current != null -> if (prev < current) break
            }




            //Меняем местами элементы
            data[prevIndex] = currentItem
            data[prevIndex + 1] = prevItem
        }
    }

    return this
}