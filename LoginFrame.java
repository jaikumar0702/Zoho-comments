package gyanshala.com;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame implements ActionListener{
	
	
	
	JLabel userLabel;
	JLabel passwordLabel;
	JTextField userTextField;
	JPasswordField password;
	JButton loginButton;
	JButton resetButton;
	JCheckBox showPassword;
	JButton b1;
	
	
	
	
	LoginFrame(){
		
		
		userLabel= new JLabel("USERNAME");
        passwordLabel = new JLabel("Password");
	    userTextField =  new JTextField();
	   	password=new JPasswordField();
	    loginButton = new JButton("Login");
	    resetButton=new JButton("SIGNUP");
	    showPassword=new JCheckBox("Show Password");
	    b1=new JButton("ResetPassword");
	    		
		setBounds(510,200,410,500);
	    setVisible(true);
	    userLabel.setBounds(50, 150, 100,30);
        add(userLabel);
        
		passwordLabel.setBounds(50, 220, 100, 30);
		add(passwordLabel);
		
		userTextField.setBounds(150, 150, 150, 30);
		add(userTextField);
		
		password.setBounds(150,220 ,150,30);
		add(password);
		showPassword.setBounds(150,250,150,30);
		add(showPassword);
		
		loginButton.setBounds(50, 300, 100, 30);
		add(loginButton);
		
		resetButton.setBounds(200, 300, 100, 30);
		add(resetButton);	
		
		b1.setBounds(200, 350, 100, 30);
		add(b1);
		setLayout(null);
		
		
		loginButton.addActionListener(this);
		showPassword.addActionListener(this);
		resetButton.addActionListener(this);
		
		b1.addActionListener(this);
		
		
		getContentPane().setBackground(Color.WHITE);	
	
	}
   
	@Override
    public void actionPerformed(ActionEvent ae) {
		
		try{
			if(ae.getSource()==loginButton) {
				Conn c1= new Conn();
				String userText= userTextField.getText();
				String pwdText=password.getText();
				String q=  "select *from signup where Email = '"+userText+"' and Password='"+pwdText+"' ";
				
				ResultSet rs= c1.s.executeQuery(q);
			if(rs.next())
			{     
				new Comment(userText).setVisible(true);
				setVisible(false);
				//JOptionPane.showMessageDialog(null, "Login Successfull");
				
			}
			else{
				JOptionPane.showMessageDialog(null, "Wrong user id or Password");
			}
		}
		
		if(ae.getSource()==resetButton) {
			new Signup().setVisible(true);
			setVisible(false);
		}
		
		if(ae.getSource()==showPassword) {
			if(showPassword.isSelected()) {
				password.setEchoChar((char)0);
			}
			else {
				password.setEchoChar('*');
			}
		}
		if(ae.getSource()==b1) {
				 new Reset().setVisible(true);
				 setVisible(false);
		}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.print("error: "+e);
		}
		
		
	}
	
	
	public static void main(String args[]) {

		new LoginFrame().setVisible(true);
	}
	
}

		
	
	
