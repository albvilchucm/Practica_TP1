package pvz.logic.gameobjects;

import utils.Position;

public class PeashooterList {
	
	private int numberOfPeashooters;
	Peashooter[] peashooters;
	
	public PeashooterList() {
		this.peashooters = new Peashooter[10];
		this.numberOfPeashooters =0;
		
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
	
	public void add(Peashooter pea) {
		
	}
	
	public void receiveDamage(Position pos, int dam){
		
	}
	
}
