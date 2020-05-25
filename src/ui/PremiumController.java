package ui;

import javafx.scene.Parent;

import javafx.scene.Scene;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.Activity;
import model.EnjoyQuarantine;
import model.HealthTip;
import model.MotivationalQuote;

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
    private MenuItem seeclock;
    
    @FXML
    private MenuItem stopclock;
    
    @FXML
    private TextArea textarea;
    
    @FXML
    private Button btadd;
    
    @FXML
    private Label label;
    
    private EnjoyQuarantine eq;
    
    private boolean clock;
	
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
	public void addActivities(ActionEvent event) throws FileNotFoundException {
		eq.addActivity(textarea.getText());
		textarea.setEditable(false);
	}
	
	@FXML
    void initialize() {
		btadd.setVisible(false);
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
    
    @FXML
     public void clock() {
    	clock = true;
    	 Thread threadclock = new Thread() {
    		 
    		  Calendar calendar = Calendar.getInstance();
    		 int horas = calendar.get(Calendar.HOUR_OF_DAY);
    		 int minutos = calendar.get(Calendar.MINUTE); ; 
 	        int segundos = calendar.get(Calendar.SECOND); 
 	        int milesimas = calendar.get(Calendar.MILLISECOND);
    		 
    		 public String getClock() {
     			String text = "";
     	        //min es minutos, seg es segundos y mil es milesimas de segundo
     			String hor="";
     	        String min=""; 
     	        String seg=""; 
     	        String mil="";
     	        
                 //Incrementamos 1 milesimas de segundo
                 milesimas++;

                 //Cuando llega a 1000 osea 1 segundo aumenta 1 segundo
                 //y las milesimas de segundo de nuevo a 0
                 if( milesimas == 1000 ){
                     milesimas = 0;
                     segundos += 1;
                     //Si los segundos llegan a 60 entonces aumenta 1 los minutos
                     //y los segundos vuelven a 0
                     if( segundos == 60 ) {
                         segundos = 0;
                         minutos++;
                         if(minutos==60) {
                        	 minutos = 0;
                        	 horas++;
                         }
                     }
                     
                 }

                 //Esto solamente es estetica para que siempre este en formato
                 //00:00:000
                 hor = horas + "";
                 if( minutos < 10 ) {
                 	min = "0" + minutos;
                 }
                 else {
                 	min = minutos+"";
                 }
                 if( segundos < 10 ) {
                 	seg = "0" + segundos;
                 }
                 else {
                 	seg = segundos+"";
                 }

                 if( milesimas < 10 ) {
                 	mil = "00" + milesimas;
                 }
                 else if( milesimas < 100 ) {
                 	mil = "0" + milesimas;
                 }
                 else {
                 	mil = milesimas+"";
                 }
                 //colocar todo lo anterior en el hilo thread

                 //Colocamos en la etiqueta la informacion
                 text = hor + ":" + min + ":" + seg + ":" + mil;
     	        //Cuando se reincie se coloca nuevamente en 00:00:000
     	       //text = "00:00:00";
     	       return text;
     		}
    		 
    		 public void run() {
     			while( clock == true ){
 	    			String text = getClock();
 	    			
 	    			Platform.runLater(new Thread() {
 	    				public void run() {
 	    				 setTextC(text);
 	    				}
 	    			});
 	    			
 	                try {
 						Thread.sleep( 1 );
 					} catch (InterruptedException e) {
 						e.printStackTrace();
 					}   			
     			}    	       
     		}
    	 };
    	 threadclock.setDaemon(true);
    	 threadclock.start();
     }
    
    public void setTextC(String value) {
    	label.setText(value);
    }
    
    @FXML
    public void stopClock() {
    	clock = false;
    }
}
