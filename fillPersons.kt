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
