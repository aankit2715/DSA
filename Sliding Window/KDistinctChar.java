// Given a string s and an integer k.Find the length of the longest substring with at most k distinct characters.

// Example:
// Input : s = "aababbcaacc" , k = 2
// Output : 6
// Explanation : The longest substring with at most two distinct characters is "aababb".
// The length of the string 6.

// ===================================================================================

public class KDistinctChar {

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) return 0;

        Map<Character, Integer> freq = new HashMap<>();
        int left = 0, right = 0, maxLen = 0;

            while (right < s.length()) {
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            // Shrink window if more than k distinct chars
            while (freq.size() > k) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }

    
    
}
 
