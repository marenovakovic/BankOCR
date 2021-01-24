package writer

import Digit
import arrow.core.Either
import java.io.IOException

interface DigitWriter {
    fun writeInvalidChecksumDigits(fileName: String, fileWriter: FileWriter, digits: List<Digit>): Either<IOException, Unit>
    fun writeDigits(fileName: String, fileWriter: FileWriter, digits: List<Digit>): Either<IOException, Unit>
}