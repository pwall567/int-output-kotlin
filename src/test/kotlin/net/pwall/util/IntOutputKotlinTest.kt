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

import kotlin.test.Test
import kotlin.test.expect

class IntOutputKotlinTest {

    @Test fun `should convert Int correctly`() {
        val sb = StringBuilder()
        sb.appendInt(0)
        expect("0") { sb.toString() }
        sb.setLength(0)
        sb.appendInt(123456)
        expect("123456") { sb.toString() }
        sb.setLength(0)
        sb.appendInt(-22334455)
        expect("-22334455") { sb.toString() }
        sb.setLength(0)
        sb.appendInt(Int.MAX_VALUE)
        expect("2147483647") { sb.toString() }
        sb.setLength(0)
        sb.appendInt(Int.MIN_VALUE)
        expect("-2147483648") { sb.toString() }
    }

    @Test fun `should convert positive Int correctly`() {
        val sb = StringBuilder()
        sb.appendPositiveInt(0)
        expect("0") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveInt(123456)
        expect("123456") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveInt(Int.MAX_VALUE)
        expect("2147483647") { sb.toString() }
    }

    @Test fun `should convert unsigned Int correctly`() {
        val sb = StringBuilder()
        sb.appendUnsignedInt(0)
        expect("0") { sb.toString() }
        sb.setLength(0)
        sb.appendUnsignedInt(123456)
        expect("123456") { sb.toString() }
        sb.setLength(0)
        sb.appendUnsignedInt(2147483648L.toInt())
        expect("2147483648") { sb.toString() }
        sb.setLength(0)
        sb.appendUnsignedInt(3456789012L.toInt())
        expect("3456789012") { sb.toString() }
        sb.setLength(0)
        sb.appendUnsignedInt(0x89ABCDEF.toInt())
        expect("2309737967") { sb.toString() }
    }

    @Test fun `should convert Int scaled`() {
        val separator = '.'
        val sb = StringBuilder()
        sb.appendIntScaled(0, 0, separator)
        expect("0") { sb.toString() }
        sb.setLength(0)
        sb.appendIntScaled(0, 1, separator)
        expect("0.0") { sb.toString() }
        sb.setLength(0)
        sb.appendIntScaled(0, 2, separator)
        expect("0.00") { sb.toString() }
        sb.setLength(0)
        sb.appendIntScaled(0, 3, separator)
        expect("0.000") { sb.toString() }
        sb.setLength(0)
        sb.appendIntScaled(123456, 0, separator)
        expect("123456") { sb.toString() }
        sb.setLength(0)
        sb.appendIntScaled(123456, 1, separator)
        expect("12345.6") { sb.toString() }
        sb.setLength(0)
        sb.appendIntScaled(123456, 2, separator)
        expect("1234.56") { sb.toString() }
        sb.setLength(0)
        sb.appendIntScaled(123456, 3, separator)
        expect("123.456") { sb.toString() }
        sb.setLength(0)
        sb.appendIntScaled(123456, 6, separator)
        expect("0.123456") { sb.toString() }
        sb.setLength(0)
        sb.appendIntScaled(123456, 7, separator)
        expect("0.0123456") { sb.toString() }
        sb.setLength(0)
        sb.appendIntScaled(123456, 8, separator)
        expect("0.00123456") { sb.toString() }
        sb.setLength(0)
        sb.appendIntScaled(-22334455, 0, separator)
        expect("-22334455") { sb.toString() }
        sb.setLength(0)
        sb.appendIntScaled(-22334455, 1, separator)
        expect("-2233445.5") { sb.toString() }
        sb.setLength(0)
        sb.appendIntScaled(-22334455, 2, separator)
        expect("-223344.55") { sb.toString() }
        sb.setLength(0)
        sb.appendIntScaled(-22334455, 3, separator)
        expect("-22334.455") { sb.toString() }
        sb.setLength(0)
        sb.appendIntScaled(Int.MAX_VALUE, 0, separator)
        expect("2147483647") { sb.toString() }
        sb.setLength(0)
        sb.appendIntScaled(Int.MAX_VALUE, 1, separator)
        expect("214748364.7") { sb.toString() }
        sb.setLength(0)
        sb.appendIntScaled(Int.MAX_VALUE, 2, separator)
        expect("21474836.47") { sb.toString() }
        sb.setLength(0)
        sb.appendIntScaled(Int.MAX_VALUE, 3, separator)
        expect("2147483.647") { sb.toString() }
        sb.setLength(0)
        sb.appendIntScaled(Int.MIN_VALUE, 0, separator)
        expect("-2147483648") { sb.toString() }
        sb.setLength(0)
        sb.appendIntScaled(Int.MIN_VALUE, 1, separator)
        expect("-214748364.8") { sb.toString() }
        sb.setLength(0)
        sb.appendIntScaled(Int.MIN_VALUE, 2, separator)
        expect("-21474836.48") { sb.toString() }
        sb.setLength(0)
        sb.appendIntScaled(Int.MIN_VALUE, 3, separator)
        expect("-2147483.648") { sb.toString() }
        sb.setLength(0)
        sb.appendIntScaled(Int.MIN_VALUE, 10, separator)
        expect("-0.2147483648") { sb.toString() }
        sb.setLength(0)
        sb.appendIntScaled(Int.MIN_VALUE, 11, separator)
        expect("-0.02147483648") { sb.toString() }
        sb.setLength(0)
        sb.appendIntScaled(Int.MIN_VALUE, 12, separator)
        expect("-0.002147483648") { sb.toString() }
    }

