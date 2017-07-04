package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class vLoginForm extends JFrame implements ActionListener
{
JLabel jl1;
JPasswordField jp1;
JButton jb1;
public vLoginForm()
{setLayout(null);
setVisible(true);
setBounds(100, 100,2000, 2000);
setTitle("Login Portal");
	jl1=new JLabel("Enter password");
	jp1=new JPasswordField("");
	jb1=new JButton("Log In");
	jl1.setBounds(150, 250, 120, 50);
	jp1.setBounds(150, 300, 150, 50);
jb1.setBounds(150, 400, 150, 50);
add(jl1);
add(jp1);
jb1.addActionListener(this);
add(jb1);
}
	
	public void actionPerformed(ActionEvent e) 
	{
		String action=e.getActionCommand();
		if(action.equals("Log In")){
			String h=jp1.getText();
			if(h.equals(""))
			{
				JOptionPane.showMessageDialog(this, "Access granted");
				this.dispose();
				 VopeningForm obj=new VopeningForm();	

			}
			else
			{
				JOptionPane.showMessageDialog(this, "Access denied");	
			}
			
		}
		
	}

}
