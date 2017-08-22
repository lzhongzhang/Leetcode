// Problem 496 Next Greater Element I

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums2.length; i++)
            map.put(nums2[i], i);
        List<Integer> res = new ArrayList<>();
        for(int n: nums1) {
            int min = -1;
            int index = map.get(n);
            while(index < nums2.length) {
                if(nums2[index] > n) {
                    min = nums2[index];
                    res.add(nums2[index]);
                    break;
                }
                else
                    index++;
            }  
            if(min == -1)
                res.add(-1);
        }
        int[] ints = new int[res.size()];
        int i = 0;
        for (Integer n : res) {
            ints[i++] = n;
        }
        return ints;
    }
}