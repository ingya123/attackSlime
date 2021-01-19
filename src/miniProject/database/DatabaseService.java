package miniProject.database;

import java.sql.ResultSet;
import java.util.HashMap;

import javafx.scene.Parent;

public interface DatabaseService {

	public ResultSet SignUp(Parent root);
	public ResultSet password(Parent root);
	
	public String loginS(String cid, String cpw );
	
	public HashMap ScoreS();
	public HashMap clickScoreS();
	
	public void scoreInput(String cid, int cscore);
	public void clickScoreInput(String cid, int cscore);
}
