package miniProject.game;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import miniProject.loginSuccess.LoginSuccessImpl;

public class Controller implements Initializable {

	private GameFuncImpl gameService;
	private Parent root;
	
	private @FXML Label ttt;
	
	

	
	
	
	public void setRoot(Parent root) {
		
		this.root = root;
		
	}
	
	
	
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//여기는 root가 set되지 않은 상태.
		
		gameService = new GameFuncImpl();



	}
			
	
	//키보드 메서드
	public void attackKeyboard(KeyEvent event) {
		//누르는 키 값
		boolean key = LoginSuccessImpl.mode;
		KeyCode keyCode = event.getCode();
		
		if(keyCode.equals(KeyCode.ENTER)&&key) {
			gameService.movePicKeyboard();
		}
	}
	
	
	
	//슬라임 클릭시 실행되는 메서드
	public void attackMonster() {
		boolean mouse = LoginSuccessImpl.mode;
		if(mouse!=true) {
			gameService.movePicMouse();
		}
	}
	


	public void setting() {
		gameService = new GameFuncImpl();
		gameService.setRoot(root); //루트 넘겨주기.
		gameService.buttonImgSet(); //버튼 이미지 조정
		
	}
	

	
	
	
			
	}


