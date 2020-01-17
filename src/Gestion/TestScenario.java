package Gestion;

public class TestScenario {
	private Plateau p;
	
	public TestScenario(Plateau p) {
		this.p = p;
	}
	
	public void changeScenario(int i) {
		if (i == 1) {
			Deplacement tmp = new Deplacement(1,false);
			p.getCase(4, 2).setDeplacement(tmp);
			p.deplaceBushi(p.getCase(1, 0).getBushi(), tmp);
			p.getCase(4,2).videDeplacement();
			p.getCase(4, 3).setDeplacement(tmp);
			p.deplaceBushi(p.getCase(1, 9).getBushi(),tmp);
		} else if (i == 2) {
			Deplacement tmp = new Deplacement(1,false);
			
			p.getCase(2, 3).setDeplacement(tmp);
			p.deplaceBushi(p.getCase(1, 7).getBushi(), tmp);
			p.getCase(2,3).videDeplacement();
			
			p.getCase(1, 4).setDeplacement(tmp);
			p.deplaceBushi(p.getCase(8, 7).getBushi(), tmp);
			p.getCase(1, 4).videDeplacement();
		} else if (i == 3) {
			Deplacement tmp = new Deplacement(1,false);
			
			p.getCase(2, 5).setDeplacement(tmp);
			p.deplaceBushi(p.getCase(1, 0).getBushi(), tmp);
			p.getCase(2,5).videDeplacement();
			
			p.getCase(3, 5).setDeplacement(tmp);
			p.deplaceBushi(p.getCase(1, 8).getBushi(), tmp);
			p.getCase(3,5).videDeplacement();
			
			p.getCase(5, 5).setDeplacement(tmp);
			p.deplaceBushi(p.getCase(1, 9).getBushi(), tmp);
			p.getCase(5, 5).videDeplacement();
			
			p.getCase(7, 5).setDeplacement(tmp);
			p.deplaceBushi(p.getCase(8, 9).getBushi(), tmp);
			p.getCase(7, 5).videDeplacement();
		}
	}
}
