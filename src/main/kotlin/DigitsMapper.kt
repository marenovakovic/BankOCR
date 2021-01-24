import arrow.core.Either
import arrow.core.left
import arrow.core.right

object DigitParseError

fun List<String>.parseDigits(): Either<DigitParseError, List<Digit>> {
    val topDigitParts = get(0).chunked(3)
    val middleDigitParts = get(1).chunked(3)
    val bottomDigitParts = get(2).chunked(3)

    return try {
        topDigitParts.mapIndexed { index, topPart ->
            "${topPart}\n${middleDigitParts[index]}\n${bottomDigitParts[index]}"
        }
            .map { digitImage ->
                digitMap[digitImage]?.let { Digit.Legible(digitImage to it) } ?: Digit.Illegible
            }
            .right()
    } catch (error: NullPointerException) {
        DigitParseError.left()
    }
}

fun List<Digit>.convertToString(): String {
    val digits =
        map { digit -> if (digit is Digit.Legible) digit.digitImage.digit else digit.digitImage.stringRepresentation }
    return StringBuilder().apply {
        digits.forEach { digit -> append(digit) }
    }.toString()
}