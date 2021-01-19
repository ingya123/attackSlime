package miniProject.loginSuccess;

import java.util.ArrayList;
import java.util.Optional;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import miniProject.alert.AlertServiceImpl;
import miniProject.game.Controller;
import miniProject.game.GameFuncImpl;
import timer.StopWatch;

public class LoginSuccessImpl implements LoginSuccess {

	public static boolean pauseTime = true;
	public static int time; // x창 눌렀을 때의 시간 담아둘 변수
	private double keyHp = 10000;
	private double mouseHp = 5000;

	AlertServiceImpl asi = new AlertServiceImpl();

	private String warrior = "전사";
	private String archer = "궁수";
	private String magic = "마법사";

	// 랜덤시 사용값
	int randomSelect;
	int ranGoblin = 1;
	boolean ranWar = randomSelect <= 33;
	boolean ranBow = randomSelect <= 66;
	boolean ranMa = randomSelect <= 100;

	public static String CharacterPick;
	private String GameFxml = "../game/gameStart.fxml";
	// 키모드 : true
	// 마우스모드 : false
	public static boolean mode;

	public static String ranchars() {
		ArrayList<String> chars = new ArrayList<String>();

		for (int i = 0; i < 10; i++) {
			chars.add("고블린");
		}
		chars.add("히든");
		for (int i = 0; i < 15; i++) {
			chars.add("전사");
			chars.add("마법사");
			chars.add("궁수");
		}
		String ch = chars.get((int) (Math.random() * chars.size()));

		return ch;
	}

	@Override
	public void startGame(Parent root) {
		mode = true;
		GameFuncImpl.hp = keyHp;
		GameFuncImpl.defaultHp = keyHp;
		game(root, GameFxml);

	}

	@Override
	public void mouseGame(Parent root) {
		mode = false;
		GameFuncImpl.hp = mouseHp;
		GameFuncImpl.defaultHp = mouseHp;
		game(root, GameFxml);

	}

	public void game(Parent root, String url) {
		RadioButton war = (RadioButton) root.lookup("#rbW");
		RadioButton bow = (RadioButton) root.lookup("#rbB");
		RadioButton mag = (RadioButton) root.lookup("#rbM");
		RadioButton gob = (RadioButton) root.lookup("#rbRan");
		if (war.isSelected() || bow.isSelected() || mag.isSelected() || gob.isSelected()) {
			try {
				Stage gameStage = new Stage();
				FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
				root = loader.load();
				Controller ctrl = loader.getController();
				ctrl.setRoot(root);
				ctrl.setting();
				Scene scene = new Scene(root);
				gameStage.setTitle("때려라 슬라임");
				gameStage.setResizable(false);
				gameStage.setScene(scene);
				gameStage.show();
				// x누르면 화면 창 끄기or안끄기
				gameStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
					@Override
					public void handle(WindowEvent evt) {

						pauseTime = false;// 스탑워치 stop or start 조절 변수

						time = StopWatch.timer;

						Optional<ButtonType> result = asi.GameEndClick();

						// 끄기
						if (result.get() == ButtonType.OK) {
							LoginSuccessImpl.CharacterPick = LoginSuccessImpl.ranchars();
							StopWatch.timer = 0;
							pauseTime = true;

							// 취소
						} else if (result.get() == ButtonType.CANCEL) {
							pauseTime = true;
							evt.consume();
						}
					}
				});

				Label ttt = (Label) root.lookup("#ttt");
				StopWatch st = new StopWatch(ttt, 10, root);
				st.start();

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {

			asi.NoCharacterCheck();

		}
	}

	@Override
	public void exit(Parent root) {
	}

	// 캐릭터 선택
	@Override
	public void charSelect(Parent root) {

		RadioButton war = (RadioButton) root.lookup("#rbW");
		RadioButton bow = (RadioButton) root.lookup("#rbB");
		RadioButton mag = (RadioButton) root.lookup("#rbM");
		RadioButton ran = (RadioButton) root.lookup("#rbRan");

		Label charSelBackground = (Label) root.lookup("#charSelBackground");
		Label comment = (Label) root.lookup("#comment");

		ImageView warBack = new ImageView("/image/warBack.jpg");
		ImageView bowBack = new ImageView("/image/bowBack.jpg");
		ImageView magBack = new ImageView("/image/magBack.jpg");
		ImageView ranBack = new ImageView("/image/ranBack.png");
		ImageView warComm = new ImageView("/image/warComment.png");
		ImageView bowComm = new ImageView("/image/bowComment.png");
		ImageView magiComm = new ImageView("/image/magiComment.png");

		warBack.setFitHeight(515);
		warBack.setFitWidth(540);
		bowBack.setFitHeight(515);
		bowBack.setFitWidth(540);
		magBack.setFitHeight(515);
		magBack.setFitWidth(540);

		Label lb = (Label) root.lookup("#lb01");
		// 사진
		ImageView wa = new ImageView("/image/warrior.png");
		ImageView bo = new ImageView("/image/bow.png");
		ImageView ma = new ImageView("/image/magic.png");
		ImageView ra = new ImageView("/image/ranChar.png");
		wa.setFitHeight(200);
		wa.setFitWidth(250);
		bo.setFitHeight(200);
		bo.setFitWidth(150);
		ma.setFitHeight(200);
		ma.setFitWidth(170);
		warComm.setFitHeight(250);
		warComm.setFitWidth(250);
		bowComm.setFitHeight(250);
		bowComm.setFitWidth(250);
		magiComm.setFitHeight(250);
		magiComm.setFitWidth(250);

		if (war.isSelected()) {
			lb.setGraphic(wa);
			charSelBackground.setGraphic(warBack);
			comment.setGraphic(warComm);
			comment.setVisible(true);
			CharacterPick = warrior;
		} else if (bow.isSelected()) {
			lb.setGraphic(bo);
			charSelBackground.setGraphic(bowBack);
			comment.setVisible(true);
			comment.setGraphic(bowComm);
			CharacterPick = archer;
		} else if (mag.isSelected()) {
			charSelBackground.setGraphic(magBack);
			comment.setGraphic(magiComm);
			comment.setVisible(true);
			lb.setGraphic(ma);
			CharacterPick = magic;
		} else if (ran.isSelected()) {
			randomSelect = (int) (Math.random() * 100 + 1);
			charSelBackground.setGraphic(ranBack);
			comment.setVisible(false);
			lb.setGraphic(ra);
			// CharacterPick="히든";
			CharacterPick = ranchars();
		}

	}

}
