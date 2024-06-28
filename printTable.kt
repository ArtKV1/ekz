fun printTable(persons: List<Person>)
{
    var at = calculatingAttendance(persons)
    var kr = calculatingKr(persons)
    var lr = calculatingLr(persons)
    var ep = calculatingEp(persons)
    var total = calculatingTheTotal(calculatingAttendance(persons), calculatingKr(persons), calculatingLr(persons), calculatingEp(persons), persons)
    for (i in 0..persons.count()-1)
    {
        val totalSum = at[i] + lr[i] + kr[i] + ep[i]+ persons[i].extraPoint
        val totalString = if (totalSum >= 90) "ОТЛЧИНО" else if (totalSum >= 75) "ХОРОШО" else if (totalSum >= 60) "САМОКАТ" else if (totalSum >= 30)  "допуск" else "недопуск"
        println("№${persons[i].id}, ФИО: ${persons[i].fullname}, доп: ${persons[i].extraPoint}, ЛР1: ${persons[i].lr[0]}, ЛР2: ${persons[i].lr[1]}, ЛР3: ${persons[i].lr[2]}, ЛР4: ${persons[i].lr[3]}, ЛР5: ${persons[i].lr[4]}, ЛР6: ${persons[i].lr[5]}, ЛР7: ${persons[i].lr[6]}, ЭП1: ${persons[i].ep[0]}, ЭП2: ${persons[i].ep[1]}, ЭП3: ${persons[i].ep[2]}, ЭП4: ${persons[i].ep[3]}, ЭП5: ${persons[i].ep[4]}, КР1: ${persons[i].kr[0]}, КР2: ${persons[i].kr[1]}, КР3: ${persons[i].kr[2]}, Посещаемость: ${at[i]}, ЛР: ${lr[i].toInt()}, ЭП: ${ep[i]}, КР: ${kr[i]}, Допуск: ${at[i] + lr[i] + kr[i]}, ИТОГО: ${totalSum}, ат: ${persons[i].attestation}, Экзамен: ${totalString}")
    }
}
