package pvz.logic.gameobjects;

import pvz.logic.Game;
import pvz.view.Messages;
import utils.Position;

public class Sunflower {
	
	public static final int COST = 20;
	private static final int DAMAGE = 0;
	private static final int INITIAL_HEALTH = 1;
	private static final int GENERATED_SUNCOINS = 10;
	private static final int COOLDOWN = 3;
	
	private int health;
	private int cyclesSinceLastCoinGeneration;
	
	private Position pos;
	private Game game;
	
	public Sunflower(Position position, Game game2) {
		this.pos = position;
		this.game = game2;
		this.health = INITIAL_HEALTH;
		this.cyclesSinceLastCoinGeneration = 0;
	}
	
	public String getIcon() {
		return String.format(Messages.SUNFLOWER_ICON, health);
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
		if (Sunflower.COOLDOWN==this.cyclesSinceLastCoinGeneration) {
			this.game.generateCoins(Sunflower.GENERATED_SUNCOINS);
			this.cyclesSinceLastCoinGeneration=1;
		}
		else {
			this.cyclesSinceLastCoinGeneration++;
		}
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
