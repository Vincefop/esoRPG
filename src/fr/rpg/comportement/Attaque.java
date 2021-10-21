package fr.rpg.comportement;

import fr.rpg.individus.Combattant;

public interface Attaque
{
	/**
	 * Renvoie un int qui sera les dégats effectués du lanceur à la cible
	 * les dégats dépendent de la chance de toucher et de la puissance de l'attaque choisie
	 * @param lanceur
	 * @param cible
	 * @return le nombre de dégats
	 */
	public int lancerAttaque(Combattant lanceur, Combattant cible);
	
	/**
	 * Récupère le nom de l'attaque
	 * @return 
	 */
	public String getNom();
	/**
	 * Donne un nouveau nom à l'attaque
	 * @param nom
	 */
	public void setNom(String nom);
	/**
	 * Récupère les dégats
	 * @return
	 */
	public int getDegats();
	/**
	 * Change les dégats
	 * @param degats
	 */
	public void setDegats(int degats);
	/**
	 * Récupère les chances de toucher
	 * @return
	 */
	public int getChanceDeToucher();
	/**
	 * change les chances de toucher
	 * @param chanceDeToucher
	 */
	public void setChanceDeToucher(int chanceDeToucher);
}
