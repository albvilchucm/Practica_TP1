package pvz.logic;

import java.util.Random;
import pvz.control.Level;
import utils.Position;
import pvz.logic.gameobjects.PeashooterList;
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
	
	
	public Game (long seed, Level level){
		this.cycles = 0;
		this.coins = INITIAL_COINS;
		this.longSeed = seed;
		this.level = level;
		this.playerQuit = false;
	}
	
	public String  positionToString(Position p) {
		return "";
		
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
		return this.level.get_numberOfZombies();
	}
	
	public int getSunCoins() {
		return this.coins;
	}
	
	public static Position newZombiePosition (int rows) {
		Position a= new Position(0, rows);
		return a;
	}
	
	public static boolean isEmpty (Position p) {
		//recorrer las listas de zombies, peashooters y sunflowers mirando si se pueden añadir
		
		return true;
	}

	public boolean haveFinished() {
		return false;
	}
}