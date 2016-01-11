package view;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
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
		shell.setLayout(new GridLayout(2,true));
		
		final Label mazeName=new Label(shell,SWT.NONE);
		mazeName.setText("mazeName:");
		mazeName.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		
		final Text t = new Text(shell, SWT.BORDER);
		t.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		
		
		
		final Label columns=new Label(shell,SWT.NONE);
		columns.setText("columns:");
		columns.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		
		final Text t1 = new Text(shell, SWT.BORDER);
		t1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		
		final Label rows=new Label(shell,SWT.NONE);
		rows.setText("rows:");
		rows.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		
		final Text t2 = new Text(shell, SWT.BORDER);
		t2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		
		final Label floors=new Label(shell,SWT.NONE);
		floors.setText("number of floors:");
		floors.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		
		final Text t3 = new Text(shell, SWT.BORDER);;
		t3.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		
		final Button ok = new Button(shell, SWT.PUSH);
		ok.setText("OK");
		ok.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, false, 1, 1));
		
		ok.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				arr.add(t.getText());
				arr.add(t1.getText());
				arr.add(t2.getText());
				arr.add(t3.getText());
				shell.close();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {	
			}
		});
		
		
		
		
		final Button defualt = new Button(shell, SWT.PUSH);
		defualt.setText("Defualt Options");
		defualt.setLayoutData(new GridData(SWT.RIGHT, SWT.BOTTOM, false, false, 1, 1));
		
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
	public static void main(String[] args) {
	//	GenerateWindow g = new GenerateWindow("sadf", 250, 250);
	//	g.run();
	}

}
