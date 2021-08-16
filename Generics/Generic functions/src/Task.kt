import java.util.*

fun <T, R : MutableCollection<T>> Collection<T>.partitionTo(x1: R, x2: R, block: (T) -> Boolean): Pair<R, R> {
    for (i in this) if (block(i)) x1.add(i) else x2.add(i)
    return Pair(x1, x2)
}

fun partitionWordsAndLines() {
    val (words, lines) = listOf("a", "a b", "c", "d e")
            .partitionTo(ArrayList(), ArrayList()) { s -> !s.contains(" ") }
    check(words == listOf("a", "c"))
    check(lines == listOf("a b", "d e"))
}

fun partitionLettersAndOtherSymbols() {
    val (letters, other) = setOf('a', '%', 'r', '}')
            .partitionTo(HashSet(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z' }
    check(letters == setOf('a', 'r'))
    check(other == setOf('%', '}'))
}
