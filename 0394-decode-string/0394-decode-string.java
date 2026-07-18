class Solution {
    public String decodeString(String s) {
        Stack<Integer> st1 = new Stack<>();
        Stack<StringBuilder> st2 = new Stack<>();

        int currNum = 0;
        StringBuilder currStr = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {
                currNum = currNum * 10 + (ch - '0');
            } 
            else if (ch == '[') {
                st1.push(currNum);
                st2.push(currStr);

                currNum = 0;
                currStr = new StringBuilder();
            } 
            else if (ch == ']') {
                int repeatCount = st1.pop();
                StringBuilder prevStr = st2.pop();

                for (int j = 0; j < repeatCount; j++) {
                    prevStr.append(currStr);
                }

                currStr = prevStr;
            } 
            else {
                currStr.append(ch);
            }
        }

        return currStr.toString();
    }
}