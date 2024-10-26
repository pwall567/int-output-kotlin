/*
 * @(#) IntOutputKotlin.kt
 *
 * int-output-kotlin  Kotlin interface to integer output functions
 * Copyright (c) 2024 Peter Wall
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package net.pwall.util

/**
 * Append an `Int` left-trimmed to an [Appendable].  This method outputs the digits left to right, avoiding the need to
 * allocate a separate object to hold the string form.
 */
fun Appendable.appendInt(i: Int) {
    IntOutput.appendInt(this, i)
}

/**
 * Append a positive `Int` left-trimmed to an [Appendable].    This method outputs the digits left to right, avoiding
 * the need to allocate a separate object to hold the string form.
 */
fun Appendable.appendPositiveInt(i: Int) {
    IntOutput.appendPositiveInt(this, i)
}

/**
 * Append an unsigned `Int` left-trimmed to an [Appendable].    This method outputs the digits left to right, avoiding
 * the need to allocate a separate object to hold the string form.
 */
fun Appendable.appendUnsignedInt(i: Int) {
    IntOutput.appendUnsignedInt(this, i)
}

/**
 * Append an `Int` left-trimmed to an [Appendable], using a scale parameter to indicate the number of decimal places.
 * This method outputs the digits left to right, avoiding the need to allocate a separate object to hold the string
 * form.
 *
 * Negative scale values (indicating that decimal point is to the right of the last digit) are ignored.  It is left to
 * the user to decide whether to output additional zeros following the number, or to add an exponent suffix.
 */
fun Appendable.appendIntScaled(i: Int, scale: Int, separator: Char) {
    IntOutput.appendIntScaled(this, i, scale, separator)
}

/**
 * Append a positive`Int` left-trimmed to an [Appendable], using a scale parameter to indicate the number of decimal
 * places.  This method outputs the digits left to right, avoiding the need to allocate a separate object to hold the
 * string form.
 */
fun Appendable.appendPositiveIntScaled(i: Int, scale: Int, separator: Char) {
    IntOutput.appendPositiveIntScaled(this, i, scale, separator)
}

/**
 * Append a `Long` left-trimmed to an [Appendable].  This method outputs the digits left to right, avoiding the need to
 * allocate a separate object to hold the string form.
 */
fun Appendable.appendLong(n: Long) {
    IntOutput.appendLong(this, n)
}

/**
 * Append a positive `Long` left-trimmed to an [Appendable].  This method outputs the digits left to right, avoiding the
 * need to allocate a separate object to hold the string form.
 */
fun Appendable.appendPositiveLong(n: Long) {
    IntOutput.appendPositiveLong(this, n)
}

/**
 * Append an unsigned `Long` left-trimmed to an [Appendable].  This method outputs the digits left to right, avoiding
 * the need to allocate a separate object to hold the string form.
 */
fun Appendable.appendUnsignedLong(n: Long) {
    IntOutput.appendUnsignedLong(this, n)
}

/**
 * Append a `Long` left-trimmed to an [Appendable], using a scale parameter to indicate the number of decimal places.
 * This method outputs the digits left to right, avoiding the need to allocate a separate object to hold the string
 * form.
 *
 * Negative scale values (indicating that decimal point is to the right of the last digit) are ignored.  It is left to
 * the user to decide whether to output additional zeros following the number, or to add an exponent suffix.
 */
fun Appendable.appendLongScaled(n: Long, scale: Int, separator: Char) {
    IntOutput.appendLongScaled(this, n, scale, separator)
}

/**
 * Append a positive `Long` left-trimmed to an [Appendable], using a scale parameter to indicate the number of decimal
 * places.  This method outputs the digits left to right, avoiding the need to allocate a separate object to hold the
 * string form.
 */
fun Appendable.appendPositiveLongScaled(n: Long, scale: Int, separator: Char) {
    IntOutput.appendLongScaled(this, n, scale, separator)
}

/**
 * Append an `Int` to an [Appendable], as a single decimal digit.  Note that there is no range check on the input value;
 * to append the least significant digit in cases where the value is not guaranteed to be in the range 0..9, use
 * [append1DigitSafe].
 */
fun Appendable.append1Digit(i: Int) {
    IntOutput.append1Digit(this, i)
}

/**
 * Append the least significant decimal digit of an [Int] to an [Appendable].
 */
fun Appendable.append1DigitSafe(i: Int) {
    IntOutput.append1DigitSafe(this, i)
}

/**
 * Append an `Int` to an [Appendable], as two decimal digits.  There is often a requirement to output a number as 2
 * digits, for example the cents value in dollars and cents, or hours, minutes and seconds in a time string.  Note that
 * there is no range check on the input value; to append the least significant two digits in cases where the value is
 * not guaranteed to be in the range 00..99, use [append2DigitsSafe].
 */
fun Appendable.append2Digits(i: Int) {
    IntOutput.append2Digits(this, i)
}

/**
 * Append the least significant two decimal digits of an [Int] to an [Appendable].
 */
