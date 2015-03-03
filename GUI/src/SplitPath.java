import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.io.*;
import java.awt.event.*;

import static Console.SwingConsole.*;

public class SplitPath extends JFrame{
	private JTextField textField;
	private JButton choose;
	private JTextArea textArea;
	private JPanel jp;
	
	public SplitPath(){
		setLayout(new FlowLayout());
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(400, 20));
		add(textField);
		choose = new JButton("Choose file");
		choose.setPreferredSize(new Dimension(100, 20));
		choose.addActionListener(new CL());
		add(choose);
		textArea = new JTextArea();
		textArea.setPreferredSize(new Dimension(500, 100));
		jp = new JPanel();
		jp.setBorder(new TitledBorder("File info"));
		jp.add(textArea);
		add(new JScrollPane(jp));
	}
	
	class CL implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JFileChooser chooser = new JFileChooser();
			int option = chooser.showOpenDialog(SplitPath.this);
			if(option == JFileChooser.APPROVE_OPTION){
				File file = chooser.getSelectedFile();
				String path = file.getAbsolutePath();
				textField.setText(path);
				int splitIndex = path.lastIndexOf("\\");
				int typeIndex = path.lastIndexOf(".");
				if(typeIndex < 0)
					typeIndex = path.length();
				String filePath = path.substring(0, splitIndex);
				String fileName = path.substring(splitIndex + 1, typeIndex);
				String extName = path.substring(typeIndex);
				textArea.setText("");
				textArea.append("File name: " + fileName + "\n");
				textArea.append("Ext name: " + extName + "\n");
				textArea.append("File path: " + filePath + "\n");
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
		run(new SplitPath(), 550, 200);
	}

}
