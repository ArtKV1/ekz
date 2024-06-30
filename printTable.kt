fun printTable(persons: List<Person>, index: Int = 0) {

    if (persons.size == index) return

    val person = persons[index]

    val at = calculatingAttendance(person)
    val kr = calculatingKr(person)
    val lr = calculatingLr(person)
    val ep = calculatingEp(person)

    val totalSum = at + lr + kr + ep + person.extraPoint
    val totalString = when {
        totalSum >= 90 -> "ОТЛЧИНО"
        totalSum >= 75 -> "ХОРОШО"
        totalSum >= 60 -> "САМОКАТ"
        totalSum >= 30 -> "допуск"
        else -> "недопуск"
    }

    val row = "№${person.id}, ФИО: ${person.fullname}, доп: ${person.extraPoint}, " +
            "ЛР1: ${person.lr[0]}, ЛР2: ${person.lr[1]}, ЛР3: ${person.lr[2]}, " +
            "ЛР4: ${person.lr[3]}, ЛР5: ${person.lr[4]}, ЛР6: ${person.lr[5]}, " +
            "ЛР7: ${person.lr[6]}, ЭП1: ${person.ep[0]}, ЭП2: ${person.ep[1]}, " +
            "ЭП3: ${person.ep[2]}, ЭП4: ${person.ep[3]}, ЭП5: ${person.ep[4]}, " +
            "КР1: ${person.kr[0]}, КР2: ${person.kr[1]}, КР3: ${person.kr[2]}, " +
            "Посещаемость: ${at}, ЛР: ${lr.toInt()}, ЭП: ${ep}, " +
            "КР: ${kr}, Допуск: ${at + lr + kr}, " +
            "ИТОГО: ${totalSum}, ат: ${person.attestation}, Экзамен: ${totalString}"

    println(row)

    return printTable(persons, index + 1)
}
