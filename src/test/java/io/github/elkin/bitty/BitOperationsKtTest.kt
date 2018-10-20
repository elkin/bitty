package io.github.elkin.bitty

import org.testng.Assert.assertEquals
import org.testng.annotations.Test

class BitOperationsKtTest {

    @Test
    fun testGetBitsSlice() {
        assertEquals(0xDA, 0xDADA.getBitsSlice(0, 7))
    }
}