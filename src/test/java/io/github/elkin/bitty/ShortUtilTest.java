package io.github.elkin.bitty;

import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.integers;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.testng.annotations.Test;

public class ShortUtilTest {

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