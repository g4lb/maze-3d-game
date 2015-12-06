package io;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyCompressorOutputStream extends OutputStream {
	
	OutputStream out;
	static final int intro = 12;

	
	public MyCompressorOutputStream(OutputStream output){
		this.out = output;
	}
	
	public MyCompressorOutputStream() throws FileNotFoundException, IOException {
		out = new ObjectOutputStream(new FileOutputStream("out.txt"));
	}

	@Override
	public void write(int b) throws IOException {
		out.write((int)b);	
	}
	@Override
	public void write(byte[] b) throws IOException {
	//	out.write(b.length);
		for (int i = 0; i < intro; i++) {
			out.write(b[i]);			
		}
		for (int i = intro; i < b.length; i++) {
			out.write(b[i]);
		}
	}
	
}
