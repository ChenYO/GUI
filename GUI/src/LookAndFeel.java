import javax.swing.*;
import java.awt.*;
import static Console.SwingConsole.*;

public class LookAndFeel extends JFrame{
	private String[] choices = "Eeny Meeny Minnie Mickey Moe Larry Curly".split(" ");
	private Component[] samples = {
			new JButton("JButton"),
			new JLabel("JLabel"),
			new JTextField("JTextField"),
			new JCheckBox("JCheckBox"),
			new JRadioButton("JRadioButton"),
			new JComboBox(choices),
			new JList(choices)
	};
	
	public LookAndFeel(){
		super("Look and feel");
		setLayout(new FlowLayout());
		for(Component component : samples)
			add(component);
	}
	
	private static void usageError(){
		System.out.println("Usage : LookAndFeel [cross|system|motif]");
		System.exit(1);
	}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length == 0)
			usageError();
		if(args[0].equals("cross")){
			try{
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(args[0].equals("system")){
			try{
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(args[0].equals("motif")){
			try{
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			usageError();
		}
		
		run(new LookAndFeel(), 300, 300);
	}

}
