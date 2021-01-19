package miniProject.alert;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class AlertServiceImpl implements AlertService {

	Alert alert;

	@Override
	public void EmptyId() {
		alert = new Alert(AlertType.ERROR);
		alert.setContentText("아이디를 입력하세요.");
		alert.show();
	}

	@Override
	public void EmptyPw() {
		alert = new Alert(AlertType.ERROR);
		alert.setContentText("비밀번호를 입력해 주세요.");
		alert.show();

	}

	@Override
	public void SignUpSuccess() {
		alert = new Alert(AlertType.INFORMATION);
		alert.setContentText("WELCOME TO CLICKER!");
		alert.show();

	}

	@Override
	public void DuplicateId() {
		alert = new Alert(AlertType.ERROR);
		alert.setContentText("중복된 아이디 입니다.");
		alert.show();

	}

	@Override
	public void AvailableId() {
		alert = new Alert(AlertType.INFORMATION);
		alert.setContentText("사용가능한 아이디 입니다.");
		alert.show();

	}

	@Override
	public void MismatchPw() {
		alert = new Alert(AlertType.ERROR);
		alert.setContentText("비밀번호가 다릅니다 확인해 주세요.");
		alert.show();

	}

	@Override
	public void RecordUpdate(String score) {
		alert = new Alert(AlertType.INFORMATION);
		alert.setContentText("기록 갱신!\n점수 : " + score);
		alert.show();

	}

	@Override
	public void GameOver(String score) {
		alert = new Alert(AlertType.INFORMATION);
		alert.setContentText("게임 종료!\n점수 : " + score);
		alert.show();

	}

	@Override
	public void NoDuplicateCheck() {
		 alert = new Alert(AlertType.ERROR);
			alert.setContentText("아이디 중복체크를 해주세요.");
			alert.show();
		
	}

	@Override
	public void NoCharacterCheck() {
		alert = new Alert(AlertType.ERROR);
		alert.setContentText("캐릭터를 선택해주세요!");
		alert.show();
		
	}

	@Override
	public void SomeError(String msg) {
		  alert = new Alert(AlertType.ERROR);
          alert.setContentText(msg);
          alert.show();
		
	}

	@Override
	public Optional<ButtonType> GameEndClick() {
		 alert = new Alert(AlertType.CONFIRMATION); 
         alert.setTitle("게임 종료"); 
         alert.setHeaderText("잠깐!게임을 종료하시겠습니까?"); 
         alert.setContentText("OK 버튼 클릭 시 서버가 종료됩니다."); 
         return alert.showAndWait();
         
          
		
	}
	
	
	

}
