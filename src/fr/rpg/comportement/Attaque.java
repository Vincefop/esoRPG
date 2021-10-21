package fr.rpg.comportement;

import fr.rpg.individus.Combattant;

public interface Attaque
{
	/**
	 * Renvoie un int qui sera les d�gats effectu�s du lanceur � la cible
	 * les d�gats d�pendent de la chance de toucher et de la puissance de l'attaque choisie
	 * @param lanceur
	 * @param cible
	 * @return le nombre de d�gats
	 */
	public int lancerAttaque(Combattant lanceur, Combattant cible);
	
	/**
	 * R�cup�re le nom de l'attaque
	 * @return 
	 */
	public String getNom();
	/**
	 * Donne un nouveau nom � l'attaque
	 * @param nom
	 */
	public void setNom(String nom);
	/**
	 * R�cup�re les d�gats
	 * @return
	 */
	public int getDegats();
	/**
	 * Change les d�gats
	 * @param degats
	 */
	public void setDegats(int degats);
	/**
	 * R�cup�re les chances de toucher
	 * @return
	 */
	public int getChanceDeToucher();
	/**
	 * change les chances de toucher
	 * @param chanceDeToucher
	 */
	public void setChanceDeToucher(int chanceDeToucher);
}
