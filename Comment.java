package gyanshala.com;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.Resultset;

public class Comment extends JFrame implements ActionListener {
    
	JLabel l1,l2;
	JButton b1,b2;
	JTextField tf1,tf2;
	private String eemail;
	JList list;
	String[] columnNames= {"Email","Comments"};
	JTable table;
	private int c1=0;
	JList frame1;
	
	
	
	Comment(String UserText){
		this.eemail=UserText;
		l1=new JLabel("What would you like to share with world");
		b1= new JButton("Submit");
		b2=new JButton("Filter");
		l2= new JLabel("Comments");
		tf1=new JTextField();
		tf2=new JTextField();
		
		l1.setBounds(50, 50, 250, 30);
		add(l1);
		
		tf1.setBounds(20, 80, 500, 150);
		add(tf1);
		b1.setBounds(550, 90, 80, 30);
		add(b1);
		
		
		l2.setBounds(30, 240, 80, 30);
		add(l2);
		b2.setBounds(550,290,80,30);
		add(b2);
		
		 fetchComment();
		
		 
		 b1.addActionListener(this);
		b2.addActionListener(this);
		
		setLayout(null);
		
		setBounds(510,200,650,650);
		setVisible(true);
	}
	
	Comment(String mail,int c){
		this.eemail=mail;
		l1=new JLabel("What would you like to share with world");
		b1= new JButton("Submit");
		b2=new JButton("Filter");
		l2= new JLabel("Comments");
		tf1=new JTextField();
		tf2=new JTextField();
		
		l1.setBounds(50, 50, 250, 30);
		add(l1);
		
		tf1.setBounds(20, 80, 500, 150);
		add(tf1);
		b1.setBounds(550, 90, 80, 30);
		add(b1);
		
		
		l2.setBounds(30, 240, 80, 30);
		add(l2);
		b2.setBounds(550,290,80,30);
		add(b2);
		
		
		showTableData(eemail);
		 
		 b1.addActionListener(this);
		b2.addActionListener(this);
		
		setLayout(null);
		
		setBounds(510,200,650,650);
		setVisible(true);
	}



	

	private void fetchComment() {
		
		showTableData();
	}





	private void showTableData() {
		frame1= new JList();
		//list.setBounds(20, 290,500, 190);
		//frame1 = new JFrame("Database Search Result");

        frame1.setLayout(new BorderLayout());
		DefaultTableModel model = new DefaultTableModel();
		
		model.setColumnIdentifiers(columnNames);
		table= new JTable();
		table.setModel(model);
		
		JScrollPane scroll = new JScrollPane(table);
		 scroll.setHorizontalScrollBarPolicy(

	                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	        scroll.setVerticalScrollBarPolicy(

	                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	     
	         
	        String mail="";
	        String comm="";
	        Conn c1= new Conn();
			String query="select * from comment";
			ResultSet rs = null;
			try {

				rs = c1.s.executeQuery(query);
				while(rs.next())
				{
				    
				    mail=rs.getString(1);
				    comm=rs.getString(2);
				    model.addRow(new Object[] {mail,comm});
				    
				}
				
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 frame1.add(scroll);
			 frame1.setBounds(20, 290,500, 190);
			 
             add(frame1);

	}





	@Override
	public void actionPerformed(ActionEvent ae) {
	try {
		if(ae.getSource()==b1) {
			Conn c1= new Conn();
			String comm= tf1.getText();
			
			String q="insert INTO comment VALUES('"+this.eemail+"','"+comm+"')";
			
			c1.s.executeUpdate(q);
		   tf1.setText("");
		   new Comment(eemail).setVisible(true);
		   setVisible(false);
			
		}
		if(ae.getSource()==b2) {
			
			new Comment(eemail,1).setVisible(true);
			setVisible(false);
		}
	}catch(Exception e) {
		 e.printStackTrace();
			System.out.print("error: "+e);
	}
		
	}





	private void showTableData(String mail2) {
		
		frame1= new JList();
		//list.setBounds(20, 290,500, 190);
		//frame1 = new JFrame("Database Search Result");

        frame1.setLayout(new BorderLayout());
		DefaultTableModel model = new DefaultTableModel();
		
		model.setColumnIdentifiers(columnNames);
		table= new JTable();
		table.setModel(model);
		
		JScrollPane scroll = new JScrollPane(table);
		 scroll.setHorizontalScrollBarPolicy(

	                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	        scroll.setVerticalScrollBarPolicy(

	                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	     
	         
	        String mail="";
	        String comm="";
	        Conn c1= new Conn();
			String query="select * from comment where Email='"+mail2+"' ";
			ResultSet rs = null;
			try {

				rs = c1.s.executeQuery(query);
				while(rs.next())
				{
				    
				    mail=rs.getString(1);
				    comm=rs.getString(2);
				    
				    model.addRow(new Object[]{mail,comm});
				    
				}
				
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
				System.out.print("error: "+e);
			}
			 frame1.add(scroll);
			 frame1.setBounds(20, 290,500, 190);
             add(frame1);
		
		
	}
      
	
}
