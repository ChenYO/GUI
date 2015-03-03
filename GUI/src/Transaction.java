import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static Console.SwingConsole.*;

public class Transaction extends JFrame{
	private JButton transaction = new JButton("Transaction");
	private JTextArea 
		senderArea = new JTextArea(),
		sellerArea = new JTextArea();
	private JPanel 
		senderPane = new JPanel(),
		sellerPane = new JPanel();
	private JLabel
		senderLabel = new JLabel("Sender"),
		sellerLabel = new JLabel("Seller");
	private ExecutorService exec = Executors.newCachedThreadPool();
	public Transaction(){
		setLayout(new FlowLayout());
		senderPane.setLayout(new BorderLayout());
		senderPane.add(senderLabel, BorderLayout.NORTH);
		senderPane.add(new JScrollPane(senderArea), BorderLayout.CENTER);
		senderPane.setPreferredSize(new Dimension(300, 200));
		add(senderPane);
		
		sellerPane.setLayout(new BorderLayout());
		sellerPane.add(sellerLabel, BorderLayout.NORTH);
		sellerPane.add(new JScrollPane(sellerArea), BorderLayout.CENTER);
		sellerPane.setPreferredSize(new Dimension(300, 200));
		add(sellerPane);
		
		transaction.addActionListener(new TL());
		transaction.setPreferredSize(new Dimension(120, 20));
		add(transaction);
	}
	class TL implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Sender sender = new Sender();
			Seller seller = new Seller(sender);
			exec.execute(sender);
			exec.execute(seller);			
		}		
	}
	
	class Sender implements Runnable{
		private String[] products = {
			"Java", "C++", "C#", "Python"	
		};
		private volatile String product;
		private volatile boolean isValid;
		public boolean isIsValid(){
			return isValid;
		}
		public void setIsValid(boolean isValid){
			this.isValid = isValid;
		}
		public String getProduct(){
			return product;
		}
		
		public void run(){
			for(int i = 0; i < 4; i++){
				while(isValid){
					Thread.yield();
				}
				product = products[i];
				String text = senderArea.getText();
				senderArea.setText(text + " send " + product + "\n");
				try{
					Thread.sleep(100);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				isValid = true;
			}
		}
	}
	
	class Seller implements Runnable{
		private Sender sender;
		public Seller(Sender sender){
			this.sender = sender;
		}
		public void run(){
			for(int i = 0; i < 4; i++){
				while(!sender.isIsValid()){
					Thread.yield();
				}
				String text = sellerArea.getText();
				sellerArea.setText(text + " receive " + sender.getProduct() + "\n");
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				sender.setIsValid(false);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run(new Transaction(), 650, 400);
	}

}
