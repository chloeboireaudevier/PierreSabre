package personnages;

public class Ronin extends Humain {
	int honneur = 1;

	public Ronin(String nom, String boissonFavorite, int argent) {
		super(nom, boissonFavorite, argent);
	}
	
	public void donner(Commercant beneficiaire) {
		int don = super.getArgent()/10;
		super.perdreArgent(don);
		super.parler(beneficiaire.getNom()+" prend ces "+don+" sous.");
		beneficiaire.recevoir(don);
		
	}
	
}
