class Solution {
    public int  sumOfSquareOfDigit(int n){
        int sum = 0;
        while(n != 0){
            int ld = n % 10;
            sum = sum + ld*ld;
            n = n / 10;
        }

        return sum;
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while(n != 1){
            if(set.contains(n)){
                return false;
            }

            set.add(n);

            n = sumOfSquareOfDigit(n);
        }
        return true;
    }
}