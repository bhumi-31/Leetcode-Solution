// Sliding Window.
// Track frequency of characters.
// In any window, only characters other than the most frequent one need replacement.
// Replacements needed = window length - max frequency.
// If replacements > k, shrink window.
// Update answer for every valid window.
// Time: O(n), Space: O(1).
// to make all characters in a window identical, the optimal strategy is to keep the most frequent character and replace the rest. Hence, the number of replacements required is the window size minus the maximum frequency.


class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxLen = 0;
        int maxFreq = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            maxFreq = Math.max(maxFreq, map.get(ch));

            while((right - left + 1) - maxFreq > k){
                char leftchar = s.charAt(left);

                map.put(leftchar, map.get(leftchar) - 1);

                if(map.get(leftchar) == 0){
                    map.remove(leftchar);
                }

                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}