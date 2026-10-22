class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        if (p.length() > s.length()) {
            return ans;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < p.length(); i++){
            char ch = p.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }


        int left = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        
        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            if (right - left + 1 > p.length()) {
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                if (window.get(leftChar) == 0) {
                    window.remove(leftChar);
                }

                left++;
            }
            if(right - left + 1 == p.length()){
                if(map.equals(window)){
                    ans.add(left);
                }
            }

        }

        return ans;
    }
}