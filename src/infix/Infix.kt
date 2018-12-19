package infix

infix fun Int.greaterThan(num: Int) = this > num

fun main(args: Array<String>) {
    println("1 is greater than 0: ${1 greaterThan 0}")
}