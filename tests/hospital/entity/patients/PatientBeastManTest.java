package hospital.entity.patients;

import hospital.entity.Patient;
import hospital.entity.patient.PatientBeastMan;
import hospital.illness.Illness;
import hospital.illness.Illnesses;
import hospital.services.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

import static hospital.illness.Illnesses.getRandomIllness;
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
    public void addIllnessTest(){
        Illness illness = new Illness(Illnesses.DRS);
        patientBeastMan.addIllness(illness);
        assertEquals(1, patientBeastMan.getIllnesses().size());
        assertTrue(patientBeastMan.getIllnesses().contains(illness));
    }

    @Test
    public void getIllnessesTest(){
        Illness illness1 = new Illness(Illnesses.DRS);
        Illness illness2 = new Illness(Illnesses.MDC);
        patientBeastMan.addIllness(illness1);
        patientBeastMan.addIllness(illness2);
        Set<Illness> expectedIllnesses = new HashSet<>();
        expectedIllnesses.add(illness1);
        expectedIllnesses.add(illness2);
        assertEquals(expectedIllnesses, patientBeastMan.getIllnesses());
    }

    @Test
    public void setIllnessesTest(){
        Illness illness1 = new Illness(Illnesses.DRS);
        Illness illness2 = new Illness(Illnesses.MDC);
        Set<Illness> listIllnesses = new HashSet<>();
        listIllnesses.add(illness1);
        listIllnesses.add(illness2);
        patientBeastMan.setIllnesses(listIllnesses);
        assertTrue(patientBeastMan.getIllnesses().contains(illness1));
        assertTrue(patientBeastMan.getIllnesses().contains(illness2));

    }


    @Test
    public void removeIllnessTest(){
        Illness illness = new Illness(Illnesses.DRS);
        patientBeastMan.addIllness(illness);
        assertTrue(patientBeastMan.getIllnesses().contains(illness));
        patientBeastMan.removeIllness(illness);
        assertEquals(0, patientBeastMan.getIllnesses().size());
    }

    @Test
    public void screamTest(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        patientBeastMan.scream();
        assertEquals("BeastMan screams...\n", outputStream.toString());
    }

    @Test
    public void waitATimeTest(){
        Service service = new Service("Service", 100, 10, 1500);
        service.addPatient(patientBeastMan);
        patientBeastMan.waitATime();
        assertEquals(98, patientBeastMan.getMorale());
        PatientBeastMan patientBeastMan2 = new PatientBeastMan("BeastMan2", true, 28, 104,220);
        service.addPatient(patientBeastMan2);
        patientBeastMan2.waitATime();
        assertEquals(99, patientBeastMan2.getMorale());
    }

    @Test
    public void passAwayTest(){
        Service service = new Service("Service", 100, 10, 1500);
        service.addPatient(patientBeastMan);
        patientBeastMan.passAway();
        assertFalse(patientBeastMan.getIsAlive());
    }

    @Test
    public void agoniseTest(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        patientBeastMan.setMorale(Patient.MORALE_MIN);
        patientBeastMan.agonise();
        assertEquals("""
                BeastMan is agonising
                BeastMan screams...
                BeastMan screams...
                BeastMan screams...
                BeastMan screams...
                BeastMan screams...
                """, outputStream.toString());


    }
    @Test
    public void contaminateTest(){
        Service service = new Service("Service", 100, 10, 1500);
        PatientBeastMan patientBeastMan2 = new PatientBeastMan("BeastMan2", true, 28, 104,220);
        service.addPatient(patientBeastMan);
        service.addPatient(patientBeastMan2);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        assertThrows(IllegalStateException.class, () -> patientBeastMan.contaminate());
        patientBeastMan.addIllness(getRandomIllness());
        patientBeastMan.contaminate();
        assertEquals("BeastMan contaminates BeastMan2...\n", outputStream.toString());

    }

    @Test
    public void compareMoraleTest(){
        PatientBeastMan patientBeastMan2 = new PatientBeastMan("BeastMan2", true, 28, 104,220);
        patientBeastMan.setMorale(50);
        patientBeastMan2.setMorale(100);
        assertFalse(patientBeastMan.compareMorale(patientBeastMan2));
    }

    @Test
    public void getIllnessesLvlSumTest() {
        Illness illness1 = new Illness(Illnesses.DRS);
        Illness illness2 = new Illness(Illnesses.MDC);
        patientBeastMan.addIllness(illness1);
        patientBeastMan.addIllness(illness2);
        assertEquals(0, patientBeastMan.getIllnessesLvlSum());
    }
    @Test
    public void compareIllnessLevelTest(){
        PatientBeastMan patientBeastMan2 = new PatientBeastMan("BeastMan2", true, 28, 104,220);
        Illness illness1 = new Illness(Illnesses.DRS);
        Illness illness2 = new Illness(Illnesses.MDC);
        illness2.setLvl(4);
        patientBeastMan.addIllness(illness1);
        patientBeastMan2.addIllness(illness2);
        assertFalse(patientBeastMan.compareIllnessLevel(patientBeastMan2));
    }
    @Test
    public void compareMoraleAndIllnessLevelTest()
    {
        PatientBeastMan patientBeastMan2 = new PatientBeastMan("BeastMan2", true, 28, 104,220);
        Illness illness1 = new Illness(Illnesses.DRS);
        Illness illness2 = new Illness(Illnesses.MDC);
        patientBeastMan.addIllness(illness1);
        illness1.setLvl(4);
        patientBeastMan.setMorale(100);
        patientBeastMan2.addIllness(illness2);
        patientBeastMan2.setMorale(50);
        assertTrue(patientBeastMan.compareMoraleAndIllnessLevel(patientBeastMan2));
    }

    @Test
    public void toStringTest(){
        assertEquals("PatientBeastMan{name='BeastMan', isMale=true, weight=104.0, height=220.0, age=28}", patientBeastMan.toString());
    }

}
