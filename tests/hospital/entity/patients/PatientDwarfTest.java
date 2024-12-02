package hospital.entity.patients;

import hospital.entity.patient.PatientDwarf;
import hospital.illness.Illness;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PatientDwarfTest {

    private PatientDwarf patientDwarf;

    @BeforeEach
    public void setUp() {
        patientDwarf = new PatientDwarf("Dwarf", true, 10, 80,140);
    }

    @Test
    public void getNameTest() {
        assertEquals("Dwarf", patientDwarf.getName());
    }

    @Test
    public void setNameTest(){
        patientDwarf.setName("Dwarf2");
        assertEquals("Dwarf2", patientDwarf.getName());
    }

    @Test
    public void isMaleTest() {
        assertTrue(patientDwarf.isMale());
    }

    @Test
    public void setMaleTest(){
        patientDwarf.setMale(false);
        assertFalse(patientDwarf.isMale());
    }

    @Test
    public void getAgeTest() {
        assertEquals(10, patientDwarf.getAge());
    }

    @Test
    public void setAgeTest(){
        patientDwarf.setAge(30);
        assertEquals(30, patientDwarf.getAge());
    }

    @Test
    public void getWeightTest() {
        assertEquals(80, patientDwarf.getWeight());
    }

    @Test
    public void getHeightTest() {
        assertEquals(140, patientDwarf.getHeight());
    }

    @Test
    public void setWeightTest(){
        patientDwarf.setWeight(100);
        assertEquals(100, patientDwarf.getWeight());
    }

    @Test
    public void setHeightTest(){
        patientDwarf.setHeight(200);
        assertEquals(200, patientDwarf.getHeight());
    }
    
    @Test
    public void getMoraleTest() {
        assertEquals(100, patientDwarf.getMorale());
    }

    @Test
    public void setMoraleTest(){
        patientDwarf.setMorale(50);
        assertEquals(50, patientDwarf.getMorale());
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
        patientDwarf.scream();
        assertEquals("The patient Dwarf is screaming.\n", outputStream.toString());
    }

    @Test
    public void waitATimeTest(){
        patientDwarf.waitATime();
        assertEquals(99, patientDwarf.getMorale());
    }

    @Test
    public void passAwayTest(){
        patientDwarf.passAway();
        //assertFalse(patientDwarf.isAlive());
    }

    @Test
    public void carriedAwayTest(){
    }

    @Test
    public void toStringTest(){
        assertEquals("PatientDwarf{name='Dwarf', isMale=true, weight=80.0, height=140.0, age=10}", patientDwarf.toString());
    }
}
