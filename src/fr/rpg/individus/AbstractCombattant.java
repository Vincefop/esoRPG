package fr.rpg.individus;

public abstract class AbstractCombattant implements ICombattant{
	
	
	//ATTRIBUTS
	private String nom;
	private int pointDeVie;
	
	
	//CONSTRUCTEURS
	public AbstractCombattant() {
		this("DefaultName", 100);
	}
	public AbstractCombattant(String nom, int pointDeVie) {
		super();
		this.setPointDeVie(pointDeVie);
		this.setNom(nom);
	}
	
	
	/**
	 * On enleve les points de vie du combattant défenseur en paramètre à la hauteur des dégats de l' attaquant
	 * Appelle la methode Defendre du defenseur passé en Params.
	 * Affiche un message pour notifier de l'attaque
	 * 
	 * @param absC
	 */
	public abstract void attaquer(ICombattant defenseur);
	
	
	
	/**
	 * Soustrait aux points de vie les degats passé en params
	 */
	public void defendre(int degats) {
		System.out.println(this.getNom() + " perd " + degats + " points de vie");
		this.setPointDeVie(this.getPointDeVie()- degats);
		System.out.println(this.getNom() + " a encore " + this.getPointDeVie() + " points de vie.");
	}


	//ACCESSEURS
	/**
	 * @return the pointDeVie
	 */
	public int getPointDeVie() {
		return this.pointDeVie;
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
		return this.nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@Override
	public String toString() {
		return "Combattant [nom=" + this.nom + ", pointDeVie=" + this.pointDeVie + "]";
	}
	
	
}