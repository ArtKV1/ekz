import java.io.File

fun fillPersons(): List<Person> {
    val persons = mutableListOf<Person>()

    val fileNames = listOf(
        "ФиЛП_2024 - 36_1.csv",
        "ФиЛП_2024 - 36_2.csv",
        "ФиЛП_2024 - 39.csv"
    )

    for ((index, fileName) in fileNames.withIndex()) {
        val file = File(fileName)
        val lines = file.readLines()

        for ((i, line) in lines.withIndex()) {
            if (i > 1) {
                val columns = line.split(",")


                if (columns[0].isEmpty()) {
                    break
                }

                val person = Person()
                person.id = columns[0].toInt()
                person.fullname = columns[1]
                person.extraPoint = if (columns[2] != "") { columns[2].toInt() } else { 0 }
                person.git = columns[3]


                person.attendanceL = columns.slice(4..15).count { it == "+" }


                val endIndex = if (index < 2) 27 else 29
                person.attendanceP = columns.slice(16..endIndex).count { it == "+" }


                val lrIndex = if (index < 2) 28 else 30
                person.lr = columns.slice(lrIndex..(lrIndex + 6))

                val epIndex = if (index < 2) 35 else 37
                person.ep = columns.slice(epIndex..(epIndex + 4))

                val krIndex = if (index < 2) 40 else 42
                person.kr = columns.slice(krIndex..(krIndex + 2))


                person.allowance = when (columns[79]) {
                    "недопуск" -> 1
                    "допуск" -> 2
                    "САМОКАТ" -> 3
                    "ХОРОШО" -> 4
                    "ОТЛИЧНО" -> 5
                    else -> 0
                }


                person.attestation = columns[if (index < 2) 78 else 80]


                person.group = when (index) {
                    0 -> "36_1"
                    1 -> "36_2"
                    2 -> "39"
                    else -> ""
                }

                persons.add(person)
            }
        }
    }

    return persons
}
