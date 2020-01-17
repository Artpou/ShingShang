package menu;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import Vue.BoutonMenu;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MenuJeu extends Pane {
		
        int pageActuel = 0;
        private String police = Main.police;
        private int Longueur = Main.Longueur;
        private int Largeur = Main.Largeur;
        
        protected Scene scene;

        /**
         * Créer le menu du jeu
         * @throws IOException 
         */
		public MenuJeu(Main app) throws IOException{
					
			//Créer les menus
			VBox menuPrincipal = new VBox(20);
			VBox menuReglage = new VBox(20);
			
			menuPrincipal.setTranslateX(Longueur/4+35);
			menuPrincipal.setTranslateY(Largeur/4+100);
			
			//BOUTONS
			
			//Nouvelle Partie
			BoutonMenu btnNouvellePartie = new BoutonMenu("NOUVELLE PARTIE",300,40);
			btnNouvellePartie.setOnMouseClicked(event -> {
				Main.fenetre.setScene(Main.getSceneJeu());
            });
            
			//Continuer
			BoutonMenu btnContinuer = new BoutonMenu("CONTINUER",300,40);
            
            //Regles       
			Group regles = creerRegles();
			regles.setVisible(false);
            
            BoutonMenu btnRegles = new BoutonMenu("REGLES",300,40);
            BoutonMenu btnRetourRegles = new BoutonMenu("RETOUR AU MENU",300,40);
            btnRetourRegles.setLayoutX(25);
            btnRetourRegles.setLayoutY(Largeur-60);
            btnRetourRegles.setVisible(false);
            
            btnRetourRegles.setOnMouseClicked(event -> {
                menuPrincipal.setVisible(true);
                regles.setVisible(false);
                btnRetourRegles.setVisible(false);
                pageActuel=0;
            });
            
            btnRegles.setOnMouseClicked(event -> {
                menuPrincipal.setVisible(false);
                regles.setVisible(true);
                btnRetourRegles.setVisible(true);
            });
            
            regles.getChildren().add(btnRetourRegles);
            
            //Quitter
            BoutonMenu btnQuitter = new BoutonMenu("QUITTER",300,40);
            btnQuitter.setOnMouseClicked(event -> {
                System.exit(0);
            });
            
            
            menuPrincipal.getChildren().addAll(btnNouvellePartie,btnContinuer,btnRegles,btnQuitter);        
            
            //insere le titre
			StackPane titre = new StackPane();
			
			Rectangle rTitre = new Rectangle(375, 60);
			rTitre.setStroke(Color.WHITE);
			rTitre.setStrokeWidth(4);
			rTitre.setFill(Color.DARKRED);
			
			Text texteTitre = new Text("SHING SHANG");
			texteTitre.setFill(Color.WHITE);
			texteTitre.setFont(Font.font(police, 50));
			
			titre.setAlignment(Pos.CENTER);
			titre.getChildren().addAll(rTitre,texteTitre);
			
			titre.setTranslateX(Longueur/4);
			titre.setTranslateY(50);
			
			//affiche tout
			this.getChildren().addAll(titre,menuPrincipal,menuReglage,regles);
			
			scene = creerScene();
		}
		
	/**
	* Créer les règles relatives au Shing Shang
	* @return root : Group
	*/
	public Group creerRegles() {
		Group root = new Group();
			
		Rectangle r = new Rectangle(Longueur-50,Largeur-250);
		r.setX(25);
		r.setY(150);
		r.setOpacity(0.8);
			
		Text texte1 = new Text(Regles.Page1.toString());		
		Text texte2 = new Text(Regles.Page2.toString());			
		Text texte3 = new Text(Regles.Page3.toString());
		Text texte4 = new Text(Regles.Page4.toString());		

			
		Text[] texte = {texte1,texte2,texte3,texte4};			
		for (int i = 0;i < 4;i++) {
			texte[i].setX(50); 
			texte[i].setY(200);
			texte[i].setFont(Font.font(police, 20));
			texte[i].setFill(Color.WHITE);
			if (i != 0)
				texte[i].setVisible(false);
		}
		
        BoutonMenu btnPrecedent = new BoutonMenu("<",100,40);
        BoutonMenu btnSuivant = new BoutonMenu(">",100,40);
            
        btnPrecedent.setLayoutX(Longueur-250);
        btnPrecedent.setLayoutY(Largeur-60);
            
        btnSuivant.setLayoutX(Longueur-125);
        btnSuivant.setLayoutY(Largeur-60);
            
        btnPrecedent.setVisible(false);
            
        btnPrecedent.setOnMouseClicked(event -> {
            texte[pageActuel].setVisible(false);
            texte[pageActuel-1].setVisible(true);
        	btnSuivant.setVisible(true);
            pageActuel--;
            if (pageActuel == 0)
            	btnPrecedent.setVisible(false);
        });
            
        btnSuivant.setOnMouseClicked(event -> {
            texte[pageActuel].setVisible(false);
            texte[pageActuel+1].setVisible(true);  
        	btnPrecedent.setVisible(true);
            pageActuel++;
            if (pageActuel == texte.length-1)
            	btnSuivant.setVisible(false);
        });
			
        root.getChildren().addAll(r,texte[0],texte[1],texte[2],texte[3],btnSuivant, btnPrecedent);
			return root;
		}
	/**
	 * 
	 * @return la scène du menu du jeu.
	 * @throws IOException
	 */
	public Scene creerScene() throws IOException {
		//créer la fenetre
		Pane root = new Pane();
		root.setPrefSize(Longueur, Largeur);
		
		//créer le background
		InputStream is = Files.newInputStream(Paths.get("ressources/background.jpg"));
		ImageView img = new ImageView(new Image(is));
		img.setFitWidth(Longueur);
		img.setFitHeight(Largeur);
		root.getChildren().add(img);
		
		root.getChildren().add(this);
		Scene scene = new Scene(root);
		
		return scene;
	}
	
}