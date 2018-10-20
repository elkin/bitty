package io.github.elkin.bitty

fun Int.getBitsSlice(startIndex: Int, stopIndex: Int) = IntegerUtil.getBitsSlice(this, startIndex, stopIndex)

fun Int.setBitsSlice(startIndex: Int, stopIndex: Int) = IntegerUtil.setBitsSlice(this, startIndex, stopIndex)

fun Int.clearBitsSlice(startIndex: Int, stopIndex: Int) = IntegerUtil.clearBitsSlice(this, startIndex, stopIndex)

fun Int.getBit(index: Int) = IntegerUtil.getBit(this, index)

fun Int.setBit(index: Int) = IntegerUtil.setBit(this, index)

fun Int.clearBit(index: Int) = IntegerUtil.clearBit(this, index)

fun Int.isBitSet(index: Int) = IntegerUtil.isBitSet(this, index)

fun Int.numberOfBytes() = IntegerUtil.numberOfBytes(this)

fun Int.clearHighBytes(numBytesToLeave: Int) = IntegerUtil.clearHighBytes(this, numBytesToLeave)

fun Int.getByte(index: Int) = IntegerUtil.getByte(this, index)

fun Long.getBitsSlice(startIndex: Int, stopIndex: Int) = LongUtil.getBitsSlice(this, startIndex, stopIndex)

fun Long.setBitsSlice(startIndex: Int, stopIndex: Int) = LongUtil.setBitsSlice(this, startIndex, stopIndex)

fun Long.clearBitsSlice(startIndex: Int, stopIndex: Int) = LongUtil.clearBitsSlice(this, startIndex, stopIndex)

fun Long.getBit(index: Int) = LongUtil.getBit(this, index)

fun Long.setBit(index: Int) = LongUtil.setBit(this, index)

fun Long.clearBit(index: Int) = LongUtil.clearBit(this, index)

fun Long.isBitSet(index: Int) = LongUtil.isBitSet(this, index)

fun Long.numberOfBytes() = LongUtil.numberOfBytes(this)

fun Long.clearHighBytes(numBytesToLeave: Int) = LongUtil.clearHighBytes(this, numBytesToLeave)

fun Long.getByte(index: Int) = LongUtil.getByte(this, index)

fun Short.getBitsSlice(startIndex: Int, stopIndex: Int) = ShortUtil.getBitsSlice(this, startIndex, stopIndex)

fun Short.setBitsSlice(startIndex: Int, stopIndex: Int) = ShortUtil.setBitsSlice(this, startIndex, stopIndex)

fun Short.clearBitsSlice(startIndex: Int, stopIndex: Int) = ShortUtil.clearBitsSlice(this, startIndex, stopIndex)

fun Short.getBit(index: Int) = ShortUtil.getBit(this, index)

fun Short.setBit(index: Int) = ShortUtil.setBit(this, index)

fun Short.clearBit(index: Int) = ShortUtil.clearBit(this, index)

fun Short.isBitSet(index: Int) = ShortUtil.isBitSet(this, index)

fun Short.numberOfBytes() = ShortUtil.numberOfBytes(this)

fun Short.clearHighBytes(numBytesToLeave: Int) = ShortUtil.clearHighBytes(this, numBytesToLeave)

fun Short.getByte(index: Int) = ShortUtil.getByte(this, index)
