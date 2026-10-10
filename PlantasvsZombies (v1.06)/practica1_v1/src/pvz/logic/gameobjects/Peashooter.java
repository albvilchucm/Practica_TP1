package pvz.logic.gameobjects;

import pvz.view.Messages;
import utils.Position;
import pvz.logic.Game;

public class Peashooter {
	
	public static final int COST = 50;
	private static final int DAMAGE = 1;
	private static final int INITIAL_HEALTH = 3;
	private int health;
	
	private Position pos;
	private Game game;
	
	public Peashooter(Position position, Game game2) {
		this.pos = position;
		this.game = game2;
		this.health = INITIAL_HEALTH;
	}
	
	public String getIcon() {
		return String.format(Messages.PEASHOOTER_ICON, health);
	}
	
	public boolean isInPosition(Position posi) {
		return (this.pos.equals(posi));
	}
	
	public static String getDescription() {
		return String.format(Messages.SUNFLOWER_DESCRIPTION,COST,DAMAGE,INITIAL_HEALTH);
	}
	
	public boolean isAlive() {
		return (health >0);
	}
	
	public void update() {
		shoot();
	}
	
	private void shoot() {
		Position pos = this.pos.right();
		this.game.attackZombie(pos, Peashooter.DAMAGE);
	}
		
	public void receiveDamage(int dam) {
		this.health = this.health-dam;
	}
	
	public String shortName() {
		return "PS";
	}
	
	public String longName() {
		return "Peashooter";
	}
	
}


