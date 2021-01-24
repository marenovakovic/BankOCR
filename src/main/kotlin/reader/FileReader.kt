package reader

import arrow.core.Either
import java.io.IOException

fun interface FileReader {
    fun readLines(fileName: String): Either<IOException, List<String>>
}