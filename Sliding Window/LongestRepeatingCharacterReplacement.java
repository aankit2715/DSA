// You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
// Return the length of the longest substring containing the same letter you can get after performing the above operations.

// Example:
// Input: s = "AABABBA", k = 1
// Output: 4
// Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
// The substring "BBBB" has the longest repeating letters, which is 4.
// There may exists other ways to achieve this answer too.

// ===============================================================================


public class LongestRepeatingCharacterReplacement {

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
