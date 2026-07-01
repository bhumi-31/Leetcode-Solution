/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int si = 1;
        int ei = n;
        int ans = -1;

        while(si <= ei){
            int mid = si + (ei - si)/2;

            if(isBadVersion(mid)){
                ans = mid;
                ei = mid - 1;
            }else{
                si = mid + 1;
            }
        }

        return ans;
    }
}