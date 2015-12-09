package boot;

import controller.Controller;
import controller.MyController;
import model.Model;
import model.MyModel;
import view.MyView;
import view.View;

public class RunMVC {

	public static void main(String[] args) {
		Controller ctr = new MyController();
		Model m = new MyModel(ctr);
		View v = new MyView(ctr);
		ctr.setModel(m);
		ctr.setView(v);
		
		v.start();
		
		

	}

}
