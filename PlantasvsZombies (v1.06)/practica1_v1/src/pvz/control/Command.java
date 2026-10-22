package pvz.control;

import java.util.*;
import pvz.control.commands.*;
import java.util.Scanner;

public abstract class Command {
	private static final List<Command> AVAILABLE_COMMANDS = Arrays.asList(new AddPlantCommand(), new AddZombieCommand(),
			new ListPlantsCommand(), new ListZombiesCommand(), new ResetCommand(), new HelpCommand(), new ExitCommand(),
			new UpdateCommand(), new CheatPlantCommand(), new CatchCommand());

	// ...
	protected String name = "";
	protected String shortcut = "";
	protected String details = "";
	protected String help = "";

	// ...
	public static Command parse(String[] commandWords) {
		boolean found = false;
		int i = 0;
		int size = AVAILABLE_COMMANDS.size();
		Command res = null;
		while (!found && i < size) {
			if( AVAILABLE_COMMANDS.get(i).matchCommand(commandWords[0])) {
				res = AVAILABLE_COMMANDS.get(i);
				found = true;
			}
			else {i++;}
		}
		if(res.name == "add") {
			
		}
		return res;
	}
	// ...
	protected abstract boolean matchCommand(String string);
	
}
