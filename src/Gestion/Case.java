package Gestion;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

public class Case extends StackPane {
	
	public int x;
	public int y;
	private Bushi contiens;
	private Deplacement deplacement;
	
	/**
	 * Constructeur de la classe Case.**/
	public Case(int x, int y) {			
		try {
			if (!Case.estDansLePlateau(x, y))
				throw new Exception("La case ne doit pas sortir du plateau");
			this.x = x;
			this.y = y;
			this.contiens = null;
			this.deplacement = null;
			
			this.creerAffichage();
			
		}catch(Exception e) {
			System.out.print(e);
		}	
	}
	/**
	 * Creer l'affichage de la Case
	 */
	private void creerAffichage() {
		Rectangle r = new Rectangle(50,50);
		r.setFill(Color.LIGHTGREY);
		r.setStroke(Color.GHOSTWHITE);
		r.setStrokeWidth(3);
		r.setStrokeType(StrokeType.OUTSIDE);
		this.getChildren().add(r);
	}
	
	/**
	 * Teste si la case est dans le plateau.
	 * @param x La coordonnée x de la case.
	 * @param y La coordonnée y de la case.
	 * **/
	 public static boolean estDansLePlateau(int x, int y) {
		 if ( (x >= 0 && x <= 9) && (y == 4 || y == 5) )
			 return true;
		 else
		     if ( (x >= 1 && x <= 8) && (y >= 0 && y <= 9) )
		    	 return true;
		     else
		         return false;
	}
	/**
	 * Renvoie la couleur du portail ciblé.
	 * @param x La coordonnée x de la case.
	 * @param y la coordonnée y de la case.
	 * @return La couleur du portail si s'en est un. si non Null. **/	
	 public static Couleur estUnPortail(int x, int y) {
		 if ( x == 4 || x == 5) {
			 if (y == 1)
				 return Couleur.ROUGE;
			 else if (y == 8)
				 return Couleur.NOIR;
		 }				 
		return null;
	}
	/**
	 * Teste si la case est vide.
	 * @return True si la case est vide. False si elle ne l'est pas.**/
	public boolean estVide() {
		if (contiens == null)
			return true;
		else
			return false;
	}
	/**
	 * Teste si la case est un déplacement.
	 * @return True si la case est un déplacement. False si non.**/
	public boolean estUnDeplacement() {
		if (deplacement == null)
			return false;
		else
			return true;
	}
	/**
	 * @return Le bushi contenu dans la case.**/
	public Bushi getBushi() {
		return contiens;
	}
	/**
	 * Permet de définir le bushi contenu dans la case.**/
	public void setBushi(Bushi bushi) {
		contiens = bushi;
		this.getChildren().add(bushi);
	}
	/**
	 * Permet de vider la case.**/
	public void videLaCase() {
		contiens = null;
		//this.getChildren().clear();
		this.creerAffichage();
	}
	/**
	 * @return Le déplacement de la case.**/
	public Deplacement getDeplacement() {
		return deplacement;
	}
	/**
	 * Défini le déplacement de la case.**/
	public void setDeplacement(Deplacement deplacement) {
		this.deplacement = deplacement;
		this.getChildren().add(deplacement);
	}
	/**
	 * Vide le déplacement de la case.
	 * **/
	public void videDeplacement() {
		this.getChildren().remove(deplacement);
		deplacement = null;
	}
	
}

