package hospital.entity.doctors;

import hospital.entity.doctor.DoctorWerewolf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoctorWerewolfTest {

    private DoctorWerewolf doctorWerewolf;

    @BeforeEach
    public void setUp() {
        doctorWerewolf = new DoctorWerewolf("Werewolf",true, 28, 104, 220);
    }

    @Test
    public void getNameTest() {
        assertEquals("Werewolf", doctorWerewolf.getName());
    }

    @Test
    public void setNameTest(){
        doctorWerewolf.setName("Werewolf2");
        assertEquals("Werewolf2", doctorWerewolf.getName());
    }

    @Test
    public void isMaleTest() {
        assertTrue(doctorWerewolf.isMale());
    }

    @Test
    public void setMaleTest(){
        doctorWerewolf.setMale(false);
        assertFalse(doctorWerewolf.isMale());
    }

    @Test
    public void getAgeTest() {
        assertEquals(28, doctorWerewolf.getAge());
    }

    @Test
    public void setAgeTest(){
        doctorWerewolf.setAge(30);
        assertEquals(30, doctorWerewolf.getAge());
    }

    @Test
    public void getWeightTest() {
        assertEquals(104, doctorWerewolf.getWeight());
    }

    @Test
    public void getHeightTest() {
        assertEquals(220, doctorWerewolf.getHeight());
    }

    @Test
    public void setWeightTest(){
        doctorWerewolf.setWeight(100);
        assertEquals(100, doctorWerewolf.getWeight());
    }

    @Test
    public void setHeightTest(){
        doctorWerewolf.setHeight(200);
        assertEquals(200, doctorWerewolf.getHeight());
    }

    @Test
    public void toStringTest(){
        assertEquals("DoctorWerewolf{name='Werewolf', isMale=true, weight=104.0, height=220.0, age=28}", doctorWerewolf.toString());
    }
}
