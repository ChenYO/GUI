import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import static Console.SwingConsole.*;

public class IconGUI extends JFrame{
	private static Icon[] faces;
	private JButton jb, jb2 = new JButton("Disable");
	private boolean mad = false;
	
	public IconGUI(){
		faces = new Icon[]{
				new ImageIcon("pic/pic1.jpg"),
				new ImageIcon("pic/pic2.jpg"),
				new ImageIcon("pic/pic3.jpg"),
				new ImageIcon("pic/pic4.jpg")
		};
		jb = new JButton("JButton", faces[0]);
		setLayout(new FlowLayout());
		jb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(mad){
					jb.setIcon(faces[1]);
					mad = false;
				}else{
					jb.setIcon(faces[2]);
					mad = true;
				}
				jb.setVerticalAlignment(JButton.TOP);
				jb.setHorizontalAlignment(JButton.LEFT);
			}			
		});
		jb.setRolloverEnabled(true);
		jb.setRolloverIcon(faces[3]);
		jb.setPressedIcon(faces[2]);
		jb.setDisabledIcon(faces[1]);
		jb.setToolTipText("Wow!");
		add(jb);
		jb2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(jb.isEnabled()){
					jb.setEnabled(false);
					jb2.setText("Enable");
				}else{
					jb.setEnabled(true);
					jb2.setText("Disable");
				}
			}
		});
		
		add(jb2);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run(new IconGUI(), 1000, 500);
	}

}
