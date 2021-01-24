package reader

import arrow.core.Either
import java.io.File
import java.io.IOException

object InputFileReaderImpl : FileReader {
    override fun readLines(fileName: String): Either<IOException, List<String>> =
        try {
            Either.Right(File("input/$fileName").readLines())
        } catch (ioException: IOException) {
            Either.Left(ioException)
        }
}