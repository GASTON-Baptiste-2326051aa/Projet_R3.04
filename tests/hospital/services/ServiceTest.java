package hospital.services;

import hospital.entity.PatientCollection;
import hospital.entity.patient.PatientDwarf;
import hospital.entity.patient.PatientElf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ServiceTest {

    private Service service;

    @BeforeEach
    public void setUp() {
        service = new Service("Service", 10, 10, 1);
    }

    @Test
    public void toStringTest() {
        assertEquals("Service{name='Service', surface=10.0, creatureMax=10, creatureNow=0, creatures=[], budget=poor}", service.toString());
    }
    @Test
    public void getNameTest() {
        assertEquals("Service", service.getName());
    }
    @Test
    public void getSurfaceTest() {
        assertEquals(10, service.getSurface());
    }
    @Test
    public void getCreatureMaxTest() {
        assertEquals(10, service.getCreatureMax());
    }
    @Test
    public void getCreatureNowTest() {
        assertEquals(0, service.getCreatureNow());
    }

    @Test
    public void addCreatureTest() {
        PatientDwarf yousra = new PatientDwarf("Yousra",false, 19, 47, 153);
        service.addCreature(yousra);
        assertEquals(1, service.getCreatureNow());
        PatientElf  Estelle = new PatientElf("Estelle",false, 21, 54, 165);
        assertThrows(IllegalArgumentException.class, () -> service.addCreature(Estelle));
    }

    @Test
    public void removeCreatureTest() {
        PatientDwarf yousra = new PatientDwarf("Yousra",false, 19, 47, 153);
        service.addCreature(yousra);
        service.removeCreature(yousra);
        assertEquals(0, service.getCreatureNow());
        assertThrows(IllegalArgumentException.class, () -> service.removeCreature(yousra));
    }

    @Test
    public void getCreaturesTest() {
        PatientDwarf yousra = new PatientDwarf("Yousra",false, 19, 47, 153);
        service.addCreature(yousra);
        assertEquals(1, service.getCreatures().size());
        assertTrue(service.getCreatures().contains(yousra));

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
    public void setCreatureNowTest() {
        PatientElf Estelle = new PatientElf("Estelle",false, 21, 54, 165);
        PatientElf Mariam = new PatientElf("Mariam",false, 19, 53, 160);
        service.addCreature(Estelle);
        service.addCreature(Mariam);
        service.setCreatureNow();
        assertEquals(2, service.getCreatureNow());

    }
    @Test
    public void setCreaturesTest() {
        PatientCollection creatures = new PatientCollection();
        PatientDwarf yousra = new PatientDwarf("Yousra",false, 19, 47, 153);
        creatures.add(yousra);
        service.setCreatures(creatures);
        assertEquals(1, service.getCreatures().size());

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
        service.addCreature(elf1);
        service.addCreature(elf2);
        service.addCreature(elf3);
        service.addCreature(elf4);
        service.addCreature(elf5);
        service.addCreature(elf6);
        service.addCreature(elf7);
        service.addCreature(elf8);
        service.addCreature(elf9);
        service.addCreature(elf10);
        assertTrue(service.isFull());
    }
    @Test
    public void isCreatureInsideTest() {
        PatientDwarf yousra = new PatientDwarf("Yousra",false, 19, 47, 153);
        service.addCreature(yousra);
        assertTrue(service.isCreatureInService(yousra));
    }


}
