package personnages;
import java.util.Random;


public class GrandMere extends Humain{
	private enum TypeHumain {
		habitant,
		ronin,
		commercant,
		samourai,
		yakuza
	}

	public GrandMere(String nom, int argent) {
		super(nom, "tisane", argent);
	}
	
	@Override
	protected Humain memoriser(Humain rencontre) {
		if (this.nbConnaissance == 5) {
			this.parler("Oh ma tête ! Je ne peux plus retenir le nom d'une personne supplémentaire !");
		} else {
			super.memoriser(rencontre);
		}
		return rencontre;
	}
	
	private TypeHumain humainHasard() {
		Random random = new Random();
		TypeHumain[] types = TypeHumain.values();
		int randomInt = random.nextInt(4);
		return types[randomInt];
	}
	
	public void ragoter() {
		for (int i = 0; i < this.nbConnaissance; i ++) {
			if (this.memoire[i] instanceof Traitre) {
				parler("Je sais que "+this.memoire[i].getNom()+" est un traître. Petit chenapan !");
			} else {
				parler("Je crois que "+this.memoire[i].getNom()+" est un "+humainHasard());
			}
		}
	}
	
}
