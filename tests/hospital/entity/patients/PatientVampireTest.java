package hospital.entity.patients;

import hospital.entity.patient.PatientVampire;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatientVampireTest {

    private PatientVampire patientVampire ;
    @BeforeEach
    public void setUp() {
        patientVampire = new PatientVampire("Vampire", true, 28, 104,220);
    }

    @Test
    public void getNameTest() {
        assertEquals("Vampire", patientVampire.getName());
    }

    @Test
    public void setNameTest(){
        patientVampire.setName("Vampire2");
        assertEquals("Vampire2", patientVampire.getName());
    }

    @Test
    public void isMaleTest() {
        assertTrue(patientVampire.isMale());
    }

    @Test
    public void setMaleTest(){
        patientVampire.setMale(false);
        assertFalse(patientVampire.isMale());
    }

    @Test
    public void getAgeTest() {
        assertEquals(28, patientVampire.getAge());
    }

    @Test
    public void setAgeTest(){
        patientVampire.setAge(30);
        assertEquals(30, patientVampire.getAge());
    }

    @Test
    public void getWeightTest() {
        assertEquals(104, patientVampire.getWeight());
    }

    @Test
    public void getHeightTest() {
        assertEquals(220, patientVampire.getHeight());
    }

    @Test
    public void setWeightTest(){
        patientVampire.setWeight(100);
        assertEquals(100, patientVampire.getWeight());
    }

    @Test
    public void setHeightTest(){
        patientVampire.setHeight(200);
        assertEquals(200, patientVampire.getHeight());
    }

    @Test
    public void getMoraleTest() {
        assertEquals(100, patientVampire.getMorale());
    }

    @Test
    public void setMoraleTest(){
        patientVampire.setMorale(50);
        assertEquals(50, patientVampire.getMorale());
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
        patientVampire.scream();
        //assertEquals("The patient Vampire is screaming.\n", outputStream.toString());
    }

    @Test
    public void waitATimeTest(){
        patientVampire.waitATime();
        //assertEquals(99, patientVampire.getMorale());
    }

    @Test
    public void passAwayTest(){
        patientVampire.passAway();
        //assertFalse(patientVampire.isAlive());
    }

    @Test
    public void carriedAwayTest(){
    }

    @Test
    public void contaminateTest(){
    }

    @Test
    public void demoralizeTest(){
    }

    @Test
    public void reviveTest(){
    }

    @Test
    public void toStringTest(){
        assertEquals("PatientVampire{name='Vampire', isMale=true, weight=104.0, height=220.0, age=28}", patientVampire.toString());
    }
}
