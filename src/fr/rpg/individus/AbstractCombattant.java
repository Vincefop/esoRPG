package fr.rpg.individus;

public abstract class AbstractCombattant implements Combattant{
	
	
	//ATTRIBUTS
	private String nom;
	private int pointDeVie;
	
	
	//CONSTRUCTEURS
	public AbstractCombattant() {
		super();
	}
	public AbstractCombattant(String nom, int pointDeVie) {
		super();
		this.pointDeVie = pointDeVie;
		this.nom = nom;
	}
	
	
	/**
	 * On enleve les points de vie du combattant défenseur en paramètre à la hauteur des dégats de l' attaquant
	 * Appelle la methode Defendre du defenseur passé en Params.
	 * Affiche un message pour notifier de l'attaque
	 * 
	 * @param absC
	 */
	public abstract void attaquer(Combattant defenseur);
	
	
	
	/**
	 * Soustrait aux points de vie les degats passé en params
	 */
	public void defendre(int degats) {
		this.pointDeVie -= degats;
		System.out.println("Le defenseur " + this.nom + " n'a plus que " + this.pointDeVie + " points de vie.");
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
	
//	@Override
//	public String toString() {
//		return "Combattant [nom=" + this.nom + ", pointDeVie=" + this.pointDeVie + ", attaque=" + this.degats + "]";
//	}
	
	
}