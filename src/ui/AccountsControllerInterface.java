package ui;

import java.io.FileNotFoundException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;

public interface AccountsControllerInterface {

	public void setScene(Scene scene);

    @FXML
    void addActivities(ActionEvent event)  throws FileNotFoundException ;

    @FXML
    void getHealthTip(ActionEvent event);

    @FXML
    void getMotivationalQuote(ActionEvent event) ;

    @FXML
    void seeActivities(ActionEvent event) ;
    
    @FXML
    void seeOtherAccounts(ActionEvent event);
	
}
