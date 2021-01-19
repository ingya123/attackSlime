package miniProject.game;

public interface IGameFunc {

	
	//피 깎이는거
	
	
	//아이템 드랍(생각)
	
	
	//한 판에 경험치를 줌..레벨
	
	

	///////////////////////////////
			
	
	//impl에서 멤버변수(score,critical)값 set
	public int calcScoreCri();
	
	
	//몬스터 사진 움직임 + 사용자 사진 움직임
		//키보드가 눌릴 때에 움직여야 함.
	public void movePicKeyboard();
	
	
	public void movePicMouse();
	
	
	//이미지 세팅 메소드
	public void buttonImgSet();
}
