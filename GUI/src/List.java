import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

import static Console.SwingConsole.*;

public class List extends JFrame{
	private String[] flavors = {
		"Chocolate", "Strawberry",	"Vanilla Fudge Swirl",
		"Mint Chip", "Mocha Almond Fudge", "Rum Raisin",
		"Praline Cream", "Mud Pie"
	};
	private int count = 0;
	private DefaultListModel lItems = new DefaultListModel();
	private JList lst = new JList(lItems);
	private JTextArea t = new JTextArea(flavors.length, 20);
	private JButton b = new JButton("Add item");
	private ActionListener b1 = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(count < flavors.length)
				lItems.add(0, flavors[count++]);
			else
				b.setEnabled(false);
		}
	};
	
	private ListSelectionListener ll = new ListSelectionListener(){
		@SuppressWarnings("deprecation")
		public void valueChanged(ListSelectionEvent e) {
			if(e.getValueIsAdjusting()) return;
			t.setText("");
			for(Object item : lst.getSelectedValues())
				t.append(item + "\n");
		}		
	};
	
	public List(){
		t.setEditable(false);
		setLayout(new FlowLayout());
		Border brd = BorderFactory.createMatteBorder(1, 1, 2, 2, Color.black);
		lst.setBorder(brd);
		t.setBorder(brd);
		for(int i = 0; i < 4; i++)
			lItems.addElement(flavors[count++]);
		add(t);
		add(lst);
		add(b);
		lst.addListSelectionListener(ll);
		b.addActionListener(b1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run(new List(), 250, 375);
	}

}
