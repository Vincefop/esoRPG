package fr.rpg;

import fr.rpg.univers.Personnage;
import fr.rpg.univers.Tools;

public class Start {

	
	
	
	/**
	* Créer un personnage avec tous ses attributs.
	* Demande a l'utilisateur d'entrer le nom du personnage.
	* retour: une instance de la classe Personnage correctement instancié.
	**/
	public Personnage personnageFactory(){
	// Demander a l'utilisateur un nom de personnage
	// Créer un nouveau personnage en utilisant le constructeur
	// avec tous ses params (dont le nom qui vient d'etre choisie par l'utilisateur)
	// Retourner l'instance du personnage
		
		//récupération des attributs
		String nom = Tools.inputString("Veuillez entrer le nom du personnage : ");
		//création du personnage
		Personnage pers = new Personnage(nom, 100, 25);
		
		return pers;
	}
	
	
	
	public static void main(String[] args) {
		
	}

}
