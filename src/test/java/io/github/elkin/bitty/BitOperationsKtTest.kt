package io.github.elkin.bitty

import org.quicktheories.QuickTheory.qt
import org.quicktheories.generators.SourceDSL
import org.testng.Assert.assertEquals
import org.testng.annotations.Test

class BitOperationsKtTest {
    @Test
    fun `get Int bits slice`() {
        qt().forAll(SourceDSL.integers().all())
            .checkAssert { number ->
                for (start in 0 until Integer.SIZE - 1) {
                    for (end in start + 1 until Integer.SIZE) {
                        val expectedResult = IntegerUtil.getBitsSlice(number, start, end)

                        assertEquals(number.getBitsSlice(start, end), expectedResult)
                        assertEquals(number.getBitsSliceSafe(start, end), expectedResult)
                        assertEquals(number[start, end], expectedResult)
                    }
                }
            }
    }

    @Test
    fun `get Long bits Slice`() {
        qt().forAll(SourceDSL.longs().all())
            .checkAssert { number ->
                for (start in 0 until java.lang.Long.SIZE - 1) {
                    for (end in start + 1 until java.lang.Long.SIZE) {
                        val expectedResult = LongUtil.getBitsSlice(number, start, end)

                        assertEquals(number.getBitsSlice(start, end), expectedResult)
                        assertEquals(number.getBitsSliceSafe(start, end), expectedResult)
                        assertEquals(number[start, end], expectedResult)
                    }
                }
            }
    }

    @Test
    fun `get Short bits slice`() {
        qt().forAll(SourceDSL.integers().between(java.lang.Short.MIN_VALUE.toInt(), java.lang.Short.MAX_VALUE.toInt()))
            .checkAssert { number ->
                for (start in 0 until java.lang.Short.SIZE - 1) {
                    for (end in start + 1 until java.lang.Short.SIZE) {
                        val num = number.toShort()
                        val expectedResult = ShortUtil.getBitsSlice(num, start, end)

                        assertEquals(num.getBitsSlice(start, end), expectedResult)
                        assertEquals(num.getBitsSliceSafe(start, end), expectedResult)
                        assertEquals(num[start, end], expectedResult)
                    }
                }
            }
    }

    @Test
    fun `set Int bits Slice`() {
        qt().forAll(SourceDSL.integers().all())
            .checkAssert { number ->
                for (start in 0 until Integer.SIZE - 1) {
                    for (end in start + 1 until Integer.SIZE) {
                        assertEquals(
                            number.setBitsSlice(start, end),
                            IntegerUtil.setBitsSlice(number, start, end))

                        assertEquals(
                            number.setBitsSliceSafe(start, end),
                            IntegerUtil.setBitsSlice(number, start, end))
                    }
                }
            }
    }

    @Test
    fun `set Long bits slice`() {
        qt().forAll(SourceDSL.longs().all())
            .checkAssert { number ->
                for (start in 0 until java.lang.Long.SIZE - 1) {
                    for (end in start + 1 until java.lang.Long.SIZE) {
                        assertEquals(
                            number.setBitsSlice(start, end),
                            LongUtil.setBitsSlice(number, start, end))

                        assertEquals(
                            number.setBitsSliceSafe(start, end),
                            LongUtil.setBitsSlice(number, start, end))
                    }
                }
            }
    }

    @Test
    fun `set Short bits slice`() {
        qt().forAll(SourceDSL.integers().between(java.lang.Short.MIN_VALUE.toInt(),
                                                 java.lang.Short.MAX_VALUE.toInt()))
            .checkAssert { number ->
                for (start in 0 until java.lang.Short.SIZE - 1) {
                    for (end in start + 1 until java.lang.Short.SIZE) {
                        val numShort = number.toShort()
                        assertEquals(
                            numShort.setBitsSlice(start, end),
                            ShortUtil.setBitsSlice(numShort, start, end))

                        assertEquals(
                            numShort.setBitsSliceSafe(start, end),
                            ShortUtil.setBitsSlice(numShort, start, end))
                    }
                }
            }
    }

    @Test
    fun `clear Int bits slice`() {
        qt().forAll(SourceDSL.integers().all())
            .checkAssert { number ->
                for (start in 0 until Integer.SIZE - 1) {
                    for (end in start + 1 until Integer.SIZE) {
                        assertEquals(
                            number.clearBitsSlice(start, end),
                            IntegerUtil.clearBitsSlice(number, start, end))

                        assertEquals(
                            number.clearBitsSliceSafe(start, end),
                            IntegerUtil.clearBitsSlice(number, start, end))
                    }
                }
            }
    }

    @Test
    fun `clear Long bits slice`() {
        qt().forAll(SourceDSL.longs().all())
            .checkAssert { number ->
                for (start in 0 until java.lang.Long.SIZE - 1) {
                    for (end in start + 1 until java.lang.Long.SIZE) {
                        assertEquals(
                            number.clearBitsSlice(start, end),
                            LongUtil.clearBitsSlice(number, start, end))

                        assertEquals(
                            number.clearBitsSliceSafe(start, end),
                            LongUtil.clearBitsSlice(number, start, end))
                    }
                }
            }
    }

