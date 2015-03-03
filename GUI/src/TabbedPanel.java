import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import static Console.SwingConsole.*;

public class TabbedPanel extends JFrame{
	private String[] flavors = {
			"Chocolate", "Strawberry",	"Vanilla Fudge Swirl",
			"Mint Chip", "Mocha Almond Fudge", "Rum Raisin",
			"Praline Cream", "Mud Pie"
	};
	
	private JTabbedPane tabs = new JTabbedPane();
	private JTextArea t = new JTextArea();
	public TabbedPanel(){
		int i = 0;
		for(String flavor : flavors)
			tabs.addTab(flavors[i], new JLabel("Tabbed pane" + i++));
		tabs.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				t.setText("Tab selected: " + tabs.getSelectedIndex());
			}
		});
		
		add(BorderLayout.SOUTH, t);
		add(tabs);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run(new TabbedPanel(), 400, 250);
	}

}
