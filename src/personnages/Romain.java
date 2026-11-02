package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	
	private boolean isInvariantVerified() {
		return force >= 0;
	}
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified();
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	public void recevoirCoup(int forceCoup) {
		assert forceCoup > 0;
		int forceInitiale = force;
		force = force - forceCoup;
		if (force < 1) {
			force = 0;
			parler("J'abandonne !");
		} else {
			parler("Aïe");
		}
	assert isInvariantVerified();
	assert force < forceInitiale;
	}
	private void equiper(Equipement newEquipement) {
		System.out.println("Le soldat "+this.getNom()+" s'équipe avec un "+newEquipement.toString()+".");
		equipements[nbEquipement] = newEquipement;
		nbEquipement += 1;
	}
	public void sEquiper(Equipement newEquipement) {
		switch (nbEquipement) {
			case 2 :
				System.out.println("Le soldat "+this.getNom()+" est déjà bien protégé !");
				break;
			case 1 :
				if (this.equipements[0] == newEquipement) {
					System.out.println("Le soldat "+this.getNom()+" possède déjà un "+newEquipement.toString()+" !");
				} else {
					equiper(newEquipement);
				}
				break;
			default :
				equiper(newEquipement);
		}
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		for (Equipement equipement : Equipement.values()) {
			System.out.println(equipement);
		}
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		
	}
	
}
