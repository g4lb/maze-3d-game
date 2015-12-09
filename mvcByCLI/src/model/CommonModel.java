package model;

import controller.Controller;

public abstract class CommonModel implements Model {

	Controller ctr;
	
	

	public CommonModel(Controller ctr2) {
		this.ctr = ctr2;
	}
	
}
