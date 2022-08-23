fun main() {
    val time = 64000// время в секундах
    println(agoToText(time))
}
fun agoToText(time: Int): String = when {
    // минуты
    time > 60 && time < 60 * 60 && checkTime(time/60) == 0 -> "был(а) в сети " + (time/60).toString() + " минут назад"
    time > 60 && time < 60 * 60 && checkTime(time/60) == 1 -> "был(а) в сети " + (time/60).toString() + " минуту назад"
    time > 60 && time < 60 * 60 && checkTime(time/60) == 2 -> "был(а) в сети " + (time/60).toString() + " минуты назад"

    // часы
    time >= 60 * 60 && time < 24 * 60 * 60 && checkTime(time/3600) == 0 -> "был(а) в сети " + (time/3600).toString() + " часов назад"
    time >= 60 * 60 && time < 24 * 60 * 60 && checkTime(time/3600) == 1 -> "был(а) в сети " + (time/3600).toString() + " час назад"
    time >= 60 * 60 && time < 24 * 60 * 60 && checkTime(time/3600) == 2 -> "был(а) в сети " + (time/3600).toString() + " часа назад"

    // дни
    time >= 24 * 60 * 60 && time < 48 * 60 * 60 -> "был(а) в сети сегодня"
    time >= 48 * 60 * 60 && time < 72 * 60 * 60 -> "был(а) в сети вчера"
    time >= 72 * 60 * 60  -> "был(а) в сети давно"

    else -> "был только что"
}

/* проверка времени функцией  checkTime:
Сценарий 0 - от 11 до 19, заканчивается на 0, от 5 до 9
Сценарий 1 - заканчивается на 1
Сценарий 2 - остальные варианты
*/
fun checkTime(time : Int) : Int = when {
    (time % 100 >= 10 && time % 100 <= 19) || (time % 10 == 0) || (time % 10 >=5 && time % 10 <=9) -> 0
    time % 10 == 1 -> 1
    else -> 2
}