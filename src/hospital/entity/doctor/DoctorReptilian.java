package hospital.entity.doctor;

import hospital.entity.Creature;
import hospital.entity.Doctor;

public class DoctorReptilian extends Creature implements Doctor {
    public DoctorReptilian(String name, boolean isMale, int age, float weight, float height) {
        super(name, isMale, age, weight, height);
    }

    public DoctorReptilian(String name, boolean isMale, int age) {
        super(name, isMale, age);
    }
}
