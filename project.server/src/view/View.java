package view;

import java.net.Socket;
import java.util.Observer;

import presenter.MyPresenter;

public interface View {
	
	public void start();
	public void stop();
	public void addClient(Socket socket);
	public void removeClient(Socket socket);
	void addObserver(Observer p);

}
