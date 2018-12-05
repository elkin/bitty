package io.github.elkin.bitty;

import static org.quicktheories.QuickTheory.qt;
import static org.testng.Assert.assertEquals;

import org.quicktheories.generators.SourceDSL;
import org.testng.annotations.Test;

public class BitUtilTest {

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getBitsSliceNegativeStartInteger() {
    BitUtil.getBitsSliceSafe(0, -1, 1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getBitsSliceStartIndexIsGreaterOrEqualToIntegerSizeInteger() {
    BitUtil.getBitsSliceSafe(0, Integer.SIZE, Integer.SIZE + 1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getBitsSliceNegativeStopIndexInteger() {
    BitUtil.getBitsSliceSafe(0, 1, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getBitsSliceStopIndexIsLessThanStartIndexInteger() {
    BitUtil.getBitsSliceSafe(0, 3, 2);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getBitsSliceDifferenceBetweenStopAndStartIsGreaterThanIntegerSizeInteger() {
    BitUtil.getBitsSliceSafe(0, 1, Integer.SIZE + 2);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void setBitsSliceNegativeStartInteger() {
    BitUtil.setBitsSliceSafe(0, -1, 1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void setBitsSliceStartIndexIsGreaterOrEqualToIntegerSizeInteger() {
    BitUtil.setBitsSliceSafe(0, Integer.SIZE, Integer.SIZE + 1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void setBitsSliceNegativeStopIndexInteger() {
    BitUtil.setBitsSliceSafe(0, 1, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void setBitsSliceStopIndexIsLessThanStartIndexInteger() {
    BitUtil.setBitsSliceSafe(0, 3, 2);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void setBitsSliceDifferenceBetweenStopAndStartIsGreaterThanIntegerSizeInteger() {
    BitUtil.setBitsSliceSafe(0, 1, Integer.SIZE + 2);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearBitsSliceNegativeStartInteger() {
    BitUtil.clearBitsSliceSafe(0, -1, 1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearBitsSliceStartIndexIsGreaterOrEqualToIntegerSizeInteger() {
    BitUtil.clearBitsSliceSafe(0, Integer.SIZE, Integer.SIZE + 1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearBitsSliceNegativeStopIndexInteger() {
    BitUtil.clearBitsSliceSafe(0, 1, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearBitsSliceStopIndexIsLessThanStartIndexInteger() {
    BitUtil.clearBitsSliceSafe(0, 3, 2);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearBitsSliceDifferenceBetweenStopAndStartIsGreaterThanIntegerSizeInteger() {
    BitUtil.clearBitsSliceSafe(0, 1, Integer.SIZE + 2);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getBitNegativeIndexInteger() {
    BitUtil.getBitSafe(0, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getBitIndexIsGreaterOrEqualToIntegerSizeInteger() {
    BitUtil.getBitSafe(0, Integer.SIZE);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void isBitSetNegativeIndexInteger() {
    BitUtil.isBitSetSafe(0, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void isBitSetIndexIsGreaterOrEqualToIntegerSizeInteger() {
    BitUtil.isBitSetSafe(0, Integer.SIZE);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void setBitNegativeIndexInteger() {
    BitUtil.setBitSafe(0, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void setBitIndexIsGreaterOrEqualToIntegerSizeInteger() {
    BitUtil.setBitSafe(0, Integer.SIZE);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearBitNegativeIndexInteger() {
    BitUtil.clearBitSafe(0, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearBitIndexIsGreaterOrEqualToIntegerSizeInteger() {
    BitUtil.clearBitSafe(0, Integer.SIZE);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearHighBytesNumBytesIsNegativeInteger() {
    BitUtil.clearHighBytesSafe(0, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearHighBytesNumBytesIsGreaterThanIntegerBytesInteger() {
    BitUtil.clearHighBytesSafe(0, Integer.BYTES + 1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getByteNegativeIndexInteger() {
    BitUtil.getByteSafe(0, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getByteIndexIsGreaterOrEqualToIntegerBytesInteger() {
    BitUtil.getByteSafe(0, Integer.BYTES);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getBitsSliceNegativeStartLong() {
    BitUtil.getBitsSliceSafe(0L, -1, 1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getBitsSliceStartIndexIsGreaterOrEqualToLongSizeLong() {
    BitUtil.getBitsSliceSafe(0L, Long.SIZE, Long.SIZE + 1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getBitsSliceNegativeStopIndexLong() {
    BitUtil.getBitsSliceSafe(0L, 1, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getBitsSliceStopIndexIsLessThanStartIndexLong() {
    BitUtil.getBitsSliceSafe(0L, 3, 2);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getBitsSliceDifferenceBetweenStopAndStartIsGreaterThanLongSizeLong() {
    BitUtil.getBitsSliceSafe(0L, 1, Long.SIZE + 2);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void setBitsSliceNegativeStartLong() {
    BitUtil.setBitsSliceSafe(0L, -1, 1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void setBitsSliceStartIndexIsGreaterOrEqualToLongSizeLong() {
    BitUtil.setBitsSliceSafe(0L, Long.SIZE, Long.SIZE + 1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void setBitsSliceNegativeStopIndexLong() {
    BitUtil.setBitsSliceSafe(0L, 1, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void setBitsSliceStopIndexIsLessThanStartIndexLong() {
    BitUtil.setBitsSliceSafe(0L, 3, 2);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void setBitsSliceDifferenceBetweenStopAndStartIsGreaterThanLongSizeLong() {
    BitUtil.setBitsSliceSafe(0L, 1, Long.SIZE + 2);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearBitsSliceNegativeStartLong() {
    BitUtil.clearBitsSliceSafe(0L, -1, 1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearBitsSliceStartIndexIsGreaterOrEqualToLongSizeLong() {
    BitUtil.clearBitsSliceSafe(0L, Long.SIZE, Long.SIZE + 1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearBitsSliceNegativeStopIndexLong() {
    BitUtil.clearBitsSliceSafe(0L, 1, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearBitsSliceStopIndexIsLessThanStartIndexLong() {
    BitUtil.clearBitsSliceSafe(0L, 3, 2);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearBitsSliceDifferenceBetweenStopAndStartIsGreaterThanLongSizeLong() {
    BitUtil.clearBitsSliceSafe(0L, 1, Long.SIZE + 2);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getBitNegativeIndexLong() {
    BitUtil.getBitSafe(0L, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getBitIndexIsGreaterOrEqualToIntegerSizeLong() {
    BitUtil.getBitSafe(0L, Long.SIZE);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void isBitSetNegativeIndexLong() {
    BitUtil.isBitSetSafe(0L, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void isBitSetIndexIsGreaterOrEqualToIntegerSizeLong() {
    BitUtil.isBitSetSafe(0L, Long.SIZE);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void setBitNegativeIndexLong() {
    BitUtil.setBitSafe(0L, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void setBitIndexIsGreaterOrEqualToIntegerSizeLong() {
    BitUtil.setBitSafe(0L, Long.SIZE);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearBitNegativeIndexLong() {
    BitUtil.clearBitSafe(0L, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearBitIndexIsGreaterOrEqualToIntegerSizeLong() {
    BitUtil.clearBitSafe(0L, Long.SIZE);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearHighBytesNumBytesIsNegativeLong() {
    BitUtil.clearHighBytesSafe(0L, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearHighBytesNumBytesIsGreaterThanIntegerBytesLong() {
    BitUtil.clearHighBytesSafe(0L, Long.BYTES + 1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getByteNegativeIndexLong() {
    BitUtil.getByteSafe(0L, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getByteIndexIsGreaterOrEqualToIntegerBytesLong() {
    BitUtil.getByteSafe(0L, Long.BYTES);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getBitsSliceNegativeStartShort() {
    BitUtil.getBitsSliceSafe((short) 0, -1, 1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getBitsSliceStartIndexIsGreaterOrEqualToShortSizeShort() {
    BitUtil.getBitsSliceSafe((short) 0, Short.SIZE, Short.SIZE + 1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getBitsSliceNegativeStopIndexShort() {
    BitUtil.getBitsSliceSafe((short) 0, 1, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getBitsSliceStopIndexIsLessThanStartIndexShort() {
    BitUtil.getBitsSliceSafe((short) 0, 3, 2);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getBitsSliceDifferenceBetweenStopAndStartIsGreaterThanShortSizeShort() {
    BitUtil.getBitsSliceSafe((short) 0, 1, Short.SIZE + 2);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void setBitsSliceNegativeStartShort() {
    BitUtil.setBitsSliceSafe((short) 0, -1, 1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void setBitsSliceStartIndexIsGreaterOrEqualToShortSizeShort() {
    BitUtil.setBitsSliceSafe((short) 0, Short.SIZE, Short.SIZE + 1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void setBitsSliceNegativeStopIndexShort() {
    BitUtil.setBitsSliceSafe((short) 0, 1, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void setBitsSliceStopIndexIsLessThanStartIndexShort() {
    BitUtil.setBitsSliceSafe((short) 0, 3, 2);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void setBitsSliceDifferenceBetweenStopAndStartIsGreaterThanShortSizeShort() {
    BitUtil.setBitsSliceSafe((short) 0, 1, Short.SIZE + 2);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearBitsSliceNegativeStartShort() {
    BitUtil.clearBitsSliceSafe((short) 0, -1, 1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearBitsSliceStartIndexIsGreaterOrEqualToShortSizeShort() {
    BitUtil.clearBitsSliceSafe((short) 0, Short.SIZE, Short.SIZE + 1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearBitsSliceNegativeStopIndexShort() {
    BitUtil.clearBitsSliceSafe((short) 0, 1, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearBitsSliceStopIndexIsLessThanStartIndexShort() {
    BitUtil.getBitsSliceSafe((short) 0, 3, 2);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearBitsSliceDifferenceBetweenStopAndStartIsGreaterThanShortSizeShort() {
    BitUtil.clearBitsSliceSafe((short) 0, 1, Short.SIZE + 2);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getBitNegativeIndexShort() {
    BitUtil.getBitSafe((short) 0, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getBitIndexIsGreaterOrEqualToIntegerSizeShort() {
    BitUtil.getBitSafe((short) 0, Short.SIZE);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void isBitSetNegativeIndexShort() {
    BitUtil.isBitSetSafe((short) 0, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void isBitSetIndexIsGreaterOrEqualToIntegerSizeShort() {
    BitUtil.isBitSetSafe((short) 0, Short.SIZE);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void setBitNegativeIndexShort() {
    BitUtil.setBitSafe((short) 0, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void setBitIndexIsGreaterOrEqualToIntegerSizeShort() {
    BitUtil.setBitSafe((short) 0, Short.SIZE);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearBitNegativeIndexShort() {
    BitUtil.clearBitSafe((short) 0, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearBitIndexIsGreaterOrEqualToIntegerSizeShort() {
    BitUtil.clearBitSafe((short) 0, Short.SIZE);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearHighBytesNumBytesIsNegativeShort() {
    BitUtil.clearHighBytesSafe((short) 0, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void clearHighBytesNumBytesIsGreaterThanIntegerBytesShort() {
    BitUtil.clearHighBytesSafe((short) 0, Short.BYTES + 1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getByteNegativeIndexShort() {
    BitUtil.getByteSafe((short) 0, -1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void getByteIndexIsGreaterOrEqualToIntegerBytesShort() {
    BitUtil.getByteSafe((short) 0, Short.BYTES);
  }

  @Test
  public void getBitsSliceInteger() {
    qt().forAll(SourceDSL.integers().all())
        .checkAssert(number -> {
          for (int start = 0; start < Integer.SIZE - 1; ++start) {
            for (int end = start + 1; end < Integer.SIZE; ++end) {
              assertEquals(
                  BitUtil.getBitsSlice(number, start, end),
                  IntegerUtil.getBitsSlice(number, start, end));
              assertEquals(
                  BitUtil.getBitsSliceSafe(number, start, end),
                  IntegerUtil.getBitsSlice(number, start, end));
            }
          }
        });
  }

  @Test
  public void getBitsSliceLong() {
    qt().forAll(SourceDSL.longs().all())
        .checkAssert(number -> {
          for (int start = 0; start < Long.SIZE - 1; ++start) {
            for (int end = start + 1; end < Long.SIZE; ++end) {
              assertEquals(
                  BitUtil.getBitsSlice(number, start, end),
                  LongUtil.getBitsSlice(number, start, end));

              assertEquals(
                  BitUtil.getBitsSliceSafe(number, start, end),
                  LongUtil.getBitsSlice(number, start, end));
            }
          }
        });
  }

  @Test
  public void getBitsSliceShort() {
    qt().forAll(SourceDSL.integers().between(Short.MIN_VALUE, Short.MAX_VALUE))
        .checkAssert(number -> {
          for (int start = 0; start < Short.SIZE - 1; ++start) {
            for (int end = start + 1; end < Short.SIZE; ++end) {
              assertEquals(
                  BitUtil.getBitsSlice(number.shortValue(), start, end),
                  ShortUtil.getBitsSlice(number.shortValue(), start, end));

              assertEquals(
                  BitUtil.getBitsSliceSafe(number.shortValue(), start, end),
                  ShortUtil.getBitsSlice(number.shortValue(), start, end));
            }
          }
        });
  }

  @Test
  public void setBitsSliceInteger() {
    qt().forAll(SourceDSL.integers().all())
        .checkAssert(number -> {
          for (int start = 0; start < Integer.SIZE - 1; ++start) {
            for (int end = start + 1; end < Integer.SIZE; ++end) {
              assertEquals(
                  BitUtil.setBitsSlice(number, start, end),
                  IntegerUtil.setBitsSlice(number, start, end));

              assertEquals(
                  BitUtil.setBitsSliceSafe(number, start, end),
                  IntegerUtil.setBitsSlice(number, start, end));
            }
          }
        });
  }

  @Test
  public void setBitsSliceLong() {
    qt().forAll(SourceDSL.longs().all())
        .checkAssert(number -> {
          for (int start = 0; start < Long.SIZE - 1; ++start) {
            for (int end = start + 1; end < Long.SIZE; ++end) {
              assertEquals(
                  BitUtil.setBitsSlice(number, start, end),
                  LongUtil.setBitsSlice(number, start, end));

              assertEquals(
                  BitUtil.setBitsSliceSafe(number, start, end),
                  LongUtil.setBitsSlice(number, start, end));
            }
          }
        });
  }

  @Test
  public void setBitsSliceShort() {
    qt().forAll(SourceDSL.integers().between(Short.MIN_VALUE, Short.MAX_VALUE))
        .checkAssert(number -> {
          for (int start = 0; start < Short.SIZE - 1; ++start) {
            for (int end = start + 1; end < Short.SIZE; ++end) {
              assertEquals(
                  BitUtil.setBitsSlice(number.shortValue(), start, end),
                  ShortUtil.setBitsSlice(number.shortValue(), start, end));

              assertEquals(
                  BitUtil.setBitsSliceSafe(number.shortValue(), start, end),
                  ShortUtil.setBitsSlice(number.shortValue(), start, end));
            }
          }
        });
  }

  @Test
  public void clearBitsSliceInteger() {
    qt().forAll(SourceDSL.integers().all())
        .checkAssert(number -> {
          for (int start = 0; start < Integer.SIZE - 1; ++start) {
            for (int end = start + 1; end < Integer.SIZE; ++end) {
              assertEquals(
                  BitUtil.clearBitsSlice(number, start, end),
                  IntegerUtil.clearBitsSlice(number, start, end));

              assertEquals(
                  BitUtil.clearBitsSliceSafe(number, start, end),
                  IntegerUtil.clearBitsSlice(number, start, end));
            }
          }
        });
  }

  @Test
  public void clearBitsSliceLong() {
    qt().forAll(SourceDSL.longs().all())
        .checkAssert(number -> {
          for (int start = 0; start < Long.SIZE - 1; ++start) {
            for (int end = start + 1; end < Long.SIZE; ++end) {
              assertEquals(
                  BitUtil.clearBitsSlice(number, start, end),
                  LongUtil.clearBitsSlice(number, start, end));

              assertEquals(
                  BitUtil.clearBitsSliceSafe(number, start, end),
                  LongUtil.clearBitsSlice(number, start, end));
            }
          }
        });
  }

  @Test
  public void clearBitsSliceShort() {
    qt().forAll(SourceDSL.integers().between(Short.MIN_VALUE, Short.MAX_VALUE))
        .checkAssert(number -> {
          for (int start = 0; start < Short.SIZE - 1; ++start) {
            for (int end = start + 1; end < Short.SIZE; ++end) {
              assertEquals(
                  BitUtil.clearBitsSlice(number.shortValue(), start, end),
                  ShortUtil.clearBitsSlice(number.shortValue(), start, end));

              assertEquals(
                  BitUtil.clearBitsSliceSafe(number.shortValue(), start, end),
                  ShortUtil.clearBitsSlice(number.shortValue(), start, end));
            }
          }
        });
  }

  @Test
  public void getBitInteger() {
    qt().forAll(SourceDSL.integers().all())
        .checkAssert(number -> {
          for (int i = 0; i < Integer.SIZE; ++i) {
            assertEquals(BitUtil.getBit(number, i), IntegerUtil.getBit(number, i));
            assertEquals(BitUtil.getBitSafe(number, i), IntegerUtil.getBit(number, i));
          }
        });
  }

  @Test
  public void getBitLong() {
    qt().forAll(SourceDSL.longs().all())
        .checkAssert(number -> {
          for (int i = 0; i < Long.SIZE; ++i) {
            assertEquals(BitUtil.getBit(number, i), LongUtil.getBit(number, i));
            assertEquals(BitUtil.getBitSafe(number, i), LongUtil.getBit(number, i));
          }
        });
  }

  @Test
  public void getBitShort() {
    qt().forAll(SourceDSL.integers().between(Short.MIN_VALUE, Short.MAX_VALUE))
        .checkAssert(number -> {
          for (int i = 0; i < Short.SIZE; ++i) {
            assertEquals(
                BitUtil.getBit(number.shortValue(), i),
                ShortUtil.getBit(number.shortValue(), i));

            assertEquals(
                BitUtil.getBitSafe(number.shortValue(), i),
                ShortUtil.getBit(number.shortValue(), i));
          }
        });
  }

  @Test
  public void isBitSetInteger() {
    qt().forAll(SourceDSL.integers().all())
        .checkAssert(number -> {
          for (int i = 0; i < Integer.SIZE; ++i) {
            assertEquals(BitUtil.isBitSet(number, i), IntegerUtil.isBitSet(number, i));
            assertEquals(BitUtil.isBitSetSafe(number, i), IntegerUtil.isBitSet(number, i));
          }
        });
  }

  @Test
  public void isBitSetLong() {
    qt().forAll(SourceDSL.longs().all())
        .checkAssert(number -> {
          for (int i = 0; i < Long.SIZE; ++i) {
            assertEquals(BitUtil.isBitSet(number, i), LongUtil.isBitSet(number, i));
            assertEquals(BitUtil.isBitSetSafe(number, i), LongUtil.isBitSet(number, i));
          }
        });
  }

  @Test
  public void isBitSetShort() {
    qt().forAll(SourceDSL.integers().between(Short.MIN_VALUE, Short.MAX_VALUE))
        .checkAssert(number -> {
          for (int i = 0; i < Short.SIZE; ++i) {
            assertEquals(
                BitUtil.isBitSet(number.shortValue(), i),
                ShortUtil.isBitSet(number.shortValue(), i));

            assertEquals(
                BitUtil.isBitSetSafe(number.shortValue(), i),
                ShortUtil.isBitSet(number.shortValue(), i));
          }
        });
  }

  @Test
  public void setBitInteger() {
    qt().forAll(SourceDSL.integers().all())
        .checkAssert(number -> {
          for (int i = 0; i < Integer.SIZE; ++i) {
            assertEquals(BitUtil.setBit(number, i), IntegerUtil.setBit(number, i));
            assertEquals(BitUtil.setBitSafe(number, i), IntegerUtil.setBit(number, i));
          }
        });
  }

  @Test
  public void setBitLong() {
    qt().forAll(SourceDSL.longs().all())
        .checkAssert(number -> {
          for (int i = 0; i < Long.SIZE; ++i) {
            assertEquals(BitUtil.setBit(number, i), LongUtil.setBit(number, i));
            assertEquals(BitUtil.setBitSafe(number, i), LongUtil.setBit(number, i));
          }
        });
  }

  @Test
  public void setBitShort() {
    qt().forAll(SourceDSL.integers().between(Short.MIN_VALUE, Short.MAX_VALUE))
        .checkAssert(number -> {
          for (int i = 0; i < Short.SIZE; ++i) {
            assertEquals(
                BitUtil.setBit(number.shortValue(), i),
                ShortUtil.setBit(number.shortValue(), i));

            assertEquals(
                BitUtil.setBitSafe(number.shortValue(), i),
                ShortUtil.setBit(number.shortValue(), i));
          }
        });
  }

  @Test
  public void clearBitInteger() {
    qt().forAll(SourceDSL.integers().all())
        .checkAssert(number -> {
          for (int i = 0; i < Integer.SIZE; ++i) {
            assertEquals(BitUtil.clearBit(number, i), IntegerUtil.clearBit(number, i));
            assertEquals(BitUtil.clearBitSafe(number, i), IntegerUtil.clearBit(number, i));
          }
        });
  }

  @Test
  public void clearBitLong() {
    qt().forAll(SourceDSL.longs().all())
        .checkAssert(number -> {
          for (int i = 0; i < Long.SIZE; ++i) {
            assertEquals(BitUtil.clearBit(number, i), LongUtil.clearBit(number, i));
            assertEquals(BitUtil.clearBitSafe(number, i), LongUtil.clearBit(number, i));
          }
        });
  }

  @Test
  public void clearBitShort() {
    qt().forAll(SourceDSL.integers().between(Short.MIN_VALUE, Short.MAX_VALUE))
        .checkAssert(number -> {
          for (int i = 0; i < Short.SIZE; ++i) {
            assertEquals(
                BitUtil.clearBit(number.shortValue(), i),
                ShortUtil.clearBit(number.shortValue(), i));

            assertEquals(
                BitUtil.clearBitSafe(number.shortValue(), i),
                ShortUtil.clearBit(number.shortValue(), i));
          }
        });
  }

  @Test
  public void clearHighBytesInteger() {
    qt().forAll(SourceDSL.integers().all())
        .checkAssert(number -> {
          for (int i = 0; i <= Integer.BYTES; ++i) {
            assertEquals(BitUtil.clearHighBytes(number, i), IntegerUtil.clearHighBytes(number, i));
            assertEquals(BitUtil.clearHighBytesSafe(number, i),
                         IntegerUtil.clearHighBytes(number, i));
          }
        });
  }

  @Test
  public void clearHighBytesLong() {
    qt().forAll(SourceDSL.longs().all())
        .checkAssert(number -> {
          for (int i = 0; i <= Long.BYTES; ++i) {
            assertEquals(BitUtil.clearHighBytes(number, i), LongUtil.clearHighBytes(number, i));
            assertEquals(BitUtil.clearHighBytesSafe(number, i),
                         LongUtil.clearHighBytes(number, i));
          }
        });
  }

  @Test
  public void clearHighBytesShort() {
    qt().forAll(SourceDSL.integers().between(Short.MIN_VALUE, Short.MAX_VALUE))
        .checkAssert(number -> {
          for (int i = 0; i <= Short.BYTES; ++i) {
            assertEquals(
                BitUtil.clearHighBytes(number.shortValue(), i),
                ShortUtil.clearHighBytes(number.shortValue(), i));

            assertEquals(
                BitUtil.clearHighBytesSafe(number.shortValue(), i),
                ShortUtil.clearHighBytes(number.shortValue(), i));
          }
        });
  }

  @Test
  public void numberOfBytesInteger() {
    qt().forAll(SourceDSL.integers().all())
        .checkAssert(number -> assertEquals(BitUtil.numberOfBytes(number),
            IntegerUtil.numberOfBytes(number)));
  }

  @Test
  public void numberOfBytesLong() {
    qt().forAll(SourceDSL.longs().all())
        .checkAssert(number -> assertEquals(BitUtil.numberOfBytes(number),
            LongUtil.numberOfBytes(number)));
  }

  @Test
  public void numberOfBytesShort() {
    qt().forAll(SourceDSL.integers().between(Short.MIN_VALUE, Short.MAX_VALUE))
        .checkAssert(number -> assertEquals(BitUtil.numberOfBytes(number.shortValue()),
            ShortUtil.numberOfBytes(number.shortValue())));
  }

  @Test
  public void getByteInteger() {
    qt().forAll(SourceDSL.integers().all())
        .checkAssert(number -> {
          for (int i = 0; i < Integer.BYTES; ++i) {
            assertEquals(BitUtil.getByte(number, i), IntegerUtil.getByte(number, i));
            assertEquals(BitUtil.getByteSafe(number, i), IntegerUtil.getByte(number, i));
          }
        });
  }

  @Test
  public void getByteLong() {
    qt().forAll(SourceDSL.longs().all())
        .checkAssert(number -> {
          for (int i = 0; i < Long.BYTES; ++i) {
            assertEquals(BitUtil.getByte(number, i), LongUtil.getByte(number, i));
            assertEquals(BitUtil.getByteSafe(number, i), LongUtil.getByte(number, i));
          }
        });
  }

  @Test
  public void getByteShort() {
    qt().forAll(SourceDSL.integers().between(Short.MIN_VALUE, Short.MAX_VALUE))
        .checkAssert(number -> {
          for (int i = 0; i < Short.BYTES; ++i) {
            assertEquals(
                BitUtil.getByte(number.shortValue(), i),
                ShortUtil.getByte(number.shortValue(), i));

            assertEquals(
                BitUtil.getByteSafe(number.shortValue(), i),
                ShortUtil.getByte(number.shortValue(), i));
          }
        });
  }
}