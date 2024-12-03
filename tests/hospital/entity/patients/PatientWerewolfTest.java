package hospital.entity.patients;

import hospital.entity.patient.PatientWerewolf;
import hospital.services.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatientWerewolfTest {

    private PatientWerewolf patientWerewolf ;
    @BeforeEach
    public void setUp() {
        patientWerewolf = new PatientWerewolf("Werewolf", true, 28, 104,220);
    }

    @Test
    public void getNameTest() {
        assertEquals("Werewolf", patientWerewolf.getName());
    }

    @Test
    public void setNameTest(){
        patientWerewolf.setName("Werewolf2");
        assertEquals("Werewolf2", patientWerewolf.getName());
    }

    @Test
    public void isMaleTest() {
        assertTrue(patientWerewolf.isMale());
    }

    @Test
    public void setMaleTest(){
        patientWerewolf.setMale(false);
        assertFalse(patientWerewolf.isMale());
    }

    @Test
    public void getAgeTest() {
        assertEquals(28, patientWerewolf.getAge());
    }

    @Test
    public void setAgeTest(){
        patientWerewolf.setAge(30);
        assertEquals(30, patientWerewolf.getAge());
    }

    @Test
    public void getWeightTest() {
        assertEquals(104, patientWerewolf.getWeight());
    }

    @Test
    public void getHeightTest() {
        assertEquals(220, patientWerewolf.getHeight());
    }

    @Test
    public void setWeightTest(){
        patientWerewolf.setWeight(100);
        assertEquals(100, patientWerewolf.getWeight());
    }

    @Test
    public void setHeightTest(){
        patientWerewolf.setHeight(200);
        assertEquals(200, patientWerewolf.getHeight());
    }

    @Test
    public void getMoraleTest() {
        assertEquals(100, patientWerewolf.getMorale());
    }

    @Test
    public void setMoraleTest(){
        patientWerewolf.setMorale(50);
        assertEquals(50, patientWerewolf.getMorale());
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
        patientWerewolf.scream();
        assertEquals("Werewolf screams...\n", outputStream.toString());
    }

    @Test
    public void waitATimeTest(){
        patientWerewolf.waitATime();
        //assertEquals(99, patientWerewolf.getMorale());
    }

    @Test
    public void passAwayTest(){
        Service service = new Service("Service", 100, 10, 1500);
        service.addPatient(patientWerewolf);
        patientWerewolf.passAway(service);
        assertFalse(patientWerewolf.getIsAlive());
    }

    @Test
    public void carriedAwayTest(){
    }

    @Test
    public void contaminateTest(){
    }

    @Test
    public void toStringTest(){
        assertEquals("PatientWerewolf{name='Werewolf', isMale=true, weight=104.0, height=220.0, age=28}", patientWerewolf.toString());
    }
}
