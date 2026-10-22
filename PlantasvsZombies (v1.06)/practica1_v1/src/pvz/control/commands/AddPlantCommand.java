package pvz.control.commands;

import pvz.view.Messages;
import pvz.control.Command;

public class AddPlantCommand extends Command {
	
	public AddPlantCommand() {
		this.name = Messages.COMMAND_ADD_PLANT_NAME;
		this.shortcut = Messages.COMMAND_ADD_PLANT_SHORTCUT;
		this.details = Messages.COMMAND_ADD_PLANT_DETAILS;
		this.help = Messages.COMMAND_ADD_PLANT_HELP;
	}
	
	

	@Override
	public void execute(GameModel model, GameView view) {
	 //...
	}
}

