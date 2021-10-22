package fr.rpg.univers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import fr.rpg.Tools;
import fr.rpg.classes.Classe;
import fr.rpg.comportement.AttaqueFeu;
import fr.rpg.comportement.BasiqueAttaque;
import fr.rpg.comportement.IAttaque;
import fr.rpg.individus.Groupe;
import fr.rpg.individus.ICombattant;
import fr.rpg.individus.Monstre;
import fr.rpg.individus.Personnage;

//Classe static Monde
//Une classe est considérée comme statique quand toutes ses méthodes et attributs sont statiques
public class Monde {
	
	
	//Pour arreter le code à chaque tour pour controler le combat
	public static Scanner scan = new Scanner(System.in);
	/*
	 * On crée un attribut classes qui contient toutes les classes autorisées dans ce monde
	 */
	public static Map<String, Classe> classes = initClasses()	;
	
	
	/**
	 * J'initialise les classes 
	 * 
	 * @return
	 */
	public static Map<String, Classe> initClasses() {
		Map<String, Classe> classes = new HashMap<>();
		//GUERRIER
		//je crée des Attaques
		BasiqueAttaque basAtt = new BasiqueAttaque();
		BasiqueAttaque mediumAtt = new BasiqueAttaque(80, 35);
		mediumAtt.setNom("Attaque Medium");
		BasiqueAttaque hardAtt = new BasiqueAttaque(25, 80);
		hardAtt.setNom("Attaque Dur");
		//Je crée une liste d'attaques et j'ajoute les attaques
		List<IAttaque> listAttGuerrier = new ArrayList<>();
		listAttGuerrier.add(basAtt);
		listAttGuerrier.add(mediumAtt);
		listAttGuerrier.add(hardAtt);
		//Je crée une classe et j'ajoute la liste d'attaques
		Classe guerrier = new Classe("Guerrier", listAttGuerrier);
		classes.put("Guerrier", guerrier);
		
		
		
		//MAGICIEN
		//Je crée des Attaques
		AttaqueFeu attFeu = new AttaqueFeu();
		AttaqueFeu mediumAttF = new AttaqueFeu(90,60);
		mediumAttF.setNom("Attaque Feu Medium");
		//Je crée une liste d'attaques et j'ajoute les attaques
		List<IAttaque> listMage = new ArrayList<>();
		listMage.add(attFeu);
		listMage.add(mediumAttF);
		listMage.add(basAtt);
		//Je crée une classe et j'ajoute la liste d'attaques
		Classe mage = new Classe("Mage", listMage);
		classes.put("Mage", mage);
		
		return classes;
	}
	
	/**
	 * Récupère une classe dans la map en fonction de son nom
	 * @param nom
	 * @return une classe
	 */
	public static Classe getClasse(String nom) {
		return classes.get(nom);
	}
	
