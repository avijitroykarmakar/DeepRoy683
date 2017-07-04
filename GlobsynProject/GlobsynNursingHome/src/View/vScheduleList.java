package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Model.Doctor;
import Model.Shedule;

public class vScheduleList extends JFrame implements ActionListener
{
 public vScheduleList()throws IOException
 {
	 setBounds(0, 0,1000, 700);
	 setVisible(true);
	 setTitle("Schedule Database");
	 
	 String h1;
		BufferedReader br2,br;

			br2=new BufferedReader(new FileReader("SheduleDatabase.txt"));
			h1=br2.readLine();
		
		
			int counter=0;
			while(h1!=null){
				counter++;
				h1=br2.readLine();
			}
			br2.close();
			String h="";
			br=new BufferedReader(new FileReader("SheduleDatabase.txt"));
			h=br.readLine();
			ArrayList<Shedule> a=new ArrayList<Shedule>();
			String[][] m=new String[counter][8];
			int y=0;
			while(h!=null)
			{
				int c=0;
			String Id="";
			//String DoctorIdCon="";
			String Specialization="";
			//String EmailId="";
			String Name="";
			//String ContactNo="";
			String sthr="",stmn="",enhr="",enmn="",date="";
			for(int i=0;i<h.length();i++)
			{String x="";
			x=x+h.charAt(i);
				if(" ".equals(x)){
					c++;
					continue;
				}
				if(c==0)
				{
					Id=Id+x;
					
				}
				if(c==1)
				{
					Name=Name+x;
				}
				if(c==2){
					Specialization=Specialization+x;
				}
				if(c==3)
				{
					sthr=sthr+x;
				}
				if(c==4)
				{
					stmn=stmn+x;	
				}
				if(c==5)
				{
					enhr=enhr+x;	
				}
				if(c==6)
				{
					enmn=enmn+x;	
				}
				if(c==7)
				{
					date=date+x;
				}
				
			}
				
					//m[i][0]=new Object();
				
					m[y][0]=Id;
					//m[i][1]=new Object();
					m[y][1]=Name;
				//	m[i][2]=new Object();
					m[y][2]=Specialization;
				//	m[i][3]=new Object();
					m[y][3]=sthr;
				//	m[i][4]=new Object();
					m[y][4]=stmn;
					m[y][5]=enhr;
					m[y][6]=enmn;
					m[y][7]=date;
				
			y++;
				h=br.readLine();
			}
			br.close();
			String[] jo={"Id","Name","Specialization","starting hour","starting minute","ending hour","ending minute","date"};
			JTable table=new JTable(m,jo);
			table.setPreferredScrollableViewportSize(new Dimension(500,80));
			JScrollPane pane=new JScrollPane(table);
			getContentPane().add(pane,BorderLayout.CENTER);
			
			

}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
