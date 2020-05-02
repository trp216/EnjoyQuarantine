package ui;

import javafx.scene.Scene;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

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


		private Scene scene;

		public void setScene(Scene scene) {
			this.scene = scene;
			
		}
}
