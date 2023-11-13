package personnages;

public class Yakuza extends Humain{
	private String clan;
	private int reputation = 4;
	
	public Yakuza(String nom, int argent, String boissonFavorite, String clan) {
		super(nom, boissonFavorite, argent);
		this.clan = clan;
	}
	
	public int getReputation() {
		return reputation;
	}

	public void extorquer(Commercant victime) {
		super.parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		super.parler(victime.getNom()+", si tu tiens à la vie donne moi ta bourse !");
		int argentExtorque = victime.seFaireExtorquer(); 
		this.reputation += 1;
		super.gagnerArgent(argentExtorque);
		super.parler("J'ai piqué les "+argentExtorque+" sous de "+victime.getNom()+", ce qui me fait "+super.getArgent()+" sous dans ma poche. Hi! Hi!");
	}
	
	protected int perdre() {
		int argentPerdu = super.getArgent();
		super.perdreArgent(argentPerdu);
		this.reputation -= 1;
		super.parler("J'ai perdu mon duel et mes "+argentPerdu+" sous, snif... J'ai déshonoré le clan de "+this.clan+".");
		return argentPerdu;
	}
	
	protected void gagner(int gain) {
		super.gagnerArgent(gain);
		this.reputation+=1;
		super.parler("Ce ronin pensait vraiment battre "+super.getNom()+" du clan de "+this.clan+" ? Je l'ai dépouillé de ses "+gain+" sous.");
	}
}
