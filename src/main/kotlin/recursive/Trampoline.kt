package recursive

import java.math.BigDecimal
import kotlin.math.sqrt

sealed class Bounce<A>
data class Done<A>(val result: A) : Bounce<A>()
data class More<A>(val thunk: () -> Bounce<A>) : Bounce<A>()

tailrec fun <A> trampoline(bounce: Bounce<A>): A = when (bounce) {
    is Done -> bounce.result
    is More -> trampoline(bounce.thunk())
}

//fun odd(n: Int): Boolean = when (n) {
//    0 -> false
//    else -> even(n - 1)
//}
fun odd(n: Int): Bounce<Boolean> = when (n) {
    0 -> Done(false)
    else -> More { even(n - 1) }
}

//fun even(n: Int): Boolean = when (n) {
//    0 -> true
//    else -> odd(n - 1)
//}
fun even(n: Int): Bounce<Boolean> = when (n) {
    0 -> Done(true)
    else -> More { odd(n - 1) }
}


//fun squareRoot(n: Double): Double = when {
//    n < 1 -> n
//    else -> divideTwo(sqrt(n))
//}


private fun squareRoot(n: Double): Bounce<Double> = when {
    n < 1 -> Done(n)
    else -> More { divideTwo(Math.sqrt(n)) }
}

//fun divideTwo(n: Double): Double = when {
//    n < 1 -> n
//    else -> squareRoot(n / 2)
//}

private fun divideTwo(n: Double): Bounce<Double> = when {
    n < 1 -> Done(n)
    else -> More { squareRoot(n / 2) }
}

fun factorialTrampoline(n: BigDecimal, acc: BigDecimal = BigDecimal(1)): Bounce<BigDecimal> = when (n) {
    BigDecimal(0) -> Done(acc)
    else -> More { factorialTrampoline(n.dec(), n * acc) }
}