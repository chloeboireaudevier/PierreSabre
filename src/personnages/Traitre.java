package personnages;
import java.util.Random;

public class Traitre extends Samourai{
	private int niveauTraitrise = 0;

	public Traitre(String nom, String boissonFavorite, int argent, String seigneur) {
		super(nom, boissonFavorite, argent, seigneur);
	}

	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mais je suis un traître et mon niveau de traîtrise est : "+this.niveauTraitrise+". Chut !");
	}
	
	public Commercant ranconner(Commercant victime) {
		if (this.niveauTraitrise < 3) {
			int argentCommercant = victime.getArgent();
			int argentRanconner = argentCommercant*2/10;
			victime.perdreArgent(argentRanconner);
			this.gagnerArgent(argentRanconner);
			niveauTraitrise++;
			parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer ! Donne-moi "+argentRanconner+" sous ou gare a toi !");
			victime.parler("Tout de suite grand "+this.getNom()+".");
		}else {
			parler("Mince je ne peux plus rançonner sinon un samouraï risque de me démasquer !");
		}
		return victime;
	}
	
	public void faireLeGentil() {
		if (nbConnaissance < 1) {
			parler("Je ne peux faire ami-ami avec personne car je ne connais personne ! Snif.");
		} else {
			int don = this.getArgent() *1/20;
			Random random = new Random();
			int numAmi = random.nextInt(this.nbConnaissance-1);
			String nomAmi = this.memoire[numAmi].getNom();
			parler("Il faut absolument remonter ma côte de confiance. Je vais faire ami-ami avec "+nomAmi+".");
			parler("Bonjour l'ami ! Je voudrais vous aider en vous donnant "+don+" sous.");
			this.memoire[numAmi].gagnerArgent(don);
			this.perdreArgent(don);
			this.memoire[numAmi].parler("Merci "+this.getNom()+". Vous êtes quelqu'un de bien.");
			if (this.niveauTraitrise > 1) {
				this.niveauTraitrise--;
			}
		}
	}
}
