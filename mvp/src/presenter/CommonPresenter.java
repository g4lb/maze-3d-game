package presenter;

import java.util.HashMap;
import java.util.Observer;

import model.Model;
import view.View;

/**
 * <h1> Class Common Presenter </h1>
 * This class has three data members - to set up a connection between Model and View
 * 1)Model m - this class get a problem and generate a solution 
 * 2)View v - this class display solution and get commands from user
 * 3)HashMap<String,Command> hash - String: saved a command name, Command: generate the Command
 * 
 * 
 * @author Gal Ben Evgi & Gal Malca
 *
 */
public abstract class CommonPresenter implements Observer ,Presenter {

	protected Model m;
	protected View v;
	HashMap<String,Command> hash;
	
	/**
	 * default C'tor
	 * a new memory allocation for hash
	 * initialization all commands
	 */
	public CommonPresenter() {
		super();
		hash = new HashMap<String,Command>();
		initCommands();
	}
	/**
	 * set method
	 * A model
	 */
	@Override
	public void setModel(Model m) {
		this.m = m;
	}
	/**
	 * set method
	 * A view
	 */
	@Override
	public void setView(View v) {
		this.v = v;
	}
	/**
	 * get method
	 * hashMap
	 */
	@Override
	public HashMap<String, Command> getHash() {
		return hash;
	}
	
	
	
	
}
