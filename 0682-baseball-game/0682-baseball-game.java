class Solution {
    public int calPoints(String[] operations) {
        Stack<String> st = new Stack<>();

        for(int i = 0; i < operations.length; i++){
            String ch = operations[i];

            if(ch.equals("C")){
                st.pop();
            }else if(ch.equals("D")){
                String top  = st.peek();
                int val = Integer.parseInt(top) * 2;
                st.push(String.valueOf(val));
            }else if(ch.equals("+")){
                String top1 = st.pop();
                String top2 = st.pop();
                st.push(top2);
                st.push(top1);
                int val = Integer.parseInt(top1) + Integer.parseInt(top2);
                st.push(String.valueOf(val));
            }else{
                st.push(ch);
            }
        }

        int sum = 0;
        while(!st.isEmpty()){
            int top = Integer.parseInt(st.peek());
            st.pop();
            sum += top;
        }

        return sum;
    }
}