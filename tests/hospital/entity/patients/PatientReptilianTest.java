package hospital.entity.patients;

import hospital.entity.patient.PatientReptilian;
import hospital.services.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatientReptilianTest {

    private PatientReptilian patientReptilian ;
    @BeforeEach
    public void setUp() {
        patientReptilian = new PatientReptilian("Reptilian", true, 28, 104,220);
    }

    @Test
    public void getNameTest() {
        assertEquals("Reptilian", patientReptilian.getName());
    }

    @Test
    public void setNameTest(){
        patientReptilian.setName("Reptilian2");
        assertEquals("Reptilian2", patientReptilian.getName());
    }

    @Test
    public void isMaleTest() {
        assertTrue(patientReptilian.isMale());
    }

    @Test
    public void setMaleTest(){
        patientReptilian.setMale(false);
        assertFalse(patientReptilian.isMale());
    }

    @Test
    public void getAgeTest() {
        assertEquals(28, patientReptilian.getAge());
    }

    @Test
    public void setAgeTest(){
        patientReptilian.setAge(30);
        assertEquals(30, patientReptilian.getAge());
    }

    @Test
    public void getWeightTest() {
        assertEquals(104, patientReptilian.getWeight());
    }

    @Test
    public void getHeightTest() {
        assertEquals(220, patientReptilian.getHeight());
    }

    @Test
    public void setWeightTest(){
        patientReptilian.setWeight(100);
        assertEquals(100, patientReptilian.getWeight());
    }

    @Test
    public void setHeightTest(){
        patientReptilian.setHeight(200);
        assertEquals(200, patientReptilian.getHeight());
    }

    @Test
    public void getMoraleTest() {
        assertEquals(100, patientReptilian.getMorale());
    }

    @Test
    public void setMoraleTest(){
        patientReptilian.setMorale(50);
        assertEquals(50, patientReptilian.getMorale());
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
        patientReptilian.scream();
        assertEquals("Reptilian screams...\n", outputStream.toString());
    }

    @Test
    public void waitATimeTest(){
        patientReptilian.waitATime();
        //assertEquals(99, patientReptilian.getMorale());
    }

    @Test
    public void passAwayTest(){
        Service service = new Service("Service", 100, 10, 1500);
        service.addPatient(patientReptilian);
        patientReptilian.passAway();
        assertFalse(patientReptilian.getIsAlive());
    }

    @Test
    public void carriedAwayTest(){
    }

    @Test
    public void toStringTest(){
        assertEquals("PatientReptilian{name='Reptilian', isMale=true, weight=104.0, height=220.0, age=28}", patientReptilian.toString());
    }
}
