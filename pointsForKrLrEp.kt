fun pointsForKrLrEp(persons: List<Person>)
{
    var attendance = 0.0

    for (person in persons)
    {
        attendance = (person.attendanceP + person.attendanceL).toDouble()
        println(attendance)
    }
}