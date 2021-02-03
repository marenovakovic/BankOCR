# BankOCR

App can be run in Intellij IDEA and you pass file name as an argument. Only one argument can be passes. File in question has to be inside `input` directory.
`main` function could also be altered and passes file name.
Output is located in `output/output.txt` file.

1) Download `Java` from `https://www.java.com/en/download/`
2) Download `Intellij IDEA` from `https://www.jetbrains.com/idea/download`
3) Upon instalation of `Java` and `Intellij IDEA` open `Intellij IDEA` and select `File -> New -> Project from Version Control` and paste code from this `GitHub` repository
4) Edit run configuration in `Intellij IDEA` to add argument (arguments and files explained bellow) or pass the name directly inside `main` -> `InputFileReaderImpl.readLines(fileName)`
5) Press Play button to run the app
6) Observe results inside `output/putput.txt` file

Input file name is the name of the file inside `input` directory. For example, for file with path `input/input.txt` you just type `input.txt` and ommit `input/` directory.
