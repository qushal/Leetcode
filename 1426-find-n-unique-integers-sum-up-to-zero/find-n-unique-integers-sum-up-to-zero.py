class Solution:
    def sumZero(self, n: int) -> List[int]:
        arr = [0] * n
        k = 0
        if n % 2 != 0:
            arr[k] = 0
            n -= 1
            k += 1
        for i in range(1, int(n/2)+1):
            arr[k] = i
            arr[k+1] = -i
            k += 2
        return arr
            

