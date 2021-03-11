package recursive

tailrec fun fiboTail(n: Int, first: Int = 0, second: Int = 1): Int = when (n) {
    0 -> first
    1 -> second
    else -> fiboTail(n - 1, second, first + second)
}

tailrec fun factorialTail(n: Int, acc: Int = 1): Int = when (n) {
    0 -> acc
    else -> factorialTail(n - 1, n * acc)
}

tailrec fun powerTail(x: Double, n: Int, acc: Double = 1.0): Double = when (n) {
    0 -> acc
    else -> powerTail(x, n - 1, x * acc)
}

tailrec fun zipTail(list1: List<Int>, list2: List<Int>, acc: List<Pair<Int, Int>> = listOf())
        : List<Pair<Int, Int>> = when {
    list1.isEmpty() || list2.isEmpty() -> acc
    else -> {
        val zipList = acc + listOf(Pair(list1.first(), list2.first()))
        zipTail(list1.drop(1), list2.drop(1), zipList)
    }
}

tailrec fun elemTail(n: Int, list: List<Int>): Boolean = when {
    list.isEmpty() -> false
    n == list.first() -> true
    else -> elemTail(n, list.drop(1))
}

tailrec fun takeTail(n: Int, list: List<Int>, acc: List<Int> = listOf()): List<Int> = when {
    n <= 0 -> acc
    list.isEmpty() -> acc
    else -> {
        val takeList = acc + listOf(list.first())
        takeTail(n - 1, list.drop(1), takeList)
    }
}

tailrec fun replicateTail(n: Int, element: Int, acc: List<Int> = listOf()): List<Int> = when {
    n <= 0 -> acc
    else -> {
        val repeatList = acc + listOf(element)
        replicateTail(n - 1, element, repeatList)
    }
}

tailrec fun toBinaryTail(n: Int, acc: String = ""): String = when {
    2 > n -> n.toString() + acc
    else -> {
        val binary = (n % 2).toString() + acc
        toBinaryTail(n / 2, binary)
    }
}

tailrec fun reverseTail(str: String, acc: String = ""): String = when {
    str.isEmpty() -> acc
    else -> {
        val reversed = str.first() + acc
        reverseTail(str.drop(1), reversed)
    }
}

tailrec fun maximumTail(items: List<Int>, acc: Int = Int.MIN_VALUE): Int = when {
    items.isEmpty() -> error("empty list")
    items.size == 1 -> acc
    else -> {
        val head = items.first()
        val maxValue = if (head > acc) head else acc
        maximumTail(items.drop(1), maxValue)
    }
}
