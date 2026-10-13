class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }


        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);

            if(!map.containsKey(ch)){
                return false;
            }

            map.put(ch, map.get(ch) - 1);
            if(map.get(ch) == 0){
                map.remove(ch);
            }
        }

        return map.isEmpty();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];


        for (int i = 0; i < strs.length; i++) {
            if (visited[i]) {
                continue;
            }

            List<String> res = new ArrayList<>();
            res.add(strs[i]);
            visited[i] = true;

            for (int j = i + 1; j < strs.length; j++) {
                if (!visited[j] && isAnagram(strs[i], strs[j])) {
                    res.add(strs[j]);
                    visited[j] = true;
                }
            }

            ans.add(res);
        }

        return ans;
    }
}