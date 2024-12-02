package hospital.entity.doctors;

import hospital.entity.doctor.DoctorBeastMan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoctorBeastManTest {
    
    private DoctorBeastMan doctorBeastMan;
    
    @BeforeEach
    public void setUp() {
        doctorBeastMan = new DoctorBeastMan("BeastMan",true, 28, 104, 220);
    }

    @Test
    public void getNameTest() {
        assertEquals("BeastMan", doctorBeastMan.getName());
    }

    @Test
    public void setNameTest(){
        doctorBeastMan.setName("BeastMan2");
        assertEquals("BeastMan2", doctorBeastMan.getName());
    }

    @Test
    public void isMaleTest() {
        assertTrue(doctorBeastMan.isMale());
    }

    @Test
    public void setMaleTest(){
        doctorBeastMan.setMale(false);
        assertFalse(doctorBeastMan.isMale());
    }

    @Test
    public void getAgeTest() {
        assertEquals(28, doctorBeastMan.getAge());
    }

    @Test
    public void setAgeTest(){
        doctorBeastMan.setAge(30);
        assertEquals(30, doctorBeastMan.getAge());
    }

    @Test
    public void getWeightTest() {
        assertEquals(104, doctorBeastMan.getWeight());
    }

    @Test
    public void getHeightTest() {
        assertEquals(220, doctorBeastMan.getHeight());
    }

    @Test
    public void setWeightTest(){
        doctorBeastMan.setWeight(100);
        assertEquals(100, doctorBeastMan.getWeight());
    }

    @Test
    public void setHeightTest(){
        doctorBeastMan.setHeight(200);
        assertEquals(200, doctorBeastMan.getHeight());
    }

    @Test
    public void toStringTest(){
        assertEquals("DoctorBeastMan{name='BeastMan', isMale=true, weight=104.0, height=220.0, age=28}", doctorBeastMan.toString());
    }
}