    @Test fun `should convert positive Int scaled`() {
        val separator = '.'
        val sb = StringBuilder()
        sb.appendPositiveIntScaled(0, 0, separator)
        expect("0") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveIntScaled(0, 1, separator)
        expect("0.0") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveIntScaled(0, 2, separator)
        expect("0.00") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveIntScaled(0, 3, separator)
        expect("0.000") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveIntScaled(123456, 0, separator)
        expect("123456") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveIntScaled(123456, 1, separator)
        expect("12345.6") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveIntScaled(123456, 2, separator)
        expect("1234.56") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveIntScaled(123456, 3, separator)
        expect("123.456") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveIntScaled(123456, 6, separator)
        expect("0.123456") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveIntScaled(123456, 7, separator)
        expect("0.0123456") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveIntScaled(123456, 8, separator)
        expect("0.00123456") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveIntScaled(Int.MAX_VALUE, 0, separator)
        expect("2147483647") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveIntScaled(Int.MAX_VALUE, 1, separator)
        expect("214748364.7") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveIntScaled(Int.MAX_VALUE, 2, separator)
        expect("21474836.47") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveIntScaled(Int.MAX_VALUE, 3, separator)
        expect("2147483.647") { sb.toString() }
    }

    @Test fun `should convert Long correctly`() {
        val sb = StringBuilder()
        sb.appendLong(0)
        expect("0") { sb.toString() }
        sb.setLength(0)
        sb.appendLong(123456789012345678L)
        expect("123456789012345678") { sb.toString() }
        sb.setLength(0)
        sb.appendLong(-2233445566778899L)
        expect("-2233445566778899") { sb.toString() }
        sb.setLength(0)
        sb.appendLong(Int.MAX_VALUE.toLong())
        expect("2147483647") { sb.toString() }
        sb.setLength(0)
        sb.appendLong(Int.MIN_VALUE.toLong())
        expect("-2147483648") { sb.toString() }
        sb.setLength(0)
        sb.appendLong(Long.MAX_VALUE)
        expect("9223372036854775807") { sb.toString() }
        sb.setLength(0)
        sb.appendLong(Long.MIN_VALUE)
        expect("-9223372036854775808") { sb.toString() }
    }

    @Test fun `should convert positive Long correctly`() {
        val sb = StringBuilder()
        sb.appendPositiveLong(0)
        expect("0") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLong(123456789012345678L)
        expect("123456789012345678") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLong(Int.MAX_VALUE.toLong())
        expect("2147483647") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLong(Long.MAX_VALUE)
        expect("9223372036854775807") { sb.toString() }
    }

    @Test fun `should convert unsigned Long correctly`() {
        val sb = StringBuilder()
        sb.appendUnsignedLong(0)
        expect("0") { sb.toString() }
        sb.setLength(0)
        sb.appendUnsignedLong(1234567890123456789L)
        expect("1234567890123456789") { sb.toString() }
        sb.setLength(0)
        val n = Long.MAX_VALUE
        @Suppress("INTEGER_OVERFLOW")
        sb.appendUnsignedLong(n + 1)
        expect("9223372036854775808") { sb.toString() }
        sb.setLength(0)
        val m = 1234567890123456789L
        @Suppress("INTEGER_OVERFLOW")
        sb.appendUnsignedLong(m * 10)
        expect("12345678901234567890") { sb.toString() }
    }

