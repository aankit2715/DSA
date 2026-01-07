// Given an integer array nums and an integer k, return the number of good subarrays of nums.
// A good array is an array where the number of different integers in that array is exactly k.
// For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
// A subarray is a contiguous part of an array.

// Example:
// Input: nums = [1,2,1,2,3], k = 2
// Output: 7
// Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]

// ====================================================================================

public class SubarraysWithKDistinct {

    public int atMostKSubarray(int[] nums, int k) {

         Map<Integer, Integer> mp = new HashMap<>();
        int left=0, right=0, res=0;

        while(right < nums.length) {

            mp.put(nums[right], mp.getOrDefault(nums[right], 0)+1);

            while(mp.size() > k) {

                mp.put(nums[left], mp.get(nums[left])-1);
                if(mp.get(nums[left]) == 0)
                    mp.remove(nums[left]);
                left++;

            }

            res += right-left+1;
            right++;
        }

        return res;

    }
    public int subarraysWithKDistinct(int[] nums, int k) {

        return atMostKSubarray(nums, k) - atMostKSubarray(nums, k-1);

        }
    
}
