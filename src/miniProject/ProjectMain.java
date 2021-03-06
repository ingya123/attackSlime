package miniProject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProjectMain extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = 
				new FXMLLoader(getClass().getResource("loginPage.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		LoginController lcCtrl = loader.getController();
		lcCtrl.setRoot(root);
		primaryStage.setScene(scene);
		primaryStage.show();
			
	}
	public static void main(String[] args) {
		launch(args);
	}
}












