package anonymous

fun calculateAndCallback(name: String, op: (word: String) -> Unit) {
    println("Do some stuff with name $name")
    op(name)
}

fun main(args: Array<String>) {
    calculateAndCallback("victor", { word -> println("The given name from callback is $word") })

    calculateAndCallback("victor", fun(word) {
        if (word.length > 3) return println("The name $word is a name > 3")

        return println("The name $word is a name <= 2")
    })
}