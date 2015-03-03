import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.*;
import static Console.SwingConsole.*;

class Task implements Runnable{
	private static int counter = 0;
	private final int id = counter++;
	public void run(){
		System.out.println(this + "started");
		try{
			TimeUnit.SECONDS.sleep(3);
		}catch(InterruptedException e){
			System.out.println("Interrupted");
			return;
		}
		System.out.println("Finished");
	}
	
	public String toString(){
		return "Task " + id;
	}
	
	public long id(){
		return id;
	}
}

public class LongRunningTask extends JFrame{
	private JButton
		b1 = new JButton("Start"),
		b2 = new JButton("End");
	ExecutorService exec = Executors.newSingleThreadExecutor();
	
	public LongRunningTask(){
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Task task = new Task();
				exec.execute(task);
				System.out.println(task + " added to the queue");
			}
		});
		
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				exec.shutdown();
			}
		});
		
		setLayout(new FlowLayout());
		add(b1);
		add(b2);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run(new LongRunningTask(), 200, 100);
	}

}
