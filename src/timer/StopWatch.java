package timer;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import miniProject.loginSuccess.LoginSuccessImpl;

public class StopWatch extends Thread{
   private Label time;
   public static int timer;
   private Parent root;
   
   
   public StopWatch(Label time,int timer,Parent root) {
         this.time = time;
         this.timer = timer;
         this.root = root;
   }
   
   public void run() {      
      while(timer>0) {
         timer--;
         Platform.runLater(new Runnable() {
            @Override
            public void run() {
               
               //x창 안누를때
               if(LoginSuccessImpl.pauseTime) {
                  time.setText(Integer.toString(timer));
                  if(timer==0) {
                     StopGame stop = new StopGame(root);
                     stop.stopAndScore();
                  }
                  
               //x창 누르면
               } else {
                  time.setText(Integer.toString(LoginSuccessImpl.time));
                  timer = LoginSuccessImpl.time;
               }
            }
         });
         
         
         
         try {
            Thread.sleep(1000);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }
}
