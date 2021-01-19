package miniProject.loginSuccess;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import miniProject.exit.Exit;
import miniProject.exit.ExitImpl;

public class LoginSuccessController implements Initializable{
	private Parent root;
	private Exit exit;
	private LoginSuccess ls;
	public void setRoot(Parent root) {
		this.root = root;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	
		
		exit = new ExitImpl();
		ls = new LoginSuccessImpl();
	}
	public void startGame() {
		ls.startGame(root);
	}
	public void mouseGame() {
		ls.mouseGame(root);
	}
	public void exit() {
		exit.exit(root);
	}
	
	public void charSelect() {
		ls.charSelect(root);
	}
	
	
	
}
