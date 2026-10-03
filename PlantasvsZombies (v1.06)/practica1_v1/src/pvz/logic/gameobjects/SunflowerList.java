package pvz.logic.gameobjects;

import utils.Position;

public class SunflowerList {

	private int numberOfSunflowers;
	Sunflower[] sunflowers;
	
	public SunflowerList() {
		this.sunflowers = new Sunflower[10];
		this.numberOfSunflowers = 0;
		
	}
	
	public String iconInPosition(Position pos) {
		
		return "";
	}
	
	public void update() {
		
	}
	
	public void removeDead() {
		
	}
	
	public boolean isEmpty(Position pos) {
	
		return true;
	}
	
	private void removeFromIndex(int ind) {
		
	}
	
	public void add(Sunflower sun) {
		
	}
	
	public void receiveDamage(Position pos, int dam){
		
	}
	
}
