package OOP.SoftwareDevProject;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import controllers.Utils;
import domeinKlassen.Docent;
import domeinKlassen.Gebruiker;
import domeinKlassen.Klas;
import domeinKlassen.Les;
import domeinKlassen.LesAbsentie;
import domeinKlassen.Rooster;
import domeinKlassen.SLB;
import domeinKlassen.Student;
import domeinKlassen.Vak;

public class ApplicationTest {
	@Nested
	class testDocent {
		@Nested
		class testGet {
			@ParameterizedTest
			@ValueSource(ints = {1, 2, 3, 4})
			public void testGetDocentNummerTrue(int docentNummer) {
				Docent docent = new Docent("test", "test", "test", "test", docentNummer);
				Assertions.assertThat(docent.getDocentNummer()).isEqualTo(docentNummer);
			}
			
			@ParameterizedTest
			@ValueSource(ints = {1, 2, 3, 4})
			public void testGetDocentNummerFalse(int docentNummer) {
				Docent docent = new Docent("test", "test", "test", "test", docentNummer);
				Assertions.assertThat(docent.getDocentNummer()).isNotEqualTo(docentNummer + 1);
			}
			
			@ParameterizedTest
			@ValueSource(ints = {1, 2, 3, 4})
			public void testGetKlassenLijstTrue(int nummer) {
				Docent docent = new Docent("test", "test", "test", "test", nummer);
				List<Klas> klassen = new ArrayList<>();
				for(int i=0;i<=10;i++) {
					Klas klas = new Klas(i);
					docent.addKlas(klas);
					klassen.add(klas);
				}
				Assertions.assertThat(docent.getKlassenLijst()).isEqualTo(klassen);
			}
			
			@ParameterizedTest
			@ValueSource(ints = {1, 2, 3, 4})
			public void testGetKlassenLijstFalse(int nummer) {
				Docent docent = new Docent("test", "test", "test", "test", nummer);
				List<Klas> klassen = new ArrayList<>();
				for(int i=0;i<=10;i++) {
					Klas klas = new Klas(i);
					klassen.add(klas);
				}
				Assertions.assertThat(docent.getKlassenLijst()).isNotEqualTo(klassen);
			}
			
			@ParameterizedTest
			@ValueSource(ints = {1, 2, 3, 4})
			public void testGetVakkenLijstTrue(int nummer) {
				Docent docent = new Docent("test", "test", "test", "test", nummer);
				List<Vak> vakken = new ArrayList<>();
				for(int i=0;i<=10;i++) {
					Vak vak = new Vak("" + i);
					docent.addVak(vak);
					vakken.add(vak);
				}
				Assertions.assertThat(docent.getVakkenLijst()).isEqualTo(vakken);
			}
			
			@ParameterizedTest
			@ValueSource(ints = {1, 2, 3, 4})
			public void testGetVakkenLijstFalse(int nummer) {
				Docent docent = new Docent("test", "test", "test", "test", nummer);
				List<Vak> vakken = new ArrayList<>();
				for(int i=0;i<=10;i++) {
					Vak vak = new Vak("" + i);
					vakken.add(vak);
				}
				Assertions.assertThat(docent.getVakkenLijst()).isNotEqualTo(vakken);
			}
			
			@ParameterizedTest
			@ValueSource(ints = {1, 2, 3, 4})
			public void testGetRoosterTrue(int nummer) {
				Docent docent = new Docent("test", "test", "test", "test", nummer);
				Rooster rooster = new Rooster(new Klas(nummer));
				docent.setRooster(rooster);
				Assertions.assertThat(docent.getRooster()).isEqualTo(rooster);
			}
			
			@ParameterizedTest
			@ValueSource(ints = {1, 2, 3, 4})
			public void testGetRoosterFalse(int nummer) {
				Docent docent = new Docent("test", "test", "test", "test", nummer);
				Rooster rooster = new Rooster(new Klas(nummer));
				Assertions.assertThat(docent.getRooster()).isNotEqualTo(rooster);
			}
		}
		
		@Nested
		class testSet {
			@ParameterizedTest
			@ValueSource(ints = {1, 2, 3, 4})
			public void testSetRoosterTrue(int nummer) {
				Docent docent = new Docent("test", "test", "test", "test", nummer);
				Rooster rooster = new Rooster(new Klas(nummer));
				docent.setRooster(rooster);
				Assertions.assertThat(docent.getRooster()).isEqualTo(rooster);
			}
			
			@ParameterizedTest
			@ValueSource(ints = {1, 2, 3, 4})
			public void testSetRoosterFalse(int nummer) {
				Docent docent = new Docent("test", "test", "test", "test", nummer);
				Rooster rooster = new Rooster(new Klas(nummer));
				Assertions.assertThat(docent.getRooster()).isNotEqualTo(rooster);
			}
		}
		
		@Nested
		class testAdd {
			@ParameterizedTest
			@ValueSource(ints = {1, 2, 3, 4})
			public void testAddKlasTrue(int nummer) {
				Docent docent = new Docent("test", "test", "test", "test", nummer);
				Klas klas = new Klas(nummer);
				docent.addKlas(klas);
				Assertions.assertThat(docent.getKlassenLijst()).contains(klas);
			}
			
			@ParameterizedTest
			@ValueSource(ints = {1, 2, 3, 4})
			public void testAddKlasFalse(int nummer) {
				Docent docent = new Docent("test", "test", "test", "test", nummer);
				Klas klas = new Klas(nummer);
				Assertions.assertThat(docent.getKlassenLijst()).doesNotContain(klas);
			}
			
			@ParameterizedTest
			@ValueSource(ints = {1, 2, 3, 4})
			public void testAddVakTrue(int nummer) {
				Docent docent = new Docent("test", "test", "test", "test", nummer);
				Vak vak = new Vak("" + nummer);
				docent.addVak(vak);
				Assertions.assertThat(docent.getVakkenLijst()).contains(vak);
			}
			
			@ParameterizedTest
			@ValueSource(ints = {1, 2, 3, 4})
			public void testAddVakFalse(int nummer) {
				Docent docent = new Docent("test", "test", "test", "test", nummer);
				Vak vak = new Vak("" + nummer);
				Assertions.assertThat(docent.getVakkenLijst()).doesNotContain(vak);
			}
		}
		
