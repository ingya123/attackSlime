package miniProject.image;

import javafx.scene.image.ImageView;

public class MonsterImageSet {
	
	private int pinkSlimeBasicsSizeHeight = 300;
	private int pinkSlimeBasicsSizeWidt = 250;
	private int pinkSlimeAttackSizeHeight = 300;
	private int pinkSlimeAttackSizeWidt = 300;
	private int pinkSlimePowerAttackSizeHeight = 350;
	private int pinkSlimePowerAttackSizeWidt = 400;	
	
	/*
	private int goblinBasicsSizeHeight = 300;
	private int goblinBasicsSizeWidt = 300;
	private int goblinAttackSizeHeight = 300;
	private int goblinAttackSizeWidt = 250;
	private int goblinPowerAttackSizeHeight = 350;
	private int goblinPowerAttackSizeWidt = 400;
	*/
	
	public ImageView goblinBasics() {
		ImageView goblin = new ImageView("/image/g1.png");
		//goblin.setFitHeight(goblinBasicsSizeHeight);
		//goblin.setFitWidth(goblinBasicsSizeWidt);
		return goblin;
	}
	public ImageView goblinAttack() {
		ImageView goblin = new ImageView("/image/g2.png");
		//goblin.setFitHeight(goblinAttackSizeHeight);
		//goblin.setFitWidth(goblinAttackSizeWidt);
		return goblin;
	}
	public ImageView goblinPowerAttack() {
		ImageView goblin = new ImageView("/image/g3.png");
		//goblin.setFitHeight(goblinPowerAttackSizeHeight);
		//goblin.setFitWidth(goblinPowerAttackSizeWidt);
		return goblin;
	}
	
	
	public ImageView pinkSlimeBasics() {
		ImageView pinkSlime = new ImageView("/image/pinksl.png");
		pinkSlime.setFitHeight(pinkSlimeBasicsSizeHeight);
		pinkSlime.setFitWidth(pinkSlimeBasicsSizeWidt);
		return pinkSlime;
	}
	public ImageView pinkSlimeAttack() {
		ImageView pinkSlime = new ImageView("/image/pinkSlime.png");
		pinkSlime.setFitHeight(pinkSlimeAttackSizeHeight);
		pinkSlime.setFitWidth(pinkSlimeAttackSizeWidt);
		return pinkSlime;
	}
	
	public ImageView pinkSlimePowerAttack() {
		ImageView pinkSlime = new ImageView("/image/criSlime.png");
		pinkSlime.setFitHeight(pinkSlimePowerAttackSizeHeight);
		pinkSlime.setFitWidth(pinkSlimePowerAttackSizeWidt);
		return pinkSlime;
	}
	
	
	
	
	
	
	
	
	
	
	
}
