class Solution:
    def countPrimes(self, n: int) -> int:
        if n < 2:
            return 0
        prime_arr = [True] * n
        prime_arr[0] = prime_arr[1] = False

        p = 2
        while p*p < n:
            if prime_arr[p]:
                # then make it multiples false as they will not be prime
                for multiple in range(p*p, n, p):
                    prime_arr[multiple] = False
            p += 1
        
        return sum(prime_arr)