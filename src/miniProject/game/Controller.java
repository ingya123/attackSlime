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
		//����� root�� set���� ���� ����.
		
		gameService = new GameFuncImpl();



	}
			
	
	//Ű���� �޼���
	public void attackKeyboard(KeyEvent event) {
		//������ Ű ��
		boolean key = LoginSuccessImpl.mode;
		KeyCode keyCode = event.getCode();
		
		if(keyCode.equals(KeyCode.ENTER)&&key) {
			gameService.movePicKeyboard();
		}
	}
	
	
	
	//������ Ŭ���� ����Ǵ� �޼���
	public void attackMonster() {
		boolean mouse = LoginSuccessImpl.mode;
		if(mouse!=true) {
			gameService.movePicMouse();
		}
	}
	


	public void setting() {
		gameService = new GameFuncImpl();
		gameService.setRoot(root); //��Ʈ �Ѱ��ֱ�.
		gameService.buttonImgSet(); //��ư �̹��� ����
		
	}
	

	
	
	
			
	}


