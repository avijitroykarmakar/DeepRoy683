package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class vDoctorManagement extends JFrame implements ActionListener
{JButton jb1,jb2,jb3,jb4;
	public vDoctorManagement()
	{
		
	 setBounds(0, 0,1000, 700);
	 setVisible(true);
	 setTitle("DOCTOR MANAGEMENT");
	 setDefaultCloseOperation(EXIT_ON_CLOSE);
	 setLayout(null);
	jb1=new JButton("ADD DOCTOR");
	 jb1.setBounds(150, 250, 200, 50);
	 add(jb1);
	 jb2=new JButton("VIEW DOCTOR LIST");
	 jb2.setBounds(370, 250, 170, 50);
	 add(jb2);
	 jb3=new JButton("UPDATE DOCTOR INFORMATION");
	 jb3.setBounds(600, 250, 350, 50);
	 add(jb3);
	 jb4=new JButton("Back");
	 jb4.setBounds(50, 620, 100, 40);
	 add(jb4);
	 jb4.addActionListener(this);
	 jb1.addActionListener(this);
	 jb2.addActionListener(this);
	 jb3.addActionListener(this);
	 
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{

		String action=e.getActionCommand();
		if("ADD DOCTOR".equals(action))
		{this.dispose();
			new vAddADoctor();
		}
		else if("VIEW DOCTOR LIST".equals(action))
		{this.dispose();
			try
			{
				new vDoctorList();
			} catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
			else if("UPDATE DOCTOR INFORMATION".equals(action))
			{this.dispose();
				try {
					new vUpdateDoctorInformation();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if("Back".equals(action))
			{
				this.dispose();
				new VopeningForm();
			}
		}
	}


