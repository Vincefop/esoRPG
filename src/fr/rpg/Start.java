package fr.rpg;

import fr.rpg.univers.*;

public class Start {

	public static void main(String[] args) {
		Monde.combat(Monde.personnageFactory(), Monde.monstreFactory());
	}

}
