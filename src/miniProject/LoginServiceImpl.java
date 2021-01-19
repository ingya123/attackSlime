package miniProject;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import miniProject.alert.AlertServiceImpl;
import miniProject.database.DatabaseServiceImpl;
import miniProject.loginSuccess.LoginSuccessController;
import miniProject.newMembership.NewMembershipController;
import miniProject.scoreBoard.ScoreBoardController;
import miniProject.scoreBoard.ScoreBoardImpl;

public class LoginServiceImpl implements LoginService {
	public static String msg;
	private DatabaseServiceImpl dbs = new DatabaseServiceImpl();
	ScoreBoardImpl sbi = new ScoreBoardImpl();
	AlertServiceImpl asi = new AlertServiceImpl();

	@Override
	public void login(Parent root) {
		DatabaseServiceImpl ds = new DatabaseServiceImpl();
		TextField id = (TextField) root.lookup("#fxId");
		PasswordField pw = (PasswordField) root.lookup("#fxPw");

		if (id.getText().isEmpty()) {

			asi.EmptyId();
		} else if (pw.getText().isEmpty()) {

			asi.EmptyPw();
		} else {
			msg = ds.loginS(id.getText(), pw.getText());
			if (id.getText().equals(msg)) {
				Stage loginSuccStage = new Stage();
				FXMLLoader loader = new FXMLLoader(
						getClass().getResource("/miniProject/loginSuccess/loginSuccess.fxml"));

				try {
					root = loader.load();
					LoginSuccessController lscCtrl = loader.getController();

					lscCtrl.setRoot(root);

				} catch (IOException e) {
					e.printStackTrace();
				}
				Label hero = (Label) root.lookup("#charSelBackground");
				ImageView hImg = new ImageView("/image/hero.png");
				hImg.setFitHeight(505);
				hImg.setFitWidth(530);
				hero.setGraphic(hImg);

				Scene scene = new Scene(root);
				loginSuccStage.setResizable(false);
				loginSuccStage.setScene(scene);
				loginSuccStage.show();
			} else {

				asi.SomeError(msg);
			}
		}
	}

	@Override
	public void newMembership(Parent root) {
		Stage newMemStage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/miniProject/newMembership/newMembershipPage.fxml"));
		Parent newMem = null;

		try {
			newMem = loader.load();
			NewMembershipController nmcCtrl = loader.getController();
			nmcCtrl.setRoot(newMem);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(newMem);
		newMemStage.setScene(scene);
		newMemStage.show();
	}

	@Override
	public void scoreBoard(Parent root) {
		try {
			Stage scoreStage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/miniProject/scoreBoard/scorePage.fxml"));
			root = loader.load();

			ScoreBoardController sc = loader.getController();
			sc.setRoot(root);

			sbi.cScoreCalc(root, dbs.clickScoreS());
			sbi.kScoreCalc(root, dbs.ScoreS());

			Scene scene = new Scene(root);
			scoreStage.setScene(scene);
			scoreStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void exit(Parent root) {
		Stage stage = (Stage) root.getScene().getWindow();
		stage.close();
	}
}
