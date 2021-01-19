package miniProject.alert;

import java.util.Optional;

import javafx.scene.control.ButtonType;

public interface AlertService {

	
	//�Ƶ��Է¾���
	public void EmptyId();
	
	//����Է¾���
	public void EmptyPw();
	
	//ȸ�����ԿϷ�
	public void SignUpSuccess();
	
	//�ߺ���id
	public void DuplicateId();
	
	//��밡����id
	public void AvailableId();
	
	//�ߺ�üũ����
	public void NoDuplicateCheck();
	
	//ĳ���ͼ��þ���
	public void NoCharacterCheck();
	
	//���Ʋ��
	public void MismatchPw();
	
	//��ϰ���
	public void RecordUpdate(String score);
	//��������
	public void GameOver(String score);
	
	//Ư���������
	public void SomeError(String msg);
	
	//��������(x)��ư����
	public Optional<ButtonType> GameEndClick();
	
	
}