	//Classe Guerrier = new Classe("Guerrier", );
	/**
	* Créer un personnage avec tous ses attributs.
	* Demande a l'utilisateur d'entrer le nom du personnage.
	* retour: une instance de la classe Personnage correctement instancié.
	**/
	public static ICombattant personnageFactory(){
	// Demander a l'utilisateur un nom de personnage
	// Créer un nouveau personnage en utilisant le constructeur
	// avec tous ses params (dont le nom qui vient d'etre choisie par l'utilisateur)
	// Retourner l'instance du personnage
		
		//récupération des attributs
		String nom = Tools.inputString("		Veuillez entrer le nom du personnage : ");
		System.out.println("		-------------------------------------------------------------------------------------------------------------------");
		System.out.println(">>>");
		//Choix de la classe du perso
		boolean rester = true;
		String classe = "-1";
		while(rester) {
			System.out.println("				Choisissez votre classe : ");
			System.out.println("				1. Guerrier");
			System.out.println("				2. Mage");
			System.out.println("		-------------------------------------------------------------------------------------------------------------------");
			System.out.println(">>>");
			int numeroClasse = Tools.inputInt("");
			switch(numeroClasse) {
				case 1 : {
					classe = "Guerrier";
					rester = false;
					break;
				}
					
				case 2 : {
					classe = "Mage";
					rester = false;
					break;
				}
				default : {
					System.out.println("chiffre non valide");
					break;
				}
			}
		}
		Classe randClasse = getClasse(classe);
		//creation du personnage
		Personnage pers = new Personnage(nom, 100, 25, 50, randClasse);
		
		return pers;
	}
	
	
	/**
	* Créer un monstre avec tous ses attributs.
	* Demande a l'utilisateur d'entrer le nom du monstre.
	* retour: une instance de la classe Monstre correctement instancié.
	**/
	public static ICombattant monstreFactory(){
	// Demander a l'utilisateur un nom de monstre
	// Créer un nouveau monstre en utilisant le constructeur
	// avec tous ses params (dont le nom qui vient d'etre choisie par l'utilisateur)
	// Retourner l'instance du monstre
		
		//récupération des attributs
		String nom = genererNomMonstre();
		//création du personnage
		Monstre mstre = new Monstre(nom, 100, 25, 50);
		
		return mstre;
	}
	
	
	
	/**
	 *  parcourt deux tableaux et ressort un nom aléatoire
	 * @return un nom aléatoire
	 */
	public static String genererNomMonstre() {
		String res="";
		//Deux listes aléatoires
		String[] debutNom = {"Chat","Chien","Chaton", "Canard", "Lapin", "Poussin", "Poule"};
		//sinon on peut faire  : 
		//List<String> list = Arrays.asList("Chat","Chien","Chaton", "Canard", "Lapin", "Poussin", "Poule");
		String[] finNom = {" Mechant"," De Feu"," De La Mort", " Du Demon", " Du Jugement Dernier", " Pendragon", " Des Enfers"};
		
		//je récupère deux index au hasard
		int index1 = new Random().nextInt(debutNom.length);
		int index2 = new Random().nextInt(finNom.length);
		//je concatène leur valeur depuis les tableaux dans res
		res = debutNom[index1].concat(finNom[index2]);		
		return res;
	}
	
	/**
	 * Crée un groupe de monstres
	 * @param nombre
	 * @return
	 */
	public static List<ICombattant> groupeMonstreFactory(int nombre) {
		//ma liste des résultats
		List<ICombattant> res = new ArrayList<>();
		//j'en crée nombre fois
		for(int i=0; i<nombre; i++) {
			res.add(monstreFactory());
		}
		return res;
	}
	
	/**
	 * Cree un groupe de personnages
	 * @param nombre
	 * @return
	 */
	public static List<ICombattant> groupePersonnageFactory(int nombre){
		//ma liste des résultats
		List<ICombattant> res = new ArrayList<>();
		//j'en crée nombre fois
		for(int i=0; i<nombre; i++) {
			res.add(personnageFactory());
		}
		return res;
	}
	
