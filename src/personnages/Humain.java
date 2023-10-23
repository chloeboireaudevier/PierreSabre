package personnages;

public class Humain {
	private String nom;
	private String boissonFavorite;
	private int argent;
	
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
	
	
	
	public void parler(String texte) {
		System.out.println("("+this.getNom()+") - "+texte);
	}
}
