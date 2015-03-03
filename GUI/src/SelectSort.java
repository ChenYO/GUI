import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import static Console.SwingConsole.*;

public class SelectSort extends JFrame{
	private JTextArea randText;
	private JTextArea resultText;
	private JButton random;
	private JButton sort;
	private int[] array = new int[10];
	public SelectSort(){
		setLayout(new FlowLayout());
		randText = new JTextArea();
		randText.setPreferredSize(new Dimension(400, 150));
		randText.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 18));
		add(randText);
		random = new JButton("Random");
		random.addActionListener(new RL());
		random.setSize(new Dimension(100, 20));
		add(random);
		resultText = new JTextArea();
		resultText.setPreferredSize(new Dimension(400, 150));
		resultText.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 18));
		add(resultText);
		sort = new JButton("Select Sort");
		sort.addActionListener(new SL());
		sort.setSize(new Dimension(100, 20));
		add(sort);
	}
	class RL implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Random rand = new Random();
			randText.setText("");
			for(int i = 0; i< array.length; i++){
				array[i] = rand.nextInt(50);
				randText.append(array[i] + " ");
			}
		}		
	}
	
	class SL implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			resultText.setText("");
			int index;
			for(int i = 1; i < array.length; i++){
				index = 0;
				for(int j = 1; j <= array.length - i; j++){
					if(array[j] > array[index])
						index = j;
				}
				
				int temp = array[array.length - i];
				array[array.length - i] = array[index];
				array[index] = temp;
			}
			for(int i = 0; i < array.length; i++)
				resultText.append(array[i] + " ");
		}		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run(new SelectSort(), 450, 420);
	}

}
