1. Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

```java

class Solution {
    public int longestOnes(int[] nums, int k) {

        int left=0, right=0, maxLen=0, zeros=0;

        while(right < nums.length) {

            if(nums[right] == 0)
                zeros++;

            while(zeros > k) {

                if(nums[left] == 0)
                    zeros--;
                left++;
            }

            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }

        return maxLen;
        
    }
}
```

2. You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.
 
Input: s = "ABAB", k = 2
Output: 4

```java
class Solution {
    public int characterReplacement(String s, int k) {

        int left=0, right=0, maxLen=0, count=0;

        int[] freqCount = new int[26];

        while(right < s.length()) {

            freqCount[s.charAt(right)-'A']++;

            count = Math.max(count, freqCount[s.charAt(right)-'A']);

            while((right-left+1) - count > k) {

                freqCount[s.charAt(left)-'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }

        return maxLen;
        
    }
}
```

3. Longest subarray of 1’s after deleting one element  
Instead of flipping, you’re allowed to delete one element to maximize consecutive 1’s.

```java
public class LongestSubarrayAfterDelete {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int zeros = 0;
        int result = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeros++;
            }

            // shrink window if more than 1 zero
            while (zeros > 1) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }

            // subtract 1 because we must delete one element
            result = Math.max(result, right - left);
        }

        return result;
    }

    public static void main(String[] args) {
        LongestSubarrayAfterDelete solver = new LongestSubarrayAfterDelete();
        System.out.println(solver.longestSubarray(new int[]{1,1,0,1})); // Output: 3
        System.out.println(solver.longestSubarray(new int[]{0,1,1,1,0,1,1,0,1})); // Output: 5
    }
}
```