    @Test fun `should convert Long scaled`() {
        val separator = '.'
        val sb = StringBuilder()
        sb.appendLongScaled(0, 0, separator)
        expect("0") { sb.toString() }
        sb.setLength(0)
        sb.appendLongScaled(0, 1, separator)
        expect("0.0") { sb.toString() }
        sb.setLength(0)
        sb.appendLongScaled(0, 2, separator)
        expect("0.00") { sb.toString() }
        sb.setLength(0)
        sb.appendLongScaled(0, 3, separator)
        expect("0.000") { sb.toString() }
        sb.setLength(0)
        sb.appendLongScaled(123456, 0, separator)
        expect("123456") { sb.toString() }
        sb.setLength(0)
        sb.appendLongScaled(123456, 1, separator)
        expect("12345.6") { sb.toString() }
        sb.setLength(0)
        sb.appendLongScaled(123456, 2, separator)
        expect("1234.56") { sb.toString() }
        sb.setLength(0)
        sb.appendLongScaled(123456, 3, separator)
        expect("123.456") { sb.toString() }
        sb.setLength(0)
        sb.appendLongScaled(123456, 6, separator)
        expect("0.123456") { sb.toString() }
        sb.setLength(0)
        sb.appendLongScaled(123456, 7, separator)
        expect("0.0123456") { sb.toString() }
        sb.setLength(0)
        sb.appendLongScaled(123456, 8, separator)
        expect("0.00123456") { sb.toString() }
        sb.setLength(0)
        sb.appendLongScaled(-22334455, 0, separator)
        expect("-22334455") { sb.toString() }
        sb.setLength(0)
        sb.appendLongScaled(-22334455, 1, separator)
        expect("-2233445.5") { sb.toString() }
        sb.setLength(0)
        sb.appendLongScaled(-22334455, 2, separator)
        expect("-223344.55") { sb.toString() }
        sb.setLength(0)
        sb.appendLongScaled(-22334455, 3, separator)
        expect("-22334.455") { sb.toString() }
        sb.setLength(0)
        sb.appendLongScaled(123456789012345678L, 0, separator)
        expect("123456789012345678") { sb.toString() }
        sb.setLength(0)
        sb.appendLongScaled(123456789012345678L, 1, separator)
        expect("12345678901234567.8") { sb.toString() }
        sb.setLength(0)
        sb.appendLongScaled(123456789012345678L, 2, separator)
        expect("1234567890123456.78") { sb.toString() }
        sb.setLength(0)
        sb.appendLongScaled(123456789012345678L, 3, separator)
        expect("123456789012345.678") { sb.toString() }
        sb.setLength(0)
        sb.appendLongScaled(123456789012345678L, 18, separator)
        expect("0.123456789012345678") { sb.toString() }
        sb.setLength(0)
        sb.appendLongScaled(123456789012345678L, 19, separator)
        expect("0.0123456789012345678") { sb.toString() }
        sb.setLength(0)
        sb.appendLongScaled(123456789012345678L, 20, separator)
        expect("0.00123456789012345678") { sb.toString() }
        sb.setLength(0)
        sb.appendLongScaled(-2233445566778899L, 0, separator)
        expect("-2233445566778899") { sb.toString() }
        sb.setLength(0)
        sb.appendLongScaled(-2233445566778899L, 1, separator)
        expect("-223344556677889.9") { sb.toString() }
        sb.setLength(0)
        sb.appendLongScaled(-2233445566778899L, 16, separator)
        expect("-0.2233445566778899") { sb.toString() }
        sb.setLength(0)
        sb.appendLongScaled(-2233445566778899L, 17, separator)
        expect("-0.02233445566778899") { sb.toString() }
        sb.setLength(0)
        sb.appendLongScaled(Long.MAX_VALUE, 0, separator)
        expect("9223372036854775807") { sb.toString() }
        sb.setLength(0)
        sb.appendLongScaled(Long.MAX_VALUE, 1, separator)
        expect("922337203685477580.7") { sb.toString() }
        sb.setLength(0)
        sb.appendLongScaled(Long.MAX_VALUE, 2, separator)
        expect("92233720368547758.07") { sb.toString() }
        sb.setLength(0)
        sb.appendLongScaled(Long.MAX_VALUE, 3, separator)
        expect("9223372036854775.807") { sb.toString() }
        sb.setLength(0)
        sb.appendLongScaled(Long.MIN_VALUE, 0, separator)
        expect("-9223372036854775808") { sb.toString() }
        sb.setLength(0)
        sb.appendLongScaled(Long.MIN_VALUE, 1, separator)
        expect("-922337203685477580.8") { sb.toString() }
        sb.setLength(0)
        sb.appendLongScaled(Long.MIN_VALUE, 2, separator)
        expect("-92233720368547758.08") { sb.toString() }
        sb.setLength(0)
        sb.appendLongScaled(Long.MIN_VALUE, 3, separator)
        expect("-9223372036854775.808") { sb.toString() }
        sb.setLength(0)
        sb.appendLongScaled(Long.MIN_VALUE, 10, separator)
        expect("-922337203.6854775808") { sb.toString() }
        sb.setLength(0)
        sb.appendLongScaled(Long.MIN_VALUE, 19, separator)
        expect("-0.9223372036854775808") { sb.toString() }
        sb.setLength(0)
        sb.appendLongScaled(Long.MIN_VALUE, 20, separator)
        expect("-0.09223372036854775808") { sb.toString() }
        sb.setLength(0)
        sb.appendLongScaled(Long.MIN_VALUE, 21, separator)
        expect("-0.009223372036854775808") { sb.toString() }
    }

