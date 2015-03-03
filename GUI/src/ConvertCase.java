import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import static Console.SwingConsole.*;

public class ConvertCase extends JFrame{
	private JTextField
		inputText = new JTextField(),
		outputText = new JTextField();
	private JButton convert = new JButton("Convert");
	private ButtonGroup bg = new ButtonGroup();
	private JRadioButton
		upperCase = new JRadioButton("Uppercase"),
		lowerCase = new JRadioButton("Lowercase");
	private JPanel jp = new JPanel();
	
	public ConvertCase(){
		setLayout(new FlowLayout());
		inputText.setPreferredSize(new Dimension(500, 20));
		add(inputText);
		upperCase.setActionCommand("Upper");
		lowerCase.setActionCommand("Lower");
		upperCase.setSelected(true);
		bg.add(upperCase);
		bg.add(lowerCase);
		convert.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String command = bg.getSelection().getActionCommand();
				boolean upper = command.equals("Upper");
				String text = inputText.getText();
				if(upper)
					outputText.setText(text.toUpperCase());
				else
					outputText.setText(text.toLowerCase());
			}			
		});
		convert.setPreferredSize(new Dimension(100, 20));
		add(convert);
		
		add(upperCase);
		add(lowerCase);
		outputText.setPreferredSize(new Dimension(500, 20));
		outputText.setEditable(false);
		add(outputText);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run(new ConvertCase(), 550, 150);
	}

}
