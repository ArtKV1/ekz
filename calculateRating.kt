import kotlin.math.*

fun calculatingAttendance2(person: Person): Double {
    return when (person.group) {
        "39" -> (person.attendanceP.toDouble() / 14 * 5).roundTo1Decimal() + (person.attendanceL.toDouble() / 12 * 5).roundTo1Decimal()
        else -> (person.attendanceP.toDouble() / 12 * 5).roundTo1Decimal() + (person.attendanceL.toDouble() / 12 * 5).roundTo1Decimal()
    }
}


fun Double.roundTo1Decimal(): Double
{
    return "%.1f".format(this).replace(',', '.').toDouble()
}

fun calculateRatingForOnePerson(person: Person): Rating
{
    val allowanceScore = calculatingAttendance(person) + calculatingLr(person) + calculatingKr(person)
    val totalScore = calculatingTheTotal(calculatingAttendance(person), calculatingKr(person), calculatingLr(person), calculatingEp(person), person)

    val allowancePercent = (allowanceScore / 75 * 100)
    val atPercent = (calculatingAttendance2(person) / 10 * 100).roundToInt()

    val totalString = when {
        allowancePercent < 40 -> "1"
        totalScore / 100 >= 0.9 -> "5"
        totalScore / 100 >= 0.75 -> "4"
        totalScore / 100 >= 0.6 -> "3"
        else -> "2"
    }

    val personRating = Rating()
    personRating.group = person.group
    personRating.fullName = person.fullname
    personRating.attestation = person.attestation
    personRating.total = totalString
    personRating.attendance = atPercent
    personRating.lr = (calculatingLr(person) / 35 * 100).roundToInt()
    personRating.ep = (calculatingEp(person).toDouble() / 25 * 100).roundToInt()
    personRating.kr = (calculatingKr(person).toDouble() / 30 * 100).roundToInt()
    personRating.allowance = allowancePercent.roundTo1Decimal()
    personRating.totalPercent = round(totalScore).toInt()

    return personRating
}

fun calculateRating(persons: List<Person>, index: Int = 0, rating: MutableList<Rating> = mutableListOf()): List<Rating>
{

    if (persons.size == index) return rating

    val personRating: Rating = calculateRatingForOnePerson(persons[index])

    rating.add(personRating)

    return calculateRating(persons, index + 1, rating)
}



