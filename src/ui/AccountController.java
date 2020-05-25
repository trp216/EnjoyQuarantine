package ui;

import javafx.scene.Scene;

import java.io.IOException;

import exceptions.MissingFieldsException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Account;
import model.EnjoyQuarantine;

public class AccountController {

    @FXML
    private TableView<Account> table;

    @FXML
    private TableColumn<Account, String> column1;

    @FXML
    private TableColumn<Account, String> column2;

    @FXML
    private TableColumn<Account, String> column3;

    @FXML
    private TableColumn<Account, String> column4;

    @FXML
    private TableColumn<Account, String> column5;

    @FXML
    private TableColumn<Account, Double> column6;

    @FXML
    private TableColumn<Account, Double> column7;

    @FXML
    private ChoiceBox<String> choicebox;
    
    @FXML
    private Button go;
	
	private Scene scene;
	
	private EnjoyQuarantine eq;

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public void getEQ(EnjoyQuarantine eq) {
		this.eq = eq;
	}
	
	 private void initializeTableView() {
		    
	    	ObservableList<Account> observableList = FXCollections.observableArrayList(eq.getAccounts());
	    	table.setItems(observableList);
	    	
	    	column1.setCellValueFactory(new PropertyValueFactory<Account,String>("username")); 
	    	column2.setCellValueFactory(new PropertyValueFactory<Account,String>("name"));
	    	column3.setCellValueFactory(new PropertyValueFactory<Account,String>("password"));
	    	column4.setCellValueFactory(new PropertyValueFactory<Account,String>("birthdate"));
	     	column5.setCellValueFactory(new PropertyValueFactory<Account,String>("gender"));
	     	column6.setCellValueFactory(new PropertyValueFactory<Account,Double>("height"));
	     	column7.setCellValueFactory(new PropertyValueFactory<Account,Double>("weight"));
	    }
	
	@FXML
	public void go(ActionEvent event) throws IOException {
		try {
			if(choicebox.getValue().equals("")) {
				throw new MissingFieldsException();
			}
			else {
				if(choicebox.getValue().equals("Bubble Sort: Name")) {
					eq.bubbleSortN();
				}
				else if(choicebox.getValue().equals("Bubble Sort: Height")) {
					eq.bubbleSortH();
				}
				else if(choicebox.getValue().equals("Selection Sort: Username")) {
					eq.selectionSortU();
				}
				else if(choicebox.getValue().equals("Selection Sort: Weight")) {
					eq.selectionSortW();
				}
				else if(choicebox.getValue().equals("Insertion Sort: Height")) {
					eq.insertionSortH();
				}
				else if(choicebox.getValue().equals("Insertion Sort: Username")) {
					eq.selectionSortU();
				}
				else if(choicebox.getValue().equals("Save Accounts")) {
					eq.saveAccounts();
				}
				
				
				initializeTableView();
			}
		}
		catch(MissingFieldsException m) {
			Alert alert = new Alert(AlertType.INFORMATION);
		    alert.setTitle("Warning filling the registration");
		    alert.setHeaderText("Some fields are empty!");
		    alert.setContentText("This is a friendly reminder for you to fill all fields :D");
		
		    alert.showAndWait();
		}
	}
	
    @FXML
    void initialize() {
    	choicebox.getItems().add("Bubble Sort: Name");
    	choicebox.getItems().add("Bubble Sort: Height");
    	choicebox.getItems().add("Selection Sort: Username");
    	choicebox.getItems().add("Selection Sort: Weight");
    	choicebox.getItems().add("Insertion Sort: Height");
    	choicebox.getItems().add("Insertion Sort: Username");
    	choicebox.getItems().add("Save Accounts");
    	
    	initializeTableView();
    }
}
