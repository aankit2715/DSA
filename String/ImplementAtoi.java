Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.

The algorithm for myAtoi(string s) is as follows:

1. Whitespace: Ignore any leading whitespace (" ").
2. Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
3. Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
4. Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
Return the integer as the final result.

Input: s = " -042"
Output: -42
Explanation:
Step 1: "   -042" (leading whitespace is read and ignored)
Step 2: "   -042" ('-' is read, so the result should be negative)
Step 3: "   -042" ("042" is read in, leading zeros ignored in the result)

========================================================================================

public class ImplementAtoi {

    public int myAtoi(String s) {

        if(s == null || s.isEmpty()) return 0;

        int i=0, n=s.length();
        // Step 1: Skip leading whitespace
        while(i<n && s.charAt(i) == ' ')
            i++;

        int sign=1;
        // Step 2: Handle sign
        if(i<n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '+') ? 1 : -1;
            i++;
        }

        long result=0;
        // Step 3: Convert digits
        while(i<n && Character.isDigit(s.charAt(i))) {
            result = result * 10 + s.charAt(i)-'0';
            
            // Step 4: Clamp to 32-bit range
            if(sign==1 && result > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;

            if(sign==-1 && -result < Integer.MIN_VALUE)
                return Integer.MIN_VALUE; 

            i++;
        }

        return (int) result * sign;
    }
    
}
