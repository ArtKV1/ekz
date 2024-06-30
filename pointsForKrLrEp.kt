import kotlin.math.*

fun calculatingAttendance(person: Person): Double {
    val attendanceP = (person.attendanceP.toDouble() / 12 * 5).roundTo1Decimal()
    val attendanceL = (person.attendanceL.toDouble() / 12 * 5).roundTo1Decimal()

    val attendance = attendanceP + attendanceL

    return when {
        attendance < 4 -> 0.0
        attendance < 6 -> 4.0
        attendance < 7.5 -> 6.0
        attendance < 9 -> 8.0
        else -> 10.0
    }
}

fun Double.roundToDecimalPlaces(decimals: Int): Double {
    val factor = 10.0.pow(decimals)
    return (this * factor).roundToInt() / factor
}


fun calculatingKr(person: Person): Int {
    return person.kr.mapNotNull { item ->
        when (item) {
            "-" -> null
            "д" -> 4
            "3" -> 6
            "4" -> 8
            "5" -> 10
            else -> null
        }
    }.sum()
}


fun calculatingLr(person: Person): Double
{
    return person.lr.mapNotNull { item ->
        when (item)
        {
            "" -> null
            "+" -> 0.5
            "++" -> 1.0
            "д" -> 2.0
            "3" -> 3.0
            "4" -> 4.0
            "5" -> 5.0
            else -> null
        }
    }.sum()
}

fun calculatingEp(person: Person): Int {
    return person.ep.mapNotNull{ item ->
        when(item)
        {
            "" -> null
            "+" -> 2
            "3" -> 3
            "4" -> 4
            "5" -> 5
            else -> null
        }
    }.sum()
}


fun calculatingTheTotal (at: Double, kr: Int, lr: Double, ep: Int, person: Person): Double
{
    return at + kr + lr + ep + person.extraPoint
}

fun pointsForKrLrEp(persons: List<Person>, index: Int = 0)
{
    if (persons.size == index) return

    val attendance = calculatingAttendance(persons[index])
    val kr = calculatingKr(persons[index])
    val lr = calculatingLr(persons[index])
    val ep = calculatingEp(persons[index])
    val total = calculatingTheTotal(attendance, kr, lr, ep, persons[index])

    println("Студент: ${persons[index].fullname}, Посещаемость: ${attendance}, КР: ${kr}, ЭП: ${ep}, ИТОГО: ${total}")

    return pointsForKrLrEp(persons, index + 1)
}
