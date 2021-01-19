package miniProject.scoreBoard;

import java.util.HashMap;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import miniProject.DTO.ScoreDTO;
import miniProject.database.DatabaseServiceImpl;

public class ScoreBoardImpl implements ScoreBoard{
   
   DatabaseServiceImpl dbs = new DatabaseServiceImpl();
   
   

   @Override
   public void scoreBoard(Parent root) {
      try {
      Stage scoreStage = new Stage();
      FXMLLoader loader = 
            new FXMLLoader(getClass().getResource("scorePage.fxml"));         
      root = loader.load();
   
      ScoreBoardController sc = loader.getController();
      sc.setRoot(root);
      
      cScoreCalc(root, dbs.clickScoreS());
      kScoreCalc(root, dbs.ScoreS());
      
      
      
      
      
         Scene scene = new Scene(root);
         scoreStage.setScene(scene);
         scoreStage.show();
      }catch (Exception e) {
         e.printStackTrace();
      }   
   }



   @Override
   public void kScoreCalc(Parent root,HashMap<String, ScoreDTO> score) {
      
      HashMap<String,ScoreDTO> hm = new HashMap<String,ScoreDTO>();
      //hm = dbs.ScoreS();
      hm = score;
      Label lbl1, lbl2, lbl3 ;
      int cnt = 1;
      
      for(String key : hm.keySet()) {
         
         ScoreDTO scoreDTO = hm.get(key);
         
         String val = Integer.toString(scoreDTO.getScore());
         String val2 = scoreDTO.getCharacter();
         
         lbl1 = (Label)root.lookup("#name0"+cnt);
         lbl2 = (Label)root.lookup("#sc0"+cnt);
         lbl3 = (Label)root.lookup("#cl0"+cnt);
         lbl1.setText(key);
         lbl2.setText(val);
         lbl3.setText(val2);

         cnt++;

         if(cnt == 11) {
            break;
         }
         
      }
   }



   @Override
   public void cScoreCalc(Parent root,HashMap<String, ScoreDTO> score) {
      HashMap<String,ScoreDTO> clickHm = new HashMap<String,ScoreDTO>();
      //clickHm = dbs.clickScoreS();
      clickHm = score;
      Label clickLbl1, clickLbl2, clickLbl3 ;
      int cnt2 = 1;
      
      for(String key : clickHm.keySet()) {
         
         ScoreDTO scoreDTO = clickHm.get(key);
         
         String val = Integer.toString(scoreDTO.getScore());
         String val2 = scoreDTO.getCharacter();
         
         clickLbl1 = (Label)root.lookup("#clickName0"+cnt2);
         clickLbl2 = (Label)root.lookup("#clickSc0"+cnt2);
         clickLbl3 = (Label)root.lookup("#clickCl0"+cnt2);
         clickLbl1.setText(key);
         clickLbl2.setText(val);
         clickLbl3.setText(val2);

         cnt2++;

         if(cnt2 == 11) {
            break;
         }
      }
      
   }



   
      
   
   
   
   
   
   
   
   
   
   
}

	

	
	
	
	
	
	
	


