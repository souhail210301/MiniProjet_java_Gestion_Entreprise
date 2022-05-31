package miniprojet.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import miniprojet.connection.connexion;
import miniprojet.entities.Employee;
import miniprojet.entities.Salarie;
import miniprojet.entities.Vendeur;

public class ApplicationService {
	public boolean createEmployee(Employee E) {
		try {
			Statement st = connexion.getConx().createStatement();
			if (E.getAnneeRecr() < 2005)
				E.setSalaire(400);
			else
				E.setSalaire(280);
			String reqSalarie = "insert into salarie values(" + E.getMatricule() + ",'" + E.getNom() + "','"
					+ E.getEmail() + "'," + E.getAnneeRecr() + "," + E.getSalaire() + ",'Employee');";
			if (st.executeUpdate(reqSalarie) == 1) {
				String reqEmployee = "insert into Employee values (" + E.getMatricule() + "," + E.getHSupp() + ","
						+ E.getPHsupp() + ");";
				if (st.executeUpdate(reqEmployee) == 1) {
					return true;
				}
			}
		} catch (SQLException ex) {
			System.out.println("Erreur SQL");
		}
		return false;
	}

	public boolean createVendeur(Vendeur V) {
		try {
			Statement st = connexion.getConx().createStatement();
			if (V.getAnneeRecr() < 2005)
				V.setSalaire(400);
			else
				V.setSalaire(280);
			String reqSalarie = "insert into salarie values(" + V.getMatricule() + ",'" + V.getNom() + "','"
					+ V.getEmail() + "'," + V.getAnneeRecr() + "," + V.getSalaire() + ",'Vendeur');";
			if (st.executeUpdate(reqSalarie) == 1) {
				String reqEmployee = "insert into Vendeur values (" + V.getMatricule() + "," + V.getVente() + ","
						+ V.getPourcentage() + ");";
				if (st.executeUpdate(reqEmployee) == 1) {
					return true;
				}
			}

		} catch (SQLException ex) {
			System.out.println("Erreur SQL" + ex);
		}
		return false;
	}

	public List<Salarie> listerEmployee() {
		List<Salarie> emps = new ArrayList<>();
		try {
			String reqE = "select s.matricule, nom, email, role, anneeRecr, (salaire + HSupp * PHSupp) as salaireTot  from salarie s, employee e where s.matricule = e.Matricule;";
			Statement st = connexion.getConx().createStatement();
			ResultSet resultatE = st.executeQuery(reqE);

			while (resultatE.next()) {
				emps.add(new Salarie(resultatE.getInt(1), resultatE.getString(2), resultatE.getString(3),
						resultatE.getString(4), resultatE.getDouble(5), resultatE.getDouble(6)));
			}
			return emps;

		} catch (SQLException ex) {
			System.out.println("Erreur SQL" + ex);
		}
		return null;
	}

	public List<Salarie> listerVendeur() {
		List<Salarie> vdrs = new ArrayList<>();
		try {
			String reqV = "select s.matricule, nom, email, anneeRecr, (salaire + vente * pourcentage) as salaireTot, role from salarie s, vendeur v where s.matricule = v.Matricule;";
			Statement st = connexion.getConx().createStatement();
			ResultSet resultatE = st.executeQuery(reqV);
			while (resultatE.next()) {
				vdrs.add(new Salarie(resultatE.getInt(1), resultatE.getString(2), resultatE.getString(3),
						resultatE.getString(6), resultatE.getDouble(4), resultatE.getDouble(5)));
			}
			return vdrs;
		} catch (SQLException ex) {
			System.out.println("Erreur SQL" + ex);
		}
		return null;

	}

	public boolean deleteSalarie(int IdEmp) {
		try {
			String req = "delete from salarie where matricule =" + IdEmp;
			Statement st = connexion.getConx().createStatement();
			if (st.executeUpdate(req) == 1) {
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Erreur SQL");
		}
		return false;
	}

}
