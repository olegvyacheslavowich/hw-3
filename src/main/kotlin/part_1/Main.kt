package part_1

fun main() {

    val sec = 150000;
    print("Был в сети ${agoToText(sec)}")

}

fun agoToText(sec: Int): String {

    val minute = 60
    val hour = minute * 60
    val day = hour * 24
    val day2 = day * 2
    val day3 = day * 3

    return when (sec) {
        in 0..minute -> "только что"

        in minute + 1..hour -> {
            val currentMinute = sec / 60
            val ending = getEnding(time = currentMinute)
            "$currentMinute $ending назад"
        }
        in hour + 1..day -> {
            val currentHour = sec / (60 * 60)
            val ending = getEnding(false, currentHour)
            "$currentHour $ending назад"
        }
        in day + 1..day2 -> "сегодня"
        in day2 + 1..day3 -> "вчера"
        else -> "давно"
    }
}

fun getEnding(isMinute: Boolean = true, time: Int): String {
    val timeString = time.toString()
    val lastChar = timeString.last()

    return if (isMinute) {
        when (lastChar) {
            '1' -> "минуту"
            '2', '3', '4' -> "минуты"
            else -> "минут"
        }
    } else {
        when (lastChar) {
            '1' -> "час"
            '2', '3', '4' -> "часа"
            else -> "часов"
        }
    }
}