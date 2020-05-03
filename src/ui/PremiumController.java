package ui;

import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class PremiumController implements AccountsControllerInterface{
	
	private Scene  scene;
	
	private AccountController ac;

	@FXML
    private MenuItem friends;

    @FXML
    private MenuItem seeActivity;

    @FXML
    private MenuItem addActivity;

    @FXML
    private MenuItem motquote;

    @FXML
    private MenuItem health;
    
	public void setScene(Scene scene) {
		this.scene = scene;
	}

    @FXML
    public void addActivities(ActionEvent event) {

    }

    @FXML
    public void getHealthTip(ActionEvent event) {

    }

    @FXML
    public void getMotivationalQuote(ActionEvent event) {

    }

    @FXML
   public  void seeActivities(ActionEvent event) {

    }

    @FXML
    public void seeOtherAccounts(ActionEvent event) {
    	 try {
  			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Accounts.fxml"));
  			Parent root = fxmlLoader.load();
  			Stage stage = new Stage();
  			Scene scene = new Scene(root);
  			ac = fxmlLoader.getController();
  			ac.setScene(scene);
  			stage.setScene(scene);
  			stage.show();
      }
      catch(IOException io) {
      	io.printStackTrace();
      }
    }
}
