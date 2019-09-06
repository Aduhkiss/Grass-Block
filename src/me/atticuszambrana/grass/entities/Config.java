package me.atticuszambrana.grass.entities;

public class Config {
	
	String APP_ID;
	String TOKEN;
	String PREFIX;
	boolean DELETE_ON_RUN;
	
	public Config(String APP_ID, String TOKEN, String PREFIX, boolean DELETE_ON_RUN) {
		this.APP_ID = APP_ID;
		this.TOKEN = TOKEN;
		this.PREFIX = PREFIX;
		this.DELETE_ON_RUN = DELETE_ON_RUN;
	}
	
	public void setAppId(String app_id) {
		this.APP_ID = app_id;
	}
	
	public String getAppId() {
		return APP_ID;
	}
	
	public void setToken(String token) {
		this.TOKEN = token;
	}
	
	public String getToken() {
		return TOKEN;
	}
	
	public void setPrefix(String prefix) {
		this.PREFIX = prefix;
	}
	
	public String getPrefix() {
		return PREFIX;
	}
	
	public void setDeleteOnRun(boolean delete) {
		this.DELETE_ON_RUN = delete;
	}
	
	public boolean getDeleteOnRun() {
		return DELETE_ON_RUN;
	}
}
