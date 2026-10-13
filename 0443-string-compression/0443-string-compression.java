class Solution {
    public int compress(char[] chars) {
        int index = 0;
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

            chars[index] = chars[i];
            index++;

            if(count > 1){
                String num = String.valueOf(count);

                for(char ch : num.toCharArray()){
                    chars[index] = ch;
                    index++;
                }
            }

            i = j;
        }

        return index;
    }
}