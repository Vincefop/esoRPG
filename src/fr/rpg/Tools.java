package fr.rpg;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Tools {

	/**
	 * Prends un message en paramètre affiché sur la console le message demande à
	 * l'utilisateur d'entrer un String
	 * 
	 * @param String qui sera affiché
	 * @return String le message String entré par l'utilisateur
	 */
	public static String inputString(String message) {
		// On affiche le message entré en paramètre
		System.out.println(message);
		// On créé un Scanner pour détecter une entrée sur la console
		Scanner scan = new Scanner(System.in);
		// On récupère le String entré par l'utilisateur, ici son nom
		return scan.next();
	}

	/**
	 * Prends un message en paramètre affiché sur la console le message demande à
	 * l'utilisateur d'entrer un int
	 * 
	 * @param String qui sera affiché
	 * @return int entré par l'utilisateur
	 */
	public static int inputInt(String message) {
		// On affiche le message entré en paramètre
		System.out.println(message);
		// On créé un Scanner pour détecter une entrée sur la console
		Scanner scan = new Scanner(System.in);
		// On récupère le int entré par l'utilisateur, ici son nom
		return scan.nextInt();
	}

	/**
	 * 
	 * fonction qui prends 2 entiers à l'utilisateur et qui renvoit leur somme
	 *
	 * @param int int
	 * @return int
	 */
	public static int sommeDeuxEntiers(int entier1, int entier2) {
		return (entier1 + entier2);

	}

	/**
	 * Fonction qui donne la différence entre deux entiers en param
	 * @param entier1
	 * @param entier2 2 entiers
	 * @return différence entre le premier et le deuxième entier
	 */
	public static int differenceDeuxEntiers(int entier1, int entier2) {
		// Je retourne la différence entre les deux
		return (entier1 - entier2);
	}

	/**
	 * Fonction qui va donner le chiffre le plus grand parmi des entiers donnés en
	 * param
	 * 
	 * @param args des entiers
	 * @return int le plus grand des entiers données en paramètre
	 */
	public static int plusGrandEntier(int... args) {
//		// J'initialise le max au premier chiffre
//		int max = args[0];
//		// Pour chaque entier des paramètres
//		for (int i : args) {
//			// si l'entier est plus grand que max, il prend la place du plus grand entier
//			if (i > max)
//				max = i;
//		}
//		// je retourne le résultat
//		return max;
		
		//autre méthode :
		int[] tab = args;
		Arrays.sort(tab);
		// ou Arrays.stream(tab).max().getAsInt();
		return tab[tab.length-1];
	}
	
	/**
	 * Rempli un tableau d'entiers randoms
	 * @param chiffre le chiffre maximum qu'on peut voir dans le tableau
	 * @param quantite la taille de la liste
	 */
	public static List<Integer> listEntiers(int chiffreMax, int quantite) {
		List<Integer> listNotes = new ArrayList<>();
		
		for (int i =0; i<quantite; i++) {
			listNotes.add(randomInt(chiffreMax));
		}
		
		return listNotes;
	}
	
	
	/**
	 * Rempli un tableau d'entiers randoms
	 * @param taille le chiffre maximum qu'on peut voir dans le tableau
	 * @param byte[] la taille de la liste
	 */
	public static byte[] listEntiersRelatifs(int taille) {
		
		byte[] listeNotes = new byte[taille];
		 
		for (int i =0; i<taille; i++) {
			Random random = new Random();
			random.nextBytes(listeNotes);
		}
		
		return listeNotes;
	}
	
	/**
	 * fonction qui envoie un entier random
	 * @param max l'entier max qu'on peut trouver
	 * 
	 */
	public static int randomInt(int max) {
		return new Random().nextInt(max);
	}
	

	/**
	 * Récupère tailleTab entiers et retourne un tableau de ces entiers
	 * 
	 * @param tailleTab
	 * @return int[] un tableau d'entier de taille tailleTab
	 */
	public static int[] recupereTabEntiersUtilisateur(int tailleTab) {
		// je crée mon tableau que je sors en sorti
		int[] tabEntier = new int[tailleTab];
		// Je demande un certain nombre d'entiers à l'utilisateur
		System.out.println("Entrez " + tailleTab + " entiers séparés par des virgules je vous donnerai le plus grand : ");
		// On créé un Scanner pour détecter une entrée sur la console
		Scanner scan = new Scanner(System.in);
		// Je rempli mon tableau avec les entiers tapés sur la console
		for (int i = 0; i < tailleTab; i++) {
			tabEntier[i] = scan.nextInt();
		}
		return tabEntier;
	}

	
		
	/**
	 * Fonction qui prend en param un entier 
	 * et renvoit la somme de tous les entiers entre 1 à cet entier
	 * @param int entier
	 * @return int un entier la somme des entiers jusqu'à cet entier
	 */
	public static int sommeDesNPremiersEntiers(int entier) {
		//mon décrémenteur
		int i = entier;
		//mon resultat aussi initialisé à lentier je gagne ainsi une boucle du while
		int res = entier;
		//le calcul du resultat
		while(i>0) {
			res += i-1;
			i--;
		}
		return res;
	}
	
	
	/**
	 * Prends un message en paramètre affiché sur la console le message demande à
	 * l'utilisateur d'entrer un float
	 * 
	 * @param String qui sera affiché
	 * @return float entré par l'utilisateur
	 */
	public static Float inputFloat(String message) {
		// On affiche le message entré en paramètre
		System.out.println(message);
		// On créé un Scanner pour détecter une entrée sur la console
		Scanner scan = new Scanner(System.in);
		// On récupère le String entré par l'utilisateur, ici son nom
		return scan.nextFloat();
	}
	
	
	/**
	 * Prends un message en paramètre affiché sur la console le message demande à
	 * l'utilisateur d'entrer un float
	 * 
	 * @param String qui sera affiché
	 * @return float entré par l'utilisateur
	 */
	public static double inputDouble(String message) {
		// On affiche le message entré en paramètre
		System.out.println(message);
		// On créé un Scanner pour détecter une entrée sur la console
		Scanner scan = new Scanner(System.in);
		// On récupère le String entré par l'utilisateur, ici son nom
		return scan.nextDouble();
	}
	
	
	/**
	 * Calcul à partir d'un tableau de bytes
	 * le chiffre le plus proche de zéro
	 * @param tabBytes tableau de bytes (valeurs positives et négatives)
	 * @return byte celui plus proche de zero
	 */
	public static byte valeurPlusProcheZero(byte[] tabBytes) {
		//J'initialise ma valeur min la plus proche de zero
		byte min = tabBytes[0];
		// je parcours mon tableau 
		for (byte b : tabBytes) {
			//si la valeur absolue de l'élément est plus petit que le min courant 
			if(Math.abs((int)b) < Math.abs((int)min)) {
				//alors je remplace le min par la valeur courante
				min = b;
			}
		}
		//je retourne la valeur la plus proche de zéro
		return min;
	}
	
	
	/**
	 * Prends un message en paramètre affiché sur la console le message demande à
	 * l'utilisateur d'entrer un char
	 * 
	 * @param String qui sera affiché
	 * @return char entré par l'utilisateur
	 */
	public static char inputChar(String message) {
		// On affiche le message entré en paramètre
		System.out.println(message);
		// On créé un Scanner pour détecter une entrée sur la console
		Scanner scan = new Scanner(System.in);
		// On récupère le String entré par l'utilisateur, ici son nom
		return scan.next().charAt(0);
	}
	
}




