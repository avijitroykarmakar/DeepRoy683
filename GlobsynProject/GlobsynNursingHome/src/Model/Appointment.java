package Model;

public class Appointment 
{
	private String PatientId,DoctorId,Problem,sthh,stmm,enhh,enmm,date,Availibility,status;
public void setPatientId(String PatientId)
{
	this.PatientId=PatientId;
}
public String getPatientId()
{
return PatientId;
}
public void setDoctorId(String DoctorId)
{
	this.DoctorId=DoctorId;
}
public String getDoctorId()
{
return DoctorId;
}
public void setProblem(String Problem)
{
	this.Problem=Problem;
}
public String getProblem()
{
return Problem;
}
public void setsthh(String sthh)
{
	this.sthh=sthh;
}
public String getsthh()
{
return sthh;
}
public void setstmm(String stmm)
{
	this.stmm=stmm;
}
public String getstmm()
{
return stmm;
}
public void setenhh(String enhh)
{
	this.enhh=enhh;
}
public String getenhh()
{
return enhh;
}
public void setenmm(String enmm)
{
	this.enmm=enmm;
}
public String getenmm()
{
return enmm;
}
public void setdate(String date)
{
	this.date=date;
}
public String getdate()
{
return date;
}
public void setstatus(String status)
{
	this.status=status;
}
public String getstatus()
{
return status;
}
public void setAvailibility(String Availibility)
{
	this.Availibility=Availibility;
}
public String getAvailibility()
{
return Availibility;
}
public String toString(){
	return PatientId+" "+DoctorId+" "+Problem+" "+sthh+" "+stmm+" "+enhh+" "+enmm+" "+date+" "+Availibility+" "+status;
}
}