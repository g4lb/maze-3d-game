package view;

import controller.Controller;

/**
 * <h1> Class CommonView </h1>
 * This class has the a data member by Controller type
 * with this data member we can:
 * 1)send objects to Controller
 * 2)generate a problem and solved it with Model via Controller
 * @author Gal Ben Evgi
 *
 */
public abstract class CommonView implements View{

	Controller ctr;
	
	/**
	 * C'tor that set the ctr
	 * @param ctr
	 */
	public CommonView(Controller ctr)
	{
		this.ctr = ctr;
	}

		

	

}
