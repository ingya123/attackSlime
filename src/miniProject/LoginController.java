package miniProject;

import java.net.URL;
import java.util.ResourceBundle;



import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class LoginController implements Initializable{
	private Parent root;
	
	private LoginServiceImpl lsi;
	
	
	
	public void setRoot(Parent root) {
		this.root = root;		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		lsi = new LoginServiceImpl();
	}

	public void login() {
		lsi.login(root);
	}
	public void newMembership() {
		lsi.newMembership(root);
	}
	public void scoreBoard() {
		lsi.scoreBoard(root);
	}
	public void exit() {
		
		lsi.exit(root);
		
	}

	
}
