import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test

class MainTest {

    @Test
    fun `should have exactly one argument`() {
        assertThrows<IllegalArgumentException> {
            main(arrayOf("input.txt", "error_input.txt"))
        }

        assertThrows<IllegalArgumentException> {
            main(emptyArray())
        }

        assertDoesNotThrow {
            main(arrayOf("input.txt"))
        }
    }
}