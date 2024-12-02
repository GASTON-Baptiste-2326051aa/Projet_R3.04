package hospital.services;

import hospital.Hospital;
import hospital.entity.PatientCollection;
import hospital.entity.patient.PatientElf;
import hospital.entity.patient.PatientVampire;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuarantineCenterTest {

    private Hospital hospital;
    private QuarantineCenter center;

    @BeforeEach
    public void setUp() {
        hospital = new Hospital("hospital");
        center = new QuarantineCenter("center", 10, 10, 1, hospital);
    }

    @Test
    public void toStringTest() {
        assertEquals("QuarantineCenter{name=center, surface=10.0, creatureMax=10, creatureNow=0, budget=poor, isolation=false}", center.toString());
    }
    @Test
    public void getNameTest() {
        assertEquals("center", center.getName());
    }
    @Test
    public void getSurfaceTest() {
        assertEquals(10, center.getSurface());
    }
    @Test
    public void getCreatureMaxTest() {
        assertEquals(10, center.getCreatureMax());
    }
    @Test
    public void getCreatureNowTest() {
        assertEquals(0, center.getCreatureNow());
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
    public void addCreatureTest() {
        PatientVampire Baptiste = new PatientVampire("Baptiste", true, 19, 77, 180);
        center.addCreature(Baptiste);
        assertEquals(1, center.getCreatureNow());
        PatientElf Estelle = new PatientElf("Estelle",false, 21, 54, 165);
        assertThrows(IllegalArgumentException.class, () -> center.addCreature(Estelle));
    }

    @Test
    public void removeCreatureTest() {
        PatientVampire Baptiste = new PatientVampire("Baptiste", true, 19, 77, 180);
        center.addCreature(Baptiste);
        center.removeCreature(Baptiste);
        assertEquals(0, center.getCreatureNow());
        assertThrows(IllegalArgumentException.class, () -> center.removeCreature(Baptiste));
    }

    @Test
    public void getCreaturesTest() {
        PatientVampire Baptiste = new PatientVampire("Baptiste", true, 19, 77, 180);
        center.addCreature(Baptiste);
        assertEquals(1, center.getCreatures().size());
        assertTrue(center.getCreatures().contains(Baptiste));

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
    public void setCreatureNowTest() {
        PatientVampire Baptiste = new PatientVampire("Baptiste", true, 19, 77, 180);
        PatientVampire Mariam = new PatientVampire("Mariam", false, 19, 53, 160);
        center.addCreature(Baptiste);
        center.addCreature(Mariam);
        center.setCreatureNow();
        assertEquals(2, center.getCreatureNow());

    }
    @Test
    public void setCreaturesTest() {
        PatientCollection creatures = new PatientCollection();
        PatientVampire Baptiste = new PatientVampire("Baptiste", true, 19, 77, 180);
        creatures.add(Baptiste);
        center.setCreatures(creatures);
        assertEquals(1, center.getCreatures().size());

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
        center.addCreature(Baptiste);
        center.addCreature(Dracula);
        center.addCreature(Selene);
        center.addCreature(Vlad);
        center.addCreature(Carmilla);
        center.addCreature(Lestat);
        center.addCreature(Akasha);
        center.addCreature(Blade);
        center.addCreature(Marcus);
        center.addCreature(Victoria);
        assertTrue(center.isFull());
    }
    @Test
    public void isCreatureInsideTest() {
        PatientVampire Baptiste = new PatientVampire("Baptiste", true, 19, 77, 180);        center.addCreature(Baptiste);
        assertTrue(center.isCreatureInService(Baptiste));
    }
}
