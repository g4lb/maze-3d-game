package view;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import algorithms.mazeGenerators.Maze3d;

public class GUI extends CommonView {
	
	Timer timer;
	TimerTask task;
	Shell GUIshell;
	Display GUIdisplay;
	PropertiesWindow prop;
	MazeDisplayer maze;
	ArrayList<String> userCommand;
	GenerateWindow generateWindow;
	String nameOfThisMaze;
	
	public GUI() {
		prop = new PropertiesWindow("Properties Window",750,750);
		userCommand = new ArrayList<String>();
		prop.start();
		userCommand = prop.getChoice();
	}
	

	@Override
	public void start() {
		
		generateWindow = new GenerateWindow("generate", 250, 250); 
		generateWindow.run(); 
		userCommand = generateWindow.getChoice(); 
		


		
		new BasicWindow("Maze3D Game",750,750) {
			
			@Override
			void initWidgets() {
			
				shell.setLayout(new GridLayout(4,true));
				
				GUIshell = shell; //shell of basic window
				GUIdisplay = display; //display of basic window
				
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
				//generate.setEnabled(false);
				
				generate.addSelectionListener(new SelectionListener() {
					
					@Override
					public void widgetSelected(SelectionEvent arg0) {
						
							new Thread(new Runnable() {
							
							
							@Override
							public void run() {
								generateWindow = new GenerateWindow("Generate Window",400,400);
								generateWindow.run();
								userCommand = generateWindow.getChoice();
								nameOfThisMaze = userCommand.get(0);
								userCommand.add(0,"generateMaze");
							}
							
						}).start();
							setChanged();
							notifyObservers();	
				}
					
					@Override
					public void widgetDefaultSelected(SelectionEvent arg0) {}
					
				}
				);
				
				final Button displaySol=new Button(shell, SWT.PUSH);
				displaySol.setText("Display Solution");
				displaySol.setLayoutData(new GridData(SWT.FILL, SWT.None, false, false, 2, 1));
				//displaySol.setEnabled(false);
				
				final Button newPro=new Button(shell, SWT.PUSH);
				newPro.setText("New Properties");
				newPro.setLayoutData(new GridData(SWT.FILL, SWT.None, false, false, 2, 1));
				//newPro.setEnabled(false);
				
				
				final Button help=new Button(shell, SWT.PUSH);
				help.setText("Help");
				help.setLayoutData(new GridData(SWT.FILL, SWT.None, false, false, 2, 1));
				//help.setEnabled(false);
				
				final Button exit=new Button(shell, SWT.PUSH);
				exit.setText("Exit");
				exit.setLayoutData(new GridData(SWT.FILL , SWT.None, true, false, 4, 1));
				//exit.setEnabled(false);
				
				
				
				
				//MazeDisplayer maze=new Maze2D(shell, SWT.BORDER);		
				final MazeDisplayer maze=new Maze3D(shell, SWT.BORDER);
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
										nameOfThisMaze = userCommand.get(0);
										userCommand.add(0,"generateMaze");
										setChanged();
										notifyObservers();
										userCommand.remove(0);
										userCommand.add(0,"displayMaze");
										setChanged();
										notifyObservers();
										
										
										

										
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
	
			}
		}.run();;
		

	
		
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
	public void displayDir(ArrayList<String> results) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayMazeReady(String str) {
	    
	    MessageBox messageBox = new MessageBox(GUIshell, SWT.OK);
	    messageBox.setMessage(str);
	    messageBox.open();
	    //GUIdisplay.dispose();
		
	}

	@Override
	public void displayListOfNamesOfMaze(ArrayList<String> names) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayError(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display3dmaze(int[][][] arr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayCrossSection(int[][] mat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayMazeSaved(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayMazeLoaded(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displaySolveMaze(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displaySolution(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayFileSize(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayMazeSize(String string) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public ArrayList<String> getUserCommand() {
		return userCommand;
	}
	public Shell getShell() {
		return GUIshell;
	}


	public void setShell(Shell shell) {
		this.GUIshell = shell;
	}


	public Display getDisplay() {
		return GUIdisplay;
	}


	public void setDisplay(Display display) {
		this.GUIdisplay = display;
	}


	@Override
	public void mazeByByteArray(byte[] data3) {
		Maze3d m = new Maze3d(data3);
		maze.setMaze(m);
		
		
	}




}
