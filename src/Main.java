
public class Main {

	public static void main(String[] args) {
		Item[] items = {new Item(5, 3), new Item(7, 4), new Item(2, 1), new Item(5, 2), new Item(8, 3), new Item(3, 2), new Item(12, 5)};
		final int MAX_WEIGHT_LIMIT = 9;
		printItems(items);
		
		System.out.printf("The most weight possible with Partial Knapsack: %.2f\n", partialKnapsack.partial(items, MAX_WEIGHT_LIMIT));
		
	}
	
	public static void printItems(Item[] items) {
		System.out.print("Index:  ");
		for(int i = 0; i < items.length; i++)
			System.out.printf("%6d", i);
		System.out.println();
		
		System.out.print("Benefit:");
		for(Item i: items)
			System.out.printf("%6d", i.getBenefit());
		System.out.println();
		
		System.out.print("Weight: ");
		for(Item i: items)
			System.out.printf("%6d", i.getWeight());
		System.out.println();
		
		System.out.print("Value:  ");
		for(Item i: items)
			System.out.printf("%6.2f", i.getValue());
		System.out.println();
	}

}
