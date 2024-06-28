import kotlin.math.round

fun calculatingAttendance2(persons: List<Person>) : List<Double>
{
    val list = mutableListOf<Double>()

    for (person in persons)
    {
        var attendanceP = (person.attendanceP).toDouble() / 12 * 5
        var attendanceL = (person.attendanceL).toDouble() / 12 * 5

        var roundedAttendanceP = String.format("%.1f", attendanceP).replace(",", ".").toDouble()
        var roundedAttendanceL = String.format("%.1f", attendanceL).replace(",", ".").toDouble()

        var attendance = roundedAttendanceP + roundedAttendanceL

        list.add(attendance)
    }

    return list
}


fun calculateRating(persons: List<Person>): List<Rating>
{
    val ratings = mutableListOf<Rating>()

    val at = calculatingAttendance(persons)
    val at2 = calculatingAttendance2(persons)
    val kr = calculatingKr(persons)
    val lr = calculatingLr(persons)
    val ep = calculatingEp(persons)
    val total = calculatingTheTotal(calculatingAttendance(persons), calculatingKr(persons), calculatingLr(persons), calculatingEp(persons), persons)
    for (i in 0 ..< at.size)
    {
        val allowance = at[i] + lr[i] + kr[i]
        val totalString = if (allowance / 75 < 0.4) { "1" } else if (total[i] / 100 >= 0.9) {"5"} else if (total[i] / 100 >= 0.75) { "4" }
                            else if (total[i] / 100 >= 0.6) { "3" } else { "2" }
        val atPercent = String.format("%.0f", (at2[i] / 10 * 100)).replace(",", ".").toDouble()
//        println("Группа: 36_1, Фамилия ИО: ${persons[i].fullname}, Аттестация: ${persons[i].attestation}, Экзамен: ${totalString}, Посещаемость: ${round(atPercent).toInt()}%, ЛР: ${round(lr[i] / 35 * 100).toInt()}%, ЭП: ${round(ep[i].toDouble() / 25 * 100).toInt()}%, КР: ${round(kr[i].toDouble() / 30 * 100).toInt()}%, Допуск: ${String.format("%.1f", (allowance / 75 * 100)).replace(",", ".")}%, Итого: ${round(total[i]).toInt()}%")

        val personRating = Rating()
        personRating.group = persons[i].group
        personRating.fullName = persons[i].fullname
        personRating.attestation = persons[i].attestation
        personRating.total = totalString
        personRating.attendance = round(atPercent).toInt()
        personRating.lr = round(lr[i] / 35 * 100).toInt()
        personRating.ep = round(ep[i].toDouble() / 25 * 100).toInt()
        personRating.kr  = round(kr[i].toDouble() / 30 * 100).toInt()
        personRating.allowance = String.format("%.1f", (allowance / 75 * 100)).replace(",", ".").toDouble()
        personRating.totalPercent = round(total[i]).toInt()

        ratings.add(personRating)
    }

    return ratings
}
