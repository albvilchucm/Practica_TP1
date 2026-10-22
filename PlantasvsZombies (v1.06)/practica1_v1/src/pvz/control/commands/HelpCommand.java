package pvz.control.commands;

import pvz.view.Messages;
import pvz.control.Command;

public class HelpCommand extends Command {

	public HelpCommand() {
		this.name = Messages.COMMAND_HELP_NAME;
		this.shortcut = Messages.COMMAND_HELP_SHORTCUT;
		this.details = Messages.COMMAND_HELP_DETAILS;
		this.help = Messages.COMMAND_HELP_HELP;
	}

	@Override
	public void execute(GameModel model, GameView view) {
		// ...
	}
	}

