package personnages;

public class Humain {
	private String nom;
	private String boissonFavorite;
	private int argent;
	
	public Humain(String nom, String boissonFavorite, int argent) {
		super();
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
	
	public void gagnerArgent(int gain) {
		this.argent += gain;
		
	}
	
	public void perdreArgent(int perte) {
		this.argent -= perte;
	}
	
	
	
	
	
	
	
	public void parler(String texte) {
		System.out.println("("+this.getNom()+") - "+texte);
	}
}
