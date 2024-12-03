package hospital.services;


import hospital.entity.Patient;
import hospital.entity.patient.PatientElf;
import hospital.entity.patient.PatientVampire;
import hospital.entity.patient.PatientZombie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CryptTest {

    private Crypt crypt;

    @BeforeEach
    public void setUp() {
        crypt = new Crypt("Crypt", 10, 10, 1, 5, 20);
    }

    @Test
    public void toStringTest() {
        assertEquals("Crypt{name=Crypt, surface=10.0, patientMax=10, patientNow=0, budget=poor, ventilationLevel=5, temperature=20.0}", crypt.toString());
        }
    @Test
    public void getNameTest() {
        assertEquals("Crypt", crypt.getServiceName());
    }
    @Test
    public void getSurfaceTest() {
        assertEquals(10, crypt.getSurface());
    }
    @Test
    public void getPatientMaxTest() {
        assertEquals(10, crypt.getPatientMax());
    }
    @Test
    public void getPatientNowTest() {
        assertEquals(0, crypt.getPatientNow());
    }

    @Test
    public void addPatientTest() {
        PatientVampire Baptiste = new PatientVampire("Baptiste", true, 19, 77, 180);
        crypt.addPatient(Baptiste);
        assertEquals(1, crypt.getPatientNow());
        PatientElf Estelle = new PatientElf("Estelle",false, 21, 54, 165);
        assertThrows(IllegalArgumentException.class, () -> crypt.addPatient(Estelle));
    }

    @Test
    public void removePatientTest() {
        PatientVampire Baptiste = new PatientVampire("Baptiste", true, 19, 77, 180);
        crypt.addPatient(Baptiste);
        crypt.removePatient(Baptiste);
        assertEquals(0, crypt.getPatientNow());
        assertThrows(IllegalArgumentException.class, () -> crypt.removePatient(Baptiste));
    }

    @Test
    public void getPatientsTest() {
        PatientZombie Cyril = new PatientZombie("Cyril", false, 19, 73, 175);
        crypt.addPatient(Cyril);
        assertEquals(1, crypt.getPatients().size());
        assertTrue(crypt.getPatients().contains(Cyril));

    }
    @Test
    public void getBudgetTest() {
        assertEquals(1, crypt.getBudget());
    }
    @Test
    public void setNameTest() {
        crypt.setName("crypt2");
        assertEquals("crypt2", crypt.getName());
    }
    @Test
    public void setSurfaceTest() {
        crypt.setSurface(20);
        assertEquals(20, crypt.getSurface());
    }
    @Test
    public void setPatientNowTest() {
        PatientVampire Baptiste = new PatientVampire("Baptiste", true, 19, 77, 180);
        PatientVampire Mariam = new PatientVampire("Mariam", false, 19, 53, 160);
        crypt.addPatient(Baptiste);
        crypt.addPatient(Mariam);
        crypt.setPatientNow();
        assertEquals(2, crypt.getPatientNow());

    }
    @Test
    public void setPatientsTest() {
        Collection<Patient> patients = new ArrayList<>();
        PatientVampire Baptiste = new PatientVampire("Baptiste", true, 19, 77, 180);
        patients.add(Baptiste);
        crypt.setPatients(patients);
        assertEquals(1, crypt.getPatients().size());

    }
    @Test
    public void setBudgetTest() {
        crypt.setBudget(2);
        assertEquals(2, crypt.getBudget());
    }

    @Test
    public void setTemperatureTest() {
        crypt.setTemperature(25);
        assertEquals(25, crypt.getTemperature());
    }
    @Test
    public void getTemperatureTest() {
        assertEquals(20, crypt.getTemperature());
    }
    @Test
    public void getVentilationLevelTest() {
        assertEquals(5, crypt.getVentilationLevel());
    }
    @Test
    public void setVentilationLevelTest() {
        crypt.setVentilationLevel(7);
        assertEquals(7, crypt.getVentilationLevel());
    }

    @Test
    public void isFullTest() {
        PatientVampire Baptiste = new PatientVampire("Baptiste", true, 19, 77, 180);
        PatientVampire Dracula = new PatientVampire("Dracula", true, 100, 75, 190);
        PatientVampire Selene = new PatientVampire("Selene", false, 200, 60, 170);
        PatientVampire Vlad = new PatientVampire("Vlad", true, 45, 85, 185);
        PatientVampire Carmilla = new PatientVampire("Carmilla", false, 150, 65, 175);
        PatientVampire Lestat = new PatientVampire("Lestat", true, 250, 70, 180);
        PatientVampire Akasha = new PatientVampire("Akasha", false, 3000, 55, 165);
        PatientVampire Blade = new PatientVampire("Blade", true, 32, 90, 188);
        PatientVampire Marcus = new PatientVampire("Marcus", true, 500, 88, 190);
        PatientVampire Victoria = new PatientVampire("Victoria", false, 120, 50, 160);
        crypt.addPatient(Baptiste);
        crypt.addPatient(Dracula);
        crypt.addPatient(Selene);
        crypt.addPatient(Vlad);
        crypt.addPatient(Carmilla);
        crypt.addPatient(Lestat);
        crypt.addPatient(Akasha);
        crypt.addPatient(Blade);
        crypt.addPatient(Marcus);
        crypt.addPatient(Victoria);
        assertTrue(crypt.isFull());
    }
    @Test
    public void isPatientInsideTest() {
        PatientVampire Baptiste = new PatientVampire("Baptiste", true, 19, 77, 180);        crypt.addPatient(Baptiste);
        assertTrue(crypt.isPatientInService(Baptiste));
    }
}
