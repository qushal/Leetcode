class Solution:
    def countAndSay(self, n: int) -> str:
        if n == 1:
            return "1"
        result = "1"

        def helper(result: str) -> str:
            string = []
            count = 1
            prev = result[0]
            
            for i in range(1, len(result)):
                if(result[i] == prev):
                    count += 1
                else:
                    string.append(str(count))
                    string.append(prev)
                    count = 1
                    prev = result[i]
            
            string.append(str(count))
            string.append(prev)

            return "".join(string)

        for _ in range(n-1):
            result = helper(result)
        return result