package fr.rpg.univers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.rpg.Tools;
import fr.rpg.comportement.*;
import fr.rpg.individus.Classe;
import fr.rpg.individus.Combattant;
import fr.rpg.individus.Monstre;
import fr.rpg.individus.Personnage;

//Classe static Monde
//Une classe est consid�r�e comme statique quand toutes ses m�thodes et attributs sont statiques
public class Monde {
	
	/**
	* Cr�er un personnage avec tous ses attributs.
	* Demande a l'utilisateur d'entrer le nom du personnage.
	* retour: une instance de la classe Personnage correctement instanci�.
	**/
	public static Personnage personnageFactory(){
	// Demander a l'utilisateur un nom de personnage
	// Cr�er un nouveau personnage en utilisant le constructeur
	// avec tous ses params (dont le nom qui vient d'etre choisie par l'utilisateur)
	// Retourner l'instance du personnage
		
		//r�cup�ration des attributs
		String nom = Tools.inputString("Veuillez entrer le nom du personnage : ");
		//cr�ation de la liste d'attaque
		List<Attaque> listAttaque = new ArrayList<>();
		listAttaque.add(new BasiqueAttaque("basique", 50, 25));
		Classe petitGuerrier = new Classe("petitGuerrier", listAttaque);
		petitGuerrier.setListAttaque(listAttaque);
		//creation du personnage
		Personnage pers = new Personnage(nom, 100, 25, 50, petitGuerrier);
		
		return pers;
	}
	
	
	/**
	* Cr�er un monstre avec tous ses attributs.
	* Demande a l'utilisateur d'entrer le nom du monstre.
	* retour: une instance de la classe Monstre correctement instanci�.
	**/
	public static Monstre monstreFactory(){
	// Demander a l'utilisateur un nom de monstre
	// Cr�er un nouveau monstre en utilisant le constructeur
	// avec tous ses params (dont le nom qui vient d'etre choisie par l'utilisateur)
	// Retourner l'instance du monstre
		
		//r�cup�ration des attributs
		String nom = genererNomMonstre();
		//cr�ation du personnage
		Monstre mstre = new Monstre(nom, 100, 25, 50);
		
		return mstre;
	}
	
	
	
	/**
	 *  parcourt deux tableaux et ressort un nom al�atoire
	 * @return un nom al�atoire
	 */
	public static String genererNomMonstre() {
		String res="";
		//Deux listes al�atoires
		String[] debutNom = {"Chat","Chien","Chaton", "Canard", "Lapin", "Poussin", "Poule"};
		String[] finNom = {" Mechant"," De Feu"," De La Mort", " Du Demon", " Du Jugement Dernier", " Pendragon", " Des Enfers"};
		
		//je r�cup�re deux index au hasard
		int index1 = new Random().nextInt(debutNom.length);
		int index2 = new Random().nextInt(finNom.length);
		//je concat�ne leur valeur depuis les tableaux dans res
		res = debutNom[index1].concat(finNom[index2]);		
		return res;
	}
	
	
	/**
	 * les deux ennemis jouent a tour de r�les
	 * jusqu'� ce qu'un des deux n'ait plus de point de vie.
	 * @param combattant1
	 * @param combattant2
	 */
	public static void combat(Combattant combattant1, Combattant combattant2){
		
		System.out.println("Le COMBAT COMMENCE entre le combattant1 " + combattant1.getNom() + " et le combattant2 " + combattant2.getNom());

		
		Boolean pileFace = new Random().nextBoolean();
		if(pileFace) {
			System.out.println("Le hasard fait que c'est " + combattant1.getNom() + " qui attaque en premier.");
		}else
			System.out.println("Le hasard fait que c'est " + combattant2.getNom() + " qui attaque en premier.");
		
		//Variable d'arret du jeu quand un combattant est mort
		Boolean leJeuContinue = true;
		//tantque personne n'est mort
		while(leJeuContinue) {
			if(pileFace) {
				//Le personnage attaque le monstre
				System.out.println(combattant1.getNom() + " ATTAQUE " + combattant2.getNom());
				combattant1.attaquer(combattant2);
				//si le monstre est mort on sort
				if(combattant2.getPointDeVie()<=0) {
					System.out.println(combattant2.getNom() + " EST MORT. \n" + combattant1.getNom() + " A GAGNE !"
											+ "\nIl lui reste " + combattant1.getPointDeVie() + " points de vie");
					leJeuContinue = false;
				}
				//sinon on change d'attaquant
				pileFace = false;
			}else {
				//le monstre attaque le perso
				System.out.println(combattant2.getNom() + " ATTAQUE " + combattant1.getNom());
				combattant2.attaquer(combattant1);
				//si le perso est mort on sort
				if(combattant1.getPointDeVie()<=0) {
					System.out.println(combattant1.getNom() + " EST MORT. \n" + combattant2.getNom() +" A GAGNE ! "
											+ "\nIl lui reste " + combattant2.getPointDeVie() + " points de vie");
					
					leJeuContinue = false;
				}
				//Sinon on change d'attaquant
				pileFace = true;
			}
		}
	}	
	
	
	
	/**
	 * Affiche les informations du monde
	 */
	public static void afficherInformations() {
		System.out.println("MOnde");
	}

	
	
}
