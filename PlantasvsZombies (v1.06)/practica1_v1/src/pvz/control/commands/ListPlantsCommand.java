package pvz.control.commands;

import pvz.view.Messages;
import pvz.control.Command;

public class ListPlantsCommand extends Command {

	public ListPlantsCommand() {
		this.name = Messages.COMMAND_LIST_PLANTS_NAME;
		this.shortcut = Messages.COMMAND_LIST_PLANTS_SHORTCUT;
		this.details = Messages.COMMAND_LIST_PLANTS_DETAILS;
		this.help = Messages.COMMAND_LIST_PLANTS_HELP;
	}

	public boolean matchCommand(String command) {
		return (command.toLowerCase().equals(this.name) || command.equals(this.shortcut));
	}
	
	@Override
	public void execute(GameModel model, GameView view) {
		// ...
	}
}
