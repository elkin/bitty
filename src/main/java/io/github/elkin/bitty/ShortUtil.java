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


  private static void checkSliceIndexes(int startIndex, int stopIndex)
  {
    if (startIndex < 0 || startIndex >= Short.SIZE) {
      throw new IllegalArgumentException(
          "startIndex parameter must be in the range [0, 15], but it's equal to " + startIndex);
    }

    if ((stopIndex < 0) || (stopIndex < startIndex) || (stopIndex - startIndex) > Short.SIZE) {
      throw new IllegalArgumentException(
          String.format(
              "stopIndex parameter must be in the range [%d, %d], but it's equal to %d",
              startIndex,
              startIndex + Short.SIZE,
              stopIndex));
    }
  }

  private static void checkBitIndex(int index) {
    if (index < 0 || index >= Short.SIZE) {
      throw new IllegalArgumentException(
          String.format(
              "index parameter must be in the range[0, %d], but it's equal to %d",
              Short.SIZE - 1,
              index));
    }
  }


  private ShortUtil() {
  }

  public static short getBitsSlice(short value, int startIndex, int stopIndex) {
    return (short) ((value & SHORT_MASKS[stopIndex]) >>> startIndex);
  }

  public static short getBitsSliceSafe(short value, int startIndex, int stopIndex) {
    checkSliceIndexes(startIndex, stopIndex);

    return getBitsSlice(value, startIndex, stopIndex);
  }

  public static short setBitsSlice(short value, int startIndex, int stopIndex) {
    return (short) (value | (SHORT_MASKS[stopIndex - startIndex] << startIndex));
  }

  public static short setBitsSliceSafe(short value, int startIndex, int stopIndex) {
    checkSliceIndexes(startIndex, stopIndex);

    return setBitsSlice(value, startIndex, stopIndex);
  }

  public static short clearBitsSlice(short value, int startIndex, int stopIndex) {
    return (short) (value & (~(SHORT_MASKS[stopIndex - startIndex] << startIndex)));
  }

  public static short clearBitsSliceSafe(short value, int startIndex, int stopIndex) {
    checkSliceIndexes(startIndex, stopIndex);

    return clearBitsSlice(value, startIndex, stopIndex);
  }

  public static short getBit(short value, int index) {
    return (short) ((value & SHORT_BIT_MASKS[index]) >>> index);
  }

  public static short getBitSafe(short value, int index) {
    checkBitIndex(index);
    return getBit(value, index);
  }

  public static boolean isBitSet(short value, int index) {
    return (value & SHORT_BIT_MASKS[index]) != 0;
  }

  public static boolean isBitSetSafe(short value, int index) {
    checkBitIndex(index);
    return isBitSet(value, index);
  }

  public static short setBit(short value, int index) {
    return (short) (value | SHORT_BIT_MASKS[index]);
  }

  public static short setBitSafe(short value, int index) {
    checkBitIndex(index);
    return setBit(value, index);
  }

  public static short clearBit(short value, int index) {
    return (short) (value & INVERTED_SHORT_BIT_MASKS[index]);
  }

  public static short clearBitSafe(short value, int index) {
    checkBitIndex(index);
    return clearBit(value, index);
  }

  public static int numberOfBytes(short value) {
    if (value < 0) {
      return 2;
    }

    if (value <= 0xFF) {
      return 1;
    }

    return 2;
  }

  public static short clearHighBytes(short value, int numBytesToLeave) {
    return (short) (value & BYTE_SLICE_MASKS[numBytesToLeave]);
  }

  public static short clearHighBytesSafe(short value, int numBytesToLeave) {
    if (numBytesToLeave < 0 || numBytesToLeave > Short.BYTES) {
      throw new IllegalArgumentException(
          "numberOfBytesToLeave parameter must be in the range [0, 8], but it's equal to "
              + numBytesToLeave);
    }

    return clearHighBytes(value, numBytesToLeave);
  }

  public static byte getByte(short value, int index) {
    if (index == 0) {
      return (byte) value;
    } else {
        return (byte)(value >>> Byte.SIZE);
    }
  }

  public static byte getByteSafe(short value, int index) {
    if (index < 0 || index >= Short.BYTES) {
      throw new IllegalArgumentException(
          "index parameter must be in the range [0, 1], but it's equal to " + index);
    }

    return getByte(value, index);
  }
}
