package controller;

import java.util.HashMap;

import model.Model;
import view.View;

public abstract class CommonController implements Controller {

	protected Model m;
	protected View v;
	HashMap<String,Command> hash;
	
	
	public CommonController() {
		super();
		hash = new HashMap<String,Command>();
		initCommands();
	}
	@Override
	public void setModel(Model m) {
		this.m = m;
		
	}

	@Override
	public void setView(View v) {
		this.v = v;
		
	}
	@Override
	public HashMap<String, Command> getHash() {
		return hash;
	}
	
	
	
	
}
