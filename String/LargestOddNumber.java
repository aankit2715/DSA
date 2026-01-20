You are given a string num, representing a large integer. Return the largest-valued odd integer (as a string) that is a non-empty substring of num, or an empty string "" if no odd integer exists.
A substring is a contiguous sequence of characters within a string.

Example 1:
Input: num = "452"
Output: "45"
 
Example 2:
Input: num = "35427"
Output: "35427"
Explanation: "35427" is already an odd number.

public class LargestOddNumber {

    public String largestOddNumber(String num) {
        // Traverse from the end to find the last odd digit
        for(int i=num.length()-1; i>=0; i--) {
            
            char c = num.charAt(i);
            if((c-'0') % 2 == 1) 
                return num.substring(0, i+1);  //substring is exclusive of end index but inclusive of start index.
        }

        return "";
        
    }
    
}
