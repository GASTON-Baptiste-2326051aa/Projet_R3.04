package hospital.entity.doctors;

import hospital.entity.doctor.DoctorVampire;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoctorVampireTest {

    private DoctorVampire doctorVampire;

    @BeforeEach
    public void setUp() {
        doctorVampire = new DoctorVampire("Vampire",true, 28, 104, 220);
    }

    @Test
    public void getNameTest() {
        assertEquals("Vampire", doctorVampire.getName());
    }

    @Test
    public void setNameTest(){
        doctorVampire.setName("Vampire2");
        assertEquals("Vampire2", doctorVampire.getName());
    }

    @Test
    public void isMaleTest() {
        assertTrue(doctorVampire.isMale());
    }

    @Test
    public void setMaleTest(){
        doctorVampire.setMale(false);
        assertFalse(doctorVampire.isMale());
    }

    @Test
    public void getAgeTest() {
        assertEquals(28, doctorVampire.getAge());
    }

    @Test
    public void setAgeTest(){
        doctorVampire.setAge(30);
        assertEquals(30, doctorVampire.getAge());
    }

    @Test
    public void getWeightTest() {
        assertEquals(104, doctorVampire.getWeight());
    }

    @Test
    public void getHeightTest() {
        assertEquals(220, doctorVampire.getHeight());
    }

    @Test
    public void setWeightTest(){
        doctorVampire.setWeight(100);
        assertEquals(100, doctorVampire.getWeight());
    }

    @Test
    public void setHeightTest(){
        doctorVampire.setHeight(200);
        assertEquals(200, doctorVampire.getHeight());
    }

    @Test
    public void toStringTest(){
        assertEquals("DoctorVampire{name='Vampire', isMale=true, weight=104.0, height=220.0, age=28}", doctorVampire.toString());
    }
}
