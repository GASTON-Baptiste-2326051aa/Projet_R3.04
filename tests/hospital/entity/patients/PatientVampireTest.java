package hospital.entity.patients;

import hospital.entity.Patient;
import hospital.entity.patient.PatientVampire;
import hospital.illness.Illness;
import hospital.illness.Illnesses;
import hospital.services.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static hospital.illness.Illnesses.getRandomIllness;
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
    public void addIllnessTest(){
        Illness illness = new Illness(Illnesses.DRS);
        patientVampire.addIllness(illness);
        assertEquals(1, patientVampire.getIllnesses().size());
        assertTrue(patientVampire.getIllnesses().contains(illness));
    }

    @Test
    public void getIllnessesTest(){
        Illness illness1 = new Illness(Illnesses.DRS);
        Illness illness2 = new Illness(Illnesses.MDC);
        patientVampire.addIllness(illness1);
        patientVampire.addIllness(illness2);
        Set<Illness> expectedIllnesses = new HashSet<>();
        expectedIllnesses.add(illness1);
        expectedIllnesses.add(illness2);
        assertEquals(expectedIllnesses, patientVampire.getIllnesses());
    }

    @Test
    public void setIllnessesTest(){
        Illness illness1 = new Illness(Illnesses.DRS);
        Illness illness2 = new Illness(Illnesses.MDC);
        Set<Illness> listIllnesses = new HashSet<>();
        listIllnesses.add(illness1);
        listIllnesses.add(illness2);
        patientVampire.setIllnesses(listIllnesses);
        assertTrue(patientVampire.getIllnesses().contains(illness1));
        assertTrue(patientVampire.getIllnesses().contains(illness2));

    }


    @Test
    public void removeIllnessTest(){
        Illness illness = new Illness(Illnesses.DRS);
        patientVampire.addIllness(illness);
        assertTrue(patientVampire.getIllnesses().contains(illness));
        patientVampire.removeIllness(illness);
        assertEquals(0, patientVampire.getIllnesses().size());
    }

    @Test
    public void screamTest(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // Sauvegarde de l'original
        System.setOut(new PrintStream(outputStream));
        patientVampire.scream();
        //assertEquals("The patient Vampire is screaming.\n", outputStream.toString());
    }

    @Test
    public void waitATimeTest(){
        patientVampire.waitATime();
        assertEquals(96, patientVampire.getMorale());
    }

    @Test
    public void passAwayTest(){
        Service service = new Service("Service", 100, 10, 1500);
        service.addPatient(patientVampire);
        patientVampire.passAway();
        assertFalse(patientVampire.getIsAlive());
    }

    @Test
    public void agoniseTest(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        patientVampire.setMorale(Patient.MORALE_MIN);
        patientVampire.agonise();
        assertEquals("""
                Vampire is agonising
                Vampire screams...
                Vampire screams...
                Vampire screams...
                Vampire screams...
                Vampire screams...
                """, outputStream.toString());
    }

    @Test
    public void contaminateTest(){
        Service service = new Service("Service", 100, 10, 1500);
        PatientVampire patientVampire2 = new PatientVampire("Vampire2", true, 28, 104,220);
        service.addPatient(patientVampire);
        service.addPatient(patientVampire2);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        assertThrows(IllegalStateException.class, () -> patientVampire.contaminate());
        patientVampire.addIllness(getRandomIllness());
        patientVampire.contaminate();
        assertEquals("Vampire contaminates Vampire2...\n", outputStream.toString());

    }

    @Test
    public void demoralizeTest(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PatientVampire patientVampire2 = new PatientVampire("Vampire2", true, 28, 104,220);
        PatientVampire patientVampire3 = new PatientVampire("Vampire3", true, 28, 104,220);
        Service service = new Service("Service", 100, 10, 1500);
        service.addPatient(patientVampire);
        service.addPatient(patientVampire2);
        service.addPatient(patientVampire3);
        System.setOut(new PrintStream(outputStream));
        //Create predictable random
        Random predictableRandom = new Random() {
            private final int[] predefinedValues = {20, 15, 20};
            private int index = 0;
            @Override
            public int nextInt(int bound) {
                return predefinedValues[index++ % predefinedValues.length];
            }
        };
        patientVampire.demoralize(predictableRandom);
        assertEquals("""
                Vampire demoralize Vampire2
                Vampire demoralize Vampire3
                """, outputStream.toString());
    }

    @Test
    public void reviveTest(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Service service = new Service("Service", 100, 10, 1500);
        service.addPatient(patientVampire);
        patientVampire.passAway();
        assertFalse(patientVampire.getIsAlive());
        assertEquals(0, service.getPatients().size());
        System.setOut(new PrintStream(outputStream));
        patientVampire.revive();
        assertEquals("""
                Vampire revives...
                Vampire has been added to the Service.
                """, outputStream.toString());
        assertTrue(patientVampire.getIsAlive());
        assertEquals(1, service.getPatients().size());



    }
    @Test
    public void compareMoraleTest(){
        PatientVampire patientVampire2 = new PatientVampire("Vampire2", true, 28, 104,220);
        patientVampire.setMorale(50);
        patientVampire2.setMorale(100);
        assertFalse(patientVampire.compareMorale(patientVampire2));
    }

    @Test
    public void getIllnessesLvlSumTest() {
        Illness illness1 = new Illness(Illnesses.DRS);
        Illness illness2 = new Illness(Illnesses.MDC);
        patientVampire.addIllness(illness1);
        patientVampire.addIllness(illness2);
        assertEquals(0, patientVampire.getIllnessesLvlSum());
    }
    @Test
    public void compareIllnessLevelTest(){
        PatientVampire patientVampire2 = new PatientVampire("Vampire2", true, 28, 104,220);
        Illness illness1 = new Illness(Illnesses.DRS);
        Illness illness2 = new Illness(Illnesses.MDC);
        illness2.setLvl(4);
        patientVampire.addIllness(illness1);
        patientVampire2.addIllness(illness2);
        assertFalse(patientVampire.compareIllnessLevel(patientVampire2));
    }
    @Test
    public void compareMoraleAndIllnessLevelTest()
    {
        PatientVampire patientVampire2 = new PatientVampire("Vampire2", true, 28, 104,220);
        Illness illness1 = new Illness(Illnesses.DRS);
        Illness illness2 = new Illness(Illnesses.MDC);
        patientVampire.addIllness(illness1);
        illness1.setLvl(4);
        patientVampire.setMorale(100);
        patientVampire2.addIllness(illness2);
        patientVampire2.setMorale(50);
        assertTrue(patientVampire.compareMoraleAndIllnessLevel(patientVampire2));
    }

    @Test
    public void toStringTest(){
        assertEquals("PatientVampire{name='Vampire', isMale=true, weight=104.0, height=220.0, age=28}", patientVampire.toString());
    }
}
