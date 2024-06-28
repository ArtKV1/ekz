fun printRating(persons: List<Person>)
{
    val r = calculateRating(persons)
    val sortedRating = r.sortedWith(compareByDescending<Rating> { it.totalPercent > 30 }.thenByDescending { it.totalPercent }.thenByDescending { it.allowance })
    val bestOfUnallowance = sortedRating.filter {it.total == "1"}.take(5)
    val worstOfAllowance = sortedRating.filter {it.total == "2"}.takeLast(5)

    for (i in sortedRating)
    {
        val assessment = if (i.total == "5") { "Отлично" } else if (i.total == "4") { "Хорошо" } else if (i.total == "3") { "Самокат" } else if (i.total == "2") { "допуск" } else { "недопуск" }
        println("Группа: ${i.group}, Фамилия ИО: ${i.fullName}, Аттестация: ${i.attestation}, \tЭкзамен: ${assessment}, Посещаемость: ${i.attendance}%, ЛР: ${i.lr}%, ЭП: ${i.ep}%, КР: ${i.kr}%, Допуск: ${i.allowance}%, Итого: ${i.totalPercent}%")
    }
    println()
    println()
    for (i in bestOfUnallowance)
    {
        val assessment = if (i.total == "5") { "Отлично" } else if (i.total == "4") { "Хорошо" } else if (i.total == "3") { "Самокат" } else if (i.total == "2") { "допуск" } else { "недопуск" }
        println("Группа: ${i.group}, Фамилия ИО: ${i.fullName}, Аттестация: ${i.attestation}, \tЭкзамен: ${assessment}, Посещаемость: ${i.attendance}%, ЛР: ${i.lr}%, ЭП: ${i.ep}%, КР: ${i.kr}%, Допуск: ${i.allowance}%, Итого: ${i.totalPercent}%")
    }
    println()
    println()

    for (i in worstOfAllowance)
    {
        val assessment = if (i.total == "5") { "Отлично" } else if (i.total == "4") { "Хорошо" } else if (i.total == "3") { "Самокат" } else if (i.total == "2") { "допуск" } else { "недопуск" }
        println("Группа: ${i.group}, Фамилия ИО: ${i.fullName}, Аттестация: ${i.attestation}, \tЭкзамен: ${assessment}, Посещаемость: ${i.attendance}%, ЛР: ${i.lr}%, ЭП: ${i.ep}%, КР: ${i.kr}%, Допуск: ${i.allowance}%, Итого: ${i.totalPercent}%")
    }
}