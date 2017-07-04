package Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Model.Appointment;

public class AppointmentController extends JFrame
{

	public void AddAppointment(String PatientId,String DoctorId,String Problem,String sthh,String stmm,String enhh,String enmm,String date) 
	{
		Appointment j=new Appointment();
		j.setdate(date);
		j.setDoctorId(DoctorId);
		j.setenhh(enhh);
		j.setenmm(enmm);
		j.setPatientId(PatientId);
		j.setProblem(Problem);
		//j.setstatus(status);
		j.setsthh(sthh);
		j.setstmm(stmm);
		int sthh1=Integer.parseInt(j.getsthh());
		int stmm1=Integer.parseInt(j.getstmm());
		int enhh1=Integer.parseInt(j.getenhh());
		int enmm1=Integer.parseInt(j.getenmm());
		if(enhh1>=sthh1){
			if(enmm1>=stmm1){
				double av1=((enhh1-sthh1)+(enmm1-stmm1)/60)/0.5;
				if(av1<0.5){
					JOptionPane.showMessageDialog(this,"its not a visiting time");
					return;
				}
				int av=(int)av1;
				String h="";
				h=h+av;
				
				j.setAvailibility(h);
			}
			if(enmm1<stmm1){
				double av1=((enhh1-sthh1)-(enmm1-stmm1)/60)/0.5;
				if(av1<0.5){
					JOptionPane.showMessageDialog(this,"its not a visiting time");
					return;
				}
				int av=(int)av1;
				String h=""+av;
				j.setAvailibility(h);
			}
		}
		
		try {File f=new File("AppointmentDatabase.txt");
		if(!f.exists())
			f.createNewFile();
		BufferedReader br=new BufferedReader(new FileReader("AppointmentDatabase.txt"));
		String h=br.readLine();
		String d="",ava="",sts="",did="",dlst="";
		boolean ef=false,na=false,nava=false;//empty file,no appointment,no availability
		//System.out.println("hum aa gaye");
		while(h!=null)
		{System.out.println(h);
			ef=true;
			int c=0;
 d="";ava="";sts="";did="";
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
			if(date.equals(d)&&did.equals(DoctorId)&&(!(Integer.parseInt(ava)==Integer.parseInt(sts))))
			{na=true;
			//System.out.println(d+" "+did);
				dlst=sts;
			}
			
			if(date.equals(d)&&did.equals(DoctorId)&&Integer.parseInt(ava)==Integer.parseInt(sts))//no parsing occuring with Integer.parseInt()
			{
				nava=true;
				
				break;
			}
		h=	br.readLine();
		}
		if(ef==false)
		{
			j.setstatus("1");
			try {
				PrintWriter pw=new PrintWriter(new FileOutputStream(new File("AppointmentDatabase.txt"),true));
				pw.println(j);
				pw.flush();
				pw.close();
			} 
			catch (FileNotFoundException e)
			{
				System.out.print("File not found");
			}
	 
		}
		if(ef==true&&na==false)
		{
			j.setstatus("1");
			try {
				PrintWriter pw=new PrintWriter(new FileOutputStream(new File("AppointmentDatabase.txt"),true));
				pw.println(j);
				pw.flush();
				pw.close();
			} 
			catch (FileNotFoundException e)
			{
				System.out.print("File not found");
			}
	 
		}
		if(ef==true&&na==true&&nava==false)
		{
			int i=Integer.parseInt(dlst);
			i++;
			System.out.println(i);
			j.setstatus(""+i);
			try {
				PrintWriter pw=new PrintWriter(new FileOutputStream(new File("AppointmentDatabase.txt"),true));
				pw.println(j);
				pw.flush();
				pw.close();
			} 
			catch (FileNotFoundException e)
			{
				System.out.print("File not found");
			}
	 
		}
		if(ef==true && na==true && nava==true)
		{
			JOptionPane.showMessageDialog(this,"No more slots left for this time");
		}
		} 
		catch (IOException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	
	}
}
