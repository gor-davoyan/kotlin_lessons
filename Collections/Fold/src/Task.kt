// Return the set of products that were ordered by all customers
fun Shop.getProductsOrderedByAll(): Set<Product> {
    val allProducts = customers.flatMap { it.getOrderedProducts() }.toSet()
    return customers.fold(allProducts) { orderedByAll, customer ->
        orderedByAll.intersect(customer.getOrderedProducts())
    }
}

//val size = customers.size
//val result = mutableSetOf<Product>()
//val list = this.customers.flatMap { it.getOrderedProducts() }
//list.forEach { product ->
//    list.count { it == product }.let { if (it == size) result.add(product) }
//}
//return result

fun Customer.getOrderedProducts(): List<Product> =
        this.orders.flatMap { it.products }