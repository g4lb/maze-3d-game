package view;


import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Solution;
import algorithms.search.State;

public class GUI extends CommonView  {
	
	PropertiesWindow prop;
	ArrayList<String> userCommand;
	GenerateWindow generateWindow;
	ConnectionWindow connectionWindow;
	MazeWindow mazeWindow;
	int [][][] clearMaze; 
	MazeDisplayer maze;
	Timer timer;
	TimerTask task;
	String nameOfThisMaze;
	String fileName;
	
	
	public GUI() {
		userCommand = new ArrayList<String>();
		connectionWindow = new ConnectionWindow("Connect To Server", 250,250);
		connectionWindow.run();
		userCommand = connectionWindow.getArr();
		prop = new PropertiesWindow("Properties", 250, 250);
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
		generateWindow = new GenerateWindow("generate", 300, 250);
		generateWindow.run();
		userCommand = generateWindow.arr;
		
		new BasicWindow("Maze3d", 1030, 685) {
			
			
			@Override
			void initWidgets() {
				{
					shell.setLayout(new GridLayout(4,true));
					
					




					

					final Button generate=new Button(shell, SWT.PUSH);
					generate.setText("Generate");
					generate.setLayoutData(new GridData(SWT.FILL, SWT.None, false, false, 2, 1));
					
					
					final Button displaySol=new Button(shell, SWT.PUSH);
					displaySol.setText("Display Solution");
					displaySol.setLayoutData(new GridData(SWT.FILL, SWT.None, false, false, 2, 1));

					
					final Button newPro=new Button(shell, SWT.PUSH);
					newPro.setText("New Properties");
					newPro.setLayoutData(new GridData(SWT.FILL, SWT.None, false, false, 2, 1));
		
					final Button solve=new Button(shell, SWT.PUSH);
					solve.setText("Solve");
					solve.setLayoutData(new GridData(SWT.FILL, SWT.None, false, false, 2, 1));
					
					
					
					
				
					maze=new Maze2D(shell, SWT.BORDER | SWT.DOUBLE_BUFFERED);
					maze.setMaze(new Maze3d(1, 20, 20));
					maze.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,true,4,1));
					
					Menu menuBar = new Menu(shell, SWT.BAR);
					Menu fileMenu = new Menu(menuBar);

					MenuItem fileItem = new MenuItem(menuBar, SWT.CASCADE);
				    fileItem.setText("File");
				    fileItem.setMenu(fileMenu);
				    
				    
				    MenuItem openItem = new MenuItem(fileMenu, SWT.NONE);
				    openItem.setText("Open...");
				    MenuItem saveItem = new MenuItem(fileMenu, SWT.NONE);
				    saveItem.setText("Save");
				    MenuItem exit = new MenuItem(fileMenu, SWT.NONE);
				    exit.setText("Exit");

				    shell.setMenuBar(menuBar);
				    shell.open();
				    
				    saveItem.addSelectionListener(new SelectionListener() {
						
						@Override
						public void widgetSelected(SelectionEvent arg0) {
							
							new Thread(new Runnable() {
								
								@Override
								public void run() {
									userCommand.clear();
									userCommand.add("saveMaze");
									userCommand.add(nameOfThisMaze);
									new BasicWindow("Save",250,100) {
										
										@Override
										void initWidgets() {
											
											shell.setLayout(new GridLayout(2,true));
											final Label filename=new Label(shell,SWT.NONE);
											filename.setText("file Name:");
											filename.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
											
											final Text t = new Text(shell, SWT.BORDER);
											t.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
											
											final Button ok = new Button(shell, SWT.PUSH);
											ok.setText("OK");
											ok.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, false, 1, 1));
											
											ok.addSelectionListener(new SelectionListener(){
												
												@Override
												public void widgetSelected(SelectionEvent arg0) {
																			
													userCommand.add(t.getText());
													shell.close();
												}
												
												@Override
												public void widgetDefaultSelected(SelectionEvent arg0) {	
												}
											});	
										}}.run();
											setChanged();
											notifyObservers();
								
								}}).start();
							
						}
					
						@Override
						public void widgetDefaultSelected(SelectionEvent arg0) {}
					});
					
