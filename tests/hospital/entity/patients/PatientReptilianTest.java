package hospital.entity.patients;

import hospital.entity.Patient;
import hospital.entity.patient.PatientReptilian;
import hospital.illness.Illness;
import hospital.illness.Illnesses;
import hospital.services.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

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
    public void addIllnessTest(){
        Illness illness = new Illness(Illnesses.DRS);
        patientReptilian.addIllness(illness);
        assertEquals(1, patientReptilian.getIllnesses().size());
        assertTrue(patientReptilian.getIllnesses().contains(illness));
    }

    @Test
    public void getIllnessesTest(){
        Illness illness1 = new Illness(Illnesses.DRS);
        Illness illness2 = new Illness(Illnesses.MDC);
        patientReptilian.addIllness(illness1);
        patientReptilian.addIllness(illness2);
        Set<Illness> expectedIllnesses = new HashSet<>();
        expectedIllnesses.add(illness1);
        expectedIllnesses.add(illness2);
        assertEquals(expectedIllnesses, patientReptilian.getIllnesses());
    }

    @Test
    public void setIllnessesTest(){
        Illness illness1 = new Illness(Illnesses.DRS);
        Illness illness2 = new Illness(Illnesses.MDC);
        Set<Illness> listIllnesses = new HashSet<>();
        listIllnesses.add(illness1);
        listIllnesses.add(illness2);
        patientReptilian.setIllnesses(listIllnesses);
        assertTrue(patientReptilian.getIllnesses().contains(illness1));
        assertTrue(patientReptilian.getIllnesses().contains(illness2));

    }


    @Test
    public void removeIllnessTest(){
        Illness illness = new Illness(Illnesses.DRS);
        patientReptilian.addIllness(illness);
        assertTrue(patientReptilian.getIllnesses().contains(illness));
        patientReptilian.removeIllness(illness);
        assertEquals(0, patientReptilian.getIllnesses().size());
    }

    @Test
    public void screamTest(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // Sauvegarde de l'original
        System.setOut(new PrintStream(outputStream));
        patientReptilian.scream();
        assertEquals("Reptilian screams...\n", outputStream.toString());
    }

    @Test
    public void waitATimeTest(){
        patientReptilian.waitATime();
        assertEquals(96, patientReptilian.getMorale());
    }

    @Test
    public void passAwayTest(){
        Service service = new Service("Service", 100, 10, 1500);
        service.addPatient(patientReptilian);
        patientReptilian.passAway();
        assertFalse(patientReptilian.getIsAlive());

    }

    @Test
    public void agoniseTest(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        patientReptilian.setMorale(Patient.MORALE_MIN);
        patientReptilian.agonise();
        assertEquals("""
                Reptilian is agonising
                Reptilian screams...
                Reptilian screams...
                Reptilian screams...
                Reptilian screams...
                Reptilian screams...
                """, outputStream.toString());
    }
    @Test
    public void compareMoraleTest(){
        PatientReptilian patientReptilian2 = new PatientReptilian("Reptilian2", true, 28, 104,220);
        patientReptilian.setMorale(50);
        patientReptilian2.setMorale(100);
        assertFalse(patientReptilian.compareMorale(patientReptilian2));
    }

    @Test
    public void getIllnessesLvlSumTest() {
        Illness illness1 = new Illness(Illnesses.DRS);
        Illness illness2 = new Illness(Illnesses.MDC);
        patientReptilian.addIllness(illness1);
        patientReptilian.addIllness(illness2);
        assertEquals(0, patientReptilian.getIllnessesLvlSum());
    }
    @Test
    public void compareIllnessLevelTest(){
        PatientReptilian patientReptilian2 = new PatientReptilian("Reptilian2", true, 28, 104,220);
        Illness illness1 = new Illness(Illnesses.DRS);
        Illness illness2 = new Illness(Illnesses.MDC);
        illness2.setLvl(4);
        patientReptilian.addIllness(illness1);
        patientReptilian2.addIllness(illness2);
        assertFalse(patientReptilian.compareIllnessLevel(patientReptilian2));
    }
    @Test
    public void compareMoraleAndIllnessLevelTest()
    {
        PatientReptilian patientReptilian2 = new PatientReptilian("Reptilian2", true, 28, 104,220);
        Illness illness1 = new Illness(Illnesses.DRS);
        Illness illness2 = new Illness(Illnesses.MDC);
        patientReptilian.addIllness(illness1);
        illness1.setLvl(4);
        patientReptilian.setMorale(100);
        patientReptilian2.addIllness(illness2);
        patientReptilian2.setMorale(50);
        assertTrue(patientReptilian.compareMoraleAndIllnessLevel(patientReptilian2));
    }
    

    @Test
    public void toStringTest(){
        assertEquals("PatientReptilian{name='Reptilian', isMale=true, weight=104.0, height=220.0, age=28}", patientReptilian.toString());
    }
}
