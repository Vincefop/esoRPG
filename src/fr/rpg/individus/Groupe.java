package fr.rpg.individus;

import java.util.List;
import java.util.Random;

import fr.rpg.comportement.IAttaque;

public class Groupe implements ICombattant{

	//list des combattants
	private List<ICombattant> listCombattant;
	private String nomDuGroupe;
	private int pointDeVieDuGroupe;
	
	/**
	 * Constructeur
	 */
	public Groupe() {
		this(null, "defaultName", -1);
	}
	/**
	 * Constructeur param 
	 * @param listCombattant
	 */
	public Groupe(List<ICombattant> listCombattant) {
		this();
		this.listCombattant = listCombattant;
	}
	/**
	 * Constructeur param 
	 * @param listCombattant
	 */
	public Groupe(List<ICombattant> listCombattant, String nom) {
		this(listCombattant, nom, -1);
	}
	/**
	 * COnstructeur total
	 * @param listCombattant
	 * @param nomDuGroupe
	 * @param pointDeVieDuGroupe
	 */
	public Groupe(List<ICombattant> listCombattant, String nomDuGroupe, int pointDeVieDuGroupe) {
		super();
		this.setListCombattant(listCombattant);
		this.setNom(nomDuGroupe); 
		this.setPointDeVie(pointDeVieDuGroupe);
	}
	
	
	
	
	
	//METHODES
	/**
	 * ajouter un combattant à la liste
	 * @param unCombattant
	 */
	public void addCombattant(ICombattant combat) {
		listCombattant.add(combat);
	}
	
	/**
	 * Vrai si tous les membres sont morts
	 * @return 
	 */
	public boolean estMort() {
		boolean dead = false;
		if(this.getPointDeVie()==0)
			dead = true;
		return dead;
	}
	
	
	/**
	 * choisie un Combattant aléatoire du groupe qui attaque le groupe ennemi 
	 */
	@Override
	public void attaquer(ICombattant defenseur) {
		int index = new Random().nextInt(this.getListCombattant().size());
		ICombattant attaquant = this.getListCombattant().get(index);
		System.out.println(""+ attaquant.getNom() + " attaque pour " + this.getNom());
		
		
		//CODE DE PERSONNAGES
		if(attaquant instanceof Personnage) {
			//récupère une attaque random dans la liste de la classe
			IAttaque randAttaque = ((Personnage) attaquant).getClasse().getAttaque();
			System.out.println(" avec " + randAttaque.getNom() + "(" + randAttaque.getDegats() + " degats)");
			//récupère si ses chances de toucher lui permet des dégats à infliger
			int degat = randAttaque.lancerAttaque(this, defenseur);
			//change les points de vie du défenseur
			if(degat!=0)
				defenseur.defendre(degat);
		//CODE DE MONSTRES SI JAMAIS IL FALLAIT
		}else if(attaquant instanceof Monstre) {
			attaquant.attaquer(defenseur);
		}
		
	}

	/**
	 * choisie un aléatoirement un Combattant vivant du groupe qui va recevoir les dégats
	 */
	@Override
	public void defendre(int degats) {
		boolean isDead = true;
		ICombattant defenseur = null;
		//tant que l'attaquand est mort je vais continuer à prendre un Combattant aléatoire
		while(isDead) {
			int index = new Random().nextInt(this.getListCombattant().size());
			defenseur = this.getListCombattant().get(index);
			//si l'attaquant est en vie je sors
			if(defenseur.getPointDeVie()>0) {
				isDead = false;
			}
		}
		//System.out.println(defenseur.getNom() + " a ete choisi pour prendre les degats");
		//CODE DE ABSTRACTCOMBATTANT
		System.out.println(this.getNom() + " perd " + degats + " points de vie");
		this.setPointDeVie(this.getPointDeVie()- degats);
		System.out.println(this.getNom() + " a encore " + this.getPointDeVie() + " points de vie.");
		
	}

	@Override
	public String getNom() {
		return this.nomDuGroupe;
	}

	@Override
	public void setNom(String nom) {
		this.nomDuGroupe = nom;
	}

	@Override
	public int getPointDeVie() {
		setPointDeVie(pointDeVieDuGroupe);
		return this.pointDeVieDuGroupe;
	}

	@Override
	public void setPointDeVie(int pdv) {
		pdv = 0;
		if(!this.getListCombattant().isEmpty()) {
			for (ICombattant combattant : listCombattant) {
				pdv += combattant.getPointDeVie();
			}
		}else
			System.out.println("Il n'y a pas de combattants dans ce groupe");
		this.pointDeVieDuGroupe=pdv;
	}
	/**
	 * @return the listCombattant
	 */
	public List<ICombattant> getListCombattant() {
		return listCombattant;
	}
	/**
	 * @param listCombattant the listCombattant to set
	 */
	public void setListCombattant(List<ICombattant> listCombattant) {
		this.listCombattant = listCombattant;
	}
	

}
