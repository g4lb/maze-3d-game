package view;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;

public class GenerateWindow extends BasicWindow {

	ArrayList<Text> testlist;
	ArrayList<String> choice;
	
	public ArrayList<String> getChoice() {
		return choice;
	}

	public void setChoice(ArrayList<String> choice) {
		this.choice = choice;
	}

	public GenerateWindow(String title, int width, int height) {
		super(title, width, height);
		testlist = new ArrayList<Text>();
		choice = new ArrayList<String>();
	}

	@Override
	void initWidgets() {
		shell.setLayout(new GridLayout(2,true));
		
		final Text mazeName=new Text(shell,SWT.Activate);
		mazeName.setText("mazeName:");
		testlist.add(new Text(shell, SWT.BORDER));
		
		
		final Text floors=new Text(shell,SWT.Activate);
		floors.setText("number of floors:");
		testlist.add(new Text(shell, SWT.BORDER));
		
		
		final Text columns=new Text(shell,SWT.Activate);
		columns.setText("columns:");
		testlist.add(new Text(shell, SWT.BORDER));
		
		
		final Text rows=new Text(shell,SWT.Activate);
		rows.setText("rows:");
		testlist.add(new Text(shell, SWT.BORDER));
		
		
		
		final Button ok = new Button(shell, SWT.PUSH);
		ok.setText("OK");
		
		final Button defualt = new Button(shell, SWT.PUSH);
		defualt.setText("Defualt Options");
		
		defualt.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
			choice.add("gal");
			choice.add("4");
			choice.add("5");
			choice.add("5");
			shell.close();
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {	
			}
		});
	
	

		

	}
	
	public static void main(String[] args) {
		GenerateWindow win=new GenerateWindow("Generate Window",325, 200);
		win.run();
	}

}
