package boot;

import java.util.Observer;

import model.Model;
import model.MyModel;
import presenter.CommonPresenter;
import presenter.MyPresenter;
import presenter.Presenter;
import view.MyView;
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
		Model m = new MyModel();
		View v = new MyView();
		Observer p = new MyPresenter(m,v);
		v.addObserver(p);
		m.addObserver(p);
		
		v.start();
		
		

	}

}