    @Test fun `should convert positive Long scaled`() {
        val separator = '.'
        val sb = StringBuilder()
        sb.appendPositiveLongScaled(0, 0, separator)
        expect("0") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongScaled(0, 1, separator)
        expect("0.0") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongScaled(0, 2, separator)
        expect("0.00") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongScaled(0, 3, separator)
        expect("0.000") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongScaled(123456, 0, separator)
        expect("123456") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongScaled(123456, 1, separator)
        expect("12345.6") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongScaled(123456, 2, separator)
        expect("1234.56") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongScaled(123456, 3, separator)
        expect("123.456") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongScaled(123456, 6, separator)
        expect("0.123456") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongScaled(123456, 7, separator)
        expect("0.0123456") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongScaled(123456, 8, separator)
        expect("0.00123456") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongScaled(123456789012345678L, 0, separator)
        expect("123456789012345678") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongScaled(123456789012345678L, 1, separator)
        expect("12345678901234567.8") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongScaled(123456789012345678L, 2, separator)
        expect("1234567890123456.78") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongScaled(123456789012345678L, 3, separator)
        expect("123456789012345.678") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongScaled(123456789012345678L, 18, separator)
        expect("0.123456789012345678") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongScaled(123456789012345678L, 19, separator)
        expect("0.0123456789012345678") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongScaled(123456789012345678L, 20, separator)
        expect("0.00123456789012345678") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongScaled(Long.MAX_VALUE, 0, separator)
        expect("9223372036854775807") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongScaled(Long.MAX_VALUE, 1, separator)
        expect("922337203685477580.7") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongScaled(Long.MAX_VALUE, 2, separator)
        expect("92233720368547758.07") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongScaled(Long.MAX_VALUE, 3, separator)
        expect("9223372036854775.807") { sb.toString() }
    }

    @Test fun `should output 1 digit correctly`() {
        val sb = StringBuilder()
        sb.append1Digit(0)
        expect("0") { sb.toString() }
        sb.setLength(0)
        sb.append1Digit(1)
        expect("1") { sb.toString() }
        sb.setLength(0)
        sb.append1Digit(9)
        expect("9") { sb.toString() }
    }

    @Test fun `should output 1 digit safely`() {
        val sb = StringBuilder()
        sb.append1DigitSafe(50)
        expect("0") { sb.toString() }
        sb.setLength(0)
        sb.append1DigitSafe(-511)
        expect("1") { sb.toString() }
        sb.setLength(0)
        sb.append1DigitSafe(99999999)
        expect("9") { sb.toString() }
    }

    @Test fun `should output 2 digits correctly`() {
        val sb = StringBuilder()
        sb.append2Digits(0)
        expect("00") { sb.toString() }
        sb.setLength(0)
        sb.append2Digits(1)
        expect("01") { sb.toString() }
        sb.setLength(0)
        sb.append2Digits(21)
        expect("21") { sb.toString() }
    }

