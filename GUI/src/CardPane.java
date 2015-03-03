import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

import static Console.SwingConsole.*;

public class CardPane extends JFrame{
	private JButton 
		first = new JButton("<-- First"),
		pre = new JButton("Pre"),
		next = new JButton("Next"),
		last = new JButton("Last-->");

	private JPanel jp = new JPanel();
	private CardLayout cardLayout = new CardLayout();
	
	public CardPane(){
		
		setLayout(new FlowLayout());
		jp.setLayout(cardLayout);
		jp.add(new JLabel("Page 1"), "Page 1");
		jp.add(new JLabel("Page 2"), "Page 2");
		jp.add(new JLabel("Page 3"), "Page 3");
		jp.add(new JLabel("Page 4"), "Page 4");
		jp.setPreferredSize(new Dimension(100, 20));
		first.setPreferredSize(new Dimension(100, 20));
		first.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.first(jp);
			}			
		});
		add(first);
		pre.setPreferredSize(new Dimension(100, 20));
		pre.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.previous(jp);;
			}			
		});
		add(pre);
		add(jp);
		next.setPreferredSize(new Dimension(100, 20));		
		next.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.next(jp);
			}			
		});
		add(next);
		last.setPreferredSize(new Dimension(100, 20));
		last.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.last(jp);
			}			
		});
		add(last);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run(new CardPane(), 600, 100);
	}

}
