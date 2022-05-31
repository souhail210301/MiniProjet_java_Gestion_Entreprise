package miniprojet;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
public class Main extends Application {
@Override
public void start(Stage primaryStage) throws Exception{
Parent root = FXMLLoader.load(getClass().getResource("interface.fxml"));
primaryStage.setTitle("Gestion Entreprise");
primaryStage.setScene(new Scene(root, 800, 500));
primaryStage.show();
}
public static void main(String[] args) {
	launch(args);
}
}