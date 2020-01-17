package menu;

public enum Regles {
	
	Page1("RÈGLE DU JEU:\r\n" + 
				"\r\n" + 
				" \r\n" + 
				"PREPARATION\r\n" + 
				"\r\n" + 
				"Le jeu se déroule sur un plateau de 84 cases.\r\n" + 
				"Chaque joueur prend les 12 pions de sa couleur, 2 Dragons,4 Lions et 6 Singes.\r\n" + 
				"Chaque joueur possède également 2 portails qui ne peuvent pas être déplacés.\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"DEROULEMENT DU JEU\r\n" + 
				"\r\n" + 
				"Le joueur rouge commence, puis les joueurs jouent à tour de rôle. Lors de son \r\n" + 
				"tour de jeu un joueur doit déplacer l'un de ses pions\r\n" + 
				"(mouvement simple ou saut).")
	
	,Page2("DEPLACEMENT\r\n" + 
				"\r\n" + 
				"Les Singes peuvent\r\n" + 
				"- soit se déplacer de une ou deux cases dans n'importes quelles direction,\r\n" + 
				"  horizontalement, verticalement ou en diagonal mais sans changer de direction\r\n" + 
				"  au cours du tour.\r\n" + 
				"- soit effectuer un ou une série de sauts (voir plus loin)\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"Les Lions peuvent\r\n" + 
				"- soit se déplacer de une case dans n'importes quelles direction,\r\n" + 
				"  horizontalement, verticalement ou en diagonal (Comme le roi aux Echecs).\r\n" + 
				"- soit effectuer un ou une série de sauts (voir plus loin)\r\n" + 
				"\r\n" + 
				"Les Dragons ne peuvent se déplacer qu'en sautant.")
	
	,Page3("SAUTS \r\n" + 
			"\r\n"+
			"- une figurine peut sauter une autre figurine (rouge ou noire) à condition que \r\n" + 
			"la pièce sauter soit de même taille ou de taille inférieure. Un dragons peut\r\n" + 
			"  sauter par dessus un autre dragon, un lions ou un singe. Un Lions peut\r\n" + 
			" sauter par dessus un autre lion ou un singe. Un singe ne peut sauter que par\r\n" + 
			" dessus un autre singe.\r\n" + 
			"- De plus il faut qu'au départ de sont mouvement, la figurine se trouve sur\r\n" + 
			" une case contiguë à une case occupée par une figurine rouge ou noire, elle \r\n" + 
			"peut sauter la pièce, verticalement, horizontalement ou en diagonale, à \r\n" + 
			"condition que la case suivante soit vide (comme aux Dames).\r\n" + 
			"\r\n" + 
			"On peut enchaîner plusieurs sauts au cours d'un même tour. (cet enchaînement\r\n" + 
			" de sauts s'appel un Shing Shang).\r\n" + 
			"Si au cours d'un Shing Shang on saute par dessus une ou plusieurs figurines \r\n" + 
			"adverses, celle-ci sont retiré du plateau. ")
	
	,Page4("FIN DU JEU\r\n" + 
			"\r\n" + 
			"Un joueur gagne la partie lorsqu'il parvient à amener l'un de ses dragons\r\n" + 
			"sur l'un des portails de son adversaire ou qu'il capture les deux dragons\r\n" + 
			"de son adversaire.\r\n" + 
			"\r\n" + 
			"Note: On ne retire pas de figurine adverse pour un saut simple.\r\n" + 
			" \r\n" + 
			"\r\n" + 
			"Note: Il est interdit de terminer un mouvement (saut ou déplacement simple)\r\n" + 
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
