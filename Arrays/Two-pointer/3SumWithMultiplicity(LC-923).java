// Fix one index i. For each i, use a HashMap to count pairs (j, k) such that arr[j] + arr[k] = target - arr[i].
// While iterating j, the map stores frequencies of elements seen before j.
// If the required third value exists in the map, add its frequency to the answer.
// Insert arr[j] into the map after processing.
// This ensures i < j < k and correctly counts duplicates.
// Time: O(n²), Space: O(n).
import java.util.*;
class Solution {
    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);

        int MOD = 1_000_000_007;

        int ans = 0;

        for(int i = 0; i < arr.length; i++){
            HashMap<Integer, Integer> map = new HashMap<>();

            for(int j = i + 1; j < arr.length; j++){

            int k = target - arr[i] - arr[j];

            ans = (ans + map.getOrDefault(k, 0)) % MOD;

            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            }

        }

        return (int) ans;
    }
}