fun Appendable.append2DigitsSafe(i: Int) {
    IntOutput.append2DigitsSafe(this, i)
}

/**
 * Append an `Int` to an [Appendable], as three decimal digits.  There is less frequently a requirement to output a
 * number as 3 digits, for example the milliseconds in a time string.  Note that there is no range check on the input
 * value; to append the least significant three digits in cases where the value is not guaranteed to be in the range
 * 000..999, use [append3DigitsSafe].
 */
fun Appendable.append3Digits(i: Int) {
    IntOutput.append3Digits(this, i)
}

/**
 * Append the least significant three decimal digits of an [Int] to an [Appendable].
 */
fun Appendable.append3DigitsSafe(i: Int) {
    IntOutput.append3DigitsSafe(this, i)
}

/**
 * Append an [Int] left-trimmed to an [Appendable] with digits grouped in 3s and separated by the specified grouping
 * character.
 */
fun Appendable.appendIntGrouped(i: Int, groupingChar: Char) {
    IntOutput.appendIntGrouped(this, i, groupingChar)
}

/**
 * Append a positive [Int] left-trimmed to an [Appendable] with digits grouped in 3s and separated by the specified
 * grouping character.
 */
fun Appendable.appendPositiveIntGrouped(i: Int, groupingChar: Char) {
    IntOutput.appendPositiveIntGrouped(this, i, groupingChar)
}

/**
 * Append a [Long] left-trimmed to an [Appendable] with digits grouped in 3s and separated by the specified grouping
 * character.
 */
fun Appendable.appendLongGrouped(n: Long, groupingChar: Char) {
    IntOutput.appendLongGrouped(this, n, groupingChar)
}

/**
 * Append a positive [Long] left-trimmed to an [Appendable] with digits grouped in 3s and separated by the specified
 * grouping character.
 */
fun Appendable.appendPositiveLongGrouped(n: Long, groupingChar: Char) {
    IntOutput.appendPositiveLongGrouped(this, n, groupingChar)
}

/**
 * Append an `Int` left-trimmed to an [Appendable] in hexadecimal.  This method outputs the digits left to right,
 * avoiding the need to allocate a separate object to hold the string form.
 */
fun Appendable.appendIntHex(i: Int) {
    IntOutput.appendIntHex(this, i)
}

/**
 * Append an `Int` left-trimmed to an [Appendable] in hexadecimal, using lower-case for the alphabetic characters.  This
 * method outputs the digits left to right, avoiding the need to allocate a separate object to hold the string form.
 */
fun Appendable.appendIntHexLC(i: Int) {
    IntOutput.appendIntHexLC(this, i)
}

/**
 * Append a `Long` left-trimmed to an [Appendable] in hexadecimal.  This method outputs the digits left to right,
 * avoiding the need to allocate a separate object to hold the string form.
 */
fun Appendable.appendLongHex(n: Long) {
    IntOutput.appendLongHex(this, n)
}

/**
 * Append a `Long` left-trimmed to an [Appendable] in hexadecimal, using lower-case for the alphabetic characters.  This
 * method outputs the digits left to right, avoiding the need to allocate a separate object to hold the string form.
 */
fun Appendable.appendLongHexLC(n: Long) {
    IntOutput.appendLongHexLC(this, n)
}

/**
 * Append an `Int` to an [Appendable] as eight hexadecimal digits.
 */
fun Appendable.append8Hex(i: Int) {
    IntOutput.append8Hex(this, i)
}

/**
 * Append an `Int` to an [Appendable] as eight hexadecimal digits, using lower-case for the alphabetic characters.
 */
fun Appendable.append8HexLC(i: Int) {
    IntOutput.append8HexLC(this, i)
}

/**
 * Append an `Int` to an [Appendable] as four hexadecimal digits.
 */
fun Appendable.append4Hex(i: Int) {
    IntOutput.append4Hex(this, i)
}

/**
 * Append an `Int` to an [Appendable] as four hexadecimal digits, using lower-case for the alphabetic characters.
 */
fun Appendable.append4HexLC(i: Int) {
    IntOutput.append4HexLC(this, i)
}

/**
 * Append an `Int` to an [Appendable] as two hexadecimal digits.
 */
fun Appendable.append2Hex(i: Int) {
    IntOutput.append2Hex(this, i)
}

/**
 * Append an `Int` to an [Appendable] as two hexadecimal digits, using lower-case for the alphabetic characters.
 */
fun Appendable.append2HexLC(i: Int) {
    IntOutput.append2HexLC(this, i)
}

/**
 * Append an `Int` to an [Appendable] as a single hexadecimal digit.
 */
fun Appendable.append1Hex(i: Int) {
    IntOutput.append1Hex(this, i)
}

/**
 * Append an `Int` to an [Appendable] as a single hexadecimal digit, using lower-case for the alphabetic characters.
 */
fun Appendable.append1HexLC(i: Int) {
    IntOutput.append1HexLC(this, i)
}
