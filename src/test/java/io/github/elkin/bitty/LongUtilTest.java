package io.github.elkin.bitty;

import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.longs;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.testng.annotations.Test;

public class LongUtilTest {
  
  @Test(expectedExceptions = AssertionError.class)
  public void getBitsSliceNegativeStart()
  {
    LongUtil.getBitsSlice(0, -1, 1);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void getBitsSliceStartIndexIsGreaterOrEqualToLongSize()
  {
    LongUtil.getBitsSlice(0, Long.SIZE, Long.SIZE + 1);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void getBitsSliceNegativeStopIndex()
  {
    LongUtil.getBitsSlice(0, 1, -1);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void getBitsSliceStopIndexIsLessThanStartIndex()
  {
    LongUtil.getBitsSlice(0, 3, 2);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void getBitsSliceDifferenceBetweenStopAndStartIsGreaterThanLongSize()
  {
    LongUtil.getBitsSlice(0, 1, Long.SIZE + 2);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void getBitNegativeIndex()
  {
    LongUtil.getBit(0, -1);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void getBitIndexIsGreaterOrEqualToIntegerSize()
  {
    LongUtil.getBit(0, Long.SIZE);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void isBitSetNegativeIndex()
  {
    LongUtil.isBitSet(0, -1);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void isBitSetIndexIsGreaterOrEqualToIntegerSize()
  {
    LongUtil.isBitSet(0, Long.SIZE);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void setBitNegativeIndex()
  {
    LongUtil.setBit(0, -1);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void setBitIndexIsGreaterOrEqualToIntegerSize()
  {
    LongUtil.setBit(0, Long.SIZE);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void clearBitNegativeIndex()
  {
    LongUtil.clearBit(0, -1);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void clearBitIndexIsGreaterOrEqualToIntegerSize()
  {
    LongUtil.clearBit(0, Long.SIZE);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void clearHighBytesNumBytesIsNegative()
  {
    LongUtil.clearHighBytes(0, -1);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void clearHighBytesNumBytesIsGreaterThanIntegerBytes()
  {
    LongUtil.clearHighBytes(0, Long.BYTES + 1);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void getByteNegativeIndex()
  {
    LongUtil.getByte(0, -1);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void getByteIndexIsGreaterOrEqualToIntegerBytes()
  {
    LongUtil.getByte(0, Long.BYTES);
  }

  @Test
  public void setBit() {
    qt().forAll(longs().all())
        .checkAssert(
            number -> {
              for (long bit = 1, i = 0; bit != 0; bit <<= 1, ++i) {
                assertEquals(LongUtil.setBit(number, (int) i), number | bit);
              }
            });
  }

  @Test
  public void clearBit() {
    qt().forAll(longs().all())
        .checkAssert(
            number -> {
              for (long bit = 1, i = 0; bit != 0; bit <<= 1, ++i) {
                assertEquals(LongUtil.clearBit(number, (int) i), number & (~bit));
              }
            });
  }

  @Test
  public void clearHighBytes() {
    qt().forAll(longs().all())
        .checkAssert(
            number -> {
              for (int numBytes = 0; numBytes <= Long.BYTES; ++numBytes) {
                long result = LongUtil.clearHighBytes(number, numBytes);
                switch (numBytes) {
                  case 0:
                    assertEquals(result, 0);
                    break;
                  case 1:
                    assertEquals(result, number & 0xFFL);
                    break;

                  case 2:
                    assertEquals(result, number & 0xFFFFL);
                    break;

                  case 3:
                    assertEquals(result, number & 0xFFFFFFL);
                    break;

                  case 4:
                    assertEquals(result, number & 0xFFFFFFFFL);
                    break;

                  case 5:
                    assertEquals(result, number & 0xFFFFFFFFFFL);
                    break;
                  case 6:
                    assertEquals(result, number & 0xFFFFFFFFFFFFL);
                    break;

                  case 7:
                    assertEquals(result, number & 0xFFFFFFFFFFFFFFL);
                    break;

                  case 8:
                    assertEquals(result, (long) number);
                    break;

                  default:
                    fail();
                    break;
                }

              }
            });
  }

  @Test
  public void isBitSet() {
    qt().forAll(longs().all())
        .checkAssert(
            number -> {
              for (long bit = 1, i = 0; bit != 0; bit <<= 1, ++i) {
                assertEquals(LongUtil.isBitSet(number, (int) i), (number & bit) != 0);
              }
            });
  }

  @Test
  public void getBit() {
    qt().forAll(longs().all())
        .checkAssert(
            number -> {
              for (long bit = 1, i = 0; bit != 0; bit <<= 1, ++i) {
                assertEquals(LongUtil.getBit(number, (int) i), (number & bit) >>> i);
              }
            });
  }

  @Test
  public void getBitsSlice() {
    qt().forAll(longs().all())
        .checkAssert(
            number -> {
              for (long length = 1, mask = 1;
                  length <= Long.SIZE;
                  ++length, mask = (mask << 1) | 1) {
                for (int start = 0; start < Long.SIZE; ++start) {
                  assertEquals(LongUtil.getBitsSlice(number,
                      start,
                      (int) (start + length - 1)),
                      (number >>> start) & mask);
                }
              }
            });
  }

  @Test
  public void getByte() {
    qt().forAll(longs().all())
        .checkAssert(
            number -> {
              for (int byteIndex = 0; byteIndex < Long.BYTES; ++byteIndex) {
                byte result = LongUtil.getByte(number, byteIndex);
                switch (byteIndex) {
                  case 0:
                    assertEquals(result, (byte) (number & 0xFFL));
                    break;

                  case 1:
                    assertEquals(result, (byte) ((number & 0xFF00L) >>> 8));
                    break;

                  case 2:
                    assertEquals(result, (byte) ((number & 0xFF0000L) >>> 16));
                    break;

                  case 3:
                    assertEquals(result, (byte) ((number & 0xFF000000L) >>> 24));
                    break;

                  case 4:
                    assertEquals(result, (byte) ((number & 0xFF00000000L) >>> 32));
                    break;

                  case 5:
                    assertEquals(result, (byte) ((number & 0xFF0000000000L) >>> 40));
                    break;

                  case 6:
                    assertEquals(result, (byte) ((number & 0xFF000000000000L) >>> 48));
                    break;

                  case 7:
                    assertEquals(result,
                        (byte) ((number & 0xFF00000000000000L) >>> 56));
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
  public void numberOfBytes() {
    for (long bit = 1, i = 0; bit != 0; bit <<= 1, ++i) {
      assertEquals(LongUtil.numberOfBytes(bit), (i / Byte.SIZE) + 1);
    }
  }
}
