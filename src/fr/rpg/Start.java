package fr.rpg;

import fr.rpg.univers.Monde;

public class Start {
	
	
	
	
	/**
	 * La m�thode main qui lance un monde
	 * @param args
	 */
	public static void main(String[] args) {
		
		Monde.initClasses();
		
		Monde.menu();
		
		
		
		
	}

}
