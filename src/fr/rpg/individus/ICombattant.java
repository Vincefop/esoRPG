package fr.rpg.individus;

public interface ICombattant
{
	/**
	 * Permet au combattant d'attaquer 
	 * soit en utilisant ses d�gats pour les monstres
	 * soit en utilisant la liste d' attaques disponible dans la classe de chaque personnage
	 * @param defenseur
	 */
	public void attaquer(ICombattant defenseur);
	/**
	 * Permet au combattant de perdre des points de vie quand il se fait attaquer
	 * @param degats
	 */
	public void defendre(int degats);
	/**
	 * pour r�cup�rer le nom du combattant
	 * @return
	 */
	public String getNom();
	/**
	 * donner un nouveau nom au combattant
	 * @param nom
	 */
	public void setNom(String nom);
	/**
	 * r�cup�rer les points de vie
	 * @return
	 */
	public int getPointDeVie();
	/**
	 * changer les points de vie du Combattant
	 * @param pdv
	 */
	public void setPointDeVie(int pdv);
	/**
	 * retourne vrai si les points de vie sont �gal ou inf � 0
	 * @return
	 */
	//public boolean estMort();
	
	
}
