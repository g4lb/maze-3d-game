package boot;

import model.ClientHandler;
import model.Model;
import model.MyClientHandler;
import model.MyModel;
import model.MyServer;
import model.PropManager;
import presenter.MyPresenter;
import presenter.MyProperties;
import view.ServerGui;
import view.View;

public class RunServer {

	public static void main(String[] args) throws InterruptedException {
		MyProperties prop = new PropManager().loadProp();
		Model m = new MyModel(prop);
		final View v = new ServerGui();
		ClientHandler ch =new MyClientHandler();
		MyPresenter p = new MyPresenter(m,v,ch);
		m.addObserver(p);	
		ch.addObserver(p);
		v.addObserver(p);
		MyServer server = new MyServer(5555,ch);
		server.startServer();
		Thread.sleep(30*1000);
		server.stop();

	}

}
