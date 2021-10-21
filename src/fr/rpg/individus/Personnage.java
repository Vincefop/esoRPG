package fr.rpg.individus;

import fr.rpg.classes.Classe;
import fr.rpg.comportement.Attaque;

public class Personnage extends AbstractCombattant{
	
	private Classe classe;
	
	//CONSTRUCTEURS
	public Personnage() {
		super();
	}
	public Personnage(Classe uneClasse) {
		super();
		this.classe = uneClasse;
	}
	public Personnage(String nom, int pointDeVie, int degats) {
		super(nom, pointDeVie);
	}
	public Personnage(String nom, int pointDeVie, int degats, int chanceDeToucher, Classe uneClasse) {
		super(nom, pointDeVie);
		this.classe = uneClasse;
	}

	
	
	@Override
	/**
	 * methode qui fait attaquer un personnage 
	 * il utilise une attaque random que sa classe lui permet d'utiliser.
	 * @param le combattant attaqué
	 */
	public void attaquer(Combattant defenseur) {
		//récupère une attaque random dans la liste de la classe
		Attaque randAttaque = this.getClasse().getAttaque();
		System.out.println(" avec " + randAttaque.getNom() + "(" + randAttaque.getDegats() + " degats)");
		//récupère si ses chances de toucher lui permet des dégats à infliger
		int degat = randAttaque.lancerAttaque(this, defenseur);
		//change les points de vie du défenseur
		if(degat!=0)
			defenseur.defendre(degat);
		
	}

	
	
	
	
	
	/**
	 * @return the uneClasse
	 */
	public Classe getClasse() {
		return classe;
	}
	/**
	 * @param uneClasse the uneClasse to set
	 */
	public void setClasse(Classe uneClasse) {
		this.classe = uneClasse;
	}
	@Override
	public String toString() {
		return "le " + classe.getNom() + " " + getNom() + " [PointDeVie=" + getPointDeVie() + "]";
	}

	
	
	
}
