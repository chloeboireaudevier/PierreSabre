package histoire;
import personnages.Humain;
import personnages.Ronin;
import personnages.Commercant;
import personnages.Yakuza;

public class HistoireTP4 {

	public static void main(String[] args) {
		Humain prof = new Humain("Prof", "kombucha",54);
		prof.direBonjour();
		prof.acheter("une boisson", 12);
		prof.boire();
		prof.acheter("un jeu", 2);
		prof.acheter("un kimono", 50);

		System.out.println("\n");
		
		Commercant Marco = new Commercant("Marco",20);
		Marco.direBonjour();
		Marco.seFaireExtorquer();
		Marco.recevoir(15);
		Marco.boire();
		
		System.out.println("\n");
		
		Yakuza yakuLeNoir = new Yakuza("Yaku Le Noir",30,"whisky","Warsong");
		yakuLeNoir.direBonjour();
		yakuLeNoir.extorquer(Marco);
		
		System.out.println("\n");
		Ronin Roro = new Ronin("Roro","shochu",60);
		Roro.direBonjour();
		Roro.donner(Marco);
	}

}
