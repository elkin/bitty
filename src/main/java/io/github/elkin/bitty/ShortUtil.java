package io.github.elkin.bitty;

public final class ShortUtil {

  private static final int[] SHORT_MASKS = {
      0x1, 0x3, 0x7, 0xF,
      0x1F, 0x3F, 0x7F, 0xFF,
      0x1FF, 0x3FF, 0x7FF, 0xFFF,
      0x1FFF, 0x3FFF, 0x7FFF, 0xFFFF,

      0xFFFF, 0xFFFF, 0xFFFF, 0xFFFF,
      0xFFFF, 0xFFFF, 0xFFFF, 0xFFFF,
      0xFFFF, 0xFFFF, 0xFFFF, 0xFFFF,
      0xFFFF, 0xFFFF, 0xFFFF, 0xFFFF
  };

  private static final int[] BYTE_SLICE_MASKS = {0, 0xFF, 0xFFFF};

  private static final int[] BYTE_MASKS = {0xFF, 0xFF00};

  private static final int[] SHORT_BIT_MASKS = {
      0x1, 0x2, 0x4, 0x8,
      0x10, 0x20, 0x40, 0x80,
      0x100, 0x200, 0x400, 0x800,
      0x1000, 0x2000, 0x4000, 0x8000,
  };

  private static final int[] INVERTED_SHORT_BIT_MASKS = {
      0xFFFE, 0xFFFD, 0xFFFB, 0xFFF7,
      0xFFEF, 0xFFDF, 0xFFBF, 0xFF7F,
      0xFEFF, 0xFDFF, 0xFBFF, 0xF7FF,
      0xEFFF, 0xDFFF, 0xBFFF, 0x7FFF,
  };

  private static void checkSliceAsserts(int startIndex, int stopIndex)
  {
    assert startIndex >= 0;
    assert startIndex < Short.SIZE;
    assert stopIndex >= 0;
    assert stopIndex >= startIndex;
    assert stopIndex - startIndex <= Short.SIZE;
  }

  private ShortUtil() {
  }

  public static short getBitsSlice(short value, int startIndex, int stopIndex) {
    checkSliceAsserts(startIndex, stopIndex);

    // it's very important to evaluate expression in the braces firstly
    // otherwise result value will be incorrectly evaluated.
    return (short) ((value & SHORT_MASKS[stopIndex]) >>> startIndex);
  }

  public static short setBitsSlice(short value, int startIndex, int stopIndex) {
    checkSliceAsserts(startIndex, stopIndex);

    return (short) (value | (SHORT_MASKS[stopIndex - startIndex] << startIndex));
  }

  public static short clearBitsSlice(int value, int startIndex, int stopIndex) {
    checkSliceAsserts(startIndex, stopIndex);

    return (short) (value & (~(SHORT_MASKS[stopIndex - startIndex] << startIndex)));
  }

  public static short getBit(short value, int index) {
    assert index >= 0;
    assert index < Short.SIZE;
    return (short) ((value & SHORT_BIT_MASKS[index]) >>> index);
  }

  public static boolean isBitSet(short value, int index) {
    assert index >= 0;
    assert index < Short.SIZE;
    return (value & SHORT_BIT_MASKS[index]) != 0;
  }

  public static short setBit(short value, int index) {
    assert index >= 0;
    assert index < Short.SIZE;

    return (short) (value | SHORT_BIT_MASKS[index]);
  }

  public static short clearBit(short value, int index) {
    assert index >= 0;
    assert index < Short.SIZE;

    return (short) (value & INVERTED_SHORT_BIT_MASKS[index]);
  }

  public static int numberOfBytes(short value) {
    int highestBit = Integer.highestOneBit(value & 0xFFFF);
    switch (highestBit) {
      case 0x8000:
      case 0x4000:
      case 0x2000:
      case 0x1000:
      case 0x800:
      case 0x400:
      case 0x200:
      case 0x100:
        return 2;

      default:
        return 1;
    }
  }

  public static short clearHighBytes(short value, int numBytes) {
    assert numBytes >= 0;
    assert numBytes <= Short.BYTES;

    return (short) (value & BYTE_SLICE_MASKS[numBytes]);
  }

  public static byte getByte(short value, int index) {
    assert index >= 0;
    assert index < Short.BYTES;

    return (byte) ((value & BYTE_MASKS[index]) >>> (index << 3));
  }
}
