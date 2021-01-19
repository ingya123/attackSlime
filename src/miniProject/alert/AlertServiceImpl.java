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
		alert.setContentText("���̵� �Է��ϼ���.");
		alert.show();
	}

	@Override
	public void EmptyPw() {
		alert = new Alert(AlertType.ERROR);
		alert.setContentText("��й�ȣ�� �Է��� �ּ���.");
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
		alert.setContentText("�ߺ��� ���̵� �Դϴ�.");
		alert.show();

	}

	@Override
	public void AvailableId() {
		alert = new Alert(AlertType.INFORMATION);
		alert.setContentText("��밡���� ���̵� �Դϴ�.");
		alert.show();

	}

	@Override
	public void MismatchPw() {
		alert = new Alert(AlertType.ERROR);
		alert.setContentText("��й�ȣ�� �ٸ��ϴ� Ȯ���� �ּ���.");
		alert.show();

	}

	@Override
	public void RecordUpdate(String score) {
		alert = new Alert(AlertType.INFORMATION);
		alert.setContentText("��� ����!\n���� : " + score);
		alert.show();

	}

	@Override
	public void GameOver(String score) {
		alert = new Alert(AlertType.INFORMATION);
		alert.setContentText("���� ����!\n���� : " + score);
		alert.show();

	}

	@Override
	public void NoDuplicateCheck() {
		 alert = new Alert(AlertType.ERROR);
			alert.setContentText("���̵� �ߺ�üũ�� ���ּ���.");
			alert.show();
		
	}

	@Override
	public void NoCharacterCheck() {
		alert = new Alert(AlertType.ERROR);
		alert.setContentText("ĳ���͸� �������ּ���!");
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
         alert.setTitle("���� ����"); 
         alert.setHeaderText("���!������ �����Ͻðڽ��ϱ�?"); 
         alert.setContentText("OK ��ư Ŭ�� �� ������ ����˴ϴ�."); 
         return alert.showAndWait();
         
          
		
	}
	
	
	

}
