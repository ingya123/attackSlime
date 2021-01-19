package miniProject.game;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import miniProject.image.CharImage;
import miniProject.image.CharImageSet;
import miniProject.image.MonsterImage;
import miniProject.image.MonsterImageSet;
import miniProject.loginSuccess.LoginSuccessImpl;
import timer.StopWatch;

public class GameFuncImpl implements IGameFunc {
	
	private Parent root;
	private Label backLabel;
	private Button monster;
	private Button userImg;
	private Label scoreLabel;
	private ProgressBar hpBar;
	public static double hp=5000;
	private float sumScore=0;
	
	private String character1 = "전사";
	private String character2 = "궁수";
	private String character3 = "마법사";
	private String character4 = "고블린";
	private String character5 = "히든";
	
	//게임 값 변수
	private int warScore=100;
	private int criWarScore=200;
	private int magScore=50;
	private int criMagScore=600;
	private int bowScore=80;
	private int criBowScore=180;
	private int goblinScore = 1;
	private int crigoblinScore = 10000;
	private int crigoblinScoreClick = 20000;
	private int hidenScore = 200;
	private int crihidenScore = 500;
	
	public static double defaultHp=5000;
	
	
	
	
	//이미지
	
	private CharImage charImage = new CharImage();
	private CharImageSet charSet = new CharImageSet();
	private MonsterImage monImage = new MonsterImage();
	private MonsterImageSet monSet = new MonsterImageSet();
	
	
	private ImageView backImg;
	private ImageView backImg2;

	public void setRoot(Parent root) {
		this.root = root;
	}
	
	//버튼에 이미지 지정하고 크기 지정
	public void buttonImgSet() {
		
		//hp 삽입
		hpBar = (ProgressBar)root.lookup("#hpBar");
		hpBar.setProgress(1);
		backImg = new ImageView("/image/back.png");
		backImg2 = new ImageView("/image/back2.gif");
		//배경이미지
		backLabel = (Label)root.lookup("#backLabel");

		
		
		backImg.setFitHeight(800);backImg.setFitWidth(1100);
		
		backLabel.setGraphic(backImg);
		
		backImg2.setFitHeight(800);backImg2.setFitWidth(1100);
		
		//전사를 선택했을 때 이미지 set
		if(LoginSuccessImpl.CharacterPick.equals(character1)) {
			
			charImage.setBasics(charSet.warriorBasics());
			charImage.setAttack(charSet.warriorAttack());
			charImage.setPowerAttack(charSet.warriorPowerAttack());
			
		//궁수를 선택했을 때 이미지 set
		}else if(LoginSuccessImpl.CharacterPick.equals(character2)){
			charImage.setBasics(charSet.archerBasice());
			charImage.setAttack(charSet.archerAttack());
			charImage.setPowerAttack(charSet.archerPowerAttack());
			
			
		//마법사를 선택했을 때 이미지 set
		}else if(LoginSuccessImpl.CharacterPick.equals(character3)) {
			charImage.setBasics(charSet.magicianBasics());
			charImage.setAttack(charSet.magicianAttack());
			charImage.setPowerAttack(charSet.magicianPowerAttack());
			
		}else if(LoginSuccessImpl.CharacterPick.equals(character4)) {
			charImage.setBasics(charSet.goblinBasics());
			charImage.setAttack(charSet.goblinAttack());
			charImage.setPowerAttack(charSet.goblinPowerAttack());
		}else if(LoginSuccessImpl.CharacterPick.equals(character5)) {
			charImage.setBasics(charSet.hidenBasics());
			charImage.setAttack(charSet.hidenAttack());
			charImage.setPowerAttack(charSet.hidenPowerAttack());
		}
		
		monImage.setPinkSlimeBasics(monSet.pinkSlimeBasics());
		monImage.setPinkSlimeAttack(monSet.pinkSlimeAttack());
		monImage.setPinkSlimePowerAttack(monSet.pinkSlimePowerAttack());

		 	
		monster = (Button)root.lookup("#monster");
		userImg = (Button)root.lookup("#userImg");
		   
		  
		monster.setGraphic(monImage.getPinkSlimeBasics());
		monster.setStyle("-fx-background-color:transparent;");
		userImg.setGraphic(charImage.getBasics());
		userImg.setStyle("-fx-background-color:transparent;");
		    

	}
	
	
	
