package View;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class MainClass  {
	
	public static void main(String[] args) throws IOException
	{
		new vLoginForm();
	
			
		//new vScheduleList();
		//Date date = new Date();  
	   // SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	   //String strDate= formatter.format(date); 
	   //System.out.println("02:56".substring(0,2));
	    		//System.out.println(new SimpleDateFormat("dd/mm/yyyy"));
	//String s=new DateSim).toString();
	//System.out.println(strDate);
	    /*String day2="",month2="",year2="";
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
		if(c==2){
			year2=year2+x;
		}
	}
	Date date2 = new Date(2015, 1, 21);

	boolean after = date2.after(new Date(Integer.parseInt(year2),Integer.parseInt(month2),Integer.parseInt(day2)));
	   System.out.println("Date 2 is after date: " + after);
		  // create 2 dates
		/*   Date date = new Date(2016, 5, 21);
		   Date date2 = new Date(2015, 1, 21);

		   //tests if date 2 is after date and print
		   boolean after = date2.after(date);
		   System.out.println("Date 2 is after date: " + after);

		   // tests if date is after date 2 and print
		   after = date.after(date2);
		   System.out.println("Date is after date 2: " + after);*/


	}

}
//Sun Jun 18 00:12:44 IST 2017
//wday mon mday time tz year