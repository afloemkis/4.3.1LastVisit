fun main() {
    val lastOnline =
        (System.currentTimeMillis() / 1000) - (60 * 60 * 74) // timestamp в секундах, соответствующий 04.04.2022, 12:20:00 GMT+3
    val agoText = agoToText(lastOnline)
    println(agoText) // "был(а) в сети 2 дня назад"
}

fun agoToText(lastOnline: Long): String {
    val currentTime = System.currentTimeMillis() / 1000
    val secondsPassed = currentTime - lastOnline

    return when {
        secondsPassed <= 60 -> "был(а) в сети только что"
        secondsPassed <= 60 * 60 -> "был(а) в сети ${minutesAgoText(secondsPassed)} назад"
        secondsPassed <= 24 * 60 * 60 -> "был(а) в сети ${hoursAgoText(secondsPassed)} назад"
        secondsPassed <= 2 * 24 * 60 * 60 -> "был(а) в сети вчера"
        secondsPassed <= 3 * 24 * 60 * 60 -> "был(а) в сети позавчера"
        else -> "был(а) в сети давно"
    }
}

fun minutesAgoText(secondsPassed: Long): String {
    val minutes = secondsPassed / 60
    return when {
        minutes in 11..14 -> "$minutes минут назад"
        (minutes % 10).toInt() == 1 -> "$minutes минуту назад"
        minutes % 10 in 2..4 -> "$minutes минуты назад"
        else -> "$minutes минут назад"
    }
}

fun hoursAgoText(secondsPassed: Long): String {
    val hours = secondsPassed / 3600
    return when {
        hours in 11..14 -> "$hours часов назад"
        (hours % 10).toInt() == 1 -> "$hours час назад"
        hours % 10 in 2..4 -> "$hours часа назад"
        else -> "$hours часов назад"
    }
}