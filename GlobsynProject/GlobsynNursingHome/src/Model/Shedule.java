package Model;

public class Shedule 
{
private String Id;
private String Specialization;
private String name;
private String sthr;
private String enhr,stmn,enmn;
private String date;
public String getId(){
	return Id;
}
public void setId(String Id){
	this.Id=Id;
}
public String getSpecialization(){
	return Specialization;
}
public void setSpecialization(String Specialization){
	this.Specialization=Specialization;
}
public String getname(){
	return name;
}
public void setname(String name){
	this.name=name;
}
public String getsthr(){
	return sthr;
}
public void setsthr(String sthr){
	this.sthr=sthr;
}
public String getenhr(){
	return enhr;
}
public void setenhr(String enhr){
	this.enhr=enhr;
}
public String getstmn(){
	return stmn;
}
public void setstmn(String stmn){
	this.stmn=stmn;
}
public String getenmn(){
	return enmn;
}
public void setenmn(String enmn){
	this.enmn=enmn;
}
public String getdate(){
	return date;
}
public void setdate(String date){
	this.date=date;
}
public String toString()
{
return 	Id+" "+name+" "+Specialization+" "+sthr+" "+stmn+" "+enhr+" "+enmn+" "+date;
}
}
