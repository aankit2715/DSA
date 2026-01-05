// Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
// A subarray is a contiguous part of the array.

// Example:
// Input: nums = [1,0,1,0,1], goal = 2
// Output: 4
// Explanation: The 4 subarrays are bolded and underlined below:
// [1,0,1,0,1]
// [1,0,1,0,1]
// [1,0,1,0,1]
// [1,0,1,0,1]

// ====================================================================================

public class CountNumberofNiceSubarrays {

    public int numSubarraysWithSum(int[] nums, int goal) {

        int right=0, sum=0, res=0;
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);

        while(right < nums.length) {

            sum += nums[right];

            if(prefixCount.containsKey(sum-goal))
                res += prefixCount.get(sum-goal);

            prefixCount.put(sum, prefixCount.getOrDefault(sum, 0) +1);
            right++;
        }

        return res;
        
    }
    
}
