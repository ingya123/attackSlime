package timer;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import miniProject.LoginServiceImpl;
import miniProject.alert.AlertServiceImpl;
import miniProject.database.DatabaseServiceImpl;
import miniProject.loginSuccess.LoginSuccessImpl;
import miniProject.scoreBoard.ScoreBoard;
import miniProject.scoreBoard.ScoreBoardImpl;

public class StopGame {
	private Parent root;
	DatabaseServiceImpl dsi;	
	AlertServiceImpl asi;
	
	public StopGame(Parent root) {
		this.root = root;
		dsi = new DatabaseServiceImpl();
		asi = new AlertServiceImpl();
	}
	
	
	
	
	
	
	public void stopAndScore() {
		
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();		
		Label lb = (Label)root.lookup("#scoreLabel");
		String score = lb.getText();		
		int sc = Integer.parseInt(score);
		ScoreBoard sb = new ScoreBoardImpl();
		boolean check = LoginSuccessImpl.mode;
		int score2;
		if(check)
			score2 = dsi.maxScore(LoginServiceImpl.msg, sc);
		else
			score2 = dsi.clickMaxScore(LoginServiceImpl.msg, sc);
		if(sc > score2) {
			
			if(check) 
				dsi.scoreInput(LoginServiceImpl.msg, sc);
			else 
				dsi.clickScoreInput(LoginServiceImpl.msg, sc);
			
			sb.scoreBoard(root);
			asi.RecordUpdate(score);
		}else {			
			sb.scoreBoard(root);
			asi.GameOver(score);
		}
		LoginSuccessImpl.CharacterPick = LoginSuccessImpl.ranchars();
	}
	
	
}
