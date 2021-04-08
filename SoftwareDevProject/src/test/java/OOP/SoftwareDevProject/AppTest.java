package OOP.SoftwareDevProject;

import UI.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import domeinKlassen.Docent;
import domeinKlassen.Klas;
import domeinKlassen.Rooster;
import domeinKlassen.SLB;
import domeinKlassen.Student;


public class AppTest {
	Student s1 = new Student("Gerard.Hartong@student.hu.nl", "sinterklaas364", "Gerard", "Harting", 1023045);
	Student s2 = new Student("Jelle.vanBroek@student.hu.nl", "kerstman", "Jelle", "van Broek", 1034839);
	Student s3 = new Student("Christa.Lange@student.hu.nl", "konijnenvoer", "Christa", "Lange", 1472890);
	Student s4 = new Student("Dante.Jawel@student.hu.nl", "watiseenwachtwoord", "Dante", "Jawel", 1432907);
	Student s5 = new Student("Sophie.Dielemans@student.hu.nl", "ditiseenwachtwoord", "Sophie", "Dielemans", 1234678);
	Student s6 = new Student("Ingmar.Boomstam@student.hu.nl", "ingmarisbest", "Ingmar", "Boomstam", 1094789);
	
	Docent d1 = new Docent("Karin.Haring@docent.hu.nl", "supersterkwachtwoord20", "Karin", "Haring", 4320832);
	Docent d2 = new Docent("Brian.Honing@docent.hu.nl", "eenmindersterkwachtwoord", "Brian", "Honing", 4321934);
	SLB slb1 = new SLB("Berend.Botje@docent.hu.nl", "woawoiewo", "Berend", "Botje");
	Docent docent = new Docent("Karin.Haring@docent.hu.nl", "supersterkwachtwoord20", "Karin", "Haring", 4320832);
	
	Klas SG14 = new Klas(14);
	Klas SG15 = new Klas(15);
	
	Rooster kr1 = new Rooster(SG14);
	Rooster kr2 = new Rooster(SG15);
	Rooster dr1 = new Rooster(d1);
	Rooster dr2 = new Rooster(d2);
	
	LoginController l1 = new LoginController();
	
    /**
     * Rigorous Test :-)
     */
    @Test
    public void TestToString(){
    
   Assertions.assertEquals("Gerard Harting",s1.toString());
   Assertions.assertEquals("Jelle vanBroek",s2.toString());
   Assertions.assertEquals("Christa Lange",s3.toString());
   Assertions.assertEquals("Dante Jawel",s4.toString());
   Assertions.assertEquals("Sophie Dielemans",s5.toString());
   Assertions.assertEquals("Ingmar Boomstam",s6.toString());
   
   Assertions.assertEquals("Karin Haring",d1.toString());
   Assertions.assertEquals("Brian Honing",d2.toString());
   Assertions.assertEquals("Berend Botje",slb1.toString());
   
   Assertions.assertEquals("Gerard.Hartong@student.hu.nl",s1.toString());
    	
    	
    	
    }
    @Test
    public void DocentAndSLB_klas() {
    	kr1.setKlas(SG14);
        kr2.setKlas(SG15);
        d2.setRooster(dr2);
        Assertions.assertEquals(4320832,docent.getDocentNummer());
        Assertions.assertEquals(4321934,d2.getDocentNummer());
   //Assertions.assertEquals(docent,docent.equals(docent));
   //Assertions.assertEquals(true,d2.equals(d2));
        Assertions.assertEquals(SG14, kr1.getKlas());
        Assertions.assertEquals(SG15,kr2.getKlas());
    
    
    }
    @Test
public void Logincheck() {
    	
    	//zet expectation to false om te zien of je niet zomaar kunt inloggen
    	Assertions.assertEquals(false,l1.checkDocent());
    	Assertions.assertEquals(false,l1.checkStudent());
	
	
}



}
