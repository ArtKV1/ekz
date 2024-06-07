fac(0, 1).
fac(N, Result) :- N > 0, N1 is N - 1, fac(N1, Result1), Result is N * Result1.