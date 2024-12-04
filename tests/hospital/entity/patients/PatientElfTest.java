package hospital.entity.patients;

import hospital.entity.Patient;
import hospital.entity.patient.PatientElf;
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
    public void addIllnessTest(){
        Illness illness = new Illness(Illnesses.DRS);
        patientElf.addIllness(illness);
        assertEquals(1, patientElf.getIllnesses().size());
        assertTrue(patientElf.getIllnesses().contains(illness));
    }

    @Test
    public void getIllnessesTest(){
        Illness illness1 = new Illness(Illnesses.DRS);
        Illness illness2 = new Illness(Illnesses.MDC);
        patientElf.addIllness(illness1);
        patientElf.addIllness(illness2);
        Set<Illness> expectedIllnesses = new HashSet<>();
        expectedIllnesses.add(illness1);
        expectedIllnesses.add(illness2);
        assertEquals(expectedIllnesses, patientElf.getIllnesses());
    }

    @Test
    public void setIllnessesTest(){
        Illness illness1 = new Illness(Illnesses.DRS);
        Illness illness2 = new Illness(Illnesses.MDC);
        Set<Illness> listIllnesses = new HashSet<>();
        listIllnesses.add(illness1);
        listIllnesses.add(illness2);
        patientElf.setIllnesses(listIllnesses);
        assertTrue(patientElf.getIllnesses().contains(illness1));
        assertTrue(patientElf.getIllnesses().contains(illness2));

    }


    @Test
    public void removeIllnessTest(){
        Illness illness = new Illness(Illnesses.DRS);
        patientElf.addIllness(illness);
        assertTrue(patientElf.getIllnesses().contains(illness));
        patientElf.removeIllness(illness);
        assertEquals(0, patientElf.getIllnesses().size());
    }

    @Test
    public void screamTest(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        patientElf.scream();
        assertEquals("Elf screams...\n", outputStream.toString());
    }

    @Test
    public void waitATimeTest(){
        patientElf.waitATime();
        assertEquals(96, patientElf.getMorale());
    }

    @Test
    public void passAwayTest(){
        Service service = new Service("Service", 100, 10, 1500);
        service.addPatient(patientElf);
        patientElf.passAway();
        assertFalse(patientElf.getIsAlive());
    }

    @Test
    public void agoniseTest(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        patientElf.setMorale(Patient.MORALE_MIN);
        patientElf.agonise();
        assertEquals("""
                Elf is agonising
                Elf screams...
                Elf screams...
                Elf screams...
                Elf screams...
                Elf screams...
                """, outputStream.toString());
    }

    @Test
    public void demoralizeTest(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PatientElf patientElf2 = new PatientElf("Elf2", true, 28, 104,220);
        PatientElf patientElf3 = new PatientElf("Elf3", true, 28, 104,220);
        Service service = new Service("Service", 100, 10, 1500);
        service.addPatient(patientElf);
        service.addPatient(patientElf2);
        service.addPatient(patientElf3);
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
        patientElf.demoralize(predictableRandom);
        assertEquals("""
                Elf demoralize Elf2
                Elf demoralize Elf3
                """, outputStream.toString());
    }
    @Test
    public void compareMoraleTest(){
        PatientElf patientElf2 = new PatientElf("Elf2", true, 28, 104,220);
        patientElf.setMorale(50);
        patientElf2.setMorale(100);
        assertFalse(patientElf.compareMorale(patientElf2));
    }

    @Test
    public void getIllnessesLvlSumTest() {
        Illness illness1 = new Illness(Illnesses.DRS);
        Illness illness2 = new Illness(Illnesses.MDC);
        patientElf.addIllness(illness1);
        patientElf.addIllness(illness2);
        assertEquals(0, patientElf.getIllnessesLvlSum());
    }
    @Test
    public void compareIllnessLevelTest(){
        PatientElf patientElf2 = new PatientElf("Elf2", true, 28, 104,220);
        Illness illness1 = new Illness(Illnesses.DRS);
        Illness illness2 = new Illness(Illnesses.MDC);
        illness2.setLvl(4);
        patientElf.addIllness(illness1);
        patientElf2.addIllness(illness2);
        assertFalse(patientElf.compareIllnessLevel(patientElf2));
    }
    @Test
    public void compareMoraleAndIllnessLevelTest()
    {
        PatientElf patientElf2 = new PatientElf("Elf2", true, 28, 104,220);
        Illness illness1 = new Illness(Illnesses.DRS);
        Illness illness2 = new Illness(Illnesses.MDC);
        patientElf.addIllness(illness1);
        illness1.setLvl(4);
        patientElf.setMorale(100);
        patientElf2.addIllness(illness2);
        patientElf2.setMorale(50);
        assertTrue(patientElf.compareMoraleAndIllnessLevel(patientElf2));
    }

    @Test
    public void toStringTest(){
        assertEquals("PatientElf{name='Elf', isMale=true, weight=104.0, height=220.0, age=28}", patientElf.toString());
    }
}
