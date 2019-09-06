package me.atticuszambrana.grass;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

import me.atticuszambrana.grass.command.CommandCenter;
import me.atticuszambrana.grass.entities.Config;
import me.atticuszambrana.grass.manager.ConfigManager;

public class Grass {
	
	DiscordApi api;
	Config config;
	
	// Managers
	ConfigManager configManager;
	
	public Grass() {
		registerManagers();
		config = configManager.getConfig();
		startAPI();
	}
	
	private void registerManagers() {
		configManager = new ConfigManager(this);
	}
	
	private void startAPI() {
		api = new DiscordApiBuilder()
				.setToken(config.getToken())
				.addListener(new CommandCenter(this))
				.login()
				.join();
	}
	
	public DiscordApi getAPI() {
		return api;
	}
	
	public Config getConfig() {
		return config;
	}

}
