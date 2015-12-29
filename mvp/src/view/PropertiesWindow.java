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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class PropertiesWindow extends BasicWindow {
		
		String fileName;
		Text art;
		Label unitI, algo, solve;
	

	public PropertiesWindow(String title, int width, int height) {
		super(title, width, height);
	}

	@Override
	void initWidgets() {
		shell.setLayout(new GridLayout(2,true));
		
		unitI = new Label(shell, SWT.None);
		unitI.setText("Unit Interface:");
		unitI.setLayoutData(new GridData(SWT.FILL,SWT.FILL,false,false,1,1));
		
		
		final Combo ui= new Combo(this.shell,SWT.DROP_DOWN );
		ui.setText("");
		ui.setLayoutData(new GridData(SWT.FILL,SWT.NONE,true,false,2,1));
		String[] items = "GUI,CLI      ".split(",");
		ui.setItems(items);
		
		ui.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
			
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
		});
		
		algo = new Label(shell, SWT.None);
		algo.setText("Generate Algo:  ");
		algo.setLayoutData(new GridData(SWT.FILL,SWT.FILL,false,false,3,1));
		
		
		final Combo ag= new Combo(this.shell,SWT.DROP_DOWN);
		ag.setText("");
		ag.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false,4,1));
		String[] items1 = "DFS,Simple".split(",");
		ag.setItems(items1);
		
		ag.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
			
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
		});
		
		solve = new Label(shell, SWT.None);
		solve.setText("Solve Algo:   ");
		solve.setLayoutData(new GridData(SWT.FILL,SWT.FILL,false,false,5,1));
		
		
		final Combo sv= new Combo(this.shell,SWT.DROP_DOWN);
		sv.setText("");
		sv.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false,6,1));
		String[] items2 = "DFS,Astar   ".split(",");
		sv.setItems(items2);
		
		sv.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
		});
		
		Button ok= new Button(this.shell,SWT.PUSH);
		ok.setText("ok");
		ok.setLayoutData(new GridData(SWT.LEFT,SWT.BOTTOM,false,false,1,1));
		
		ok.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
		
		Button cancel= new Button(this.shell,SWT.PUSH);
		cancel.setText("cancel");
		cancel.setLayoutData(new GridData(SWT.RIGHT,SWT.BOTTOM,false,false,1,1));
		
		cancel.addSelectionListener(new SelectionListener() {
			
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

	public static void main(String[] args) {
		PropertiesWindow p = new PropertiesWindow("properties", 250, 250);
		p.run();
	}

}