		@Nested
		class testRemove {
			@ParameterizedTest
			@ValueSource(ints = {1, 2, 3, 4})
			public void testRemoveKlasTrue(int nummer) {
				Docent docent = new Docent("test", "test", "test", "test", nummer);
				Klas klas = new Klas(nummer);
				docent.addKlas(klas);
				Assertions.assertThat(docent.getKlassenLijst()).contains(klas);
				docent.removeKlas(klas);
				Assertions.assertThat(docent.getKlassenLijst()).doesNotContain(klas);
			}
			
			@ParameterizedTest
			@ValueSource(ints = {1, 2, 3, 4})
			public void testRemoveKlasFalse(int nummer) {
				Docent docent = new Docent("test", "test", "test", "test", nummer);
				Klas klas = new Klas(nummer);
				docent.addKlas(klas);
				Assertions.assertThat(docent.getKlassenLijst()).contains(klas);
			}
			
			@ParameterizedTest
			@ValueSource(ints = {1, 2, 3, 4})
			public void testRemoveVakTrue(int nummer) {
				Docent docent = new Docent("test", "test", "test", "test", nummer);
				Vak vak = new Vak("" + nummer);
				docent.addVak(vak);
				Assertions.assertThat(docent.getVakkenLijst()).contains(vak);
			}
		}
	}
	
	@Nested
	class testGebruiker {
		@Nested
		class testGet {
			@ParameterizedTest
			@ValueSource(strings = {"test.test@test.nl", "test@test.com", "test@test.hu.nl", "test.test@test.hu.com"})
			public void testGetEmailAdresTrue(String email) {
				Gebruiker gebruiker = new Gebruiker(email, "test", "test", "test");
				Assertions.assertThat(gebruiker.getEmailAdres()).isEqualTo(email);
			}
			
			@ParameterizedTest
			@ValueSource(strings = {"test.test@test.nl", "test@test.com", "test@test.hu.nl", "test.test@test.hu.com"})
			public void testGetEmailAdresFalse(String email) {
				Gebruiker gebruiker = new Gebruiker(email, "test", "test", "test");
				Assertions.assertThat(gebruiker.getEmailAdres()).isNotEqualTo("test");
			}
			
			@ParameterizedTest
			@ValueSource(strings = {"test", "1234", "testtest", "1234567890"})
			public void testGetWachtwoordTrue(String password) {
				Gebruiker gebruiker = new Gebruiker("test", password, "test", "test");
				Assertions.assertThat(gebruiker.getWachtwoord()).isEqualTo(Utils.hashPassword(password));
			}
			
			@ParameterizedTest
			@ValueSource(strings = {"test", "1234", "testtest", "1234567890"})
			public void testGetWachtwoordFalse(String password) {
				Gebruiker gebruiker = new Gebruiker("test", password, "test", "test");
				Assertions.assertThat(gebruiker.getWachtwoord()).isNotEqualTo(Utils.hashPassword("nope"));
			}
			
			@ParameterizedTest
			@ValueSource(strings = {"test", "voornaam", "testtest", "firstname"})
			public void testGetVoorNaamTrue(String firstname) {
				Gebruiker gebruiker = new Gebruiker("test", "test", firstname, "test");
				Assertions.assertThat(gebruiker.getVoorNaam()).isEqualTo(firstname);
			}
			
			@ParameterizedTest
			@ValueSource(strings = {"test", "voornaam", "testtest", "firstname"})
			public void testGetVoorNaamFalse(String firstname) {
				Gebruiker gebruiker = new Gebruiker("test", "test", firstname, "test");
				Assertions.assertThat(gebruiker.getVoorNaam()).isNotEqualTo("nope");
			}
			
			@ParameterizedTest
			@ValueSource(strings = {"test", "achternaam", "testtest", "lastname"})
			public void testGetAchterNaamTrue(String lastname) {
				Gebruiker gebruiker = new Gebruiker("test", "test", "test", lastname);
				Assertions.assertThat(gebruiker.getAchterNaam()).isEqualTo(lastname);
			}
			
			@ParameterizedTest
			@ValueSource(strings = {"test", "achternaam", "testtest", "lastname"})
			public void testGetAchterNaamFalse(String lastname) {
				Gebruiker gebruiker = new Gebruiker("test", "test", "test", lastname);
				Assertions.assertThat(gebruiker.getAchterNaam()).isNotEqualTo("nope");
			}
		}
	}
	
	@Nested
	class testKlas {
		@Nested
		class testGet {
			@ParameterizedTest
			@ValueSource(ints = {1, 2, 3, 4})
			public void testGetKlasNummerTrue(int nummer) {
				Klas klas = new Klas(nummer);
				Assertions.assertThat(klas.getKlasNummer()).isEqualTo(nummer);
			}
			
			@ParameterizedTest
			@ValueSource(ints = {1, 2, 3, 4})
			public void testGetKlasNummerFalse(int nummer) {
				Klas klas = new Klas(nummer);
				Assertions.assertThat(klas.getKlasNummer()).isNotEqualTo(nummer + 1);
			}
			
			@ParameterizedTest
			@CsvSource({
				"test,test,test,test,1",
				"test1,test1,test1,test1,2",
				"test2,test2,test2,test2,3",
				"test3,test3,test3,test3,4",
			})
			public void testGetStudentenLijstTrue(String email, String password, String voornaam, String achternaam, int nummer) {
				Klas klas = new Klas(nummer);
				List<Student> studenten = new ArrayList<>();
				for(int i=0;i<=10;i++) {
					Student student = new Student(email, password, voornaam, achternaam, nummer + i);
					klas.addStudent(student);
					studenten.add(student);
				}
				Assertions.assertThat(klas.getStudentenLijst()).isEqualTo(studenten);
			}
			
			@ParameterizedTest
			@CsvSource({
				"test,test,test,test,1",
				"test1,test1,test1,test1,2",
				"test2,test2,test2,test2,3",
				"test3,test3,test3,test3,4",
			})
			public void testGetStudentenLijstFalse(String email, String password, String voornaam, String achternaam, int nummer) {
				Klas klas = new Klas(nummer);
				List<Student> studenten = new ArrayList<>();
				for(int i=0;i<=10;i++) {
					Student student = new Student(email, password, voornaam, achternaam, nummer + i);
					studenten.add(student);
				}
				Assertions.assertThat(klas.getStudentenLijst()).isNotEqualTo(studenten);
			}
			
