package recursive

private var fiboMemoArray = Array(100) { -1 }
private var factorialMemoArray = Array(100) { -1 }

fun fiboMemoization(n: Int): Int = when {
    n == 0 -> 0
    n == 1 -> 1
    fiboMemoArray[n] != -1 -> fiboMemoArray[n]
    else -> {
        fiboMemoArray[n] = fiboMemoization(n - 2) + fiboMemoization(n - 1)
        fiboMemoArray[n]
    }
}

fun factorialMemoization(n: Int): Int = when {
    n == 0 -> 1
    factorialMemoArray[n] != -1 -> factorialMemoArray[n]
    else -> {
        factorialMemoArray[n] = n * factorialMemoization(n - 1)
        factorialMemoArray[n]
    }
}
