package View;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controller.ScheduleOperator;

public class vAddASchedule extends JFrame implements ActionListener
{
	JLabel jlname,jlDoctorId,jlspec,jlotm,jlctm,jlst,jlet,jldt;
JTextField jtname,jtspec,jtst,jtet,jtdt;
JComboBox jtreg;
 JButton jbFind,jbAdd,jb4;

	public vAddASchedule() throws IOException 
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
		 setTitle("ADD A SCHEDULE(24HR FORMAT)");
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 setLayout(null);

		 jlname=new JLabel("NAME: ");
		 jlname.setBounds(150, 300, 120, 50);
		 add(jlname);
		 jtname=new JTextField();
		 jtname.setBounds(300,310, 120,35);
		 add(jtname);
		 jlDoctorId=new JLabel("REGISTRATION ID");
		 jlDoctorId.setBounds(150, 250, 150, 50);
		 add(jlDoctorId);
		 jtreg=new JComboBox(a.toArray());
		 jtreg.setBounds(300,265, 150,35);
		 add(jtreg);
		 jlspec=new JLabel("Specialization: ");
		 jlspec.setBounds(150, 375, 120, 50);
		 add(jlspec);
		 jtspec=new JTextField();
		 jtspec.setBounds(300,375,120,35);
		 add(jtspec);
		 jbFind=new JButton("FIND");
		 jbFind.setBounds(300,420,120,35);
		 jbFind.addActionListener(this);
		 add(jbFind);
		 jlst=new JLabel("Starting hh:mm");
		 jlst.setBounds(150,470,120,35);
		 add(jlst);
		 jtst=new JTextField();
		 jtst.setBounds(300,470,120,35);
		 add(jtst);
		 jlet=new JLabel("Ending hh:mm");
		 jlet.setBounds(150,515,120,35);
		 add(jlet);
		 jtet=new JTextField();
		 jtet.setBounds(300,515,120,35);
		 add(jtet);
		 jldt=new JLabel("DATE:");
		 jldt.setBounds(150,560,120,35);
		 add(jldt);
		 jtdt=new JTextField("date");
		 jtdt.setBounds(300,560,120,35);
		 add(jtdt);
		 jbAdd=new JButton("ADD");
		 jbAdd.setBounds(250,610,120,35);
		 jbAdd.addActionListener(this);
		 add(jbAdd);
		 jb4=new JButton("Back");
		 jb4.setBounds(50, 620, 100, 40);
		 add(jb4);
		 jb4.addActionListener(this);
	}

	
	public void actionPerformed(ActionEvent e) 
	{String action=e.getActionCommand();
	boolean after=false;
	boolean tv=false;
	if(action.equals("FIND"))
	{
	
		try{
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
				
				
				jtspec.setText(Specialization);
				break;
			}
			h=br.readLine();
			}
		}
		catch(IOException k){
			k.getMessage();
		}
	}
	if(action.equals("ADD"))
	{
		if("".equals(jtname.getText()))
		{
			JOptionPane.showMessageDialog(this,"Select id from the list and click on find to get the doctor");
		}
		if("".equals(jtspec.getText()))
		{
		JOptionPane.showMessageDialog(this,"Select id from the list and click on find to get the doctor");	
		}
		if("".equals(jtdt.getText()))
		{
		JOptionPane.showMessageDialog(this,"Please enter the date");	
		}
		if("".equals(jtst.getText()))
		{
			JOptionPane.showMessageDialog(this,"Enter starting time");
		}
		if("".equals(jtet.getText()))
		{
			JOptionPane.showMessageDialog(this,"Enter ending time");
		}
		if(!"".equals(jtdt.getText()))
		{
		String date=jtdt.getText();
		int dc=0,day=0,month=0,year=0;
		String day1="",month1="",year1="";
		for(int i=0;i<date.length();i++)
		{String c="";
		c=c+date.charAt(i);
			if("/".equals(c))
			{
				dc++;
				continue;
				}
			if(dc==0)
			{
				day1=day1+c;
			}
			if(dc==1)
			{
				month1=month1+c;
			}
			if(dc==2)
			{
				year1=year1+c;
			}
		}
		if(day1.length()==2&& month1.length()==2 && year1.length()==4)
		{
		try{
			day=Integer.parseInt(day1);
		
		month=Integer.parseInt(month1);
		year=Integer.parseInt(year1);
		//System.out.println(day+" "+month+" "+year);
		}
		catch(NumberFormatException p)
		{
			JOptionPane.showMessageDialog(this,"incorrect  date format");
			}
		boolean Validmonth = (month >= 1 && month <= 12);
		
		         int mday=0;
		
		boolean    Validyear = (year >= 1590 && year <= 2400);
		
		 boolean   leapyear =((year % 4) == 0 && ((year % 100) != 0) || (year % 400) == 0);        
		
		     if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)		
		     mday = 31;
		
		     if (month == 4 || month == 6 || month == 9 || month == 11)		
		     mday = 30;
		
		     if (month == 2)		
		     {mday = 28;
		
		     if (leapyear)		
		    	 mday = 29;
		     }
		
		  boolean  Validday = (day >= 1);
		
		    Validday = (day <= mday);
		    
		
		    if (Validmonth == true && Validday == true && Validyear == true )
		    {//System.out.println("pass");
		    	Date date2 = new Date();  
		    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		    String strDate= formatter.format(date2);
		    String day2="",month2="",year2="";
			int c=0;
			for (int i=0;i<strDate.length();i++)
			{
				String x="";
				x=x+strDate.charAt(i);
				if("/".equals(x))
				{c++;	
				continue;	
				}
				if(c==0)
				{
				day2=day2+x;	
				}
				if(c==1)
				{month2=month2+x;
					
				}
				if(c==2)
				{
					year2=year2+x;
				}
			}
			//System.out.println(day2+" "+month2+" "+year2);
			//System.out.println(day+" "+month+" "+year);
			Date date3 = new Date(year,month, day);

			 after = date3.after(new Date(Integer.parseInt(year2),Integer.parseInt(month2),Integer.parseInt(day2))); 
			 if(after==false){
				 JOptionPane.showMessageDialog(this,"Don't enter previous dates");
			 }
		    	//System.out.println(after);
		    }
		    else{
		    	JOptionPane.showMessageDialog(this, "Invalid date");
		    }
		}
		else
		{
		JOptionPane.showMessageDialog(this,"input correct date ");	
		}
		}
		if(!"".equals(jtst.getText())&&!"".equals(jtet.getText()))
		{//System.out.println(after);
			String shh="",smm="",ehh="",emm="";
		int c=0;
			String jtst1=jtst.getText(),jtet1=jtet.getText();
			for(int i=0;i<jtst1.length();i++)
			{
				String x="";
				x=x+jtst1.charAt(i);
				if(":".equals(x))
				{
				c++;
				continue;
				}
				if(c==0)
				{
					shh=shh+x;
				}
				if(c==1)
				{
					smm=smm+x;
				}
			}
			//System.out.println(shh+" "+smm);
			c=0;
			for(int i=0;i<jtet1.length();i++)
			{
				String x="";
				x=x+jtet1.charAt(i);
				if(":".equals(x))
				{
				c++;
				continue;
				}
				if(c==0)
				{
					ehh=ehh+x;
				}
				if(c==1)
				{
					emm=emm+x;
				}
			}
			int shhi=0,smmi=0,ehhi=0,emmi=0;
			try{
				shhi=Integer.parseInt(shh);
				smmi=Integer.parseInt(smm);
				ehhi=Integer.parseInt(ehh);
				emmi=Integer.parseInt(emm);
			}
			catch(Exception r)
			{
				JOptionPane.showMessageDialog(this,"Incorrect time format");
			}
			System.out.println(shhi+" "+smmi+" "+ehhi+" "+emmi);
			if(((shhi>=0)&&(shhi<=23))&&((smmi>=0)&&(smmi<=60))&&((ehhi>=0)&&(ehhi<=23))&&((emmi>=0)&&(emmi<=60)))
			{
				if(ehhi==shhi)
				{
					if(emmi>smmi)
				{
					tv=true;
				}
					else
					{
						JOptionPane.showMessageDialog(this, "wrong timing");
					}
				}
				if(ehhi>shhi)
				{
					tv=true;
				}
			if(ehhi<shhi)
				{
					JOptionPane.showMessageDialog(this, "wrong timing");
				}
				
			}
		}
		if(tv==true && after==true)
		{//System.out.println("hello");
			boolean tc=false,tf=false;
			try {File f=new File("SheduleDatabase.txt");
			if(!f.exists())
				f.createNewFile();
				BufferedReader br=new BufferedReader(new FileReader("SheduleDatabase.txt"));
				ArrayList<String> a=new ArrayList<String>();
				String h;
				h=br.readLine();
				String d="",id="",sthh="",stmm="",enhh="",enmm="";
				
				while(h!=null)
				{int c=0,s=0;
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
						id=id+x;	
						}
						if(c==7)
						{
							d=d+x;
						}
						if(c==3)
						{
							sthh=sthh+x;
						}
						if(c==4)
						{
						stmm=stmm+x;	
						}
						if(c==5)
						{
						enhh=enhh+x;	
						}
						if(c==6)
						{
						enmm=enmm+x;	
						}
					
					}
					
					if(d.equals(jtdt.getText())&&id.equals(jtreg.getSelectedItem().toString()))
					{//String gsthh=jtst.getText().substring(0,2),gstmm=jtst.getText().substring(3),genhh=jtet.getText().substring(0,2),genmm=jtet.getText().substring(3);
					
					
						tc=false;
						tf=true;
						JOptionPane.showMessageDialog(this,"appointment for the doctor on this date has already been booked");
			break;
					}
					h=br.readLine();
					}
					
				}
				
			
			catch (IOException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		if(tc||tc==false&& tf==false)
		{this.dispose();
new ScheduleOperator().AddSchedule(jtreg.getSelectedItem().toString(), jtspec.getText(), jtname.getText(), jtst.getText().substring(0,2), jtet.getText().substring(0,2), jtst.getText().substring(3), jtet.getText().substring(3), jtdt.getText());	
		JOptionPane.showMessageDialog(this,"appointment booked");
		}
		}
		
		
		
	}
	if("Back".equals(action))
	{
	this.dispose();
	new VopeningForm();
	}
		
	}
}
	

