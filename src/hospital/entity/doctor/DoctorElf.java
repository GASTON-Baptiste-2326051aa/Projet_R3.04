package hospital.entity.doctor;

import hospital.entity.Creature;
import hospital.entity.Doctor;

public class DoctorElf extends Creature implements Doctor {
    public DoctorElf(String name, boolean isMale, int age, float weight, float height) {
        super(name, isMale, age, weight, height);
    }

    public DoctorElf(String name, boolean isMale, int age) {
        super(name, isMale, age);
    }

    /**
     *
     */
    @Override
    public void run() {

    }
}
