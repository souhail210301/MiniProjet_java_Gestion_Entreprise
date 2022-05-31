package miniprojet.entities;

public class Salarie {
	private int Matricule;
	private String Nom;
	private String Email;
	private String Cat;
	private double AnneeRecr;
	private double Salaire;
	
	public Salarie(int matricule, String nom, String email, String cat, double anneeRecr, double salaire) {
		super();
		Matricule = matricule;
		Nom = nom;
		Email = email;
		Cat = cat;
		AnneeRecr = anneeRecr;
		Salaire = salaire;
	}

	public String getCat() {
		return Cat;
	}

	public void setCat(String cat) {
		Cat = cat;
	}



	public int getMatricule() {
		return Matricule;
	}

	public void setMatricule(int matricule) {
		Matricule = matricule;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public double getAnneeRecr() {
		return AnneeRecr;
	}

	public void setAnneeRecr(double anneeRecr) {
		AnneeRecr = anneeRecr;
	}

	public double getSalaire() {
		return Salaire;
	}

	public void setSalaire(double salaire) {
		Salaire = salaire;
	}

	@Override
	public String toString() {
		return "Salarie [Matricule=" + Matricule + ", Nom=" + Nom + ", Email=" + Email + ", Cat=" + Cat
				+ ", AnneeRecr=" + AnneeRecr + ", Salaire=" + Salaire + "]";
	}



}