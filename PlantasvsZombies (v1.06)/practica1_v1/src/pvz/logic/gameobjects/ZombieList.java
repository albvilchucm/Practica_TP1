package pvz.logic.gameobjects;

import utils.Position;

public class ZombieList {

	private int numberOfZombies;
	private Zombie[] zombies;
	
	public ZombieList() {
		this.numberOfZombies = 0;
	}
	
	public int size() {
		return this.numberOfZombies;
	}
	
	public String iconInPosition(Position pos) {
		return "";
	}
	
	public void add(Zombie zombie) {
		
	}
	
	public boolean damage(Position pos, int dam) {
		
		return true;
	}
	
	public boolean isEmpty (Position pos) {
		
		return true;
	}
	
	public void update() {
		
	}
	
	public void removeDead() {
		
	}
	
	public boolean anyInColumn(int col) {
		
		return true;
	}
	
	private void removeFromIndex (int ind) {
		
	}
	
}
