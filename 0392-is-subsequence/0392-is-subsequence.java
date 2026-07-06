class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        for(int j = 0; j < t.length(); j++){
            char ch = t.charAt(j);

            if(i < s.length() && s.charAt(i) == ch){
                i++;
            }
        }
        return i == s.length();
    }
}