					openItem.addSelectionListener(new SelectionListener() {
						
						@Override
						public void widgetSelected(SelectionEvent arg0) {
							new Thread(new Runnable() {
								
								@Override
								public void run() {
									new BasicWindow("Load",250,100) {
										
										@Override
										void initWidgets() {
											shell.setLayout(new GridLayout(2,true));
											final Label mazeName=new Label(shell,SWT.NONE);
											mazeName.setText("maze Name:");
											mazeName.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
											
											final Text t = new Text(shell, SWT.BORDER);
											t.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
											
											final Button ok = new Button(shell, SWT.PUSH);
											ok.setText("OK");
											ok.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, false, 1, 1));
											
											ok.addSelectionListener(new SelectionListener(){
												
												@Override
												public void widgetSelected(SelectionEvent arg0) {
																			
													nameOfThisMaze=t.getText();
													FileDialog fd = new FileDialog(shell,SWT.OPEN);
													fd.setText("Open");
													fd.setFilterPath(""); //Correct folder
													String[] filterExt = {"*.*"};
													fd.setFilterExtensions(filterExt); //add to path
													
													fileName = fd.open(); //open the dialog - if the string is not null - nivhar kovetz	
													
													shell.close();
												}
												
												@Override
												public void widgetDefaultSelected(SelectionEvent arg0) {	
												}
											});	
										}}.run();

											String fname= fileName;
									        String split[]  = fname.split("\\\\");
									        String split2[] = split[split.length-1].split(".maz");
									     			
											userCommand.clear();
											userCommand.add("loadMaze");
											userCommand.add(split2[0]);
											userCommand.add(nameOfThisMaze);
											setChanged();
											notifyObservers();
											
											userCommand.clear();
											userCommand.add(0,"displayMaze");
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
															maze.setFocus();
														}
													});
												}
											};
											timer.scheduleAtFixedRate(task, 0, 10000);
			
									}
	
							}
							).start();
							
						}
						
						@Override
						public void widgetDefaultSelected(SelectionEvent arg0) {}
					});
				    
					maze.addKeyListener(new KeyListener() {
						
						@Override
						public void keyReleased(KeyEvent arg0) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void keyPressed(KeyEvent e) {
							if (e.keyCode == SWT.PAGE_UP)
							{
								maze.moveUp();
							}
							if (e.keyCode == SWT.PAGE_DOWN)
							{
								maze.moveDown();
							}
							if (e.keyCode == SWT.ARROW_LEFT)
							{
								maze.moveLeft();
							}
							if (e.keyCode == SWT.ARROW_RIGHT)
							{
								maze.moveRight();
							}
							if (e.keyCode == SWT.ARROW_UP)
							{
								maze.moveForword();
							}
							if (e.keyCode == SWT.ARROW_DOWN)
							{
								maze.moveBackward();
							}
							
						}
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
											maze.setFocus();
										}
									});
								}
							};
							timer.scheduleAtFixedRate(task, 0, 10000);
						}
						@Override
						public void widgetDefaultSelected(SelectionEvent arg0) {}
					});
					
					displaySol.addSelectionListener(new SelectionListener() {
						
						@Override
						public void widgetSelected(SelectionEvent arg0) {
							userCommand.clear();
							userCommand.add("setCorrect");
							userCommand.add(nameOfThisMaze);
							userCommand.add(maze.maze.getCorrect().toString());
							setChanged();
							notifyObservers();
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
							};
						
						
						@Override
						public void widgetDefaultSelected(SelectionEvent arg0) {}
					});
					
					exit.addSelectionListener(new SelectionListener() {
						
						@Override
						public void widgetSelected(SelectionEvent arg0) {
							userCommand.clear();
							userCommand.add("exit");
							setChanged();
							notifyObservers();
						}
						
						@Override
						public void widgetDefaultSelected(SelectionEvent arg0) {}
					});
					
					
					newPro.addSelectionListener(new SelectionListener() {
						
						
						@Override
						public void widgetSelected(SelectionEvent arg0) {									
							userCommand.clear();
							new Thread(new Runnable() {
								
								@Override
								public void run() {
									GenerateWindow gw = new GenerateWindow("Generate Windows",250,250);
									gw.run();
									nameOfThisMaze = gw.arr.get(0);
									userCommand = gw.arr;
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
									timer.scheduleAtFixedRate(task, 0, 10000);		
								}
							}).start();														
						}
						
						@Override
						public void widgetDefaultSelected(SelectionEvent arg0) {
							// TODO Auto-generated method stub
							
						}
					});
				solve.addSelectionListener(new SelectionListener() {
						
						@Override
						public void widgetSelected(SelectionEvent arg0) {
							
							for(int i = maze.solution.getArr().size()-1;i >= 0;i--){
								final State<Position> p = maze.solution.getArr().remove(i);		
								display.syncExec(new Runnable() {
									
									@Override
									public void run() {
										maze.setCharacterPosition(p);
										maze.redraw();
										
									}
								});
										
								
								
						
							}
						}	
						
						@Override
						public void widgetDefaultSelected(SelectionEvent arg0) {}
					});
				}
				
			}
		}.run();
		
	}

	@Override
	public void displayDir(ArrayList<String> results) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayMazeReady(String str) {
		//TODO
	}

	@Override
	public void displayListOfNamesOfMaze(ArrayList<String> names) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayError(final String string) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				Display dis = new Display();
				Shell shell = new Shell(dis);
				MessageBox ms = new MessageBox(shell, SWT.ERROR);
				ms.setMessage(string);
				ms.setText("Error");
				ms.open();
				
			}
		}).start();
				
	
		
		
	}

	@Override
	public void display3dmaze(int[][][] arr) {
		
	
	}

	@Override
	public void displayCrossSection(int[][] mat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayMazeSaved(final String string) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				Display dis = new Display();
				Shell shell = new Shell(dis);
				MessageBox ms = new MessageBox(shell, SWT.OK);
				ms.setMessage(string);
				ms.setText("Message");
				ms.open();
				
			}
		}).start();
		
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
		maze.removeSol();
		
	}

	@Override
	public void displaySolution(Solution sol) {
		maze.solution = sol;
		maze.printSolution();
		
	}

	@Override
	public void displayMessage(final String string) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				Display dis = new Display();
				Shell shell = new Shell(dis);
				MessageBox ms = new MessageBox(shell, SWT.OK);
				ms.setMessage(string);
				ms.setText("Message");
				ms.open();
				
			}
		}).start();
		
	}
	


}
