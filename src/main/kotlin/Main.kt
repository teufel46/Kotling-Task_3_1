const val DAY : Int = 24*60*60
const val HOUR : Int = 60*60
const val MIN : Int = 60

fun main() {

    println("был(а) " + agoToText(5*DAY))
    println("был(а) " + agoToText(2*DAY + 5*HOUR))
    println("был(а) " + agoToText(1*DAY + 3*HOUR))
    println("был(а) " + agoToText(1*HOUR + 11*MIN))
    println("был(а) " + agoToText(6*HOUR + 11*MIN))
    println("был(а) " + agoToText(11*HOUR + 11*MIN))
    println("был(а) " + agoToText(16*HOUR + 11*MIN))
    println("был(а) " + agoToText(21*HOUR + 11*MIN))
    println("был(а) " + agoToText(22*HOUR + 11*MIN))
    println("был(а) " + agoToText(30*MIN))
    println("был(а) " + agoToText(24*MIN))
    println("был(а) " + agoToText(21*MIN))
    println("был(а) " + agoToText(11*MIN))
    println("был(а) " + agoToText(3*MIN))
    println("был(а) " + agoToText(1*MIN + 2))
    println("был(а) " + agoToText(24))
}

fun agoToText (countSec : Int) : String{
    var text : String = ""
    when {
        countSec > 3*DAY ->  text = "давно"
        countSec <= 3*DAY &&  countSec > 2*DAY ->  text = "вчера"
        countSec <= 2*DAY &&  countSec > 1*DAY ->  text = "сегодня"
        countSec in (HOUR + 1)..DAY ->
        {
            val hours : Int = (countSec/(HOUR)).toInt()
            text = "$hours час" + endHours(hours) + " назад"
        }
        countSec in (MIN + 1)..HOUR ->  {
            val minutes : Int = (countSec/(MIN)).toInt()
            text = "$minutes минут" + endMinutes(minutes) + " назад"
        }
        else -> text = "только что"
    }
    return text
}

fun endHours(hours : Int) = when (hours % 10){
    1 -> if (hours == 11) "ов" else ""
    2,3,4 -> "а"
    else -> "ов"
}

fun endMinutes(min : Int) = when (min % 10){
    1 -> if (min == 11) "" else "у"
    2,3,4 -> "ы"
    else -> ""
}