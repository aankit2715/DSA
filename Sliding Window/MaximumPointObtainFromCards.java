// There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.
// In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
// Your score is the sum of the points of the cards you have taken.
// Given the integer array cardPoints and the integer k, return the maximum score you can obtain.

// Example:
// Input : cardScore = [5, 4, 1, 8, 7, 1, 3 ] , k = 3
// Output : 12
// Explanation : In first step we will choose card from beginning with score of 5.
// In second step we will choose the card from beginning again with score of 4.
// In third step we will choose the card from end with score of 3.
// The total score is 5 + 4 + 3 => 12

// ====================================================================================

public class MaximumPointObtainFromCards {

    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;
        int total = 0;
        for (int point : cardPoints) {
            total += point;
        }
 
        int windowSize = n - k;
        int windowSum = 0;
 
        for (int i = 0; i < windowSize; i++) {
            windowSum += cardPoints[i];
        }
        
        int minWindowSum = windowSum;
 
        for (int i = windowSize; i < n; i++) {
            windowSum += cardPoints[i] - cardPoints[i - windowSize];
            minWindowSum = Math.min(minWindowSum, windowSum);
        }
        
        return total - minWindowSum;
        
    }
    
}
