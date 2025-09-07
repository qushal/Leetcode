class Solution:
    def maximumGain(self, s: str, x: int, y: int) -> int:

        def solve(sub: str, s: str, score: int):
            stack = []
            gain = 0
            for ch in s:
                if stack and stack[-1] == sub[0] and ch == sub[1]:
                    stack.pop()
                    gain += score
                else:
                    stack.append(ch)
            
            return gain, "".join(stack)
                

        total = 0
        if x > y:
            gain, s = solve("ab", s, x)
            total += gain
            gain, s = solve("ba", s, y)
            total += gain
        else:
            gain, s = solve("ba", s, y)
            total += gain
            gain, s = solve("ab", s, x)
            total += gain

        return total
