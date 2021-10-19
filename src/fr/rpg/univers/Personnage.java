package fr.rpg.univers;

public class Personnage {
	
	//ATTRIBUTS
	private String nom;
	private int pointDeVie;
	private int degats;
	
	
	//CONSTRUCTEURS
	public Personnage() {
		super();
	}
	public Personnage(String nom, int pointDeVie, int degats ) {
		super();
		this.pointDeVie = pointDeVie;
		this.degats = degats;
		this.nom = nom;
	}
	

	//ACCESSEURS
	/**
	 * @return the pointDeVie
	 */
	public int getPointDeVie() {
		return pointDeVie;
	}
	/**
	 * @param pointDeVie the pointDeVie to set
	 */
	public void setPointDeVie(int pointDeVie) {
		this.pointDeVie = pointDeVie;
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
	@Override
	public String toString() {
		return "Personnage [nom=" + this.nom + ", pointDeVie=" + this.pointDeVie + ", attaque=" + this.degats + "]";
	}
	
	
}
