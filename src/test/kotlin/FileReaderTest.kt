import reader.InputFileReaderImpl
import kotlin.test.Test
import kotlin.test.assertTrue

class FileReaderTest {

    @Test
    fun `should return file lines`() {
        val lines = InputFileReaderImpl.readLines("input/input.txt")

        assertTrue(lines.isRight())
        lines.fold(
            { assertTrue(false) },
            { value -> assertTrue(value.isNotEmpty()) },
        )
    }
}