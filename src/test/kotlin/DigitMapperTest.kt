import arrow.core.flatMap
import reader.InputFileReaderImpl
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class DigitMapperTest {

    @Test
    fun `should map lines to digits`() {
        val lines = InputFileReaderImpl.readLines("input.txt")
        val digits = lines.flatMap(List<String>::parseDigits)

        digits.fold(
            ifLeft = { assertTrue(false, "digits should not be Left") },
            ifRight = { value ->
                assertEquals(
                    value.map { digit -> (digit as Digit.Legible).digitImage.digit },
                    listOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
                )
            },
        )
    }
}
