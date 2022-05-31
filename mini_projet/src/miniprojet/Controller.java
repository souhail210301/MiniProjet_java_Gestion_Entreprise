package miniprojet;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import miniprojet.entities.Employee;
import miniprojet.entities.Salarie;
import miniprojet.entities.Vendeur;
import miniprojet.service.ApplicationService;

public class Controller implements Initializable {

	@FXML
	private RadioButton rbEmployee;
	@FXML
	private RadioButton rbVendeur;
	@FXML
	private TextField tfMatricule;
	@FXML
	private TextField tfNom;
	@FXML
	private TextField tfEmail;
	@FXML
	private TextField tfAnneRecruit;
	@FXML
	private TextField tfVente_Heurs;
	@FXML
	private TextField tfTaux_Pourcentage;
	@FXML
	private TextField tfSalaire;

	@FXML
	private Button addBtn;
	@FXML
	private Button deleteBtn;
	@FXML
	private Button editBtn;
	@FXML
	private Button exportBtn;
	@FXML
	private Button catBtn;
	
	@FXML
	private TableView<Salarie> table;
	@FXML
	private TableColumn<Salarie, Integer> matriculeCol;
	@FXML
	private TableColumn<Salarie, String> nameCol;
	@FXML
	private TableColumn<Salarie, String> emailCol;
	@FXML
	private TableColumn<Salarie, String> catCol;
	@FXML
	private TableColumn<Salarie, Double> salaireCol;
	
	

	public void AddSalarie() {
		if (rbEmployee.isSelected()) {
			Employee emp = new Employee(Integer.parseInt(tfMatricule.getText()), tfNom.getText(), tfEmail.getText(),
					"E", Double.parseDouble(tfAnneRecruit.getText()), 0.1, Double.parseDouble(tfVente_Heurs.getText()),
					Double.parseDouble(tfTaux_Pourcentage.getText()));
			ApplicationService AS = new ApplicationService();
			boolean result = AS.createEmployee(emp);
		} else if (rbVendeur.isSelected()) {
			Vendeur vdr = new Vendeur(Integer.parseInt(tfMatricule.getText()), tfNom.getText(), tfEmail.getText(), "E",
					Double.parseDouble(tfAnneRecruit.getText()), 0.1, Double.parseDouble(tfVente_Heurs.getText()),
					Double.parseDouble(tfTaux_Pourcentage.getText()));
			System.out.println(vdr.toString());
			ApplicationService AS = new ApplicationService();
			boolean result = AS.createVendeur(vdr);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		matriculeCol.setCellValueFactory(new PropertyValueFactory<>("Matricule"));
		nameCol.setCellValueFactory(new PropertyValueFactory<>("Nom"));
		emailCol.setCellValueFactory(new PropertyValueFactory<>("Email"));
		catCol.setCellValueFactory(new PropertyValueFactory<>("Cat"));
		salaireCol.setCellValueFactory(new PropertyValueFactory<>("Salaire"));
		
		
	}
	
	public void lister() {
		ApplicationService AS = new ApplicationService();
		table.getItems().addAll(AS.listerEmployee());
		table.getItems().addAll(AS.listerVendeur());
	}

	
	
	public void deleteSalarie() {
		ApplicationService AS = new ApplicationService();

		AS.deleteSalarie(table.getSelectionModel().getSelectedItem().getMatricule());
		table.getItems().remove(table.getSelectionModel().getSelectedItem());
	}
}
