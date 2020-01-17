package menu;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

import javafx.stage.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import Gestion.*;
import Vue.BarreJeu;
import Vue.BoutonJeu;
import menu.Main;

public class Jeu extends GridPane {
	
    private String police = Main.police;
    private int Longueur = Main.Longueur;
    private int Largeur = Main.Largeur;
    
    private Partie partie;
    
    public Scene scene;
	/**
	 * Le Constructeur de jeu
	 * @param Fenetre
	 */
	public Jeu(Stage Fenetre){
		Joueur j1 = new Joueur(Couleur.ROUGE);
		Joueur j2 = new Joueur(Couleur.NOIR);
		partie = new Partie(this,j1,j2);
		try {
			scene = creerScene();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		TestScenario test = new TestScenario(partie.getPlateau());
		Scanner sc = new Scanner(System.in);
		
			System.out.println("CHARGER SCENARIO");
			int i = sc.nextInt();
			test.changeScenario(i);
	}
	/**
	 * @return la scène du jeu.
	 * @throws IOException
	 */
	private Scene creerScene() throws IOException {
		//créer la fenetre
		Pane root = new Pane();
		root.setPrefSize(Longueur, Largeur);
		
		//affiche la barre de jeu
		BarreJeu barre = new BarreJeu(this);
		this.getChildren().add(barre);
		
		partie.setLayoutY(40);
		root.getChildren().add(partie);
		
		//affiche le plateau
		partie.getPlateau().setLayoutX(100);
		partie.getPlateau().setLayoutY(160);
		root.getChildren().add(partie.getPlateau());
		
		//creer le background
		root.getChildren().add(this);
		Color c1 = Color.web("#737373");
		Color c2 = Color.web("#1a1a1a");
		Stop[] stops = new Stop[] { new Stop(0, c1), new Stop(1, c2)};
		LinearGradient degrade = new LinearGradient(0, 1, 0, 0, true, CycleMethod.NO_CYCLE, stops);
		
		Scene scene = new Scene(root,degrade);	
		return scene;
	}
	/**
	 * @return la Partie actuel.
	 */
	public Partie getPartie() {
		return partie;
	}
	/**
	 * Sauvegarde la partie actuel.
	 */
	public void sauvegardeLaPartie() {		
		try {
			Partie p = this.partie;
			FileOutputStream fos = new FileOutputStream("Partie.serial");

			// création d'un "flux objet" avec le flux fichier
			ObjectOutputStream oos= new ObjectOutputStream(fos);
			try {
				// sérialisation : écriture de l'objet dans le flux de sortie
				oos.writeObject(p); 
				// on vide le tampon
				oos.flush();
			} finally {
				//fermeture des flux
				try {
					oos.close();
				} finally {
					fos.close();
				}
			}
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	/**
	 * Charge la partie contenu dans la sauvegarde.
	 */
	public void chargeLaPartie() {
		try {
			// ouverture d'un flux d'entrée depuis le fichier "personne.serial"
			FileInputStream fis = new FileInputStream("Partie.serial");
			// création d'un "flux objet" avec le flux fichier
			ObjectInputStream ois= new ObjectInputStream(fis);
			try {	
				// désérialisation : lecture de l'objet depuis le flux d'entrée
				partie = (Partie) ois.readObject(); 
			} finally {
				// on ferme les flux
				try {
					ois.close();
				} finally {
					fis.close();
				}
			}
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}
	/**
	 * Affiche l'écran de victoire.
	 */
	public void finieLaPartie() {
		Pane root = new Pane();
		root.setPrefSize(Main.Largeur, Main.Largeur);
		
		//creer l'affichage de fin de partie
		StackPane cadre = new StackPane();
		cadre.setPrefSize(Main.Largeur,Main.Longueur);
		
		Text texte = new Text("LE JOUEUR " + this.getPartie().gagnant().getCouleur() + " GAGNE LA PARTIE !");
		texte.setFill(Color.WHITE);
		texte.setFont(Font.font(Main.police, FontWeight.SEMI_BOLD,35));
		texte.setLayoutY(150);
		cadre.getChildren().add(texte);
		StackPane.setAlignment(texte,Pos.TOP_CENTER);
		
		BoutonJeu btnRetour = new BoutonJeu("Retour au menu",200,75);
		btnRetour.setOnMousePressed(event -> {
			Main.fenetre.setScene(Main.getSceneMenu());
		});
		cadre.getChildren().add(btnRetour);
		
		root.getChildren().add(cadre);
		
		//creer le background
		Color c1 = Color.web("#737373");
		Color c2 = Color.web("#1a1a1a");
		Stop[] stops = new Stop[] { new Stop(0, c1), new Stop(1, c2)};
		LinearGradient degrade = new LinearGradient(0, 1, 0, 0, true, CycleMethod.NO_CYCLE, stops);
		
		Main.fenetre.setScene(new Scene(root,degrade));
	}
	/**
	 * Remet la partie à zero.
	 */
	public void resetPartie() {
		Joueur j1 = new Joueur(Couleur.ROUGE);
		Joueur j2 = new Joueur(Couleur.NOIR);
		partie = new Partie(this,j1,j2);
		try {
			scene = creerScene();
			Main.fenetre.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
