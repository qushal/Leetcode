class Solution {
    public int countPrimeSetBits(int left, int right) {
        Set<Integer> set = Set.of(2, 3, 5, 7, 11, 13, 17, 19);
        System.out.print(set);
        int count = 0;
        for(int i=left; i<=right; i++){
            int b = Integer.bitCount(i);
            if(set.contains(b)) count++;
        }
        return count;
    }
}