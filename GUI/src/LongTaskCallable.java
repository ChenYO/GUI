import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.*;
import util.*;
import static Console.SwingConsole.*;

class CallableTask extends Task implements Callable<String>{
	public String call(){
		run();
		return "Return value of " + this;
	}
}

public class LongTaskCallable extends JFrame{
	private JButton
		b1 = new JButton("Start"),
		b2 = new JButton("End"),
		b3 = new JButton("Result");
	
	private TaskManager<String, CallableTask> manager = 
			new TaskManager<String, CallableTask>();
	
	public LongTaskCallable(){
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CallableTask task = new CallableTask();
				manager.add(task);
				System.out.println(task + " added to the queue");
			}
		});
		
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				for(String result : manager.purge())
					System.out.println(result);
			}
		});
		
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				for(TaskItem<String, CallableTask> tt : manager)
					tt.task.id();
				for(String result : manager.getResult())
					System.out.println(result);
			}
		});
		
		setLayout(new FlowLayout());
		add(b1);
		add(b2);
		add(b3);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run(new LongTaskCallable(), 200, 150);
	}

}
