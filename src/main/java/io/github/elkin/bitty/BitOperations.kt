package io.github.elkin.bitty

fun Int.getBitsSlice(startIndex: Int, stopIndex: Int) = IntegerUtil.getBitsSlice(this, startIndex, stopIndex)

fun Int.getBitsSliceSafe(startIndex: Int, stopIndex: Int) = IntegerUtil.getBitsSliceSafe(this, startIndex, stopIndex)

fun Int.setBitsSlice(startIndex: Int, stopIndex: Int) = IntegerUtil.setBitsSlice(this, startIndex, stopIndex)

fun Int.setBitsSliceSafe(startIndex: Int, stopIndex: Int) = IntegerUtil.setBitsSliceSafe(this, startIndex, stopIndex)

fun Int.clearBitsSlice(startIndex: Int, stopIndex: Int) = IntegerUtil.clearBitsSlice(this, startIndex, stopIndex)

fun Int.clearBitsSliceSafe(startIndex: Int, stopIndex: Int) = IntegerUtil.clearBitsSliceSafe(this, startIndex, stopIndex)

fun Int.getBit(index: Int) = IntegerUtil.getBit(this, index)

fun Int.getBitSafe(index: Int) = IntegerUtil.getBitSafe(this, index)

fun Int.setBit(index: Int) = IntegerUtil.setBit(this, index)

fun Int.setBitSafe(index: Int) = IntegerUtil.setBitSafe(this, index)

fun Int.clearBit(index: Int) = IntegerUtil.clearBit(this, index)

fun Int.clearBitSafe(index: Int) = IntegerUtil.clearBitSafe(this, index)

fun Int.isBitSet(index: Int) = IntegerUtil.isBitSet(this, index)

fun Int.isBitSetSafe(index: Int) = IntegerUtil.isBitSetSafe(this, index)

fun Int.numberOfBytes() = IntegerUtil.numberOfBytes(this)

fun Int.clearHighBytes(numBytesToLeave: Int) = IntegerUtil.clearHighBytes(this, numBytesToLeave)

fun Int.clearHighBytesSafe(numBytesToLeave: Int) = IntegerUtil.clearHighBytesSafe(this, numBytesToLeave)

fun Int.getByte(index: Int) = IntegerUtil.getByte(this, index)

fun Int.getByteSafe(index: Int) = IntegerUtil.getByteSafe(this, index)

fun Long.getBitsSlice(startIndex: Int, stopIndex: Int) = LongUtil.getBitsSlice(this, startIndex, stopIndex)

fun Long.getBitsSliceSafe(startIndex: Int, stopIndex: Int) = LongUtil.getBitsSliceSafe(this, startIndex, stopIndex)

fun Long.setBitsSlice(startIndex: Int, stopIndex: Int) = LongUtil.setBitsSlice(this, startIndex, stopIndex)

fun Long.setBitsSliceSafe(startIndex: Int, stopIndex: Int) = LongUtil.setBitsSliceSafe(this, startIndex, stopIndex)

fun Long.clearBitsSlice(startIndex: Int, stopIndex: Int) = LongUtil.clearBitsSlice(this, startIndex, stopIndex)

fun Long.clearBitsSliceSafe(startIndex: Int, stopIndex: Int) = LongUtil.clearBitsSliceSafe(this, startIndex, stopIndex)

fun Long.getBit(index: Int) = LongUtil.getBit(this, index)

fun Long.getBitSafe(index: Int) = LongUtil.getBitSafe(this, index)

fun Long.setBit(index: Int) = LongUtil.setBit(this, index)

fun Long.setBitSafe(index: Int) = LongUtil.setBitSafe(this, index)

fun Long.clearBit(index: Int) = LongUtil.clearBit(this, index)

fun Long.clearBitSafe(index: Int) = LongUtil.clearBitSafe(this, index)

fun Long.isBitSet(index: Int) = LongUtil.isBitSet(this, index)

fun Long.isBitSetSafe(index: Int) = LongUtil.isBitSetSafe(this, index)

fun Long.numberOfBytes() = LongUtil.numberOfBytes(this)

fun Long.clearHighBytes(numBytesToLeave: Int) = LongUtil.clearHighBytes(this, numBytesToLeave)

fun Long.clearHighBytesSafe(numBytesToLeave: Int) = LongUtil.clearHighBytesSafe(this, numBytesToLeave)

fun Long.getByte(index: Int) = LongUtil.getByte(this, index)

fun Long.getByteSafe(index: Int) = LongUtil.getByteSafe(this, index)

fun Short.getBitsSlice(startIndex: Int, stopIndex: Int) = ShortUtil.getBitsSlice(this, startIndex, stopIndex)

fun Short.getBitsSliceSafe(startIndex: Int, stopIndex: Int) = ShortUtil.getBitsSliceSafe(this, startIndex, stopIndex)

fun Short.setBitsSlice(startIndex: Int, stopIndex: Int) = ShortUtil.setBitsSlice(this, startIndex, stopIndex)

fun Short.setBitsSliceSafe(startIndex: Int, stopIndex: Int) = ShortUtil.setBitsSliceSafe(this, startIndex, stopIndex)

fun Short.clearBitsSlice(startIndex: Int, stopIndex: Int) = ShortUtil.clearBitsSlice(this, startIndex, stopIndex)

fun Short.clearBitsSliceSafe(startIndex: Int, stopIndex: Int) =
        ShortUtil.clearBitsSliceSafe(this, startIndex, stopIndex)

fun Short.getBit(index: Int) = ShortUtil.getBit(this, index)

fun Short.getBitSafe(index: Int) = ShortUtil.getBitSafe(this, index)

fun Short.setBit(index: Int) = ShortUtil.setBit(this, index)

fun Short.setBitSafe(index: Int) = ShortUtil.setBitSafe(this, index)

fun Short.clearBit(index: Int) = ShortUtil.clearBit(this, index)

fun Short.clearBitSafe(index: Int) = ShortUtil.clearBitSafe(this, index)

fun Short.isBitSet(index: Int) = ShortUtil.isBitSet(this, index)

fun Short.isBitSetSafe(index: Int) = ShortUtil.isBitSetSafe(this, index)

fun Short.numberOfBytes() = ShortUtil.numberOfBytes(this)

fun Short.clearHighBytes(numBytesToLeave: Int) = ShortUtil.clearHighBytes(this, numBytesToLeave)

fun Short.clearHighBytesSafe(numBytesToLeave: Int) = ShortUtil.clearHighBytesSafe(this, numBytesToLeave)

fun Short.getByte(index: Int) = ShortUtil.getByte(this, index)

fun Short.getByteSafe(index: Int) = ShortUtil.getByteSafe(this, index)
