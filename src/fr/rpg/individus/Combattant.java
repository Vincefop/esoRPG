package fr.rpg.individus;

public interface Combattant
{
	/**
	 * Permet au combattant d'attaquer 
	 * soit en utilisant ses dégats pour les monstres
	 * soit en utilisant la liste d' attaques disponible dans la classe de chaque personnage
	 * @param defenseur
	 */
	public void attaquer(Combattant defenseur);
	/**
	 * Permet au combattant de perdre des points de vie quand il se fait attaquer
	 * @param degats
	 */
	public void defendre(int degats);
	/**
	 * pour récupérer le nom du combattant
	 * @return
	 */
	public String getNom();
	/**
	 * donner un nouveau nom au combattant
	 * @param nom
	 */
	public void setNom(String nom);
	/**
	 * récupérer les points de vie
	 * @return
	 */
	public int getPointDeVie();
	/**
	 * changer les points de vie
	 * @param pdv
	 */
	public void setPointDeVie(int pdv);
	
	
	
}
