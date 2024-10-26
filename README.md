# int-output-kotlin

[![Build Status](https://github.com/pwall567/int-output-kotlin/actions/workflows/build.yml/badge.svg)](https://github.com/pwall567/int-output-kotlin/actions/workflows/build.yml)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Kotlin](https://img.shields.io/static/v1?label=Kotlin&message=v1.9.24&color=7f52ff&logo=kotlin&logoColor=7f52ff)](https://github.com/JetBrains/kotlin/releases/tag/v1.9.24)
[![Maven Central](https://img.shields.io/maven-central/v/net.pwall.util/int-output-kotlin?label=Maven%20Central)](https://search.maven.org/search?q=g:%22net.pwall.util%22%20AND%20a:%22int-output-kotlin%22)

## Background

The original [`int-output`](https://github.com/pwall567/int-output) library was produced some years ago to provide
highly-optimised output functions for integer and long integer values.
That library has proved very useful, but being written in Java, it doesn't lend itself to idiomatic Kotlin usage.

The `int-output-kotlin` library is a thin Kotlin layer over the top of `int-output`.
It provides access to the underlying library in a more natural style for Kotlin developers, and depending on the level
optimisation of the compiler, the code using the Kotlin versions should not be significantly less efficient than code
calling the original functions.

## User Guide

The functions are all extension functions on `Appendable`, and as with the original functions, they can be divided into
those which output to decimal, and those which output to hexadecimal.

### Decimal

| Function                    | Parameter | Output                                                                             |
|-----------------------------|-----------|------------------------------------------------------------------------------------|
| `appendInt`                 | `Int`     | left-trimmed                                                                       |
| `appendPositiveInt`         | `Int`     | left-trimmed (value must be positive)                                              |
| `appendUnsignedInt`         | `Int`     | left-trimmed (value is treated as unsigned)                                        |
| `appendIntScaled`           | `Int`     | left-trimmed with decimal separator as indicated by scale                          |
| `appendPositiveIntScaled`   | `Int`     | left-trimmed with decimal separator as indicated by scale (value must be positive) |
| `appendLong`                | `Long`    | left-trimmed                                                                       |
| `appendPositiveLong`        | `Long`    | left-trimmed (value must be positive)                                              |
| `appendUnsignedLong`        | `Long`    | left-trimmed (value is treated as unsigned)                                        |
| `appendLongScaled`          | `Long`    | left-trimmed with decimal separator as indicated by scale                          |
| `appendPositiveLongScaled`  | `Long`    | left-trimmed with decimal separator as indicated by scale (value must be positive) |
| `append1Digit`              | `Int`     | 1 digit                                                                            |
| `append1DigitSafe`          | `Int`     | 1 digit (safe version; performs modulo on value)                                   |
| `append2Digits`             | `Int`     | 2 digits left filled with zeros                                                    |
| `append2DigitsSafe`         | `Int`     | 2 digits left filled with zeros (safe version; performs modulo on value)           |
| `append3Digits`             | `Int`     | 3 digits left filled with zeros                                                    |
| `append3DigitsSafe`         | `Int`     | 3 digits left filled with zeros (safe version; performs modulo on value)           |
| `appendIntGrouped`          | `Int`     | left-trimmed, output in 3-digit groups                                             |
| `appendPositiveIntGrouped`  | `Int`     | left-trimmed, output in 3-digit groups (value must be positive)                    |
| `appendLongGrouped`         | `Long`    | left-trimmed, output in 3-digit groups                                             |
| `appendPositiveLongGrouped` | `Long`    | left-trimmed, output in 3-digit groups (value must be positive)                    |

(the "grouped" forms output digits in blocks of three, separated by a nominated separator character)

### Hexadecimal

| Function          | Parameter | Output                                                           |
|-------------------|-----------|------------------------------------------------------------------|
| `appendIntHex`    | `Int`     | left-trimmed, hexadecimal                                        |
| `appendIntHexLC`  | `Int`     | left-trimmed, hexadecimal (using lower-case alphabetics)         |
| `appendLongHex`   | `Long`    | left-trimmed, hexadecimal                                        |
| `appendLongHexLC` | `Long`    | left-trimmed, hexadecimal (using lower-case alphabetics)         |
| `append8Hex`      | `Int`     | 8 digits left-padded, hexadecimal                                |
| `append8HexLC`    | `Int`     | 8 digits left-padded, hexadecimal (using lower-case alphabetics) |
| `append4Hex`      | `Int`     | 4 digits left-padded, hexadecimal                                |
| `append4HexLC`    | `Int`     | 4 digits left-padded, hexadecimal (using lower-case alphabetics) |
| `append2Hex`      | `Int`     | 2 digits left-padded, hexadecimal                                |
| `append2HexLC`    | `Int`     | 2 digits left-padded, hexadecimal (using lower-case alphabetics) |
| `append1Hex`      | `Int`     | 1 digit, hexadecimal                                             |
| `append1HexLC`    | `Int`     | 1 digit, hexadecimal (using lower-case alphabetics)              |

(the functions all have two variants, one which uses upper-case characters for the hexadecimal digits and one which uses
lower-case)

## Extended Example

The following code creates a summary line for a purchase:
```kotlin
    fun formatSummary(count: Int, dollars: Long, cents: Int) = buildString { 
        appendInt(count)
        append(" item")
        if (count != 1)
            append('s')
        append(" purchased, total cost $")
        appendLongGrouped(dollars, ',')
        append('.')
        append2Digits(cents)
    }
```
The `int-output-kotlin` library functions fit in naturally with the `append` function of the standard library.

## Dependency Specification

The latest version of the library is 1.0, and it may be obtained from the Maven Central repository.

### Maven
```xml
    <dependency>
      <groupId>net.pwall.util</groupId>
      <artifactId>int-output-kotlin</artifactId>
      <version>1.0</version>
    </dependency>
```
### Gradle
```groovy
    implementation 'net.pwall.util:int-output-kotlin:1.0'
```
### Gradle (kts)
```kotlin
    implementation("net.pwall.util:int-output-kotlin:1.0")
```

Peter Wall

2024-10-26
