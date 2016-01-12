package view;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

import algorithms.mazeGenerators.Position;
import algorithms.search.State;

public class Maze2D extends MazeDisplayer{

	
	Position correct,goal,start,walkToGoal;
	int flag = 0  ;
	Image backgroundImg, playerImg, finishImg,solutionImg, wallImg, wallpaperImg,goalImg;
	int sizeOfSolution;
	Timer timer;
	TimerTask task;


	 public Maze2D(Composite parent,int style){
	        super(parent, SWT.DOUBLE_BUFFERED);	
			//final Color white=new Color(null, 255, 255, 255);
			//final Color black=new Color(null, 150,150,150);
			backgroundImg = new Image(this.getDisplay(),"./resources/legends.png");
			playerImg = new Image(getDisplay(),"./resources/player.png");
			solutionImg = new Image(getDisplay(),"./resources/solution.gif");
			wallImg = new Image(getDisplay(), "./resources/wall.jpg");
			wallpaperImg = new Image(getDisplay(), "./resources/wallpaper.jpg");
			finishImg = new Image(getDisplay(), "./resources/finish.png");
			goalImg = new Image(getDisplay(), "./resources/goal.jpg");
			setBackgroundImage(backgroundImg);   
			start = new Position(0, 0, 0);
			correct = new Position(0, 0, 0);
			goal = new Position(0, 0, 0);
	    	//setBackground(new Color(null, 255, 255, 255));
	    	addPaintListener(new PaintListener() {
				
				@Override
				public void paintControl(PaintEvent e) {
					try{
						if(!maze.getGoal().equals(new Position(0, 0, 0))){
							goal = maze.getGoal();
							start = maze.getStart();
							correct = maze.getCorrect();
							setBackgroundImage(wallpaperImg);
						}
						}catch (Exception e2) {
						}
					 
					 
					   
					   int width=getSize().x;
					   int height=getSize().y;
					   
					   int w=width/mazeData[0][0].length;
					   int h=height/mazeData[0].length;
					   
					   for(int i=0;i<mazeData[correct.getZ()].length;i++)
					      for(int j=0;j<mazeData[correct.getZ()][i].length;j++){
					          int x=j*w;
					          int y=i*h;
					          if(mazeData[correct.getZ()][i][j]!=0){					          
					          	e.gc.drawImage(wallImg, 0, 0, wallImg.getBounds().width,wallImg.getBounds().height,x,y,w,h);
				          }
					       //goalImg
					       if(correct.equals(goal)&&!start.equals(correct)){					        
						         e.gc.drawImage(goalImg, 0, 0, goalImg.getBounds().width,goalImg.getBounds().height, 0, 0, getSize().x, getSize().y);		
						        	 
							     }       
				          //for solution
				          if(flag==1){
				        	  @SuppressWarnings("rawtypes")
							ArrayList<State> arr = solution.getArr();
				        	
				        	  for(int k = 0;k<arr.size();k++){
				        		  if(solution.getArr().get(k).getState().equals(new Position(j,i,correct.getZ()))&&!solution.getArr().get(k).getState().equals(goal)){				
				        		  e.gc.drawImage(solutionImg, 0, 0, solutionImg.getBounds().width,solutionImg.getBounds().height,x,y,w,h);
				        		  }
				          }}
				          //finishImg
				          if(i==goal.getY() && j==goal.getX() && goal.getZ()==correct.getZ() && !goal.equals(correct)){
				        	  e.gc.drawImage(finishImg, 0, 0, finishImg.getBounds().width,finishImg.getBounds().height,x,y,w,h);			        	  
				          }
				          //playerImg
				          if(i==correct.getY() && j==correct.getX()&& !goal.equals(new Position(0, 0, 0))){
				        	   e.gc.drawImage(playerImg, 0, 0, playerImg.getBounds().width,playerImg.getBounds().height,x,y,w,h);
				          }
				          
				        
					      }}
				});
	 }


	 public void moveCharacter(int x,int y,int z){
				correct.setX(x);
				correct.setY(y);
				correct.setZ(z);
				redraw();
	
		}
	public void moveCharacter(State<Position> p){
		correct.setX(p.getState().getX());
		correct.setY(p.getState().getY());
		correct.setZ(p.getState().getZ());			
		
		

		redraw();
	}
		@Override
		public void printSolution() {
			this.flag = 1;
			redraw();
		}
		
		
		/* (non-Javadoc)
		 * @see view.MazeDisplayer#moveUp()
		 */
		@Override
		public void moveUp() {
			Position up = new Position(maze.getCorrect());
			up.setZ(up.getZ()+1);
			if(maze.cellValueReal(up)&&maze.cellValue(up)!=1)
			{
			correct.setZ(correct.getZ()+1);
			moveCharacter(correct.getX(),correct.getY(),correct.getZ());
			}
		}
		/* (non-Javadoc)
		 * @see view.MazeDisplayer#moveDown()
		 */
		@Override
		public void moveDown() {
			Position down = new Position(maze.getCorrect());
			down.setZ(down.getZ()-1);
			if(maze.cellValueReal(down)&&maze.cellValue(down)!=1)
			{
				correct.setZ(correct.getZ()-1);
				moveCharacter(correct.getX(),correct.getY(),correct.getZ());
			}
		}
		/* (non-Javadoc)
		 * @see view.MazeDisplayer#moveLeft()
		 */
		@Override
		public void moveLeft() {
			Position left = new Position(maze.getCorrect());
			left.setX(left.getX()-1);
			if(maze.cellValueReal(left)&&maze.cellValue(left)!=1)
			{
				correct.setX(correct.getX()-1);
				moveCharacter(correct.getX(),correct.getY(),correct.getZ());
			
			}
		
		}
		/* (non-Javadoc)
		 * @see view.MazeDisplayer#moveRight()
		 */
		@Override
		public void moveRight() {
			Position right = new Position(maze.getCorrect());
			right.setX(right.getX()+1);
			if(maze.cellValueReal(right)&&maze.cellValue(right)!=1)
			{
				correct.setX(correct.getX()+1);
				moveCharacter(correct.getX(),correct.getY(),correct.getZ());
			
			}
		
		}
		
		@Override
		public void moveForword() {
			Position forword = new Position(maze.getCorrect());
			forword.setY(forword.getY()-1);
			if(maze.cellValueReal(forword)&&maze.cellValue(forword)!=1)
			{
			correct.setY(correct.getY()-1);
			moveCharacter(correct.getX(),correct.getY(),correct.getZ());
			}
		}
		
		@Override
		public void moveBackward() {
			Position backward = new Position(maze.getCorrect());
			backward.setY(backward.getY()+1);
			if(maze.cellValueReal(backward)&&maze.cellValue(backward)!=1)
			{
			correct.setY(correct.getY()+1);
			moveCharacter(correct.getX(),correct.getY(), correct.getZ());
			}
		}
		
		@Override
		public void setCharacterPosition(int row, int col,int floor) {
//			int x=correct.getX();
//			int y=correct.getY();
//			int z=correct.getZ();
			moveCharacter(col,row,floor);
		}
		@Override
		public void walkToSolution(){	
		for(int i = solution.getArr().size()-1;i >= 0;i--){			
			State p = solution.getArr().get(i);		
			moveCharacter(p);
	
			
			   }
			}
	}
