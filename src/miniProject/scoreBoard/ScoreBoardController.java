package miniProject.scoreBoard;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import miniProject.exit.ExitImpl;

public class ScoreBoardController implements Initializable {

	private Parent root;
	ExitImpl ei;
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		ei = new ExitImpl();
		
		
	}
	
	
	public void exitS() {
		
		ei.exit(root);
	}
	
	
	

	
	
	
}
