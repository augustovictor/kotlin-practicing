package inlineFunctions

inline fun operation(op: () -> Unit) {
    // The inline copies the content of the function and pastes it where it's called
    println("Before calling op")
    op()
    println("After calling op")
}

inline fun operationWithLambda(noinline op: () -> Unit, op2: () -> Unit) {
    // We can set a parameter that receives a lambda function as noinline so its content is not copied to where it's called
    println("Before calling operationWithLambda")
    op()
    println("After calling operationWithLambda")
}

fun main(args: Array<String>) {
//    operation { println("This happens between...") }

    operationWithLambda({ println("This happens between...") }, { println("Happens between 2") })
}