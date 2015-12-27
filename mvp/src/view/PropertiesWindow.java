package view;
import java.io.BufferedReader;
import java.io.FileReader;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Text;

public class PropertiesWindow extends BasicWindow {
		
		String fileName;
		Text art;
	

	public PropertiesWindow(String title, int width, int height) {
		super(title, width, height);
	}

	@Override
	void initWidgets() {
		
		shell.setLayout(new GridLayout(1,false));
		
		Combo ui= new Combo(this.shell,SWT.PUSH);
		ui.setText("unit interface");
		ui.setLayoutData(new GridData(SWT.FILL,SWT.FILL,false,false,1,1));
		
		ui.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
			
			FileDialog fd = new FileDialog(shell,SWT.OPEN);
			fd.setText("open");
			fd.setFilterPath("");
			String[] filterExt = {"*.jpg","*.bmp","*.png","*.jpeg","*.*"};
			fd.setFilterExtensions(filterExt);
			fileName = fd.open();
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		art = new Text(shell, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		art.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true,1,3));
		
		Button convert= new Button(this.shell,SWT.PUSH);
		convert.setText("convert to ASCII art");
		convert.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false,1,1));
		
		convert.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
//				if(fileName!=null)
//						//ctr.convert(fileName);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
		
		Button font= new Button(this.shell,SWT.PUSH);
		font.setText("set font");
		font.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false,1,1));
		
		font.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	
		
	}

	public void display(String fileName)  {
		try {
		
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		String line;
		art.setText("");
		while((line=in.readLine())!= null)
			art.append(line+"\n");
		in.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	
	public void start() {
		this.run();
		
	}



}
