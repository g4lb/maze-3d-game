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

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Solution;
import algorithms.search.State;

public class GUI extends CommonView {
	
	PropertiesWindow prop;
	ArrayList<String> userCommand;
	GenerateWindow generateWindow;
	MazeWindow mazeWindow;
	int [][][] clearMaze; 
	MazeDisplayer maze;
	Timer timer;
	TimerTask task;
	String nameOfThisMaze;
	
	
	public GUI() {
		prop = new PropertiesWindow("Properties", 250, 250);
		userCommand = new ArrayList<String>();
		prop.run();
		userCommand = prop.arr;
		clearMaze = new int[1][20][20];
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < 20; j++) {
				for (int j2 = 0; j2 < 20; j2++) {
					clearMaze[i][j][j2] = 0;
				}
			}
		}
	}
	
	@Override
	public void start() {
		generateWindow = new GenerateWindow("generate", 250, 250);
		generateWindow.run();
		userCommand = generateWindow.arr;
		
		new BasicWindow("Maze3d", 600, 500) {
			
			
			@Override
			void initWidgets() {
				{
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
					
					
					
					
						
					maze=new Maze3D(shell, SWT.BORDER);
					maze.setMaze(new Maze3d(1, 20, 20));
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
											//randomWalk(maze);
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
							nameOfThisMaze = userCommand.get(0);
							userCommand.add(0,"generateMaze");
							setChanged();
							notifyObservers();	
							userCommand.remove(0);
							userCommand.add(0,"displayMaze");
							setChanged();
							notifyObservers();
							timer = new Timer();
							task = new TimerTask() {
								
								@Override
								public void run() {
									display.syncExec( new Runnable() {
										public void run() {
											maze.redraw();
											maze.forceFocus();
										}
									});
								}
							};
							timer.scheduleAtFixedRate(task, 0, 3);
						}
						@Override
						public void widgetDefaultSelected(SelectionEvent arg0) {}
					});
					
					displaySol.addSelectionListener(new SelectionListener() {
						
						@Override
						public void widgetSelected(SelectionEvent arg0) {
							userCommand.clear();
							userCommand.add("solveMaze");
							userCommand.add(nameOfThisMaze);
							setChanged();
							notifyObservers();
							userCommand.clear();
							userCommand.add("displaySolution");
							userCommand.add(nameOfThisMaze);
							setChanged();
							notifyObservers();
							timer = new Timer();
							task = new TimerTask() {
								
								@Override
								public void run() {
									display.syncExec( new Runnable() {
										public void run() {
											maze.redraw();
											maze.forceFocus();
										}
									});
								}
							};
							timer.scheduleAtFixedRate(task, 0, 5);	
							};
						
						
						@Override
						public void widgetDefaultSelected(SelectionEvent arg0) {
						}
					});
					
				}
				
			}
		}.run();;
		
	}

	@Override
	public void displayDir(ArrayList<String> results) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayMazeReady(String str) {
		// TODO Auto-generated method stub
		
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

	@Override
	public void MazeByByteArray(byte[] array) {
		Maze3d m = new Maze3d(array);
		maze.setMaze(m);
		
	}

	@Override
	public void displaySolution(Solution sol) {
		maze.solution = sol;
		maze.printSolution();
		
	}


}
