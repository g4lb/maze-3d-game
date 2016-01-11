package view;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class ConnectionWindow extends BasicWindow {
	

	ArrayList<String> arr;
	
	public ConnectionWindow(String title, int width, int height) {
		super(title, width, height);
		arr = new ArrayList<String>();
	}

	@Override
	void initWidgets() {
		shell.setLayout(new GridLayout(2,true));
		shell.setBackgroundImage(new Image(display, "./resources/Web-server.png"));
		
		final Label ipServer=new Label(shell,SWT.NONE);
		ipServer.setText("IP SERVER:");
		ipServer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		
		final Text t = new Text(shell, SWT.BORDER);
		t.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		
		
		
		final Label portServer=new Label(shell,SWT.NONE);
		portServer.setText("PORT SERVER:");
		portServer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		
		final Text t1 = new Text(shell, SWT.BORDER);
		t1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		
		
		final Button connectToServer = new Button(shell, SWT.PUSH);
		connectToServer.setText("Connect!");
		connectToServer.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, false, true, 2, 1));
		
		connectToServer.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				arr.add(t.getText());
				arr.add(t1.getText());
				shell.close();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {	
			}
		});
		
		
		
		
	
		

	}
	public void start() {
		this.run();
		
	}
	public static void main(String[] args) {
		ConnectionWindow g = new ConnectionWindow("sadf", 250, 250);
		g.run();
	}

	public ArrayList<String> getArr() {
		return arr;
	}

}
