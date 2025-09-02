class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        n = len(hand)
        if n % groupSize != 0:
            return False
        
        count = Counter(hand)
        for card in sorted(hand):
            while count[card] > 0:
                for i in range(groupSize):
                    if count[i + card] == 0:
                        return False
                    count[i+card] -= 1
        
        return True