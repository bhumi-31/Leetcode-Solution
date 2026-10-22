class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxi = 0;

        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);

            while(set.contains(ch)){
                char leftChar = s.charAt(left);
                set.remove(leftChar);
                left++;
            }

            set.add(ch);
            maxi = Math.max(maxi, right - left + 1);
        }

        return maxi;
    }
}