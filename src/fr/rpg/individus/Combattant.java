package fr.rpg.individus;

public interface Combattant
{
	public void attaquer(Combattant defenseur);
	public void defendre(int degats);
	public String getNom();
	public void setNom(String nom);
	public int getPointDeVie();
	public void setPointDeVie(int pdv);
	
	
	
}
