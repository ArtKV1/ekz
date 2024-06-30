fun printGroup(persons: List<Person>, index: Int = 0, mapOfGroups: MutableMap<String, MutableList<Int>> = mutableMapOf()) {

    if (persons.size == index)
    {
        println("Группа в которой наименьший средний балл на допуск, среди тех кто получил оценки 3,4,5: ${mapOfGroups.minBy {it.value[1] / it.value[0]}.key}")
        return
    }

    val person: Person = persons[index]

    val at = calculatingAttendance(person)
    val lr = calculatingLr(person)
    val kr = calculatingKr(person)

    val rating = calculateRatingForOnePerson(persons[index])

    if (rating.total.toInt() > 2) {
        val list = mapOfGroups.getOrPut(person.group) { mutableListOf() }

        if (!list.isEmpty()) {
            list[0] = list[0] + 1
            list[1] = list[1] + (lr + kr + at).toInt()
        } else {
            list.add(1)
            list.add((lr + kr + at).toInt())
        }

        mapOfGroups[person.group] = list
    }

    return printGroup(persons, index + 1, mapOfGroups)
}
