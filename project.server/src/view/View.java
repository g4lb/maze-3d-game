package view;

import java.util.Observer;

import presenter.MyPresenter;

public interface View {
	
	public void start();
	public void stop();
	public void addClient();
	void addObserver(Observer p);

}
