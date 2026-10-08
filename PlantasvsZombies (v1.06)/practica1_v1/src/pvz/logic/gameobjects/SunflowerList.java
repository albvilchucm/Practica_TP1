package pvz.logic.gameobjects;

import utils.Position;

public class SunflowerList {

	private int numberOfSunflowers;
	Sunflower[] sunflowers;

	public SunflowerList() {
		this.sunflowers = new Sunflower[10];
		this.numberOfSunflowers = 0;

	}
	
	public int getNumberOfSunflowers() {
		return this.numberOfSunflowers;
	}
	
	public String iconInPosition(Position pos) {
		String str = " ";
		int i = 0;
		boolean encontrado = false;
		while (!encontrado && i<this.numberOfSunflowers) {
			if(this.sunflowers[i].isInPosition(pos)) {
				str = this.sunflowers[i].getIcon();
				encontrado = true;
			}
			i++;
		}
		return str;
	}

	public void update() {
		for (int i = 0; i < this.numberOfSunflowers; i++) {
			 this.sunflowers[i].update();
			 
			}
	}

	public void removeDead() {
		for (int i = 0; i < this.numberOfSunflowers; i++) {
			 if(!this.sunflowers[i].isAlive()) {
				 this.removeFromIndex(i);
			 }
		}
	}

	public boolean isEmpty(Position pos) {
		int i = 0;
		boolean encontrado = false;
		while (!encontrado && i<this.numberOfSunflowers) {
			if(this.sunflowers[i].isInPosition(pos)) {
				encontrado = true;
			}
			i++;
		}
		return !encontrado;
	}

	private void removeFromIndex(int ind) {
		for (int i = 0; i < this.numberOfSunflowers-1; i++) {
			this.sunflowers[i] = this.sunflowers[i+1];
		}
		this.numberOfSunflowers--;
	}

	public void add(Sunflower sun) {
		if (this.numberOfSunflowers == this.sunflowers.length) {
			Sunflower[] nuevo = new Sunflower[this.numberOfSunflowers + 1];
			for (int i = 0; i < this.numberOfSunflowers; i++) {
				nuevo[i] = this.sunflowers[i];
			}

			nuevo[this.numberOfSunflowers] = sun;
			this.sunflowers = nuevo;
		}
		else {
			this.sunflowers[this.numberOfSunflowers]=sun;
		}

		this.numberOfSunflowers++;
	}

	public void receiveDamage(Position pos, int dam) {

	}

}
