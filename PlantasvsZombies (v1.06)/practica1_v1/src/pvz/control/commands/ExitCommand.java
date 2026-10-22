package pvz.control.commands;

import pvz.view.Messages;
import pvz.control.Command;

public class ExitCommand extends Command {

	public ExitCommand() {
		this.name = Messages.COMMAND_EXIT_NAME;
		this.shortcut = Messages.COMMAND_EXIT_SHORTCUT;
		this.details = Messages.COMMAND_EXIT_DETAILS;
		this.help = Messages.COMMAND_EXIT_HELP;
	}

	@Override
	public void execute(GameModel model, GameView view) {
		// ...
	}
}
