package personnages;

public class Humain {
	private final int nb_connaissances_max = 30;
	private String nom;
	private String boissonFavorite;
	private int argent;
	protected int nbConnaissance = 0;
	protected Humain[] memoire = new Humain[nb_connaissances_max];
	
	public Humain(String nom, String boissonFavorite, int argent) {
		this.nom = nom;
		this.boissonFavorite = boissonFavorite;
		this.argent = argent;
	}

	public String getNom() {
		return nom;
	}

	public int getArgent() {
		return argent;
	}
	
	protected void gagnerArgent(int gain) {
		this.argent += gain;
		
	}
	
	protected void perdreArgent(int perte) {
		this.argent -= perte;
	}
	
	public void direBonjour() {
		parler("Bonjour ! Je m'appelle "+this.nom+" et j'aime boire du "+this.boissonFavorite+" .");
		
	}
	
	public void boire() {
		parler("Mmmm, un bon verre de "+this.boissonFavorite+" ! GLOUPS !");
		
	}
	
	public void acheter(String bien, int prix) {
		if (this.argent >= prix) {
			parler("J'ai "+this.argent+" sous en poche. Je vais pouvoir m'offrir "+bien+" à "+prix+" sous");
			this.argent -= prix;
		}else {
			parler("Je n'ai plus que "+this.argent+" sous en poche. Je ne peux même pas m'offrir "+bien+" à "+prix+" sous");
		}
		
	}
	
	protected void parler(String texte) {
		System.out.println("("+this.getNom()+") - "+texte);
	}
	
	public Humain faireConnaissanceAvec(Humain rencontre) {
		this.direBonjour();
		rencontre.repondre(this);
		memoriser(rencontre);
		return rencontre;
	}
	
	protected Humain memoriser(Humain rencontre) {
		if (this.nbConnaissance < nb_connaissances_max) {
		this.memoire[this.nbConnaissance] = rencontre;
		this.nbConnaissance +=1;
		}else {
			for (int i = 1 ; i < nb_connaissances_max ; i++) {
				this.memoire[i-1] = this.memoire[i];
			}
			this.memoire[nb_connaissances_max-1] = rencontre;
		}
		return rencontre;
	}
	
	private Humain repondre(Humain rencontre) {
		this.direBonjour();
		memoriser(rencontre);
		return rencontre;
	}
	
	public void listerConnaissance() {
		if (this.nbConnaissance == 0) {
			this.parler("Je ne connais personne");
		} else {
			String chaine = "Je connais beaucoup de monde dont : ";
			for (int i = 0; i< this.nbConnaissance; i++) {
				chaine += this.memoire[i].getNom();
				if ( i != this.nbConnaissance - 1) {
					chaine +=",";
				}
				chaine += " ";
			}
			parler(chaine);
		}
	}
}
