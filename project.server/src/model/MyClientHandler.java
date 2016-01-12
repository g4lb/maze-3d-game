package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Observable;

import presenter.MyPresenter;

public class MyClientHandler extends Observable implements ClientHandler {
	
	private ObjectOutputStream out;
	MyPresenter p;
	ArrayList<String> userCommand;
	
	
	
	public ArrayList<String> getUserCommand() {
		return userCommand;
	}

	public MyClientHandler() {
		userCommand = new ArrayList<>();
	}
	
	public void writeWithOut(Object o) {
		try {
			out.writeObject(o);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void handleClient(InputStream inFromClient, OutputStream outToClient) {
		BufferedReader in = new BufferedReader(new InputStreamReader(inFromClient));
		try {
			out = new ObjectOutputStream(outToClient);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String line,line2;
		ArrayList<String> arr = new ArrayList<>();
		try{
			while(!(line = in.readLine()).equals("exit")) {
				line2 = line.substring(1);
				StringBuilder sb = new StringBuilder(line2);
				sb.deleteCharAt(sb.length()-1);
				line = sb.toString();
				String [] items = line.split(",");
				for (String string : items) {
					arr.add(string.trim());
				}
				userCommand.clear();
				userCommand.addAll(arr);
				setChanged();	
				notifyObservers();
				userCommand.clear();
				out.writeObject(p.getData());				
				out.flush();
				

			}
			out.flush();
		}catch(Exception e){}

	}

}
