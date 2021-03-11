package recursive

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class MemoRecursiveKtTest {

    @Test
    fun fiboMemoization() {
        Assertions.assertEquals(55, fiboMemoization(10))
    }

    @Test
    fun factorialMemoization() {
        Assertions.assertEquals(2, factorialMemoization(2))
    }
}