    @Test fun `should output 2 digits safely`() {
        val sb = StringBuilder()
        sb.append2DigitsSafe(5000)
        expect("00") { sb.toString() }
        sb.setLength(0)
        sb.append2DigitsSafe(-801)
        expect("01") { sb.toString() }
        sb.setLength(0)
        sb.append2DigitsSafe(222221)
        expect("21") { sb.toString() }
    }

    @Test fun `should output 3 digits correctly`() {
        val sb = StringBuilder()
        sb.append3Digits(0)
        expect("000") { sb.toString() }
        sb.setLength(0)
        sb.append3Digits(1)
        expect("001") { sb.toString() }
        sb.setLength(0)
        sb.append3Digits(21)
        expect("021") { sb.toString() }
        sb.setLength(0)
        sb.append3Digits(321)
        expect("321") { sb.toString() }
    }

    @Test fun `should output 3 digits safely`() {
        val sb = StringBuilder()
        sb.append3DigitsSafe(5000)
        expect("000") { sb.toString() }
        sb.setLength(0)
        sb.append3DigitsSafe(1234569001)
        expect("001") { sb.toString() }
        sb.setLength(0)
        sb.append3DigitsSafe(-4021)
        expect("021") { sb.toString() }
        sb.setLength(0)
        sb.append3DigitsSafe(7654321)
        expect("321") { sb.toString() }
    }

    @Test fun `should output Int with grouping`() {
        val sb = StringBuilder()
        sb.appendIntGrouped(0, ',')
        expect("0") { sb.toString() }
        sb.setLength(0)
        sb.appendIntGrouped(1, ',')
        expect("1") { sb.toString() }
        sb.setLength(0)
        sb.appendIntGrouped(123, ',')
        expect("123") { sb.toString() }
        sb.setLength(0)
        sb.appendIntGrouped(1234, ',')
        expect("1,234") { sb.toString() }
        sb.setLength(0)
        sb.appendIntGrouped(12345, ',')
        expect("12,345") { sb.toString() }
        sb.setLength(0)
        sb.appendIntGrouped(123456, ',')
        expect("123,456") { sb.toString() }
        sb.setLength(0)
        sb.appendIntGrouped(1234567, ',')
        expect("1,234,567") { sb.toString() }
        sb.setLength(0)
        sb.appendIntGrouped(12345678, ',')
        expect("12,345,678") { sb.toString() }
        sb.setLength(0)
        sb.appendIntGrouped(123456789, ',')
        expect("123,456,789") { sb.toString() }
        sb.setLength(0)
        sb.appendIntGrouped(1234567890, ',')
        expect("1,234,567,890") { sb.toString() }
        sb.setLength(0)
        sb.appendIntGrouped(Int.MAX_VALUE, ',')
        expect("2,147,483,647") { sb.toString() }
        sb.setLength(0)
        sb.appendIntGrouped(Int.MIN_VALUE, ',')
        expect("-2,147,483,648") { sb.toString() }
    }

    @Test fun `should output positive Int with grouping`() {
        val sb = StringBuilder()
        sb.appendPositiveIntGrouped(0, ',')
        expect("0") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveIntGrouped(1, ',')
        expect("1") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveIntGrouped(123, ',')
        expect("123") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveIntGrouped(1234, ',')
        expect("1,234") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveIntGrouped(12345, ',')
        expect("12,345") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveIntGrouped(123456, ',')
        expect("123,456") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveIntGrouped(1234567, ',')
        expect("1,234,567") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveIntGrouped(12345678, ',')
        expect("12,345,678") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveIntGrouped(123456789, ',')
        expect("123,456,789") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveIntGrouped(1234567890, ',')
        expect("1,234,567,890") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveIntGrouped(Int.MAX_VALUE, ',')
        expect("2,147,483,647") { sb.toString() }
    }

