package io.github.elkin.bitty;

import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.integers;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.testng.annotations.Test;

public class ShortUtilTest {
  
  @Test(expectedExceptions = AssertionError.class)
  public void getBitsSliceNegativeStart()
  {
    ShortUtil.getBitsSlice((short)0, -1, 1);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void getBitsSliceStartIndexIsGreaterOrEqualToShortSize()
  {
    ShortUtil.getBitsSlice((short) 0, Short.SIZE, Short.SIZE + 1);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void getBitsSliceNegativeStopIndex()
  {
    ShortUtil.getBitsSlice((short) 0, 1, -1);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void getBitsSliceStopIndexIsLessThanStartIndex()
  {
    ShortUtil.getBitsSlice((short) 0, 3, 2);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void getBitsSliceDifferenceBetweenStopAndStartIsGreaterThanShortSize()
  {
    ShortUtil.getBitsSlice((short) 0, 1, Short.SIZE + 2);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void getBitNegativeIndex()
  {
    ShortUtil.getBit((short) 0, -1);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void getBitIndexIsGreaterOrEqualToIntegerSize()
  {
    ShortUtil.getBit((short) 0, Short.SIZE);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void isBitSetNegativeIndex()
  {
    ShortUtil.isBitSet((short) 0, -1);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void isBitSetIndexIsGreaterOrEqualToIntegerSize()
  {
    ShortUtil.isBitSet((short) 0, Short.SIZE);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void setBitNegativeIndex()
  {
    ShortUtil.setBit((short) 0, -1);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void setBitIndexIsGreaterOrEqualToIntegerSize()
  {
    ShortUtil.setBit((short) 0, Short.SIZE);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void clearBitNegativeIndex()
  {
    ShortUtil.clearBit((short) 0, -1);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void clearBitIndexIsGreaterOrEqualToIntegerSize()
  {
    ShortUtil.clearBit((short) 0, Short.SIZE);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void clearHighBytesNumBytesIsNegative()
  {
    ShortUtil.clearHighBytes((short) 0, -1);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void clearHighBytesNumBytesIsGreaterThanIntegerBytes()
  {
    ShortUtil.clearHighBytes((short) 0, Short.BYTES + 1);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void getByteNegativeIndex()
  {
    ShortUtil.getByte((short) 0, -1);
  }

  @Test(expectedExceptions = AssertionError.class)
  public void getByteIndexIsGreaterOrEqualToIntegerBytes()
  {
    ShortUtil.getByte((short) 0, Short.BYTES);
  }

  @Test
  public void setBit() {
    qt().forAll(integers().between(Short.MIN_VALUE, Short.MAX_VALUE))
        .checkAssert(
            number -> {
              for (short bit = 1, i = 0; bit != 0; bit = (short)(bit << 1), ++i) {
                assertEquals(ShortUtil.setBit(number.shortValue(), i), number | bit);
              }
            });
  }

  @Test
  public void clearBit() {
    qt().forAll(integers().between(Short.MIN_VALUE, Short.MAX_VALUE))
        .checkAssert(
            number -> {
              for (short bit = 1, i = 0; bit != 0; bit = (short)(bit << 1), ++i) {
                assertEquals(ShortUtil.clearBit(number.shortValue(), i), number & (~bit));
              }
            });
  }

  @Test
  public void clearHighBytes() {
    qt().forAll(integers().between(Short.MIN_VALUE, Short.MAX_VALUE))
        .checkAssert(
            number -> {
              for (int numBytes = 0; numBytes <= Short.BYTES; ++numBytes) {
                short result = ShortUtil.clearHighBytes(number.shortValue(), numBytes);
                switch (numBytes) {
                  case 0:
                    assertEquals(result, 0);
                    break;
                  case 1:
                    assertEquals(result, number & 0xFF);
                    break;

                  case 2:
                    assertEquals(result, number.shortValue());
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
    qt().forAll(integers().between(Short.MIN_VALUE, Short.MAX_VALUE))
        .checkAssert(
            number -> {
              for (short bit = 1, i = 0; bit != 0; bit = (short)(bit << 1), ++i) {
                assertEquals(ShortUtil.isBitSet(number.shortValue(), i),
                    (number & bit) != 0);
              }
            });
  }

  @Test
  public void getBit() {
    qt().forAll(integers().between(Short.MIN_VALUE, Short.MAX_VALUE))
        .checkAssert(
            number -> {
              for (int bit = 1, i = 0; i < Short.SIZE; bit <<= 1, ++i) {
                assertEquals(ShortUtil.getBit(number.shortValue(), i),
                    (short) ((number & bit) >>> i));
              }
            });
  }

  @Test
  public void getBitsSlice() {
    qt().forAll(integers().between(Short.MIN_VALUE, Short.MAX_VALUE))
        .checkAssert(
            number -> {
              for (int length = 1, mask = 1;
                  length <= Short.SIZE;
                  ++length, mask = (mask << 1) | 1) {
                for (int start = 0; start < Short.SIZE; ++start) {
                  assertEquals(ShortUtil.getBitsSlice(number.shortValue(),
                      start,
                      start + length - 1),
                      (short) (((number & 0xFFFF) >>> start) & mask));
                }
              }
            });
  }

  @Test
  public void getByteIn() {
    qt().forAll(integers().between(Short.MIN_VALUE, Short.MAX_VALUE))
        .checkAssert(
            number -> {
              for (int byteIndex = 0; byteIndex < Short.BYTES; ++byteIndex) {
                byte result = ShortUtil.getByte(number.shortValue(), byteIndex);
                switch (byteIndex) {
                  case 0:
                    assertEquals(result, (byte) (number & 0xFF));
                    break;

                  case 1:
                    assertEquals(result, (byte) ((number & 0xFF00) >>> 8));
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
    for (short bit = 1, i = 0; bit != 0; bit = (short)(bit << 1), ++i) {
      assertEquals(ShortUtil.numberOfBytes(bit), (i / Byte.SIZE) + 1);
    }
  }
}