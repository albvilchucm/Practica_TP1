package pvz.logic.gameobjects;

import pvz.logic.Game;
import pvz.view.Messages;
import utils.Position;

public class Zombie {
	
	private static final int DAMAGE = 1;
	private static final int INITAL_HEALTH = 3;
	private static final int MOVE_EVERY_CYCLES = 2;
	
	private int health;
	private int cyclesSinceLastMovement;
	
	private Position pos;
	private Game game;
	
	public Zombie(Position pos, Game game2) {
		this.pos = pos;
		this.game = game2;
		this.health = this.INITAL_HEALTH;
		this.cyclesSinceLastMovement = 0;
	}
	
	public String getIcon() {
		return String.format(Messages.ZOMBIE_ICON, health);
	}
	
	public boolean isInPosition(Position pos) {
		return this.pos.equals(pos);
	}
	
	public boolean isHorizontallyAligned(Position pos) {
		return true;
	}
	
	public boolean isVerticallyAligned(Position pos) {
		return true;
	}
	
	public void receiveAttack(int dam) {
		this.health = this.health - dam;
	}
	
	public void update() {
		
	}
	
	private boolean canMove() {
		return true;
	}
	
	private void move() {
		
	}
	
	public boolean isAlive() {
		return (this.health>0);
	}
	
	private void attack() {
		
	}
	
}
