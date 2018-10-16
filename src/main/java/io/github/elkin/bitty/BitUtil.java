package io.github.elkin.bitty;

public final class BitUtil {
  private BitUtil() {}

  public static int getBitsSlice(int value, int startIndex, int stopIndex) {
    return IntegerUtil.getBitsSlice(value, startIndex, stopIndex);
  }

  public static long getBitsSlice(long value, int startIndex, int stopIndex) {
    return LongUtil.getBitsSlice(value, startIndex, stopIndex);
  }

  public static short getBitsSlice(short value, int startIndex, int stopIndex) {
    return ShortUtil.getBitsSlice(value, startIndex, stopIndex);
  }

  public static int setBitsSlice(int value, int startIndex, int stopIndex) {
    return IntegerUtil.setBitsSlice(value, startIndex, stopIndex);
  }

  public static long setBitsSlice(long value, int startIndex, int stopIndex) {
    return LongUtil.setBitsSlice(value, startIndex, stopIndex);
  }

  public static short setBitsSlice(short value, int startIndex, int stopIndex) {
    return ShortUtil.setBitsSlice(value, startIndex, stopIndex);
  }

  public static int clearBitsSlice(int value, int startIndex, int stopIndex) {
    return IntegerUtil.clearBitsSlice(value, startIndex, stopIndex);
  }

  public static long clearBitsSlice(long value, int startIndex, int stopIndex) {
    return LongUtil.clearBitsSlice(value, startIndex, stopIndex);
  }

  public static short clearBitsSlice(short value, int startIndex, int stopIndex) {
    return ShortUtil.clearBitsSlice(value, startIndex, stopIndex);
  }

  public static int getBit(int value, int index) {
    return IntegerUtil.getBit(value, index);
  }

  public static long getBit(long value, int index) {
    return LongUtil.getBit(value, index);
  }

  public static short getBit(short value, int index) {
    return ShortUtil.getBit(value, index);
  }

  public static boolean isBitSet(int value, int index) {
    return IntegerUtil.isBitSet(value, index);
  }

  public static boolean isBitSet(long value, int index) {
    return LongUtil.isBitSet(value, index);
  }

  public static boolean isBitSet(short value, int index) {
    return ShortUtil.isBitSet(value, index);
  }

  public static int setBit(int value, int index) {
    return IntegerUtil.setBit(value, index);
  }

  public static long setBit(long value, int index) {
    return LongUtil.setBit(value, index);
  }

  public static int setBit(short value, int index) {
    return ShortUtil.setBit(value, index);
  }

  public static int clearBit(int value, int index) {
    return IntegerUtil.clearBit(value, index);
  }

  public static long clearBit(long value, int index) {
    return LongUtil.clearBit(value, index);
  }

  public static short clearBit(short value, int index) {
    return ShortUtil.clearBit(value, index);
  }

  public static int clearHighBytes(int value, int numBytes) {
    return IntegerUtil.clearHighBytes(value, numBytes);
  }

  public static long clearHighBytes(long value, int numBytes) {
    return LongUtil.clearHighBytes(value, numBytes);
  }

  public static short clearHighBytes(short value, int numBytes) {
    return ShortUtil.clearHighBytes(value, numBytes);
  }

  public static int numberOfBytes(int value) {
    return IntegerUtil.numberOfBytes(value);
  }

  public static int numberOfBytes(long value) {
    return LongUtil.numberOfBytes(value);
  }

  public static int numberOfBytes(short value) {
    return ShortUtil.numberOfBytes(value);
  }

  public static byte getByte(int value, int index) {
    return IntegerUtil.getByte(value, index);
  }

  public static byte getByte(long value, int index) {
    return LongUtil.getByte(value, index);
  }

  public static byte getByte(short value, int index) {
    return ShortUtil.getByte(value, index);
  }
}
