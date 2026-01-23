// The problem can be split into two parts.
// First, I generate the k-th smallest greater permutation of the given number using the standard next permutation logic on its digits.

// Once the target permutation is known, I compute the minimum number of adjacent swaps needed to transform the original number into this target.
// I do this greedily by fixing digits from left to right: for each position, I locate the required digit in the remaining suffix and bring it to the correct position using adjacent swaps. Each swap moves the digit one step closer, guaranteeing the minimum number of swaps.

// This approach works because the prefix is fixed progressively and adjacent swaps preserve the relative order of the remaining digits.

class Solution {
    public void reverse(char[] nums, int si, int ei){
        while(si < ei){
            char temp = nums[si];
            nums[si] = nums[ei];
            nums[ei] = temp;
            si++;
            ei--;
        }
    }
    public void nextPermutation(char[] nums){
        int n = nums.length;
        int index = -1;

        for(int i = n - 2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                index = i;
                break;
            }
        }

        if(index == -1) reverse(nums, 0 , n - 1);

        for(int i = n - 1; i >= index; i--){
            if(nums[i] > nums[index]){
                char temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                break;
            }
        }

        reverse(nums, index + 1, n - 1);
    }

    public void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int swaps(char[] original, char[] target){
        int swaps = 0;
        int j = 0;

        for(int i = 0; i < original.length; i++){
            j = i;
            while(original[j] != target[i]){
                j++;
            }

            while(j > i){
                swap(original, j, j - 1);
                swaps++;
                j--;
            }
        }

        return swaps;
    }
    public int getMinSwaps(String num, int k) {
        char[] target = num.toCharArray();

        for(int i = 0; i < k; i++){
            nextPermutation(target);
        }

        char original[] = num.toCharArray();

        return swaps(original, target);
    }
}