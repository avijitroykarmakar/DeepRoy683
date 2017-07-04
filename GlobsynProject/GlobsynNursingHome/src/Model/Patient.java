package Model;

public class Patient 
{
	private String PatientId;
	private String PatientName;
	private String EmailId;
	private String Problem;
	private String ContactNo;
	//private String Slot;
	/*public String getDoctorSlot(){
		return Slot;
	}*/
	public String getPatientId()
	{
		return PatientId;
		
	}
	public void setPatientId(String PatientId)
	{
		this.PatientId=PatientId;
		
	}


	public String getPatientName()
	{
		return PatientName;
		
	}
	public void setPatientName(String PatinetName)
	{
		this.PatientName=PatinetName;
		
	}

	public String getPatientEmailId()
	{
		return EmailId;
		
	}
	public void setPatientEmailId(String EmailId)
	{
		this.EmailId=EmailId;
		
	}


	public String getProblem()
	{
		return Problem;
		
	}
	public void setProblem(String Problem)
	{
		this.Problem=Problem;
		
	}



	public String getPatientContactNo()
	{
		return ContactNo;
		
	}
	public void setPatientContactNo(String ContactNo)
	{
		this.ContactNo=ContactNo;
		
	}
	public String toString(){
		return PatientId+" "+PatientName+" "+EmailId+" "+Problem+" "+ContactNo;
	}
}
