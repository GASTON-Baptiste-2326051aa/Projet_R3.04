package hospital.entity.doctors;

import hospital.entity.doctor.DoctorReptilian;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoctorReptilianTest {

    private DoctorReptilian doctorReptilian;

    @BeforeEach
    public void setUp() {
        doctorReptilian = new DoctorReptilian("Reptilian",true, 28, 104, 220);
    }

    @Test
    public void getNameTest() {
        assertEquals("Reptilian", doctorReptilian.getName());
    }

    @Test
    public void setNameTest(){
        doctorReptilian.setName("Reptilian2");
        assertEquals("Reptilian2", doctorReptilian.getName());
    }

    @Test
    public void isMaleTest() {
        assertTrue(doctorReptilian.isMale());
    }

    @Test
    public void setMaleTest(){
        doctorReptilian.setMale(false);
        assertFalse(doctorReptilian.isMale());
    }

    @Test
    public void getAgeTest() {
        assertEquals(28, doctorReptilian.getAge());
    }

    @Test
    public void setAgeTest(){
        doctorReptilian.setAge(30);
        assertEquals(30, doctorReptilian.getAge());
    }

    @Test
    public void getWeightTest() {
        assertEquals(104, doctorReptilian.getWeight());
    }

    @Test
    public void getHeightTest() {
        assertEquals(220, doctorReptilian.getHeight());
    }

    @Test
    public void setWeightTest(){
        doctorReptilian.setWeight(100);
        assertEquals(100, doctorReptilian.getWeight());
    }

    @Test
    public void setHeightTest(){
        doctorReptilian.setHeight(200);
        assertEquals(200, doctorReptilian.getHeight());
    }

    @Test
    public void toStringTest(){
        assertEquals("DoctorReptilian{name='Reptilian', isMale=true, weight=104.0, height=220.0, age=28}", doctorReptilian.toString());
    }
}
