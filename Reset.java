package gyanshala.com;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Reset extends JFrame implements ActionListener{
    
	JLabel l1,l2,l3;
	JTextField t1,t2;
	JButton b1,b2;
	
	Reset(){
		l1=new JLabel("Email");
		l2=new JLabel("Secret Code");
		l3= new JLabel("Reset");
		
		t1= new JTextField();
		t2= new JTextField();
		
		b1=new JButton("Reset");
		b2=new JButton("Back");
		setLayout(null);
		
		l1.setBounds(100, 100, 100, 40);
		l1.setFont(new Font("Raleway",Font.ITALIC,14));
		add(l1);
		
		l2.setBounds(100, 140, 100, 40);
		l2.setFont(new Font("Raleway",Font.ITALIC,14));
		add(l2);
		
		l3.setBounds(200, 20, 100, 40);
		l3.setFont(new Font("Raleway",Font.BOLD,22));
        add(l3);
		
        
		t1.setBounds(200,100,100,30);
		add(t1);
		
		t2.setBounds(200,140,100,30);add(t2);
		b1.setBounds(200, 200, 100, 30);
		add(b1);
		b2.setBounds(200,260,100,30);
		add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		setBounds(510,200,600,600);
		setVisible(true);
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		try {
		if(ae.getSource()==b1) {
			Conn c1= new Conn();
			String mail=t1.getText();
			String secret= t2.getText();
			String q="Select *from signup where Email='"+mail+"' and Secret_Code='"+secret+"' ";
			  ResultSet rs= c1.s.executeQuery(q);
			  if(rs.next()){
				  
				  new ResetPassword(mail).setVisible(true);
				  setVisible(false); 
			  }
			  else {
				  JOptionPane.showMessageDialog(null, "Wrong Email or Code ,Please Enter Again");
			  }
			
		}
		else if(ae.getSource()==b2) {
			new LoginFrame().setVisible(true);
			setVisible(false);
		}
		
		}catch(Exception e) {
			 e.printStackTrace();
				System.out.print("error: "+e);
		}
	}
	
	public static void main(String[] args) {
	  new Reset().setVisible(true);
	  
	}
}
