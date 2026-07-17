class Solution {
    public int evalRPN(String[] tokens) {
       Stack<Integer> st = new Stack<>();

       for(String s : tokens){
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
            int a = st.peek();
            st.pop();
            int b = st.peek();
            st.pop();

            if(s.equals("+")) st.push(a + b);
            if(s.equals("-")) st.push(b - a);
            if(s.equals("*")) st.push(a * b);
            if(s.equals("/")) st.push(b / a);
        }else{
            st.push(Integer.parseInt(s));
        }
       } 
       return st.peek();
    }
}