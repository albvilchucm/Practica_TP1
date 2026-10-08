package pvz.logic.gameobjects;

import utils.Position;

public class PeashooterList {

	private int numberOfPeashooters;
	Peashooter[] peashooters;

	public PeashooterList() {
		this.peashooters = new Peashooter[10];
		this.numberOfPeashooters = 0;

	}

	public String iconInPosition(Position pos) {
		String str = " ";
		int i = 0;
		boolean encontrado = false;
		while (!encontrado && i<this.numberOfPeashooters) {
			if(this.peashooters[i].isInPosition(pos)) {
				str = this.peashooters[i].getIcon();
				encontrado = true;
			}
			i++;
		}
		return str;
	}

	public void update() {

	}

	public void removeDead() {
		for (int i = 0; i < this.numberOfPeashooters; i++) {
			 if(!this.peashooters[i].isAlive()) {
				 this.removeFromIndex(i);
			 }
		}
	}

	public boolean isEmpty(Position pos) {
		int i = 0;
		boolean encontrado = false;
		while (!encontrado && i<this.numberOfPeashooters) {
			if(this.peashooters[i].isInPosition(pos)) {
				encontrado = true;
			}
			i++;
		}
		return !encontrado;
	}

	private void removeFromIndex(int ind) {
		for (int i = 0; i < this.numberOfPeashooters-1; i++) {
			this.peashooters[i] = this.peashooters[i+1];
		}
		this.numberOfPeashooters--;
	}

	public void add(Peashooter pea) {

		if (this.numberOfPeashooters == this.peashooters.length) {
			Peashooter[] nuevo = new Peashooter[this.numberOfPeashooters + 1];
			for (int i = 0; i < this.numberOfPeashooters; i++) {
				nuevo[i] = this.peashooters[i];
			}

			nuevo[this.numberOfPeashooters] = pea;
			this.peashooters = nuevo;
		} else {
			this.peashooters[this.numberOfPeashooters] = pea;
		}

		this.numberOfPeashooters++;
	}

	public void receiveDamage(Position pos, int dam) {

	}

}
