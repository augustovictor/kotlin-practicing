package delegate

import java.math.BigDecimal
import kotlin.properties.Delegates

class Employee {
    var name: String by Delegates.observable("", { property, oldValue, newValue -> run {
        println("The employee changed its property $property from \"$oldValue\" to \"$newValue\"")
    } })

    var salary: BigDecimal by Delegates.vetoable(BigDecimal.ZERO, { _, old, new ->
        if (new > old) {
            println("New value greater than old value. Change happening...")
            true
        } else {
            println("New value cannot be less than old value")
            false
        }
    })

    // Local delegate
    val remoteValue by lazy { fetchRemoteValue() }

    var greeting: String by Delegates.notNull()

    private fun fetchRemoteValue(): String {
        return "Value returned from remote call"
    }
}

val Employee.isLargeIncome: Boolean
    get() = this.salary > 100.toBigDecimal()

fun main(args: Array<String>) {
    val e = Employee()

    e.name = "Victor"
    e.name = "Victor Augusto"

    e.salary = 10.toBigDecimal()
    e.salary = 11.toBigDecimal()
    e.salary = 10.toBigDecimal()
    println("employee has large income: ${e.isLargeIncome}")
    e.salary = 200.toBigDecimal()
    println("employee has large income: ${e.isLargeIncome}")

    println(e.remoteValue)

    println(e.greeting)
}