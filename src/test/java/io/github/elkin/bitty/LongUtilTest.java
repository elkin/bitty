package io.github.elkin.bitty;

import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.longs;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.testng.annotations.Test;

public class LongUtilTest {
  
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getBitsSliceNegativeStart()
  {
    LongUtil.getBitsSliceSafe(0, -1, 1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getBitsSliceStartIndexIsGreaterOrEqualToLongSize()
  {
    LongUtil.getBitsSliceSafe(0, Long.SIZE, Long.SIZE + 1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getBitsSliceNegativeStopIndex()
  {
    LongUtil.getBitsSliceSafe(0, 1, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getBitsSliceStopIndexIsLessThanStartIndex()
  {
    LongUtil.getBitsSliceSafe(0, 3, 2);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getBitsSliceDifferenceBetweenStopAndStartIsGreaterThanLongSize()
  {
    LongUtil.getBitsSliceSafe(0, 1, Long.SIZE + 2);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void setBitsSliceNegativeStart()
  {
    LongUtil.setBitsSliceSafe(0, -1, 1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void setBitsSliceStartIndexIsGreaterOrEqualToLongSize()
  {
    LongUtil.setBitsSliceSafe(0, Long.SIZE, Long.SIZE + 1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void setBitsSliceNegativeStopIndex()
  {
    LongUtil.setBitsSliceSafe(0, 1, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void setBitsSliceStopIndexIsLessThanStartIndex()
  {
    LongUtil.setBitsSliceSafe(0, 3, 2);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void setBitsSliceDifferenceBetweenStopAndStartIsGreaterThanLongSize()
  {
    LongUtil.setBitsSliceSafe(0, 1, Long.SIZE + 2);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearBitsSliceNegativeStart()
  {
    LongUtil.clearBitsSliceSafe(0, -1, 1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearBitsSliceStartIndexIsGreaterOrEqualToLongSize()
  {
    LongUtil.clearBitsSliceSafe(0, Long.SIZE, Long.SIZE + 1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearBitsSliceNegativeStopIndex()
  {
    LongUtil.clearBitsSliceSafe(0, 1, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearBitsSliceStopIndexIsLessThanStartIndex()
  {
    LongUtil.clearBitsSliceSafe(0, 3, 2);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearBitsSliceDifferenceBetweenStopAndStartIsGreaterThanLongSize()
  {
    LongUtil.clearBitsSliceSafe(0, 1, Long.SIZE + 2);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getBitNegativeIndex()
  {
    LongUtil.getBitSafe(0, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getBitIndexIsGreaterOrEqualToIntegerSize()
  {
    LongUtil.getBitSafe(0, Long.SIZE);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void isBitSetNegativeIndex()
  {
    LongUtil.isBitSetSafe(0, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void isBitSetIndexIsGreaterOrEqualToIntegerSize()
  {
    LongUtil.isBitSetSafe(0, Long.SIZE);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void setBitNegativeIndex()
  {
    LongUtil.setBitSafe(0, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void setBitIndexIsGreaterOrEqualToIntegerSize()
  {
    LongUtil.setBitSafe(0, Long.SIZE);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearBitNegativeIndex()
  {
    LongUtil.clearBitSafe(0, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearBitIndexIsGreaterOrEqualToIntegerSize()
  {
    LongUtil.clearBitSafe(0, Long.SIZE);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearHighBytesNumBytesIsNegative()
  {
    LongUtil.clearHighBytesSafe(0, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearHighBytesNumBytesIsGreaterThanIntegerBytes()
  {
    LongUtil.clearHighBytesSafe(0, Long.BYTES + 1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getByteNegativeIndex()
  {
    LongUtil.getByteSafe(0, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getByteIndexIsGreaterOrEqualToIntegerBytes()
  {
    LongUtil.getByteSafe(0, Long.BYTES);
  }

  @Test
  public void setBit() {
    qt().forAll(longs().all())
        .checkAssert(
            number -> {
              for (long bit = 1, i = 0; bit != 0; bit <<= 1, ++i) {
                assertEquals(LongUtil.setBit(number, (int) i), number | bit);
                assertEquals(LongUtil.setBitSafe(number, (int) i), number | bit);
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
                assertEquals(LongUtil.clearBitSafe(number, (int) i), number & (~bit));
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
                long safeResult = LongUtil.clearHighBytesSafe(number, numBytes);
                switch (numBytes) {
                  case 0:
                    assertEquals(result, 0);
                    assertEquals(safeResult, 0);
                    break;
                  case 1:
                    assertEquals(result, number & 0xFFL);
                    assertEquals(safeResult, number & 0xFFL);
                    break;

                  case 2:
                    assertEquals(result, number & 0xFFFFL);
                    assertEquals(safeResult, number & 0xFFFFL);
                    break;

                  case 3:
                    assertEquals(result, number & 0xFFFFFFL);
                    assertEquals(safeResult, number & 0xFFFFFFL);
                    break;

                  case 4:
                    assertEquals(result, number & 0xFFFFFFFFL);
                    assertEquals(safeResult, number & 0xFFFFFFFFL);
                    break;

                  case 5:
                    assertEquals(result, number & 0xFFFFFFFFFFL);
                    assertEquals(safeResult, number & 0xFFFFFFFFFFL);
                    break;
                  case 6:
                    assertEquals(result, number & 0xFFFFFFFFFFFFL);
                    assertEquals(safeResult, number & 0xFFFFFFFFFFFFL);
                    break;

                  case 7:
                    assertEquals(result, number & 0xFFFFFFFFFFFFFFL);
                    assertEquals(safeResult, number & 0xFFFFFFFFFFFFFFL);
                    break;

                  case 8:
                    assertEquals(result, (long) number);
                    assertEquals(safeResult, (long) number);
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
                assertEquals(LongUtil.isBitSetSafe(number, (int) i), (number & bit) != 0);
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
                assertEquals(LongUtil.getBitSafe(number, (int) i), (number & bit) >>> i);
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

                  assertEquals(LongUtil.getBitsSliceSafe(number,
                      start,
                      (int) (start + length - 1)),
                      (number >>> start) & mask);
                }
              }
            });
  }

  @Test
  public void setBitsSlice() {
    qt().forAll(longs().all())
        .checkAssert(
            number -> {
              for (long length = 1, mask = 1;
                  length <= Long.SIZE;
                  ++length, mask = (mask << 1) | 1) {
                for (int start = 0; start < Long.SIZE; ++start) {
                  assertEquals(
                      LongUtil.setBitsSlice(
                          number,
                          start,
                          (int) (start + length - 1)),
                      number | (mask << start));

                  assertEquals(
                      LongUtil.setBitsSliceSafe(
                          number,
                          start,
                          (int) (start + length - 1)),
                      number | (mask << start));
                }
              }
            });
  }

  @Test
  public void clearBitsSlice() {
    qt().forAll(longs().all())
        .checkAssert(
            number -> {
              for (long length = 1, mask = 1;
                  length <= Long.SIZE;
                  ++length, mask = (mask << 1) | 1) {
                for (int start = 0; start < Long.SIZE; ++start) {
                  assertEquals(
                      LongUtil.clearBitsSlice(
                          number,
                          start,
                          (int) (start + length - 1)),
                      number & (~(mask << start)));

                  assertEquals(
                      LongUtil.clearBitsSliceSafe(
                          number,
                          start,
                          (int) (start + length - 1)),
                      number & (~(mask << start)));
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
                byte safeResult = LongUtil.getByteSafe(number, byteIndex);
                switch (byteIndex) {
                  case 0:
                    assertEquals(result, (byte) (number & 0xFFL));
                    assertEquals(safeResult, (byte) (number & 0xFFL));
                    break;

                  case 1:
                    assertEquals(result, (byte) ((number & 0xFF00L) >>> 8));
                    assertEquals(safeResult, (byte) ((number & 0xFF00L) >>> 8));
                    break;

                  case 2:
                    assertEquals(result, (byte) ((number & 0xFF0000L) >>> 16));
                    assertEquals(safeResult, (byte) ((number & 0xFF0000L) >>> 16));
                    break;

                  case 3:
                    assertEquals(result, (byte) ((number & 0xFF000000L) >>> 24));
                    assertEquals(safeResult, (byte) ((number & 0xFF000000L) >>> 24));
                    break;

                  case 4:
                    assertEquals(result, (byte) ((number & 0xFF00000000L) >>> 32));
                    assertEquals(safeResult, (byte) ((number & 0xFF00000000L) >>> 32));
                    break;

                  case 5:
                    assertEquals(result, (byte) ((number & 0xFF0000000000L) >>> 40));
                    assertEquals(safeResult, (byte) ((number & 0xFF0000000000L) >>> 40));
                    break;

                  case 6:
                    assertEquals(result, (byte) ((number & 0xFF000000000000L) >>> 48));
                    assertEquals(safeResult, (byte) ((number & 0xFF000000000000L) >>> 48));
                    break;

                  case 7:
                    assertEquals(result, (byte) ((number & 0xFF00000000000000L) >>> 56));
                    assertEquals(safeResult, (byte) ((number & 0xFF00000000000000L) >>> 56));
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
