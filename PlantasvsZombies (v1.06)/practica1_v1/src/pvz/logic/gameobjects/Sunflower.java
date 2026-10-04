package pvz.logic.gameobjects;

import pvz.logic.Game;
import pvz.view.Messages;
import utils.Position;

public class Sunflower {
	
	private final int cost = 20;
	private final int damage = 0;
	private final int initial_health = 1;
	private int health;
	
	private Position pos;
	private Game game;
	
	public Sunflower(Position position, Game game2) {
		this.pos = position;
		this.game = game2;
		this.health = initial_health;
	}
	
	public String getIcon() {
		return Messages.SUNFLOWER_ICON;
	}
	
	public boolean isInPosition(Position posi) {
		return (this.pos.equals(posi));
	}
	
	public static String getDescription() {
		return Messages.SUNFLOWER_DESCRIPTION;
	}
	
	public boolean isAlive() {
		return (health >0);
	}
	
	public void update() {
		
	}
	
	public void receiveDamage(int dam) {
		this.health = this.health-dam;
	}
	
	public String shortName() {
		return "SF";
	}
	
	public String longName() {
		return "Sunflower";
	}
	
}
