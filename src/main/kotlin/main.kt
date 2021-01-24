import arrow.core.Either
import arrow.core.flatMap
import reader.InputFileReaderImpl
import writer.DigitWriterImpl
import writer.OutputFileWriterImpl
import java.io.IOException

fun main(args: Array<String>) {
    if (args.size != 1) throw IllegalArgumentException("main accepts only one argument, name of input file")

    val fileName = args[0]
    InputFileReaderImpl.readLines(fileName)
        .flatMap { lines -> lines.parseDigits() }
        .fold(
            {},
            { digits ->
                digits.validate().fold(
                    { error -> handleError(error, digits) },
                    { DigitWriterImpl.writeDigits("output.txt", OutputFileWriterImpl, it) },
                )
            },
        )
}

private fun handleError(
    error: ValidationError,
    digits: List<Digit>,
): Either<IOException, Unit> = when (error) {
    ValidationError.InvalidSum ->
        DigitWriterImpl.writeInvalidChecksumDigits("output.txt", OutputFileWriterImpl, digits)
    ValidationError.IllegibleDigits ->
        DigitWriterImpl.writeDigits("output.txt", OutputFileWriterImpl, digits)
}