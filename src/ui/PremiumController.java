package ui;

import javafx.scene.Parent;

import javafx.scene.Scene;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.Activity;
import model.EnjoyQuarantine;

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
    
    @FXML
    private TextArea textarea;
    
    @FXML
    private Button btadd;
    
    private EnjoyQuarantine eq;
	
	public void getEQ(EnjoyQuarantine eq) {
		this.eq = eq;
	}
    
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	@FXML
    void addActivity(ActionEvent event) {
    	textarea.setEditable(true);
    	btadd.setVisible(true);
    }

	@Override
	public void addActivities(ActionEvent event) {
		eq.addActivity(textarea.getText());
	}
	
	@FXML
    void initialize() {
		btadd.setVisible(false);
    }
    @FXML
    public void getHealthTip(ActionEvent event) {

    }

    @FXML
    public void getMotivationalQuote(ActionEvent event) {

    }

    @FXML
   public  void seeActivities(ActionEvent event) {
    	Activity aux = eq.getActivities();
    	String text = "";
    	if(aux!=null) {
    		while(aux.getNext()!=null) {
    			text += aux.getText()+"\n";
    			aux = aux.getNext();
    		}
    	}
    	else {
    		text = "No activities added yet";
    	}
    	textarea.setText(text);
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
