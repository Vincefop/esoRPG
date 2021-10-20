package fr.rpg.individus;

import java.util.List;
import java.util.Random;

import fr.rpg.comportement.Attaque;

public class Classe {
	
	private String nom;
	private List<Attaque> listAttaque;
	
	
	public Classe() {
		super();
	}
	public Classe(String nom, List<Attaque> listAttaque) {
		super();
		this.nom = nom;
		this.listAttaque = listAttaque;
	}

	/**
	 * recuperer une attaque parmis la liste d'attaques  et la renvoie
	 * @return une attaque aleatoire
	 */
	public Attaque getAttaque() {
		
		int index = new Random().nextInt(listAttaque.size());
		Attaque attaque = listAttaque.get(index);
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
