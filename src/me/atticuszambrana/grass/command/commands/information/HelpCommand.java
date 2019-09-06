package me.atticuszambrana.grass.command.commands.information;

import java.util.concurrent.ExecutionException;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

import me.atticuszambrana.grass.Main;
import me.atticuszambrana.grass.command.Command;
import me.atticuszambrana.grass.command.CommandCenter;

public class HelpCommand extends Command {
	public HelpCommand() {
		super("help", "Display basic help information");
	}
	
	public void execute(MessageCreateEvent event) {
		EmbedBuilder embed = new EmbedBuilder();
		
		embed.setDescription("Check your DM's!");
		
		event.getChannel().sendMessage(embed);
		
		// Then in direct messages, actually send them all of the commands, along with their descriptions
		
		for(Command cmd : CommandCenter.commands) {
			EmbedBuilder command = new EmbedBuilder();
			command.addField(Main.getGrass().getConfig().getPrefix() + cmd.getCommandName(), cmd.getCommandDescription(), true);
			try {
				event.getApi().getUserById(event.getMessageAuthor().getId()).get().sendMessage(command);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}