    @Test fun `should output Long with grouping`() {
        val sb = StringBuilder()
        sb.appendLongGrouped(0, ',')
        expect("0") { sb.toString() }
        sb.setLength(0)
        sb.appendLongGrouped(1, ',')
        expect("1") { sb.toString() }
        sb.setLength(0)
        sb.appendLongGrouped(123, ',')
        expect("123") { sb.toString() }
        sb.setLength(0)
        sb.appendLongGrouped(1234, ',')
        expect("1,234") { sb.toString() }
        sb.setLength(0)
        sb.appendLongGrouped(12345, ',')
        expect("12,345") { sb.toString() }
        sb.setLength(0)
        sb.appendLongGrouped(123456, ',')
        expect("123,456") { sb.toString() }
        sb.setLength(0)
        sb.appendLongGrouped(1234567, ',')
        expect("1,234,567") { sb.toString() }
        sb.setLength(0)
        sb.appendLongGrouped(12345678, ',')
        expect("12,345,678") { sb.toString() }
        sb.setLength(0)
        sb.appendLongGrouped(123456789, ',')
        expect("123,456,789") { sb.toString() }
        sb.setLength(0)
        sb.appendLongGrouped(1234567890, ',')
        expect("1,234,567,890") { sb.toString() }
        sb.setLength(0)
        sb.appendLongGrouped(12345678901, ',')
        expect("12,345,678,901") { sb.toString() }
        sb.setLength(0)
        sb.appendLongGrouped(123456789012, ',')
        expect("123,456,789,012") { sb.toString() }
        sb.setLength(0)
        sb.appendLongGrouped(1234567890123, ',')
        expect("1,234,567,890,123") { sb.toString() }
        sb.setLength(0)
        sb.appendLongGrouped(12345678901234, ',')
        expect("12,345,678,901,234") { sb.toString() }
        sb.setLength(0)
        sb.appendLongGrouped(123456789012345, ',')
        expect("123,456,789,012,345") { sb.toString() }
        sb.setLength(0)
        sb.appendLongGrouped(1234567890123456, ',')
        expect("1,234,567,890,123,456") { sb.toString() }
        sb.setLength(0)
        sb.appendLongGrouped(12345678901234567, ',')
        expect("12,345,678,901,234,567") { sb.toString() }
        sb.setLength(0)
        sb.appendLongGrouped(123456789012345678, ',')
        expect("123,456,789,012,345,678") { sb.toString() }
        sb.setLength(0)
        sb.appendLongGrouped(1234567890123456789, ',')
        expect("1,234,567,890,123,456,789") { sb.toString() }
        sb.setLength(0)
        sb.appendLongGrouped(Long.MAX_VALUE, ',')
        expect("9,223,372,036,854,775,807") { sb.toString() }
        sb.setLength(0)
        sb.appendLongGrouped(Long.MIN_VALUE, ',')
        expect("-9,223,372,036,854,775,808") { sb.toString() }
    }

    @Test fun `should output positive Long with grouping`() {
        val sb = StringBuilder()
        sb.appendPositiveLongGrouped(0, ',')
        expect("0") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongGrouped(1, ',')
        expect("1") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongGrouped(123, ',')
        expect("123") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongGrouped(1234, ',')
        expect("1,234") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongGrouped(12345, ',')
        expect("12,345") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongGrouped(123456, ',')
        expect("123,456") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongGrouped(1234567, ',')
        expect("1,234,567") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongGrouped(12345678, ',')
        expect("12,345,678") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongGrouped(123456789, ',')
        expect("123,456,789") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongGrouped(1234567890, ',')
        expect("1,234,567,890") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongGrouped(12345678901, ',')
        expect("12,345,678,901") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongGrouped(123456789012, ',')
        expect("123,456,789,012") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongGrouped(1234567890123, ',')
        expect("1,234,567,890,123") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongGrouped(12345678901234, ',')
        expect("12,345,678,901,234") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongGrouped(123456789012345, ',')
        expect("123,456,789,012,345") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongGrouped(1234567890123456, ',')
        expect("1,234,567,890,123,456") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongGrouped(12345678901234567, ',')
        expect("12,345,678,901,234,567") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongGrouped(123456789012345678, ',')
        expect("123,456,789,012,345,678") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongGrouped(1234567890123456789, ',')
        expect("1,234,567,890,123,456,789") { sb.toString() }
        sb.setLength(0)
        sb.appendPositiveLongGrouped(Long.MAX_VALUE, ',')
        expect("9,223,372,036,854,775,807") { sb.toString() }
    }

    @Test fun `should format money`() {
        expect("$1.00") { formatMoney(1, 0) }
        expect("$1,234.56") { formatMoney(1234, 56) }
    }

    private fun formatMoney(dollars: Long, cents: Int) = buildString(32) {
        append('$')
        appendPositiveLongGrouped(dollars, ',')
        append('.')
        append2Digits(cents)
    }

