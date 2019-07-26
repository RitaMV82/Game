package com.game.model;

import java.util.Random;

public class Machine {
	
	private Random random;
	private String[] movimientos = {"R", "P", "S"};
	
	public Machine(){
		random = new Random();
	}
	
	public String getMachineMove(){
		int rnd = random.nextInt(movimientos.length);		
		return movimientos[rnd];
		
	}
	
	
	
	
	
}
