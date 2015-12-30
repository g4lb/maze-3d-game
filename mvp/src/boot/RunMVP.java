package boot;

import model.Model;
import model.MyModel;
import model.PropManager;
import presenter.MyPresenter;
import presenter.MyProperties;
import view.CLI;
import view.GUI;
import view.View;

/**
 * <h1> Class RunMVC </h1>
 * 
 * this class has main method that run a MVC application design
 * read about MVC:
 * <p><a href="http://www.oracle.com/technetwork/articles/javase/index-142890.html">MVC</a> is a link to oracle website about MVC app design</p>


 * @author Gal Ben Evgi & Gal Malca
 * @since 2015-12-17
 * @version 1.0
 */
public class RunMVP {

	public static void main(String[] args) {
		
		
		MyProperties prop = new PropManager().loadProp();
		View v = new GUI();
		if(v.getUserCommand().get(0).equals("CLI")){
			v = new CLI();			
		}
		if(!prop.getGenerateAlgo().equals(v.getUserCommand().get(1)))
			prop.setGenerateAlgo(v.getUserCommand().get(1));
		if(!prop.getSolveAlgo().equals(v.getUserCommand().get(2)))
			prop.setSolveAlgo(v.getUserCommand().get(2));
		
		Model m = new MyModel(prop);
		MyPresenter p = new MyPresenter(m,v);
		v.addObserver(p);
		m.addObserver(p);
		
		v.start();
		
		

	}

}
