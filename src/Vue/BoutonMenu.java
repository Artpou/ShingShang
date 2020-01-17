package Vue;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import menu.Main;

public class BoutonMenu extends StackPane{
	
	private String police = Main.police;

	/**
	 * Créer un Bouton de menu
	 * @param name
	 * @param x
	 * @param y
	 */
	public BoutonMenu(String name,int x,int y) {		
		Color selection = Color.DARKRED;
			
		Rectangle r = new Rectangle(x,y);
		r.setOpacity(0.6);
			
		Text texte = new Text(name);
		texte.setFill(Color.DARKGREY);
		texte.setFont(Font.font(police, FontWeight.SEMI_BOLD,20));
			
		this.getChildren().addAll(r, texte);
			
		this.setOnMouseEntered(event -> {
			r.setFill(selection);
			texte.setFill(Color.WHITE);	
		});
			
		//evenements quand la souris utilise le boutons
		this.setOnMouseExited(event -> {
				r.setFill(Color.BLACK);
				texte.setFill(Color.DARKGREY);
		});
		this.setOnMousePressed(event -> {
			r.setFill(Color.DARKVIOLET);		
		});
			
		this.setOnMouseReleased(event -> {
			r.setFill(selection);
		});
			
	}
		
}