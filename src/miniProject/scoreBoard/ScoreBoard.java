package miniProject.scoreBoard;


import java.util.HashMap;

import javafx.scene.Parent;
import miniProject.DTO.ScoreDTO;

public interface ScoreBoard {
   public void scoreBoard(Parent root);
   
   public void kScoreCalc(Parent root,HashMap<String, ScoreDTO> score);
   public void cScoreCalc(Parent root,HashMap<String, ScoreDTO> score);


}
