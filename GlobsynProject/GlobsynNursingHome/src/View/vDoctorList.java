package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import Model.Doctor;

public class vDoctorList extends JFrame implements ActionListener
{
	JButton jb4;
	public vDoctorList()throws IOException
	{setBounds(0, 0,1000, 700);
	 setVisible(true);
	 setTitle("Doctor Database");
	 setDefaultCloseOperation(EXIT_ON_CLOSE);
	 
	 jb4=new JButton("Back");
	 jb4.setBounds(50, 620, 100, 40);
	 add(jb4);
	 jb4.addActionListener(this);
		String h1;
	BufferedReader br2,br;

		br2=new BufferedReader(new FileReader("DoctorDatabase.txt"));
		h1=br2.readLine();
	
	
		int counter=3;
		while(h1!=null){
			counter++;
			h1=br2.readLine();
		}
		br2.close();

		String h="";
	
	br=new BufferedReader(new FileReader("DoctorDatabase.txt"));
		h=br.readLine();
	
	ArrayList<Doctor> a=new ArrayList<Doctor>();
	String[][] m=new String[counter][5];
	
	
int y=0;
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
		
			//m[i][0]=new Object();
		DoctorRegitrationId=DoctorIdCon;
			m[y][0]=DoctorRegitrationId;
			//m[i][1]=new Object();
			m[y][1]=Name;
		//	m[i][2]=new Object();
			m[y][2]=EmailId;
		//	m[i][3]=new Object();
			m[y][3]=Specialization;
		//	m[i][4]=new Object();
			m[y][4]=ContactNo;
		
	y++;
		h=br.readLine();
	}
	br.close();
	String[] jo={"RegId","Name","EmailId","Specialization","ContactNo"};
	JTable table=new JTable(m,jo);
	table.setPreferredScrollableViewportSize(new Dimension(500,80));
	JScrollPane pane=new JScrollPane(table);
	getContentPane().add(pane,BorderLayout.CENTER);
	
	
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		String action=e.getActionCommand();
		if("Back".equals(action))
		{this.dispose();
		new vDoctorManagement();
			
		}
	}

	}


