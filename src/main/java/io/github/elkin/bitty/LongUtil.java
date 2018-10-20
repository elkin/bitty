package io.github.elkin.bitty;

public final class LongUtil {

  private static final long[] LONG_MASKS = {
      0x1L, 0x3L, 0x7L, 0xFL,
      0x1FL, 0x3FL, 0x7FL, 0xFFL,
      0x1FFL, 0x3FFL, 0x7FFL, 0xFFFL,
      0x1FFFL, 0x3FFFL, 0x7FFFL, 0xFFFFL,
      0x1FFFFL, 0x3FFFFL, 0x7FFFFL, 0xFFFFFL,
      0x1FFFFFL, 0x3FFFFFL, 0x7FFFFFL, 0xFFFFFFL,
      0x1FFFFFFL, 0x3FFFFFFL, 0x7FFFFFFL, 0xFFFFFFFL,
      0x1FFFFFFFL, 0x3FFFFFFFL, 0x7FFFFFFFL, 0xFFFFFFFFL,
      0x1FFFFFFFFL, 0x3FFFFFFFFL, 0x7FFFFFFFFL, 0xFFFFFFFFFL,
      0x1FFFFFFFFFL, 0x3FFFFFFFFFL, 0x7FFFFFFFFFL, 0xFFFFFFFFFFL,
      0x1FFFFFFFFFFL, 0x3FFFFFFFFFFL, 0x7FFFFFFFFFFL, 0xFFFFFFFFFFFL,
      0x1FFFFFFFFFFFL, 0x3FFFFFFFFFFFL, 0x7FFFFFFFFFFFL, 0xFFFFFFFFFFFFL,
      0x1FFFFFFFFFFFFL, 0x3FFFFFFFFFFFFL, 0x7FFFFFFFFFFFFL, 0xFFFFFFFFFFFFFL,
      0x1FFFFFFFFFFFFFL, 0x3FFFFFFFFFFFFFL, 0x7FFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFL,
      0x1FFFFFFFFFFFFFFL, 0x3FFFFFFFFFFFFFFL, 0x7FFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFL,
      0x1FFFFFFFFFFFFFFFL, 0x3FFFFFFFFFFFFFFFL, 0x7FFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,

      0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
      0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
      0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
      0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
      0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
      0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
      0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
      0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
      0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
      0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
      0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
      0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
      0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
      0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
      0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
      0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL,
  };

  private static final long[] LONG_BIT_MASKS = {
      0x1L, 0x2L, 0x4L, 0x8L,
      0x10L, 0x20L, 0x40L, 0x80L,
      0x100L, 0x200L, 0x400L, 0x800L,
      0x1000L, 0x2000L, 0x4000L, 0x8000L,
      0x10000L, 0x20000L, 0x40000L, 0x80000L,
      0x100000L, 0x200000L, 0x400000L, 0x800000L,
      0x1000000L, 0x2000000L, 0x4000000L, 0x8000000L,
      0x10000000L, 0x20000000L, 0x40000000L, 0x80000000L,
      0x100000000L, 0x200000000L, 0x400000000L, 0x800000000L,
      0x1000000000L, 0x2000000000L, 0x4000000000L, 0x8000000000L,
      0x10000000000L, 0x20000000000L, 0x40000000000L, 0x80000000000L,
      0x100000000000L, 0x200000000000L, 0x400000000000L, 0x800000000000L,
      0x1000000000000L, 0x2000000000000L, 0x4000000000000L, 0x8000000000000L,
      0x10000000000000L, 0x20000000000000L, 0x40000000000000L, 0x80000000000000L,
      0x100000000000000L, 0x200000000000000L, 0x400000000000000L, 0x800000000000000L,
      0x1000000000000000L, 0x2000000000000000L, 0x4000000000000000L, 0x8000000000000000L
  };

  private static final long[] INVERTED_LONG_BIT_MASKS = {
      0xFFFFFFFFFFFFFFFEL, 0xFFFFFFFFFFFFFFFDL, 0xFFFFFFFFFFFFFFFBL, 0xFFFFFFFFFFFFFFF7L,
      0xFFFFFFFFFFFFFFEFL, 0xFFFFFFFFFFFFFFDFL, 0xFFFFFFFFFFFFFFBFL, 0xFFFFFFFFFFFFFF7FL,
      0xFFFFFFFFFFFFFEFFL, 0xFFFFFFFFFFFFFDFFL, 0xFFFFFFFFFFFFFBFFL, 0xFFFFFFFFFFFFF7FFL,
      0xFFFFFFFFFFFFEFFFL, 0xFFFFFFFFFFFFDFFFL, 0xFFFFFFFFFFFFBFFFL, 0xFFFFFFFFFFFF7FFFL,
      0xFFFFFFFFFFFEFFFFL, 0xFFFFFFFFFFFDFFFFL, 0xFFFFFFFFFFFBFFFFL, 0xFFFFFFFFFFF7FFFFL,
      0xFFFFFFFFFFEFFFFFL, 0xFFFFFFFFFFDFFFFFL, 0xFFFFFFFFFFBFFFFFL, 0xFFFFFFFFFF7FFFFFL,
      0xFFFFFFFFFEFFFFFFL, 0xFFFFFFFFFDFFFFFFL, 0xFFFFFFFFFBFFFFFFL, 0xFFFFFFFFF7FFFFFFL,
      0xFFFFFFFFEFFFFFFFL, 0xFFFFFFFFDFFFFFFFL, 0xFFFFFFFFBFFFFFFFL, 0xFFFFFFFF7FFFFFFFL,
      0xFFFFFFFEFFFFFFFFL, 0xFFFFFFFDFFFFFFFFL, 0xFFFFFFFBFFFFFFFFL, 0xFFFFFFF7FFFFFFFFL,
      0xFFFFFFEFFFFFFFFFL, 0xFFFFFFDFFFFFFFFFL, 0xFFFFFFBFFFFFFFFFL, 0xFFFFFF7FFFFFFFFFL,
      0xFFFFFEFFFFFFFFFFL, 0xFFFFFDFFFFFFFFFFL, 0xFFFFFBFFFFFFFFFFL, 0xFFFFF7FFFFFFFFFFL,
      0xFFFFEFFFFFFFFFFFL, 0xFFFFDFFFFFFFFFFFL, 0xFFFFBFFFFFFFFFFFL, 0xFFFF7FFFFFFFFFFFL,
      0xFFFEFFFFFFFFFFFFL, 0xFFFDFFFFFFFFFFFFL, 0xFFFBFFFFFFFFFFFFL, 0xFFF7FFFFFFFFFFFFL,
      0xFFEFFFFFFFFFFFFFL, 0xFFDFFFFFFFFFFFFFL, 0xFFBFFFFFFFFFFFFFL, 0xFF7FFFFFFFFFFFFFL,
      0xFEFFFFFFFFFFFFFFL, 0xFDFFFFFFFFFFFFFFL, 0xFBFFFFFFFFFFFFFFL, 0xF7FFFFFFFFFFFFFFL,
      0xEFFFFFFFFFFFFFFFL, 0xDFFFFFFFFFFFFFFFL, 0xBFFFFFFFFFFFFFFFL, 0x7FFFFFFFFFFFFFFFL
  };

