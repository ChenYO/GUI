import javax.swing.*;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static Console.SwingConsole.*;

public class Clock extends JFrame{
	private static JLabel clockFormat;
	
	public Clock(){
		 addWindowListener(new WindowAdapter() {
	            @Override
	            public void windowActivated(WindowEvent arg0) {
	                do_this_windowActivated(arg0);
	            }
	        });
		setLayout(new BorderLayout());
		clockFormat = new JLabel();
		clockFormat.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 30));
		clockFormat.setHorizontalAlignment(SwingConstants.CENTER);
		add(clockFormat, BorderLayout.CENTER);

	}
	
		
	public static String format(int number){
		return number < 10 ? "0" + number : "" + number;
	}
	
	public static String getTime(){
		Calendar calendar = new GregorianCalendar();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		return format(hour) + ":" + format(minute) + ":" + format(second);		
	}
	
	static class ClockRunnable implements Runnable{
		public void run(){
			while(true){
				clockFormat.setText(getTime());
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
	}
	  protected void do_this_windowActivated(WindowEvent arg0) {
	        new Thread(new ClockRunnable()).start();
	    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
		run(new Clock(), 300, 100);
	}

}
