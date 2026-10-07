package pvz.control;

import pvz.logic.Game;
import pvz.view.GamePrinter;
import pvz.view.GameView;
import pvz.view.Messages;
import java.util.Scanner;
import pvz.logic.gameobjects.Peashooter;
import pvz.logic.gameobjects.PeashooterList;
import pvz.logic.gameobjects.Sunflower;
import pvz.logic.gameobjects.SunflowerList;
import utils.Position;

/**
 * Input/output coordinator of the game (the C in MVC).
 *
 * <p>Owns the game loop: reads a line from stdin, parses it into a
 * command, validates parameters (plant type, position), delegates
 * state changes to {@link Game}, and triggers a board reprint via
 * {@link tp1.pvz.view.GameView>} when the cycle advances. It holds no game
 * state of its own; the source of truth is always {@link Game}.
 */
public class Controller {

	private final Game game;
	private final GameView view;

	public Controller(Game game) {
		this.game = game;
		this.view = new GamePrinter(game);
	}

	/**
	 * Runs the game logic.
	 */
	/**
	 * 
	 */
	public void run() {
		while (!game.getPlayerQuit() && !game.haveFinished() )	{
			this.view.showGame();
			String[] opstring = this.view.getPrompt();
			char opchar = getOption(opstring);
		
			boolean avanzar = false;
			while(!avanzar && !this.game.getPlayerQuit()) {
				switch(opchar) {
				case 'a':  if(this.add(opstring[1].toLowerCase().charAt(0), Integer.parseInt(opstring[2]),Integer.parseInt(opstring[3]))) {    avanzar=true;} break;
				case 'l': this.view.showMessage(Messages.LIST); break;
				case 'r':
				case 'h': this.view.showMessage(Messages.HELP); break;
				case 'e': this.view.showEndMessage();	this.game.setPlayerQuitTrue(); break;       
				case 'n': avanzar=true; break;
				default: this.view.showMessage(Messages.INVALID_COMMAND); break;		
				}
				if (!avanzar && !this.game.getPlayerQuit()) {
					opstring = this.view.getPrompt();
					opchar = getOption(opstring);
				}
				else if (avanzar) {
					this.game.nextCycle();//cycles++;	
				}
			}
		}	
	}

	private boolean add(char plant, int col, int row) {
		Position pos = new Position(row, col);
		if (game.isEmpty(pos)) {
			if (plant == 's' && (game.getSunCoins() >= Sunflower.cost)) {
				Sunflower sun = new Sunflower(pos, this.game);
				SunflowerList listaSun = this.game.getSunflowerList();
				listaSun.add(sun);
				this.game.looseSunCoins(Sunflower.cost);
				
				return true;
			} 
			else if (plant == 'p' && (game.getSunCoins() >= Peashooter.cost)) {
				Peashooter pea = new Peashooter(pos, this.game);
				PeashooterList listaPea = this.game.getPeashooterList();
				listaPea.add(pea);
				this.game.looseSunCoins(Peashooter.cost);
				return true;
			}
			this.view.showMessage(Messages.NOT_ENOUGH_COINS);
		}
		return false;
	}
	
	
	private char getOption(String[] op1) { //Para la practica_v2 conviene hacerlo mejor con un tipo numerado
		char res= 'i';
		String op= "";
		char planta=' ';
		int col=-1;
		int row=-1;
		
		
		if (op1.length==1) {
		op = op1[0];
		}
		
		else if (op1.length==4) {
			op=op1[0];
			if (op1[1].toLowerCase().equals("sunflower")||op1[1].toLowerCase().equals("peashooter")||op1[1].toLowerCase().equals("p")||op1[1].toLowerCase().equals("s"))
			planta= op1[1].toLowerCase().charAt(0);
			col = Integer.parseInt(op1[2]);
			row=Integer.parseInt(op1[3]);
		}

		op = op.toLowerCase();
		if (op.length()>1) {
			if(op.equals("add")&& (planta=='s'||planta=='p')&&(0<=col && col<=7)&&(0<=row && row<=3)) {res= 'a';}
			else if(op.equals("list")) {res= 'l';}
			else if(op.equals("reset")) {res= 'r';}
			else if(op.equals("help")) {res= 'h';}
			else if(op.equals("exit")) {res= 'e';}
			else if(op.equals("none")) {res= 'n';}
		}
		
		else{
			if(op.equals("a")&& (planta=='s'||planta=='p')&&(0<=col && col<=7)&&(0<=row && row<=3)) {res= 'a';}
			else if(op.equals("l")) {res= 'l';}
			else if(op.equals("r")) {res= 'r';}
			else if(op.equals("h")) {res= 'h';}
			else if(op.equals("e")) {res= 'e';}
			else if(op.equals("n")|| op.equals("")) {res= 'n';}
		}
		return res;
	}
	
}