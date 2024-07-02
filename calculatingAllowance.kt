fun calculatingAllowance(person: Person): PersonsWithAllowance
{
    var prolog = 0.0
    var lamda = 0.0
    var kotlin = 0.0

    person.ep.mapIndexed({index, ep ->
        when(index)
        {
            1 -> when(ep)
            {
                "д" -> prolog += 2
                "3" -> prolog += 3
                "4" -> prolog += 4
                "5" -> prolog += 5
            }
            2 -> when(ep)
            {
                "д" -> kotlin += 2
                "3" -> kotlin += 3
                "4" -> kotlin += 4
                "5" -> kotlin += 5
            }
        }
    })

    person.kr.mapIndexed({index, kr ->
        when(index)
        {
            0 -> when(kr)
            {
                "д" -> prolog += 2
                "3" -> prolog += 3
                "4" -> prolog += 4
                "5" -> prolog += 5
            }
            1 -> when(kr)
            {
                "д" -> lamda += 2
                "3" -> lamda += 3
                "4" -> lamda += 4
                "5" -> lamda += 5
            }
            2 -> when(kr)
            {
                "д" -> kotlin += 2
                "3" -> kotlin += 3
                "4" -> kotlin += 4
                "5" -> kotlin += 5
            }
        }
    })

    person.lr.mapIndexed({index, lr ->
        when(index)
        {
            0 -> when(lr)
            {
                "+" -> prolog += 0.5
                "++" -> prolog += 1
                "д" -> prolog += 2
                "3" -> prolog += 3
                "4" -> prolog += 4
                "5" -> prolog += 5
            }
            1 -> when(lr)
            {
                "+" -> prolog += 0.5
                "++" -> prolog += 1
                "д" -> prolog += 2
                "3" -> prolog += 3
                "4" -> prolog += 4
                "5" -> prolog += 5
            }
            2 -> when(lr)
            {
                "+" -> prolog += 0.5
                "++" -> prolog += 1
                "д" -> prolog += 2
                "3" -> prolog += 3
                "4" -> prolog += 4
                "5" -> prolog += 5
            }
            3 -> when(lr)
            {
                "+" -> lamda += 0.5
                "++" -> lamda += 1
                "д" -> lamda += 2
                "3" -> lamda += 3
                "4" -> lamda += 4
                "5" -> lamda += 5
            }
            4 -> when(lr)
            {
                "+" -> kotlin += 0.5
                "++" -> kotlin += 1
                "д" -> kotlin += 2
                "3" -> kotlin += 3
                "4" -> kotlin += 4
                "5" -> kotlin += 5
            }
            5 -> when(lr)
            {
                "+" -> kotlin += 0.5
                "++" -> kotlin += 1
                "д" -> kotlin += 2
                "3" -> kotlin += 3
                "4" -> kotlin += 4
                "5" -> kotlin += 5
            }
            6 -> when(lr)
            {
                "+" -> kotlin += 0.5
                "++" -> kotlin += 1
                "д" -> kotlin += 2
                "3" -> kotlin += 3
                "4" -> kotlin += 4
                "5" -> kotlin += 5
            }
        }
    })

    val total = (prolog + lamda + kotlin) / 60 * 100

    prolog = prolog / 25 * 100
    lamda = lamda / 10 * 100
    kotlin = kotlin / 25 * 100

    var totalString = ""

    if ((prolog >= 30) and (lamda >= 30) and (kotlin >= 30) and (total >= 30))
    {
        totalString = "допуск"
        if ((prolog > 60) and (total >= 60))
        {
            totalString = "удовл"
            if (((prolog > 75) and (kotlin > 75)) || ((prolog > 75) and (lamda > 75)) || ((prolog > 75) and (total > 75)) || ((kotlin > 75) and (lamda > 75)) || ((kotlin > 75) and (total > 75)) || ((lamda > 75) and (total > 75)))
            {
                totalString = "хорошо"
                if ((prolog > 90) || (lamda > 90) || (kotlin > 90) || (total > 90))
                {
                    totalString = "отлично"
                }
            }
        }
    }
    else
    {
        totalString = "недопуск"
    }

    val personsWithAllowance = PersonsWithAllowance()

    personsWithAllowance.fullName = person.fullname
    personsWithAllowance.totalPrecent = total
    personsWithAllowance.total = totalString
    personsWithAllowance.kotlinPrecent = kotlin
    personsWithAllowance.prologPrecent = prolog
    personsWithAllowance.lambdaPrecent = lamda

    return personsWithAllowance

}

fun getPersonsWithAllowance(persons: List<Person>, index: Int = 0, personsWithAllowance: MutableList<PersonsWithAllowance> = mutableListOf()): List<PersonsWithAllowance>
{
    if (index == persons.size) return personsWithAllowance

    personsWithAllowance.add(calculatingAllowance(persons[index]))

    return getPersonsWithAllowance(persons, index + 1, personsWithAllowance)
}

fun sortPersons(persons: List<Person>): List<PersonsWithAllowance>
{

    val personsWithAllowance = getPersonsWithAllowance(persons)

    val filtredPersonsWithAllowance = personsWithAllowance.filter {(it.total == "допуск") || (it.total == "удовл") || (it.total == "хорошо") || (it.total == "отлично")}
    val sortedPersonsWithAllowance = filtredPersonsWithAllowance.sortedByDescending { it.totalPrecent }

    return sortedPersonsWithAllowance
}

fun printAllowance(personsWithAllowance: List<PersonsWithAllowance>, index: Int = 0)
{
    if (personsWithAllowance.size == index) return
    println("${personsWithAllowance[index].fullName} ${personsWithAllowance[index].lambdaPrecent} ${personsWithAllowance[index].kotlinPrecent}, ${personsWithAllowance[index].prologPrecent}, ${personsWithAllowance[index].totalPrecent}, ${personsWithAllowance[index].total}")
    return printAllowance(personsWithAllowance, index + 1)
}


fun allowance(persons: List<Person>)
{
    val sortedAllowance = sortPersons(persons)
    printAllowance(sortedAllowance)
}