import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static Console.SwingConsole.*;

public class FileChooser extends JFrame{
	private JTextField
		fileName = new JTextField(),
		dir = new JTextField();
	private JButton 
		open = new JButton("Open"),
		save = new JButton("Save");
	public FileChooser(){
		JPanel p = new JPanel();
		open.addActionListener(new OpenL());
		p.add(open);
		save.addActionListener(new SaveL());
		p.add(save);
		add(p, BorderLayout.SOUTH);
		dir.setEditable(false);
		fileName.setEditable(false);
		p = new JPanel();
		p.setLayout(new GridLayout(2, 1));
		p.add(fileName);
		p.add(dir);
		add(p, BorderLayout.NORTH);
	}
	
	class OpenL implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JFileChooser c = new JFileChooser();
			int rVal = c.showOpenDialog(FileChooser.this);
			if(rVal == JFileChooser.APPROVE_OPTION){
				fileName.setText(c.getSelectedFile().getName());
				dir.setText(c.getCurrentDirectory().toString());
			}
			if(rVal == JFileChooser.CANCEL_OPTION){
				fileName.setText("You pressed cancel");
				dir.setText("");
			}
		}
	}
	
	class SaveL implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JFileChooser c = new JFileChooser();
			int rVal = c.showSaveDialog(FileChooser.this);
			if(rVal == JFileChooser.APPROVE_OPTION){
				fileName.setText(c.getSelectedFile().getName());
				dir.setText(c.getCurrentDirectory().toString());
			}
			if(rVal == JFileChooser.CANCEL_OPTION){
				fileName.setText("You pressed cancel");
				dir.setText("");
			}
		}
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run(new FileChooser(), 250, 150);
	}

}
