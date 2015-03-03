import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import static Console.SwingConsole.*;

public class TrackEvent extends JFrame{
	private HashMap<String, JTextField> h =
			new HashMap<String, JTextField>();
	private String[] event = {
		"focusGained", "focusLost", "keyPressed",
		"keyReleased", "keyTyped", "mouseClicked",
		"mouseEntered", "mouseExited", "mousePressed",
		"mouseReleased", "mouseDragged", "mouseMoved"
	};
	
	private MyButton
		b1 = new MyButton(Color.BLUE, "Test1"),
		b2 = new MyButton(Color.RED, "Test2");
	
	class MyButton extends JButton{
		void report(String field, String msg){
			h.get(field).setText(msg);
		}
		
		FocusListener f1 = new FocusListener(){
			public void focusGained(FocusEvent e) {
				report("focusGained", e.paramString());
			}

			public void focusLost(FocusEvent e) {
				report("focusLost", e.paramString());
			}			
		};
		
		KeyListener k1 = new KeyListener(){
			public void keyPressed(KeyEvent e) {
				report("keyPressed", e.paramString());
			}

			public void keyReleased(KeyEvent e) {
				report("keyReleased", e.paramString());
			}

			public void keyTyped(KeyEvent e) {
				report("keyTyped", e.paramString());
			}			
		};
		
		MouseListener m1 = new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				report("mouseClicked", e.paramString());
			}

			public void mouseEntered(MouseEvent e) {
				report("mouseEntered", e.paramString());
			}

			public void mouseExited(MouseEvent e) {
				report("mouseExited", e.paramString());
			}

			public void mousePressed(MouseEvent e) {
				report("mousePressed", e.paramString());
			}

			public void mouseReleased(MouseEvent e) {
				report("mouseReleased", e.paramString());
			}			
		};
		
		MouseMotionListener mm1 = new MouseMotionListener(){

			public void mouseDragged(MouseEvent e) {
				report("mouseDragged", e.paramString());
			}

			public void mouseMoved(MouseEvent e) {
				report("mouseMoved", e.paramString());
			}		
		};
		
		public MyButton(Color color, String label){
			super(label);
			setBackground(color);
			addFocusListener(f1);
			addKeyListener(k1);
			addMouseListener(m1);
			addMouseMotionListener(mm1);
		}
	}
	
	public TrackEvent(){
		setLayout(new GridLayout(event.length + 1 , 2));
		for(String evt : event){
			JTextField t = new JTextField();
			t.setEditable(false);
			add(new JLabel(evt, JLabel.RIGHT));
			add(t);
			h.put(evt, t);
		}
		add(b1);
		add(b2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run(new TrackEvent(), 700, 500);
	}

}
