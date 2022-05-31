package miniprojet.entities;

public class Vendeur extends Salarie {
	private double Vente;
	private double Pourcentage;



	public Vendeur(int matricule, String nom, String email, String cat, double anneeRecr, double salaire,
			double vente, double pourcentage) {
		super(matricule, nom, email, cat, anneeRecr, salaire);
		Vente = vente;
		Pourcentage = pourcentage;
	}

	public double getVente() {
		return Vente;
	}

	public void setVente(double vente) {
		Vente = vente;
	}

	public double getPourcentage() {
		return Pourcentage;
	}

	public void setPourcentage(double pourcentage) {
		Pourcentage = pourcentage;
	}

	@Override
	public String toString() {
		return "Vente=" + Vente + ", Pourcentage=" + Pourcentage + ", Matricule=" + getMatricule()
				+ ", Nom=" + getNom() + ", Email=" + getEmail() + ", AnneeRecr=" + getAnneeRecr()
				+ ", Salaire=" + getSalaire() ;
	}

	
	
}
