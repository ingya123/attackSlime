package miniProject.newMembership;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import miniProject.exit.ExitImpl;

public class NewMembershipController implements Initializable{
	private Parent root;
	private NewMembership nms;
	private ExitImpl ei;
	public void setRoot(Parent root) {
		this.root = root;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		nms = new NewMembershipImpl();
		ei = new ExitImpl();
	}
	
	public void IdCh() {
		nms.IdCh(root);
	}
	public void NewMembershipCompl() {
		nms.NewMembershipCompl(root);
	}
	public void exit() {
		ei.exit(root);
	}


}
