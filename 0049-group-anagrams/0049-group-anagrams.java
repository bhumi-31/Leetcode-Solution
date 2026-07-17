class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String word : strs){
            char chrs[] = word.toCharArray();
            Arrays.sort(chrs);

            String str = new String(chrs);

            if(!map.containsKey(str)){
                map.put(str, new ArrayList<>());
            }

            map.get(str).add(word);
        }

        return new ArrayList<>(map.values());
    }
}