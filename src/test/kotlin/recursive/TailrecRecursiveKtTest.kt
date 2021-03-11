package recursive

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


internal class TailrecRecursiveKtTest {

    @Test
    fun fiboTail() {
        Assertions.assertEquals(55, fiboTail(10))
    }

    @Test
    fun zipTail() {
        Assertions.assertEquals(listOf(1, 3) zip listOf(2, 4), zipTail(listOf(1, 3, 5), listOf(2, 4)))
    }

    @Test
    fun reverseTail() {
        Assertions.assertEquals("olleH", reverseTail("Hello"))
    }

    @Test
    fun toBinaryTail() {
        Assertions.assertEquals("10", toBinaryTail(2))
    }

    @Test
    fun replicateTail() {
        Assertions.assertEquals(listOf(2, 2), replicateTail(2, 2))
    }

    @Test
    fun takeTail() {
        Assertions.assertEquals(listOf(1, 2), takeTail(2, listOf(1, 2, 3)))
    }

    @Test
    fun elemTail() {
        Assertions.assertEquals(true, elemTail(1, listOf(1, 2, 3, 4, 5, 6)))
        Assertions.assertEquals(false, elemTail(10, listOf(1, 2, 3, 4, 5, 6)))
    }

    @Test
    fun maximumTail() {
        Assertions.assertEquals(1, maximumTail(listOf(1, -1, -1, -2, -3)))
    }

    @Test
    fun factorialTail() {
        Assertions.assertEquals(2, factorialTail(2))
    }

    @Test
    fun powerTail() {
        Assertions.assertEquals(
            4.0,
            powerTail(2.0, 2)
        )
    }
}