package personnages;

import objets.Equipement;
import village_gaulois.Village;

public class Gaulois {
	private String nom;
	private int effetPotion = 1;
	private Village village;
	private int force;
	private int nbTrophees = 0;
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
		village = null;
	}
	public String getNom() {
		return nom;
	}
	public void setVillage(Village village) {
		this.village = village;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] trophees = romain.recevoirCoup((force / 2) * effetPotion);
		effetPotion--;
		if (effetPotion < 1) {
			effetPotion = 1;
		}
		//for (int i = 0; trophees != null && i < trophees.length; i++, nbTrophees++) {
		//	trophees[nbTrophees] = trophees[i];
		//}
		if (trophees != null) {
			nbTrophees += trophees.length;
		}
	}
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
	}
	
	public void sePresenter() {
		String texte = "Bonjour, je m'appelle ";
		if (village == null) {
			parler(texte+nom+". Je voyage de village en village.");
		} else if (village.getChef() == this) {
			parler(texte+nom+". Je suis le chef du village : "+village.getNom()+".");
		} else {
			parler(texte+nom+". J'habite le village : "+village.getNom()+".");
		}
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);
	}
}
