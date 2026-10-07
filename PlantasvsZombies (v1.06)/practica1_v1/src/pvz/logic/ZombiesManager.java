package pvz.logic;

import java.util.Random;

import pvz.control.Level;
import pvz.logic.gameobjects.Zombie;
import pvz.logic.gameobjects.ZombieList;


import utils.Position;
/**
 * Manages the full lifecycle of zombies for a game session.
 *
 * <p>Responsibilities: deciding each cycle whether to spawn a new zombie
 * (probabilistically, subject to the remaining quota from {@link Level}),
 * delegating per-cycle updates and dead-removal to the underlying
 * {@link ZombieList}, and answering win/loss queries
 *
 */
public class ZombiesManager {

	private Game game;

	private Level level;

	private Random rand;

	private int remainingZombies;

	private ZombieList zombielist;

	public ZombiesManager(Game game, Level level, Random rand) {
		this.game = game;
		this.level = level;
		this.rand = rand;
		this.remainingZombies = level.get_numberOfZombies();
		this.zombielist = new ZombieList();
	}

	/**
	 * Checks if the game should add (if possible) a zombie to the game.
	 * 
	 * @return <code>true</code> if a zombie should be added to the game.
	 */
	private boolean shouldAddZombie() {
		return rand.nextDouble() < level.get_zombieFrequency();
	}
	
	/**
	 * Return a random row within the board limits.
	 * 
	 * @return a random row.
	 */
	private int randomZombieRow() {
		return rand.nextInt(Game.NUM_ROWS);
	}
	
	public boolean addZombie() {
		int row = randomZombieRow();
		return addZombie(row);
	}

	public boolean addZombie(int row) {
		Position zombiePosition = Game.newZombiePosition(row);

		boolean canAdd = this.remainingZombies > 0 && shouldAddZombie() && game.isEmpty(zombiePosition);

		if(canAdd) {
			// TODO fill your code
		}
		return canAdd;
	}

	public int getRemainingZombies() {
		return this.remainingZombies;
	}
	
	public boolean doZombiesReachedTheHouse() {
		
		return false;
	}
	
	public void damageZombie(Position pos, int dam) {
		
	}
	
	public String iconInPosition(Position pos) {
		return this.zombielist.iconInPosition(pos);
	}
	
	public boolean isEmpty(Position pos) {
		return this.zombielist.isEmpty(pos);
	}
	
	public void update() {
		
	}
	
	public boolean allZombiesWereKilled() {
		return (this.remainingZombies==0);
	}
	
	public void removeDead() {
		
	}
	
}
