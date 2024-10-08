fun fold (list: List<Int>, initial: Int, operator: (Int, Int) -> Int, index: Int = 0) : Int
{
    if (index == list.size) return initial
    var accum = operator(initial, list[index])
    return fold(list, accum, operator, index + 1)
}

fun main2()
{
    val list = listOf(1,2,3,4,5)
    val res = fold(list, 1, operator = {acc, num -> acc * num})
    println(res)
}


fun main(args : Array<String>)
{

    val persons = fillPersons()
    //1 Прочитать суммарные баллы и оценки. Найти лабораторную работу, которую
    //выполнили наибольшее количество человек на любую оценку среди неполучивших допуск.
    //Найти КР, которую выполнили наименьшее количество человек хотя бы на допуск среди не
    //поливших допуск.
//    findMaxAndMin(persons)
    //2 Рассчитать самостоятельно в программе баллы за посещаемость, КР, ЛР и ЭП так же,
    //как в документе. Найти сумму баллов и вывести количество баллов за посещаемость, ЛР, ЭП,
    //КР, ИТОГО для каждого студента.
//    println()
//    println()
//    pointsForKrLrEp(persons)
    //3 Сформировать рейтинг так же, как и в разделе рейтинг программно. Вывести 5
    //худших среди получивших допуск, сгруппировав их по группам. Вывести 5 лучших среди не
    //получивших допуск, сгруппировав их по группам в том же формате, как и в разделе рейтинг,
    //то есть выводить проценты сделанного.
//    println()
//    println()
//    SortRating(persons)
    //4 Сформировать программно раздел группы так же, как сформировано в таблице и
    //вывести на экран.
//    println()
//    println()
//    printTable(persons)
    //5 Найти группу, в которой наименьший средний балл на допуск среди тех, кто получил
    //оценки 3, 4, 5
//    println()
//    println()
//    printGroup(persons)

    // Там что-то с 30% по четерём параметрам
//    allowance(persons)
}
