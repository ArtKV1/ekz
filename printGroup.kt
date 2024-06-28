fun printGroup(persons: List<Person>)
{
    val at = calculatingAttendance(persons)
    val lr = calculatingLr(persons)
    val kr = calculatingKr(persons)

    val rating = calculateRating(persons)

    var sum361 = 0.0
    var sum362 = 0.0
    var sum39 = 0.0
    var personsCount361 = 0.0
    var personsCount362 = 0.0
    var personsCount39 = 0.0
    for (i in 0..<persons.size)
    {
        if ((persons[i].group == "36_1") and ((rating[i].total).toInt() > 2))
        {
            sum361 += at[i] + lr[i] + kr[i]
            personsCount361++
        }
        else if ((persons[i].group == "36_2") and ((rating[i].total).toInt() > 2))
        {
            sum362 += at[i] + lr[i] + kr[i]
            personsCount362++
        }
        else if ((persons[i].group == "39") and ((rating[i].total).toInt() > 2))
        {
            sum39 += at[i] + lr[i] + kr[i]
            personsCount39++
        }
    }

    if ((sum361 / personsCount361 < sum362 / personsCount361) and (sum361 / personsCount361 < sum39 / personsCount39))
    {
        println("Группа в которой наименьший средний балл на допуск, среди тех кто получил оценки 3,4,5: 36_1")
    }
    else if ((sum362 / personsCount362 < sum361 / personsCount361) and (sum362 / personsCount362 < sum39 / personsCount39))
    {
        println("Группа в которой наименьший средний балл на допуск, среди тех кто получил оценки 3,4,5: 36_2")
    }
    else
    {
        println("Группа в которой наименьший средний балл на допуск, среди тех кто получил оценки 3,4,5: 39")
    }
}
