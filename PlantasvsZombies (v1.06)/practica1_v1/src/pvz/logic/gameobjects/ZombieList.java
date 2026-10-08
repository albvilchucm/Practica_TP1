package pvz.logic.gameobjects;

import utils.Position;

public class ZombieList {

	private int numberOfZombies;
	private Zombie[] zombies;
	
	public ZombieList() {
		this.numberOfZombies = 0;
		this.zombies = new Zombie[3];
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
		if (this.numberOfZombies == this.zombies.length) {
			Zombie[] nuevo = new Zombie[this.numberOfZombies + 1];
			for (int i = 0; i < this.numberOfZombies; i++) {
				nuevo[i] = this.zombies[i];
			}

			nuevo[this.numberOfZombies] = zombie;
			this.zombies = nuevo;
		}
		else {
			this.zombies[this.numberOfZombies]=zombie;
		}

		this.numberOfZombies++;
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
		for (int i = 0; i < this.numberOfZombies; i++) {
			 if(!this.zombies[i].isAlive()) {
				 this.removeFromIndex(i);
			 }
		}
	}
	
	public boolean anyInColumn(int col) {
		
		return true;
	}
	
	private void removeFromIndex (int ind) {
		for(int i = ind;i<this.numberOfZombies-1;i++) {
			this.zombies[i]=this.zombies[i+1];
		}
		this.numberOfZombies--;
	}
	
}
