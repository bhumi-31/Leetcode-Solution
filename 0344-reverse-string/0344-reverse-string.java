class Solution {
    public void reverse(int start, int end, char[] s){
        while(start <= end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
    public void reverseString(char[] s) {
        reverse(0, s.length - 1, s);
    }
}