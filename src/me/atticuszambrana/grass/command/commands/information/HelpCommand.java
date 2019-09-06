package me.atticuszambrana.grass.command.commands.information;

import org.javacord.api.event.message.MessageCreateEvent;

import me.atticuszambrana.grass.command.Command;

public class HelpCommand extends Command {
	public HelpCommand() {
		super("help", "Display basic help information");
	}
	
	public void execute(MessageCreateEvent event) {
		event.getChannel().sendMessage("Hi");
	}
}
