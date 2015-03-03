import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import static Console.SwingConsole.*;

public class ImageViewer extends JFrame{
	private JButton
		b1 = new JButton("Pic1"),
		b2 = new JButton("Pic2"),
		b3 = new JButton("Pic3");
	private JLabel show = new JLabel();
	public ImageViewer(){
		setLayout(new FlowLayout());
		b1.setPreferredSize(new Dimension(100, 20));
		b2.setPreferredSize(new Dimension(100, 20));
		b3.setPreferredSize(new Dimension(100, 20));
		b1.addActionListener(new BL());
		b2.addActionListener(new BL());
		b3.addActionListener(new BL());
		add(b1);
		add(b2);
		add(b3);
		add(show);
	}
	
	class BL implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == b1)
				show.setIcon(new ImageIcon("pic/1.jpg"));
			else if(e.getSource() == b2)
				show.setIcon(new ImageIcon("pic/2.jpg"));
			else if(e.getSource() == b3)
				show.setIcon(new ImageIcon("pic/3.jpg"));
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run(new ImageViewer(), 350, 600);
	}

}
