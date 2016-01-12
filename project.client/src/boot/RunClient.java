package boot;

import java.util.ArrayList;

import model.Model;
import model.MyModel;
import model.PropManager;
import presenter.MyPresenter;
import presenter.MyProperties;
import view.CLI;
import view.GUI;
import view.View;

public class RunClient {

	public static void main(String[] args) {

		MyProperties prop = new PropManager().loadProp();
		View v = new GUI();
		ArrayList<String> arr = v.getUserCommand();
		if(v.getUserCommand().get(0).equals("CLI")){
			v = new CLI();			
		}
		if(!prop.getGenerateAlgo().equals(arr.get(1)))
			prop.setGenerateAlgo(arr.get(1));
		if(!prop.getSolveAlgo().equals(arr.get(2)))
			prop.setSolveAlgo(arr.get(2));
		v.getUserCommand().get(0);		
		Model m = new MyModel(prop,v.getUserCommand().get(0),Integer.parseInt(v.getUserCommand().get(1)));		
		MyPresenter p = new MyPresenter(m,v);
		v.addObserver(p);
		m.addObserver(p);
		
		v.start();

	}

}
