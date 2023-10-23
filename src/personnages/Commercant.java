package personnages;

public class Commercant extends Humain {

	public Commercant(String nom, int argent) {
		super(nom, "thé", argent);
	}
	
	public int seFaireExtorquer() {
		int argentVole = super.getArgent();
		super.perdreArgent(argentVole);
		super.parler("J'ai tout perdu ! Le monde est trop injuste...");
		return argentVole;
	}
	
	public void recevoir(int argent) {
		super.gagnerArgent(argent);
		super.parler(argent+" sous ! Je te remercie généreux donateur !");
		
	}
	

}
