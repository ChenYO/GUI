package bangbean;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class BangBean extends JPanel implements Serializable{
	private int xm, ym;
	private int cSize = 20;
	private String text = "Bang!";
	private int fontSize = 48;
	private Color color = Color.RED;
	private ActionListener actionListener;
	public BangBean(){
		addMouseListener(new ML());
		addMouseMotionListener(new MML());
	}
	public int getcSize() {
		return cSize;
	}
	public void setcSize(int cSize) {
		this.cSize = cSize;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getFontSize() {
		return fontSize;
	}
	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawOval(xm - cSize/2 , ym - cSize/2, cSize, cSize);
	}
	
	public void addActionListener(ActionListener l) throws TooManyListenersException{
		if(actionListener != null)
			throw new TooManyListenersException();
		actionListener = l;
	}
	
	public void removeActionListener(ActionListener l){
		actionListener = null;
	}
	
	class ML extends MouseAdapter{
		public void mousePressed(MouseEvent e){
			Graphics g = getGraphics();
			g.setColor(color);
			g.setFont(new Font("TimesRoman", Font.BOLD, fontSize));
			int width = g.getFontMetrics().stringWidth(text);
			g.drawString(text, (getSize().width - width)/2, getSize().height/2);
			g.dispose();
			if(actionListener != null)
				actionListener.actionPerformed(new ActionEvent(BangBean.this, ActionEvent.ACTION_PERFORMED, null));
		}
	}
	
	class MML extends MouseMotionAdapter{
		public void mouseMoved(MouseEvent e){
			xm = e.getX();
			ym = e.getY();
			repaint();
		}
	}
	
	public Dimension getPerferredSize(){
		return new Dimension(200, 200);
	}
}
