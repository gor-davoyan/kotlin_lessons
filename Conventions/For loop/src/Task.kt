import java.lang.Exception
import java.lang.RuntimeException

class DateRange(val start: MyDate, val end: MyDate): Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {
            var temp = start
            override fun hasNext(): Boolean {
                return temp <= end
            }

            override fun next(): MyDate {
                if (hasNext()) {
                    val result = temp
                    temp = temp.followingDate()
                    return result
                }
                throw RuntimeException()
            }
        }
    }
}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}