  private static final long[] BYTE_SLICE_MASKS = {
      0L, 0xFFL, 0xFFFFL, 0xFFFFFFL, 0xFFFFFFFFL,
      0xFFFFFFFFFFL, 0xFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL
  };

  private static final long[] BYTE_MASKS = {
      0xFFL, 0xFF00L, 0xFF0000L, 0xFF000000L,
      0xFF00000000L, 0xFF0000000000L, 0xFF000000000000L, 0xFF00000000000000L
  };

  private static void checkSliceAsserts(int startIndex, int stopIndex)
  {
    assert startIndex >= 0;
    assert startIndex < Long.SIZE;
    assert stopIndex >= 0;
    assert stopIndex >= startIndex;
    assert stopIndex - startIndex <= Long.SIZE;
  }

  private LongUtil() {
  }

  public static long getBitsSlice(long value, int startIndex, int stopIndex) {
    checkSliceAsserts(startIndex, stopIndex);

    return (value & LONG_MASKS[stopIndex]) >>> startIndex;
  }

  public static long setBitsSlice(long value, int startIndex, int stopIndex) {
    checkSliceAsserts(startIndex, stopIndex);

    return value | (LONG_MASKS[stopIndex - startIndex] << startIndex);
  }

  public static long clearBitsSlice(long value, int startIndex, int stopIndex) {
    checkSliceAsserts(startIndex, stopIndex);

    return value & (~(LONG_MASKS[stopIndex - startIndex] << startIndex));
  }

  public static long getBit(long value, int index) {
    assert index >= 0;
    assert index < Long.SIZE;
    return (value & LONG_BIT_MASKS[index]) >>> index;
  }

  public static boolean isBitSet(long value, int index) {
    assert index >= 0;
    assert index < Long.SIZE;
    return (value & LONG_BIT_MASKS[index]) != 0;
  }

  public static int numberOfBytes(long value) {
    int numZeros = Long.numberOfLeadingZeros(value);
    switch (numZeros) {
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
        return Long.BYTES;

      case 8:
      case 9:
      case 10:
      case 11:
      case 12:
      case 13:
      case 14:
      case 15:
        return Long.BYTES - 1;

      case 16:
      case 17:
      case 18:
      case 19:
      case 20:
      case 21:
      case 22:
      case 23:
        return Long.BYTES - 2;

      case 24:
      case 25:
      case 26:
      case 27:
      case 28:
      case 29:
      case 30:
      case 31:
        return Long.BYTES - 3;

      case 32:
      case 33:
      case 34:
      case 35:
      case 36:
      case 37:
      case 38:
      case 39:
        return Long.BYTES - 4;

      case 40:
      case 41:
      case 42:
      case 43:
      case 44:
      case 45:
      case 46:
      case 47:
        return Long.BYTES - 5;

      case 48:
      case 49:
      case 50:
      case 51:
      case 52:
      case 53:
      case 54:
      case 55:
        return Long.BYTES - 6;

//                case 56:
//                case 57:
//                case 58:
//                case 59:
//                case 60:
//                case 61:
//                case 62:
//                case 63:
//                case 64:
      default:
        return 1; // Long.BYTES - 7
    }
  }

  public static long setBit(long value, int index) {
    assert index >= 0;
    assert index < Long.SIZE;
    return value | LONG_BIT_MASKS[index];
  }

  public static long clearBit(long value, int index) {
    assert index >= 0;
    assert index < Long.SIZE;

    return value & INVERTED_LONG_BIT_MASKS[index];
  }

  public static byte getByte(long value, int index) {
    assert index >= 0;
    assert index < Long.BYTES;

    return (byte) ((value & BYTE_MASKS[index]) >>> (index << 3));
  }

  public static long clearHighBytes(long value, int numBytesToLeave) {
    assert numBytesToLeave >= 0;
    assert numBytesToLeave <= Long.BYTES;

    return (value & BYTE_SLICE_MASKS[numBytesToLeave]);
  }
}

