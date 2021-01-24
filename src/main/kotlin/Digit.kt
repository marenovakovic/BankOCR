sealed class Digit(val digitImage: DigitImage) {
    data class Legible(val value: DigitImage) : Digit(value)
    object Illegible : Digit(IllegibleDigitImage)
}

val List<Digit>.containsIllegibleDigits: Boolean
    get() = any { digit -> digit is Digit.Illegible }