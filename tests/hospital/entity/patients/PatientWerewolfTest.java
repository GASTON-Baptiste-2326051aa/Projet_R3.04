package hospital.entity.patients;

import hospital.entity.Patient;
import hospital.entity.patient.PatientWerewolf;
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
    public void addIllnessTest(){
        Illness illness = new Illness(Illnesses.DRS);
        patientWerewolf.addIllness(illness);
        assertEquals(1, patientWerewolf.getIllnesses().size());
        assertTrue(patientWerewolf.getIllnesses().contains(illness));
    }

    @Test
    public void getIllnessesTest(){
        Illness illness1 = new Illness(Illnesses.DRS);
        Illness illness2 = new Illness(Illnesses.MDC);
        patientWerewolf.addIllness(illness1);
        patientWerewolf.addIllness(illness2);
        Set<Illness> expectedIllnesses = new HashSet<>();
        expectedIllnesses.add(illness1);
        expectedIllnesses.add(illness2);
        assertEquals(expectedIllnesses, patientWerewolf.getIllnesses());
    }

    @Test
    public void setIllnessesTest(){
        Illness illness1 = new Illness(Illnesses.DRS);
        Illness illness2 = new Illness(Illnesses.MDC);
        Set<Illness> listIllnesses = new HashSet<>();
        listIllnesses.add(illness1);
        listIllnesses.add(illness2);
        patientWerewolf.setIllnesses(listIllnesses);
        assertTrue(patientWerewolf.getIllnesses().contains(illness1));
        assertTrue(patientWerewolf.getIllnesses().contains(illness2));

    }


    @Test
    public void removeIllnessTest(){
        Illness illness = new Illness(Illnesses.DRS);
        patientWerewolf.addIllness(illness);
        assertTrue(patientWerewolf.getIllnesses().contains(illness));
        patientWerewolf.removeIllness(illness);
        assertEquals(0, patientWerewolf.getIllnesses().size());
    }

    @Test
    public void screamTest(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        patientWerewolf.scream();
        assertEquals("Werewolf screams...\n", outputStream.toString());
    }

    @Test
    public void waitATimeTest(){
        Service service = new Service("Service", 100, 10, 1500);
        service.addPatient(patientWerewolf);
        patientWerewolf.waitATime();
        assertEquals(98, patientWerewolf.getMorale());
    }

    @Test
    public void passAwayTest(){
        Service service = new Service("Service", 100, 10, 1500);
        service.addPatient(patientWerewolf);
        patientWerewolf.passAway();
        assertFalse(patientWerewolf.getIsAlive());

    }

    @Test
    public void agoniseTest(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        patientWerewolf.setMorale(Patient.MORALE_MIN);
        patientWerewolf.agonise();
        assertEquals("""
                Werewolf is agonising
                Werewolf screams...
                Werewolf screams...
                Werewolf screams...
                Werewolf screams...
                Werewolf screams...
                """, outputStream.toString());
    }

    @Test
    public void contaminateTest(){
        Service service = new Service("Service", 100, 10, 1500);
        PatientWerewolf patientWerewolf2 = new PatientWerewolf("Werewolf2", true, 28, 104,220);
        service.addPatient(patientWerewolf);
        service.addPatient(patientWerewolf2);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        assertThrows(IllegalStateException.class, () -> patientWerewolf.contaminate());
        patientWerewolf.addIllness(getRandomIllness());
        patientWerewolf.contaminate();
        assertEquals("Werewolf contaminates Werewolf2...\n", outputStream.toString());

    }

    @Test
    public void compareMoraleTest(){
        PatientWerewolf patientWerewolf2 = new PatientWerewolf("Werewolf2", true, 28, 104,220);
        patientWerewolf.setMorale(50);
        patientWerewolf2.setMorale(100);
        assertFalse(patientWerewolf.compareMorale(patientWerewolf2));
    }

    @Test
    public void getIllnessesLvlSumTest() {
        Illness illness1 = new Illness(Illnesses.DRS);
        Illness illness2 = new Illness(Illnesses.MDC);
        patientWerewolf.addIllness(illness1);
        patientWerewolf.addIllness(illness2);
        assertEquals(0, patientWerewolf.getIllnessesLvlSum());
    }
    @Test
    public void compareIllnessLevelTest(){
        PatientWerewolf patientWerewolf2 = new PatientWerewolf("Werewolf2", true, 28, 104,220);
        Illness illness1 = new Illness(Illnesses.DRS);
        Illness illness2 = new Illness(Illnesses.MDC);
        illness2.setLvl(4);
        patientWerewolf.addIllness(illness1);
        patientWerewolf2.addIllness(illness2);
        assertFalse(patientWerewolf.compareIllnessLevel(patientWerewolf2));
    }
    @Test
    public void compareMoraleAndIllnessLevelTest()
    {
        PatientWerewolf patientWerewolf2 = new PatientWerewolf("Werewolf2", true, 28, 104,220);
        Illness illness1 = new Illness(Illnesses.DRS);
        Illness illness2 = new Illness(Illnesses.MDC);
        patientWerewolf.addIllness(illness1);
        illness1.setLvl(4);
        patientWerewolf.setMorale(100);
        patientWerewolf2.addIllness(illness2);
        patientWerewolf2.setMorale(50);
        assertTrue(patientWerewolf.compareMoraleAndIllnessLevel(patientWerewolf2));
    }

    @Test
    public void toStringTest(){
        assertEquals("PatientWerewolf{name='Werewolf', isMale=true, weight=104.0, height=220.0, age=28}", patientWerewolf.toString());
    }
}