			@ParameterizedTest
			@CsvSource({
				"test,test,test,test,1",
				"test1,test1,test1,test1,2",
				"test2,test2,test2,test2,3",
				"test3,test3,test3,test3,4",
			})
			public void testGetDocentenLijstTrue(String email, String password, String voornaam, String achternaam, int nummer) {
				Klas klas = new Klas(nummer);
				List<Docent> docenten = new ArrayList<>();
				for(int i=0;i<=10;i++) {
					Docent docent = new Docent(email, password, voornaam, achternaam, nummer + i);
					klas.addDocent(docent);
					docenten.add(docent);
				}
				Assertions.assertThat(klas.getDocentenLijst()).isEqualTo(docenten);
			}
			
			@ParameterizedTest
			@CsvSource({
				"test,test,test,test,1",
				"test1,test1,test1,test1,2",
				"test2,test2,test2,test2,3",
				"test3,test3,test3,test3,4",
			})
			public void testGetDocentenLijstFalse(String email, String password, String voornaam, String achternaam, int nummer) {
				Klas klas = new Klas(nummer);
				List<Docent> docenten = new ArrayList<>();
				for(int i=0;i<=10;i++) {
					Docent docent = new Docent(email, password, voornaam, achternaam, nummer + i);
					docenten.add(docent);
				}
				Assertions.assertThat(klas.getDocentenLijst()).isNotEqualTo(docenten);
			}
			
			@ParameterizedTest
			@ValueSource(ints = {1, 2, 3, 4})
			public void testGetVakkenLijstTrue(int nummer) {
				Klas klas = new Klas(nummer);
				List<Vak> vakken = new ArrayList<>();
				for(int i=0;i<=10;i++) {
					Vak vak = new Vak("" + i);
					klas.addVak(vak);
					vakken.add(vak);
				}
				Assertions.assertThat(klas.getVakkenLijst()).isEqualTo(vakken);
			}
			
			@ParameterizedTest
			@ValueSource(ints = {1, 2, 3, 4})
			public void testGetVakkenLijstFalse(int nummer) {
				Klas klas = new Klas(nummer);
				List<Vak> vakken = new ArrayList<>();
				for(int i=0;i<=10;i++) {
					Vak vak = new Vak("" + i);
					vakken.add(vak);
				}
				Assertions.assertThat(klas.getVakkenLijst()).isNotEqualTo(vakken);
			}
			
			@ParameterizedTest
			@ValueSource(ints = {1, 2, 3, 4})
			public void testGetRoosterTrue(int nummer) {
				Klas klas = new Klas(nummer);
				Rooster rooster = new Rooster(klas);
				klas.setRooster(rooster);
				Assertions.assertThat(klas.getRooster()).isEqualTo(rooster);
			}
			
			@ParameterizedTest
			@ValueSource(ints = {1, 2, 3, 4})
			public void testGetRoosterFalse(int nummer) {
				Klas klas = new Klas(nummer);
				Rooster rooster = new Rooster(klas);
				Assertions.assertThat(klas.getRooster()).isNotEqualTo(rooster);
			}
		}
		
		@Nested
		class testSet {
			@ParameterizedTest
			@ValueSource(ints = {1, 2, 3, 4})
			public void testSetRoosterTrue(int nummer) {
				Klas klas = new Klas(nummer);
				Rooster rooster = new Rooster(klas);
				klas.setRooster(rooster);
				Assertions.assertThat(klas.getRooster()).isEqualTo(rooster);
			}
			
			@ParameterizedTest
			@ValueSource(ints = {1, 2, 3, 4})
			public void testSetRoosterFalse(int nummer) {
				Klas klas = new Klas(nummer);
				Rooster rooster = new Rooster(klas);
				Assertions.assertThat(klas.getRooster()).isNotEqualTo(rooster);
			}
		}
		
		@Nested
		class testAdd {
			@ParameterizedTest
			@CsvSource({
				"test,test,test,test,1",
				"test1,test1,test1,test1,2",
				"test2,test2,test2,test2,3",
				"test3,test3,test3,test3,4",
			})
			public void testAddStudentTrue(String email, String password, String voornaam, String achternaam, int nummer) {
				Klas klas = new Klas(nummer);
				Student student = new Student(email, password, voornaam, achternaam, nummer);
				klas.addStudent(student);
				Assertions.assertThat(klas.getStudentenLijst()).contains(student);
			}
			
			@ParameterizedTest
			@CsvSource({
				"test,test,test,test,1",
				"test1,test1,test1,test1,2",
				"test2,test2,test2,test2,3",
				"test3,test3,test3,test3,4",
			})
			public void testAddStudentFalse(String email, String password, String voornaam, String achternaam, int nummer) {
				Klas klas = new Klas(nummer);
				Student student = new Student(email, password, voornaam, achternaam, nummer);
				Assertions.assertThat(klas.getStudentenLijst()).doesNotContain(student);
			}
			
			@ParameterizedTest
			@CsvSource({
				"test,test,test,test,1",
				"test1,test1,test1,test1,2",
				"test2,test2,test2,test2,3",
				"test3,test3,test3,test3,4",
			})
			public void testAddDocentTrue(String email, String password, String voornaam, String achternaam, int nummer) {
				Klas klas = new Klas(nummer);
				Docent docent = new Docent(email, password, voornaam, achternaam, nummer);
				klas.addDocent(docent);
				Assertions.assertThat(klas.getDocentenLijst()).contains(docent);
			}
			
			@ParameterizedTest
			@CsvSource({
				"test,test,test,test,1",
				"test1,test1,test1,test1,2",
				"test2,test2,test2,test2,3",
				"test3,test3,test3,test3,4",
			})
			public void testAddDocentFalse(String email, String password, String voornaam, String achternaam, int nummer) {
				Klas klas = new Klas(nummer);
				Docent docent = new Docent(email, password, voornaam, achternaam, nummer);
				Assertions.assertThat(klas.getDocentenLijst()).doesNotContain(docent);
			}
			