	/**
	 * les deux ennemis jouent a tour de rôles
	 * jusqu'à ce qu'un des deux n'ait plus de point de vie.
	 * @param combattant1
	 * @param combattant2
	 */
	public static void combat(ICombattant combattant1, ICombattant combattant2){
		
		//PRésentation des combattants
		System.out.println("Le COMBAT COMMENCE entre " + combattant1 + " et " + combattant2);

		
		Boolean pileFace = new Random().nextBoolean();
		if(pileFace) {
			System.out.println("Le hasard fait que " + combattant1.getNom() + " attaque en premier.");
		}else
			System.out.println("Le hasard fait que " + combattant2.getNom() + " attaque en premier.");
		
		//Variable d'arret du jeu quand un combattant est mort
		Boolean leJeuContinue = true;
		//tantque personne n'est mort
		while(leJeuContinue) {
			if(pileFace) {
				//Le personnage attaque le monstre
				System.out.print("\n" + combattant1.getNom() + " ATTAQUE " + combattant2.getNom());
				combattant1.attaquer(combattant2);
				//si le monstre est mort on sort
				if(combattant2.getPointDeVie()<=0) {
					System.out.println(combattant2.getNom() + " EST MORT. \n" + combattant1.getNom() + " A GAGNE !"
											+ "\nIl lui reste " + combattant1.getPointDeVie() + " points de vie");
					leJeuContinue = false;
				}
				//sinon on change d'attaquant
				//pileFace = false;
			}else {
				//le monstre attaque le perso
				System.out.print("\n" + combattant2.getNom() + " ATTAQUE " + combattant1.getNom());
				combattant2.attaquer(combattant1);
				//si le perso est mort on sort
				if(combattant1.getPointDeVie()<=0) {
					System.out.println(combattant1.getNom() + " EST MORT. \n" + combattant2.getNom() +" A GAGNE ! "
											+ "\nIl lui reste " + combattant2.getPointDeVie() + " points de vie");
					
					leJeuContinue = false;
				}
				//on change d'attaquant
				pileFace = !pileFace;
				scan.nextLine();
			}
			
		}
		scan.close();
	}
	
	
	/**
	 * MENU DEROULANT DEBUT DE PARTIE
	 */
	public static void menu() {
		System.out.println("		------------------------------------------------------Bonjour------------------------------------------------------");
		System.out.println("				Choisir une option : ");
		System.out.println("				1. Lancer un combat 1v1");
		System.out.println("				2. Lancer un combat de groupe");
		System.out.println("				3. One vs World Hardcore Edition");
		System.out.println("				4. Informations");
		System.out.println("				5. Quitter");
		System.out.println("		-------------------------------------------------------------------------------------------------------------------");
		System.out.println(">>>");
		int option = Tools.inputInt("");
		switch(option) {
			case 1 : combat1v1(); break;
			case 2 : System.out.println("combatGroupe()"); break;
			case 3 : System.out.println("combat1vWorld"); break;
			case 4 : System.out.println("Game developped by Vincent Debuisson	"); break;
			case 5 : System.out.println("A bientot"); System.exit(0);
			default : {
				System.out.println("chiffre non valide");
				menu();
				break;
			}
		}
		menu();
	}
	
	
	/**
	 * La méthode qui lance le jeu 1 contre 1
	 */
	public static void combat1v1() {
		
		System.out.println("				Bienvenu aux combats 1 v 1");
		System.out.println("		-------------------------------------------------------------------------------------------------------------------");
		
		Monde.combat(Monde.personnageFactory(), Monde.monstreFactory());
		
	}
	
	/**
	 * Lance les combats de groupe
	 */
	public static void combatGroupe() {
		
		System.out.println("				Bienvenu aux combats de groupes ");
		System.out.println("		-------------------------------------------------------------------------------------------------------------------");
		System.out.println("				Combien de monstres contiendra le groupe adverse ? ");
		System.out.println("		-------------------------------------------------------------------------------------------------------------------");
		System.out.println(">>>");
		int nombreMonstre = Tools.inputInt(null);
		Groupe mesMonstres = new Groupe(groupeMonstreFactory(nombreMonstre), "Le groupe des monstres");
		
		System.out.println("				Combien de personnages contiendra votre groupe ? ");
		System.out.println("		-------------------------------------------------------------------------------------------------------------------");
		System.out.println(">>>");
		int nombrePerso = Tools.inputInt(null);
		Groupe mesPerso = new Groupe(groupePersonnageFactory(nombrePerso), "le groupe de personnages");
		
		//tant que le groupe monstre est vivant ET le groupe perso est vivant
		//je vais prendre un membre au hasard dans chaque groupe et les faire s'attaquer avec la méthode combat
		//à la fin je mets un message pour afficher le vainqueur
		while(!mesMonstres.estMort() && !mesPerso.estMort()) {
			
		}
		
	}
	
	
	/**
	 * Affiche les informations du monde
	 */
	public static void afficherInformations() {
		System.out.println("MOnde");
	}

	
	
}
