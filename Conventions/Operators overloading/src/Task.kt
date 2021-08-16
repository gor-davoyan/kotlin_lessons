import TimeInterval.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

data class TInterval(val timeInterval: TimeInterval, val num: Int)

// Supported intervals that might be added to dates:
enum class TimeInterval { DAY, WEEK, YEAR }

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate {
    return this.addTimeIntervals(timeInterval, 1)
}

operator fun MyDate.plus(timeInterval: TInterval): MyDate {
    return this.addTimeIntervals(timeInterval.timeInterval, timeInterval.num)
}

operator fun TimeInterval.times(number: Int): TInterval {
    return TInterval(this, number)
}

fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

fun task2(today: MyDate): MyDate {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}
