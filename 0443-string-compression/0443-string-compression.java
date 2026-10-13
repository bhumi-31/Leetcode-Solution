class Solution {
    public int compress(char[] chars) {
        ArrayList<Character> ans = new ArrayList<>();
        int i = 0;
        while(i < chars.length){
            int count = 1;
            int j;
            for(j = i + 1; j < chars.length; j++){
                if(chars[j] == chars[i]){
                    count++;
                }else{
                    break;
                }
            }
            ans.add(chars[i]);
            if(count > 1){
                for (char c : String.valueOf(count).toCharArray()) {
                    ans.add(c);
                }
            }
            i = j;
        }

        for(int k = 0; k < ans.size(); k++){
            chars[k] = ans.get(k);
        }

        return ans.size();
    }
}