package pvz.control.commands;

import pvz.view.Messages;
import pvz.control.Command;

public class AddZombieCommand extends Command {
	
	public AddZombieCommand() {
		this.name = Messages.COMMAND_ADD_ZOMBIE_NAME;
		this.shortcut = Messages.COMMAND_ADD_ZOMBIE_SHORTCUT;
		this.details = Messages.COMMAND_ADD_ZOMBIE_DETAILS;
		this.help = Messages.COMMAND_ADD_ZOMBIE_HELP;
	}

	@Override
	public void execute(GameModel model, GameView view) {
		// ...
	}
}
