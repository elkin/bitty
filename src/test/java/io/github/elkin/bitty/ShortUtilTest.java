package io.github.elkin.bitty;

import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.integers;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.testng.annotations.Test;

public class ShortUtilTest {

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getBitsSliceNegativeStart() {
    ShortUtil.getBitsSliceSafe((short) 0, -1, 1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getBitsSliceStartIndexIsGreaterOrEqualToShortSize() {
    ShortUtil.getBitsSliceSafe((short) 0, Short.SIZE, Short.SIZE + 1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getBitsSliceNegativeStopIndex() {
    ShortUtil.getBitsSliceSafe((short) 0, 1, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getBitsSliceStopIndexIsLessThanStartIndex() {
    ShortUtil.getBitsSliceSafe((short) 0, 3, 2);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getBitsSliceDifferenceBetweenStopAndStartIsGreaterThanShortSize() {
    ShortUtil.getBitsSliceSafe((short) 0, 1, Short.SIZE + 2);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void setBitsSliceNegativeStart() {
    ShortUtil.setBitsSliceSafe((short) 0, -1, 1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void setBitsSliceStartIndexIsGreaterOrEqualToShortSize() {
    ShortUtil.setBitsSliceSafe((short) 0, Short.SIZE, Short.SIZE + 1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void setBitsSliceNegativeStopIndex() {
    ShortUtil.setBitsSliceSafe((short) 0, 1, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void setBitsSliceStopIndexIsLessThanStartIndex() {
    ShortUtil.setBitsSliceSafe((short) 0, 3, 2);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void setBitsSliceDifferenceBetweenStopAndStartIsGreaterThanShortSize() {
    ShortUtil.setBitsSliceSafe((short) 0, 1, Short.SIZE + 2);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearBitsSliceNegativeStart() {
    ShortUtil.clearBitsSliceSafe((short) 0, -1, 1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearBitsSliceStartIndexIsGreaterOrEqualToShortSize() {
    ShortUtil.clearBitsSliceSafe((short) 0, Short.SIZE, Short.SIZE + 1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearBitsSliceNegativeStopIndex() {
    ShortUtil.clearBitsSliceSafe((short) 0, 1, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearBitsSliceStopIndexIsLessThanStartIndex() {
    ShortUtil.getBitsSliceSafe((short) 0, 3, 2);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearBitsSliceDifferenceBetweenStopAndStartIsGreaterThanShortSize() {
    ShortUtil.clearBitsSliceSafe((short) 0, 1, Short.SIZE + 2);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getBitNegativeIndex() {
    ShortUtil.getBitSafe((short) 0, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getBitIndexIsGreaterOrEqualToIntegerSize() {
    ShortUtil.getBitSafe((short) 0, Short.SIZE);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void isBitSetNegativeIndex() {
    ShortUtil.isBitSetSafe((short) 0, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void isBitSetIndexIsGreaterOrEqualToIntegerSize() {
    ShortUtil.isBitSetSafe((short) 0, Short.SIZE);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void setBitNegativeIndex() {
    ShortUtil.setBitSafe((short) 0, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void setBitIndexIsGreaterOrEqualToIntegerSize() {
    ShortUtil.setBitSafe((short) 0, Short.SIZE);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearBitNegativeIndex() {
    ShortUtil.clearBitSafe((short) 0, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearBitIndexIsGreaterOrEqualToIntegerSize() {
    ShortUtil.clearBitSafe((short) 0, Short.SIZE);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearHighBytesNumBytesIsNegative() {
    ShortUtil.clearHighBytesSafe((short) 0, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearHighBytesNumBytesIsGreaterThanIntegerBytes() {
    ShortUtil.clearHighBytesSafe((short) 0, Short.BYTES + 1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getByteNegativeIndex() {
    ShortUtil.getByteSafe((short) 0, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getByteIndexIsGreaterOrEqualToIntegerBytes() {
    ShortUtil.getByteSafe((short) 0, Short.BYTES);
  }

  @Test
  public void setBit() {
    qt().forAll(integers().between(Short.MIN_VALUE, Short.MAX_VALUE))
        .checkAssert(
            number -> {
              for (short bit = 1, i = 0; bit != 0; bit = (short) (bit << 1), ++i) {
                assertEquals(ShortUtil.setBit(number.shortValue(), i), number | bit);
                assertEquals(ShortUtil.setBitSafe(number.shortValue(), i), number | bit);
              }
            });
  }

  @Test
  public void clearBit() {
    qt().forAll(integers().between(Short.MIN_VALUE, Short.MAX_VALUE))
        .checkAssert(
            number -> {
              for (short bit = 1, i = 0; bit != 0; bit = (short) (bit << 1), ++i) {
                assertEquals(ShortUtil.clearBit(number.shortValue(), i), number & (~bit));
                assertEquals(ShortUtil.clearBitSafe(number.shortValue(), i), number & (~bit));
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
                short safeResult = ShortUtil.clearHighBytesSafe(number.shortValue(), numBytes);
                switch (numBytes) {
                  case 0:
                    assertEquals(result, 0);
                    assertEquals(safeResult, 0);
                    break;
                  case 1:
                    assertEquals(result, number & 0xFF);
                    assertEquals(safeResult, number & 0xFF);
                    break;

                  case 2:
                    assertEquals(result, number.shortValue());
                    assertEquals(safeResult, number.shortValue());
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
              for (short bit = 1, i = 0; bit != 0; bit = (short) (bit << 1), ++i) {
                assertEquals(
                    ShortUtil.isBitSet(number.shortValue(), i),
                    (number & bit) != 0);

                assertEquals(
                    ShortUtil.isBitSetSafe(number.shortValue(), i),
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
                assertEquals(
                    ShortUtil.getBit(number.shortValue(), i),
                    (short) ((number & bit) >>> i));

                assertEquals(
                    ShortUtil.getBitSafe(number.shortValue(), i),
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
                  assertEquals(
                      ShortUtil.getBitsSlice(
                          number.shortValue(),
                          start,
                          start + length - 1),
                      (short) (((number & 0xFFFF) >>> start) & mask));

                  assertEquals(
                      ShortUtil.getBitsSliceSafe(
                          number.shortValue(),
                          start,
                          start + length - 1),
                      (short) (((number & 0xFFFF) >>> start) & mask));
                }
              }
            });
  }

  @Test
  public void setBitsSlice() {
    qt().forAll(integers().between(Short.MIN_VALUE, Short.MAX_VALUE))
        .checkAssert(
            number -> {
              for (int length = 1, mask = 1;
                  length <= Short.SIZE;
                  ++length, mask = (mask << 1) | 1) {
                for (int start = 0; start < Short.SIZE; ++start) {
                  assertEquals(
                      ShortUtil.setBitsSlice(
                          number.shortValue(),
                          start,
                          start + length - 1),
                      (short) (number | (mask << start)));

                  assertEquals(
                      ShortUtil.setBitsSliceSafe(
                          number.shortValue(),
                          start,
                          start + length - 1),
                      (short) (number | (mask << start)));
                }
              }
            });
  }

  @Test
  public void clearBitsSlice() {
    qt().forAll(integers().between(Short.MIN_VALUE, Short.MAX_VALUE))
        .checkAssert(
            number -> {
              for (int length = 1, mask = 1;
                  length <= Short.SIZE;
                  ++length, mask = (mask << 1) | 1) {
                for (int start = 0; start < Short.SIZE; ++start) {
                  assertEquals(
                      ShortUtil.clearBitsSlice(
                          number.shortValue(),
                          start,
                          start + length - 1),
                      (short) (number & (~(mask << start))));

                  assertEquals(
                      ShortUtil.clearBitsSliceSafe(
                          number.shortValue(),
                          start,
                          start + length - 1),
                      (short) (number & (~(mask << start))));
                }
              }
            });
  }

  @Test
  public void getByte() {
    qt().forAll(integers().between(Short.MIN_VALUE, Short.MAX_VALUE))
        .checkAssert(
            number -> {
              for (int byteIndex = 0; byteIndex < Short.BYTES; ++byteIndex) {
                byte result = ShortUtil.getByte(number.shortValue(), byteIndex);
                byte safeResult = ShortUtil.getByteSafe(number.shortValue(), byteIndex);
                switch (byteIndex) {
                  case 0:
                    assertEquals(result, (byte) (number & 0xFF));
                    assertEquals(safeResult, (byte) (number & 0xFF));
                    break;

                  case 1:
                    assertEquals(result, (byte) ((number & 0xFF00) >>> 8));
                    assertEquals(safeResult, (byte) ((number & 0xFF00) >>> 8));
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
    for (short bit = 1, i = 0; bit != 0; bit = (short) (bit << 1), ++i) {
      assertEquals(ShortUtil.numberOfBytes(bit), (i / Byte.SIZE) + 1);
    }
  }
}