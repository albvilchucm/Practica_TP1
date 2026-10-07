package pvz.logic;

import java.util.Random;
import pvz.control.Level;
import utils.Position;
import pvz.logic.gameobjects.Peashooter;
import pvz.logic.gameobjects.PeashooterList;
import pvz.logic.gameobjects.Sunflower;
import pvz.logic.gameobjects.SunflowerList;
import pvz.view.Messages;


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
	
	
	public Game (long seed, Level level){
		this.cycles = 0;
		this.coins = INITIAL_COINS;
		this.longSeed = seed;
		this.level = level;
		this.playerQuit = false;
		sunflowers= new SunflowerList();
		peashooters=new PeashooterList();
		zombies = new ZombiesManager(this, level, rand);
	}
	//HAY QUE TERMINAR LA IMPLEMENTACION
	
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
		return this.level.get_numberOfZombies();
	}
	
	public int getSunCoins() {
		return this.coins;
	}
	
	public void looseSunCoins(int i) {
		this.coins = this.coins - i;
	}
	
	public static Position newZombiePosition (int rows) {
		Position a= new Position(0, rows);
		return a;
	}
	
	public boolean isEmpty (Position p) {
	return (this.sunflowers.isEmpty(p) || this.peashooters.isEmpty(p) || this.zombies.isEmpty(p));
	}
	
	public String  positionToString(Position p) {
		if(!this.sunflowers.isEmpty(p)) {
			return sunflowers.iconInPosition(p);
			}
		else if(!this.peashooters.isEmpty(p)) {
			return peashooters.iconInPosition(p);
		}
		else if(!this.zombies.isEmpty(p)) {
			return zombies.iconInPosition(p);
		}
	
		return " ";
		
	}
	
	public boolean haveFinished() {
		return false;
	}
	
	public void nextCycle() {
		this.cycles = this.cycles+1;
	}
	
	public void addObject (char plant,Position pos) {
			if (plant == 's') {
				Sunflower sun = new Sunflower(pos, this);
				this.sunflowers.add(sun);
				this.looseSunCoins(Sunflower.cost);
			} 
			else if (plant == 'p') {
				Peashooter pea = new Peashooter(pos, this);
				this.peashooters.add(pea);
				this.looseSunCoins(Peashooter.cost);
			}
	}
	
}