    @Test
    fun `clear Short bits slice`() {
        qt().forAll(SourceDSL.integers().between(java.lang.Short.MIN_VALUE.toInt(), java.lang.Short.MAX_VALUE.toInt()))
            .checkAssert { number ->
                for (start in 0 until java.lang.Short.SIZE - 1) {
                    for (end in start + 1 until java.lang.Short.SIZE) {
                        val numShort = number.toShort()
                        assertEquals(
                            numShort.clearBitsSlice(start, end),
                            ShortUtil.clearBitsSlice(numShort, start, end))

                        assertEquals(
                            numShort.clearBitsSliceSafe(start, end),
                            ShortUtil.clearBitsSlice(numShort, start, end))
                    }
                }
            }
    }

    @Test
    fun `get bit in Int`() {
        qt().forAll(SourceDSL.integers().all())
            .checkAssert { number ->
                for (i in 0 until Integer.SIZE) {
                    assertEquals(number.getBit(i), IntegerUtil.getBit(number, i))
                    assertEquals(number.getBitSafe(i), IntegerUtil.getBit(number, i))
                    assertEquals(number[i], IntegerUtil.getBit(number, i))
                }
            }
    }

    @Test
    fun `get bit in Long`() {
        qt().forAll(SourceDSL.longs().all())
            .checkAssert { number ->
                for (i in 0 until java.lang.Long.SIZE) {
                    assertEquals(number.getBit(i), LongUtil.getBit(number, i))
                    assertEquals(number.getBitSafe(i), LongUtil.getBit(number, i))
                    assertEquals(number[i], LongUtil.getBit(number, i))
                }
            }
    }

    @Test
    fun `get bit in Short`() {
        qt().forAll(SourceDSL.integers().between(java.lang.Short.MIN_VALUE.toInt(), java.lang.Short.MAX_VALUE.toInt()))
            .checkAssert { number ->
                for (i in 0 until java.lang.Short.SIZE) {
                    val numShort = number.toShort()
                    assertEquals(numShort.getBit(i), ShortUtil.getBit(numShort, i))
                    assertEquals(numShort.getBitSafe(i), ShortUtil.getBit(numShort, i))
                    assertEquals(numShort[i], ShortUtil.getBit(numShort, i))
                }
            }
    }

    @Test
    fun `is bit set in Int`() {
        qt().forAll(SourceDSL.integers().all())
            .checkAssert { number ->
                for (i in 0 until Integer.SIZE) {
                    assertEquals(number.isBitSet(i), IntegerUtil.isBitSet(number, i))
                    assertEquals(number.isBitSetSafe(i), IntegerUtil.isBitSet(number, i))
                }
            }
    }

    @Test
    fun `is bit set in Long`() {
        qt().forAll(SourceDSL.longs().all())
            .checkAssert { number ->
                for (i in 0 until java.lang.Long.SIZE) {
                    assertEquals(number.isBitSet(i), LongUtil.isBitSet(number, i))
                    assertEquals(number.isBitSetSafe(i), LongUtil.isBitSet(number, i))
                }
            }
    }

    @Test
    fun `is bit set in Short`() {
        qt().forAll(SourceDSL.integers().between(java.lang.Short.MIN_VALUE.toInt(), java.lang.Short.MAX_VALUE.toInt()))
            .checkAssert { number ->
                for (i in 0 until java.lang.Short.SIZE) {
                    val numShort = number.toShort()
                    assertEquals(
                        numShort.isBitSet(i),
                        ShortUtil.isBitSet(numShort, i))

                    assertEquals(
                        numShort.isBitSetSafe(i),
                        ShortUtil.isBitSet(numShort, i))
                }
            }
    }

    @Test
    fun `set bit in Int`() {
        qt().forAll(SourceDSL.integers().all())
            .checkAssert { number ->
                for (i in 0 until Integer.SIZE) {
                    assertEquals(number.setBit(i), IntegerUtil.setBit(number, i))
                    assertEquals(number.setBitSafe(i), IntegerUtil.setBit(number, i))
                }
            }
    }

    @Test
    fun `set bit in Long`() {
        qt().forAll(SourceDSL.longs().all())
            .checkAssert { number ->
                for (i in 0 until java.lang.Long.SIZE) {
                    assertEquals(number.setBit(i), LongUtil.setBit(number, i))
                    assertEquals(number.setBitSafe(i), LongUtil.setBit(number, i))
                }
            }
    }

    @Test
    fun `set bit in Short`() {
        qt().forAll(SourceDSL.integers().between(java.lang.Short.MIN_VALUE.toInt(), java.lang.Short.MAX_VALUE.toInt()))
            .checkAssert { number ->
                for (i in 0 until java.lang.Short.SIZE) {
                    val numShort = number.toShort()
                    assertEquals(
                        numShort.setBit(i),
                        ShortUtil.setBit(numShort, i))

                    assertEquals(
                        numShort.setBitSafe(i),
                        ShortUtil.setBit(numShort, i))
                }
            }
    }

