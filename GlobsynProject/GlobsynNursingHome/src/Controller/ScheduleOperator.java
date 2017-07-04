package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import Model.Shedule;

public class ScheduleOperator 
{
public void AddSchedule( String Id,String Specialization, String name, String sthr, String enhr,String stmn,String enmn,String date)
{

	Shedule j=new Shedule();
	j.setId(Id);
	j.setdate(date);
	j.setenhr(enhr);
	j.setenmn(enmn);
	j.setsthr(sthr);
	j.setstmn(stmn);
	j.setname(name);	
	j.setSpecialization(Specialization);
	try {
		PrintWriter pw=new PrintWriter(new FileOutputStream(new File("SheduleDatabase.txt"),true));
		pw.println(j);
		pw.flush();
		pw.close();
	} 
	catch (FileNotFoundException e) {
		System.out.print("File not found");
	}
}
}
