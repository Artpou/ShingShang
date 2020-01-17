package Gestion;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import menu.Jeu;

public class Deplacement extends StackPane {

	private int num;
	private boolean shingshang;
	private Bushi mange;
	/**
	 * Consructeur de la classe d�placement**/
	public Deplacement(int num,boolean estUnShingShang) {
			this.num = num;
			this.shingshang = estUnShingShang;
			this.mange = null;
			this.CreerAffichage();
	}
	
	private void CreerAffichage() {
		Rectangle r = new Rectangle(50,50);
		if(shingshang)
			r.setFill(Color.DARKRED);
		else
			r.setFill(Color.RED);
		this.getChildren().add(r);
	}
	
	public void CreerEcouteur(Jeu j,Bushi b) {
		this.setOnMousePressed(event -> {
			j.getPartie().getPlateau().deplaceBushi(b, this);
			j.getPartie().getPlateau().videDeplacement();
			if (this.shingshang) {
				try {		
					j.getPartie().getPlateau().creerDeplacement(j, b, this.shingshang);	
					if (j.getPartie().getPlateau().getDeplacement(1) == j.getPartie().caseInitalBushi.getDeplacement()
							&& j.getPartie().getPlateau().getDeplacement(2) == null)
						throw new Exception("Le d�placement est termin�");
					
					j.getPartie().enShingShang = true;
				} catch (Exception e) {
					j.getPartie().getPlateau().videDeplacement();
					j.getPartie().passeTourJoueur();
				}
			} else {
				j.getPartie().passeTourJoueur();
			}
			if (j.getPartie().finie()) {
				j.finieLaPartie();
			}
		});
	}	
	/**
	 * @return num,Le num�ro du d�placement.
	 * **/
	public int getNum() {
		return num;
	}
	/**
	 * @return Le bushi qui est mang� par le d�placement.
	 * **/
	public Bushi getBushi() {
		return mange;
	}
	/**
	 * Permet de d�finir le bushi qui est mang� par le d�placement.
	 * **/
	public void mange(Bushi bushi) {
		mange = bushi;
	}
	/**
	 * @return shingshang
	 * **/
	public boolean estUnShingShang() {
		return shingshang;
	}
}
