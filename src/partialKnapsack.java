/**
 * Optimization: Most benefits in the bag
 * Constraint: Limited Max Weight
 * Partial insertion of item is allowed.
 * 
 * Greedy method
 */
public class partialKnapsack {
	
	static boolean printInsertion = true;
	
	public static double partial(Item[] items, int limit) {
		int totalWeight = 0;
		double totalBenefit = 0;
		// duplicate array (do not mutate original array of items)
		Item[] temp = new Item[items.length];
		for(int i = 0; i < items.length; i++) {
			temp[i] = new Item(items[i].getBenefit(), items[i].getWeight());
		}
		
		// find highest benefit/weight ratio item, remove from array, and add it to the knapsack
		int nextIndex;
		while(limit > totalWeight && temp.length > 0) {
			nextIndex = findMax(temp);
			if(totalWeight+temp[nextIndex].getWeight() > limit) {
				// take partial of last item
				int rem = limit - totalWeight;
				double portion = (double)rem/(double)temp[nextIndex].getWeight();
				totalWeight += rem;
				totalBenefit += (double)temp[nextIndex].getBenefit() * portion; 
				if(printInsertion)
					System.out.printf("Item[%d] (benefit = %.2f/%d, weight = %d/%d) PARTIALLY INSERTED\n", nextIndex, (double)items[nextIndex].getBenefit() * portion, items[nextIndex].getBenefit(), rem, items[nextIndex].getWeight());
			} else {
				// take full item
				totalWeight += temp[nextIndex].getWeight();
				totalBenefit += temp[nextIndex].getBenefit();
				// remove from array (conceptually, by making benefit = value = 0)
				temp[nextIndex].setBenefit(0);
				if(printInsertion)
					System.out.printf("Item[%d] (benefit = %d, weight = %d) INSERTED\n", nextIndex, items[nextIndex].getBenefit(), items[nextIndex].getWeight());
			}
			if(printInsertion)
				System.out.printf("Current Total: Benefit = %.2f, Weight = %d\n", totalBenefit, totalWeight);
		}
		
		return totalBenefit;
	}
	
	private static int findMax(Item[] items) {
		int maxIndex = -1;
		double maxValue = Integer.MIN_VALUE;
		for(int i = 0; i < items.length; i++) {
			if(items[i].getValue() > maxValue) {
				maxIndex = i;
				maxValue = items[i].getValue();
			}
		}
		return maxIndex;
	}
}
