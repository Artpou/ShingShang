package menu;

public enum Regles {
	
	Page1("R�GLE DU JEU:\r\n" + 
				"\r\n" + 
				"�\r\n" + 
				"PREPARATION\r\n" + 
				"\r\n" + 
				"Le jeu se d�roule sur un plateau de 84 cases.\r\n" + 
				"Chaque joueur prend les 12 pions de sa couleur, 2 Dragons,4 Lions et 6 Singes.\r\n" + 
				"Chaque joueur poss�de �galement 2 portails qui ne peuvent pas �tre d�plac�s.\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"DEROULEMENT DU JEU\r\n" + 
				"\r\n" + 
				"Le joueur rouge commence, puis les joueurs jouent � tour de r�le. Lors de son \r\n" + 
				"tour de jeu un joueur doit d�placer l'un de ses pions\r\n" + 
				"(mouvement simple ou saut).")
	
	,Page2("DEPLACEMENT\r\n" + 
				"\r\n" + 
				"Les Singes peuvent\r\n" + 
				"- soit se d�placer de une ou deux cases dans n'importes quelles direction,\r\n" + 
				"  horizontalement, verticalement ou en diagonal mais sans changer de direction\r\n" + 
				"  au cours du tour.\r\n" + 
				"- soit effectuer un ou une s�rie de sauts (voir plus loin)\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"Les Lions peuvent\r\n" + 
				"- soit se d�placer de une case dans n'importes quelles direction,\r\n" + 
				"  horizontalement, verticalement ou en diagonal (Comme le roi aux Echecs).\r\n" + 
				"- soit effectuer un ou une s�rie de sauts (voir plus loin)\r\n" + 
				"\r\n" + 
				"Les Dragons�ne peuvent se d�placer qu'en sautant.")
	
	,Page3("SAUTS�\r\n" + 
			"\r\n"+
			"- une figurine peut sauter une autre figurine (rouge ou noire) � condition que \r\n" + 
			"la pi�ce sauter soit de m�me taille ou de taille inf�rieure. Un dragons peut\r\n" + 
			"  sauter par dessus un autre dragon, un lions ou un singe. Un Lions peut\r\n" + 
			" sauter par dessus un autre lion ou un singe. Un singe ne peut sauter que par\r\n" + 
			" dessus un autre singe.\r\n" + 
			"- De plus il faut qu'au d�part de sont mouvement, la figurine se trouve sur\r\n" + 
			" une case contigu� � une case occup�e par une figurine rouge ou noire, elle \r\n" + 
			"peut sauter la pi�ce, verticalement, horizontalement ou en diagonale, � \r\n" + 
			"condition que la case suivante soit vide (comme aux Dames).\r\n" + 
			"\r\n" + 
			"On peut encha�ner plusieurs sauts au cours d'un m�me tour. (cet encha�nement\r\n" + 
			" de sauts s'appel un Shing Shang).\r\n" + 
			"Si au cours d'un Shing Shang on saute par dessus une ou plusieurs figurines \r\n" + 
			"adverses, celle-ci sont retir� du plateau.�")
	
	,Page4("FIN DU JEU\r\n" + 
			"\r\n" + 
			"Un joueur gagne la partie lorsqu'il parvient � amener l'un de ses dragons\r\n" + 
			"sur l'un des portails de son adversaire ou qu'il capture les deux dragons\r\n" + 
			"de son adversaire.\r\n" + 
			"\r\n" + 
			"Note:�On ne retire pas de figurine adverse pour un saut simple.\r\n" + 
			"�\r\n" + 
			"\r\n" + 
			"Note:�Il est interdit de terminer un mouvement (saut ou d�placement simple)\r\n" + 
			"sur l'une des 4 cases portail du plateau de jeu, exception faite d'amener\r\n" + 
			"l'un de ses dragons sur l'un des portails de son adversaire,\r\n" + 
			"ce qui termine la partie.");
	
	private String texte;
	
	Regles(String texte) {
		this.texte = texte;
	}
	
	public String toString() {
		return texte;
	}
 }
