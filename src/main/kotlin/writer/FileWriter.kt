package writer

import arrow.core.Either
import java.io.IOException

fun interface FileWriter {
    fun writeText(fileName: String, text: String): Either<IOException, Unit>
}