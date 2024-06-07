fun max(x: Int, y: Int, z: Int): Int
{
    if ((x > y) and (x > z)) return x;
    if (y > z) return y;
    return z;
}

fun factUp(n: Int): Int
{
    if (n == 0) return 1;
    return n * factUp(n - 1);
}

tailrec fun factDown(n: Int, f: Int = 1): Int
{
    return if (n == 0) f else factDown(n - 1, n * f);
}

fun sumOfNumbersUp(n: Int): Int
{
    if (n < 10) return n;
    val sum = n % 10;
    return sum + sumOfNumbersUp(n / 10)
}

tailrec fun sumOfNumbersDown(n: Int, f: Int = 0): Int
{
    return if (n == 0) f else sumOfNumbersDown(n / 10, f + n % 10);
}




fun main()
{
    // Нахождение max(X, Y, Z)
    println(max(3, 5, 2));
    val a = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(a.filter { it % 2 == 0 })
    println(a.map { it * 2 })
    println(a.reduce {sum, it -> it * sum})
    //fact(N) - рекурсия вниз и вверх
    /*println(factDown(5));
    println(factUp(5));
    println(sumOfNumbersUp(548621));
    println(sumOfNumbersDown(548621));*/
}
