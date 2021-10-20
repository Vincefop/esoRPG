package fr.rpg.comportement;

import fr.rpg.individus.Combattant;

public interface Attaque
{
	public int lancerAttaque(Combattant lanceur, Combattant cible);
	public String getNom();
	public void setNom(String nom);
	public int getDegats();
	public void setDegats(int degats);
	public int getChanceDeToucher();
	public void setChanceDeToucher(int chanceDeToucher);
}
