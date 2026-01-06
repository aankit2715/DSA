// Given two integers start and goal, return the minimum number of bit flips to convert start to goal.

// Example:
// Input: start = 10, goal = 7
// Output: 3

// ===================================================================================

public class MinimumBitFlips {

    public int minBitFlips(int start, int goal) {

        start = start ^ goal; // XOR to find different bits
        int count = 0;

        while(start > 0) {

            start &= start-1; // count set bits
            count++;

        }

        return count;
        
    }
    
}
