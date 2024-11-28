package hospital.entity.doctor;

import hospital.entity.Creature;
import hospital.entity.Doctor;
import hospital.race.Reptilian;

public class DoctorReptilian extends Creature implements Doctor, Reptilian {

    public DoctorReptilian(String name, boolean isMale, int age, float weight, float height) {
        super(name, isMale, age, weight, height);
    }

    public DoctorReptilian(String name, boolean isMale, int age) {
        super(name, isMale, age);
    }

    /**
     *
     */
    @Override
    public void run() {

    }
}
