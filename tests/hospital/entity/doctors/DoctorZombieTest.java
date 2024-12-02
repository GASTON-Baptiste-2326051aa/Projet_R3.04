package hospital.entity.doctors;

import hospital.entity.doctor.DoctorZombie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoctorZombieTest {

    private DoctorZombie doctorZombie;

    @BeforeEach
    public void setUp() {
        doctorZombie = new DoctorZombie("Zombie",true, 28, 104, 220);
    }

    @Test
    public void getNameTest() {
        assertEquals("Zombie", doctorZombie.getName());
    }

    @Test
    public void setNameTest(){
        doctorZombie.setName("Zombie2");
        assertEquals("Zombie2", doctorZombie.getName());
    }

    @Test
    public void isMaleTest() {
        assertTrue(doctorZombie.isMale());
    }

    @Test
    public void setMaleTest(){
        doctorZombie.setMale(false);
        assertFalse(doctorZombie.isMale());
    }

    @Test
    public void getAgeTest() {
        assertEquals(28, doctorZombie.getAge());
    }

    @Test
    public void setAgeTest(){
        doctorZombie.setAge(30);
        assertEquals(30, doctorZombie.getAge());
    }

    @Test
    public void getWeightTest() {
        assertEquals(104, doctorZombie.getWeight());
    }

    @Test
    public void getHeightTest() {
        assertEquals(220, doctorZombie.getHeight());
    }

    @Test
    public void setWeightTest(){
        doctorZombie.setWeight(100);
        assertEquals(100, doctorZombie.getWeight());
    }

    @Test
    public void setHeightTest(){
        doctorZombie.setHeight(200);
        assertEquals(200, doctorZombie.getHeight());
    }

    @Test
    public void toStringTest(){
        assertEquals("DoctorZombie{name='Zombie', isMale=true, weight=104.0, height=220.0, age=28}", doctorZombie.toString());
    }
}
