class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int total = n + m;

        int i = 0, j = 0;
        int count = 0;

        int prev = 0;
        int curr = 0;

        while (i < n && j < m) {
            prev = curr;

            if (nums1[i] <= nums2[j]) {
                curr = nums1[i++];
            } else {
                curr = nums2[j++];
            }

            if(total % 2 == 1 && count == total / 2){
                return curr;
            }

            if (total % 2 == 0 && count == total / 2) {
                return (prev + curr) / 2.0;
            }

            count++;
        }



        while (i < n) {

            prev = curr;
            curr = nums1[i++];

            if (total % 2 == 1 && count == total / 2) {
                return curr;
            }

            if (total % 2 == 0 && count == total / 2) {
                return (prev + curr) / 2.0;
            }

            count++;
        }


        while (j < m) {

            prev = curr;
            curr = nums2[j++];

            if (total % 2 == 1 && count == total / 2) {
                return curr;
            }

            if (total % 2 == 0 && count == total / 2) {
                return (prev + curr) / 2.0;
            }

            count++;
        }

        return 0.0;
    }
}