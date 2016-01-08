package view;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;

public class Maze2D extends MazeDisplayer{


	 public Maze2D(Composite parent,int style){
	        super(parent, style);
	    	// set a white background   (red, green, blue)
	    	setBackground(new Color(null, 255, 255, 255));
	    	addPaintListener(new PaintListener() {
				
				@Override
				public void paintControl(PaintEvent e) {
					   e.gc.setForeground(new Color(null,0,0,0));
					   e.gc.setBackground(new Color(null,0,0,0));

					   int width=getSize().x;
					   int height=getSize().y;

					   int w=width/mazeData[0][0].length;
					   int h=height/mazeData[0].length;

					   for(int i=0;i<mazeData.length;i++)
					      for(int j=0;j<mazeData[i].length;j++){
					          int x=j*w;
					          int y=i*h;
					          if(mazeData[0][i][j]!=0)
					              e.gc.fillRectangle(x,y,w,h);
					      }
					}
			});
	 }


	@Override
	public void setCharacterPosition(int row, int col,int floor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void printSolution() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void moveForword() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void moveBackward() {
		// TODO Auto-generated method stub
		
	}

}
