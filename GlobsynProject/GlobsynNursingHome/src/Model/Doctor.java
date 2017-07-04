package Model;

public class Doctor 
{private String DoctorRegistrationId;
private String DoctorName;
private String EmailId;
private String Specialization;
private String ContactNo;
//private String Slot;
/*public String getDoctorSlot(){
	return Slot;
}*/
public String getDoctorRegistrationId()
{
	return DoctorRegistrationId;
	
}
public void setDoctorRegistrationId(String DoctorRegistrationId)
{
	this.DoctorRegistrationId=DoctorRegistrationId;
	
}


public String getDoctorName()
{
	return DoctorName;
	
}
public void setDoctorName(String DoctorName)
{
	this.DoctorName=DoctorName;
	
}

public String getDoctorEmailId()
{
	return EmailId;
	
}
public void setDoctorEmailId(String EmailId)
{
	this.EmailId=EmailId;
	
}


public String getDoctorSpecialization()
{
	return Specialization;
	
}
public void setDoctorSpecialization(String Specialization)
{
	this.Specialization=Specialization;
	
}



public String getDoctorContactNo()
{
	return ContactNo;
	
}
public void setDoctorContactNo(String ContactNo)
{
	this.ContactNo=ContactNo;
	
}
public String toString(){
	return DoctorRegistrationId+" "+DoctorName+" "+EmailId+" "+Specialization+" "+ContactNo;
}


}
