package View;
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
import Controller.*;
public class vAppointment extends JFrame implements ActionListener
{
 JLabel jprob,jpatientid,jdoctor,jtime,jdate;
 JTextField jtext,cproblem,ctime;
 JButton jsearch,japp,searchDoctor,jb4,jb5;
 JComboBox cpatientid,cdoctor;
 public vAppointment()
 {
	 ArrayList<String> a=new ArrayList<String>();
	 
	 try {BufferedReader br=new BufferedReader(new FileReader("PatientDatabase.txt"));
		String h;
			h=br.readLine();
			while(h!=null)
			{
				int c=0;
			String PatientId="";
			String PatientIdCon="";
			String Problem="";
			String EmailId="";
			String Name="";
			String ContactNo="";
			for(int i=0;i<h.length();i++)
			{
				String x="";
			x=x+h.charAt(i);
				if(" ".equals(x)){
					c++;
					continue;
				}
				if(c==0)
				{
					PatientIdCon=PatientIdCon+x;
					
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
					Problem=Problem+x;
				}
				if(c==4)
				{ContactNo=ContactNo+x;
					
				}
			}
			a.add(PatientIdCon);
			h=br.readLine();
			}
			br.close();
	 }
	 catch(IOException e)
	 {
		 
	 }
	 
		 
	 
	 setBounds(0, 0,1000, 700);
	 setVisible(true);
	 setTitle("APPOINTMENT FORM(One time selection only)");
	 setDefaultCloseOperation(EXIT_ON_CLOSE);
	 setLayout(null);
	 jprob=new JLabel("Problem");
	 jprob.setBounds(60,70, 120,30);
	 add(jprob);
	 cproblem=new JTextField();
	 cproblem.setBounds(120,70,120,30);
	 add(cproblem);
	 jpatientid=new JLabel("Patient Id");
	 jpatientid.setBounds(60,30, 120,30);
	 add(jpatientid);
	 cpatientid=new JComboBox(a.toArray());
	 cpatientid.setBounds(120,30,120,30);
	 add(cpatientid);
	 jdate=new JLabel("Date ");
	 jdate.setBounds(270,70, 120,30);
	 add(jdate);
	 jtext=new JTextField();
	 jtext.setBounds(300,70, 120,30);
	 add(jtext);
	 jsearch=new JButton("Search");
	 jsearch.setBounds(120,120,80,40);
	 add(jsearch);
	 jdoctor=new JLabel("Doctor");
	 jdoctor.setBounds(60,180, 120,30);
	 add(jdoctor);
	cdoctor=new JComboBox();
	 cdoctor.setBounds(120,180,120,30);
 add(cdoctor);
	 searchDoctor=new JButton("Search time");
	 searchDoctor.setBounds(250, 180, 120, 30);
	 add(searchDoctor);
	 searchDoctor.addActionListener(this);
	 jtime=new JLabel("Time");
	 jtime.setBounds(60,220, 120,30);
	 add(jtime);
	 ctime=new JTextField();
	 ctime.setBounds(120,220,120,30);
	 add(ctime);
	 japp=new JButton("ConFirm Appointment");
	 japp.setBounds(120,260,220,40);
	 add(japp);
	 japp.addActionListener(this);
	 jsearch.addActionListener(this);
	 jb4=new JButton("Back");
	 jb4.setBounds(50, 620, 100, 40);
	 add(jb4);
	 jb4.addActionListener(this);
	 jb5=new JButton("Show Schedule");
	 jb5.setBounds(500, 20, 200, 70);
	 add(jb5);
	 jb5.addActionListener(this);
 }

public void actionPerformed(ActionEvent e) 
{boolean after=false;
	String action=e.getActionCommand();
	if("Search".equals(action))
	{if("".equals(jtext.getText()))
	{
JOptionPane.showMessageDialog(this,"enter date ");
}
if(!"".equals(jtext.getText()))
{
String date=jtext.getText();
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

		

		try{
			BufferedReader br=new BufferedReader(new FileReader("PatientDatabase.txt"));
		String h;
	
			h=br.readLine();
			
			while(h!=null)
			{//System.out.println(h);
				int c=0;
			String PatientId="";
			String PatientIdCon="";
			String Problem="";
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
					PatientIdCon=PatientIdCon+x;
					
				}
				
				if(c==3)
				{
					Problem=Problem+x;
				}
				
				
			}
			if(cpatientid.getSelectedItem().equals(PatientIdCon))
			{
				cproblem.setText(Problem);
				
				break;
			}
			//System.out.println(PatientIdCon);
			h=br.readLine();
			}
			br.close();
		}
		catch(IOException k)
		{
			k.getMessage();
		}
		ArrayList<String> a=new ArrayList<String>();
		try {File f=new File("SheduleDatabase.txt");
		//System.out.println("hjk");
		if(!f.exists())
			f.createNewFile();
			BufferedReader br=new BufferedReader(new FileReader("SheduleDatabase.txt"));
			String h;
			
			h=br.readLine();
			//System.out.println(h);
			
			while(h!=null)
			{int c=0;
				String id="",spec="",date="";
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
				if(c==2)
				{
					spec=spec+x;
				}
				if(c==7)
				{
					date=date+x;
				}
					
				}
				//System.out.println(id+" "+date+" "+spec);
				if(date.equals(jtext.getText())&& spec.equals(cproblem.getText()))
				{//System.out.println(id);
				a.add(id);	
				}
				h=br.readLine();
				
			}
			
		} 
		catch (IOException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ArrayList<String> b=new ArrayList<String>();
		for(String id:a)
		{//System.out.println(id);
			try {File f=new File("AppointmentDatabase.txt");
			if(!f.exists())
				f.createNewFile();
			BufferedReader br=new BufferedReader(new FileReader("AppointmentDatabase.txt"));
			String h=br.readLine();
			//System.out.println(h);
			boolean ef=false,na=false,nava=false;//empty file,no appointment,no availability
			while(h!=null)
			{ef=true;
				int c=0;
			String d="",ava="",sts="",did="";
				for(int i=0;i<h.length();i++)
				{
					String x="";
					x=x+h.charAt(i);
					if(" ".equals(x))
					{c++;
					continue;
						
					}
					if(c==1)
					{
					did=did+x;	
					}
					if(c==7)
					{
						d=d+x;
					}
					if(c==8)
					{
						ava=ava+x;
					}
					if(c==9)
					{
						sts=sts+x;
					}
				}
				if(jtext.getText().equals(d)&&did.equals(id)&&(!(Integer.parseInt(ava)==Integer.parseInt(sts))))
				{na=true;
				//System.out.println(d+" "+id);
					//dlst=did;
				}
				
				if(jtext.getText().equals(d)&&did.equals(id)&&Integer.parseInt(ava)==Integer.parseInt(sts))//no parsing occuring with Integer.parseInt()
				{
					nava=true;
					
					break;
				}
			h=	br.readLine();
			}
			if(ef==false)
			{
				b.add(id);
			}
			if(ef==true&&na==false)
			{
				b.add(id);
			}
			if(ef==true&&na==true&&nava==false)
			{
				b.add(id);
			}
			} 
			catch (IOException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		//System.out.println(b);
			//for(String id:b)
			//	System.out.println(id);
		if(b.size()==0)
		{
			JOptionPane.showMessageDialog(this,"no doctors available");
		}
		cdoctor.removeAllItems();
		for(String s:b)
		{
		cdoctor.addItem(s);
		
		}
		//cdoctor=new JComboBox(b.toArray());
		//cdoctor.setBounds(120,180,120,30);
		//add(cdoctor);
		
				
	
	}
	if("Search time".equals(action))
	{if("".equals(jtext.getText()))
	{
JOptionPane.showMessageDialog(this,"enter date ");
}
if(!"".equals(jtext.getText()))
{
String date=jtext.getText();
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
 if(after==false)
 {
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

if(!"".equals(cdoctor.getSelectedItem())&& after==true)
{
	try{File f=new File("SheduleDatabase.txt");
	if(!f.exists())
		f.createNewFile();
	BufferedReader br=new BufferedReader(new FileReader("SheduleDatabase.txt"));
	String h=br.readLine();
	while(h!=null)
	{
		String id="",sthh="",stmm="",enhh="",enmm="",date="";
		int c=0;
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
		if(c==7)
			{
			date=date+x;	
			}
		}
		if(date.equals(jtext.getText())&&id.equals(cdoctor.getSelectedItem()))
		{
			ctime.setText(sthh+":"+stmm+" to "+enhh+":"+enmm);
			//System.out.println(after);
			break;
		}
		h=br.readLine();
	}
		
	}
	catch(IOException p)
	{
		
	}
}
//System.out.println("true");
	}	
	//System.out.println(after+"123");
	if("ConFirm Appointment".equals(action))
	{//System.out.println("Hello");
		if("".equals(cproblem)||"".equals(jtext.getText())||"".equals(ctime.getText()))
		{
			
			JOptionPane.showMessageDialog(this,"Required fields are not filled");
			
		}
		if(!"".equals(cproblem)&&!"".equals(jtext.getText())&&"".equals(ctime.getText()))
		{
		JOptionPane.showMessageDialog(this,"No Doctor Available");	
		}
		if(!"".equals(cproblem)&&!"".equals(jtext.getText())&&!"".equals(ctime.getText()))
		{
			new AppointmentController().AddAppointment(cpatientid.getSelectedItem().toString(), cdoctor.getSelectedItem().toString(), cproblem.getText(), ctime.getText().substring(0, 2), ctime.getText().substring(3, 5), ctime.getText().substring(9, 11), ctime.getText().substring(12), jtext.getText());
		}
	}
	if("Back".equals(action))
	{
	this.dispose();
	new VopeningForm();
	}
	if("Show Schedule".equals(action))
	{
	try {
		new vScheduleList();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}	
	}

}
}