	public void hpControl(double damage) {
		hp -= damage;
		
		double percentage = Math.round((hp / defaultHp)*100);
		hpBar.setProgress(percentage/100);
		
		
		if(hp <= 0) {//피버타임일 때
			
			StopWatch.timer += 5; 		   //시간 10초 더
			hp = defaultHp*100;
			
			//공격력
			criBowScore *=2;criWarScore *=2;criMagScore *=2;crihidenScore *=2;
			bowScore*=2;warScore*=2;magScore*=2;hidenScore *=2;crigoblinScore *=2;
			
			//몬스터 이미지
			monImage.setPinkSlimeBasics(monSet.goblinBasics());
			monImage.setPinkSlimeAttack(monSet.goblinAttack());
			monImage.setPinkSlimePowerAttack(monSet.goblinPowerAttack());
			hpBar.setVisible(false);
			
			backLabel.setGraphic(backImg2);
			
		}
		
		
	}
	
	
	@Override
	public void movePicKeyboard() {
		boolean cri;
		if(LoginSuccessImpl.CharacterPick.equals(character1)) {
			cri = calcScoreCri() == 7;
			keyboard(warScore,criWarScore,cri);
		}else if(LoginSuccessImpl.CharacterPick.equals(character2)) {
			cri = calcScoreCri() == 1||calcScoreCri() == 2||calcScoreCri() == 3;
			keyboard(bowScore,criBowScore,cri);
		}else if(LoginSuccessImpl.CharacterPick.equals(character3)) {
			cri = calcScoreCri() ==7;
			keyboard(magScore,criMagScore,cri);
		}else if(LoginSuccessImpl.CharacterPick.equals(character4)) {
			cri = (int)(Math.random()*60+1) == 7;
			keyboard(goblinScore,crigoblinScore,cri);
		}else if(LoginSuccessImpl.CharacterPick.equals(character5)) {
			cri = calcScoreCri() == 1||calcScoreCri() == 2||calcScoreCri() == 3;
			keyboard(hidenScore,crihidenScore,cri);
		}
	}
	
	
	
	
	public void keyboard(int score,int criScore,boolean cri) {
	      Button monster = (Button)root.lookup("#monster");
	      Button userImg = (Button)root.lookup("#userImg");     
	      
	      int attackXLine=30;int attackYLine=50;
	      int XLine=170;int YLine=200;
	    	  
	  	      //키보드 누르면 이벤트 실행
	      monster.setOnKeyPressed(new EventHandler<KeyEvent>() {
	    	  
	    	  @Override
	    	  public void handle(KeyEvent event) {
	    		  KeyCode keyCode = event.getCode();

	    		  //엔터만 누를 때 실행
	    		  if(keyCode.equals(KeyCode.ENTER)) {//엔터일때만 때리기
	  						
	    			    	  	
	    			  //크리티컬 발생 시 if문
	    			  if(cri) {		
					  
	    				  monster.setGraphic(monImage.getPinkSlimePowerAttack());
	    				  userImg.setGraphic(charImage.getPowerAttack());
	    				  userImg.setLayoutX(attackXLine);
	    				  userImg.setLayoutY(attackYLine);
				                      
	    				  sumScore+=criScore;
				                      
	    				  hpControl(criScore);
	    				  setScoreLabel();

	    			  } else { //크리티컬 안떴을 시
						                	 
	    				  monster.setGraphic(monImage.getPinkSlimeAttack());
	    				  userImg.setGraphic(charImage.getAttack());
	    				  sumScore+=score;
	    				  hpControl(score);
	    				  setScoreLabel();
	    			  }//크리티컬 if문 끝  
				                
	    			  monster.setOnKeyReleased(e->{
	    				  monster.setGraphic(monImage.getPinkSlimeBasics());		              
	    				  userImg.setGraphic(charImage.getBasics());
	    				  userImg.setLayoutX(XLine);
	    				  userImg.setLayoutY(YLine);
	    			  });
	    			  
	    		  }					
	    	  }
	      });	      
	}
	
	
	
	
	
	
	
	
	
	
	public void movePicMouse() {
		boolean cri;
		if(LoginSuccessImpl.CharacterPick.equals("전사")) {
			cri = calcScoreCri() == 7;
			mouse(warScore,criWarScore,cri);
		}else if(LoginSuccessImpl.CharacterPick.equals("궁수")) {
			cri = calcScoreCri() == 1||calcScoreCri() == 2||calcScoreCri() == 3;
			mouse(bowScore,criBowScore,cri);
		}else if(LoginSuccessImpl.CharacterPick.equals("마법사")) {
			cri = calcScoreCri() ==7;
			mouse(magScore,criMagScore,cri);
		}else if(LoginSuccessImpl.CharacterPick.equals("고블린")) {
			cri = (int)(Math.random()*60+1) == 7;
			mouse(goblinScore,crigoblinScoreClick,cri);
		}else if(LoginSuccessImpl.CharacterPick.equals("히든")) {
			cri = calcScoreCri() == 1||calcScoreCri() == 2||calcScoreCri() == 3;
			mouse(hidenScore,crihidenScore,cri);
		}
	}//movePicMouse끝
	
	
	
	public void mouse(int score,int criScore,boolean cri) {
		
		Button monster = (Button)root.lookup("#monster");
		Button userImg = (Button)root.lookup("#userImg");	            
		int attackXLine=30;int attackYLine=50;
		int XLine=170;int YLine=200;

	       //==============마우스 버전=======================
	    
		if(cri) {
			
			monster.setOnMousePressed(e->{
				monster.setGraphic(monImage.getPinkSlimePowerAttack());
				userImg.setGraphic(charImage.getPowerAttack());
				userImg.setLayoutX(attackXLine);
				userImg.setLayoutY(attackYLine);
				sumScore+=criScore;
				hpControl(criScore);
				setScoreLabel();
			});
            
		} else {
      	  
			monster.setOnMousePressed(e->{
				monster.setGraphic(monImage.getPinkSlimeAttack());
				userImg.setGraphic(charImage.getAttack());
				sumScore+=score;
				hpControl(score);
				setScoreLabel();
			});
		}   
 
		monster.setOnMouseReleased(e->{
			monster.setGraphic(monImage.getPinkSlimeBasics());
			userImg.setGraphic(charImage.getBasics());
			userImg.setLayoutX(XLine);
			userImg.setLayoutY(YLine);
		});    
	}
	
	
	

	public void setScoreLabel() {
		
		scoreLabel = (Label)root.lookup("#scoreLabel");
	      String num = String.format("%.0f", sumScore);
	      scoreLabel.setText(num);
	}
		@Override
		public int calcScoreCri() {
			int critical=0;
			
			critical = (int)((Math.random()*10)+1); //난수발생
			return critical;
		}


	
	

}
