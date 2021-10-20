package fr.rpg.individus;

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
	 */
	public void attaquer(Combattant defenseur) {
		Attaque randAttaque = this.getClasse().getAttaque();
		int degat = randAttaque.lancerAttaque(this, defenseur);
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

	
	
	
}
