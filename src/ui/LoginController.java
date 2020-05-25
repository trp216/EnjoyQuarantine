package ui;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.sound.sampled.AudioSystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import model.EnjoyQuarantine;
import thread.MusicThread;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txfuser;

    @FXML
    private PasswordField pfpass;

    @FXML
    private Button btcancel;

    @FXML
    private Button btsignin;
    
    @FXML
    private RadioButton free;

    @FXML
    private ToggleGroup accountype;

    @FXML
    private RadioButton premium;
    
    private Scene scene;
    
    private RegisterController rc;
    
    private FreeController fc;
    
    private PremiumController pc;
    
    private EnjoyQuarantine enjoyquarantine;

    public LoginController(EnjoyQuarantine enjoyquarantine) {
		this.enjoyquarantine = enjoyquarantine;
	}
    
    @FXML
    public void signUp(MouseEvent event){
    	try {
    		rc = new RegisterController();
    		rc.getEQ(enjoyquarantine);
    		rc.getFP(fc, pc);
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Register.fxml"));
			Parent root = fxmlLoader.load();
			Stage stage = new Stage();
			Scene scene = new Scene(root);
			rc = fxmlLoader.getController();
			rc.setScene(scene);
			stage.setScene(scene);
			stage.show();
    	}
    	catch(IOException io) {
    		io.printStackTrace();
    	}
		
    }
    
    @FXML
    public void signIn(ActionEvent event) {
    	if(free.isSelected()) {
    		try {
    			fc = new FreeController();
    			fc.getEQ(enjoyquarantine);
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
    	else if(premium.isSelected()) {
    		try {
    			pc = new PremiumController();
    			pc.getEQ(enjoyquarantine);
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
    
    public void testPlay() {
		try {
			MusicThread sound = new MusicThread(
					AudioSystem.getAudioInputStream(new BufferedInputStream(getClass()
							.getResourceAsStream("mix.wav"))));
			sound.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    @FXML
    private void closeButtonAction(ActionEvent event){
        // get a handle to the stage
        Stage stage = (Stage) btcancel.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

	@FXML
    void initialize() {
		testPlay();
    }
}
