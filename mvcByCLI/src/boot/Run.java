package boot;

import controller.MyCommand;
import view.CLI;

public class Run {

	public static void main(String[] args) {
		CLI ui = new CLI(new MyCommand());
		ui.start();

	}

}
