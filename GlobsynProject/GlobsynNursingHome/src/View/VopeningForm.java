package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VopeningForm extends JFrame implements ActionListener
{
 JLabel jl1,l1;
 JButton jb1,jb2,b1,jb3,jb4;
 public VopeningForm()
 {
	 setBounds(0, 0,1000, 700);
	 setVisible(true);
	 setTitle("G F S Nursing Home");
	 setDefaultCloseOperation(EXIT_ON_CLOSE);
	 setLayout(null);
	

	 jl1=new JLabel("<html><strong><h1><font size=40 style=arial color=red >FIND DOCTORS AND BOOK APPOINTMENTS </strong></h1></font></html>");
	 jl1.setBounds(250, 50, 500, 100);
	 add(jl1);
	 
	 jb1=new JButton("DOCTOR MANAGEMENT");
	 jb1.setBounds(150, 250, 200, 50);
	 add(jb1);
	 jb2=new JButton("PATIENT MANAGEMENT");
	 jb2.setBounds(370, 250, 170, 50);
	 add(jb2);
	 jb4=new JButton("FIX APPOINTMENT");
	 jb4.setBounds(370,310,170,50);
	 add(jb4);
	 jb3=new JButton("DOCTOR SCHEDULE MANAGEMENT");
	 jb3.setBounds(550, 250,300, 50);
	 add(jb3);
	 jb1.addActionListener(this);
	 jb2.addActionListener(this);
	 jb3.addActionListener(this);
	 jb4.addActionListener(this);
 }
@Override
public void actionPerformed(ActionEvent e)

{
	String action=e.getActionCommand();
	if("DOCTOR MANAGEMENT".equals(action))
	{this.dispose();
		new vDoctorManagement();
	}
	else if("PATIENT MANAGEMENT".equals(action))
	{this.dispose();
		new vPatientManagement();
	}
	else if("FIX APPOINTMENT".equals(action))
	{this.dispose();
	new vAppointment();
		
	}
	else if("DOCTOR SCHEDULE MANAGEMENT".equals(action)){
		this.dispose();
		try {
			new vAddASchedule();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
}
