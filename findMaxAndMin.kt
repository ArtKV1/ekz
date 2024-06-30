private fun MutableList<Int>.sumLrsForOnePerson(lr: List<String>): List<Int> {

    lr.mapIndexed { index, value ->
        when(value)
        {
            "" -> this[index] = this[index]
            else -> this[index] = this[index] + 1
        }

    }
    return this
}


private fun MutableList<Int>.sumKrsForOnePerson(kr: List<String>): List<Int>
{
    kr.mapIndexed { index, value ->
        when(value)
        {
            "-" -> this[index] = this[index]
            else -> this[index] = this[index] + 1
        }

    }
    return this
}



fun findMaxAndMin(persons: List<Person>, index: Int = 0, lrCount: List<Int> = listOf(0,0,0,0,0,0,0), krCount: List<Int> = listOf(0,0,0))
{
    if (persons.size == index)
    {
        println("Лабораторная работа которую выполнило наибольшее количество человек, которые не получили допуск: " + (lrCount.indexOfFirst {it == lrCount.max()} + 1))
        println("Контрольная работа которую выполнило наименьшее количество человек, которые получили допуск: " + (krCount.indexOfFirst {it == krCount.min()} + 1))
        return
    }
    val lrCountMutable = lrCount.toMutableList()
    val krCountMutable = krCount.toMutableList()

    when(persons[index].allowance)
    {
        1 -> lrCountMutable.sumLrsForOnePerson(persons[index].lr)
        2 -> krCountMutable.sumKrsForOnePerson(persons[index].kr)
        3 -> krCountMutable.sumKrsForOnePerson(persons[index].kr)
        4 -> krCountMutable.sumKrsForOnePerson(persons[index].kr)
        5 -> krCountMutable.sumKrsForOnePerson(persons[index].kr)
    }

    return findMaxAndMin(persons, index + 1, lrCountMutable, krCountMutable)
}