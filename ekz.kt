import java.io.File

fun fillPersons() : List<Person>
{
    val file = File("ФиЛП_2024 - 36_1.csv");
    val lines = file.readLines();
    var i = 0
    val persons = mutableListOf<Person>()
    for (line in lines)
    {
        if (i == 0)
        {
            val columns = line.split(",");
        }
        if (i > 1)
        {
            val person = Person()
            val columns = line.split(",");

            if (columns[0] == "")
            {
                break;
            }

            person.id = columns[0].toInt();
            person.fullname = columns[1];
            person.extraPoint = columns[2].toInt();
            person.git = columns[3];

            var count: Int = 0;
            for (j in 4..15)
            {
                if (columns[j] == "+")
                {
                    count += 1;
                }
            }
            person.attendanceL = count;

            count = 0;
            for (j in 16..27)
            {
                if (columns[j] == "+")
                {
                    count++;
                }
            }
            person.attendanceP = count;

            var listLR = columns.slice(28..34)
            person.lr = listLR

            var listEP = columns.slice(35..39)
            person.ep = listEP

            var listKR = columns.slice(40..42)
            person.kr = listKR

            var allow = columns[79]
            var allowance: Int = 0
            if (allow == "недопуск")
            {
                allowance = 1;
            }
            else if (allow == "допуск")
            {
                allowance = 2;
            }
            else if (allow == "САМОКАТ")
            {
                allowance = 3;
            }
            else if (allow == "ХОРОШО")
            {
                allowance = 4;
            }
            else if (allow == "ОТЛИЧНО")
            {
                allowance = 5;
            }
            person.allowance = allowance;

            persons.add(person);
        }
        i++;
    }

    return persons;
}

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


fun main()
{
    val persons = fillPersons();
    // №1 из списка
    findMaxAndMin(persons);
    // №2 из списка

}

class Person
{
    var id: Int = 0
        get() = field
        set(value)
        {
            field = value
        }

    var fullname: String = ""
        get() = field
        set(value)
        {
            field = value
        }

    var extraPoint: Int = 0
        get() = field
        set(value)
        {
            field = value
        }

    var git: String = ""
        get() = field
        set(value)
        {
            field = value
        }

    var attendanceL: Int = 0
        get() = field
        set(value)
        {
            field = value
        }

    var attendanceP: Int = 0
        get() = field
        set(value)
        {
            field = value
        }

    var lr: List<String> = listOf()
        get() = field
        set(value)
        {
            field = value
        }

    var ep: List<String> = listOf()
        get() = field
        set(value)
        {
            field = value
        }

    var kr: List<String> = listOf()
        get() = field
        set(value)
        {
            field = value
        }

    var allowance: Int = 0
        get() = field
        set(value)
        {
            field = value
        }
}