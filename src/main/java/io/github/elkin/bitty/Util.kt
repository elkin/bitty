package io.github.elkin.bitty

fun Int.getBitsSlice(startIndex: Int, stopIndex: Int): Int
{
    return IntegerUtil.getBitsSlice(this, startIndex, stopIndex)
}

fun Int.setBitsSLice(startIndex: Int, stopIndex: Int): Int{
    return IntegerUtil.setBitsSlice(this, startIndex, stopIndex)
}

fun Int.clearBitsSLice(startIndex: Int, stopIndex: Int): Int{
    return IntegerUtil.clearBitsSlice(this, startIndex, stopIndex)
}

fun Int.getBit(index: Int): Int
{
    return IntegerUtil.getBit(this, index)
}

fun Int.setBit(index: Int): Int
{
    return IntegerUtil.setBit(this, index)
}

fun Int.clearBit(index: Int): Int
{
    return IntegerUtil.clearBit(this, index)
}

fun Int.numberOfBytes(): Int
{
    return IntegerUtil.numberOfBytes(this)
}

fun Int.clearHighBytes(numBytes: Int): Int
{
    return IntegerUtil.clearHighBytes(this, numBytes)
}

fun Int.getByte(index: Int): Byte
{
    return IntegerUtil.getByte(this, index)
}

fun Long.getBitsSlice(startIndex: Int, stopIndex: Int): Long
{
    return LongUtil.getBitsSlice(this, startIndex, stopIndex)
}

fun Long.setBitsSLice(startIndex: Int, stopIndex: Int): Long
{
    return LongUtil.setBitsSlice(this, startIndex, stopIndex)
}

fun Long.clearBitsSLice(startIndex: Int, stopIndex: Int): Long
{
    return LongUtil.clearBitsSlice(this, startIndex, stopIndex)
}

fun Long.getBit(index: Int): Long
{
    return LongUtil.getBit(this, index)
}

fun Long.setBit(index: Int): Long
{
    return LongUtil.setBit(this, index)
}

fun Long.clearBit(index: Int): Long
{
    return LongUtil.clearBit(this, index)
}

fun Long.numberOfBytes(): Int
{
    return LongUtil.numberOfBytes(this)
}

fun Long.clearHighBytes(numBytes: Int): Long
{
    return LongUtil.clearHighBytes(this, numBytes)
}

fun Long.getByte(index: Int): Byte
{
    return LongUtil.getByte(this, index)
}

fun Short.getBitsSlice(startIndex: Int, stopIndex: Int): Short
{
    return ShortUtil.getBitsSlice(this, startIndex, stopIndex)
}

fun Short.setBitsSLice(startIndex: Int, stopIndex: Int): Short
{
    return ShortUtil.setBitsSlice(this, startIndex, stopIndex)
}

fun Short.clearBitsSLice(startIndex: Int, stopIndex: Int): Short
{
    return ShortUtil.clearBitsSlice(this, startIndex, stopIndex)
}

fun Short.getBit(index: Int): Short
{
    return ShortUtil.getBit(this, index)
}

fun Short.setBit(index: Int): Short
{
    return ShortUtil.setBit(this, index)
}

fun Short.clearBit(index: Int): Short
{
    return ShortUtil.clearBit(this, index)
}

fun Short.numberOfBytes(): Int
{
    return ShortUtil.numberOfBytes(this)
}

fun Short.clearHighBytes(numBytes: Int): Short
{
    return ShortUtil.clearHighBytes(this, numBytes)
}

fun Short.getByte(index: Int): Byte
{
    return ShortUtil.getByte(this, index)
}