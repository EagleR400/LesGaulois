package personnages;

import objets.Chaudron;

public class Druide {
	private String nom;
	private int force;
	private Chaudron chaudron = new Chaudron(0, 1);
	
	public String getNom() {
		return "Le druide " + nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	public void fabriquerPotion(int quantite, int forcePotion) {
		chaudron.remplirChaudron(quantite, forcePotion);
		parler("J'ai concocté "+quantite+" doses de potion magique. Elle a une force de "+forcePotion+".");
	}
	public void booster(Gaulois gaulois) {
		
	}
	
}
