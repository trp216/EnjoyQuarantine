package ui;

import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.time.LocalDate;

import exceptions.DifferentPasswordException;
import exceptions.MissingFieldsException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.EnjoyQuarantine;

	public class RegisterController {

	    @FXML
	    private TextField txfname;

	    @FXML
	    private Button btregister;

	    @FXML
	    private TextField txfuser;

	    @FXML
	    private PasswordField pwfpass;

	    @FXML
	    private PasswordField pwfcp;

	    @FXML
	    private TextField tfweight;

	    @FXML
	    private TextField tfheight;

	    @FXML
	    private RadioButton womangender;

	    @FXML
	    private ToggleGroup gender;

	    @FXML
	    private RadioButton mangender;

	    @FXML
	    private RadioButton othergender;

	    @FXML
	    private DatePicker brithdate;

	    @FXML
	    private RadioButton premiumacc;

	    @FXML
	    private ToggleGroup typeofaccount;

	    @FXML
	    private RadioButton freeacc;

	    @FXML
	    private CheckBox terms;

	    private FreeController fc;
	    
	    private PremiumController pc;

		private Scene scene;
		
		private EnjoyQuarantine eq;
		
		public void getEQ(EnjoyQuarantine eq) {
			this.eq = eq;
		}

		public void setScene(Scene scene) {
			this.scene = scene;
			
		}
		
		public void getFP(FreeController fc, PremiumController pc) {
			this.fc = fc;
			this.pc = pc;
		}
		
		@FXML
		public void register(ActionEvent event) {
			
			String name = txfname.getText();
			String username = txfuser.getText();
			String password = pwfpass.getText();
			String confirmpass = pwfcp.getText();
			
			String gen = "";
			
			boolean isPremium = false;
			
			String h = tfheight.getText();
			String w = tfweight.getText();
			
			
			try {
				if(name.equals("") || username.equals("") || password.equals("") || confirmpass.equals("") || 
						(mangender.isSelected()==false && womangender.isSelected()==false && othergender.isSelected()==false) 
						|| (freeacc.isSelected()==false && premiumacc.isSelected()==false) || brithdate.getValue()==null
						|| h.equals("")|| w.equals("")) {
					throw new MissingFieldsException();
				}
				else {
					name = txfname.getText();
					username = txfuser.getText();
					password = pwfpass.getText();
					confirmpass = pwfcp.getText();
					
					String birthdate = brithdate.getValue()+"";
					
					
					if(mangender.isSelected()==true) {
						gen = "Man";
					}
					else if(womangender.isSelected()==true) {
						gen = "Woman";
					}
					else if(othergender.isSelected()==true) {
						gen = "Other";
					}
					
					
					else if(freeacc.isSelected()==true) {
						isPremium = false;
					}
					else if(premiumacc.isSelected()==true) {
						isPremium = true;
					}
					
					double height = Double.parseDouble(h);
					double weight = Double.parseDouble(w);
					
					try {
						if(!password.equals(confirmpass)) {
							throw new DifferentPasswordException();
						}
						else {
							if(terms.isSelected()==false) {
								Alert alert = new Alert(AlertType.INFORMATION);
							    alert.setTitle("Warning filling the registration");
							    alert.setHeaderText("You haven't accepted the terms and conditions");
							    alert.setContentText("You can't register unless you accept the terms and conditions.");
							
							    alert.showAndWait();
							}
							
							eq.addAccount(username, name, password, birthdate, gen, height, weight, isPremium);
							
							if(freeacc.isSelected()==true) {
								registerAsFree();
							}
							else if(premiumacc.isSelected()==true) {
								registerAsPremium();
							}
						}
					}
					catch(DifferentPasswordException e){
						 Alert alert = new Alert(AlertType.INFORMATION);
			    		    alert.setTitle("Error");
			    		    alert.setHeaderText("Error");
			    		    alert.setContentText(e.getMessage());
			    		    alert.showAndWait();
					}
					
					
				}
			}
			catch(MissingFieldsException m) {
				warning(event);
			}
			
		}
		
		
		@FXML
		public void warning(ActionEvent event) {
			Alert alert = new Alert(AlertType.INFORMATION);
		    alert.setTitle("Warning filling the registration");
		    alert.setHeaderText("Some fields are empty!");
		    alert.setContentText("This is a friendly reminder for you to fill all fields :D");
		
		    alert.showAndWait();
		}
		
		public void registerAsFree() {
			try {
				fc.getEQ(eq);
    			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Free.fxml"));
    			Parent root = fxmlLoader.load();
    			Stage stage = new Stage();
    			Scene scene = new Scene(root);
    			fc = fxmlLoader.getController();
    			fc.setScene(scene);
    			stage.setScene(scene);
    			stage.show();
    		}
    		catch(IOException io) {
    			io.printStackTrace();
    		}
		}
		
		public void registerAsPremium() {
			try {
				pc.getEQ(eq);
    			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Premium.fxml"));
    			Parent root = fxmlLoader.load();
    			Stage stage = new Stage();
    			Scene scene = new Scene(root);
    			pc = fxmlLoader.getController();
    			pc.setScene(scene);
    			stage.setScene(scene);
    			stage.show();
    		}
    		catch(IOException io) {
    			io.printStackTrace();
    		}
		}
}
