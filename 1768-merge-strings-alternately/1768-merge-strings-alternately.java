class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        StringBuilder ans = new StringBuilder();

        int i = 0;
        int j = 0;

        while(i < n && j < m){
            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(j);

            ans.append(ch1);
            i++;
            ans.append(ch2);
            j++;
        }

        while(i < n){
            ans.append(word1.charAt(i++));
        }

        while(j < m){
            ans.append(word2.charAt(j++));
        }

        return ans.toString();
    }
}