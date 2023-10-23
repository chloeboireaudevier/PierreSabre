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
	
	public void provoquer(Yakuza adversaire) {
		int force = this.honneur * 2;
		super.parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand !");
		if ( force >= adversaire.getReputation()) {
			super.parler("Je t'ai eu petit Yakuza!");
			int argentGagne = adversaire.perdre();
			super.gagnerArgent(argentGagne);
			
		} else {
			super.parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse en ont pris un coup.");
			int argentPerdu = super.getArgent();
			super.perdreArgent(argentPerdu);
			adversaire.gagner(argentPerdu);
			
		}
	}
	
}
