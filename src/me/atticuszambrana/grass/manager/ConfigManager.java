package me.atticuszambrana.grass.manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

import me.atticuszambrana.grass.Grass;
import me.atticuszambrana.grass.entities.Config;

public class ConfigManager {
	Grass grass;
	String configFile = "config.json";
	
	// The current config on file
	Config config;
	
	public ConfigManager(Grass grass) {
		this.grass = grass;
		
		// Check to see if the file exists, if it doesn't, create it, then load it.
		// if it does, just load it
		if(!doesFileExist()) {
			writeData(getDefaultConfig());
			// Then shutdown the bot, and prompt the user to input the required data
			System.out.println("A new config file has been generated. Please enter the required information, then run again.");
			System.exit(0);
		} else {
			// Load the information
			config = getConfigFromData();
			
			// Then lets test to make sure that this actually works
			System.out.println("You're bot token is " + config.getToken() + " and prefix is " + config.getPrefix());
		}
	}
	
	public Config getConfig() {
		return config;
	}
	
	public void updateConfig() {
		Gson gson = new Gson();
		config = gson.fromJson(getData(), Config.class);
	}
	
	public Config getConfigFromData() {
		Gson gson = new Gson();
		return gson.fromJson(getData(), Config.class);
	}
	
	public String getData() {
		String line = null;
		
		StringBuilder builder = new StringBuilder();
		
		try {
			FileReader fileReader = new FileReader(configFile);
			
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while((line = bufferedReader.readLine()) != null) {
				builder.append(line);
			}
		} catch(FileNotFoundException ex) {
			// Create the file, and start out with a default config
			ex.printStackTrace();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		
		return builder.toString();
	}
	
	public Config getDefaultConfig() {
		Config config = new Config("NO_APP_ID", "NO_TOKEN", "!", true);
		return config;
	}
	
	public boolean doesFileExist() {
		boolean exists = true;
		try {
			FileReader reader = new FileReader(configFile);
		} catch(FileNotFoundException ex) {
			exists = false;
		}
		return exists;
	}
	
	public void writeData(Config config) {
		Gson gson = new Gson();
		String json = gson.toJson(config);
		
		try {
			FileWriter fileWriter = new FileWriter(configFile);
			
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			bufferedWriter.write(json);
			
			bufferedWriter.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}
