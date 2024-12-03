package hospital.entity.doctors;

import hospital.entity.doctor.DoctorOrc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoctorOrcTest {

    private DoctorOrc doctorOrc;

    @BeforeEach
    public void setUp() {
        doctorOrc = new DoctorOrc("Orc",true, 28, 104, 220);
    }

    @Test
    public void getNameTest() {
        assertEquals("Orc", doctorOrc.getName());
    }

    @Test
    public void setNameTest(){
        doctorOrc.setName("Orc2");
        assertEquals("Orc2", doctorOrc.getName());
    }

    @Test
    public void isMaleTest() {
        assertTrue(doctorOrc.isMale());
    }

    @Test
    public void setMaleTest(){
        doctorOrc.setMale(false);
        assertFalse(doctorOrc.isMale());
    }

    @Test
    public void getAgeTest() {
        assertEquals(28, doctorOrc.getAge());
    }

    @Test
    public void setAgeTest(){
        doctorOrc.setAge(30);
        assertEquals(30, doctorOrc.getAge());
    }

    @Test
    public void getWeightTest() {
        assertEquals(104, doctorOrc.getWeight());
    }

    @Test
    public void getHeightTest() {
        assertEquals(220, doctorOrc.getHeight());
    }

    @Test
    public void setWeightTest(){
        doctorOrc.setWeight(100);
        assertEquals(100, doctorOrc.getWeight());
    }

    @Test
    public void setHeightTest(){
        doctorOrc.setHeight(200);
        assertEquals(200, doctorOrc.getHeight());
    }

    @Test
    public void toStringTest(){
        assertEquals("DoctorOrc{name='Orc', isMale=true, weight=104.0, height=220.0, age=28}", doctorOrc.toString());
    }
}
