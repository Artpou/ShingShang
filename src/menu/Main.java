package menu;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;

public class Main extends Application{
	
	static public int Longueur = 800;
	static public int Largeur = 800;
	public static  String police = "Trebuchet MS";
	
	static private Scene sceneMenu = null;
	static private Scene sceneJeu = null;	
	static public Stage fenetre;

	
	/**
	 * Cr�er la fen�tre et affiche le menu
	 */
	public void start(Stage primaryStage) throws Exception{
		
		fenetre = primaryStage;
		
		//cr�er les diff�rents menus
		MenuJeu menu = new MenuJeu(this);
		sceneMenu = menu.scene;
		
		//cr�er le jeu
		Jeu jeu = new Jeu(fenetre);
		sceneJeu = jeu.scene;
				
		fenetre.setScene(sceneMenu);
		fenetre.setTitle("SHING SHANG");	
		fenetre.show();
	}

	static public Scene getSceneMenu() {
		return sceneMenu;
	}

	static public Scene getSceneJeu() {
		return sceneJeu;
	}

	/**
	 * Lance le programme
	 * @param args
	 */
	public static void main(String[] args) {
		
		launch(args);
	}
}