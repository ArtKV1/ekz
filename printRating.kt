fun printRating(ratingList: List<Rating>, index: Int = 0)
{

    if (ratingList.size == index) return

    val rating = ratingList[index]

    val assessment = when (rating.total) {
        "5" -> "Отлично"
        "4" -> "Хорошо"
        "3" -> "Самокат"
        "2" -> "допуск"
        else -> "недопуск"
    }

    println("Группа: ${rating.group}, Фамилия ИО: ${rating.fullName}, " +
            "Аттестация: ${rating.attestation}, Экзамен: ${assessment}, " +
            "Посещаемость: ${rating.attendance}%, ЛР: ${rating.lr}%, " +
            "ЭП: ${rating.ep}%, КР: ${rating.kr}%, Допуск: ${rating.allowance}%, " +
            "Итого: ${rating.totalPercent}%")

    return printRating(ratingList, index + 1)
}


fun SortRating(persons: List<Person>) {
    val ratings = calculateRating(persons)

    val sortedRating = ratings.sortedWith(
        compareByDescending<Rating> { it.totalPercent > 30 }
            .thenByDescending { it.totalPercent }
            .thenByDescending { it.allowance }
    )


    val bestOfUnallowance = sortedRating.filter { it.total == "1" }.take(5)
    val worstOfAllowance = sortedRating.filter { it.total == "2" }.takeLast(5)


    fun getAssessment(total: String): String {
        return when (total) {
            "5" -> "Отлично"
            "4" -> "Хорошо"
            "3" -> "Самокат"
            "2" -> "допуск"
            else -> "недопуск"
        }
    }


    printRating(sortedRating)

    println()
    println()


    printRating(bestOfUnallowance)

    println()
    println()


    printRating(worstOfAllowance)
}
