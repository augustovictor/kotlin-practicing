package tailRecursion

fun divideWord(word: String, numPerLine: Int): String {
    var res = ""
    val wordSubs = word.substring(0, numPerLine)
    if (word.length > numPerLine) res += wordSubs + "\n"
    return res
}

// Recursion optimization
tailrec fun divideWord2(word: String, numPerLine: Int): String {
    var res = ""
    val wordSubs = word.substring(0, numPerLine)
    if (word.length > numPerLine) res += wordSubs
    return divideWord2(word.substring(numPerLine, -1), numPerLine)
}

fun main(args: Array<String>) {
    divideWord("victor", 1)
}