package hospital.entity.patients;

import hospital.entity.Patient;
import hospital.entity.patient.PatientDwarf;
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
    public void addIllnessTest(){
        Illness illness = new Illness(Illnesses.DRS);
        patientDwarf.addIllness(illness);
        assertEquals(1, patientDwarf.getIllnesses().size());
        assertTrue(patientDwarf.getIllnesses().contains(illness));
    }

    @Test
    public void getIllnessesTest(){
        Illness illness1 = new Illness(Illnesses.DRS);
        Illness illness2 = new Illness(Illnesses.MDC);
        patientDwarf.addIllness(illness1);
        patientDwarf.addIllness(illness2);
        Set<Illness> expectedIllnesses = new HashSet<>();
        expectedIllnesses.add(illness1);
        expectedIllnesses.add(illness2);
        assertEquals(expectedIllnesses, patientDwarf.getIllnesses());
    }

    @Test
    public void setIllnessesTest(){
        Illness illness1 = new Illness(Illnesses.DRS);
        Illness illness2 = new Illness(Illnesses.MDC);
        Set<Illness> listIllnesses = new HashSet<>();
        listIllnesses.add(illness1);
        listIllnesses.add(illness2);
        patientDwarf.setIllnesses(listIllnesses);
        assertTrue(patientDwarf.getIllnesses().contains(illness1));
        assertTrue(patientDwarf.getIllnesses().contains(illness2));

    }


    @Test
    public void removeIllnessTest(){
        Illness illness = new Illness(Illnesses.DRS);
        patientDwarf.addIllness(illness);
        assertTrue(patientDwarf.getIllnesses().contains(illness));
        patientDwarf.removeIllness(illness);
        assertEquals(0, patientDwarf.getIllnesses().size());
    }

    @Test
    public void screamTest(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        patientDwarf.scream();
        assertEquals("Dwarf screams...\n", outputStream.toString());
    }

    @Test
    public void waitATimeTest(){
        patientDwarf.waitATime();
        assertEquals(96, patientDwarf.getMorale());
    }

    @Test
    public void passAwayTest(){
        Service service = new Service("Service", 100, 10, 1500);
        service.addPatient(patientDwarf);
        patientDwarf.passAway();
        assertFalse(patientDwarf.getIsAlive());
    }

    @Test
    public void agoniseTest(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        patientDwarf.setMorale(Patient.MORALE_MIN);
        patientDwarf.agonise();
        assertEquals("""
                Dwarf is agonising
                Dwarf screams...
                Dwarf screams...
                Dwarf screams...
                Dwarf screams...
                Dwarf screams...
                """, outputStream.toString());
    }
    @Test
    public void compareMoraleTest(){
        PatientDwarf patientDwarf2 = new PatientDwarf("Dwarf2", true, 28, 104,220);
        patientDwarf.setMorale(50);
        patientDwarf2.setMorale(100);
        assertFalse(patientDwarf.compareMorale(patientDwarf2));
    }

    @Test
    public void getIllnessesLvlSumTest() {
        Illness illness1 = new Illness(Illnesses.DRS);
        Illness illness2 = new Illness(Illnesses.MDC);
        patientDwarf.addIllness(illness1);
        patientDwarf.addIllness(illness2);
        assertEquals(0, patientDwarf.getIllnessesLvlSum());
    }
    @Test
    public void compareIllnessLevelTest(){
        PatientDwarf patientDwarf2 = new PatientDwarf("Dwarf2", true, 28, 104,220);
        Illness illness1 = new Illness(Illnesses.DRS);
        Illness illness2 = new Illness(Illnesses.MDC);
        illness2.setLvl(4);
        patientDwarf.addIllness(illness1);
        patientDwarf2.addIllness(illness2);
        assertFalse(patientDwarf.compareIllnessLevel(patientDwarf2));
    }
    @Test
    public void compareMoraleAndIllnessLevelTest()
    {
        PatientDwarf patientDwarf2 = new PatientDwarf("Dwarf2", true, 28, 104,220);
        Illness illness1 = new Illness(Illnesses.DRS);
        Illness illness2 = new Illness(Illnesses.MDC);
        patientDwarf.addIllness(illness1);
        illness1.setLvl(4);
        patientDwarf.setMorale(100);
        patientDwarf2.addIllness(illness2);
        patientDwarf2.setMorale(50);
        assertTrue(patientDwarf.compareMoraleAndIllnessLevel(patientDwarf2));
    }

    @Test
    public void toStringTest(){
        assertEquals("PatientDwarf{name='Dwarf', isMale=true, weight=80.0, height=140.0, age=10}", patientDwarf.toString());
    }
}
