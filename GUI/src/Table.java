import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import static Console.SwingConsole.*;

public class Table extends JFrame{
	private JTable table;
	public Table(){
		table = getTable();
		add(new JScrollPane(table), BorderLayout.CENTER);
	}
	
	public JTable getTable(){
		if(table == null){
			table = new JTable();
			String[] columns = {
					"Monday", "Tuesday", "Wednesday",
					"Thursday", "Friday", "Saturday",
					"Sunday"
			};
			
			int[] columnWidth = {
				10, 20, 30, 40, 50, 60, 70	
			};
			DefaultTableModel model = new DefaultTableModel(columns, 15);
			table.setModel(model);
			TableColumnModel columnModel = table.getColumnModel();
			int count = columnModel.getColumnCount();
			for(int i = 0; i < count; i++){
				TableColumn column = columnModel.getColumn(i);
				column.setPreferredWidth(columnWidth[i]);
			}
		}
		return table;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run(new Table(), 700, 200);
	}

}
