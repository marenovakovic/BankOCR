package reader

sealed class FileReadError {
    object IOException : FileReadError()
    object IncorrectCharacterCount : FileReadError()
}
