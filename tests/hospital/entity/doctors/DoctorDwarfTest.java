package hospital.entity.doctors;

import hospital.entity.doctor.DoctorDwarf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoctorDwarfTest {

    private DoctorDwarf doctorDwarf;

    @BeforeEach
    public void setUp() {
        doctorDwarf = new DoctorDwarf("Dwarf",true, 28, 104, 220);
    }

    @Test
    public void getNameTest() {
        assertEquals("Dwarf", doctorDwarf.getName());
    }

    @Test
    public void setNameTest(){
        doctorDwarf.setName("Dwarf2");
        assertEquals("Dwarf2", doctorDwarf.getName());
    }

    @Test
    public void isMaleTest() {
        assertTrue(doctorDwarf.isMale());
    }

    @Test
    public void setMaleTest(){
        doctorDwarf.setMale(false);
        assertFalse(doctorDwarf.isMale());
    }

    @Test
    public void getAgeTest() {
        assertEquals(28, doctorDwarf.getAge());
    }

    @Test
    public void setAgeTest(){
        doctorDwarf.setAge(30);
        assertEquals(30, doctorDwarf.getAge());
    }

    @Test
    public void getWeightTest() {
        assertEquals(104, doctorDwarf.getWeight());
    }

    @Test
    public void getHeightTest() {
        assertEquals(220, doctorDwarf.getHeight());
    }

    @Test
    public void setWeightTest(){
        doctorDwarf.setWeight(100);
        assertEquals(100, doctorDwarf.getWeight());
    }

    @Test
    public void setHeightTest(){
        doctorDwarf.setHeight(200);
        assertEquals(200, doctorDwarf.getHeight());
    }

    @Test
    public void toStringTest(){
        assertEquals("DoctorDwarf{name='Dwarf', isMale=true, weight=104.0, height=220.0, age=28}", doctorDwarf.toString());
    }
}
