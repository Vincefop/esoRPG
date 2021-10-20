package fr.rpg.individus;

import java.util.Random;

public class Monstre extends AbstractCombattant {
	
	private int degats;
	private int chanceDeToucher;
	
	//CONSTRUCTEURS
	public Monstre() {
		super();
	}
	public Monstre(String nom, int pointDeVie, int degats, int chanceDeToucher) {
		super(nom, pointDeVie);
		this.degats = degats;
		this.chanceDeToucher = chanceDeToucher;
	}
	
	
	@Override
	/**
	 * un monstre attaque avec ses dégats
	 */
	public void attaquer(Combattant defenseur) {
		//Ajout de la variable chance de Toucher
		int alea = new Random().nextInt(100);
		//si le lanceur a plus de chance de toucher que le chiffre aléatoire il touche
		if(alea < this.getChanceDeToucher()) {
			defenseur.defendre(degats);
			//System.out.println("Le personnage " + defenseur.getNom() + " a perdu " + this.degats + " points de vie." );
		}//sinon message d'échec et renvoyer 0;
		else
			System.out.println(this.getNom() + " a rate son attaque. " + defenseur.getNom() + " n'est pas touche.");
		//Si c'est un monstre on récupère ses dégats pour les infliger au defenseur
		
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * @return the degats
	 */
	public int getDegats() {
		return degats;
	}
	/**
	 * @param degats the degats to set
	 */
	public void setDegats(int degats) {
		this.degats = degats;
	}
	/**
	 * @return the chanceDeToucher
	 */
	public int getChanceDeToucher() {
		return chanceDeToucher;
	}
	/**
	 * @param chanceDeToucher the chanceDeToucher to set
	 */
	public void setChanceDeToucher(int chanceDeToucher) {
		this.chanceDeToucher = chanceDeToucher;
	}
	
		
	
}