    @Test fun `should convert Int to hex correctly`() {
        val sb = StringBuilder()
        sb.appendIntHex(0)
        expect("0") { sb.toString() }
        sb.setLength(0)
        sb.appendIntHex(1)
        expect("1") { sb.toString() }
        sb.setLength(0)
        sb.appendIntHex(0x23)
        expect("23") { sb.toString() }
        sb.setLength(0)
        sb.appendIntHex(0x456)
        expect("456") { sb.toString() }
        sb.setLength(0)
        sb.appendIntHex(0xA7B9)
        expect("A7B9") { sb.toString() }
        sb.setLength(0)
        sb.appendIntHex(0x8A1B1)
        expect("8A1B1") { sb.toString() }
        sb.setLength(0)
        sb.appendIntHex(0xFEEABC)
        expect("FEEABC") { sb.toString() }
        sb.setLength(0)
        sb.appendIntHex(0xDEADFEED.toInt())
        expect("DEADFEED") { sb.toString() }
    }

    @Test fun `should convert Int to hex correctly using lower case`() {
        val sb = StringBuilder()
        sb.appendIntHexLC(0)
        expect("0") { sb.toString() }
        sb.setLength(0)
        sb.appendIntHexLC(1)
        expect("1") { sb.toString() }
        sb.setLength(0)
        sb.appendIntHexLC(0x23)
        expect("23") { sb.toString() }
        sb.setLength(0)
        sb.appendIntHexLC(0x456)
        expect("456") { sb.toString() }
        sb.setLength(0)
        sb.appendIntHexLC(0xA7B9)
        expect("a7b9") { sb.toString() }
        sb.setLength(0)
        sb.appendIntHexLC(0x8A1B1)
        expect("8a1b1") { sb.toString() }
        sb.setLength(0)
        sb.appendIntHexLC(0xFEEABC)
        expect("feeabc") { sb.toString() }
        sb.setLength(0)
        sb.appendIntHexLC(0xDEADFEED.toInt())
        expect("deadfeed") { sb.toString() }
    }

    @Test fun `should convert Long to hex correctly`() {
        val sb = StringBuilder()
        sb.appendLongHex(0)
        expect("0") { sb.toString() }
        sb.setLength(0)
        sb.appendLongHex(1)
        expect("1") { sb.toString() }
        sb.setLength(0)
        sb.appendLongHex(0x23)
        expect("23") { sb.toString() }
        sb.setLength(0)
        sb.appendLongHex(0x456)
        expect("456") { sb.toString() }
        sb.setLength(0)
        sb.appendLongHex(0xA7B9)
        expect("A7B9") { sb.toString() }
        sb.setLength(0)
        sb.appendLongHex(0x8A1B1)
        expect("8A1B1") { sb.toString() }
        sb.setLength(0)
        sb.appendLongHex(0xFEEABC)
        expect("FEEABC") { sb.toString() }
        sb.setLength(0)
        sb.appendLongHex(0xDEADFEED)
        expect("DEADFEED") { sb.toString() }
        sb.setLength(0)
        sb.appendLongHex(0x123DEADFEED)
        expect("123DEADFEED") { sb.toString() }
        sb.setLength(0)
        sb.appendLongHex(0x800000000000000 shl 4)
        expect("8000000000000000") { sb.toString() }
    }

    @Test fun `should convert Long to hex correctly using lower case`() {
        val sb = StringBuilder()
        sb.appendLongHexLC(0)
        expect("0") { sb.toString() }
        sb.setLength(0)
        sb.appendLongHexLC(1)
        expect("1") { sb.toString() }
        sb.setLength(0)
        sb.appendLongHexLC(0x23)
        expect("23") { sb.toString() }
        sb.setLength(0)
        sb.appendLongHexLC(0x456)
        expect("456") { sb.toString() }
        sb.setLength(0)
        sb.appendLongHexLC(0xA7B9)
        expect("a7b9") { sb.toString() }
        sb.setLength(0)
        sb.appendLongHexLC(0x8A1B1)
        expect("8a1b1") { sb.toString() }
        sb.setLength(0)
        sb.appendLongHexLC(0xFEEABC)
        expect("feeabc") { sb.toString() }
        sb.setLength(0)
        sb.appendLongHexLC(0xDEADFEED)
        expect("deadfeed") { sb.toString() }
        sb.setLength(0)
        sb.appendLongHexLC(0x123DEADFEED)
        expect("123deadfeed") { sb.toString() }
        sb.setLength(0)
        sb.appendLongHexLC(0x800000000000000 shl 4)
        expect("8000000000000000") { sb.toString() }
    }

