fun calculatingAttendance(persons: List<Person>) : List<Double>
{
    val list = mutableListOf<Double>()

    for (person in persons)
    {
        var attendanceP = (person.attendanceP).toDouble() / 12 * 5
        var attendanceL = (person.attendanceL).toDouble() / 12 * 5

        var roundedAttendanceP = String.format("%.1f", attendanceP).replace(",", ".").toDouble()
        var roundedAttendanceL = String.format("%.1f", attendanceL).replace(",", ".").toDouble()

        var attendance = roundedAttendanceP + roundedAttendanceL

        if (attendance < 4)
        {
            attendance = 0.0
        }
        else if (attendance < 6)
        {
            attendance = 4.0
        }
        else if ((attendance >= 6) and (attendance < 7.5))
        {
            attendance = 6.0
        }
        else if (attendance < 9)
        {
            attendance = 8.0
        }
        else
        {
            attendance = 10.0
        }

        list.add(attendance)
    }

    return list
}

fun calculatingKr(persons: List<Person>) : List<Int>
{
    val list = mutableListOf<Int>()
    for (person in persons)
    {
        var sum = 0
        for (item in person.kr)
        {
            if (item == "-") {}
            else if (item == "д")
            {
                sum += 4
            }
            else if (item == "3")
            {
                sum += 6
            }
            else if (item == "4")
            {
                sum += 8
            }
            else if (item == "5")
            {
                sum += 10
            }
        }
        list.add(sum)
    }
    return list
}

fun calculatingLr(persons: List<Person>) : List<Double>
{
    val list = mutableListOf<Double>()
    for (person in persons)
    {
        var sum = 0.0
        for (item in person.lr)
        {
            if (item == "") {}
            else if (item == "+")
            {
                sum += 0.5
            }
            else if (item == "++")
            {
                sum += 1
            }
            else if (item == "д")
            {
                sum += 2
            }
            else if (item == "3")
            {
                sum += 3
            }
            else if (item == "4")
            {
                sum += 4
            }
            else if (item == "5")
            {
                sum += 5
            }
        }
        list.add(sum)
    }
    return list
}

fun calculatingEp(persons: List<Person>) : List<Int>
{
    val list = mutableListOf<Int>()
    for (person in persons)
    {
        var sum = 0
        for (item in person.ep)
        {
            if (item == "") {}
            else if (item == "+")
            {
                sum += 2
            }
            else if (item == "3")
            {
                sum += 3
            }
            else if (item == "4")
            {
                sum += 4
            }
            else if (item == "5")
            {
                sum += 5
            }
        }
        list.add(sum)
    }
    return list
}

fun calculatingTheTotal (at: List<Double>, kr: List<Int>, lr: List<Double>, ep: List<Int>, persons: List<Person>): List<Double>
{
    val list = mutableListOf<Double>()
    for (i in 0 ..< at.size)
    {
        list.add(at[i] + kr[i] + lr[i] + ep[i] + persons[i].extraPoint)
    }
    return list
}

fun pointsForKrLrEp(persons: List<Person>)
{
    println(calculatingAttendance(persons))
    println(calculatingKr(persons))
    println(calculatingLr(persons))
    println(calculatingEp(persons))
    println(calculatingTheTotal(calculatingAttendance(persons), calculatingKr(persons), calculatingLr(persons), calculatingEp(persons), persons))
}