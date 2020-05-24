package ui;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.Activity;
import model.EnjoyQuarantine;
import model.HealthTip;
import model.MotivationalQuote;

public class FreeController implements AccountsControllerInterface{

    @FXML
    private MenuItem friends;

    @FXML
    private MenuItem addActivity;

    @FXML
    private MenuItem seeActivity;

    @FXML
    private MenuItem health;

    @FXML
    private MenuItem motquote;
    
    @FXML
    private TextArea textarea;
    
    @FXML
    private Button btadd;

    private Scene scene;
    
    private AccountController ac;

    private EnjoyQuarantine eq;
	
	public void getEQ(EnjoyQuarantine eq) {
		this.eq = eq;
	}
    
    @FXML
    void addActivity(ActionEvent event) {
    	textarea.setEditable(true);
    	btadd.setVisible(true);
    }

    @FXML
    public void getHealthTip(ActionEvent event) {
    	ArrayList<HealthTip> ar = new ArrayList<HealthTip>();
    	eq.getRandomHT(eq.getRootHT(), ar, 0);
    	int random = (int)(Math.random() * ar.size() + 1);
    	textarea.setText(ar.get(random).getText());
    }

    @FXML
    public void getMotivationalQuote(ActionEvent event) {
    	ArrayList<MotivationalQuote> ar = new ArrayList<MotivationalQuote>();
    	eq.getRandomMQ(eq.getRootmq(), ar, 0);
    	int random = (int)(Math.random() * ar.size() + 1);
    	textarea.setText(ar.get(random).getText());
    }

    @FXML
    public void seeActivities(ActionEvent event) {
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
    		 ac.getEQ(eq);
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

	public void setScene(Scene scene) {
		this.scene = scene;
		
	}

	@Override
	public void addActivities(ActionEvent event) {
		eq.addActivity(textarea.getText());
		textarea.setEditable(false);
	}
	
	@FXML
    void initialize() {
		btadd.setVisible(false);
    }

}
