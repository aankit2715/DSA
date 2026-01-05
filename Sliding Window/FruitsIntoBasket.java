// There is only one row of fruit trees on the farm, oriented left to right. An integer array called fruits represents the trees, where fruits[i] denotes the kind of fruit produced by the ith tree.
// The goal is to gather as much fruit as possible, adhering to the owner's stringent rules:

// 1) There are two baskets available, and each basket can only contain one kind of fruit. The quantity of fruit each basket can contain is unlimited.
// 2) Start at any tree, but as you proceed to the right, select exactly one fruit from each tree, including the starting tree. One of the baskets must hold the harvested fruits.
// 3) Once reaching a tree with fruit that cannot fit into any basket, stop.

// Return the maximum number of fruits that can be picked.

// Example:
// Input : fruits = [1, 2, 3, 2, 2]
// Output : 4

// Explanation : we will start from second tree.
// The first basket contains fruits from second , fourth and fifth.
// The second basket will contain fruit from third tree.
// Hence we collected total of 4 fruits.

// ===================================================================================

public class FruitsIntoBasket {

    public int totalFruit(int[] fruits) {

        int left=0, right=0, maxLen=0;

        Map <Integer, Integer> basket = new HashMap<>();

        while(right < fruits.length) {

            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) +1);

            while(basket.size() > 2) {

                basket.put(fruits[left], basket.get(fruits[left]) -1);
                if(basket.get(fruits[left]) == 0)
                    basket.remove(fruits[left]);

                left++;

            }

            maxLen = Math.max(maxLen, right-left+1);
            right++;

        }

        return maxLen;
        
    }
    
}
