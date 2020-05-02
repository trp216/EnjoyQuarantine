package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.EnjoyQuarantine;

public class Main extends Application {
	
	private LoginController lc;
	private EnjoyQuarantine enjoyquarantine;
	
	public Main() {
		enjoyquarantine = new EnjoyQuarantine();
		lc = new LoginController(enjoyquarantine);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		Main main = new Main();
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
		
		fxmlLoader.setController(lc);
		
		Parent root = fxmlLoader.load();
		
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}