package miniProject.alert;

import java.util.Optional;

import javafx.scene.control.ButtonType;

public interface AlertService {

	
	//아디입력안함
	public void EmptyId();
	
	//비번입력안함
	public void EmptyPw();
	
	//회원가입완료
	public void SignUpSuccess();
	
	//중복된id
	public void DuplicateId();
	
	//사용가능한id
	public void AvailableId();
	
	//중복체크안함
	public void NoDuplicateCheck();
	
	//캐릭터선택안함
	public void NoCharacterCheck();
	
	//비번틀림
	public void MismatchPw();
	
	//기록갱신
	public void RecordUpdate(String score);
	//게임종료
	public void GameOver(String score);
	
	//특정오류출력
	public void SomeError(String msg);
	
	//게임종료(x)버튼누름
	public Optional<ButtonType> GameEndClick();
	
	
}
