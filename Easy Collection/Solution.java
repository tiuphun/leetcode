class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length == 1) return;
        else if (nums.length < k) {
            k = k % nums.length;                                          
        }
        
        if (nums.length == k) {
            for(int i = 0; i < nums.length / 2; i++) {
                int j = nums[i];
                nums[i] = nums[nums.length - i - 1];
                nums[nums.length - i - 1] = j;
            }
        }
        else {
            for(int i = 0; i < nums.length / 2; i++) {
                int j = nums[i];
                nums[i] = nums[nums.length - i - 1];
                nums[nums.length - i - 1] = j;
            }

            //reverse left section: len = k
            for(int i = 0; i < k / 2; i++) {
                int j = nums[i];
                nums[i] = nums[k - i - 1];
                nums[k - i - 1] = j;
            }

            //reverse right section: len = nums.length - k
            for(int i = k; i < (nums.length - k)/ 2 + k; i++) {
                int j = nums[i];
                nums[i] = nums[nums.length - i - 1];
                nums[nums.length - i - 1] = j;
            }
        }
    }
}