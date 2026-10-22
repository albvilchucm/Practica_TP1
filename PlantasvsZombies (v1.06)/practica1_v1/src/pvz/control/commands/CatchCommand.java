package pvz.control.commands;

import pvz.view.Messages;
import pvz.control.Command;

public class CatchCommand extends Command{
	
	public CatchCommand() {
		this.name = Messages.COMMAND_CATCH_NAME;
		this.shortcut = Messages.COMMAND_CATCH_SHORTCUT;
		this.details = Messages.COMMAND_CATCH_DETAILS;
		this.help = Messages.COMMAND_CATCH_HELP;
	}

	@Override
	public void execute(GameModel model, GameView view) {
		// ...
	}
}
