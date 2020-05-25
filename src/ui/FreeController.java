package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import exceptions.MissingFieldsException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Activity;
import model.EnjoyQuarantine;
import model.HealthTip;
import model.MotivationalQuote;
import model.Reminder;
import thread.ReminderThread;

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
    private MenuItem addreminder;
    
    @FXML
    private TextArea textarea;
    
    @FXML
    private Button btadd;
    
    @FXML
    private Button btaddR;
    
    @FXML
    private Text t1;

    @FXML
    private TextField tfmin;

    @FXML
    private Text t2;

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
    	ar = eq.getRandomHT(eq.getRootHT(), ar, 0);
    	int random = (int)(Math.random() * ar.size() + 1);
    	textarea.setText(ar.get(random).getText());
    }

    @FXML
    public void getMotivationalQuote(ActionEvent event) {
    	ArrayList<MotivationalQuote> ar = new ArrayList<MotivationalQuote>();
    	ar = eq.getRandomMQ(eq.getRootmq(), ar, 0);
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
    		ac = new AccountController();
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
	public void addActivities(ActionEvent event) throws FileNotFoundException {
		eq.addActivity(textarea.getText());
		textarea.setEditable(false);

    	btadd.setVisible(false);
	}
	
	@FXML
	public void addReminder() {
		textarea.setEditable(true);

    	btaddR.setVisible(true);
    	   t1.setVisible(true);

           tfmin.setVisible(true);

           t2.setVisible(true);
	}
	
	@FXML
	public void addReminderB() throws FileNotFoundException, IOException {
		Reminder remind = new Reminder();
		remind.setText(textarea.getText());
		eq.addReminder(remind);
		
           
           try {
           if(tfmin.getText()=="") {
        	  throw new MissingFieldsException();
           }
           else {
        	   textarea.setEditable(false);

        	   btaddR.setVisible(false);
           	   t1.setVisible(false);

               tfmin.setVisible(false);

               t2.setVisible(false);
        	   
        	   ReminderThread rt = new ReminderThread(remind,this,Integer.parseInt(tfmin.getText()));
               rt.start();
           }
           }
           catch(MissingFieldsException m) {
        	   Alert alert = new Alert(AlertType.INFORMATION);
        	   alert.setTitle("Warning");
        	   alert.setHeaderText("Some fields are empty!");
        	   alert.setContentText("You have to specify the time for the reminder");
   		
        	   alert.showAndWait();
           }
           
          
	}
	
	@FXML
    void initialize() {
		try {
			eq = new EnjoyQuarantine();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		btadd.setVisible(false);

    	btaddR.setVisible(false);
    	
        t1.setVisible(false);

        tfmin.setVisible(false);

        t2.setVisible(false);
    }

	public void isTime(boolean already, Reminder r) {
		if(already==true) {
			Alert alert = new Alert(AlertType.INFORMATION);
		    alert.setTitle("Friendly Reminder");
		    alert.setContentText(r.getText());
		
		    alert.showAndWait();
		}
	}

}
