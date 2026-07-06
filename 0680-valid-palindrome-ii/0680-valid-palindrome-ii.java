class Solution {
    public boolean isPalindrome(String s, int si, int ei){
        while(si <= ei){
            if(s.charAt(si) != s.charAt(ei)){
                return false;
            }
            si++;
            ei--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }

            left++;
            right--;
        }

        return true;
    }
}