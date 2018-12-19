package delegate

class Customer

interface Repository {
    fun findById(id: Int): Customer
    fun findAll(): List<Customer>
}

interface Logger {
    fun logAll()
}

// Delegation of member functions
class CustomerController(repository: Repository, logger: Logger): Repository by repository, Logger by logger {
    fun getById(id: Int): Customer {
        logAll()
        return findById(id)
    }
}

fun main(args: Array<String>) {

}