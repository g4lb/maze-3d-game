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
		
		MyProperties prop = new PropManager().loadProp();//TODO basic window with properties
		Model m = new MyModel(prop);
		View v ;
		if(prop.getGameInterface().equals("CLI")){
			v = new CLI();			
		}
		else{
			v = new GUI();
		}
		MyPresenter p = new MyPresenter(m,v);
		v.addObserver(p);
		m.addObserver(p);
		
		v.start();
		
		

	}

}
