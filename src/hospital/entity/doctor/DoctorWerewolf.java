package hospital.entity.doctor;

import hospital.entity.Creature;
import hospital.entity.Doctor;

public class DoctorWerewolf extends Creature implements Doctor {

    public DoctorWerewolf(String name, boolean isMale, int age, float weight, float height) {
        super(name, isMale, age, weight, height);
    }

    public DoctorWerewolf(String name, boolean isMale, int age) {
        super(name, isMale, age);
    }

    /**
     *
     */
    @Override
    public void run() {

    }
}
