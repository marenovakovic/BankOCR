import arrow.core.flatMap
import reader.InputFileReaderImpl
import kotlin.test.Test
import kotlin.test.assertSame
import kotlin.test.assertTrue

class DigitValidatorTest {

    @Test
    fun `should return Valid for valid data`() {
        InputFileReaderImpl.readLines("input.txt")
            .flatMap(List<String>::parseDigits)
            .fold(
                { assertTrue(false) },
                { digits ->
                    digits.validate().fold(
                        { assertTrue(false) },
                        { println(it) },
                    )
                },
            )
    }

    @Test
    fun `should return Invalid for error input`() {
        InputFileReaderImpl.readLines("error_input.txt")
            .flatMap(List<String>::parseDigits)
            .fold(
                { assertTrue(false) },
                { digits ->
                    digits.validate().fold(
                        { error ->
                            assertSame(error, ValidationError.IllegibleDigits)
                        },
                        { assertTrue(false) },
                    )
                },
            )
    }
}