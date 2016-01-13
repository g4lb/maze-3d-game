package model;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Observable;

import algorithms.search.Solution;
import io.MyCompressorOutputStream;
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
		if(o.getClass().equals(Solution.class))
		{
			
		
			String s = o.toString();
			PrintWriter outToClient = new PrintWriter(out);
			outToClient.println(s);
			outToClient.flush();
			
		}
		else
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
		String line,line2;
		ArrayList<String> arr = new ArrayList<>();
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
				arr.clear();
				userCommand.clear();
				out.flush();
				

			}
		}catch(Exception e){}

	}

}
