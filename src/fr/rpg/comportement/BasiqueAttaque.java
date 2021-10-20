package fr.rpg.comportement;

import java.util.Random;

import fr.rpg.individus.*;

public class BasiqueAttaque implements Attaque{

	private String nom;
	private int chanceDeToucher;
	private int degats;
	
	
	
	public BasiqueAttaque() {
		super();
	}
	public BasiqueAttaque(String nom, int chanceDeToucher, int degats) {
		super();
		this.nom = nom;
		this.chanceDeToucher = chanceDeToucher;
		this.degats = degats;
	}

	/**
	 * Génère un nombre aleatoire compris entre 0 et 100
	 * si rand < chanceToucher
	 * retourner lanceur.Degats
	 * sinon
	 * renvoyer 0 et afficher un message d'echec
	 * @param lanceur
	 * @param cible
	 */
	@Override
	public int lancerAttaque(Combattant lanceur, Combattant cible) {
		//le res
		int res = 0;
		//nombre aleatoire ou chance de toucher en pourcentage
		int alea = new Random().nextInt(100);
		//si le lanceur a plus de chance de toucher que le chiffre aléatoire il touche
		if(alea < this.getChanceDeToucher()) {
			res= this.getDegats();
		}//sinon message d'échec et renvoyer 0;
		else
			System.out.println(lanceur.getNom() + " a raté son attaque. " + cible.getNom() + " n'est pas touché.");
		return res;
	}

	@Override
	public String getNom() {
		return this.nom;
	}

	@Override
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public int getDegats() {
		return this.degats;
	}

	@Override
	public void setDegats(int degats) {
		this.degats= degats;
	}
	/**
	 * @return the chanceDeToucher
	 */
	public int getChanceDeToucher() {
		return this.chanceDeToucher;
	}

	/**
	 * @param chanceDeToucher the chanceDeToucher to set
	 */
	public void setChanceDeToucher(int chanceDeToucher) {
		this.chanceDeToucher = chanceDeToucher;
	}


}
