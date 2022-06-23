fun <T : Comparable<T>>T?.compareToWithNull(other: T?): Int {
    return when{
        this == null && other == null -> 0
        this == null && other != null -> -1
        this != null && other == null -> 1
        else -> this!!.compareTo(other!!)
    }
}