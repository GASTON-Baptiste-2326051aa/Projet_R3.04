package hospital.services;

import hospital.entity.Patient;
import hospital.entity.patient.PatientDwarf;
import hospital.entity.patient.PatientElf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceTest {

    private Service service;

    @BeforeEach
    public void setUp() {
        service = new Service("Service", 10, 10, 1);
    }

    @Test
    public void toStringTest() {
        assertEquals("Service{name='Service', surface=10.0, patientMax=10, patientNow=0, patients=[], budget=poor}", service.toString());
    }
    @Test
    public void getNameTest() {
        assertEquals("Service", service.getServiceName());
    }
    @Test
    public void getSurfaceTest() {
        assertEquals(10, service.getSurface());
    }
    @Test
    public void getPatientMaxTest() {
        assertEquals(10, service.getPatientMax());
    }
    @Test
    public void getPatientNowTest() {
        assertEquals(0, service.getPatientNow());
    }

    @Test
    public void addPatientTest() {
        PatientDwarf yousra = new PatientDwarf("Yousra",false, 19, 47, 153);
        service.addPatient(yousra);
        assertEquals(1, service.getPatientNow());
        PatientElf  Estelle = new PatientElf("Estelle",false, 21, 54, 165);
        assertThrows(IllegalArgumentException.class, () -> service.addPatient(Estelle));
    }

    @Test
    public void removePatientTest() {
        PatientDwarf yousra = new PatientDwarf("Yousra",false, 19, 47, 153);
        service.addPatient(yousra);
        service.removePatient(yousra);
        assertEquals(0, service.getPatientNow());
        assertThrows(IllegalArgumentException.class, () -> service.removePatient(yousra));
    }

    @Test
    public void getPatientsTest() {
        PatientDwarf yousra = new PatientDwarf("Yousra",false, 19, 47, 153);
        service.addPatient(yousra);
        assertEquals(1, service.getPatients().size());
        assertTrue(service.getPatients().contains(yousra));

    }
    @Test
    public void getBudgetTest() {
        assertEquals(1, service.getBudget());
    }
    @Test
    public void setNameTest() {
        service.setName("Service2");
        assertEquals("Service2", service.getName());
    }
    @Test
    public void setSurfaceTest() {
        service.setSurface(20);
        assertEquals(20, service.getSurface());
    }
    @Test
    public void setPatientNowTest() {
        PatientElf Estelle = new PatientElf("Estelle",false, 21, 54, 165);
        PatientElf Mariam = new PatientElf("Mariam",false, 19, 53, 160);
        service.addPatient(Estelle);
        service.addPatient(Mariam);
        service.setPatientNow();
        assertEquals(2, service.getPatientNow());

    }
    @Test
    public void setPatientsTest() {
        Collection<Patient> patients = new ArrayList<>();
        PatientDwarf yousra = new PatientDwarf("Yousra",false, 19, 47, 153);
        patients.add(yousra);
        service.setPatients(patients);
        assertEquals(1, service.getPatients().size());

    }
    @Test
    public void setBudgetTest() {
        service.setBudget(2);
        assertEquals(2, service.getBudget());
    }

    @Test
    public void isFullTest() {
        PatientElf elf1 = new PatientElf("Estelle", false, 21, 54, 165);
        PatientElf elf2 = new PatientElf("Alaric", true, 25, 62, 170);
        PatientElf elf3 = new PatientElf("Elara", false, 19, 50, 160);
        PatientElf elf4 = new PatientElf("Theron", true, 30, 68, 180);
        PatientElf elf5 = new PatientElf("Lorien", true, 28, 60, 175);
        PatientElf elf6 = new PatientElf("Celia", false, 23, 55, 162);
        PatientElf elf7 = new PatientElf("Faylin", true, 27, 64, 178);
        PatientElf elf8 = new PatientElf("Selene", false, 22, 52, 168);
        PatientElf elf9 = new PatientElf("Kael", true, 24, 63, 172);
        PatientElf elf10 = new PatientElf("Aria", false, 26, 58, 169);
        service.addPatient(elf1);
        service.addPatient(elf2);
        service.addPatient(elf3);
        service.addPatient(elf4);
        service.addPatient(elf5);
        service.addPatient(elf6);
        service.addPatient(elf7);
        service.addPatient(elf8);
        service.addPatient(elf9);
        service.addPatient(elf10);
        assertTrue(service.isFull());
    }
    @Test
    public void isPatientInsideTest() {
        PatientDwarf yousra = new PatientDwarf("Yousra",false, 19, 47, 153);
        service.addPatient(yousra);
        assertTrue(service.isPatientInService(yousra));
    }


}
