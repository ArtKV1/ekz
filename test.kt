//Количество делителей числа
tailrec fun countDelimitersDown(n: Int, count: Int = 0, i: Int = 1): Int
{
    return if (n < i) count else { if (n % i == 0) countDelimitersDown(n, count + 1, i + 1) else  countDelimitersDown(n, count, i + 1)}
}

fun countDelimitersUp(n: Int, i: Int = 1): Int
{
    if (i > n) return 0
    var count = 0
    if (n % i == 0) count++
    return count + countDelimitersUp(n, i + 1)
}

//Факториал
tailrec fun factorialDown(n: Int, i: Int = 1): Int
{
    return if (n == 0) i else factorialDown(n - 1, i * n)
}

fun factorialUp(n: Int): Int
{
    if (n == 0) return 1
    return n * factorialUp(n - 1)
}


//НОД двух чисел
fun nodDown(a: Int, b: Int): Int
{
    return if (b == 0) return a else nodDown(b, a % b)
}



fun main()
{
    println(countDelimitersDown(7))
    println(countDelimitersUp(7))

    println(factorialDown(5))
    println(factorialUp(5))

    println(nodDown(42, 28))
}
