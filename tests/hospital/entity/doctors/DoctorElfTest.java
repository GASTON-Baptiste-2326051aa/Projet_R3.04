package hospital.entity.doctors;

import hospital.entity.doctor.DoctorElf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoctorElfTest {

    private DoctorElf doctorElf;

    @BeforeEach
    public void setUp() {
        doctorElf = new DoctorElf("Elf",true, 28, 104, 220);
    }

    @Test
    public void getNameTest() {
        assertEquals("Elf", doctorElf.getName());
    }

    @Test
    public void setNameTest(){
        doctorElf.setName("Elf2");
        assertEquals("Elf2", doctorElf.getName());
    }

    @Test
    public void isMaleTest() {
        assertTrue(doctorElf.isMale());
    }

    @Test
    public void setMaleTest(){
        doctorElf.setMale(false);
        assertFalse(doctorElf.isMale());
    }

    @Test
    public void getAgeTest() {
        assertEquals(28, doctorElf.getAge());
    }

    @Test
    public void setAgeTest(){
        doctorElf.setAge(30);
        assertEquals(30, doctorElf.getAge());
    }

    @Test
    public void getWeightTest() {
        assertEquals(104, doctorElf.getWeight());
    }

    @Test
    public void getHeightTest() {
        assertEquals(220, doctorElf.getHeight());
    }

    @Test
    public void setWeightTest(){
        doctorElf.setWeight(100);
        assertEquals(100, doctorElf.getWeight());
    }

    @Test
    public void setHeightTest(){
        doctorElf.setHeight(200);
        assertEquals(200, doctorElf.getHeight());
    }

    @Test
    public void toStringTest(){
        assertEquals("DoctorElf{name='Elf', isMale=true, weight=104.0, height=220.0, age=28}", doctorElf.toString());
    }
}
