package io.github.elkin.bitty

fun Int.getBitsSlice(startIndex: Int, stopIndex: Int): Int
{
    return IntegerUtil.getBitsSlice(this, startIndex, stopIndex)
}