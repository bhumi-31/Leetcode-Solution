class Solution {
    public String simplifyPath(String path) {
        int n = path.length();
        ArrayList<String> st = new ArrayList<>();

        int i = 0;

        while(i < n){
            while(i < n && path.charAt(i) == '/'){
                i++;
            }

            String temp = "";
            while(i < n && path.charAt(i) != '/'){
                temp += path.charAt(i);
                i++;
            }

            if(temp.equals("..")){
                if(!st.isEmpty()){
                    st.remove(st.size() - 1);
                }
            }

            else if(temp.equals(".") || temp.equals("")){
                continue;
            }else{
                st.add(temp);
            }
        }

        if (st.isEmpty()) {
            return "/";
        }


        StringBuilder ans = new StringBuilder();

        for(String dir : st){
            ans.append('/').append(dir);
        }

        return ans.toString();
    }
}