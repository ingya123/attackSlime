package miniProject.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import miniProject.DTO.ScoreDTO;
import miniProject.loginSuccess.LoginSuccessImpl;

public class DatabaseServiceImpl implements DatabaseService{
	String driver, url,user,pwd;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	public DatabaseServiceImpl() {
		user = "java1"; pwd = "1234";
		driver = "oracle.jdbc.driver.OracleDriver";
		url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName(driver);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public ResultSet SignUp(Parent root) {
		TextField id = (TextField)root.lookup("#fxNewId");
		String sql = "insert into userinfo values(?,?,0)";
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			sql = "select * from userinfo where id = ?";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, id.getText());
			rs = ps.executeQuery();
			return rs;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}	
			
	@Override
	public ResultSet password(Parent root) {
		TextField id = (TextField)root.lookup("#fxNewId");
		PasswordField pw = (PasswordField)root.lookup("#fxNewPw");
		
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "insert into userinfo(id, pw, score,clickscore) values(?, ?, ?,0)";
			ResultSet rs = null;
			ps = con.prepareStatement(sql);
			ps.setString(1, id.getText());
			ps.setString(2, pw.getText());
			ps.setInt(3, 0);
			rs = ps.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}	
	}
		
	@Override
	   public String loginS(String cid, String cpw) {
	      String checkPw = null;
	      String checkId = null;
	      checkId = checkId(cid);
	      if(checkId == null) {
	         return "그런 아이디는 없습니다.";
	      } else {
	         checkPw = checkPw(checkId);
	         if(cpw.equals(checkPw)) { 
	        	 return checkId;		          
	         }else {
	        	  return "비밀번호가 틀렸습니다.";
	         }
	      }
		}
		   
	public String checkId(String cid) {
		String sql = "select id from userinfo where id=?";
		ResultSet rs = null;
		String checkid = null;
		try {
			con = DriverManager.getConnection(url,user,pwd);
			ps = con.prepareStatement(sql);
			ps.setString(1, cid);
			rs = ps.executeQuery();
			if(rs.next()) {
				checkid = rs.getString("id");		            
			}
			return checkid;
		}catch (Exception e) {
			e.printStackTrace();
			return checkid;
		}   
	}   
		   
	private String checkPw(String cid) {
		String sql = "select pw from userinfo where id=?";
		ResultSet rs = null;
		String checkPw = null;
		try {
			con = DriverManager.getConnection(url,user,pwd);
			ps = con.prepareStatement(sql);
			ps.setString(1, cid);
			rs = ps.executeQuery();
			if(rs.next()) {
				checkPw = rs.getString("pw");
			}
		}catch (Exception e) {
			e.printStackTrace();
			return checkPw;
		}
		return checkPw;
	}
		   
	@Override
	public LinkedHashMap<String,ScoreDTO> ScoreS() {
		LinkedHashMap<String,ScoreDTO> scores = new LinkedHashMap<String, ScoreDTO>();
		String sql = "select id,score,character from userinfo where score <> 0 order by score desc";
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url,user,pwd);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ScoreDTO sdo = new ScoreDTO();
				sdo.setScore(rs.getInt("score"));
				sdo.setCharacter(rs.getString("character"));
				scores.put(rs.getString("id"), sdo);				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return scores;
	}

	@Override
	public void scoreInput(String cid, int cscore) {
		String sql = "update userinfo set score=?, character = ? where id=?";
		String id = cid;
		int score = cscore;		
		try {
			con = DriverManager.getConnection(url,user,pwd);
			ps = con.prepareStatement(sql);
			ps.setInt(1, score);
			ps.setString(2, LoginSuccessImpl.CharacterPick);
			ps.setString(3, id);			
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public LinkedHashMap<String,ScoreDTO> clickScoreS() {
		LinkedHashMap<String,ScoreDTO> scores = new LinkedHashMap<String, ScoreDTO>();
		String sql = "select id,clickscore,clickcharacter from userinfo where clickscore <> 0 order by clickscore desc";
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url,user,pwd);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ScoreDTO sdo = new ScoreDTO();
				sdo.setScore(rs.getInt("clickscore"));
				sdo.setCharacter(rs.getString("clickcharacter"));
				scores.put(rs.getString("id"), sdo);				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return scores;
	}
	@Override
	public void clickScoreInput(String cid, int cscore) {
		String sql = "update userinfo set clickscore=?, clickcharacter = ? where id=?";
		String id = cid;
		int score = cscore;		
		try {
			con = DriverManager.getConnection(url,user,pwd);
			ps = con.prepareStatement(sql);
			ps.setInt(1, score);
			ps.setString(2, LoginSuccessImpl.CharacterPick);
			ps.setString(3, id);			
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int maxScore(String id,int newScore) {
		String sql = "select score from userinfo where id=?";
		ResultSet rs = null;
		int score = 0;
		try {
			con = DriverManager.getConnection(url,user,pwd);
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				score = rs.getInt("score");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return score;		
	}
	public int clickMaxScore(String id,int newScore) {
		String sql = "select clickscore from userinfo where id=? order by clickscore desc";
		ResultSet rs = null;
		int clickScore = 0;
		try {
			con = DriverManager.getConnection(url,user,pwd);
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				clickScore = rs.getInt("clickscore");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return clickScore;		
	}
}
