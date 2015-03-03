import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static Console.SwingConsole.*;

public class Button1 extends JFrame{
	
	private JButton
		b1 = new JButton("Button1"),
		b2 = new JButton("Button2");
	
	private JTextField txt = new JTextField(10);
	
	class ButtonLinstener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String name = ((JButton)e.getSource()).getText();
			txt.setText(name);
		}
	}
	
	private ButtonLinstener bl = new ButtonLinstener();
	public Button1(){
		b1.addActionListener(bl);
		b2.addActionListener(bl);
		setLayout(new FlowLayout());
		add(b1);
		add(b2);
		add(txt);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run(new Button1(), 200, 100);
	}

}
