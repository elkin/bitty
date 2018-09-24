package io.github.elkin.bitty;

import org.testng.annotations.Test;

import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.integers;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class IntegerUtilTest {
    @Test
    public void setBit()
    {
        qt().forAll(integers().all())
            .checkAssert(
                value -> {
                    for (int bit = 1, i = 0; bit != 0; bit <<= 1, ++i) {
                        assertEquals(IntegerUtil.setBit(value, i), value | bit);
                    }
                });
    }

    @Test
    public void clearBit()
    {
        qt().forAll(integers().all())
            .checkAssert(
                value -> {
                    for (int bit = 1, i = 0; bit != 0; bit <<= 1, ++i) {
                        assertEquals(IntegerUtil.clearBit(value, i), value & (~bit));
                    }
                });
    }

    @Test
    public void clearHighBytes()
    {
        qt().forAll(integers().all())
            .checkAssert(
                value -> {
                    for (int numBytes = 0; numBytes < Integer.BYTES; ++numBytes) {
                        int result = IntegerUtil.clearHighBytes(value, numBytes);
                        switch (numBytes) {
                            case 0:
                                assertEquals(result, 0);
                                break;
                            case 1:
                                assertEquals(result, value & 0xFF);
                                break;

                            case 2:
                                assertEquals(result, value & 0xFFFF);
                                break;

                            case 3:
                                assertEquals(result, value & 0xFFFFFF);
                                break;

                            case 4:
                                assertEquals(result, (int) value);
                                break;
                            default:
                                fail();
                                break;
                        }

                    }
                });
    }

    @Test
    public void isBitSet()
    {
        qt().forAll(integers().all())
            .checkAssert(
                value -> {
                    for (int bit = 1, i = 0; bit != 0; bit <<= 1, ++i) {
                        assertEquals(IntegerUtil.isBitSet(value, i), (value & bit) != 0);
                    }
                });
    }

    @Test
    public void getBit()
    {
        qt().forAll(integers().all())
            .checkAssert(
                value -> {
                    for (int bit = 1, i = 0; bit != 0; bit <<= 1, ++i) {
                        assertEquals(IntegerUtil.getBit(value, i), (value & bit) >>> i);
                    }
                });
    }

    @Test
    public void getBitsSlice()
    {
        qt().forAll(integers().all())
            .checkAssert(
                value -> {
                    for (int length = 1, mask = 1;
                         length <= Integer.SIZE;
                         ++length, mask = (mask << 1) | 1) {
                        for (int start = 0; start < Integer.SIZE; ++start) {
                            assertEquals(IntegerUtil.getBitsSlice(value,
                                                                  start,
                                                                  start + length - 1),
                                         (value >>> start) & mask);
                        }
                    }
                });
    }

    @Test
    public void getByte()
    {
        qt().forAll(integers().all())
            .checkAssert(
                value -> {
                    for (int byteIndex = 0; byteIndex < Integer.BYTES; ++byteIndex) {
                        byte result = IntegerUtil.getByte(value, byteIndex);
                        switch (byteIndex) {
                            case 0:
                                assertEquals(result, (byte) (value & 0xFF));
                                break;

                            case 1:
                                assertEquals(result, (byte) ((value & 0xFF00) >>> 8));
                                break;

                            case 2:
                                assertEquals(result, (byte) ((value & 0xFF0000) >>> 16));
                                break;

                            case 3:
                                assertEquals(result, (byte) ((value & 0xFF000000) >>> 24));
                                break;

                            default:
                                fail();
                                break;
                        }
                    }
                }
                        );
    }

    @Test
    public void numberOfBytes()
    {
        for (int bit = 1, i = 0; bit != 0; bit <<= 1, ++i) {
            assertEquals(IntegerUtil.numberOfBytes(bit), (i / Byte.SIZE) + 1);
        }
    }
}
