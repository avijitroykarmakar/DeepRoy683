package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import Controller.PatientOperator;

public class vAddAPatient extends JFrame implements ActionListener
{
	JLabel jlname,jlreg,jlcontact,jlemail,jlspec;
	JTextField jtname,jtreg,jtcontact,jtemail;
	JComboBox bx;
	JButton jb1,jb4;
	String[] problem={"--select--","Orthopadedic","GastroMedicine","Ent","Neurology","Cardiology","PaediatricMedicine","Dental"};

public vAddAPatient()
 {
	 setBounds(0, 0,1000, 700);
	 setVisible(true);
	 setTitle("ADD PATIENT INFORMATION");
	 setDefaultCloseOperation(EXIT_ON_CLOSE);
	 setLayout(null);
	 jb4=new JButton("Back");
	 jb4.setBounds(50, 620, 100, 40);
	 add(jb4);
	 jb4.addActionListener(this);
	 jlname=new JLabel("NAME: ");
	 jlname.setBounds(150, 250, 120, 50);
	 add(jlname);
	 jtname=new JTextField();
	 jtname.setBounds(300,265, 150,20);
	 add(jtname);
	 jlreg=new JLabel("REGISTRATION NO:");
	 jlreg.setBounds(150, 300, 150, 50);
	 add(jlreg);
	 jtreg=new JTextField();
	 jtreg.setBounds(300,315, 150,20);
	 add(jtreg);
	 jlcontact=new JLabel("CONTACT NO : ");
	 jlcontact.setBounds(150, 350, 120, 50);
	 add(jlcontact);
	 jtcontact=new JTextField();
	 jtcontact.setBounds(300,367, 150,20);
	 add(jtcontact);
	 
	 jlemail=new JLabel("Email Id: ");
	 jlemail.setBounds(150, 400, 120, 50);
	 add(jlemail);
	 jtemail=new JTextField();
	 jtemail.setBounds(300,417, 150,20);
	 add(jtemail);
	 jlspec=new JLabel("Problem ");
	 jlspec.setBounds(150, 450, 120, 50);
	 add(jlspec);
	 bx=new JComboBox(problem);
	 bx.setBounds(300,470,150,40);
	 add(bx);
	 jb1=new JButton("SUBMIT");
	 jb1.setBounds(300, 550, 100,30);
	 add(jb1);
	 jb1.addActionListener(this);
		
 }
	public void actionPerformed(ActionEvent e)
	{
		int c1=0;
		boolean mail=false;
			String action=e.getActionCommand();
			if("SUBMIT".equals(action)){
				if("".equals(jtname.getText()))
					JOptionPane.showMessageDialog(this, "Can't keep the name field empty");
				 if("".equals(jtreg.getText()))
					JOptionPane.showMessageDialog(this, "Can't keep the id field empty");
				 if("".equals(jtcontact.getText()))
					JOptionPane.showMessageDialog(this, "Can't keep the contact field empty");
				 if("".equals(jtemail.getText()))
					JOptionPane.showMessageDialog(this, "Can't keep the email field empty");
				 if("--select--".equals(bx.getSelectedItem().toString()))
					JOptionPane.showMessageDialog(this, "Select a valid specialization from from the combo box");
				 if(jtcontact.getText().length()!=10){
					JOptionPane.showMessageDialog(this, "Enter a valid contact");
				}
				if(!"".equals(jtreg.getText()))
				{
					try
				{
					BufferedReader br=new BufferedReader(new FileReader("PatientDatabase.txt"));
					String h;
					ArrayList<Integer> a=new ArrayList<Integer>();
						h=br.readLine();
						while(h!=null)
						{
							int c=0;
						String DoctorRegitrationId="";
						String DoctorIdCon="";
						String Specialization="";
						String EmailId="";
						String Name="";
						String ContactNo="";
						for(int i=0;i<h.length();i++)
						{String x="";
						x=x+h.charAt(i);
							if(" ".equals(x))
							{
								c++;
								continue;
							}
							if(c==0)
							{
								DoctorIdCon=DoctorIdCon+x;
								
							}
							if(c==1)
							{
								Name=Name+x;
							}
							if(c==2){
								EmailId=EmailId+x;
							}
							if(c==3)
							{
								Specialization=Specialization+x;
							}
							if(c==4)
							{ContactNo=ContactNo+x;
								
							}
						}
						a.add(Integer.parseInt(DoctorIdCon));
						h=br.readLine();
						}
						int k1=Integer.parseInt(jtreg.getText());
						
						for(int i:a){
							if(i==k1)
								c1=1;
						}
						if(c1==1)
							JOptionPane.showMessageDialog(this, "Enter a unique reg id");
							
						}
				
				catch(IOException u)
					{
					u.printStackTrace();
				}

				}
				if(!"".equals(jtemail.getText()))
				{
		mail=	this.jtemail.getText().matches("[a-zA-Z0-9\\.]+@[a-zA-Z0-9\\-\\_\\.]+\\.[a-zA-Z0-9]{3}");
					if(!mail)
					{
						JOptionPane.showMessageDialog(this, "Enter a valid email id");
					}
					
				}
				
				if(c1==0&&mail==true)
				{
					new PatientOperator().AddPatient(jtname.getText(),jtreg.getText(),jtcontact.getText(), jtemail.getText(),bx.getSelectedItem().toString());
				}

	}
			if("Back".equals(action))
			{
			this.dispose();
			new vPatientManagement();
			}
	


	}
}

