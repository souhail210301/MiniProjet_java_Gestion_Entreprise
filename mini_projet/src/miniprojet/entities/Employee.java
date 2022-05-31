package miniprojet.entities;

public class Employee extends Salarie {
	private double HSupp;
	private double PHsupp;
	
	
	

	public Employee(int matricule, String nom, String email, String cat, double anneRecruit, double salaire,
			double hSupp, double pHsupp) {
		super(matricule, nom, email, cat, anneRecruit, salaire);
		HSupp = hSupp;
		PHsupp = pHsupp;
	}



	@Override
	public String toString() {
		return "HSupp=" + HSupp + ", PHsupp=" + PHsupp + ", Cat=" + getCat() + ", Matricule="
				+ getMatricule() + ", Nom=" + getNom() + ", Email=" + getEmail() + ", AnneeRecr="
				+ getAnneeRecr() + ", Salaire=" + getSalaire() ;
	}



	public double getHSupp() {
		return HSupp;
	}

	public void setHSupp(double hSupp) {
		HSupp = hSupp;
	}

	public double getPHsupp() {
		return PHsupp;
	}

	public void setPHsupp(double pHsupp) {
		PHsupp = pHsupp;
	}
	
	
	
}