    @Test fun `should output 8 digits hex correctly`() {
        val sb = StringBuilder()
        sb.append8Hex(0)
        expect("00000000") { sb.toString() }
        sb.setLength(0)
        sb.append8Hex(1)
        expect("00000001") { sb.toString() }
        sb.setLength(0)
        sb.append8Hex(0xABCD)
        expect("0000ABCD") { sb.toString() }
        sb.setLength(0)
        sb.append8Hex(0x9ABCD)
        expect("0009ABCD") { sb.toString() }
        sb.setLength(0)
        sb.append8Hex(0x89ABCD)
        expect("0089ABCD") { sb.toString() }
        sb.setLength(0)
        sb.append8Hex(0xE89ABCD)
        expect("0E89ABCD") { sb.toString() }
        sb.setLength(0)
        sb.append8Hex(0x7E89ABCD)
        expect("7E89ABCD") { sb.toString() }
    }

    @Test fun `should output 8 digits hex correctly using lower case`() {
        val sb = StringBuilder()
        sb.append8HexLC(0)
        expect("00000000") { sb.toString() }
        sb.setLength(0)
        sb.append8HexLC(1)
        expect("00000001") { sb.toString() }
        sb.setLength(0)
        sb.append8HexLC(0xABCD)
        expect("0000abcd") { sb.toString() }
        sb.setLength(0)
        sb.append8HexLC(0x9ABCD)
        expect("0009abcd") { sb.toString() }
        sb.setLength(0)
        sb.append8HexLC(0x89ABCD)
        expect("0089abcd") { sb.toString() }
        sb.setLength(0)
        sb.append8HexLC(0xE89ABCD)
        expect("0e89abcd") { sb.toString() }
        sb.setLength(0)
        sb.append8HexLC((0xFE89ABC shl 4) or 0xD)
        expect("fe89abcd") { sb.toString() }
    }

    @Test fun `should output 4 digits hex correctly`() {
        val sb = StringBuilder()
        sb.append4Hex(0)
        expect("0000") { sb.toString() }
        sb.setLength(0)
        sb.append4Hex(1)
        expect("0001") { sb.toString() }
        sb.setLength(0)
        sb.append4Hex(0xABCD)
        expect("ABCD") { sb.toString() }
    }

    @Test fun `should output 4 digits hex correctly using lower case`() {
        val sb = StringBuilder()
        sb.append4HexLC(0)
        expect("0000") { sb.toString() }
        sb.setLength(0)
        sb.append4HexLC(1)
        expect("0001") { sb.toString() }
        sb.setLength(0)
        sb.append4HexLC(0xABCD)
        expect("abcd") { sb.toString() }
    }

    @Test fun `should output 2 digits hex correctly`() {
        val sb = StringBuilder()
        sb.append2Hex(0)
        expect("00") { sb.toString() }
        sb.setLength(0)
        sb.append2Hex(1)
        expect("01") { sb.toString() }
        sb.setLength(0)
        sb.append2Hex(0xAB)
        expect("AB") { sb.toString() }
    }

    @Test fun `should output 2 digits hex correctly using lower case`() {
        val sb = StringBuilder()
        sb.append2HexLC(0)
        expect("00") { sb.toString() }
        sb.setLength(0)
        sb.append2HexLC(1)
        expect("01") { sb.toString() }
        sb.setLength(0)
        sb.append2HexLC(0xAB)
        expect("ab") { sb.toString() }
    }

    @Test fun `should output 1 digit hex correctly`() {
        val sb = StringBuilder()
        sb.append1Hex(0)
        expect("0") { sb.toString() }
        sb.setLength(0)
        sb.append1Hex(1)
        expect("1") { sb.toString() }
        sb.setLength(0)
        sb.append1Hex(0xA)
        expect("A") { sb.toString() }
    }

    @Test fun `should output 1 digit hex correctly using lower case`() {
        val sb = StringBuilder()
        sb.append1HexLC(0)
        expect("0") { sb.toString() }
        sb.setLength(0)
        sb.append1HexLC(1)
        expect("1") { sb.toString() }
        sb.setLength(0)
        sb.append1HexLC(0xA)
        expect("a") { sb.toString() }
    }

}
