class Solution {
    public String decodeString(String s) {
        Stack<Integer> st1 = new Stack<>();
        Stack<String> st2 = new Stack<>();

        int currNum = 0;
        String currStr = "";

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                currNum = currNum * 10 + (ch - '0');
            }else if(ch == '['){
                st1.push(currNum);
                st2.push(currStr);
                currNum = 0;
                currStr = "";
            }else if(ch ==']'){
                int repeatCount = st1.peek();
                st1.pop();
                String prevStr = st2.peek();
                st2.pop();
                String repeatStr = "";
                for(int j = 0; j < repeatCount; j++){
                    repeatStr += currStr;
                }

                currStr = prevStr + repeatStr;
            }else{
                currStr += ch;
            }
        }
        return currStr;
    }
}