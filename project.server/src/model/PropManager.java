package model;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import presenter.MyProperties;

public class PropManager {
	
	MyProperties prop;
	XMLDecoder decoder;
	XMLEncoder encoder;
	File myFile;

	public PropManager() {
	}
	
	
	public MyProperties getProp() {
		return prop;
	}


	public void setProp(MyProperties prop) {
		this.prop = prop;
	}


	public XMLDecoder getDecoder() {
		return decoder;
	}


	public void setDecoder(XMLDecoder decoder) {
		this.decoder = decoder;
	}


	public XMLEncoder getEncoder() {
		return encoder;
	}


	public void setEncoder(XMLEncoder encoder) {
		this.encoder = encoder;
	}


	public File getMyFile() {
		return myFile;
	}


	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}


	public Properties readProp(String path) throws FileNotFoundException {
		XMLDecoder decod = new XMLDecoder(new BufferedInputStream(new FileInputStream(path)));
		Properties proper = (Properties) decod.readObject();
		decod.close();
		return proper;
	}
	
	public void writeProp(Properties proper,String fileName) throws FileNotFoundException {
		XMLEncoder encod = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fileName)));
		encod.writeObject(proper);
		encod.flush();
		encod.close();
	}
	
	public MyProperties loadProp() {
		myFile = new File("properties.xml");
		try
		{
			if(!myFile.createNewFile())
			{
				this.decoder = new XMLDecoder(new BufferedInputStream( new FileInputStream(myFile)));
				prop = (MyProperties) decoder.readObject();
				decoder.close();
			}
			else
			{
				this.prop = new MyProperties();
				this.encoder = new XMLEncoder(new FileOutputStream("properties.xml"));
				encoder.writeObject(prop);
				encoder.flush();
				encoder.close();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return prop;
	}
	
	
	
}
