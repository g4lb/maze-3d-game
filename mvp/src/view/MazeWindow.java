package view;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;

public class MazeWindow extends BasicWindow{

	Timer timer;
	TimerTask task;
	
	
	public MazeWindow(String title, int width, int height) {
		super(title, width, height);
		
	}

	private void randomWalk(MazeDisplayer maze){
		Random r=new Random();
		boolean b1,b2;
		b1=r.nextBoolean();
		b2=r.nextBoolean();
		if(b1&&b2)
			maze.moveUp();
		if(b1&&!b2)
			maze.moveDown();
		if(!b1&&b2)
			maze.moveRight();
		if(!b1&&!b2)
			maze.moveLeft();
		
		maze.redraw();
	}
	
	@Override
	void initWidgets() {
		shell.setLayout(new GridLayout(4,true));
		
		final Button startButton=new Button(shell, SWT.PUSH);
		startButton.setText("Start");
		startButton.setLayoutData(new GridData(SWT.FILL, SWT.None, false,false, 2, 1));
				
		
		final Button stopButton=new Button(shell, SWT.PUSH);
		stopButton.setText("Stop");
		stopButton.setLayoutData(new GridData(SWT.FILL, SWT.None, false, false, 2, 1));
		stopButton.setEnabled(false);
		
		final Button generate=new Button(shell, SWT.PUSH);
		generate.setText("Generate");
		generate.setLayoutData(new GridData(SWT.FILL, SWT.None, false, false, 2, 1));

		
		final Button displaySol=new Button(shell, SWT.PUSH);
		displaySol.setText("Display Solution");
		displaySol.setLayoutData(new GridData(SWT.FILL, SWT.None, false, false, 2, 1));

		
		final Button newPro=new Button(shell, SWT.PUSH);
		newPro.setText("New Properties");
		newPro.setLayoutData(new GridData(SWT.FILL, SWT.None, false, false, 2, 1));
		
		
		
		final Button help=new Button(shell, SWT.PUSH);
		help.setText("Help");
		help.setLayoutData(new GridData(SWT.FILL, SWT.None, false, false, 2, 1));
		
		
		final Button exit=new Button(shell, SWT.PUSH);
		exit.setText("Exit");
		exit.setLayoutData(new GridData(SWT.FILL , SWT.None, true, false, 4, 1));
		
		
		
		
		
		final MazeDisplayer maze=new Maze2D(shell, SWT.BORDER);
		
		maze.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,true,4,1));
		
		
		
		
		startButton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				timer=new Timer();
				task=new TimerTask() {
					@Override
					public void run() {
						display.syncExec(new Runnable() {
							@Override
							public void run() {
								randomWalk(maze);
							}
						});
					}
				};				
				timer.scheduleAtFixedRate(task, 0, 100);				
				startButton.setEnabled(false);
				generate.setEnabled(false);
				displaySol.setEnabled(false);
				newPro.setEnabled(false);
				help.setEnabled(false);
				exit.setEnabled(false);
				stopButton.setEnabled(true);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
		});
		
		stopButton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				task.cancel();
				timer.cancel();
				startButton.setEnabled(true);
				generate.setEnabled(true);
				displaySol.setEnabled(true);
				newPro.setEnabled(true);
				help.setEnabled(true);
				exit.setEnabled(true);
				stopButton.setEnabled(false);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
		});
		
		generate.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	

}
