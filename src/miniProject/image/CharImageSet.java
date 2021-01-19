package miniProject.image;

import javafx.scene.image.ImageView;

public class CharImageSet {
	
	
	
	private int warriorBasicsSizeHeight = 200;
	private int warriorBasicsSizeWidth = 250;
	private int warriorAttackSizeHeight = 200;
	private int warriorAttackSizeWidth = 250;
	private int warriorPowerAttackSizeHeight = 400;
	private int warriorPowerAttackSizeWidth = 400;
	
	
	private int archerBasicsSizeHeight = 200;
	private int archerBasicsSizeWidth = 150;
	private int archerAttackSizeHeight = 200;
	private int archerAttackSizeWidth = 250;
	private int archerPowerAttackSizeHeight = 400;
	private int archerPowerAttackSizeWidth = 400;
	
	private int magicianBasicsSizeHeight = 200;
	private int magicianBasicsSizeWidth = 170;
	private int magicianAttackSizeHeight = 200;
	private int magicianAttackSizeWidth = 250;
	private int magicianPowerAttackSizeHeight = 400;
	private int magicianPowerAttackSizeWidth = 400;
	
	private int goblinBasicsSizeHeight = 200;
	private int goblinBasicsSizeWidth = 170;
	private int goblinAttackSizeHeight = 200;
	private int goblinAttackSizeWidth = 250;
	private int goblinPowerAttackSizeHeight = 450;
	private int goblinPowerAttackSizeWidth = 450;
	
	private int hidenBasicsSizeHeight = 250;
	private int hidenBasicsSizeWidth = 270;
	private int hidenAttackSizeHeight = 250;
	private int hidenAttackSizeWidth = 270;
	private int hidenPowerAttackSizeHeight = 400;
	private int hidenPowerAttackSizeWidth = 450;
	
		//히든 기본
		public ImageView hidenBasics() {
			ImageView hiden = new ImageView("/image/hiden1.png");
			hiden.setFitHeight(hidenBasicsSizeHeight);
			hiden.setFitWidth(hidenBasicsSizeWidth);
			return hiden;
		}
		//히든 공격
		public ImageView hidenAttack() {
			ImageView hiden = new ImageView("/image/hiden2.png");
			hiden.setFitHeight(hidenAttackSizeHeight);
			hiden.setFitWidth(hidenAttackSizeWidth);
			return hiden;
		}
		//히든 크리티컬
		public ImageView hidenPowerAttack() {
			ImageView hiden = new ImageView("/image/hiden3.png");
			hiden.setFitHeight(hidenPowerAttackSizeHeight);
			hiden.setFitWidth(hidenPowerAttackSizeWidth);
			return hiden;
		}
	
	//고블린 기본
	public ImageView goblinBasics() {
		ImageView goblin = new ImageView("/image/goble1.png");
		goblin.setFitHeight(goblinBasicsSizeHeight);
		goblin.setFitWidth(goblinBasicsSizeWidth);
		return goblin;
	}
	//고블린 공격
	public ImageView goblinAttack() {
		ImageView goblin = new ImageView("/image/goble2.png");
		goblin.setFitHeight(goblinAttackSizeHeight);
		goblin.setFitWidth(goblinAttackSizeWidth);
		return goblin;
	}
	//고블린 크리티컬
	public ImageView goblinPowerAttack() {
		ImageView goblin = new ImageView("/image/goble3.png");
		goblin.setFitHeight(goblinPowerAttackSizeHeight);
		goblin.setFitWidth(goblinPowerAttackSizeWidth);
		return goblin;
	}
	
	
	//마법사 기본
	public ImageView magicianBasics() {
		ImageView magician = new ImageView("/image/magic.png");
		magician.setFitHeight(magicianBasicsSizeHeight);
		magician.setFitWidth(magicianBasicsSizeWidth);
		return magician;
	}
	//마법사 공격
	public ImageView magicianAttack() {
		ImageView magician = new ImageView("/image/magic2.png");
		magician.setFitHeight(magicianAttackSizeHeight);
		magician.setFitWidth(magicianAttackSizeWidth);
		return magician;
	}
	//마법사 크리티컬
	public ImageView magicianPowerAttack() {
		ImageView magician = new ImageView("/image/magic3.png");
		magician.setFitHeight(magicianPowerAttackSizeHeight);
		magician.setFitWidth(magicianPowerAttackSizeWidth);
		return magician;
	}
	
	//궁수 기본
	public ImageView archerBasice() {
		ImageView archer = new ImageView("/image/bow.png");
		archer.setFitHeight(archerBasicsSizeHeight);
		archer.setFitWidth(archerBasicsSizeWidth);
		return archer;
	}
	//궁수 공격
	public ImageView archerAttack() {
		ImageView archer = new ImageView("/image/bow2.png");
		archer.setFitHeight(archerAttackSizeHeight);
		archer.setFitWidth(archerAttackSizeWidth);
		return archer;
	}
	//궁수 크리티컬
	public ImageView archerPowerAttack() {
		ImageView archer = new ImageView("/image/bow3.png");
		archer.setFitHeight(archerPowerAttackSizeHeight);
		archer.setFitWidth(archerPowerAttackSizeWidth);
		return archer;
	}
	
	//전사 기본
	public ImageView warriorBasics() {
		ImageView warrior = new ImageView("/image/warrior.png");
		warrior.setFitHeight(warriorBasicsSizeHeight);
		warrior.setFitWidth(warriorBasicsSizeWidth);
		return warrior;
	}
	//전사 공격
	public ImageView warriorAttack() {
		ImageView warrior = new ImageView("/image/warrior2.png");
		warrior.setFitHeight(warriorAttackSizeHeight);
		warrior.setFitWidth(warriorAttackSizeWidth);
		return warrior;
	}
	//전사 크리티컬
	public ImageView warriorPowerAttack() {
		ImageView warrior = new ImageView("/image/warrior3.png");
		warrior.setFitHeight(warriorPowerAttackSizeHeight);
		warrior.setFitWidth(warriorPowerAttackSizeWidth);
		return warrior;
	}
	
	
	
	
	
}
