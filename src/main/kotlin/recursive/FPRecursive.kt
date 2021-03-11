package recursive

fun fibo(n: Int): Int = when (n) {
    0 -> 0
    1 -> 1
    else -> fibo(n-1)+fibo(n-2)
}

fun power(x: Double, n: Int): Double = when (n) {
    0 -> 1.0
    else -> x * power(x, n - 1)
}

fun factorial(n: Int): Int = when (n) {
    0 -> 1
    else -> n * factorial(n - 1)
}

fun maximum(items: List<Int>): Int = when {
    items.isEmpty() -> error("Empty List")
    1 == items.size -> items[0]
    else -> {
        val head = items.first()
        val tail = items.drop(1)
        val maxVal = maximum(tail)
        if (head > maxVal) head else maxVal
    }
}

fun reverse(str: String): String = when {
    str.isBlank() -> ""
    else -> reverse(str.drop(1)) + str.first()
}

fun toBinary(n: Int): String = when {
    n < 2 -> n.toString()
    else -> toBinary(n / 2) + (n % 2).toString()
}

fun replicate(n: Int, element: Int): List<Int> = when {
    n <= 0 -> listOf()
    else -> listOf(element) + replicate(n - 1, element)
}

fun take(n: Int, list: List<Int>): List<Int> = when {
    n <= 0 -> listOf()
    list.isEmpty() -> listOf()
    else -> listOf(list.first()) + take(n - 1, list.drop(1))
}

fun elem(num: Int, list: List<Int>): Boolean = when {
    list.isEmpty() -> false
    list.first() == num -> true
    else -> elem(num, list.drop(1))
}

fun takeSequence(n: Int, sequence: Sequence<Int>): List<Int> = when {
    n <= 0 -> listOf()
    sequence.none() -> listOf()
    else -> listOf(sequence.first()) + takeSequence(n - 1, sequence.drop(1))
}

operator fun <T> Sequence<T>.plus(other: () -> Sequence<T>) = object : Sequence<T> {
    private val thisIterator: Iterator<T> by lazy { this@plus.iterator() }
    private val otherIterator: Iterator<T> by lazy { other().iterator() }
    override fun iterator() = object : Iterator<T> {
        override fun next(): T =
            if (thisIterator.hasNext())
                thisIterator.next()
            else
                otherIterator.next()

        override fun hasNext(): Boolean = thisIterator.hasNext() || otherIterator.hasNext()
    }
}

fun repeat(n: Int): Sequence<Int> = sequenceOf(n) + { repeat(n) }

fun zip(list1: List<Int>, list2: List<Int>): List<Pair<Int, Int>> = when {
    list1.isEmpty() || list2.isEmpty() -> listOf()
    else -> listOf(Pair(list1.first(), list2.first())) + zip(list1.drop(1), list2.drop(1))
}

fun quicksort(list: List<Int>): List<Int> = when {
    list.isEmpty() -> list
    else -> {
        val pivot = list.first()
        val (small, bigger) = list.drop(1).partition { it < pivot }
        quicksort(small) + listOf(pivot) + quicksort(bigger)
    }
}

fun gcd(m: Int, n: Int): Int = when (n) {
    0 -> m
    else -> gcd(n, m % n)
}


