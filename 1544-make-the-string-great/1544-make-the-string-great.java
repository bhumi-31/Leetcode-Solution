class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for(int i = 0 ; i < s.length(); i++){
            char ch = s.charAt(i);

            if(!st.isEmpty() && Math.abs(ch - st.peek()) == 32){
                st.pop();
            }else{
                st.push(ch);
            }
        }

        while(!st.isEmpty()){
            sb.append(st.peek());
            st.pop();
        }

        sb.reverse();
        return sb.toString();
    }
}