    @Test
    fun `clear bit in Int`() {
        qt().forAll(SourceDSL.integers().all())
            .checkAssert { number ->
                for (i in 0 until Integer.SIZE) {
                    assertEquals(number.clearBit(i), IntegerUtil.clearBit(number, i))
                    assertEquals(number.clearBitSafe(i), IntegerUtil.clearBit(number, i))
                }
            }
    }

    @Test
    fun `clear bit in Long`() {
        qt().forAll(SourceDSL.longs().all())
            .checkAssert { number ->
                for (i in 0 until java.lang.Long.SIZE) {
                    assertEquals(number.clearBit(i), LongUtil.clearBit(number, i))
                    assertEquals(number.clearBitSafe(i), LongUtil.clearBit(number, i))
                }
            }
    }

    @Test
    fun `clear bit in Short`() {
        qt().forAll(SourceDSL.integers().between(java.lang.Short.MIN_VALUE.toInt(), java.lang.Short.MAX_VALUE.toInt()))
            .checkAssert { number ->
                for (i in 0 until java.lang.Short.SIZE) {
                    val numShort = number.toShort()
                    assertEquals(
                        numShort.clearBit(i),
                        ShortUtil.clearBit(numShort, i))

                    assertEquals(
                        numShort.clearBitSafe(i),
                        ShortUtil.clearBit(numShort, i))
                }
            }
    }

    @Test
    fun `clear high bytes in Int`() {
        qt().forAll(SourceDSL.integers().all())
            .checkAssert { number ->
                for (i in 0..Integer.BYTES) {
                    assertEquals(number.clearHighBytes(i), IntegerUtil.clearHighBytes(number, i))
                    assertEquals(number.clearHighBytesSafe(i),
                                 IntegerUtil.clearHighBytes(number, i))
                }
            }
    }

    @Test
    fun `clear high bytes in Long`() {
        qt().forAll(SourceDSL.longs().all())
            .checkAssert { number ->
                for (i in 0..java.lang.Long.BYTES) {
                    assertEquals(number.clearHighBytes(i), LongUtil.clearHighBytes(number, i))
                    assertEquals(number.clearHighBytesSafe(i), LongUtil.clearHighBytes(number, i))
                }
            }
    }

    @Test
    fun `clear high bytes in Short`() {
        qt().forAll(SourceDSL.integers().between(java.lang.Short.MIN_VALUE.toInt(),
                                                 java.lang.Short.MAX_VALUE.toInt()))
            .checkAssert { number ->
                for (i in 0..java.lang.Short.BYTES) {
                    val numShort = number.toShort()
                    assertEquals(
                        numShort.clearHighBytes(i),
                        ShortUtil.clearHighBytes(numShort, i))

                    assertEquals(
                        numShort.clearHighBytesSafe(i),
                        ShortUtil.clearHighBytes(numShort, i))
                }
            }
    }

    @Test
    fun `number of bytes in Int`() {
        qt().forAll(SourceDSL.integers().all())
            .checkAssert { number ->
                assertEquals(
                    number.numberOfBytes(),
                    IntegerUtil.numberOfBytes(number))
            }
    }

    @Test
    fun `number of bytes in Long`() {
        qt().forAll(SourceDSL.longs().all())
            .checkAssert { number ->
                assertEquals(
                    number.numberOfBytes(),
                    LongUtil.numberOfBytes(number))
            }
    }

    @Test
    fun `number of bytes in Short`() {
        qt().forAll(SourceDSL.integers().between(java.lang.Short.MIN_VALUE.toInt(), java.lang.Short.MAX_VALUE.toInt()))
            .checkAssert { number ->
                val numShort = number.toShort()
                assertEquals(
                    numShort.numberOfBytes(),
                    ShortUtil.numberOfBytes(numShort))
            }
    }

    @Test
    fun `get byte in Int`() {
        qt().forAll(SourceDSL.integers().all())
            .checkAssert { number ->
                for (i in 0 until Integer.BYTES) {
                    assertEquals(number.getByte(i), IntegerUtil.getByte(number, i))
                    assertEquals(number.getByteSafe(i), IntegerUtil.getByte(number, i))
                }
            }
    }

    @Test
    fun `get byte in Long`() {
        qt().forAll(SourceDSL.longs().all())
            .checkAssert { number ->
                for (i in 0 until java.lang.Long.BYTES) {
                    assertEquals(number.getByte(i), LongUtil.getByte(number, i))
                    assertEquals(number.getByteSafe(i), LongUtil.getByte(number, i))
                }
            }
    }

    @Test
    fun `get byte in Short`() {
        qt().forAll(SourceDSL.integers().between(java.lang.Short.MIN_VALUE.toInt(), java.lang.Short.MAX_VALUE.toInt()))
            .checkAssert { number ->
                val numShort = number.toShort()
                for (i in 0 until java.lang.Short.BYTES) {
                    assertEquals(
                        numShort.getByte(i),
                        ShortUtil.getByte(numShort, i))

                    assertEquals(
                        numShort.getByteSafe(i),
                        ShortUtil.getByte(numShort, i))
                }
            }
    }
}