class Solution {
    public String removeKdigits(String num, int k) {
        
        Stack<Character> stack = new Stack<>();
        for(char c: num.toCharArray()){
            while(!stack.isEmpty() && stack.peek() > c && k > 0){
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        while(k > 0){
            stack.pop();
            k--;
        }
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()){
            ans.insert(0, stack.pop());
        }
        while (ans.length() > 0 && ans.charAt(0) == '0') {
            ans.deleteCharAt(0);
        }
        if(ans.length() < 1) return "0";
        return ans.toString();
    }
}