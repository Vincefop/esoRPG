package fr.rpg.comportement;

import java.util.Random;

import fr.rpg.individus.*;

public class BasiqueAttaque implements IAttaque{

	private String nom;
	private int chanceDeToucher;
	private int degats;
	
	
	
	public BasiqueAttaque() {
		this(70, 25);
	}
	public BasiqueAttaque(int chanceDeToucher, int degats) {
		super();
		this.setNom("BasiqueAttaque");
		this.setChanceDeToucher(chanceDeToucher);
		this.setDegats(degats);
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
	public int lancerAttaque(ICombattant lanceur, ICombattant cible) {
		//le res
		int res = 0;
		//nombre aleatoire ou chance de toucher en pourcentage
		int alea = new Random().nextInt(100);
		//si le lanceur a plus de chance de toucher que le chiffre aléatoire il touche
		if(alea < this.getChanceDeToucher()) {
			res= this.getDegats();
		}//sinon message d'échec et renvoyer 0;
		else
			System.out.println("Attaque ratee");
			//System.out.println(lanceur.getNom() + " rate son attaque. " + cible.getNom() + "est indemne.");
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