			@ParameterizedTest
			@ValueSource(ints = {1, 2, 3, 4})
			public void testAddVakTrue(int nummer) {
				Klas klas = new Klas(nummer);
				Vak vak = new Vak("" + nummer);
				klas.addVak(vak);
				Assertions.assertThat(klas.getVakkenLijst()).contains(vak);
			}
			
			@ParameterizedTest
			@ValueSource(ints = {1, 2, 3, 4})
			public void testAddVakFalse(int nummer) {
				Klas klas = new Klas(nummer);
				Vak vak = new Vak("" + nummer);
				Assertions.assertThat(klas.getVakkenLijst()).doesNotContain(vak);
			}
		}
		
		@Nested
		class testRemove {
			@ParameterizedTest
			@CsvSource({
				"test,test,test,test,1",
				"test1,test1,test1,test1,2",
				"test2,test2,test2,test2,3",
				"test3,test3,test3,test3,4",
			})
			public void testRemoveStudentTrue(String email, String password, String voornaam, String achternaam, int nummer) {
				Klas klas = new Klas(nummer);
				Student student = new Student(email, password, voornaam, achternaam, nummer);
				klas.addStudent(student);
				Assertions.assertThat(klas.getStudentenLijst()).contains(student);
				klas.removeStudent(student);
				Assertions.assertThat(klas.getStudentenLijst()).doesNotContain(student);
			}
			
			@ParameterizedTest
			@CsvSource({
				"test,test,test,test,1",
				"test1,test1,test1,test1,2",
				"test2,test2,test2,test2,3",
				"test3,test3,test3,test3,4",
			})
			public void testRemoveStudentFalse(String email, String password, String voornaam, String achternaam, int nummer) {
				Klas klas = new Klas(nummer);
				Student student = new Student(email, password, voornaam, achternaam, nummer);
				klas.addStudent(student);
				Assertions.assertThat(klas.getStudentenLijst()).contains(student);
			}
			
			@ParameterizedTest
			@CsvSource({
				"test,test,test,test,1",
				"test1,test1,test1,test1,2",
				"test2,test2,test2,test2,3",
				"test3,test3,test3,test3,4",
			})
			public void testRemoveDocentTrue(String email, String password, String voornaam, String achternaam, int nummer) {
				Klas klas = new Klas(nummer);
				Docent docent = new Docent(email, password, voornaam, achternaam, nummer);
				klas.addDocent(docent);
				Assertions.assertThat(klas.getDocentenLijst()).contains(docent);
				klas.removeDocent(docent);
				Assertions.assertThat(klas.getDocentenLijst()).doesNotContain(docent);
			}
			
			@ParameterizedTest
			@CsvSource({
				"test,test,test,test,1",
				"test1,test1,test1,test1,2",
				"test2,test2,test2,test2,3",
				"test3,test3,test3,test3,4",
			})
			public void testRemoveDocentFalse(String email, String password, String voornaam, String achternaam, int nummer) {
				Klas klas = new Klas(nummer);
				Docent docent = new Docent(email, password, voornaam, achternaam, nummer);
				klas.addDocent(docent);
				Assertions.assertThat(klas.getDocentenLijst()).contains(docent);
			}
			
			@ParameterizedTest
			@ValueSource(ints = {1, 2, 3, 4})
			public void testRemoveVakTrue(int nummer) {
				Klas klas = new Klas(nummer);
				Vak vak = new Vak("" + nummer);
				klas.addVak(vak);
				Assertions.assertThat(klas.getVakkenLijst()).contains(vak);
				klas.removeVak(vak);
				Assertions.assertThat(klas.getVakkenLijst()).doesNotContain(vak);
			}
			
			@ParameterizedTest
			@ValueSource(ints = {1, 2, 3, 4})
			public void testRemoveVakFalse(int nummer) {
				Klas klas = new Klas(nummer);
				Vak vak = new Vak("" + nummer);
				klas.addVak(vak);
				Assertions.assertThat(klas.getVakkenLijst()).contains(vak);
			}
		}
	}
	
	@Nested
	class testLes {
		@Nested
		class testGet {
			@ParameterizedTest
			@CsvSource({
				"test,10:10,11:10",
				"test2,10:11,11:11",
				"test3,10:12,11:12",
				"test4,10:13,11:13"
			})
			public void testGetNaamTrue(String naam, String beginTijd, String eindTijd) {
				Les les = new Les(naam, beginTijd, eindTijd, LocalDate.now(), new Vak(naam));
				Assertions.assertThat(les.getNaam()).isEqualTo(naam);
			}
			
			@ParameterizedTest
			@CsvSource({
				"test,10:10,11:10",
				"test2,10:11,11:11",
				"test3,10:12,11:12",
				"test4,10:13,11:13"
			})
			public void testGetNaamFalse(String naam, String beginTijd, String eindTijd) {
				Les les = new Les(naam, beginTijd, eindTijd, LocalDate.now(), new Vak(naam));
				Assertions.assertThat(les.getNaam()).isNotEqualTo("nope");
			}
			
			@ParameterizedTest
			@CsvSource({
				"test,10:10,11:10",
				"test2,10:11,11:11",
				"test3,10:12,11:12",
				"test4,10:13,11:13"
			})
			public void testGetBeginTijdTrue(String naam, String beginTijd, String eindTijd) {
				Les les = new Les(naam, beginTijd, eindTijd, LocalDate.now(), new Vak(naam));
				Assertions.assertThat(les.getBeginTijd()).isEqualTo(beginTijd);
			}
			
			@ParameterizedTest
			@CsvSource({
				"test,10:10,11:10",
				"test2,10:11,11:11",
				"test3,10:12,11:12",
				"test4,10:13,11:13"
			})
			public void testGetBeginTijdFalse(String naam, String beginTijd, String eindTijd) {
				Les les = new Les(naam, beginTijd, eindTijd, LocalDate.now(), new Vak(naam));
				Assertions.assertThat(les.getBeginTijd()).isNotEqualTo("nope");
			}
			
			@ParameterizedTest
			@CsvSource({
				"test,10:10,11:10",
				"test2,10:11,11:11",
				"test3,10:12,11:12",
				"test4,10:13,11:13"
			})
			public void testGetEindTijdTrue(String naam, String beginTijd, String eindTijd) {
				Les les = new Les(naam, beginTijd, eindTijd, LocalDate.now(), new Vak(naam));
				Assertions.assertThat(les.getEindTijd()).isEqualTo(eindTijd);
			}
			
