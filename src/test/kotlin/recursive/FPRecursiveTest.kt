package recursive

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class FPRecursiveTest {

    @Test
    fun fibo() {
        Assertions.assertEquals(55, fibo(10))
    }

    @Test
    fun power() {
        Assertions.assertEquals(
            4.0,
            power(2.0, 2)
        )
    }

    @Test
    fun factorial() {
        Assertions.assertEquals(2, factorial(2))
    }

    @Test
    fun maximum() {
        Assertions.assertEquals(1, maximum(listOf(1, -1, -1, -2, -3)))
    }

    @Test
    fun reverse() {
        Assertions.assertEquals("olleH", reverse("Hello"))

    }

    @Test
    fun toBinary() {
        Assertions.assertEquals("10", toBinary(2))
    }

    @Test
    fun replicate() {
        Assertions.assertEquals(listOf(2, 2), replicate(2, 2))
    }

    @Test
    fun take() {
        Assertions.assertEquals(listOf(1, 2), take(2, listOf(1, 2, 3)))
    }

    @Test
    fun elem() {
        Assertions.assertEquals(true, elem(1, listOf(1, 2, 3, 4, 5, 6)))
        Assertions.assertEquals(false, elem(10, listOf(1, 2, 3, 4, 5, 6)))
    }

    @Test
    fun takeSequence() {
        Assertions.assertEquals(listOf(3, 3), takeSequence(2, repeat(3)))
    }

    @Test
    fun zip() {
        Assertions.assertEquals(listOf(1, 3) zip listOf(2, 4), zip(listOf(1, 3, 5), listOf(2, 4)))
    }

    @Test
    fun quicksort() {
        Assertions.assertEquals(listOf(1, 2, 3, 4, 5), quicksort(listOf(5, 4, 3, 1, 2)))
    }

    @Test
    fun gcd() {
        Assertions.assertEquals(3, gcd(15, 3))
    }

}