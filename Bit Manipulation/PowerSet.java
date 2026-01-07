// Given an integer array nums of unique elements, return all possible subsets (the power set).
// The solution set must not contain duplicate subsets. Return the solution in any order.

// Example:
// Input: nums = [1,2,3]
// Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

// ======================================================================================

public class PowerSet {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        int total = 1 << n;

        for(int mask=0; mask<total; mask++) {

            List<Integer> subset = new ArrayList<>();
            for(int i=0; i<n; i++) {

                if((mask & (1 << i)) != 0)
                    subset.add(nums[i]);

            }

            res.add(subset);
        }

        return res;
        
    }
    
}
