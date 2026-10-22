package pvz.control.commands;

import pvz.view.Messages;
import pvz.control.Command;

public class ListZombiesCommand extends Command {

	public ListZombiesCommand() {
		this.name = Messages.COMMAND_LIST_ZOMBIES_NAME;
		this.shortcut = Messages.COMMAND_LIST_ZOMBIES_SHORTCUT;
		this.details = Messages.COMMAND_LIST_ZOMBIES_DETAILS;
		this.help = Messages.COMMAND_LIST_ZOMBIES_HELP;
	}

	public boolean matchCommand(String command) {
		return (command.toLowerCase().equals(this.name) || command.equals(this.shortcut));
	}
	
	@Override
	public void execute(GameModel model, GameView view) {
		// ...
	}
}
