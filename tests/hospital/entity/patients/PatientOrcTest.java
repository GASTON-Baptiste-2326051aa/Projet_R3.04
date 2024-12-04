package hospital.entity.patients;

import hospital.entity.Patient;
import hospital.entity.patient.PatientOrc;
import hospital.illness.Illness;
import hospital.illness.Illnesses;
import hospital.services.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static hospital.illness.Illnesses.getRandomIllness;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatientOrcTest {

    private PatientOrc patientOrc ;
    @BeforeEach
    public void setUp() {
        patientOrc = new PatientOrc("Orc", true, 28, 104,220);
    }

    @Test
    public void getNameTest() {
        assertEquals("Orc", patientOrc.getName());
    }

    @Test
    public void setNameTest(){
        patientOrc.setName("Orc2");
        assertEquals("Orc2", patientOrc.getName());
    }

    @Test
    public void isMaleTest() {
        assertTrue(patientOrc.isMale());
    }

    @Test
    public void setMaleTest(){
        patientOrc.setMale(false);
        assertFalse(patientOrc.isMale());
    }

    @Test
    public void getAgeTest() {
        assertEquals(28, patientOrc.getAge());
    }

    @Test
    public void setAgeTest(){
        patientOrc.setAge(30);
        assertEquals(30, patientOrc.getAge());
    }

    @Test
    public void getWeightTest() {
        assertEquals(104, patientOrc.getWeight());
    }

    @Test
    public void getHeightTest() {
        assertEquals(220, patientOrc.getHeight());
    }

    @Test
    public void setWeightTest(){
        patientOrc.setWeight(100);
        assertEquals(100, patientOrc.getWeight());
    }

    @Test
    public void setHeightTest(){
        patientOrc.setHeight(200);
        assertEquals(200, patientOrc.getHeight());
    }

    @Test
    public void getMoraleTest() {
        assertEquals(100, patientOrc.getMorale());
    }

    @Test
    public void setMoraleTest(){
        patientOrc.setMorale(50);
        assertEquals(50, patientOrc.getMorale());
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
        System.setOut(new PrintStream(outputStream));
        patientOrc.scream();
        assertEquals("Orc screams...\n", outputStream.toString());
    }

    @Test
    public void waitATimeTest(){
        Service service = new Service("Service", 100, 10, 1500);
        service.addPatient(patientOrc);
        patientOrc.waitATime();
        assertEquals(98, patientOrc.getMorale());
    }

    @Test
    public void passAwayTest(){
        Service service = new Service("Service", 100, 10, 1500);
        service.addPatient(patientOrc);
        patientOrc.passAway();
        assertFalse(patientOrc.getIsAlive());
    }

    @Test
    public void agoniseTest(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        patientOrc.setMorale(Patient.MORALE_MIN);
        patientOrc.agonise();
        assertEquals("""
                Orc is agonising
                Orc screams...
                Orc screams...
                Orc screams...
                Orc screams...
                Orc screams...
                """, outputStream.toString());
    }

    @Test
    public void contaminateTest(){
        Service service = new Service("Service", 100, 10, 1500);
        PatientOrc patientOrc2 = new PatientOrc("Orc2", true, 28, 104,220);
        service.addPatient(patientOrc);
        service.addPatient(patientOrc2);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        assertThrows(IllegalStateException.class, () -> patientOrc.contaminate());
        patientOrc.addIllness(getRandomIllness());
        patientOrc.contaminate();
        assertEquals("Orc contaminates Orc2...\n", outputStream.toString());

    }
    @Test
    public void compareMoraleTest(){
        PatientOrc patientOrc2 = new PatientOrc("Orc2", true, 28, 104,220);
        patientOrc.setMorale(50);
        patientOrc2.setMorale(100);
        assertFalse(patientOrc.compareMorale(patientOrc2));
    }

    @Test
    public void getIllnessesLvlSumTest() {
        Illness illness1 = new Illness(Illnesses.DRS);
        Illness illness2 = new Illness(Illnesses.MDC);
        patientOrc.addIllness(illness1);
        patientOrc.addIllness(illness2);
        assertEquals(0, patientOrc.getIllnessesLvlSum());
    }
    @Test
    public void compareIllnessLevelTest(){
        PatientOrc patientOrc2 = new PatientOrc("Orc2", true, 28, 104,220);
        Illness illness1 = new Illness(Illnesses.DRS);
        Illness illness2 = new Illness(Illnesses.MDC);
        illness2.setLvl(4);
        patientOrc.addIllness(illness1);
        patientOrc2.addIllness(illness2);
        assertFalse(patientOrc.compareIllnessLevel(patientOrc2));
    }
    @Test
    public void compareMoraleAndIllnessLevelTest()
    {
        PatientOrc patientOrc2 = new PatientOrc("Orc2", true, 28, 104,220);
        Illness illness1 = new Illness(Illnesses.DRS);
        Illness illness2 = new Illness(Illnesses.MDC);
        patientOrc.addIllness(illness1);
        illness1.setLvl(4);
        patientOrc.setMorale(100);
        patientOrc2.addIllness(illness2);
        patientOrc2.setMorale(50);
        assertTrue(patientOrc.compareMoraleAndIllnessLevel(patientOrc2));
    }

    @Test
    public void toStringTest(){
        assertEquals("PatientOrc{name='Orc', isMale=true, weight=104.0, height=220.0, age=28}", patientOrc.toString());
    }
}
