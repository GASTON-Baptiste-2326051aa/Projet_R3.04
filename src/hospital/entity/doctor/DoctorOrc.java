package hospital.entity.doctor;

import hospital.entity.Creature;
import hospital.entity.Doctor;

public class DoctorOrc extends Creature implements Doctor {
    public DoctorOrc(String name, boolean isMale, int age, float weight, float height) {
        super(name, isMale, age, weight, height);
    }

    public DoctorOrc(String name, boolean isMale, int age) {
        super(name, isMale, age);
    }
}
