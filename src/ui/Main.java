package ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.EnjoyQuarantine;

public class Main extends Application {
	
	//Note: because github can't store files larger than 100MB you will have to download the .wav file 
	//of this google drive: https://drive.google.com/drive/folders/1EfM0HRBTk68ZoS6PQ3zeq26TMqlPDrCh?usp=sharing
	//and paste it into ui folder.
	//Thanks
	
	private LoginController lc;
	private EnjoyQuarantine enjoyquarantine;
	
	public Main() throws IOException, ClassNotFoundException {
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