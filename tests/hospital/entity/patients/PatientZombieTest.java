package hospital.entity.patients;

import hospital.entity.patient.PatientZombie;
import hospital.services.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatientZombieTest {

    private PatientZombie patientZombie ;
    @BeforeEach
    public void setUp() {
        patientZombie = new PatientZombie("Zombie", true, 28, 104,220);
    }

    @Test
    public void getNameTest() {
        assertEquals("Zombie", patientZombie.getName());
    }

    @Test
    public void setNameTest(){
        patientZombie.setName("Zombie2");
        assertEquals("Zombie2", patientZombie.getName());
    }

    @Test
    public void isMaleTest() {
        assertTrue(patientZombie.isMale());
    }

    @Test
    public void setMaleTest(){
        patientZombie.setMale(false);
        assertFalse(patientZombie.isMale());
    }

    @Test
    public void getAgeTest() {
        assertEquals(28, patientZombie.getAge());
    }

    @Test
    public void setAgeTest(){
        patientZombie.setAge(30);
        assertEquals(30, patientZombie.getAge());
    }

    @Test
    public void getWeightTest() {
        assertEquals(104, patientZombie.getWeight());
    }

    @Test
    public void getHeightTest() {
        assertEquals(220, patientZombie.getHeight());
    }

    @Test
    public void setWeightTest(){
        patientZombie.setWeight(100);
        assertEquals(100, patientZombie.getWeight());
    }

    @Test
    public void setHeightTest(){
        patientZombie.setHeight(200);
        assertEquals(200, patientZombie.getHeight());
    }

    @Test
    public void getMoraleTest() {
        assertEquals(100, patientZombie.getMorale());
    }

    @Test
    public void setMoraleTest(){
        patientZombie.setMorale(50);
        assertEquals(50, patientZombie.getMorale());
    }

    @Test
    public void getIllnessesTest(){
    }

    @Test
    public void setIllnessesTest(){

    }
    @Test
    public void addIllnessTest(){
    }

    @Test
    public void removeIllnessTest(){
    }

    @Test
    public void screamTest(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out; // Sauvegarde de l'original
        System.setOut(new PrintStream(outputStream));
        patientZombie.scream();
        //assertEquals("The patient Zombie is screaming.\n", outputStream.toString());
    }

    @Test
    public void waitATimeTest(){
        patientZombie.waitATime();
        //assertEquals(99, patientZombie.getMorale());
    }

    @Test
    public void passAwayTest(){
        Service service = new Service("Service", 100, 10, 1500);
        service.addPatient(patientZombie);
        patientZombie.passAway(service);
        assertFalse(patientZombie.getIsAlive());
    }

    @Test
    public void carriedAwayTest(){
    }

    @Test
    public void reviveTest(){
    }

    @Test
    public void toStringTest(){
        assertEquals("PatientZombie{name='Zombie', isMale=true, weight=104.0, height=220.0, age=28}", patientZombie.toString());
    }
}
