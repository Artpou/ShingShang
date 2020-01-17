package Gestion;

import java.util.LinkedList;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import menu.Jeu;

public class Plateau extends GridPane {	
	
	private Case[][] casePlateau = new Case [10] [10];
	/**
	 *Constructeur de la classe Plateau. 
	 **/
	public Plateau() {
		for (int y = 0;y <= 9;y++){
	        for (int x = 0;x <= 9;x++){
	        	if (Case.estUnPortail(x, y) == Couleur.ROUGE)
	        		casePlateau[x][y] = new Portail(x,y,Couleur.ROUGE);
	        	else if (Case.estUnPortail(x, y) == Couleur.NOIR)
	        		casePlateau[x][y] = new Portail(x,y,Couleur.NOIR);
	        	else if (Case.estDansLePlateau(x, y))
	        		casePlateau[x][y] = new Case(x,y);
	        }
		}
		this.creerAffichage();
	}
	
	private void creerAffichage() {
	    int taille = 10;
	    this.setHgap(5);
	    this.setVgap(5);
	    
	    for (int y = 0; y < taille; y++) {
	        for (int x = 0; x < taille; x++) {
	            if (Case.estDansLePlateau(x, y)) {
	            	this.add(this.getCase(x, y), x, y);
	            }
	        }
	    }
	}
	/**
	 * @param X Le x de la Case souhaitée.
	 * @param Y Le y de la case souhaitée.
	 * @return La Case passée en paramètre. 
	 * **/
	public Case getCase(int x,int y) {
		try {
			if (!Case.estDansLePlateau(x, y))
				throw new Exception("La case sort du plateau");
		} catch (Exception e) {
			System.out.println(e);
		}
		return casePlateau[x][y];
	}
	/**
	 * Permet de retrouver une case à partir du bushi qu'elle contient.
	 * @param bushi Le bushi que l'on souhaite localiser.
	 * @return La case qui contient le bushi passé en paramètre.**/
	public Case getCase(Bushi bushi) {	
		Case caseBushi = null;
		Bushi bushiSelectionne = null;
		
		//Recherche le Bushi sur le plateau
		for (int x = 0;x <= 9;x++) {
			for (int y = 0;y <= 9; y++) {
				if(Case.estDansLePlateau(x, y) && !casePlateau[x][y].estVide()) {
					bushiSelectionne = casePlateau[x][y].getBushi();
					if(bushiSelectionne.equals(bushi))
						caseBushi = casePlateau[x][y];
				}
			}
		}
		
		//Renvoie la case du Bushi ou null si il n'a pas était trouvé
		if (caseBushi == null)
			return null;
		else
			return caseBushi;
	}
	/**
	 * Recherche un déplacement sur le plateau et renvoie sa Case s'il existe.
	 * @param pos Le déplacement recherché.
	 * @return La case correspondant au déplacement.   **/
	public Case getCase(Deplacement pos) {
		Case caseDeplacement = null;
		Deplacement DeplacementSelectionne = null;
		
		//Recherche le Deplacement sur le plateau
		for (int x = 0;x <= 9;x++) {
			for (int y = 0;y <= 9; y++) {
				if(Case.estDansLePlateau(x, y) && casePlateau[x][y].estUnDeplacement()) {
					DeplacementSelectionne = casePlateau[x][y].getDeplacement();
					if(DeplacementSelectionne.getNum() == pos.getNum())
						caseDeplacement = casePlateau[x][y];
				}
			}
		}
		
		//Renvoie la case du Deplacement ou null si il n'a pas était trouvé
		return caseDeplacement;
	}
	/**
	 * Renvoie un déplacement à partir de son numéro si ce dernier existe.
	 * @param num Le num du déplacement en question.
	 * @return Le déplacement correspondant à num ou null si ce dernier n'existe pas. **/
	public Deplacement getDeplacement (int num) {
		Deplacement deplacement = null;
		
		//Recherche le Deplacement sur le plateau
		for (int x = 0;x <= 9;x++) {
			for (int y = 0;y <= 9; y++) {
				if(Case.estDansLePlateau(x, y) && casePlateau[x][y].estUnDeplacement()) {
					if (casePlateau[x][y].getDeplacement().getNum() == num)
						deplacement = casePlateau[x][y].getDeplacement();
				}
			}
		}
		
		//Renvoie la Deplacement ou null si il n'a pas était trouvé
		return deplacement;
	}
	/**
	 *Renvoie la Case voisine de la case passée en paramètre.
	 *@param c La case dont on cherche la case voisine.
	 *@param x La différence entre le point x de la case initiale et celui de la case voisine.
	 *@param y La différence entre le y de la case initiale et celui de la case voisine. **/
	public Case voisine(Case c,int x, int y) {
		try {
			if (x < -1 || x > 1)
				throw new Exception("x doit être entre -1 et 1");
			else if (y < -1 || y > 1)
				throw new Exception("y doit être entre -1 et 1");
		} catch (Exception e) {
			System.out.println(e);
		}
		Case voisine =	casePlateau[c.x+x][c.y+y];		
		return voisine;
	}
	/**
	 * Permet de mettre en place les bushi dans le plateau.
	 * @param armee La liste de bushi a mettre en place sur le plateau.
	 * **/
	public void poseArmee(LinkedList<Bushi> armee) {
		for(int i = 0;i < armee.size();i++){
			if (armee.get(i).getType() == TypeBushi.Dragon) {				
				switch (armee.get(i).getNum()) {
					case 1:
						if (armee.get(i).getCouleur() == Couleur.ROUGE)
							casePlateau[1][0].setBushi(armee.get(i));
						else
							casePlateau[1][9].setBushi(armee.get(i));
						break;
					case 2:
						if (armee.get(i).getCouleur() == Couleur.ROUGE)
							casePlateau[8][0].setBushi(armee.get(i));
						else
							casePlateau[8][9].setBushi(armee.get(i));
						break;
				}
				
			}else if (armee.get(i).getType() == TypeBushi.Lion) {
				switch (armee.get(i).getNum()) {
				case 1:
					if (armee.get(i).getCouleur() == Couleur.ROUGE)
						casePlateau[2][0].setBushi(armee.get(i));
					else
						casePlateau[2][9].setBushi(armee.get(i));
					break;
				case 2:
					if (armee.get(i).getCouleur() == Couleur.ROUGE)
						casePlateau[1][1].setBushi(armee.get(i));
					else
						casePlateau[1][8].setBushi(armee.get(i));
					break;
				case 3:
					if (armee.get(i).getCouleur() == Couleur.ROUGE)
						casePlateau[7][0].setBushi(armee.get(i));
					else
						casePlateau[7][9].setBushi(armee.get(i));
					break;
				case 4:
					if (armee.get(i).getCouleur() == Couleur.ROUGE)
						casePlateau[8][1].setBushi(armee.get(i));
					else
						casePlateau[8][8].setBushi(armee.get(i));
					break;
				}
					
			}else if (armee.get(i).getType() == TypeBushi.Singe) {
				switch (armee.get(i).getNum()) {
				case 1:
					if (armee.get(i).getCouleur() == Couleur.ROUGE)
						casePlateau[3][0].setBushi(armee.get(i));
					else
						casePlateau[3][9].setBushi(armee.get(i));
					break;
				case 2:
					if (armee.get(i).getCouleur() == Couleur.ROUGE)
						casePlateau[2][1].setBushi(armee.get(i));
					else
						casePlateau[2][8].setBushi(armee.get(i));
					break;
				case 3:
					if (armee.get(i).getCouleur() == Couleur.ROUGE)
						casePlateau[1][2].setBushi(armee.get(i));
					else
						casePlateau[1][7].setBushi(armee.get(i));
					break;
				case 4:
					if (armee.get(i).getCouleur() == Couleur.ROUGE)
						casePlateau[6][0].setBushi(armee.get(i));
					else
						casePlateau[6][9].setBushi(armee.get(i));
					break;
				case 5:
					if (armee.get(i).getCouleur() == Couleur.ROUGE)
						casePlateau[7][1].setBushi(armee.get(i));
					else
						casePlateau[7][8].setBushi(armee.get(i));
					break;
				case 6:
					if (armee.get(i).getCouleur() == Couleur.ROUGE)
						casePlateau[8][2].setBushi(armee.get(i));
					else
						casePlateau[8][7].setBushi(armee.get(i));
					break;
			}
		}
	}
}

	
	/**
	 * Permet de tester si le déplacement souhaité est valide et de créer un déplacement si c'est le cas.
	 * @param j Le jeu actuel.
	 * @param piece La pièce que l'on souhaite déplacer.
	 * @param shingshang booléen défini si le déplacement est un shingshang ou non.
	 * 
	  **/
	public void creerDeplacement(Jeu j,Bushi bushi,boolean shingshang) throws Exception {
		Case caseInitial = getCase(bushi);
		Case caseVoisine;
		int nb = 1;
		
		if (caseInitial == null)
			throw new Exception("LE BUSHI EST MORT !");
			
		for(int x = -1;x <= 1;x++) {
			for(int y = -1;y <= 1;y++) {			
				if (Case.estDansLePlateau(caseInitial.x+x, caseInitial.y+y)) {
					caseVoisine = voisine(caseInitial,x,y);
					
					//DEPLACEMENT DRAGON
					if (bushi.getType() == TypeBushi.Dragon) {
						if (!caseVoisine.estVide() && Case.estDansLePlateau(caseVoisine.x+x, caseVoisine.y+y)) {
							if (voisine(caseVoisine,x,y).estVide()) {
								if ((Case.estUnPortail(voisine(caseVoisine,x,y).x, voisine(caseVoisine,x,y).y) != bushi.getCouleur())) {
									voisine(caseVoisine,x,y).setDeplacement(new Deplacement(nb,true));
									if(shingshang && caseVoisine.getBushi().getCouleur() != bushi.getCouleur())
										voisine(caseVoisine,x,y).getDeplacement().mange(caseVoisine.getBushi());
									nb++;
								}
							}
						}
						
					//DEPLACEMENT LION
					}else if (bushi.getType() == TypeBushi.Lion){
						if (caseVoisine.estVide()) {
							if ((Case.estUnPortail(caseVoisine.x,caseVoisine.y) == null)) {
								if (!shingshang) {
									caseVoisine.setDeplacement(new Deplacement(nb,false));
									nb++;
								}
							}
							
						}else if (!caseVoisine.estVide() && Case.estDansLePlateau(caseVoisine.x+x, caseVoisine.y+y)) {
							if ((Case.estUnPortail(voisine(caseVoisine,x,y).x, voisine(caseVoisine,x,y).y) == null)) {
								if (voisine(caseVoisine,x,y).estVide()) {
									if (caseVoisine.getBushi().getType() == TypeBushi.Lion || caseVoisine.getBushi().getType() == TypeBushi.Singe) {
										voisine(caseVoisine,x,y).setDeplacement(new Deplacement(nb,true));
										if(shingshang && caseVoisine.getBushi().getCouleur() != bushi.getCouleur())
											voisine(caseVoisine,x,y).getDeplacement().mange(caseVoisine.getBushi());
										nb++;
									}
								}
							}
						}
						
					//DEPLACEMENT SINGE
					} else if (bushi.getType() == TypeBushi.Singe) {
						if (caseVoisine.estVide()) {
							if (!shingshang) {
								if ((Case.estUnPortail(caseVoisine.x,caseVoisine.y) == null)) {
									caseVoisine.setDeplacement(new Deplacement(nb,false));
									nb++;
								}
								
								if (Case.estDansLePlateau(caseVoisine.x+x, caseVoisine.y+y) && voisine(caseVoisine,x,y).estVide()) {
									if ((Case.estUnPortail(voisine(caseVoisine,x,y).x, voisine(caseVoisine,x,y).y) == null)) {
										voisine(caseVoisine,x,y).setDeplacement(new Deplacement(nb,false));
										nb++;
									}
								}
							}
								
						}else if (!caseVoisine.estVide() && Case.estDansLePlateau(caseVoisine.x+x, caseVoisine.y+y)){
							if ((Case.estUnPortail(voisine(caseVoisine,x,y).x, voisine(caseVoisine,x,y).y) == null)) {
								if (voisine(caseVoisine,x,y).estVide()) {
									if (caseVoisine.getBushi().getType() == TypeBushi.Singe) {
										voisine(caseVoisine,x,y).setDeplacement(new Deplacement(nb,true));
										if(shingshang && caseVoisine.getBushi().getCouleur() != bushi.getCouleur())
											voisine(caseVoisine,x,y).getDeplacement().mange(caseVoisine.getBushi());
										nb++;
									}
								}
							}			
						}
					}
				}
			}
		}
			
		this.creerEcouteurDeplacement(j,bushi, nb);
		
		if(nb == 1)
			throw new Exception("AUCUN DEPLACEMENT POSSIBLE !");
	}
	/**
	 * Creer les écouteurs des déplacements
	 * @param j Le jeu actuel.
	 * @param b Le bushi concerné par le déplacement.
	 * @param nb le numéro du déplacement.
	 */
	private void creerEcouteurDeplacement(Jeu j,Bushi b,int nb) {
		for (int i = 1;i < nb; i++) {
			this.getDeplacement(i).CreerEcouteur(j,b);
		}
	}
	/**
	 * Permet de vider la case de déplacement **/
	public void videDeplacement() {
		for (int x = 0;x <= 9;x++) {
			for (int y = 0;y <= 9; y++) {
				if(Case.estDansLePlateau(x, y) && casePlateau[x][y].estUnDeplacement()) {
					casePlateau[x][y].videDeplacement();
				}
			}
		}
	}
	/**
	 * Permet de déplacer un bushi sur le plateau.
	 * @param bushi Le bushi a déplacer.
	 * @param dep Le déplacement souhaité
	 **/
	public void deplaceBushi(Bushi bushi,Deplacement dep) {
		Case caseInitial = getCase(bushi);
		Case caseSuivante = getCase(dep);
		
		caseSuivante.setBushi(bushi);
		caseInitial.videLaCase();
		
		if (dep.getBushi() != null) {
			Case caseBushiMange = getCase(dep.getBushi());
			caseBushiMange.videLaCase();
		}
	}
}