			@ParameterizedTest
			@CsvSource({
				"test,10:10,11:10",
				"test2,10:11,11:11",
				"test3,10:12,11:12",
				"test4,10:13,11:13"
			})
			public void testGetEindTijdFalse(String naam, String beginTijd, String eindTijd) {
				Les les = new Les(naam, beginTijd, eindTijd, LocalDate.now(), new Vak(naam));
				Assertions.assertThat(les.getEindTijd()).isNotEqualTo("nope");
			}
			
			@ParameterizedTest
			@CsvSource({
				"test,10:10,11:10,1",
				"test2,10:11,11:11,2",
				"test3,10:12,11:12,3",
				"test4,10:13,11:13,4"
			})
			public void testGetDagTrue(String naam, String beginTijd, String eindTijd, int nummer) {
				LocalDate date = LocalDate.now().plusDays(nummer);
				Les les = new Les(naam, beginTijd, eindTijd, date, new Vak(naam));
				Assertions.assertThat(les.getDag()).isEqualTo(date);
			}
			
			@ParameterizedTest
			@CsvSource({
				"test,10:10,11:10,1",
				"test2,10:11,11:11,2",
				"test3,10:12,11:12,3",
				"test4,10:13,11:13,4"
			})
			public void testGetDagFalse(String naam, String beginTijd, String eindTijd, int nummer) {
				LocalDate date = LocalDate.now().plusDays(nummer);
				Les les = new Les(naam, beginTijd, eindTijd, date, new Vak(naam));
				Assertions.assertThat(les.getDag()).isNotEqualTo(date.minusDays(nummer));
			}
			
			@ParameterizedTest
			@CsvSource({
				"test,10:10,11:10",
				"test2,10:11,11:11",
				"test3,10:12,11:12",
				"test4,10:13,11:13"
			})
			public void testGetVakTrue(String naam, String beginTijd, String eindTijd) {
				Vak vak = new Vak(naam);
				Les les = new Les(naam, beginTijd, eindTijd, LocalDate.now(), vak);
				Assertions.assertThat(les.getVak()).isEqualTo(vak);
			}
			
			@ParameterizedTest
			@CsvSource({
				"test,10:10,11:10",
				"test2,10:11,11:11",
				"test3,10:12,11:12",
				"test4,10:13,11:13"
			})
			public void testGetVakFalse(String naam, String beginTijd, String eindTijd) {
				Vak vak = new Vak(naam);
				Les les = new Les(naam, beginTijd, eindTijd, LocalDate.now(), vak);
				Assertions.assertThat(les.getVak()).isNotEqualTo(new Vak("nope"));
			}
			
			@ParameterizedTest
			@CsvSource({
				"test,10:10,11:10,1",
				"test2,10:11,11:11,2",
				"test3,10:12,11:12,3",
				"test4,10:13,11:13,4"
			})
			public void testGetRoosterTrue(String naam, String beginTijd, String eindTijd, int nummer) {
				Les les = new Les(naam, beginTijd, eindTijd, LocalDate.now(), new Vak(naam));
				Rooster rooster = new Rooster(new Klas(nummer));
				les.setRooster(rooster);
				Assertions.assertThat(les.getRooster()).isEqualTo(rooster);
			}
			
			@ParameterizedTest
			@CsvSource({
				"test,10:10,11:10,1",
				"test2,10:11,11:11,2",
				"test3,10:12,11:12,3",
				"test4,10:13,11:13,4"
			})
			public void testGetRoosterFalse(String naam, String beginTijd, String eindTijd, int nummer) {
				Les les = new Les(naam, beginTijd, eindTijd, LocalDate.now(), new Vak(naam));
				Rooster rooster = new Rooster(new Klas(nummer));
				Assertions.assertThat(les.getRooster()).isNotEqualTo(rooster);
			}
		}
		
		@Nested
		class testSet {
			@ParameterizedTest
			@CsvSource({
				"test,10:10,11:10,1",
				"test2,10:11,11:11,2",
				"test3,10:12,11:12,3",
				"test4,10:13,11:13,4"
			})
			public void testSetRoosterTrue(String naam, String beginTijd, String eindTijd, int nummer) {
				Les les = new Les(naam, beginTijd, eindTijd, LocalDate.now(), new Vak(naam));
				Rooster rooster = new Rooster(new Klas(nummer));
				les.setRooster(rooster);
				Assertions.assertThat(les.getRooster()).isEqualTo(rooster);
			}
			
			@ParameterizedTest
			@CsvSource({
				"test,10:10,11:10,1",
				"test2,10:11,11:11,2",
				"test3,10:12,11:12,3",
				"test4,10:13,11:13,4"
			})
			public void testSetRoosterFalse(String naam, String beginTijd, String eindTijd, int nummer) {
				Les les = new Les(naam, beginTijd, eindTijd, LocalDate.now(), new Vak(naam));
				Rooster rooster = new Rooster(new Klas(nummer));
				Assertions.assertThat(les.getRooster()).isNotEqualTo(rooster);
			}
		}
	}
	
	@Nested
	class testLesAbsentie {
		@Nested
		class testGet {
			@ParameterizedTest
			@CsvSource({
				"test,test,test,test,1",
				"test1,test1,test1,test1,2",
				"test2,test2,test2,test2,3",
				"test3,test3,test3,test3,4",
			})
			public void testGetStudentTrue(String email, String password, String voornaam, String achternaam, int leerlingnummer) {
				LesAbsentie absentie = new LesAbsentie();
				Student student = new Student(email, password, voornaam, achternaam, leerlingnummer);
				absentie.setStudent(student);
				Assertions.assertThat(absentie.getStudent()).isEqualTo(student);
			}
			
			@ParameterizedTest
			@CsvSource({
				"test,test,test,test,1",
				"test1,test1,test1,test1,2",
				"test2,test2,test2,test2,3",
				"test3,test3,test3,test3,4",
			})
			public void testGetStudentFalse(String email, String password, String voornaam, String achternaam, int leerlingnummer) {
				LesAbsentie absentie = new LesAbsentie();
				Student student = new Student(email, password, voornaam, achternaam, leerlingnummer);
				Assertions.assertThat(absentie.getStudent()).isNotEqualTo(student);
			}
			
