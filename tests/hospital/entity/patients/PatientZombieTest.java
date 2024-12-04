package hospital.entity.patients;

import hospital.entity.Patient;
import hospital.entity.patient.PatientZombie;
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

public class PatientZombieTest {

    private PatientZombie patientZombie ;
    @BeforeEach
    public void setUp() {
        patientZombie = new PatientZombie("Zombie", true, 28, 104,220);
    }

    @Test
    public void getNameTest() {
        assertEquals("Zombie", patientZombie.getName());
    }

    @Test
    public void setNameTest(){
        patientZombie.setName("Zombie2");
        assertEquals("Zombie2", patientZombie.getName());
    }

    @Test
    public void isMaleTest() {
        assertTrue(patientZombie.isMale());
    }

    @Test
    public void setMaleTest(){
        patientZombie.setMale(false);
        assertFalse(patientZombie.isMale());
    }

    @Test
    public void getAgeTest() {
        assertEquals(28, patientZombie.getAge());
    }

    @Test
    public void setAgeTest(){
        patientZombie.setAge(30);
        assertEquals(30, patientZombie.getAge());
    }

    @Test
    public void getWeightTest() {
        assertEquals(104, patientZombie.getWeight());
    }

    @Test
    public void getHeightTest() {
        assertEquals(220, patientZombie.getHeight());
    }

    @Test
    public void setWeightTest(){
        patientZombie.setWeight(100);
        assertEquals(100, patientZombie.getWeight());
    }

    @Test
    public void setHeightTest(){
        patientZombie.setHeight(200);
        assertEquals(200, patientZombie.getHeight());
    }

    @Test
    public void getMoraleTest() {
        assertEquals(100, patientZombie.getMorale());
    }

    @Test
    public void setMoraleTest(){
        patientZombie.setMorale(50);
        assertEquals(50, patientZombie.getMorale());
    }
    @Test
    public void addIllnessTest(){
        Illness illness = new Illness(Illnesses.DRS);
        patientZombie.addIllness(illness);
        assertEquals(1, patientZombie.getIllnesses().size());
        assertTrue(patientZombie.getIllnesses().contains(illness));
    }

    @Test
    public void getIllnessesTest(){
        Illness illness1 = new Illness(Illnesses.DRS);
        Illness illness2 = new Illness(Illnesses.MDC);
        patientZombie.addIllness(illness1);
        patientZombie.addIllness(illness2);
        Set<Illness> expectedIllnesses = new HashSet<>();
        expectedIllnesses.add(illness1);
        expectedIllnesses.add(illness2);
        assertEquals(expectedIllnesses, patientZombie.getIllnesses());
    }

    @Test
    public void setIllnessesTest(){
        Illness illness1 = new Illness(Illnesses.DRS);
        Illness illness2 = new Illness(Illnesses.MDC);
        Set<Illness> listIllnesses = new HashSet<>();
        listIllnesses.add(illness1);
        listIllnesses.add(illness2);
        patientZombie.setIllnesses(listIllnesses);
        assertTrue(patientZombie.getIllnesses().contains(illness1));
        assertTrue(patientZombie.getIllnesses().contains(illness2));

    }


    @Test
    public void removeIllnessTest(){
        Illness illness = new Illness(Illnesses.DRS);
        patientZombie.addIllness(illness);
        assertTrue(patientZombie.getIllnesses().contains(illness));
        patientZombie.removeIllness(illness);
        assertEquals(0, patientZombie.getIllnesses().size());
    }

    @Test
    public void screamTest(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        patientZombie.scream();
        assertEquals("Zombie screams...\n", outputStream.toString());
    }

    @Test
    public void waitATimeTest(){
        Service service = new Service("Service", 100, 10, 1500);
        service.addPatient(patientZombie);
        patientZombie.waitATime();
        assertEquals(98, patientZombie.getMorale());
    }

    @Test
    public void passAwayTest(){
        Service service = new Service("Service", 100, 10, 1500);
        service.addPatient(patientZombie);
        patientZombie.passAway();
        assertFalse(patientZombie.getIsAlive());
    }

    @Test
    public void agoniseTest(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        patientZombie.setMorale(Patient.MORALE_MIN);
        patientZombie.agonise();
        assertEquals("""
                Zombie is agonising
                Zombie screams...
                Zombie screams...
                Zombie screams...
                Zombie screams...
                Zombie screams...
                """, outputStream.toString());
    }

    @Test
    public void reviveTest(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Service service = new Service("Service", 100, 10, 1500);
        service.addPatient(patientZombie);
        patientZombie.passAway();
        assertFalse(patientZombie.getIsAlive());
        assertEquals(0, service.getPatients().size());
        System.setOut(new PrintStream(outputStream));
        patientZombie.revive();
        assertEquals("""
                Zombie revives...
                Zombie has been added to the Service.
                """, outputStream.toString());
        assertTrue(patientZombie.getIsAlive());
        assertEquals(1, service.getPatients().size());
    }
    @Test
    public void compareMoraleTest(){
        PatientZombie patientZombie2 = new PatientZombie("Zombie2", true, 28, 104,220);
        patientZombie.setMorale(50);
        patientZombie2.setMorale(100);
        assertFalse(patientZombie.compareMorale(patientZombie2));
    }

    @Test
    public void getIllnessesLvlSumTest() {
        Illness illness1 = new Illness(Illnesses.DRS);
        Illness illness2 = new Illness(Illnesses.MDC);
        patientZombie.addIllness(illness1);
        patientZombie.addIllness(illness2);
        assertEquals(0, patientZombie.getIllnessesLvlSum());
    }
    @Test
    public void compareIllnessLevelTest(){
        PatientZombie patientZombie2 = new PatientZombie("Zombie2", true, 28, 104,220);
        Illness illness1 = new Illness(Illnesses.DRS);
        Illness illness2 = new Illness(Illnesses.MDC);
        illness2.setLvl(4);
        patientZombie.addIllness(illness1);
        patientZombie2.addIllness(illness2);
        assertFalse(patientZombie.compareIllnessLevel(patientZombie2));
    }
    @Test
    public void compareMoraleAndIllnessLevelTest()
    {
        PatientZombie patientZombie2 = new PatientZombie("Zombie2", true, 28, 104,220);
        Illness illness1 = new Illness(Illnesses.DRS);
        Illness illness2 = new Illness(Illnesses.MDC);
        patientZombie.addIllness(illness1);
        illness1.setLvl(4);
        patientZombie.setMorale(100);
        patientZombie2.addIllness(illness2);
        patientZombie2.setMorale(50);
        assertTrue(patientZombie.compareMoraleAndIllnessLevel(patientZombie2));
    }
    
    @Test
    public void toStringTest(){
        assertEquals("PatientZombie{name='Zombie', isMale=true, weight=104.0, height=220.0, age=28}", patientZombie.toString());
    }
}
