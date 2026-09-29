package pvz.logic;

import java.util.Random;
import pvz.control.Level;
import utils.Position;

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
	
}
