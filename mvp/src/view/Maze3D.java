package view;

import java.util.ArrayList;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

import algorithms.mazeGenerators.Position;
import algorithms.search.State;

public class Maze3D extends MazeDisplayer {

//	public int characterX=0;
//	public int characterY=2;
//	public int characterZ=2;
	Position correct,goul,start;
	int flag = 0;
	Image image ;
//	public int exitX=0;
//	public int exitY=2;
//	public int exitZ=2;
	
	private void paintCube(double[] p,double h,PaintEvent e){
        int[] f=new int[p.length];
        for(int k=0;k<f.length;f[k]=(int)Math.round(p[k]),k++);
        
        e.gc.drawPolygon(f);
        
        int[] r=f.clone();
        for(int k=1;k<r.length;r[k]=f[k]-(int)(h),k+=2);
        

        int[] b={r[0],r[1],r[2],r[3],f[2],f[3],f[0],f[1]};
        e.gc.drawPolygon(b);
        int[] fr={r[6],r[7],r[4],r[5],f[4],f[5],f[6],f[7]};
        e.gc.drawPolygon(fr);
        
        e.gc.fillPolygon(r);
        e.gc.drawImage(image, 250, 250);
		
	}
	public Maze3D(Composite parent, int style) {
		super(parent, style);
		
		final Color white=new Color(null, 255, 255, 255);
		final Color black=new Color(null, 150,150,150);
		setBackground(white);
		image = new Image(this.getDisplay(), "C:\\Users\\Gal Ben Evgi\\Desktop\\MaggieSimpson3.gif");
		start = new Position(0, 0, 0);
		correct = new Position(0, 0, 0);
		goul = new Position(0, 0, 0);
		
		addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent e) {	
				try{
				if(!maze.getGoal().equals(new Position(0, 0, 0))){
					goul = maze.getGoal();
					start = maze.getStart();
					correct = maze.getCorrect();
				}
				}catch (Exception e2) {
				}
					
				   e.gc.setForeground(new Color(null,0,0,0));
				   e.gc.setBackground(new Color(null,0,0,0));
				
				   
				  
				   
				   int width=getSize().x;
				   int height=getSize().y;
				   
				
				   
				   int mx=width/2;

				   double w=(double)width/mazeData[0][0].length;
				   double h=(double)height/mazeData[0].length;

				   for(int i=0;i<mazeData[correct.getZ()].length;i++){
					   double w0=0.7*w +0.3*w*i/mazeData[correct.getZ()].length;
					   double w1=0.7*w +0.3*w*(i+1)/mazeData[correct.getZ()].length;
					   double start=mx-w0*mazeData[correct.getZ()][i].length/2;
					   double start1=mx-w1*mazeData[correct.getZ()][i].length/2;
				      for(int j=0;j<mazeData[correct.getZ()][i].length;j++){
				          double []dpoints={start+j*w0,i*h,start+j*w0+w0,i*h,start1+j*w1+w1,i*h+h,start1+j*w1,i*h+h};
				          double cheight=h/2;
				          if(mazeData[correct.getZ()][i][j]!=0)
				        	  paintCube(dpoints, cheight,e);
		
				          if(flag==1){
				        	  ArrayList<State> arr = solution.getArr();
				        	  for(int k = 0;k<arr.size();k++){
				        		  if(solution.getArr().get(k).getState().equals(new Position(j,i,correct.getZ()))){				
				        		  e.gc.setBackground(new Color(null,0,0,0));
				        		  e.gc.fillOval((int)Math.round(dpoints[0]), (int)Math.round(dpoints[1]-cheight/2), (int)Math.round((w0+w1)/2), (int)Math.round(h));
				        		  e.gc.setBackground(new Color(null,150,150,0));
				        		  e.gc.fillOval((int)Math.round(dpoints[0]+2), (int)Math.round(dpoints[1]-cheight/2+2), (int)Math.round((w0+w1)/2/1.5), (int)Math.round(h/1.5));
				        		  e.gc.setBackground(new Color(null,0,0,0));
				        		  

				        		 
				        		  }
				          }}
				          if(i==goul.getY() && j==goul.getX() && goul.getZ()==correct.getZ() && !goul.equals(correct)){
							   e.gc.setBackground(new Color(null,0,255,0));
							   e.gc.fillOval((int)Math.round(dpoints[0]), (int)Math.round(dpoints[1]-cheight/2), (int)Math.round((w0+w1)/2), (int)Math.round(h));
							   e.gc.setBackground(new Color(null,0,255,0));
							   e.gc.fillOval((int)Math.round(dpoints[0]+2), (int)Math.round(dpoints[1]-cheight/2+2), (int)Math.round((w0+w1)/2/1.5), (int)Math.round(h/1.5));
							   e.gc.setBackground(new Color(null,0,0,0));				        	  
				          }
				          if(i==correct.getY() && j==correct.getX()){
							   e.gc.setBackground(new Color(null,200,0,0));
							   e.gc.fillOval((int)Math.round(dpoints[0]), (int)Math.round(dpoints[1]-cheight/2), (int)Math.round((w0+w1)/2), (int)Math.round(h));

							   e.gc.setBackground(new Color(null,255,0,0));
							   e.gc.fillOval((int)Math.round(dpoints[0]+2), (int)Math.round(dpoints[1]-cheight/2+2), (int)Math.round((w0+w1)/2/1.5), (int)Math.round(h/1.5));
							   e.gc.setBackground(new Color(null,0,0,0));
							
							 
				          }
				         
				      }
				   }
				
			}
		});
	}
	

	private void moveCharacter(int x,int y,int z){
		//if(x>=0 && x<mazeData[z].length && y>=0 && y<mazeData.length && mazeData[z][y][x]==0){
			correct.setX(x);
			correct.setY(y);
			correct.setZ(z);
			redraw();
		//}
	}
	@Override
	public void printSolution() {
		this.flag = 1;
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
		int x=correct.getX();
		int y=correct.getY();
		int z=correct.getZ();
		moveCharacter(col,row,floor);
	}

}
