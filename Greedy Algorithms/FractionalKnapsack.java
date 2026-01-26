Given two arrays, val[] and wt[] , representing the values and weights of items, and an integer capacity representing the maximum weight
a knapsack can hold, determine the maximum total value that can be achieved by putting items in the knapsack. You are allowed to break items into fractions if necessary.
Return the maximum value as a double, rounded to 6 decimal places.

Examples :
Input: val[] = [60, 100, 120], wt[] = [10, 20, 30], capacity = 50
Output: 240.000000
Explanation: By taking items of weight 10 and 20 kg and 2/3 fraction of 30 kg. Hence total price will be 60+100+(2/3)(120) = 240

========================================================================================

class Item {
    
    double value, weight, ratio;
    Item(double v, double w) {
        value = v;
        weight = w;
        ratio = v/w;
    }
}

class FractionalKnapsack {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        int n = val.length;
        List<Item> items = new ArrayList<>();
        
        for(int i=0; i<n; i++) 
            items.add(new Item(val[i], wt[i]));
        
        // Sort by ratio (value/weight) descending (Lambda function)
        items.sort((a, b) -> Double.compare(b.ratio, a.ratio));
        
        double totalValue=0.0;
        int remaining=capacity;
        
        for(Item item : items) {
            
            if(remaining == 0) break;
            
            if(item.weight <= remaining) {
                totalValue += item.value;
                remaining -= item.weight;
            }
            
            else {
                totalValue += item.ratio * remaining;
                remaining = 0;
            }
        }
        // Round to 6 decimal places
        return Math.round(totalValue * 1_000_000.0) / 1_000_000.0;
    }
}
