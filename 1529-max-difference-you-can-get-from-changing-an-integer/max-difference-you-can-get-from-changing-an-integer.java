class Solution {
    public int maxDiff(int num) {
        String s = Integer.toString(num);
        StringBuilder sb = new StringBuilder(s);
        char alter = '9';
        boolean foundDigit = false;

        for(int i=0; i<s.length(); i++){
            if(!foundDigit && s.charAt(i) != '9'){
                foundDigit = true;
                alter = s.charAt(i);
            }
            if(foundDigit && s.charAt(i) == alter){
                sb.setCharAt(i, '9');
            }
        }
        int max = Integer.parseInt(sb.toString());

        sb.setLength(0);
        sb.append(s);
        boolean setZero = false;
        boolean setOne = false;
        foundDigit = false;

        for(int i=0; i<s.length(); i++){
            if(!foundDigit && i==0 && s.charAt(i) != '1'){
                setOne = true;
                alter = s.charAt(i);
                foundDigit = true;
            }
            if(!foundDigit && s.charAt(i) != '0' && i != 0 && s.charAt(i) != s.charAt(0)){
                setZero = true;
                alter = s.charAt(i);
                foundDigit = true;
            }
            if(setOne && s.charAt(i) == alter){
                sb.setCharAt(i, '1');
            }
            if(setZero && s.charAt(i) == alter){
                sb.setCharAt(i, '0');
            }
        }
        int min = Integer.parseInt(sb.toString());
        return max - min;
    }
}