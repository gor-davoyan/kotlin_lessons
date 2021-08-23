// Return customers who have more undelivered orders than delivered
fun Shop.getCustomersWithMoreUndeliveredOrders(): Set<Customer> {
    val block: (Customer) -> Boolean = {
        val (delivered, undelivered) = it.orders.partition { it.isDelivered }
        undelivered.size > delivered.size
    }
    return this.customers.filter(block).toSet()
}

