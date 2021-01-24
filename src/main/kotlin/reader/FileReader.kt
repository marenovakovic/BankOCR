package reader

import arrow.core.Either

fun interface FileReader {
    fun readLines(fileName: String): Either<FileReadError, List<String>>
}