package pvz.logic.gameobjects;

import pvz.logic.Game;
import pvz.view.Messages;
import utils.Position;

public class Zombie {
	
	private static final int DAMAGE = 1;
	private static final int INITIAL_HEALTH = 5;
	private static final int MOVE_EVERY_CYCLES = 2;
	
	private int health;
	private int cyclesSinceLastMovement;
	
	private Position pos;
	private Game game;
	
	public Zombie(Position pos, Game game2) {
		this.pos = pos;
		this.game = game2;
		this.health = Zombie.INITIAL_HEALTH;
		this.cyclesSinceLastMovement = 0;
	}
	
	public String getIcon() {
		return String.format(Messages.ZOMBIE_ICON, health);
	}
	
	public boolean isInPosition(Position pos) {
		return this.pos.equals(pos);
	}
	
	public void receiveAttack(int dam) {
		this.health = this.health - dam;
	}
	
	public void update() {
		if (canMove()) {
			move();
			this.cyclesSinceLastMovement =0;
		}
		else {
			attack();
			this.cyclesSinceLastMovement++;
		}
	}
	
	private boolean canMove() {
		return (this.game.isEmpty(this.pos.left()) 
				&& this.cyclesSinceLastMovement ==Zombie.MOVE_EVERY_CYCLES-1);
	}
	
	private void move() {
		this.pos = this.pos.left();
	}
	
	private void attack() {
		Position pos = this.pos.left();
		this.game.attackPlant(pos, Zombie.DAMAGE);
	}
	
	public boolean isAlive() {
		return (this.health>0);
	}
	
}
