import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

import static Console.SwingConsole.*;

class Forever implements Runnable{
	public void run(){
		while(true){
			
		}
	}
}

public class ThreadNameTest extends JFrame{
	private JTextField
		newThread = new JTextField(20),
		changeThread = new JTextField(20);
	private JButton
		newB = new JButton("New thread"),
		changeB = new JButton("Change thread");
	private JTable result = new JTable();
	
	public ThreadNameTest(){
		setLayout(new FlowLayout());
		result.setPreferredSize(new Dimension(450, 300));
		add(new JScrollPane(result));
		add(newThread);
		newB.setPreferredSize(new Dimension(100, 20));
		newB.addActionListener(new NL());
		add(newB);
		add(changeThread);
		changeB.addActionListener(new CBL());
		changeB.setPreferredSize(new Dimension(120, 20));
		add(changeB);
		addWindowListener(new WL());
		
	}
	class WL extends WindowAdapter{
		public void windowActivated(WindowEvent e){
			ThreadGroup group = Thread.currentThread().getThreadGroup();
			Thread[] threads = new Thread[group.activeCount()];
			group.enumerate(threads);
			DefaultTableModel model = (DefaultTableModel) result.getModel();
			model.setRowCount(0);
			model.setColumnIdentifiers(new Object[]{"Thread ID", "Thread Name"});
			for(Thread thread: threads){
				model.addRow(new Object[]{thread.getId(), thread.getName()});
			}
			result.setModel(model);
		}
	}
	
	
	
	class NL implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			Object[] threads = null;
			String name = newThread.getText();
			if(name.isEmpty()){
				Thread thread = new Thread(new Forever());
				thread.start();
				threads = new Object[]{
						thread.getId(),
						thread.getName()
				};
			}else{
				Thread thread = new Thread(new Forever(), name);
				thread.start();
				threads = new Object[]{
						thread.getId(),
						thread.getName()
				};
			}
			((DefaultTableModel) result.getModel()).addRow(threads);;
		}	
	}
	
	class CBL implements ActionListener{
		public void actionPerformed(ActionEvent e){
			int selectedRow = result.getSelectedRow();
			String newName = changeThread.getText();
			if((selectedRow == -1) || newName.isEmpty())
				return;
			DefaultTableModel model = (DefaultTableModel) result.getModel();
			model.setValueAt(newName, selectedRow, 1);
			repaint();
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
		run(new ThreadNameTest(), 450, 600);
	}

}
