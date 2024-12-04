package hospital.entity.patients;

import hospital.entity.patient.PatientOrc;
import hospital.services.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatientOrcTest {

    private PatientOrc patientOrc ;
    @BeforeEach
    public void setUp() {
        patientOrc = new PatientOrc("Orc", true, 28, 104,220);
    }

    @Test
    public void getNameTest() {
        assertEquals("Orc", patientOrc.getName());
    }

    @Test
    public void setNameTest(){
        patientOrc.setName("Orc2");
        assertEquals("Orc2", patientOrc.getName());
    }

    @Test
    public void isMaleTest() {
        assertTrue(patientOrc.isMale());
    }

    @Test
    public void setMaleTest(){
        patientOrc.setMale(false);
        assertFalse(patientOrc.isMale());
    }

    @Test
    public void getAgeTest() {
        assertEquals(28, patientOrc.getAge());
    }

    @Test
    public void setAgeTest(){
        patientOrc.setAge(30);
        assertEquals(30, patientOrc.getAge());
    }

    @Test
    public void getWeightTest() {
        assertEquals(104, patientOrc.getWeight());
    }

    @Test
    public void getHeightTest() {
        assertEquals(220, patientOrc.getHeight());
    }

    @Test
    public void setWeightTest(){
        patientOrc.setWeight(100);
        assertEquals(100, patientOrc.getWeight());
    }

    @Test
    public void setHeightTest(){
        patientOrc.setHeight(200);
        assertEquals(200, patientOrc.getHeight());
    }

    @Test
    public void getMoraleTest() {
        assertEquals(100, patientOrc.getMorale());
    }

    @Test
    public void setMoraleTest(){
        patientOrc.setMorale(50);
        assertEquals(50, patientOrc.getMorale());
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
        patientOrc.scream();
        assertEquals("Orc screams...\n", outputStream.toString());
    }

    @Test
    public void waitATimeTest(){
        Service service = new Service("Service", 100, 10, 1500);
        service.addPatient(patientOrc);
        patientOrc.waitATime();
        //assertEquals(99, patientOrc.getMorale());
    }

    @Test
    public void passAwayTest(){
        Service service = new Service("Service", 100, 10, 1500);
        service.addPatient(patientOrc);
        patientOrc.passAway();
        assertFalse(patientOrc.getIsAlive());
    }

    @Test
    public void carriedAwayTest(){
    }

    @Test
    public void contaminateTest(){
    }

    @Test
    public void toStringTest(){
        assertEquals("PatientOrc{name='Orc', isMale=true, weight=104.0, height=220.0, age=28}", patientOrc.toString());
    }
}
