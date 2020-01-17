package Vue;

import javafx.scene.layout.HBox;
import menu.Jeu;
import menu.Main;

public class BarreJeu extends HBox {
	
	private String police = Main.police;
	
	/**
	 * Le Constrcteur de la classe BarreJeu
	 * @param j
	 */
	public BarreJeu(Jeu j) {
		BoutonJeu btnSauvegarde = new BoutonJeu("Sauvegarder",150,30);
		btnSauvegarde.setOnMouseClicked(event -> {
			j.sauvegardeLaPartie();
        });
		BoutonJeu btnPasseTour = new BoutonJeu("Finir le tour",150,30);
		btnPasseTour.setOnMouseClicked(event -> {
			j.getPartie().getPlateau().videDeplacement();
            j.getPartie().passeTourJoueur();
        });
		BoutonJeu btnReset = new BoutonJeu("Reset",150,30);
		btnReset.setOnMouseClicked(event -> {
            j.resetPartie();
        });
		BoutonJeu btnQuitter = new BoutonJeu("Quitter",150,30);
        btnQuitter.setOnMouseClicked(event -> {
            System.exit(0);
        });
		
		this.setSpacing(63);
		this.getChildren().addAll(btnSauvegarde, btnPasseTour, btnReset, btnQuitter);
	}
}
