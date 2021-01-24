package writer

import Digit
import arrow.core.Either
import convertToString
import java.io.IOException

object DigitWriterImpl : DigitWriter {
    override fun writeInvalidChecksumDigits(
        fileName: String,
        fileWriter: FileWriter,
        digits: List<Digit>,
    ): Either<IOException, Unit> {
        val text = digits.convertToString() + " ERR"
        return fileWriter.writeText(fileName, text)
    }

    override fun writeDigits(fileName: String, fileWriter: FileWriter, digits: List<Digit>): Either<IOException, Unit> {
        val text = digits.convertToString() + " ILL"
        return fileWriter.writeText(fileName, text)
    }
}