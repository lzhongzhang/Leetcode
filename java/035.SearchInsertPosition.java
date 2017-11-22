// Problem 35 Search Insert Position

/* If there is no target in array, we should consider many circumstances where
 * the position target should be inserted in. */

public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0)
            return 0;
        
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(target == nums[i])
                index = i;
            if(nums[i] < target) {
                if(i + 1 == nums.length)
                    index = i+1;
                else
                    continue;
            }
            else
                index = i;
                if(i + 1 <= nums.length)
                    break;
        }
        return index;
    }
}

// Other idea
class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0, n = nums.length - 1;
        while (i <= n) {
            if (nums[i] == target)
                return i;
            else {
                if (nums[i] > target) {
                    return i;
                } else {
                    i++;
                }
            }
        }
        return n + 1;
    }
}