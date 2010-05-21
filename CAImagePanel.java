
import java.awt.*;

import javax.swing.*;


class CAImagePanel extends JPanel {

	    Image backImg;
	    Graphics backGr;
		int height, width, colums, rows;
		int xScale, yScale;

		public void setScale(int noColums,int noRows, int scale)
		{
			colums = noColums;
			rows = noRows;
			xScale = scale;
			yScale = scale;
			//System.out.println("here"+xScale*colums+" "+yScale*rows);
			backImg= createImage(xScale*colums,yScale*rows);
			//System.out.println("here"+backImg);
			backGr= backImg.getGraphics();

		}
		
		public void clearCAPanel()
		{
				backGr.setColor(Color.orange);
				backGr.fillRect(0,0,this.colums*xScale,rows*yScale);
		}

		public void drawCircleAt(int x, int y, Color colour)
		{
			backGr.setColor(colour);
			backGr.fillOval(x*xScale,y*yScale,xScale,yScale);
		}

		public void updateGraphic() {
		        Graphics g = this.getGraphics();
		        if ((backImg != null) && (g != null)) {		        	
		            g.drawImage(backImg, 10, 10, this.getSize().width-10, this.getSize().height-10, 0, 0, (int) (xScale * (colums)), (int) (yScale * (rows)), this);
		        }
		    }

		    @Override
		    public void paintComponent(Graphics g) {
		        updateGraphic();
		    }

		    @Override
		    public void paint(Graphics g) {
		        updateGraphic();
		    }

	}