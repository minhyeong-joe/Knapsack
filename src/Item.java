
public class Item {
	
	private int benefit;
	private int weight;
	
	public Item(int b, int w) {
		this.benefit = b;
		this.weight = w;
	}
	
	public void setBenefit(int b) {
		this.benefit = b;
	}
	
	public void setWeight(int w) {
		this.weight = w;
	}
	
	public int getBenefit() {
		return this.benefit;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public double getValue() {
		return (double)this.benefit/(double)this.weight;
	}
}
