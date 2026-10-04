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
