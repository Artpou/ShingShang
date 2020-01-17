package Gestion;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import menu.Jeu;
import menu.Main;

public class Partie extends StackPane {
	
	private int nbTour;
	
	private Plateau plateau;
	
	private Rectangle rectangleInfos;
	private Text infos;
	
	private Joueur joueurCourant;
	private Joueur joueurRouge;
	private Joueur joueurNoir;
	
	protected Bushi bushiSelectionne;
	protected Case caseInitalBushi;
	
	protected boolean enShingShang;
	
	/**
	 * Constructeur de la classe partie.
	 * **/
	public Partie(Jeu j,Joueur joueur1, Joueur joueur2) {
		nbTour=1;
		joueurRouge = joueur1;
		joueurNoir = joueur2;
		joueurCourant = joueurRouge;
		
		plateau = new Plateau();
		joueurRouge.remplieArmee(j);
		joueurNoir.remplieArmee(j);
		plateau.poseArmee(joueurRouge.armee);
		plateau.poseArmee(joueurNoir.armee);
			
		infos = new Text("TOUR : " + nbTour + " | " + "AU JOUEUR "+joueurCourant.getCouleur() + " DE JOUER");
		infos.setFill(Color.WHITE);
		infos.setFont(Font.font(Main.police, FontWeight.SEMI_BOLD,25));
		
		rectangleInfos = new Rectangle(Main.Longueur-5,100);
		rectangleInfos.setFill(Color.DARKRED);
		rectangleInfos.setStroke(Color.GHOSTWHITE);
		rectangleInfos.setStrokeWidth(5);
			
		this.getChildren().addAll(rectangleInfos, infos);
	}
	/**
	 * @return le tour actuel
	 */
	public int getNbTour() {
		return nbTour;
	}
	/**
	 * @return le plateau de la partie
	 */
	public Plateau getPlateau() {
		return plateau;
	}
	/**
	 * @return le Joueur actuel
	 */
	public Joueur getJoueurCourant() {
		return joueurCourant;
	}

	/**
	 * Teste si la partie est finie.
	 * @return True si la partie est finie. False si elle n'est pas finie.**/
	public void passeTourJoueur() {
		bushiSelectionne = null;
		enShingShang = false;
		if (joueurCourant.getCouleur() == Couleur.ROUGE) {
			joueurCourant = joueurNoir;
			rectangleInfos.setFill(Color.BLACK);
		}else {
			joueurCourant = joueurRouge;
			rectangleInfos.setFill(Color.DARKRED);
			nbTour++;
		}
		infos.setText("TOUR : " + nbTour + " | " + "AU JOUEUR "+joueurCourant.getCouleur() + " DE JOUER");
	}
	/**
	 * Teste si la partie est finie.
	 * @return True si la partie est finie. False si elle n'est pas finie.**/
	public boolean finie() {
		if(this.gagnant() == null)
			return false;
		else
			return true;
	}
	/**
	 * Détermine le joueur qui a gagné la partie.
	 * @return le Joueur qui a gagné.**/
	public Joueur gagnant() {
		Joueur gagnant;
		
		if ((!plateau.getCase(4,1).estVide() && plateau.getCase(4,1).getBushi().getCouleur() == Couleur.NOIR) ||
				(!plateau.getCase(5,1).estVide() && plateau.getCase(5,1).getBushi().getCouleur() == Couleur.NOIR))
			return joueurNoir;
		else if ((!plateau.getCase(4,8).estVide() && plateau.getCase(4,8).getBushi().getCouleur() == Couleur.ROUGE) ||
					(!plateau.getCase(5,8).estVide() && plateau.getCase(5,8).getBushi().getCouleur() == Couleur.ROUGE))
			return joueurRouge;
		else {
			gagnant = joueurNoir;
			for (int y = 0; y < 10;y++)
				for (int x = 0; x < 10;x++)
					if (Case.estDansLePlateau(x, y) && plateau.getCase(x, y).getBushi() != null)
						if (plateau.getCase(x, y).getBushi().getType() == TypeBushi.Dragon && plateau.getCase(x, y).getBushi().getCouleur() == Couleur.ROUGE)
							gagnant = null;
			
			if (gagnant != null)
				return gagnant;
			
			gagnant = joueurRouge;
			for (int y = 0; y < 10;y++)
				for (int x = 0; x < 10;x++)
					if (Case.estDansLePlateau(x, y) && plateau.getCase(x, y).getBushi() != null)
						if (plateau.getCase(x, y).getBushi().getType() == TypeBushi.Dragon && plateau.getCase(x, y).getBushi().getCouleur() == Couleur.NOIR)
							gagnant = null;
				
			return gagnant;
		}	
	}
}
