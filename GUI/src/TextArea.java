import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import static Console.SwingConsole.*;

public class TextArea extends JFrame{
	private JButton
		b1 = new JButton("Add data"),
		b2 = new JButton("Clear date");
	
	private JTextArea t = new JTextArea(20, 40);
	private Map<String, String> m = new HashMap<String, String>();
	
	public TextArea(){
		m.put("Taiwan", "Kaohsiung");
		m.put("Japan", "Tyoto");
		m.put("USA", "New York");
		
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				for(Map.Entry me : m.entrySet())
					t.append(me.getKey() + ": " + me.getValue() + "\n");
			}			
		});
		
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				t.setText("");
			}			
		});
		
		setLayout(new FlowLayout());
		add(new JScrollPane(t));
		add(b1);
		add(b2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run(new TextArea(), 475, 425);
	}

}
