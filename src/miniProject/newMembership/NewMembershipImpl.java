
package miniProject.newMembership;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import miniProject.alert.AlertServiceImpl;
import miniProject.database.DatabaseService;
import miniProject.database.DatabaseServiceImpl;
import miniProject.exit.Exit;
import miniProject.exit.ExitImpl;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;

public class NewMembershipImpl implements NewMembership{
   private DatabaseService ds = new DatabaseServiceImpl();
   AlertServiceImpl asi = new AlertServiceImpl();
   private boolean flag = false;
   
   @Override
   public void IdCh(Parent root) {
      ResultSet rs = ds.SignUp(root);
      TextField id = (TextField)root.lookup("#fxNewId");
      
      if(id.getText().equals("")) {
 
    	  asi.EmptyId();
      }else {	      
	      try {
	         if(rs.next()) {

	        	 asi.EmptyPw();
	         }else {

	        	 asi.AvailableId();
	            flag = true;
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
      }
   }
      
   

   @Override
   public void NewMembershipCompl(Parent root) {
      Exit exit = new ExitImpl();
      TextField id = (TextField)root.lookup("#fxNewId");
      PasswordField pw = (PasswordField)root.lookup("#fxNewPw");
      PasswordField pwCh = (PasswordField)root.lookup("#fxNewPwCh");
      
      if(id.getText().isEmpty()) {
        
    	  asi.EmptyId();
      }else if(pw.getText().isEmpty() || pwCh.getText().isEmpty()) {
  
    	  asi.EmptyPw();
      }else {
         if(pw.getText().equals(pwCh.getText())) {
        	 if(flag) {
        		 flag = false;
        		 ds.password(root);         

        		 asi.SignUpSuccess();
        		 exit.exit(root);
        	 }else {

        		 asi.NoDuplicateCheck();
        	 }
         }else {
        	 asi.MismatchPw();
         }
      }
   }

   @Override
   public void exit(Parent root) {}

}