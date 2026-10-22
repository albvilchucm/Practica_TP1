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
		while (!this.game.getPlayerQuit() && !terminado) {
			this.view.showGame();
			String[] opstring = this.view.getPrompt();
			Command command = Command.parse(opstring);

			boolean avanzar = false;
			boolean reset = false;
			while (!avanzar && !this.game.getPlayerQuit()) {
					if (command != null) {
					command.execute(game, view);
					} else {
					view.showError(Messages.UNKNOWN_COMMAND);
					}
					}
			/*	
			if (!avanzar && !this.game.getPlayerQuit()) {
					opstring = this.view.getPrompt();
					opchar = getOption(opstring);
				} else if (avanzar && !reset) {
					this.game.update();
				}
				ESTO HAY QUE IMPLEMENTARLO EN COMMAND.EXECUTE */
			}
			if (this.game.haveFinished()) {
				terminado = true;
				this.view.showGame();
				this.view.showEndMessage();
				if (this.game.getZombies() == 0) {
					this.view.showMessage(Messages.PLAYER_WINS);
				} else {
					this.view.showMessage(Messages.ZOMBIES_WIN);
				}
			}
		}
	}

	private boolean isValidPosition(Position pos) {
		return this.game.isInsideBoard(pos);
	}

	private boolean isValidObject(String name) {
		return this.game.checkGameObject(name);
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
						this.view.showError(Messages.NOT_ENOUGH_COINS);
					} else {
						this.game.addGameObject(plant, pos);
						res = true;
					}
				} else {
					this.view.showError(Messages.INVALID_GAME_OBJECT);
				}
			} else {
				this.view.showError(Messages.INVALID_POSITION);
			}
		} else {
			this.view.showError(Messages.INVALID_POSITION);
		}
		return res;
	}

}

