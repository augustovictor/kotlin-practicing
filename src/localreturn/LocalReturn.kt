package localreturn

fun containingFunction() {
    val numbers = 1..100
    numbers.forEach firstForEach@ {
        numbers.forEach innerForeach@ {
            if(it % 5 == 0) return@innerForeach
        }
    }
    println("Hello guys!")
}

fun main(args: Array<String>) {
    containingFunction()
}