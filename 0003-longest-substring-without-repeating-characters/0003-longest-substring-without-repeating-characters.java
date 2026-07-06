class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxi = 0;

        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);

            while(map.containsKey(ch)){
                char leftChar = s.charAt(left);

                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                left++;
            }

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            maxi = Math.max(maxi, right - left + 1);
        }
        return maxi;
    }
}