package pvz.logic;

import java.util.Random;
import pvz.control.Level;
import utils.Position;
import pvz.logic.gameobjects.Peashooter;
import pvz.logic.gameobjects.PeashooterList;
import pvz.logic.gameobjects.Sunflower;
import pvz.logic.gameobjects.SunflowerList;

public class Game {

	public static final int NUM_ROWS = 4;
	public static final int NUM_COLS = 8;
	public static final int INITIAL_COINS = 50;

	private int cycles;
	private int coins;
	private long longSeed;
	private Level level;
	private Random rand;
	private boolean playerQuit;

	PeashooterList peashooters;
	SunflowerList sunflowers;
	ZombiesManager zombies;

	public Game(long seed, Level level) {
		this.cycles = 0;
		this.coins = INITIAL_COINS;
		this.longSeed = seed;
		this.level = level;
		this.playerQuit = false;
		this.rand = new Random(this.longSeed);
		sunflowers = new SunflowerList();
		peashooters = new PeashooterList();
		zombies = new ZombiesManager(this, level, this.rand);
	}

	public boolean getPlayerQuit() {
		return this.playerQuit;
	}

	public void setPlayerQuitTrue() {
		this.playerQuit = true;
	}

	public int getNumberCycles() {
		return this.cycles;
	}

	public int getZombies() {
		return this.zombies.getRemainingZombies();
	}

	public int getSunCoins() {
		return this.coins;
	}

	public static Position newZombiePosition(int rows) {
		Position p = new Position(rows, Game.NUM_COLS - 1);
		return p;
	}

	public boolean isEmpty(Position p) {
		return (this.sunflowers.isEmpty(p) && this.peashooters.isEmpty(p) && this.zombies.isEmpty(p));
	}

	public String positionToString(Position p) {
		if (!this.sunflowers.isEmpty(p)) {
			return sunflowers.iconInPosition(p);
		} else if (!this.peashooters.isEmpty(p)) {
			return peashooters.iconInPosition(p);
		} else if (!this.zombies.isEmpty(p)) {
			return zombies.iconInPosition(p);
		}

		return " ";

	}

	public boolean haveFinished() {
		if(this.zombies.doZombiesReachedTheHouse()) {
		
		}
		return (this.zombies.doZombiesReachedTheHouse() || this.zombies.allZombiesWereKilled());
	}

	public void generateCoins(int coins) {
		this.coins += coins;
	}

	public void update() {

		this.zombies.addZombie();

		this.sunflowers.update();
		this.peashooters.update();
		this.zombies.update();

		this.sunflowers.removeDead();
		this.peashooters.removeDead();
		this.zombies.removeDead();

		this.cycles++;
	}

	public boolean checkGameObject(String nombre) {
		boolean res = false;
		nombre = nombre.toLowerCase();
		
		if (nombre.equals("peashooter") || nombre.equals("p")) {
			res = true;
		} else if (nombre.equals("sunflower") || nombre.equals("s")) {
			res = true;
		}
		return res;
	}

	public void attackZombie(Position pos, int dam) {
		boolean shot = false;
		while (!shot && pos.col() < Game.NUM_COLS) {
				if (!this.zombies.isEmpty(pos))
				shot = true;
			
				else pos = pos.right();
		}
		this.zombies.damageZombie(pos, dam);
	}

	public void attackPlant(Position pos, int dam) {
		if (!this.peashooters.isEmpty(pos)) {
			this.peashooters.receiveDamage(pos, dam);
		}
		if (!this.sunflowers.isEmpty(pos)) {
			this.sunflowers.receiveDamage(pos, dam);
		}
	}

	private void buyWithCoins(int cost) {
		this.coins = this.coins - cost;
	}

	public boolean areEnoughCoins(String planta) {
		if (planta.toLowerCase().charAt(0) == 'p' && this.coins < Peashooter.COST)
			return false;
		else if (planta.toLowerCase().charAt(0) == 's' && this.coins < Sunflower.COST)
			return false;
		else
			return true;
	}

	public boolean isInsideBoard(Position pos) {
		boolean res = false;
		if (pos.col() <= 7 && pos.col() >= 0 && pos.row() >= 0 && pos.row() <= 3) {
			res = true;
		}
		return res;
	}

	public void addGameObject(String nameObject, Position position) {
		// Se ha comprobado ya que se puede añadir por objeto valido, posicion valida, y
		// monedas suficientes
		char planta = nameObject.toLowerCase().charAt(0);
		if (planta == 's') {
			Sunflower sun = new Sunflower(position, this);
			this.sunflowers.add(sun);
			this.buyWithCoins(Sunflower.COST);
		} else if (planta == 'p') {
			Peashooter pea = new Peashooter(position, this);
			this.peashooters.add(pea);
			this.buyWithCoins(Peashooter.COST);
		}
	}

	public void reset() {
		this.cycles = 0;
		this.coins = INITIAL_COINS;
		this.playerQuit = false;
		this.rand = new Random(this.longSeed);
		sunflowers = new SunflowerList();
		peashooters = new PeashooterList();
		zombies = new ZombiesManager(this, level, this.rand);
	}

}