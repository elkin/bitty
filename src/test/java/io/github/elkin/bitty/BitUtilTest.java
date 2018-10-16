package io.github.elkin.bitty;

import static org.quicktheories.QuickTheory.qt;
import static org.testng.Assert.assertEquals;

import org.quicktheories.generators.SourceDSL;
import org.testng.annotations.Test;

public class BitUtilTest {

  @Test
  public void getBitsSliceInteger() {
    qt().forAll(SourceDSL.integers().all())
        .checkAssert(number -> {
          for (int start = 0; start < Integer.SIZE - 1; ++start) {
            for (int end = start + 1; end < Integer.SIZE; ++end) {
              assertEquals(
                  BitUtil.getBitsSlice(number, start, end),
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
          }
        });
  }

  @Test
  public void getBitLong() {
    qt().forAll(SourceDSL.longs().all())
        .checkAssert(number -> {
          for (int i = 0; i < Long.SIZE; ++i) {
            assertEquals(BitUtil.getBit(number, i), LongUtil.getBit(number, i));
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
          }
        });
  }

  @Test
  public void isBitSetInteger() {
    qt().forAll(SourceDSL.integers().all())
        .checkAssert(number -> {
          for (int i = 0; i < Integer.SIZE; ++i) {
            assertEquals(BitUtil.isBitSet(number, i), IntegerUtil.isBitSet(number, i));
          }
        });
  }

  @Test
  public void isBitSetLong() {
    qt().forAll(SourceDSL.longs().all())
        .checkAssert(number -> {
          for (int i = 0; i < Long.SIZE; ++i) {
            assertEquals(BitUtil.isBitSet(number, i), LongUtil.isBitSet(number, i));
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
          }
        });
  }

  @Test
  public void setBitInteger() {
    qt().forAll(SourceDSL.integers().all())
        .checkAssert(number -> {
          for (int i = 0; i < Integer.SIZE; ++i) {
            assertEquals(BitUtil.setBit(number, i), IntegerUtil.setBit(number, i));
          }
        });
  }

  @Test
  public void setBitLong() {
    qt().forAll(SourceDSL.longs().all())
        .checkAssert(number -> {
          for (int i = 0; i < Long.SIZE; ++i) {
            assertEquals(BitUtil.setBit(number, i), LongUtil.setBit(number, i));
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
          }
        });
  }

  @Test
  public void clearBitInteger() {
    qt().forAll(SourceDSL.integers().all())
        .checkAssert(number -> {
          for (int i = 0; i < Integer.SIZE; ++i) {
            assertEquals(BitUtil.clearBit(number, i), IntegerUtil.clearBit(number, i));
          }
        });
  }

  @Test
  public void clearBitLong() {
    qt().forAll(SourceDSL.longs().all())
        .checkAssert(number -> {
          for (int i = 0; i < Long.SIZE; ++i) {
            assertEquals(BitUtil.clearBit(number, i), LongUtil.clearBit(number, i));
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
          }
        });
  }

  @Test
  public void clearHighBytesInteger() {
    qt().forAll(SourceDSL.integers().all())
        .checkAssert(number -> {
          for (int i = 0; i <= Integer.BYTES; ++i) {
            assertEquals(BitUtil.clearHighBytes(number, i), IntegerUtil.clearHighBytes(number, i));
          }
        });
  }

  @Test
  public void clearHighBytesLong() {
    qt().forAll(SourceDSL.longs().all())
        .checkAssert(number -> {
          for (int i = 0; i <= Long.BYTES; ++i) {
            assertEquals(BitUtil.clearHighBytes(number, i), LongUtil.clearHighBytes(number, i));
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
          }
        });
  }

  @Test
  public void getByteLong() {
    qt().forAll(SourceDSL.longs().all())
        .checkAssert(number -> {
          for (int i = 0; i < Long.BYTES; ++i) {
            assertEquals(BitUtil.getByte(number, i), LongUtil.getByte(number, i));
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
          }
        });
  }
}