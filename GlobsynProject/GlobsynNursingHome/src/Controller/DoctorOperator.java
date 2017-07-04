package Controller;
import java.io.*;


import Model.Doctor;
//import View.*;
public class DoctorOperator 
{
	public void AddDoctor( String DoctorName,String DoctorRegistrationId, String ContactNo,String EmailId,String Specialization)
{
		Doctor j=new Doctor();
		j.setDoctorName(DoctorName);
		j.setDoctorContactNo(ContactNo);
		j.setDoctorEmailId(EmailId);
		j.setDoctorSpecialization(Specialization);
		j.setDoctorRegistrationId(DoctorRegistrationId);
		try {
			PrintWriter pw=new PrintWriter(new FileOutputStream(new File("DoctorDatabase.txt"),true));
			pw.println(j);
			pw.flush();
			pw.close();
		} 
		catch (FileNotFoundException e) {
			System.out.print("File not found");
		}
 
	
}

}
