package hospital.entity.doctor;

import hospital.entity.Creature;
import hospital.entity.Doctor;

public class DoctorVampire extends Creature implements Doctor {

    public DoctorVampire(String name, boolean isMale, int age, float weight, float height) {
        super(name, isMale, age, weight, height);
    }

    public DoctorVampire(String name, boolean isMale, int age) {
        super(name, isMale, age);
    }

    /**
     *
     */
    @Override
    public void run() {

    }
}
