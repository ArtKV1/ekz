fun delimetresOfNUp(n: Int, curr: Int = 1): Int
{
    if (curr > n) return 0;
    else
    {
        val count = if (n % curr == 0) 1 else 0
        return count + delimetresOfNUp(n, curr + 1)
    }
}

fun isPrime (n: Int): Boolean
{
    if (n < 2) return false;
    for (i in 2..n-1)
    {
        if (n % i == 0) return false;
    }
    return true;
}

fun sumOfDel(n: Int): Int
{
    var result = 0;
    for (i in 1..n)
    {
        if (n % i == 0) result++;
    }
    return result;
}


fun funcWithThreeArgs(list: List<Int>, p: (Int) -> Boolean, f: (Int) -> Int): List<Int>
{
    return list.filter(p).map(f);
}

fun sortList(list: List<Int>): List<Int>
{
    var map: MutableMap<Int, Int> = mutableMapOf();
    for (i in list)
    {
        map[i] = map.getOrDefault(i, 0) + 1;
    }

    val sortedMap = map.entries.sortedByDescending { it.value };
    var result: MutableList<Int> = mutableListOf<Int>();
    for (i in sortedMap)
    {
        val element = i.key
        val value = i.value
        repeat(value)
        {
            result.add(element)
        }

    }
    return result
}


fun main()
{
    println(delimetresOfNUp(2048));
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)
    println(funcWithThreeArgs(list, ::isPrime, ::sumOfDel))
    val list2 = listOf(5,6,2,2,3,3,3,5,5,5)
    println(sortList(list2))
}