package bangbean;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import static Console.SwingConsole.*;

public class BangBeanTest extends JFrame{
	private JTextField txt = new JTextField(20);
	class BBL implements ActionListener{
		private int count = 0;
		public void actionPerformed(ActionEvent e){
			txt.setText("BangBean action " + count++);
		}
	}
	
	public BangBeanTest(){
		BangBean bb = new BangBean();
		try{
			bb.addActionListener(new BBL());
		}catch(TooManyListenersException e){
			txt.setText("Too many listeners");
		}
		add(bb);
		add(BorderLayout.SOUTH, txt);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run(new BangBeanTest(), 400, 500);
	}

}
