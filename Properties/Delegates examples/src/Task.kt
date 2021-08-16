class LazyProperty(val initializer: () -> Int) {
    val lazyValue: Int by lazy {
        return@lazy initializer()
    }
}

