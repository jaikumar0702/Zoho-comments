package gyanshala.com;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import com.mysql.cj.protocol.Resultset;

public class ResetPassword extends JFrame implements ActionListener{
       
	     JLabel l1,l2;
	     JPasswordField pf1;
	     JButton b1,b2;
	     String email;
	     
	     
	    ResetPassword(String mail)
	    {
	    	 this.email=mail;
	    	 l1= new JLabel("Enter Password");
	    	 l2=new JLabel("Reset Your Password");
	    	 pf1= new JPasswordField();
	    	 b1=new JButton("Reset");
	    	 b2=new JButton("Back");
	    	 setLayout(null);
	    	 
	    	 l2.setBounds(130,20,250,40);
	    	 l2.setBackground(Color.BLACK);
	         l2.setFont(new Font("Raleway", Font.BOLD,20));
	         add(l2);
	         
	    	 l1.setBounds(100, 80, 150, 100);
	    	 l1.setFont(new Font("Raleway",Font.ITALIC,14));
	    	 add(l1);
	    	 
	    	 pf1.setBounds(240, 120, 100, 30);
	    	 add(pf1);
	    	 
	    	 b1.setBounds(160, 200, 100, 20);
	    	 add(b1);
	    	 
	    	 b2.setBounds(160, 240, 100, 20);
	    	 add(b2);
	    	 b2.addActionListener(this);
	    	 b1.addActionListener(this);
	    	 
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
	    
		@Override
	     public void actionPerformed(ActionEvent ae){
	    	  
	    	 try{
	    		 if(ae.getSource()==b1) {
	    			 Conn c1= new Conn();
	    		  String Pass= pf1.getText();
	    		  char[] Password=pf1.getPassword();
	    		  
	    		  if(Pass.length()==0)
	    		  {
	    			  JOptionPane.showMessageDialog(null, "password should not be empty");
	    		  }
	    		  else if(!checkValidPassword(Password))
	    		  {
	    			  JOptionPane.showMessageDialog(null, "Poor Password");
	    		  }
	    		  else {
	    			  
	    		  String q ="Update signup set Password='"+Pass+"' where Email='"+this.email+"' ";
	    		
	    		  c1.s.executeUpdate(q);
	    		 new LoginFrame().setVisible(true);
	    		  setVisible(false);
				 // JOptionPane.showMessageDialog(null, "Wrong Email or Code ,Please Enter Again");
	    	 }
	    	 }
	    		 else if(ae.getSource()==b2) {
	    			 new Reset().setVisible(true);
		    		  setVisible(false); 
	    		 }
	    	 }
	    	 catch(Exception e) {
	    		 e.printStackTrace();
					System.out.print("error: "+e);
	    	 }
	     }
	 
	
	
	
}
