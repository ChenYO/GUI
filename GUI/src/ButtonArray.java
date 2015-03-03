import javax.swing.*;

import java.awt.*;

import static Console.SwingConsole.*;

public class ButtonArray extends JFrame{
	private JTextField field;
	private JButton[][] button;
	private JPanel panel;
	private String[][] names = {
			{"1", "2", "3", "+"},
			{"4", "5", "6", "-"},
			{"7", "8", "9", "*"},
			{".", "0", "=", "/"}
	};
	
	public ButtonArray(){
		field = new JTextField();
		field.setHorizontalAlignment(SwingConstants.TRAILING);
		field.setPreferredSize(new Dimension(12, 50));
		field.setColumns(10);
		add(field, BorderLayout.NORTH);
		GridLayout grid = new GridLayout(4, 0);
		grid.setHgap(5);
		grid.setVgap(5);
		
		panel = new JPanel();
		panel.setLayout(grid);
		add(panel, BorderLayout.CENTER);
		
		button = new JButton[4][4];
		
		for(int row = 0; row < names.length; row++){
			for(int col = 0; col < names.length; col++){
				button[row][col] = new JButton(names[row][col]);
				panel.add(button[row][col]);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		run(new ButtonArray(), 400, 400);
	}

}
