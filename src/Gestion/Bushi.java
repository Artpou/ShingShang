package Gestion;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import menu.Jeu;

public class Bushi extends StackPane  {
	
	private Couleur couleur;
	private TypeBushi type;
	private int num;

	public Bushi(TypeBushi type,Couleur couleur,int numero) {	
		try {			
			if (type == TypeBushi.Dragon && (numero <= 0 || numero > 2)) 
				throw new Exception("Un dragon doit avoir un numéro entre"
						+ " 1 et 2");
			else if (type == TypeBushi.Lion && (numero <= 0 || numero > 4)) 
				throw new Exception("Un lion doit avoir un numéro entre"
						+ " 1 et 4");
			else if	(type == TypeBushi.Singe && (numero <= 0 || numero > 6))
				throw new Exception("Un singe doit avoir un numéro entre"
						+ " 1 et 6");
			this.couleur = couleur;
			this.type = type;
			this.num = numero;
			
			this.creerAffichage();
			
		} catch(Exception e) {
			 System.out.println(e);
		}
		
	}
	/**
	 * Creer l'affichage du Bushi
	 */
	private void creerAffichage() {
        Image image;     
		if (this.getType() == TypeBushi.Dragon) {
			if (this.getCouleur() == Couleur.NOIR)
				image = new Image("file:ressources/dragonNoir.jpg");
			else
				image = new Image("file:ressources/dragonRouge.jpg");
		} else if (this.getType() == TypeBushi.Lion){
			if (this.getCouleur() == Couleur.NOIR)
				image = new Image("file:ressources/lionNoir.jpg");
			else
				image = new Image("file:ressources/lionRouge.jpg");
		} else {
			if (this.getCouleur() == Couleur.NOIR)
				image = new Image("file:ressources/singeNoir.jpg");
			else
				image = new Image("file:ressources/singeRouge.jpg");
		}		
        ImageView affichage = new ImageView();
		affichage.setImage(image);
		affichage.setFitWidth(50); 
		affichage.setFitHeight(50); 
		
        this.getChildren().add(affichage);
	}
	
	/**
	 * Creer l'écouteur pour le Bushi
	 * @param j
	 */
	public void creerEcouteur(Jeu j) {
		this.setOnMousePressed(event -> {
			try {
				if (j.getPartie().getJoueurCourant().getCouleur() == this.couleur) {
					if(j.getPartie().bushiSelectionne != null && !(j.getPartie().enShingShang)) {
						j.getPartie().getPlateau().videDeplacement();
						j.getPartie().getPlateau().creerDeplacement(j, this, false);
						j.getPartie().bushiSelectionne = this;
						j.getPartie().caseInitalBushi = j.getPartie().getPlateau().getCase(this);
					}else if (j.getPartie().bushiSelectionne == null) {
						j.getPartie().getPlateau().creerDeplacement(j, this, false);
						j.getPartie().bushiSelectionne = this;
						j.getPartie().caseInitalBushi = j.getPartie().getPlateau().getCase(this);
					}
				}
			} catch (Exception e) {
				//e.printStackTrace();
			}	
		});
	}

	/**
	 *@return La couleur du bushi.**/
	public Couleur getCouleur() {
		return couleur;
	}
	/**
	 * @return Le type du bushi.**/
	public TypeBushi getType() {
		return type;
	}
	/**
	 * @return Le numéro du bushi.**/
	public int getNum() {
		return num;
	}
	/**
	 * Teste l'égalitée entre deux bushis.
	 * @param bushi Le bushi que l'on souhaite comparer avec le bushi appelant la fonction
	 * @return False si les bushis ne sont pas égaux. True si ils le sont.**/
	public boolean equals(Bushi bushi) {
		if(this.type == bushi.type && this.couleur == bushi.couleur && this.num == bushi.num)
			return true;
		else
			return false;
	}
	
}