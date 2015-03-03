import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static Console.SwingConsole.*;

public class ComboBoxes extends JFrame{
	private String[] description = {
			"Ebullient", "Obtuse", "Recalcitrant", "Brilliant",
			"Somnescent", "Timorous", "Fiorid", "Putrescent"
	};
	
	private JTextField t = new JTextField(15);
	private JComboBox c = new JComboBox();
	private JButton b = new JButton("Add item");
	private int count = 0;
	public ComboBoxes(){
		for(int i = 0 ; i < 4 ; i++)
			c.addItem(description[count++]);
		t.setEditable(false);
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(count < description.length)
					c.addItem(description[count++]);
			}
		});
		
		c.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				t.setText("index: " + c.getSelectedIndex() + "  " +
						((JComboBox)e.getSource()).getSelectedIndex());
			}
		});
		
		setLayout(new FlowLayout());
		add(t);
		add(b);
		add(c);		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run(new ComboBoxes(), 200, 175);
	}

}
