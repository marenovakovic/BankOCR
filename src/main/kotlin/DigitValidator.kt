import arrow.core.Validated
import arrow.core.invalid
import arrow.core.valid

sealed class ValidationError {
    object IllegibleDigits : ValidationError()
    object InvalidSum : ValidationError()
}

fun List<Digit>.validate(): Validated<ValidationError, List<Digit>> {
    if (containsIllegibleDigits)
        return ValidationError.IllegibleDigits.invalid()

    return if (checkSum % 11 == 0) this.valid()
    else ValidationError.InvalidSum.invalid()
}

//for (i in 0..list.size)
//    sum += list[list.size - i].digitImage.digit * i
private val List<Digit>.checkSum: Int
    get() = reversed().scanIndexed(0) { i, sum, digit ->
        sum + (digit as Digit.Legible).digitImage.digit * i
    }
        .sum()