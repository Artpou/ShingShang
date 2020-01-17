package Gestion;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Portail extends Case {

	private Couleur couleur;
	
	/**
	 * Constructeur de la classe portail.
	 * **/
	public Portail(int x, int y,Couleur couleur) {
		super(x, y);
		this.couleur = couleur;
		this.creerAffichage();
	}
	/**
	 * Créer l'affichage du portail.
	 */
	private void creerAffichage() {
        Image image;     
		if (this.couleur == Couleur.NOIR)
			image = new Image("file:ressources/portailNoir.jpg");
		else
			image = new Image("file:ressources/portailRouge.jpg");
		
        ImageView affichage = new ImageView();
		affichage.setImage(image);
		affichage.setFitWidth(50); 
		affichage.setFitHeight(50); 
		
        this.getChildren().add(affichage);
	}
	
	public Couleur getCouleur() {
		return couleur;
	}
}
