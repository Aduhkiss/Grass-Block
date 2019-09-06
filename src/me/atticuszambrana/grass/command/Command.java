package me.atticuszambrana.grass.command;

import org.javacord.api.event.message.MessageCreateEvent;

public abstract class Command {
	
	String command;
	String description;
	
	public Command(String command, String description) {
		this.command = command;
		this.description = description;
	}
	
	public String getCommandName() {
		return command;
	}
	
	public String getCommandDescription() {
		return description;
	}
	
	public abstract void execute(MessageCreateEvent event);
}
