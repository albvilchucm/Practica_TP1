package pvz.control.commands;

import pvz.view.Messages;
import pvz.control.Command;

public class CheatPlantCommand extends Command {
	
	public CheatPlantCommand() {
		this.name = Messages.COMMAND_CHEAT_PLANT_NAME;
		this.shortcut = Messages.COMMAND_CHEAT_PLANT_SHORTCUT;
		this.details = Messages.COMMAND_CHEAT_PLANT_DETAILS;
		this.help = Messages.COMMAND_CHEAT_PLANT_HELP;
	}

	@Override
	public void execute(GameModel model, GameView view) {
		// ...
	}
}