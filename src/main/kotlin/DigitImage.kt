typealias DigitImage = Pair<String, Int>

val IllegibleDigitImage = "?" to -1

val DigitImage.stringRepresentation: String
    get() = first

val DigitImage.digit: Int
    get() = second

val digitMap = mapOf(
    " _ \n| |\n|_|" to 0,
    "   \n  |\n  |" to 1,
    " _ \n _|\n|_ " to 2,
    " _ \n _|\n _|" to 3,
    "   \n|_|\n  |" to 4,
    " _ \n|_ \n _|" to 5,
    " _ \n|_ \n|_|" to 6,
    " _ \n  |\n  |" to 7,
    " _ \n|_|\n|_|" to 8,
    " _ \n|_|\n _|" to 9,
)