import java.util.ArrayList;

/**
 * 0-1 Knapsack
 * Optimization: Most benefits
 * Constraints: Limited max weight
 *              No partial item is allowed (unlike partial knapsack)
 *              
 * Dynamic Programming Approach
 */
public class fullKnapsack {
	
	static boolean displayDPtable = true;
	static boolean displayInsertion = true;
	
	public static int optimize(Item[] items, int limit) {
		int i, j;
		int[][] table = new int[items.length+1][limit+1];
		for(i = 0; i <= items.length; i++)
			table[i][0] = 0;
		for(j = 0; j <= limit; j++)
			table[0][j] = 0;
		for(i = 1; i <= items.length; i++) {
			for(j = 1; j <= limit; j++) {
				if(items[i-1].getWeight() > j) {
					table[i][j] = table[i-1][j];
				} else {
					table[i][j] = Math.max(table[i-1][j], table[i-1][j-items[i-1].getWeight()] + items[i-1].getBenefit());
				}
			}
		}
		if(displayDPtable) {
			for(i = 0; i <= items.length; i++) {
				for(j = 0; j <= limit; j++) {
					System.out.printf("%3d", table[i][j]);
				}
				System.out.println();
			}
			System.out.println();
		}
		
		if(displayInsertion) {
			ArrayList<Integer> insertedIndex = new ArrayList<>();
			int currentMax = table[items.length][limit];
			for(i = items.length; i > 0; i--) {
				for(j = limit; j > 0; j--) {
					if(currentMax == 0) {
						break;
					}
					if(currentMax > table[i-1][j]) {
						insertedIndex.add(0, i-1);
						i -= 1;
						j = j - items[i].getWeight();
						currentMax = table[i][j];
						j++;
					} else {
						i--;
						j++;
					}
				}
				if(currentMax == 0)
					break;
			}
			int totalWeight = 0;
			for(int index: insertedIndex) {
				totalWeight += items[index].getWeight();
				System.out.printf("Item[%d] (Benefit = %d, Weight = %d) Inserted.\n", index, items[index].getBenefit(), items[index].getWeight());
			}
			System.out.printf("Total Weight occupied: %d / %d\n", totalWeight, limit);
			
		}
		
		return table[items.length][limit];
	}
}
