class Solution {
    public boolean isVowel(char ch ){

        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        return false;
    }
    public int maxVowels(String s, int k) {
        int left = 0;
        int maxi = 0;
        int count = 0;

        for(int i = 0; i < k; i++){
            if(isVowel(s.charAt(i))){
                count++;
            }
        }

        maxi = count;

        for(int i = k; i < s.length(); i++){
            if(isVowel(s.charAt(i - k))){
                count--;
            }

            if(isVowel(s.charAt(i))){
                count++;
            }

            maxi = Math.max(maxi, count);
        }

        return maxi;
    }
}