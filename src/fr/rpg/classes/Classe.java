package fr.rpg.classes;

import java.util.List;
import java.util.Random;

import fr.rpg.comportement.Attaque;

public class Classe {
	
	private String nom;
	private List<Attaque> listAttaque; // liste des attaques propres à la classe choisie
	
	
	public Classe() {
		super();
	}
	public Classe(String nom, List<Attaque> listAttaque) {
		super();
		this.setNom(nom);
		this.setListAttaque(listAttaque);
	}

	/**
	 * recuperer une attaque aléatoire parmis la liste d'attaques  et la renvoie
	 * @return une attaque aleatoire
	 */
	public Attaque getAttaque() {
		
		int index = new Random().nextInt(listAttaque.size());
		Attaque attaque = this.getListAttaque().get(index);
		return attaque;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the listAttaque
	 */
	public List<Attaque> getListAttaque() {
		return listAttaque;
	}

	/**
	 * @param listAttaque the listAttaque to set
	 */
	public void setListAttaque(List<Attaque> listAttaque) {
		this.listAttaque = listAttaque;
	}
	
	
}
