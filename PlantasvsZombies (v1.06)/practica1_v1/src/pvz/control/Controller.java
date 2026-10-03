package pvz.control;

import pvz.logic.Game;
import pvz.view.GamePrinter;
import pvz.view.GameView;
import pvz.view.Messages;
import java.util.Scanner;

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
	public void run() {
		while (!game.getPlayerQuit() && !game.haveFinished() )	{
			this.view.showGame();
			String[] opstring = this.view.getPrompt();
			char opchar = getOption(opstring);
		
			boolean avanzar = false;
			while(!avanzar && !this.game.getPlayerQuit()) {
				switch(opchar) {
				case 'a':       avanzar=true; break;
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
					//cycles++;	
				}
			}
		}	
	}
	
	private char getOption(String[] op1) { //Para la practica_v2 conviene hacerlo mejor con un tipo numerado
		char res= 'i';
		String op = op1[0];
		op = op.toLowerCase();
		if (op.length()>1) {
			if(op.equals("add")) {res= 'a';}
			else if(op.equals("list")) {res= 'l';}
			else if(op.equals("reset")) {res= 'r';}
			else if(op.equals("help")) {res= 'h';}
			else if(op.equals("exit")) {res= 'e';}
			else if(op.equals("none")) {res= 'n';}
		}
		
		else{
			if(op.equals("a")) {res= 'a';}
			else if(op.equals("l")) {res= 'l';}
			else if(op.equals("r")) {res= 'r';}
			else if(op.equals("h")) {res= 'h';}
			else if(op.equals("e")) {res= 'e';}
			else if(op.equals("n")|| op.equals("")) {res= 'n';}
		}
		return res;
	}
	
}