package pvz.control.commands;

import pvz.view.Messages;
import pvz.control.Command;

public class UpdateCommand extends Command{
	
	public UpdateCommand() {
		this.name = Messages.COMMAND_UPDATE_NAME;
		this.shortcut = Messages.COMMAND_UPDATE_SHORTCUT;
		this.details = Messages.COMMAND_UPDATE_DETAILS;
		this.help = Messages.COMMAND_UPDATE_HELP;
	}

	@Override
	public void execute(GameModel model, GameView view) {
		// ...
	}
}
