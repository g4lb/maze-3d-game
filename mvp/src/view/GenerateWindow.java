package view;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;

public class GenerateWindow extends BasicWindow {

	//ArrayList<Text> testlist;
	ArrayList<String> arr;
	
	public GenerateWindow(String title, int width, int height) {
		super(title, width, height);
		//testlist = new ArrayList<Text>();
		arr = new ArrayList<String>();
	}

	@Override
	void initWidgets() {
		shell.setLayout(new GridLayout(2,false));
		
		final Text mazeName=new Text(shell,SWT.Activate);
		mazeName.setText("mazeName:");
		arr.add(new Text(shell, SWT.BORDER).toString());
		
		
		final Text columns=new Text(shell,SWT.Activate);
		columns.setText("columns:");
		arr.add(new Text(shell, SWT.BORDER).toString());
		
		final Text rows=new Text(shell,SWT.Activate);
		rows.setText("rows:");
		arr.add(new Text(shell, SWT.BORDER).toString());
		
		final Text floors=new Text(shell,SWT.Activate);
		floors.setText("number of floors:");
		arr.add(new Text(shell, SWT.BORDER).toString());
		
		final Button ok = new Button(shell, SWT.PUSH);
		ok.setText("OK");
		
		ok.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				shell.close();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {	
			}
		});
		
		
		
		
		final Button defualt = new Button(shell, SWT.PUSH);
		defualt.setText("Defualt Options");
		
		defualt.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				arr.clear();
				arr.add("eli");
				arr.add("20");
				arr.add("20");
				arr.add("1");
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


}
