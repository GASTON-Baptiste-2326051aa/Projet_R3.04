package hospital.services;


import hospital.Hospital;
import hospital.entity.Patient;
import hospital.entity.patient.PatientElf;
import hospital.entity.patient.PatientVampire;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuarantineCenterTest {

    private Hospital hospital;
    private QuarantineCenter center;

    @BeforeEach
    public void setUp() {
        hospital = new Hospital("hospital", 10);
        center = new QuarantineCenter("center", 10, 10, 1, hospital);
    }

    @Test
    public void toStringTest() {
        assertEquals("QuarantineCenter{name=center, surface=10.0, patientMax=10, patientNow=0, budget=poor, isolation=false}", center.toString());
    }
    @Test
    public void getNameTest() {
        assertEquals("center", center.getServiceName());
    }
    @Test
    public void getSurfaceTest() {
        assertEquals(10, center.getSurface());
    }
    @Test
    public void getPatientMaxTest() {
        assertEquals(10, center.getPatientMax());
    }
    @Test
    public void getPatientNowTest() {
        assertEquals(0, center.getPatientNow());
    }

    @Test
    public void getIsolationTest() {
        assertFalse(center.isIsolate());
    }

    @Test
    public void setIsolationTest() {
        center.setIsolation(true);
        assertTrue(center.isIsolate());
    }
    @Test
    public void addPatientTest() {
        PatientVampire Baptiste = new PatientVampire("Baptiste", true, 19, 77, 180);
        center.addPatient(Baptiste);
        assertEquals(1, center.getPatientNow());
        PatientElf Estelle = new PatientElf("Estelle",false, 21, 54, 165);
        assertThrows(IllegalArgumentException.class, () -> center.addPatient(Estelle));
    }

    @Test
    public void removePatientTest() {
        PatientVampire Baptiste = new PatientVampire("Baptiste", true, 19, 77, 180);
        center.addPatient(Baptiste);
        center.removePatient(Baptiste);
        assertEquals(0, center.getPatientNow());
        assertThrows(IllegalArgumentException.class, () -> center.removePatient(Baptiste));
    }

    @Test
    public void getPatientsTest() {
        PatientVampire Baptiste = new PatientVampire("Baptiste", true, 19, 77, 180);
        center.addPatient(Baptiste);
        assertEquals(1, center.getPatients().size());
        assertTrue(center.getPatients().contains(Baptiste));

    }
    @Test
    public void getBudgetTest() {
        assertEquals(1, center.getBudget());
    }
    @Test
    public void setNameTest() {
        center.setName("center2");
        assertEquals("center2", center.getName());
    }
    @Test
    public void setSurfaceTest() {
        center.setSurface(20);
        assertEquals(20, center.getSurface());
    }
    @Test
    public void setPatientNowTest() {
        PatientVampire Baptiste = new PatientVampire("Baptiste", true, 19, 77, 180);
        PatientVampire Mariam = new PatientVampire("Mariam", false, 19, 53, 160);
        center.addPatient(Baptiste);
        center.addPatient(Mariam);
        center.setPatientNow();
        assertEquals(2, center.getPatientNow());

    }
    @Test
    public void setPatientsTest() {
        Collection<Patient> patients = new ArrayList<>();
        PatientVampire Baptiste = new PatientVampire("Baptiste", true, 19, 77, 180);
        patients.add(Baptiste);
        center.setPatients(patients);
        assertEquals(1, center.getPatients().size());

    }
    @Test
    public void setBudgetTest() {
        center.setBudget(2);
        assertEquals(2, center.getBudget());
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
        center.addPatient(Baptiste);
        center.addPatient(Dracula);
        center.addPatient(Selene);
        center.addPatient(Vlad);
        center.addPatient(Carmilla);
        center.addPatient(Lestat);
        center.addPatient(Akasha);
        center.addPatient(Blade);
        center.addPatient(Marcus);
        center.addPatient(Victoria);
        assertTrue(center.isFull());
    }
    @Test
    public void isPatientInsideTest() {
        PatientVampire Baptiste = new PatientVampire("Baptiste", true, 19, 77, 180);        center.addPatient(Baptiste);
        assertTrue(center.isPatientInService(Baptiste));
    }
}
