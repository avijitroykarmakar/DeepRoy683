package View;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class vPatientAppoinmentBooking extends JFrame 
{
        JLabel jlname,jlreg,jlcontact,jlemail,jlspec,jlproblem;
		JTextField jtname,jtreg,jtcontact,jtemail,jtproblem;
		JComboBox bx;
		String[] specialization={"--select--","Orthopadedic","GastroMedicine","Ent","Neurology","Cardiology","PaediatricMedicine","Dental"};
		JButton jb1;
		public  vPatientAppoinmentBooking()
		{
			 setBounds(0, 0,1000, 700);
			 setVisible(true);
			 setTitle("ADD DOCTOR INFORMATION");
			 setDefaultCloseOperation(this.EXIT_ON_CLOSE);
			 setLayout(null);
            jlname=new JLabel("PATIENT NAME: ");
			 jlname.setBounds(150, 250, 120, 50);
			 add(jlname);
			 jtname=new JTextField();
			 jtname.setBounds(300,265, 150,20);
			 add(jtname);
			 jlreg=new JLabel("PATIENT ID:");
			 jlreg.setBounds(150, 300, 150, 50);
			 add(jlreg);
			 jtreg=new JTextField();
			 jtreg.setBounds(300,315, 150,20);
			 add(jtreg);
			 jlcontact=new JLabel("PATIENT CONTACT NO : ");
			 jlcontact.setBounds(150, 350, 150, 50);
			 add(jlcontact);
			 jtcontact=new JTextField();
			 jtcontact.setBounds(300,367, 150,20);
			 add(jtcontact);
			 jlemail=new JLabel("EMAIL ID: ");
			 jlemail.setBounds(150, 400, 120, 50);
			 add(jlemail);
			 jtemail=new JTextField();
			 jtemail.setBounds(300,417, 150,20);
			 add(jtemail);
			 jlproblem=new JLabel("Problem: ");
			 jlproblem.setBounds(150, 460, 120, 50);
			 add(jlproblem);
			 bx=new JComboBox(specialization);
			 bx.setBounds(300,460,150,40);
			 add(bx);
			 
			 jb1=new JButton("SUBMIT");
			 jb1.setBounds(300, 550, 100,30);
			 add(jb1);
	    }

}
