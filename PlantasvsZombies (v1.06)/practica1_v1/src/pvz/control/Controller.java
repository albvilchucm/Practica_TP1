package pvz.control;

import pvz.logic.Game;
import pvz.view.GamePrinter;
import pvz.view.GameView;
import pvz.view.Messages;
import utils.Position;

/**
 * Input/output coordinator of the game (the C in MVC).
 *
 * <p>
 * Owns the game loop: reads a line from stdin, parses it into a command,
 * validates parameters (plant type, position), delegates state changes to
 * {@link Game}, and triggers a board reprint via {@link tp1.pvz.view.GameView>}
 * when the cycle advances. It holds no game state of its own; the source of
 * truth is always {@link Game}.
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
		boolean terminado = false;
		while (!this.game.getPlayerQuit() && !terminado) { // && !game.haveFinished()) {

			this.view.showGame();
			if (this.game.haveFinished()) {
				terminado = true;
				this.view.showEndMessage();
				if (this.game.getZombies() == 0) {
					this.view.showMessage(Messages.PLAYER_WINS);
				} else {
					this.view.showMessage(Messages.ZOMBIES_WIN);
				}
			} else {
				String[] opstring = this.view.getPrompt();
				char opchar = getOption(opstring);

				boolean avanzar = false;
				boolean reset = false;
				while (!avanzar && !this.game.getPlayerQuit()) {
					switch (opchar) {
					case 'a':
						if (this.add(opstring[1].toLowerCase(), Integer.parseInt(opstring[2]),
								Integer.parseInt(opstring[3]))) {
							avanzar = true;
						}
						break;
					case 'l':
						this.view.showMessage(Messages.LIST);
						break;
					case 'r':
						this.game.reset();
						avanzar = true;
						reset = true;
						break;
					case 'h':
						this.view.showMessage(Messages.HELP);
						break;
					case 'e':
						this.view.showMessage(Messages.PLAYER_QUITS);
						this.game.setPlayerQuitTrue();
						break;
					case 'n':
						avanzar = true;
						break;
					default:
						this.view.showMessage(Messages.INVALID_COMMAND);
						break;
					}
					if (!avanzar && !this.game.getPlayerQuit()) {
						opstring = this.view.getPrompt();
						opchar = getOption(opstring);
					} else if (avanzar && !reset) {
						this.game.update();
					}
				}
			}
		}
	}

	private boolean isValidPosition(Position pos) {
		return this.game.isInsideBoard(pos);
	}

	private boolean isValidObject(String name) {
		if (this.game.checkGameObject(name))
			return true;
		else
			return false;
	}

	private boolean areValidCoins(String planta) {
		return this.game.areEnoughCoins(planta);
	}

	private boolean add(String plant, int col, int row) {
		boolean res = false;

		Position pos = new Position(row, col);
		if (this.isValidPosition(pos)) {
			if (game.isEmpty(pos)) {
				if (this.isValidObject(plant)) {
					if (!this.areValidCoins(plant)) {
						this.view.showMessage(Messages.NOT_ENOUGH_COINS);
					} else {
						this.game.addGameObject(plant, pos);
						res = true;
					}
				} else {
					this.view.showMessage(Messages.INVALID_GAME_OBJECT);
				}
			} else {
				this.view.showError("Position already taken.");
			}
		} else {
			this.view.showMessage(Messages.INVALID_POSITION);
		}
		return res;
	}

	private char getOption(String[] op1) { // Para la practica_v2 conviene hacerlo mejor con un tipo numerado
		char res = 'i';
		String op = "";
		boolean ok = false;

		if (op1.length == 1) {
			op = op1[0].toLowerCase();
			ok = true;
		}

		else if (op1.length == 4) {
			// La comprobacion de las plantas va en check game object name
			op = op1[0].toLowerCase();
			int i = 0;
			int j = 0;
			;
			if (op1[2].charAt(0) == '-')
				i = 1;
			if (op1[3].charAt(0) == '-')
				j = 1;
			if (Character.isDigit(op1[2].charAt(i)) && (Character.isDigit(op1[3].charAt(j)))) {
				ok = true;
			}
		}

		if (ok) {
			if (op.equals("none") || op.equals("exit") || op.equals("add") || op.equals("list") || op.equals("help")
					|| op.equals("reset") || op.equals("n") || op.equals("e") || op.equals("a") || op.equals("l")
					|| op.equals("h") || op.equals("r")) {
				res = op.toLowerCase().charAt(0);
			} else {
				res = 'i';
			}
		}
		return res;
	}

}
