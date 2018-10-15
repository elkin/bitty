package io.github.elkin.bitty;

import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.integers;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.testng.annotations.Test;

public class IntegerUtilTest {

  @Test(expectedExceptions = AssertionError.class)
  public void getBitsSliceNegativeStart()
  {
    IntegerUtil.getBitsSlice(0, -1, 1);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void getBitsSliceStartIndexIsGreaterOrEqualToIntegerSize()
  {
    IntegerUtil.getBitsSlice(0, 32, 33);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void getBitsSliceNegativeStopIndex()
  {
    IntegerUtil.getBitsSlice(0, 1, -1);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void getBitsSliceStopIndexIsLessThanStartIndex()
  {
    IntegerUtil.getBitsSlice(0, 3, 2);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void getBitsSliceDifferenceBetweenStopAndStartIsGreaterThanIntegerSize()
  {
    IntegerUtil.getBitsSlice(0, 1, 34);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void setBitsSliceNegativeStart()
  {
    IntegerUtil.setBitsSlice(0, -1, 1);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void setBitsSliceStartIndexIsGreaterOrEqualToIntegerSize()
  {
    IntegerUtil.setBitsSlice(0, 32, 33);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void setBitsSliceNegativeStopIndex()
  {
    IntegerUtil.setBitsSlice(0, 1, -1);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void setBitsSliceStopIndexIsLessThanStartIndex()
  {
    IntegerUtil.setBitsSlice(0, 3, 2);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void setBitsSliceDifferenceBetweenStopAndStartIsGreaterThanIntegerSize()
  {
    IntegerUtil.setBitsSlice(0, 1, 34);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void clearBitsSliceNegativeStart()
  {
    IntegerUtil.clearBitsSlice(0, -1, 1);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void clearBitsSliceStartIndexIsGreaterOrEqualToIntegerSize()
  {
    IntegerUtil.clearBitsSlice(0, 32, 33);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void clearBitsSliceNegativeStopIndex()
  {
    IntegerUtil.clearBitsSlice(0, 1, -1);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void clearBitsSliceStopIndexIsLessThanStartIndex()
  {
    IntegerUtil.clearBitsSlice(0, 3, 2);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void clearBitsSliceDifferenceBetweenStopAndStartIsGreaterThanIntegerSize()
  {
    IntegerUtil.clearBitsSlice(0, 1, 34);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void getBitNegativeIndex()
  {
    IntegerUtil.getBit(0, -1);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void getBitIndexIsGreaterOrEqualToIntegerSize()
  {
    IntegerUtil.getBit(0, Integer.SIZE);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void isBitSetNegativeIndex()
  {
    IntegerUtil.isBitSet(0, -1);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void isBitSetIndexIsGreaterOrEqualToIntegerSize()
  {
    IntegerUtil.isBitSet(0, Integer.SIZE);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void setBitNegativeIndex()
  {
    IntegerUtil.setBit(0, -1);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void setBitIndexIsGreaterOrEqualToIntegerSize()
  {
    IntegerUtil.setBit(0, Integer.SIZE);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void clearBitNegativeIndex()
  {
    IntegerUtil.clearBit(0, -1);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void clearBitIndexIsGreaterOrEqualToIntegerSize()
  {
    IntegerUtil.clearBit(0, Integer.SIZE);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void clearHighBytesNumBytesIsNegative()
  {
    IntegerUtil.clearHighBytes(0, -1);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void clearHighBytesNumBytesIsGreaterThanIntegerBytes()
  {
    IntegerUtil.clearHighBytes(0, Integer.BYTES + 1);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void getByteNegativeIndex()
  {
    IntegerUtil.getByte(0, -1);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void getByteIndexIsGreaterOrEqualToIntegerBytes()
  {
    IntegerUtil.getByte(0, Integer.BYTES);
  }

  @Test
  public void setBit() {
    qt().forAll(integers().all())
        .checkAssert(
            number -> {
              for (int bit = 1, i = 0; bit != 0; bit <<= 1, ++i) {
                assertEquals(IntegerUtil.setBit(number, i), number | bit);
              }
            });
  }

  @Test
  public void clearBit() {
    qt().forAll(integers().all())
        .checkAssert(
            number -> {
              for (int bit = 1, i = 0; bit != 0; bit <<= 1, ++i) {
                assertEquals(IntegerUtil.clearBit(number, i), number & (~bit));
              }
            });
  }

  @Test
  public void clearHighBytes() {
    qt().forAll(integers().all())
        .checkAssert(
            number -> {
              for (int numBytes = 0; numBytes <= Integer.BYTES; ++numBytes) {
                int result = IntegerUtil.clearHighBytes(number, numBytes);
                switch (numBytes) {
                  case 0:
                    assertEquals(result, 0);
                    break;
                  case 1:
                    assertEquals(result, number & 0xFF);
                    break;

                  case 2:
                    assertEquals(result, number & 0xFFFF);
                    break;

                  case 3:
                    assertEquals(result, number & 0xFFFFFF);
                    break;

                  case 4:
                    assertEquals(result, (int) number);
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
    qt().forAll(integers().all())
        .checkAssert(
            number -> {
              for (int bit = 1, i = 0; bit != 0; bit <<= 1, ++i) {
                assertEquals(IntegerUtil.isBitSet(number, i), (number & bit) != 0);
              }
            });
  }

  @Test
  public void getBit() {
    qt().forAll(integers().all())
        .checkAssert(
            number -> {
              for (int bit = 1, i = 0; bit != 0; bit <<= 1, ++i) {
                assertEquals(IntegerUtil.getBit(number, i), (number & bit) >>> i);
              }
            });
  }

  @Test
  public void getBitsSlice() {
    qt().forAll(integers().all())
        .checkAssert(
            number -> {
              for (int length = 1, mask = 1;
                  length <= Integer.SIZE;
                  ++length, mask = (mask << 1) | 1) {
                for (int start = 0; start < Integer.SIZE; ++start) {
                  assertEquals(IntegerUtil.getBitsSlice(number,
                      start,
                      start + length - 1),
                      (number >>> start) & mask);
                }
              }
            });
  }

  @Test
  public void setBitsSlice() {
    qt().forAll(integers().all())
        .checkAssert(
            number -> {
              for (int length = 1, mask = 1;
                  length <= Integer.SIZE;
                  ++length, mask = (mask << 1) | 1) {
                for (int start = 0; start < Integer.SIZE; ++start) {
                  assertEquals(
                      IntegerUtil.setBitsSlice(
                          number,
                          start,
                          start + length - 1),
                      number | (mask << start));
                }
              }
            });
  }

  @Test
  public void clearBitsSlice() {
    qt().forAll(integers().all())
        .checkAssert(
            number -> {
              for (int length = 1, mask = 1;
                  length <= Integer.SIZE;
                  ++length, mask = (mask << 1) | 1) {
                for (int start = 0; start < Integer.SIZE; ++start) {
                  assertEquals(
                      IntegerUtil.clearBitsSlice(
                          number,
                          start,
                          start + length - 1),
                      number & (~(mask << start)));
                }
              }
            });
  }

  @Test
  public void getByte() {
    qt().forAll(integers().all())
        .checkAssert(
            number -> {
              for (int byteIndex = 0; byteIndex < Integer.BYTES; ++byteIndex) {
                byte result = IntegerUtil.getByte(number, byteIndex);
                switch (byteIndex) {
                  case 0:
                    assertEquals(result, (byte) (number & 0xFF));
                    break;

                  case 1:
                    assertEquals(result, (byte) ((number & 0xFF00) >>> 8));
                    break;

                  case 2:
                    assertEquals(result, (byte) ((number & 0xFF0000) >>> 16));
                    break;

                  case 3:
                    assertEquals(result, (byte) ((number & 0xFF000000) >>> 24));
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
    for (int bit = 1, i = 0; bit != 0; bit <<= 1, ++i) {
      assertEquals(IntegerUtil.numberOfBytes(bit), (i / Byte.SIZE) + 1);
    }
  }
}