			@ParameterizedTest
			@CsvSource({
				"test,10:10,11:10,a",
				"test1,10:11,11:11,b",
				"test2,10:12,11:12,c",
				"test3,10:13,11:13,d",
			})
			public void testGetLesTrue(String naam, String beginTijd, String eindTijd, String vak) {
				LesAbsentie absentie = new LesAbsentie();
				Les les = new Les(naam, beginTijd, eindTijd, LocalDate.now(), new Vak(vak));
				absentie.setLes(les);
				Assertions.assertThat(absentie.getLes()).isEqualTo(les);
			}
			
			@ParameterizedTest
			@CsvSource({
				"test,10:10,11:10,a",
				"test1,10:11,11:11,b",
				"test2,10:12,11:12,c",
				"test3,10:13,11:13,d",
			})
			public void testGetLesFalse(String naam, String beginTijd, String eindTijd, String vak) {
				LesAbsentie absentie = new LesAbsentie();
				Les les = new Les(naam, beginTijd, eindTijd, LocalDate.now(), new Vak(vak));
				Assertions.assertThat(absentie.getLes()).isNotEqualTo(les);
			}
		}
		
		@Nested
		class testSet {
			@ParameterizedTest
			@CsvSource({
				"test,test,test,test,1",
				"test1,test1,test1,test1,2",
				"test2,test2,test2,test2,3",
				"test3,test3,test3,test3,4",
			})
			public void testSetStudentTrue(String email, String password, String voornaam, String achternaam, int leerlingnummer) {
				LesAbsentie absentie = new LesAbsentie();
				Student student = new Student(email, password, voornaam, achternaam, leerlingnummer);
				absentie.setStudent(student);
				Assertions.assertThat(absentie.getStudent()).isEqualTo(student);
			}
			
			@ParameterizedTest
			@CsvSource({
				"test,test,test,test,1",
				"test1,test1,test1,test1,2",
				"test2,test2,test2,test2,3",
				"test3,test3,test3,test3,4",
			})
			public void testSetStudentFalse(String email, String password, String voornaam, String achternaam, int leerlingnummer) {
				LesAbsentie absentie = new LesAbsentie();
				Student student = new Student(email, password, voornaam, achternaam, leerlingnummer);
				Assertions.assertThat(absentie.getStudent()).isNotEqualTo(student);
			}
			
			@ParameterizedTest
			@CsvSource({
				"test,10:10,11:10,a",
				"test1,10:11,11:11,b",
				"test2,10:12,11:12,c",
				"test3,10:13,11:13,d",
			})
			public void testSetLesTrue(String naam, String beginTijd, String eindTijd, String vak) {
				LesAbsentie absentie = new LesAbsentie();
				Les les = new Les(naam, beginTijd, eindTijd, LocalDate.now(), new Vak(vak));
				absentie.setLes(les);
				Assertions.assertThat(absentie.getLes()).isEqualTo(les);
			}
			
			@ParameterizedTest
			@CsvSource({
				"test,10:10,11:10,a",
				"test1,10:11,11:11,b",
				"test2,10:12,11:12,c",
				"test3,10:13,11:13,d",
			})
			public void testSetLesFalse(String naam, String beginTijd, String eindTijd, String vak) {
				LesAbsentie absentie = new LesAbsentie();
				Les les = new Les(naam, beginTijd, eindTijd, LocalDate.now(), new Vak(vak));
				Assertions.assertThat(absentie.getLes()).isNotEqualTo(les);
			}
		}
	}
	
	@Nested
	class testRooster {
		@Nested
		class testGet {
			@ParameterizedTest
			@ValueSource(ints = {1, 2, 3, 4})
			public void testGetDocentTrue(int docentNummer) {
				Docent docent = new Docent("test", "test", "test", "test", docentNummer);
				Rooster rooster = new Rooster(docent);
				Assertions.assertThat(rooster.getDocent()).isEqualTo(docent);
			}
			
			@ParameterizedTest
			@ValueSource(ints = {1, 2, 3, 4})
			public void testGetDocentFalse(int docentNummer) {
				Docent docent = new Docent("test", "test", "test", "test", docentNummer);
				Rooster rooster = new Rooster(docent);
				Assertions.assertThat(rooster.getDocent()).isNotEqualTo("nope");
			}
			
			@ParameterizedTest
			@ValueSource(ints = {1, 2, 3, 4})
			public void testGetKlasTrue(int klasNummer) {
				Klas klas = new Klas(klasNummer);
				Rooster rooster = new Rooster(klas);
				Assertions.assertThat(rooster.getKlas()).isEqualTo(klas);
			}
			
			@ParameterizedTest
			@ValueSource(ints = {1, 2, 3, 4})
			public void testGetKlasFalse(int klasNummer) {
				Klas klas = new Klas(klasNummer);
				Rooster rooster = new Rooster(klas);
				Assertions.assertThat(rooster.getKlas()).isNotEqualTo("nope");
			}
			
			@ParameterizedTest
			@CsvSource({
				"test,10:10,11:10,a",
				"test1,10:11,11:11,b",
				"test2,10:12,11:12,c",
				"test3,10:13,11:13,d",
			})
			public void testGetLessenLijstTrue(String naam, String beginTijd, String eindTijd, String vak) {
				Rooster rooster = new Rooster(new Klas(1));
				ArrayList<Les> lessen = new ArrayList<>();
				for(int i=0;i<=10;i++) {
					lessen.add(new Les(naam, beginTijd, eindTijd, LocalDate.now(), new Vak(vak + i)));
				}
				rooster.setLessenLijst(lessen);
				Assertions.assertThat(rooster.getLessenLijst()).isEqualTo(lessen);
			}
			
			@ParameterizedTest
			@CsvSource({
				"test,10:10,11:10,a",
				"test1,10:11,11:11,b",
				"test2,10:12,11:12,c",
				"test3,10:13,11:13,d",
			})
			public void testGetLessenLijstFalse(String naam, String beginTijd, String eindTijd, String vak) {
				Rooster rooster = new Rooster(new Klas(1));
				ArrayList<Les> lessen = new ArrayList<>();
				for(int i=0;i<=10;i++) {
					lessen.add(new Les(naam, beginTijd, eindTijd, LocalDate.now(), new Vak(vak + i)));
				}
				rooster.setLessenLijst(lessen);
				Assertions.assertThat(rooster.getLessenLijst()).isNotEqualTo("nope");
			}
		}
		
