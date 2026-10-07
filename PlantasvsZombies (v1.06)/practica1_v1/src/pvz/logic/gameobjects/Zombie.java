package pvz.logic.gameobjects;

import pvz.logic.Game;
import pvz.view.Messages;
import utils.Position;

public class Zombie {
	
	private int damage = 1;
	private int initial_health = 3;
	private int health;
	private int move_every_cycles = 2;
	private int cyclesSinceLastMovement;
	
	private Position pos;
	private Game game;
	
	public Zombie(Position pos, Game game2) {
		this.pos = pos;
		this.game = game2;
		this.health = this.initial_health;
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
