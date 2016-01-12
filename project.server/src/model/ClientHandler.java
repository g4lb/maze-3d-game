package model;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Observer;

public interface ClientHandler {

	public void handleClient(InputStream inFromClient,OutputStream outToClient);

	void addObserver(Observer p);
	
	public void writeWithOut(Object o);

	public ArrayList<String> getUserCommand();
	
}
