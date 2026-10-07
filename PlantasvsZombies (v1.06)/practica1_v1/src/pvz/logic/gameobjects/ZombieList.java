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
		String str = " ";
		int i = 0;
		boolean encontrado = false;
		while (!encontrado && i<this.numberOfZombies) {
			if(this.zombies[i].isInPosition(pos)) {
				str = this.zombies[i].getIcon();
				encontrado = true;
			}
			i++;
		}
		return str;
	}
	
	public void add(Zombie zombie) {
		
	}
	
	public boolean damage(Position pos, int dam) {
		
		return true;
	}
	
	public boolean isEmpty (Position pos) {
		int i = 0;
		boolean encontrado = false;
		while (!encontrado && i<this.numberOfZombies) {
			if(this.zombies[i].isInPosition(pos)) {
				encontrado = true;
			}
			i++;
		}
		return !encontrado;
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
