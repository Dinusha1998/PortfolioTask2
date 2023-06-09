package Abominodo;
import java.awt.*;

import javax.swing.*;

public class PictureFrame {
  public int[] reroll = null;
  Aardvark master = null;

  class DominoPanel extends JPanel {
    private static final long serialVersionUID = 4190229282411119364L;

    public void drawGrid(Graphics g) {
      for (int are = 0; are < 7; are++) {
        for (int see = 0; see < 8; see++) {
          drawDigitGivenCentre(g, 30 + see * 20, 30 + are * 20, 20,
              master.grid[are][see]);
        }
      }
    }
    
    public void drawGridLines(Graphics g) {
    	  g.setColor(Color.LIGHT_GRAY);
    	  int startX = 20;
    	  int startY = 20;
    	  int endX = 180;
    	  int endY = 160;
    	  int cellSize = 20;

    	  for (int are = 0; are <= 7; are++) {
    	    int lineY = startY + are * cellSize;
    	    g.drawLine(startX, lineY, endX, lineY);
    	  }

    	  for (int see = 0; see <= 8; see++) {
    	    int lineX = startX + see * cellSize;
    	    g.drawLine(lineX, startY, lineX, endY);
    	  }
    	}

    public void drawHeadings(Graphics g) {
      for (int are = 0; are < 7; are++) {
        fillDigitGivenCentre(g, 10, 30 + are * 20, 20, are+1);
      }

      for (int see = 0; see < 8; see++) {
        fillDigitGivenCentre(g, 30 + see * 20, 10, 20, see+1);
      }
    }

    public void drawDomino(Graphics g, Domino d) {
      if (d.placed) {
        int y = Math.min(d.ly, d.hy);
        int x = Math.min(d.lx, d.hx);
        int w = Math.abs(d.lx - d.hx) + 1;
        int h = Math.abs(d.ly - d.hy) + 1;
        g.setColor(Color.WHITE);
        g.fillRect(20 + x * 20, 20 + y * 20, w * 20, h * 20);
        g.setColor(Color.RED);
        g.drawRect(20 + x * 20, 20 + y * 20, w * 20, h * 20);
        drawDigitGivenCentre(g, 30 + d.hx * 20, 30 + d.hy * 20, 20, d.high,
            Color.BLUE);
        drawDigitGivenCentre(g, 30 + d.lx * 20, 30 + d.ly * 20, 20, d.low,
            Color.BLUE);
      }
    }

    void drawDigitGivenCentre(Graphics g, int x, int y, int diameter, int n) {
      int radius = diameter / 2;
      g.setColor(Color.BLACK);
      // g.drawOval(x - radius, y - radius, diameter, diameter);
      FontMetrics fm = g.getFontMetrics();
      String txt = Integer.toString(n);
      g.drawString(txt, x - fm.stringWidth(txt) / 2, y + fm.getMaxAscent() / 2);
    }

    void drawDigitGivenCentre(Graphics g, int x, int y, int diameter, int n,
        Color c) {
      int radius = diameter / 2;
      g.setColor(c);
      // g.drawOval(x - radius, y - radius, diameter, diameter);
      FontMetrics fm = g.getFontMetrics();
      String txt = Integer.toString(n);
      g.drawString(txt, x - fm.stringWidth(txt) / 2, y + fm.getMaxAscent() / 2);
    }

    void fillDigitGivenCentre(Graphics g, int x, int y, int diameter, int n) {
      int radius = diameter / 2;
      g.setColor(Color.GREEN);
      g.fillOval(x - radius, y - radius, diameter, diameter);
      g.setColor(Color.BLACK);
      g.drawOval(x - radius, y - radius, diameter, diameter);
      FontMetrics fm = g.getFontMetrics();
      String txt = Integer.toString(n);
      g.drawString(txt, x - fm.stringWidth(txt) / 2, y + fm.getMaxAscent() / 2);
    }

    protected void paintComponent(Graphics g) {
    	  g.setColor(Color.YELLOW);
    	  g.fillRect(0, 0, getWidth(), getHeight());
    	  
    	  if (master.mode == 1) {
    	    drawMode1(g);
    	  } else if (master.mode == 0) {
    	    drawMode0(g);
    	  }
    	}

    	private void drawMode1(Graphics g) {
    	  drawGridLines(g);
    	  drawHeadings(g);
    	  drawGrid(g);
    	  master.drawGuesses(g);
    	}

    	private void drawMode0(Graphics g) {
    	  drawGridLines(g);
    	  drawHeadings(g);
    	  drawGrid(g);
    	  master.drawDominoes(g);
    	}

    public Dimension getPreferredSize() {
      return new Dimension(202, 182);
    }
  }

  public DominoPanel dp;

  public void PictureFrame(Aardvark sf) {
    master = sf;
    if (dp == null) {
      JFrame f = new JFrame("Abominodo");
      dp = new DominoPanel();
      f.setContentPane(dp);
      f.pack();
      f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      f.setVisible(true);
    }
  }

  public void reset() {
    // TODO Auto-generated method stub

  }

}