		@Nested
		class testSet {
			@ParameterizedTest
			@ValueSource(ints = {1, 2, 3, 4})
			public void testSetDocentTrue(int docentNummer) {
				Docent docent = new Docent("test", "test", "test", "test", docentNummer);
				Rooster rooster = new Rooster(new Docent("test", "test", "test", "test", docentNummer + 1));
				rooster.setDocent(docent);
				Assertions.assertThat(rooster.getDocent()).isEqualTo(docent);
			}
			
			@ParameterizedTest
			@ValueSource(ints = {1, 2, 3, 4})
			public void testSetDocentFalse(int docentNummer) {
				Docent docent = new Docent("test", "test", "test", "test", docentNummer);
				Rooster rooster = new Rooster(new Docent("test", "test", "test", "test", docentNummer + 1));
				Assertions.assertThat(rooster.getDocent()).isNotEqualTo(docent);
			}
			
			@ParameterizedTest
			@ValueSource(ints = {1, 2, 3, 4})
			public void testSetKlasTrue(int klasNummer) {
				Klas klas = new Klas(klasNummer);
				Rooster rooster = new Rooster(new Klas(klasNummer + 1));
				rooster.setKlas(klas);
				Assertions.assertThat(rooster.getKlas()).isEqualTo(klas);
			}
			
			@ParameterizedTest
			@ValueSource(ints = {1, 2, 3, 4})
			public void testSetKlasFalse(int klasNummer) {
				Klas klas = new Klas(klasNummer);
				Rooster rooster = new Rooster(new Klas(klasNummer + 1));
				Assertions.assertThat(rooster.getKlas()).isNotEqualTo(klas);
			}
			
			@ParameterizedTest
			@CsvSource({
				"test,10:10,11:10,a",
				"test1,10:11,11:11,b",
				"test2,10:12,11:12,c",
				"test3,10:13,11:13,d",
			})
			public void testSetLessenLijstTrue(String naam, String beginTijd, String eindTijd, String vak) {
				Rooster rooster = new Rooster(new Klas(1));
				ArrayList<Les> lessen = new ArrayList<>();
				for(int i=0;i<=10;i++) {
					lessen.add(new Les(naam, beginTijd, eindTijd, LocalDate.now(), new Vak(vak + i)));
				}
				rooster.setLessenLijst(lessen);
				Assertions.assertThat(rooster.getLessenLijst()).isEqualTo(lessen);
			}
			
			@ParameterizedTest
			@CsvSource({
				"test,10:10,11:10,a",
				"test1,10:11,11:11,b",
				"test2,10:12,11:12,c",
				"test3,10:13,11:13,d",
			})
			public void testSetLessenLijstFalse(String naam, String beginTijd, String eindTijd, String vak) {
				Rooster rooster = new Rooster(new Klas(1));
				ArrayList<Les> lessen = new ArrayList<>();
				for(int i=0;i<=10;i++) {
					lessen.add(new Les(naam, beginTijd, eindTijd, LocalDate.now(), new Vak(vak + i)));
				}
				Assertions.assertThat(rooster.getLessenLijst()).isNotEqualTo(lessen);
			}
		}
		
		@Nested
		class testAdd {
			@ParameterizedTest
			@CsvSource({
				"test,10:10,11:10,a",
				"test1,10:11,11:11,b",
				"test2,10:12,11:12,c",
				"test3,10:13,11:13,d",
			})
			public void testAddLesTrue(String naam, String beginTijd, String eindTijd, String vak) {
				Rooster rooster = new Rooster(new Klas(1));
				Les les = new Les(naam, beginTijd, eindTijd, LocalDate.now(), new Vak(vak));
				rooster.addLes(les);
				Assertions.assertThat(rooster.getLessenLijst()).contains(les);
			}
			
			@ParameterizedTest
			@CsvSource({
				"test,10:10,11:10,a",
				"test1,10:11,11:11,b",
				"test2,10:12,11:12,c",
				"test3,10:13,11:13,d",
			})
			public void testAddLesFalse(String naam, String beginTijd, String eindTijd, String vak) {
				Rooster rooster = new Rooster(new Klas(1));
				Les les = new Les(naam, beginTijd, eindTijd, LocalDate.now(), new Vak(vak));
				Assertions.assertThat(rooster.getLessenLijst()).doesNotContain(les);
			}
		}
	}
	
	@Nested
	class testSLB {
		@Nested
		class testGet {
			@ParameterizedTest
			@CsvSource({
				"test,test,test,test,1",
				"test1,test1,test1,test1,2",
				"test2,test2,test2,test2,3",
				"test3,test3,test3,test3,4",
			})
			public void testGetStudentenLijstTrue(String email, String password, String voornaam, String achternaam, int studentNummer) {
				SLB slb = new SLB(email, password, voornaam, achternaam);
				List<Student> studenten = new ArrayList<>();
				for(int i=0;i<=10;i++) {
					studenten.add(new Student(email, password, voornaam, achternaam, studentNummer + i));
				}
				slb.setStudentenLijst(studenten);
				Assertions.assertThat(slb.getStudentenLijst()).isEqualTo(studenten);
			}
			
			@ParameterizedTest
			@CsvSource({
				"test,test,test,test,1",
				"test1,test1,test1,test1,2",
				"test2,test2,test2,test2,3",
				"test3,test3,test3,test3,4",
			})
			public void testGetStudentenLijstFalse(String email, String password, String voornaam, String achternaam, int studentNummer) {
				SLB slb = new SLB(email, password, voornaam, achternaam);
				List<Student> studenten = new ArrayList<>();
				for(int i=0;i<=10;i++) {
					studenten.add(new Student(email, password, voornaam, achternaam, studentNummer + i));
				}
				Assertions.assertThat(slb.getStudentenLijst()).isNotEqualTo(studenten);
			}
		}
		
