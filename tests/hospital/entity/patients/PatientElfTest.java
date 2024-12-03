package hospital.entity.patients;

import hospital.entity.patient.PatientElf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class PatientElfTest {

    private PatientElf patientElf ;
    @BeforeEach
    public void setUp() {
        patientElf = new PatientElf("Elf", true, 28, 104,220);
    }

    @Test
    public void getNameTest() {
        assertEquals("Elf", patientElf.getName());
    }

    @Test
    public void setNameTest(){
        patientElf.setName("Elf2");
        assertEquals("Elf2", patientElf.getName());
    }

    @Test
    public void isMaleTest() {
        assertTrue(patientElf.isMale());
    }

    @Test
    public void setMaleTest(){
        patientElf.setMale(false);
        assertFalse(patientElf.isMale());
    }

    @Test
    public void getAgeTest() {
        assertEquals(28, patientElf.getAge());
    }

    @Test
    public void setAgeTest(){
        patientElf.setAge(30);
        assertEquals(30, patientElf.getAge());
    }

    @Test
    public void getWeightTest() {
        assertEquals(104, patientElf.getWeight());
    }

    @Test
    public void getHeightTest() {
        assertEquals(220, patientElf.getHeight());
    }

    @Test
    public void setWeightTest(){
        patientElf.setWeight(100);
        assertEquals(100, patientElf.getWeight());
    }

    @Test
    public void setHeightTest(){
        patientElf.setHeight(200);
        assertEquals(200, patientElf.getHeight());
    }

    @Test
    public void getMoraleTest() {
        assertEquals(100, patientElf.getMorale());
    }

    @Test
    public void setMoraleTest(){
        patientElf.setMorale(50);
        assertEquals(50, patientElf.getMorale());
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
        patientElf.scream();
        //assertEquals("The patient Elf is screaming.\n", outputStream.toString());
    }

    @Test
    public void waitATimeTest(){
        patientElf.waitATime();
        //assertEquals(99, patientElf.getMorale());
    }

    @Test
    public void passAwayTest(){
        patientElf.passAway();
        //assertFalse(patientElf.isAlive());
    }

    @Test
    public void carriedAwayTest(){
    }

    @Test
    public void contaminateTest(){
    }

    @Test
    public void toStringTest(){
        assertEquals("PatientElf{name='Elf', isMale=true, weight=104.0, height=220.0, age=28}", patientElf.toString());
    }
}
