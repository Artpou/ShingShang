package Gestion;
import java.util.LinkedList;

import menu.Jeu;

public class Joueur {
	
	private Couleur couleur;
	public LinkedList<Bushi> armee;
	/**
	 * Constructeur de la classe Joueur.
	 * @param couleur La couleur du joueur.**/
	public Joueur(Couleur couleur) {
		this.couleur = couleur;
		this.armee = new LinkedList<Bushi>();
	}
	/**
	 * @return couleur, La couleur du joueur.**/
	public Couleur getCouleur() {
		return couleur;
	}
	/**
	 * Permet de remplir l'armée d'un joueur.**/
	public void remplieArmee(Jeu j){
		if(!armee.isEmpty())
			armee.clear();
		
		for(int i = 1;i <= 6;i++) {
			if (i <= 2)
				armee.add(new Bushi(TypeBushi.Dragon,couleur,i));
			if (i <= 4)
				armee.add(new Bushi(TypeBushi.Lion,couleur,i));
			
			armee.add(new Bushi(TypeBushi.Singe,couleur,i));					
		}
		this.creerEcouteurBushi(j);
	}
	/**
	 * Creer les écouteurs pour tous les Bushi
	 * @param j - Jeu
	 */
	private void creerEcouteurBushi(Jeu j) {
		for (int i = 0;i < armee.size(); i++) {
			armee.get(i).creerEcouteur(j);
		}
	}
}
