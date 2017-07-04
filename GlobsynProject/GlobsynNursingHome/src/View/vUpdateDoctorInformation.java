package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Model.Doctor;

public class vUpdateDoctorInformation extends JFrame implements ActionListener
{JLabel jlname,jlcontact,jtreg1,jlemail,jlspec;
JTextField jtname,jtcontact,jtemail;
JTextField bx;
JComboBox jtreg;
JButton jb1,jb2,jb4;

	public vUpdateDoctorInformation() throws IOException
	{BufferedReader br=new BufferedReader(new FileReader("DoctorDatabase.txt"));
	String h;
	ArrayList<String> a=new ArrayList<String>();
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
			if(" ".equals(x)){
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
		a.add(DoctorIdCon);
		h=br.readLine();
		}
	
		setBounds(0, 0,1000, 700);
		 setVisible(true);
		 setTitle("SELECT DOCTOR REGISTRATION NO:");
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
		 jtreg1=new JLabel("REGISTRATION NO:");
		 jtreg1.setBounds(150, 300, 150, 50);
		 add(jtreg1);
		 jtreg=new JComboBox(a.toArray());
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
		 jlspec=new JLabel("specialization ");
		 jlspec.setBounds(150, 450, 120, 50);
		 add(jlspec);
		 bx=new JTextField();
		 bx.setBounds(300,470,150,40);
		 add(bx);
		 jb1=new JButton("FIND");
		 jb1.setBounds(300, 550, 100,30);
		 add(jb1);
		 jb2=new JButton("UPDATE");
		 jb2.setBounds(450, 550, 100,30);
		 add(jb2);
		 jb1.addActionListener(this);
		 jb2.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String action=e.getActionCommand();
		if("FIND".equals(action))
		{try{
			BufferedReader br=new BufferedReader(new FileReader("DoctorDatabase.txt"));
		String h;
		ArrayList<String> a=new ArrayList<String>();
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
				if(" ".equals(x)){
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
			if(jtreg.getSelectedItem().equals(DoctorIdCon))
			{
				jtname.setText(Name);
				jtcontact.setText(ContactNo);
				jtemail.setText(EmailId);
				bx.setText(Specialization);
				break;
			}
			h=br.readLine();
			}
		}
		catch(IOException k){
			k.getMessage();
		}
			
		}
		if("UPDATE".equals(action))
		{ArrayList<Doctor> a=new ArrayList<Doctor>();
			try{
				BufferedReader br=new BufferedReader(new FileReader("DoctorDatabase.txt"));
				
			String h;
			
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
					if(" ".equals(x)){
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
				
				if(jtreg.getSelectedItem().equals(DoctorIdCon))
				{
					
					Doctor k=new Doctor();
					k.setDoctorRegistrationId(DoctorIdCon);
					k.setDoctorContactNo(jtcontact.getText());
					k.setDoctorEmailId(jtemail.getText());
					k.setDoctorSpecialization(bx.getText());
					k.setDoctorName(jtname.getText());
					a.add(k);
					
					
					
				}
				else{
					Doctor k=new Doctor();
					k.setDoctorRegistrationId(DoctorIdCon);
					k.setDoctorContactNo(ContactNo);
					k.setDoctorEmailId(EmailId);
					k.setDoctorSpecialization(Specialization);
					k.setDoctorName(Name);
					a.add(k);
										
					
				}
		
				
				
						h=br.readLine();
				}
				br.close();
				PrintWriter pw=new PrintWriter("DoctorDatabase.txt");
				for(Doctor v:a)
					pw.println(v);
				pw.flush();
				
			}
			catch(IOException k){
				k.getMessage();
			}
			
		
		}
		if("Back".equals(action))
		{
			this.dispose();
			new vDoctorManagement();
		}
	}

}
