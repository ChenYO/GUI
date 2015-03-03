import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackgroundFrame extends JFrame{
	
	private ImageIcon background;
	private JLabel putBackground = new JLabel();
	private JPanel backgroundPanel = new JPanel();
	private JButton button = new JButton("Test");
	public BackgroundFrame(){

		setBack("pic/pic1.jpg");
		backgroundPanel.setOpaque(false);
		((JPanel)getContentPane()).setOpaque(false);  //使Frame的面板透明
		getLayeredPane().setLayout(null);
		getLayeredPane().add(putBackground, new Integer(Integer.MIN_VALUE));
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setBack("pic/pic2.jpg");
			}			
		});
		backgroundPanel.add(button);
		add(backgroundPanel);
	}
	
	public void setBack(String src){
		background = new ImageIcon(src);
		putBackground.setIcon(background);
		putBackground.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		setSize(background.getIconWidth(), background.getIconHeight());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BackgroundFrame();
	}

}
