package gyanshala.com;

import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Signup extends JFrame implements ActionListener {
       
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JTextField t1,t2,t3;
	JPasswordField pf1,pf2;
	JButton b1,b2,b3;
	JComboBox cb1,cb2,cb3;
	
	Signup(){
		
		
		 
		l1=new JLabel("SignUP");
		l2=new JLabel("Email");
		l3= new JLabel("Enter Password");
		l4 = new JLabel("Secret Code");
		
		
		//l6= new JLabel("RE-Enter Password");
		
		t1= new JTextField();
		t2= new JTextField();
		
		
		pf1= new JPasswordField();
		
		
		b1= new JButton("Signup");
		b2=new JButton("Login Already user");
		b3=new JButton("Back");
       
        
        setLayout(null);
        
        
       //getContentPane().setBackground(Color.WHITE);
        
        /*setSize(850,750);
        setLocation(400,50);
        setVisible(true);
        
        */
        
        l1.setBounds(250, 10, 100, 50);
        l1.setBackground(Color.BLACK);
        l1.setFont(new Font("Raleway", Font.BOLD,20));
        add(l1);
        
        l2.setBounds(70, 50, 100, 100);
        l2.setFont(new Font("Raleway", Font.ITALIC,14));
        add(l2);
        
        t1.setBounds(190,90, 250, 30);
        add(t1);
        
        l3.setBounds(70, 90, 100, 100);
        l3.setFont(new Font("Raleway",Font.ITALIC,14));
        add(l3);
        
        pf1.setBounds(190, 130, 250, 30);
        add(pf1);
        
        l4.setBounds(70, 150, 100, 100);
        l4.setFont(new Font("Raleway",Font.ITALIC,14));
        add(l4);
       
        
        t2.setBounds(190, 190, 250, 30);
        add(t2);
        
     
        
        b1.setBounds(210, 260, 100, 30);
        add(b1);
        b2.setBounds(210, 300, 100, 30);
        add(b2);
        b3.setBounds(210,340,100,30);
        add(b3);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
       b3.addActionListener(this);
        
        setBounds(510,200,600,600);
	    setVisible(true);
		
	    
	}
	
	public boolean checkValidPassword(char[] password)
    {
        int u = 0, l = 0, d = 0, sp = 0;
        
        if(password.length < 8)
        {
            return false;
        }
        for(int i = 0; i < password.length; i++)
        {
            char c = password[i];
            if(Character.isUpperCase(c))
            {
                u = 1;
            }
            else if(Character.isLowerCase(c))
            {
                l = 1;
            }
            else if(Character.isDigit(c))
            {
                d = 1;
            }
            if(!Character.isLetter(c) && !Character.isDigit(c) && !Character.isWhitespace(c))
            {
                sp = 1;
            }
        }
        if(u == 1 && l == 1 && d == 1 && sp == 1)
        {
            return true;
        }
        return false;
    }
	
	public void actionPerformed(ActionEvent ae) {
		try {
		 if(ae.getSource()==b1) {
			 Conn c1= new Conn();
			 String mail= t1.getText();
			 String pass=pf1.getText();
			 String secret_code =t2.getText();
			 char[] password= pf1.getPassword();
			 String check_mail="select *from signup where Email='"+mail+"' ";
			 ResultSet rs1= c1.s.executeQuery(check_mail);
			 
			 if(rs1.next()) {
				 JOptionPane.showMessageDialog(null, "Email already Exists");
			 } 
			 else {
				 EmailValidator emailValidator = new EmailValidator();
			   if(!emailValidator.validate(t1.getText().trim()) && !checkValidPassword(password)) {
				   JOptionPane.showMessageDialog(null, "Wrong Email & Poor Password");
			       
			   }
			   else if(!emailValidator.validate(t1.getText().trim())) {
				   JOptionPane.showMessageDialog(null, "Wrong Email");
			   }
			   else if(!checkValidPassword(password)){
				   JOptionPane.showMessageDialog(null, "Poor Password");
			   }
			   else
			   { 
				   String q ="insert INTO signup VALUES ('"+mail+"' , '"+pass+"','"+secret_code+"')";
				 
				 c1.s.executeUpdate(q);
				 
				 new LoginFrame().setVisible(true);
				 setVisible(false);
				 }
			 
			 }
		 }
		 else if(ae.getSource()==b2 ||ae.getSource()==b3 ) {
			 new LoginFrame().setVisible(true);
			 setVisible(false);
		 }
		 
		 
	}
  catch(Exception e) {
	  e.printStackTrace();
		System.out.print("error: "+e);
	}
	}
	public static void main(String[] args) {
		new Signup().setVisible(true);
	}
	
	
	
	
}
