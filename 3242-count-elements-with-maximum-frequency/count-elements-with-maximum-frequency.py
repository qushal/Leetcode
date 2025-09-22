class Solution:
    def maxFrequencyElements(self, nums: List[int]) -> int:
        count = 0
        freq = [0] * 101
        for num in nums:
            freq[num] += 1
        max_val = max(freq)
        for f in freq:
            if f == max_val:
                count += 1
        return max_val * count