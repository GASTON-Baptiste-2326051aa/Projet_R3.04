package services;

import hospital.entity.Creature;
import hospital.entity.patient.PatientDwarf;
import hospital.entity.patient.PatientElf;
import hospital.entity.patient.PatientVampire;
import hospital.entity.patient.PatientZombie;
import hospital.services.Crypt;
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
        assertEquals("Crypt{name=Crypt, surface=10.0, creatureMax=10, creatureNow=0, budget=poor, ventilationLevel=5, temperature=20.0}", crypt.toString());
        }
    @Test
    public void getNameTest() {
        assertEquals("Crypt", crypt.getName());
    }
    @Test
    public void getSurfaceTest() {
        assertEquals(10, crypt.getSurface());
    }
    @Test
    public void getCreatureMaxTest() {
        assertEquals(10, crypt.getCreatureMax());
    }
    @Test
    public void getCreatureNowTest() {
        assertEquals(0, crypt.getCreatureNow());
    }

    @Test
    public void addCreatureTest() {
        PatientVampire Baptiste = new PatientVampire("Baptiste", true, 19, 77, 180);
        crypt.addCreature(Baptiste);
        assertEquals(1, crypt.getCreatureNow());
        PatientElf Estelle = new PatientElf("Estelle",false, 21, 54, 165);
        assertThrows(IllegalArgumentException.class, () -> crypt.addCreature(Estelle));
    }

    @Test
    public void removeCreatureTest() {
        PatientVampire Baptiste = new PatientVampire("Baptiste", true, 19, 77, 180);
        crypt.addCreature(Baptiste);
        crypt.removeCreature(Baptiste);
        assertEquals(0, crypt.getCreatureNow());
        assertThrows(IllegalArgumentException.class, () -> crypt.removeCreature(Baptiste));
    }

    @Test
    public void getCreaturesTest() {
        PatientZombie Cyril = new PatientZombie("Cyril", false, 19, 73, 175);
        crypt.addCreature(Cyril);
        assertEquals(1, crypt.getCreatures().size());
        assertTrue(crypt.getCreatures().contains(Cyril));

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
    public void setCreatureNowTest() {
        PatientVampire Baptiste = new PatientVampire("Baptiste", true, 19, 77, 180);
        PatientVampire Mariam = new PatientVampire("Mariam", false, 19, 53, 160);
        crypt.addCreature(Baptiste);
        crypt.addCreature(Mariam);
        crypt.setCreatureNow();
        assertEquals(2, crypt.getCreatureNow());

    }
    @Test
    public void setCreaturesTest() {
        Collection<Creature> creatures = new ArrayList<>();
        PatientVampire Baptiste = new PatientVampire("Baptiste", true, 19, 77, 180);
        creatures.add(Baptiste);
        crypt.setCreatures(creatures);
        assertEquals(1, crypt.getCreatures().size());

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
        crypt.addCreature(Baptiste);
        crypt.addCreature(Dracula);
        crypt.addCreature(Selene);
        crypt.addCreature(Vlad);
        crypt.addCreature(Carmilla);
        crypt.addCreature(Lestat);
        crypt.addCreature(Akasha);
        crypt.addCreature(Blade);
        crypt.addCreature(Marcus);
        crypt.addCreature(Victoria);
        assertTrue(crypt.isFull());
    }
    @Test
    public void isCreatureInsideTest() {
        PatientVampire Baptiste = new PatientVampire("Baptiste", true, 19, 77, 180);        crypt.addCreature(Baptiste);
        assertTrue(crypt.isCreatureInService(Baptiste));
    }
}
