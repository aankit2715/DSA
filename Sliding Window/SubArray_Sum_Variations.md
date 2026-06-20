1. Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
A subarray is a contiguous part of the array.

Input: nums = [1,0,1,0,1], goal = 2
Output: 4

```java

class Solution {
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
```

2. Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
Return the number of nice sub-arrays.

Input: nums = [1,1,2,1,1], k = 3
Output: 2

```java
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        int right=0, sum=0, res=0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);

        while(right < nums.length) {

            sum += nums[right] % 2; // converting array into binary array

            if(mp.containsKey(sum-k))
                res += mp.get(sum-k);

            mp.put(sum, mp.getOrDefault(sum, 0) +1);
            right++;
        }

        return res;
        
    }
}
```

3. Subarray sum less than k  
Instead of exact equality, count subarrays whose sum is strictly less than k. Often solved with two pointers or prefix sums.

🔑 Approaches

1. Two pointers (sliding window):
Works when all numbers are non-negative. You expand the right pointer until the sum exceeds or equals 
𝑘, then shrink from the left. This gives 𝑂(𝑛) time.

```java
public class SubarraySumLessThanK {
    public int countSubarrays(int[] nums, int k) {
        int left = 0, sum = 0, count = 0;
        
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            
            // shrink window until sum < k
            while (left <= right && sum >= k) {
                sum -= nums[left++];
            }
            
            // all subarrays ending at 'right' with start >= left are valid
            count += (right - left + 1);
        }
        
        return count;
    }

    public static void main(String[] args) {
        SubarraySumLessThanK solver = new SubarraySumLessThanK();
        int[] nums = {1, 2, 3};
        int k = 5;
        System.out.println(solver.countSubarrays(nums, k)); // Output: 5
    }
}
```

2. Prefix sums + balanced tree:
For arrays with negative numbers, two pointers fail. Instead, you can use prefix sums and a data structure like a TreeMap or Binary Indexed Tree to count how many previous prefix sums are greater than currentSum - k. This is more complex but handles negatives.



4. Subarray sum greater than k  
Instead of exact equality, count subarrays whose sum is strictly greater than k. Often solved with two pointers or prefix sums.

🔑 Approaches

1. Two pointers (sliding window):
Works when all numbers are non-negative.

```java
public static long countSubarraysGreaterThanK(int[] nums, long k) {
    int n = nums.length;

    long count = 0;
    long sum = 0;
    int left = 0;

    for (int right = 0; right < n; right++) {
        sum += nums[right];

        while (sum > k) {
            count += (n - right);
            sum -= nums[left++];
        }
    }

    return count;
}
```
