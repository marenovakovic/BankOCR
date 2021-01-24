package reader

import arrow.core.Either
import java.io.File
import java.io.IOException

object InputFileReaderImpl : FileReader {
    override fun readLines(fileName: String): Either<FileReadError, List<String>> =
        try {
            val lines = File("input/$fileName").readLines()
            lines.forEach { line ->
                if (line.length != 27)
                    return Either.Left(FileReadError.IncorrectCharacterCount)
            }
            Either.Right(lines)
        } catch (ioException: IOException) {
            Either.Left(FileReadError.IOException)
        }
}