package hospital.entity.patients;

import hospital.entity.patient.PatientBeastMan;
import hospital.services.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PatientBeastManTest {

    private PatientBeastMan patientBeastMan ;
    @BeforeEach
    public void setUp() {
        patientBeastMan = new PatientBeastMan("BeastMan", true, 28, 104,220);
    }
    
    @Test
    public void getNameTest() {
        assertEquals("BeastMan", patientBeastMan.getName());
    }

    @Test
    public void setNameTest(){
        patientBeastMan.setName("BeastMan2");
        assertEquals("BeastMan2", patientBeastMan.getName());
    }

    @Test
    public void isMaleTest() {
        assertTrue(patientBeastMan.isMale());
    }

    @Test
    public void setMaleTest(){
        patientBeastMan.setMale(false);
        assertFalse(patientBeastMan.isMale());
    }

    @Test
    public void getAgeTest() {
        assertEquals(28, patientBeastMan.getAge());
    }

    @Test
    public void setAgeTest(){
        patientBeastMan.setAge(30);
        assertEquals(30, patientBeastMan.getAge());
    }

    @Test
    public void getWeightTest() {
        assertEquals(104, patientBeastMan.getWeight());
    }

    @Test
    public void getHeightTest() {
        assertEquals(220, patientBeastMan.getHeight());
    }

    @Test
    public void setWeightTest(){
        patientBeastMan.setWeight(100);
        assertEquals(100, patientBeastMan.getWeight());
    }

    @Test
    public void setHeightTest(){
        patientBeastMan.setHeight(200);
        assertEquals(200, patientBeastMan.getHeight());
    }
    
    @Test
    public void getMoraleTest() {
        assertEquals(100, patientBeastMan.getMorale());
    }

    @Test
    public void setMoraleTest(){
        patientBeastMan.setMorale(50);
        assertEquals(50, patientBeastMan.getMorale());
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
        patientBeastMan.scream();
        assertEquals("BeastMan screams...\n", outputStream.toString());
    }

    @Test
    public void waitATimeTest(){
        Service service = new Service("Service", 100, 10, 1500);
        service.addPatient(patientBeastMan);
        patientBeastMan.waitATime();
        //assertEquals(99, patientBeastMan.getMorale());
    }

    @Test
    public void passAwayTest(){
        Service service = new Service("Service", 100, 10, 1500);
        service.addPatient(patientBeastMan);
        patientBeastMan.passAway();
        assertFalse(patientBeastMan.getIsAlive());
    }

    @Test
    public void carriedAwayTest(){
    }


    @Test
    public void toStringTest(){
        assertEquals("PatientBeastMan{name='BeastMan', isMale=true, weight=104.0, height=220.0, age=28}", patientBeastMan.toString());
    }

}
