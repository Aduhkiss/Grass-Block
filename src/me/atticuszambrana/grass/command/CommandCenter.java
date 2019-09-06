package me.atticuszambrana.grass.command;

import java.util.ArrayList;
import java.util.List;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import me.atticuszambrana.grass.Grass;
import me.atticuszambrana.grass.command.commands.information.HelpCommand;

public class CommandCenter implements MessageCreateListener {
	
	public static List<Command> commands;
	Grass grass;
	
	public CommandCenter(Grass grass) {
		this.grass = grass;
		commands = new ArrayList<Command>();
		
		registerCommands();
	}
	
	private void registerCommands() {
		// Information
		commands.add(new HelpCommand());
		
	}
	
	@Override
	public void onMessageCreate(MessageCreateEvent event) {
		// Grab the prefix real quick from the config
		String prefix = grass.getConfig().getPrefix();
		boolean delete = grass.getConfig().getDeleteOnRun();
		
		// Make sure that we are only looking for messages that were sent by people
		if(event.getMessageAuthor().isBotUser()) {
			return;
		}
		
		// Then go through all of the commands
		for(Command cmd : commands) {
			// And if the message starts with the prefix and the command
			if(event.getMessageContent().startsWith(prefix + cmd.getCommandName())) {
				// Then execute the command
				if(delete) {
					// Figure out how the frick to actually delete the message
					//event.getMessage().delete().complete();
				}
				cmd.execute(event);
			}
		}
	}

}
