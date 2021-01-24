package writer

import arrow.core.Either
import java.io.File
import java.io.IOException

object OutputFileWriterImpl : FileWriter {
    override fun writeText(fileName: String, text: String): Either<IOException, Unit> {
        return try {
            val file = File("output/$fileName")
            if (file.exists()) file.delete()
            file.writeText(text)
            Either.Right(Unit)
        } catch (ioException: IOException) {
            Either.Left(ioException)
        }
    }
}