package personnages;

public class Yakuza extends Humain{
	private String clan;
	private int reputation = 0;
	
	public Yakuza(String nom, int argent, String boissonFavorite, String clan) {
		super(nom, boissonFavorite, argent);
		this.clan = clan;
	}
	
	public void extorquer(Commercant victime) {
		super.parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		super.parler(victime.getNom()+", si tu tiens à la vie donne moi ta bourse !");
		int argentExtorque = victime.seFaireExtorquer(); 
		this.reputation += 1;
		super.gagnerArgent(argentExtorque);
		super.parler("J'ai piqué les "+argentExtorque+" sous de "+victime.getNom()+", ce qui me fait "+super.getArgent()+" sous dans ma poche. Hi! Hi!");
	}
}