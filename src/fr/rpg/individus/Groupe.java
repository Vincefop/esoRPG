package fr.rpg.individus;

import java.util.List;
import java.util.Random;

import fr.rpg.comportement.Attaque;

public class Groupe implements Combattant{

	//list des combattants
	private List<Combattant> listCombattant;
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
	public Groupe(List<Combattant> listCombattant) {
		this();
		this.listCombattant = listCombattant;
	}
	/**
	 * Constructeur param 
	 * @param listCombattant
	 */
	public Groupe(List<Combattant> listCombattant, String nom) {
		this(listCombattant, nom, -1);
	}
	/**
	 * COnstructeur total
	 * @param listCombattant
	 * @param nomDuGroupe
	 * @param pointDeVieDuGroupe
	 */
	public Groupe(List<Combattant> listCombattant, String nomDuGroupe, int pointDeVieDuGroupe) {
		super();
		this.setListCombattant(listCombattant);
		this.setNom(nomDuGroupe); 
		this.setPointDeVie(pointDeVieDuGroupe);
	}
	
	
	
	
	
	//METHODES
	/**
	 * ajouter un combattant � la liste
	 * @param unCombattant
	 */
	public void addCombattant(Combattant combat) {
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
	 * choisie un Combattant al�atoire du groupe qui attaque le groupe ennemi 
	 */
	@Override
	public void attaquer(Combattant defenseur) {
		int index = new Random().nextInt(this.getListCombattant().size());
		Combattant attaquant = this.getListCombattant().get(index);
		System.out.println(""+ attaquant.getNom() + " attaque pour " + this.getNom());
		
		
		//CODE DE PERSONNAGES
		if(attaquant instanceof Personnage) {
			//r�cup�re une attaque random dans la liste de la classe
			Attaque randAttaque = ((Personnage) attaquant).getClasse().getAttaque();
			System.out.println(" avec " + randAttaque.getNom() + "(" + randAttaque.getDegats() + " degats)");
			//r�cup�re si ses chances de toucher lui permet des d�gats � infliger
			int degat = randAttaque.lancerAttaque(this, defenseur);
			//change les points de vie du d�fenseur
			if(degat!=0)
				defenseur.defendre(degat);
		//CODE DE MONSTRES
		}else if(attaquant instanceof Monstre) {
			attaquant.attaquer(defenseur);
		}
		
	}

	/**
	 * choisie un al�atoirement un Combattant vivant du groupe qui va recevoir les d�gats
	 */
	@Override
	public void defendre(int degats) {
		boolean isDead = true;
		Combattant defenseur = null;
		//tant que l'attaquand est mort je vais continuer � prendre un Combattant al�atoire
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
			for (Combattant combattant : listCombattant) {
				pdv += combattant.getPointDeVie();
			}
		}else
			System.out.println("Il n'y a pas de combattants dans ce groupe");
		this.pointDeVieDuGroupe=pdv;
	}
	/**
	 * @return the listCombattant
	 */
	public List<Combattant> getListCombattant() {
		return listCombattant;
	}
	/**
	 * @param listCombattant the listCombattant to set
	 */
	public void setListCombattant(List<Combattant> listCombattant) {
		this.listCombattant = listCombattant;
	}
	

}
