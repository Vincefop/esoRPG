package fr.rpg;

import fr.rpg.univers.Personnage;
import fr.rpg.univers.Tools;

public class Start {

	
	
	
	/**
	* Cr�er un personnage avec tous ses attributs.
	* Demande a l'utilisateur d'entrer le nom du personnage.
	* retour: une instance de la classe Personnage correctement instanci�.
	**/
	public Personnage personnageFactory(){
	// Demander a l'utilisateur un nom de personnage
	// Cr�er un nouveau personnage en utilisant le constructeur
	// avec tous ses params (dont le nom qui vient d'etre choisie par l'utilisateur)
	// Retourner l'instance du personnage
		
		//r�cup�ration des attributs
		String nom = Tools.inputString("Veuillez entrer le nom du personnage : ");
		//cr�ation du personnage
		Personnage pers = new Personnage(nom, 100, 25);
		
		return pers;
	}
	
	
	
	public static void main(String[] args) {
		
	}

}
