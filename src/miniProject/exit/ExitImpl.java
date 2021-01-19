package miniProject.exit;

import javafx.scene.Parent;
import javafx.stage.Stage;

public class ExitImpl implements Exit{

	@Override
	public void exit(Parent root) {
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
		
	}
	
}
