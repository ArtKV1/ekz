fun findMaxAndMin(persons: List<Person>)
{
    val list = mutableListOf(0,0,0,0,0,0,0)
    val list2 = mutableListOf(0,0,0)
    for (person in persons)
    {
        if (person.allowance == 1)
        {
            if (person.lr[0] != "")
            {
                list[0] = list[0] + 1;
            }
            if (person.lr[1] != "")
            {
                list[1] = list[1] + 1;
            }
            if (person.lr[2] != "")
            {
                list[2] = list[2] + 1;
            }
            if (person.lr[3] != "")
            {
                list[3] = list[3] + 1;
            }
            if (person.lr[4] != "")
            {
                list[4] = list[4] + 1;
            }
            if (person.lr[5] != "")
            {
                list[5] = list[5] + 1;
            }
            if (person.lr[6] != "")
            {
                list[6] = list[6] + 1;
            }

            if (person.kr[0] != "-")
            {
                list2[0] = list2[0] + 1;
            }
            if (person.kr[1] != "-")
            {
                list2[1] = list2[1] + 1;
            }
            if (person.kr[2] != "-")
            {
                list2[2] = list2[2] + 1;
            }

        }
    }
    val maxIndex = list.indexOf(list.maxOrNull())
    val minIndex = list2.indexOf(list2.minOrNull())

    println("Лабораторная работа которую выполнило наибольшее количество человек, которые не получили допуск: ${maxIndex+1}")
    println("Контрольная работа которую выполнило наименьшее количество человек, которые не получили допуск: ${minIndex+1}")
}