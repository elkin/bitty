package io.github.elkin.bitty

fun Int.getBitsSlice(startIndex: Int, stopIndex: Int) = IntegerUtil.getBitsSlice(this, startIndex, stopIndex)

fun Int.setBitsSLice(startIndex: Int, stopIndex: Int) = IntegerUtil.setBitsSlice(this, startIndex, stopIndex)

fun Int.clearBitsSLice(startIndex: Int, stopIndex: Int) = IntegerUtil.clearBitsSlice(this, startIndex, stopIndex)

fun Int.getBit(index: Int) = IntegerUtil.getBit(this, index)

fun Int.setBit(index: Int) = IntegerUtil.setBit(this, index)

fun Int.clearBit(index: Int) = IntegerUtil.clearBit(this, index)

fun Int.numberOfBytes() = IntegerUtil.numberOfBytes(this)

fun Int.clearHighBytes(numBytes: Int) = IntegerUtil.clearHighBytes(this, numBytes)

fun Int.getByte(index: Int) = IntegerUtil.getByte(this, index)

fun Long.getBitsSlice(startIndex: Int, stopIndex: Int) = LongUtil.getBitsSlice(this, startIndex, stopIndex)

fun Long.setBitsSLice(startIndex: Int, stopIndex: Int) = LongUtil.setBitsSlice(this, startIndex, stopIndex)

fun Long.clearBitsSLice(startIndex: Int, stopIndex: Int) = LongUtil.clearBitsSlice(this, startIndex, stopIndex)

fun Long.getBit(index: Int) = LongUtil.getBit(this, index)

fun Long.setBit(index: Int) = LongUtil.setBit(this, index)

fun Long.clearBit(index: Int) = LongUtil.clearBit(this, index)

fun Long.numberOfBytes() = LongUtil.numberOfBytes(this)

fun Long.clearHighBytes(numBytes: Int) = LongUtil.clearHighBytes(this, numBytes)

fun Long.getByte(index: Int) = LongUtil.getByte(this, index)

fun Short.getBitsSlice(startIndex: Int, stopIndex: Int) = ShortUtil.getBitsSlice(this, startIndex, stopIndex)

fun Short.setBitsSLice(startIndex: Int, stopIndex: Int) = ShortUtil.setBitsSlice(this, startIndex, stopIndex)

fun Short.clearBitsSLice(startIndex: Int, stopIndex: Int) = ShortUtil.clearBitsSlice(this, startIndex, stopIndex)

fun Short.getBit(index: Int) = ShortUtil.getBit(this, index)

fun Short.setBit(index: Int) = ShortUtil.setBit(this, index)

fun Short.clearBit(index: Int) = ShortUtil.clearBit(this, index)

fun Short.numberOfBytes() = ShortUtil.numberOfBytes(this)

fun Short.clearHighBytes(numBytes: Int) = ShortUtil.clearHighBytes(this, numBytes)

fun Short.getByte(index: Int) = ShortUtil.getByte(this, index)
