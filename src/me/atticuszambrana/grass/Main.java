package me.atticuszambrana.grass;

public class Main {
	
	static Grass grass;
	
	public static void main(String[] args) {
		grass = new Grass();
	}
	
	public static Grass getGrass() {
		return grass;
	}
}
