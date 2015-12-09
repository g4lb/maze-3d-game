package boot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

import controller.Command;
import controller.MyCommand;
import controller.MyCommand2;
import controller.MyCommand3;
import controller.MyCommand4;
import view.CLI;

/**
 * Class Run to test CLI
 * @author Gal Ben Evgi
 *
 */
public class Run {

	public static void main(String[] args) {
		//CLI ui = new CLI(new MyCommand());
		//ui.start();
		
		HashMap<String,Command> test = new HashMap<String,Command>();
		Command print = new MyCommand();
		Command calc = new MyCommand2();
		Command write = new MyCommand3();
		Command learn = new MyCommand4();
		test.put("print", print);
		test.put("calculate", calc);
		test.put("writing", write);
		test.put("learning", learn);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
		PrintWriter out = new PrintWriter(System.out); 

		CLI ui = new CLI(in,out,test);
		
		
		ui.run();
		
		
		

	}

}
