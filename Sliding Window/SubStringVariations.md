1. Longest substring with at most k distinct characters  
Instead of forbidding duplicates, allow up to k distinct characters and find the longest substring.

```java

import java.util.HashMap;

public class LongestSubstringKDistinct {
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            // Shrink window until we have at most k distinct chars
            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        System.out.println("Longest substring length: " + lengthOfLongestSubstringKDistinct(s, k));
    }
}
```

2. Longest substring with exactly k distinct characters  
Similar to the above, but the substring must contain exactly k distinct characters.

```java

import java.util.HashMap;

public class LongestSubstringExactlyKDistinct {
    public static int lengthOfLongestSubstringExactlyKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            // Shrink window until we have at most k distinct chars
            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }

            // Only update maxLen if we have exactly k distinct chars
            if (map.size() == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "aaabbcc";
        int k = 2;
        System.out.println("Longest substring length with exactly " + k +
                           " distinct chars: " + lengthOfLongestSubstringExactlyKDistinct(s, k));
    }
}
```

3. Longest substring without repeating vowels  
Restrict the uniqueness condition to vowels only, while consonants can repeat.

```java

import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class LongestSubstringNoRepeatingVowels {
    private static final Set<Character> VOWELS = Set.of('a','e','i','o','u');

    public static int longestSubstringWithoutRepeatingVowels(String s) {
        if (s == null || s.isEmpty()) return 0;

        HashMap<Character, Integer> vowelMap = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // If it's a vowel, update frequency
            if (VOWELS.contains(c)) {
                vowelMap.put(c, vowelMap.getOrDefault(c, 0) + 1);

                // Shrink window until no vowel repeats
                while (vowelMap.get(c) > 1) {
                    char leftChar = s.charAt(left);
                    if (VOWELS.contains(leftChar)) {
                        vowelMap.put(leftChar, vowelMap.get(leftChar) - 1);
                        if (vowelMap.get(leftChar) == 0) {
                            vowelMap.remove(leftChar);
                        }
                    }
                    left++;
                }
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcaeiouxyz";
        System.out.println("Longest substring length without repeating vowels: " +
                           longestSubstringWithoutRepeatingVowels(s));
    }
}
```

4. Longest substring with unique digits  
Applied to numeric strings, ensuring no digit repeats.

```java

public class LongestSubstringUniqueDigits {
    public static int longestUniqueDigitSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;

        boolean[] seen = new boolean[10]; // track digits 0-9
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            int digit = s.charAt(right) - '0';

            // If digit already seen, shrink window until it's unique
            while (seen[digit]) {
                int leftDigit = s.charAt(left) - '0';
                seen[leftDigit] = false;
                left++;
            }

            seen[digit] = true;
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "1231234567890";
        System.out.println("Longest substring length with unique digits: " +
                           longestUniqueDigitSubstring(s));
    }
}
```

5. Longest substring with no adjacent duplicates  
Characters can repeat, but not consecutively.

```java

public class LongestSubstringNoAdjacentDuplicates {
    public static int longestSubstringNoAdjacentDuplicates(String s) {
        if (s == null || s.isEmpty()) return 0;

        int maxLen = 1; // at least one char
        int currLen = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                currLen++; // extend substring
                maxLen = Math.max(maxLen, currLen);
            } else {
                // reset when adjacent duplicate found
                currLen = 1;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "aabcbcddde";
        System.out.println("Longest substring length with no adjacent duplicates: " +
                           longestSubstringNoAdjacentDuplicates(s));
    }
}
```

6. Longest substring with repeating characters allowed up to k times  
Each character can appear at most k times in the substring.

```java

import java.util.HashMap;

public class LongestSubstringAtMostKRepeats {
    public static int longestSubstringWithRepeatsAllowed(String s, int k) {
        if (s == null || s.isEmpty() || k <= 0) return 0;

        HashMap<Character, Integer> freq = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            // Shrink window until all chars appear at most k times
            while (freq.get(c) > k) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "aaabbccddeee";
        int k = 2;
        System.out.println("Longest substring length with repeats allowed up to " + k +
                           " times: " + longestSubstringWithRepeatsAllowed(s, k));
    }
}
```


7. Longest substring that is a palindrome  
Instead of uniqueness, the condition is symmetry.

```java

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);       // odd length
            int len2 = expandAroundCenter(s, i, i + 1);   // even length
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // length of palindrome
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println("Longest palindromic substring: " + longestPalindrome(s));
    }
}
```
