class Solution {
    public int x(int n){
        int rev = 0;
        while(n > 0){
            int ld = n % 10;
            if(ld != 0){
                rev = rev * 10 + ld;
            }

            n = n /10;
        }

        return rev;
    }
    
    public int sum(int n){
        int sum = 0;

        while(n > 0){
            int ld = n % 10;
            sum = sum + ld;
            n = n / 10;
        }

        return sum;
    }

    public int rev(int n){
        int rev = 0;

        while(n > 0){
            int ld = n % 10;
            rev = rev * 10 + ld;
            n = n/ 10;
        }

        return rev;
    }
    public long sumAndMultiply(int n) {
        int x = x(n);
        int rev = rev(x);
        int sum = sum(rev);

        return 1L * sum * rev;
    }
}