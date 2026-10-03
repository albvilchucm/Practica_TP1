package pvz.logic.gameobjects;

import pvz.view.Messages;
import utils.Position;
import pvz.logic.Game;

public class Peashooter {
	
	private int cost = 50;
	private int damage = 1;
	private int initial_health = 3;
	private int health;
	
	private Position pos;
	private Game game;
	
	public Peashooter(Position position, Game game2) {
		this.pos = position;
		this.game = game2;
		this.health = initial_health;
	}
	
	public String getIcon() {
		return Messages.PEASHOOTER_ICON;
	}
	
	public boolean isInPosition(Position posi) {
		return (this.pos.equals(posi));
	}
	
	public static String getDescription() {
		return Messages.PEASHOOTER_DESCRIPTION;
	}
	
	public boolean isAlive() {
		return (health >0);
	}
	
	public void update() {
		
	}
	
	private void shoot() {
		
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

