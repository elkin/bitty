package io.github.elkin.bitty;

public final class IntegerUtil {

  private static final int[] INT_MASKS = {
      0x1, 0x3, 0x7, 0xF,
      0x1F, 0x3F, 0x7F, 0xFF,
      0x1FF, 0x3FF, 0x7FF, 0xFFF,
      0x1FFF, 0x3FFF, 0x7FFF, 0xFFFF,
      0x1FFFF, 0x3FFFF, 0x7FFFF, 0xFFFFF,
      0x1FFFFF, 0x3FFFFF, 0x7FFFFF, 0xFFFFFF,
      0x1FFFFFF, 0x3FFFFFF, 0x7FFFFFF, 0xFFFFFFF,
      0x1FFFFFFF, 0x3FFFFFFF, 0x7FFFFFFF, 0xFFFFFFFF,

      0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF,
      0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF,
      0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF,
      0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF,
      0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF,
      0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF,
      0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF,
      0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF
  };

  private static final int[] BYTE_SLICE_MASKS = {
      0, 0xFF, 0xFFFF, 0xFFFFFF, 0xFFFFFFFF
  };

  private static final int[] BYTE_MASKS = {
      0xFF, 0xFF00, 0xFF0000, 0xFF000000
  };

  private static final int[] INT_BIT_MASKS = {
      0x1, 0x2, 0x4, 0x8,
      0x10, 0x20, 0x40, 0x80,
      0x100, 0x200, 0x400, 0x800,
      0x1000, 0x2000, 0x4000, 0x8000,
      0x10000, 0x20000, 0x40000, 0x80000,
      0x100000, 0x200000, 0x400000, 0x800000,
      0x1000000, 0x2000000, 0x4000000, 0x8000000,
      0x10000000, 0x20000000, 0x40000000, 0x80000000
  };

  private static final int[] INVERTED_INT_BIT_MASKS = {
      0xFFFFFFFE, 0xFFFFFFFD, 0xFFFFFFFB, 0xFFFFFFF7,
      0xFFFFFFEF, 0xFFFFFFDF, 0xFFFFFFBF, 0xFFFFFF7F,
      0xFFFFFEFF, 0xFFFFFDFF, 0xFFFFFBFF, 0xFFFFF7FF,
      0xFFFFEFFF, 0xFFFFDFFF, 0xFFFFBFFF, 0xFFFF7FFF,
      0xFFFEFFFF, 0xFFFDFFFF, 0xFFFBFFFF, 0xFFF7FFFF,
      0xFFEFFFFF, 0xFFDFFFFF, 0xFFBFFFFF, 0xFF7FFFFF,
      0xFEFFFFFF, 0xFDFFFFFF, 0xFBFFFFFF, 0xF7FFFFFF,
      0xEFFFFFFF, 0xDFFFFFFF, 0xBFFFFFFF, 0x7FFFFFFF,
  };

  private static void checkSliceAsserts(int startIndex, int stopIndex)
  {
    assert startIndex >= 0;
    assert startIndex < Integer.SIZE;
    assert stopIndex >= 0;
    assert stopIndex >= startIndex;
    assert stopIndex - startIndex <= Integer.SIZE;
  }

  private IntegerUtil() {
  }

  public static int getBitsSlice(int value, int startIndex, int stopIndex) {
    checkSliceAsserts(startIndex, stopIndex);
    return (value & INT_MASKS[stopIndex]) >>> startIndex;
  }

  public static int setBitsSlice(int value, int startIndex, int stopIndex) {
    checkSliceAsserts(startIndex, stopIndex);

    return value | (INT_MASKS[stopIndex - startIndex] << startIndex);
  }

  public static int clearBitsSlice(int value, int startIndex, int stopIndex) {
    checkSliceAsserts(startIndex, stopIndex);

    return value & (~(INT_MASKS[stopIndex - startIndex] << startIndex));
  }

  public static int getBit(int value, int index) {
    assert index >= 0;
    assert index < Integer.SIZE;
    return (value & INT_BIT_MASKS[index]) >>> index;
  }

  public static boolean isBitSet(int value, int index) {
    assert index >= 0;
    assert index < Integer.SIZE;
    return (value & INT_BIT_MASKS[index]) != 0;
  }

  public static int setBit(int value, int index) {
    assert index >= 0;
    assert index < Integer.SIZE;

    return value | INT_BIT_MASKS[index];
  }

  public static int clearBit(int value, int index) {
    assert index >= 0;
    assert index < Integer.SIZE;

    return value & INVERTED_INT_BIT_MASKS[index];
  }

  public static int numberOfBytes(int value) {
    int highestBit = Integer.highestOneBit(value);
    switch (highestBit) {
      case 0x80000000:
      case 0x40000000:
      case 0x20000000:
      case 0x10000000:
      case 0x8000000:
      case 0x4000000:
      case 0x2000000:
      case 0x1000000:
        return 4;

      case 0x800000:
      case 0x400000:
      case 0x200000:
      case 0x100000:
      case 0x80000:
      case 0x40000:
      case 0x20000:
      case 0x10000:
        return 3;

      case 0x8000:
      case 0x4000:
      case 0x2000:
      case 0x1000:
      case 0x800:
      case 0x400:
      case 0x200:
      case 0x100:
        return 2;

//                case 0x80:
//                case 0x40:
//                case 0x20:
//                case 0x10:
//                case 0x8:
//                case 0x4:
//                case 0x2:
//                case 0x1:
//                case 0x0:
      default:
        return 1;
    }
  }

  public static int clearHighBytes(int value, int numBytesToLeave) {
    assert numBytesToLeave >= 0;
    assert numBytesToLeave <= Integer.BYTES;

    return (value & BYTE_SLICE_MASKS[numBytesToLeave]);
  }

  public static byte getByte(int value, int index) {
    assert index >= 0;
    assert index < Integer.BYTES;

    return (byte) ((value & BYTE_MASKS[index]) >>> (index << 3));
  }
}