		@Nested
		class testSet {
			@ParameterizedTest
			@CsvSource({
				"test,test,test,test,1",
				"test1,test1,test1,test1,2",
				"test2,test2,test2,test2,3",
				"test3,test3,test3,test3,4",
			})
			public void testSetStudentenLijstTrue(String email, String password, String voornaam, String achternaam, int studentNummer) {
				SLB slb = new SLB(email, password, voornaam, achternaam);
				List<Student> studenten = new ArrayList<>();
				for(int i=0;i<=10;i++) {
					studenten.add(new Student(email, password, voornaam, achternaam, studentNummer + i));
				}
				slb.setStudentenLijst(studenten);
				Assertions.assertThat(slb.getStudentenLijst()).isEqualTo(studenten);
			}
			
			@ParameterizedTest
			@CsvSource({
				"test,test,test,test,1",
				"test1,test1,test1,test1,2",
				"test2,test2,test2,test2,3",
				"test3,test3,test3,test3,4",
			})
			public void testSetStudentenLijstFalse(String email, String password, String voornaam, String achternaam, int studentNummer) {
				SLB slb = new SLB(email, password, voornaam, achternaam);
				List<Student> studenten = new ArrayList<>();
				for(int i=0;i<=10;i++) {
					studenten.add(new Student(email, password, voornaam, achternaam, studentNummer + i));
				}
				Assertions.assertThat(slb.getStudentenLijst()).isNotEqualTo(studenten);
			}
		}
		
		@Nested
		class testAdd {
			@ParameterizedTest
			@CsvSource({
				"test,test,test,test,1",
				"test1,test1,test1,test1,2",
				"test2,test2,test2,test2,3",
				"test3,test3,test3,test3,4",
			})
			public void testAddStudentenLijstTrue(String email, String password, String voornaam, String achternaam, int studentNummer) {
				SLB slb = new SLB(email, password, voornaam, achternaam);
				Student student = new Student(email, password, voornaam, achternaam, studentNummer);
				slb.addStudent(student);
				Assertions.assertThat(slb.getStudentenLijst()).contains(student);
			}
			
			@ParameterizedTest
			@CsvSource({
				"test,test,test,test,1",
				"test1,test1,test1,test1,2",
				"test2,test2,test2,test2,3",
				"test3,test3,test3,test3,4",
			})
			public void testAddStudentenLijstFalse(String email, String password, String voornaam, String achternaam, int studentNummer) {
				SLB slb = new SLB(email, password, voornaam, achternaam);
				Student student = new Student(email, password, voornaam, achternaam, studentNummer);
				Assertions.assertThat(slb.getStudentenLijst()).doesNotContain(student);
			}
		}
	}
	
	@Nested
	class testStudent {
		@Nested
		class testGet {

		}
		
		@Nested
		class testSet {
			
		}
	}
	
	@Nested
	class testVak {
		@Nested
		class testGet {

		}
		
		@Nested
		class testAdd {
			
		}
		
		@Nested
		class testRemove {
			
		}
	}
	
	@Nested
	class testUtils {
		@Nested
		class testPassword {
			@ParameterizedTest
			@CsvSource({
				"test,52b056b246418df1d721751449e73af7276ca9490d0a3ff39e25fff284fbfaead1c518ffdd21d06b9131f069550ef1725f91c26f5b34539fde8c7e2cd692e5b2",
				"1234,32bab38878771552eac03e9e762cdd7f37fb5f80d5121f3bc74a60b32ab880c59e89b6edf45d879f220eecdeefdb04cdc4e221d8210509316cbb053873adef5a",
				"testtest,dc3d3c90c8ed985d54d982e16e8bdc78bd5ab3825590614812b10cd71963d422bd74065ee24217dd7311d4efbdfad85f7f8bab04d776220c504d12c38d67c4f8",
				"1234567890,0cc841c80dc30b05c16df84c7ded9acd3282670a00ad485aa6f0272edad73b3c9e360c392e24de05effa34dea5e25da51c07c7afa09ad447c99b41023c371313"
			})
			public void testHashPasswordTrue(String password, String hash) {
				Assertions.assertThat(Utils.hashPassword(password)).isEqualTo(hash);
			}
			
			@ParameterizedTest
			@CsvSource({
				"test,52b056b246418df1d721751449e73af7276ca9490d0a3ff39e25fff284fbfaead1c518ffdd21d06b9131f069550ef1725f91c26f5b34539fde8c7e2cd692e5b2",
				"1234,32bab38878771552eac03e9e762cdd7f37fb5f80d5121f3bc74a60b32ab880c59e89b6edf45d879f220eecdeefdb04cdc4e221d8210509316cbb053873adef5a",
				"testtest,dc3d3c90c8ed985d54d982e16e8bdc78bd5ab3825590614812b10cd71963d422bd74065ee24217dd7311d4efbdfad85f7f8bab04d776220c504d12c38d67c4f8",
				"1234567890,0cc841c80dc30b05c16df84c7ded9acd3282670a00ad485aa6f0272edad73b3c9e360c392e24de05effa34dea5e25da51c07c7afa09ad447c99b41023c371313"
			})
			public void testHashPasswordFalse(String password, String hash) {
				Assertions.assertThat(Utils.hashPassword(password)).isNotEqualTo("nope");
			}
			
			@ParameterizedTest
			@ValueSource(strings = {"test", "1234", "testtest", "1234567890"})
			public void testCheckPasswordTrue(String password) {
				Gebruiker gebruiker = new Gebruiker("test", password, "test", "test");
				Assertions.assertThat(Utils.checkPassword(gebruiker, password)).isTrue();
			}
			
			@ParameterizedTest
			@ValueSource(strings = {"test", "1234", "testtest", "1234567890"})
			public void testCheckPasswordFalse(String password) {
				Gebruiker gebruiker = new Gebruiker("test", password, "test", "test");
				Assertions.assertThat(Utils.checkPassword(gebruiker, "nope")).isFalse();
			}
		}
		
		@Nested
		class testTime {
			@ParameterizedTest
			@CsvSource({
				"10:10,11:10,1",
				"10:10,10:11,1",
				"10:10,09:10,-1",
				"10:10,10:09,-1",
				"10:10,10:10,0"
			})
			public void testCompareTime(String time1, String time2, int expected) {
				Assertions.assertThat(Utils.compareTime(time1, time2)).isEqualTo(expected);
			}
		}
	}
}
