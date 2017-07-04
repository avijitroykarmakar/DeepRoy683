package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import Model.Patient;

public class PatientOperator 
{
	public void AddPatient( String PatientName,String PatientId, String ContactNo,String EmailId,String Problem)
{
		Patient j=new Patient();
		j.setPatientName(PatientName);
		j.setPatientContactNo(ContactNo);
		j.setPatientEmailId(EmailId);
		j.setProblem(Problem);
		j.setPatientId(PatientId);
		try {
			PrintWriter pw=new PrintWriter(new FileOutputStream(new File("PatientDatabase.txt"),true));
			pw.println(j);
			pw.flush();
			pw.close();
		} 
		catch (FileNotFoundException e)
		{
			System.out.print("File not found");
		}
 
	
}
}
