package hospital.entity.doctor;

import hospital.entity.Creature;
import hospital.entity.Doctor;

/**
 * The `DoctorBeastMan` class represents a doctor of the BeastMan race.
 */
public class DoctorBeastMan extends Creature implements Doctor {
    /**
     * Constructs a `DoctorBeastMan` with specified attributes.
     * @param name the name of the doctor
     * @param isMale the sex of the doctor
     * @param age the age of the doctor
     * @param weight the weight of the doctor
     * @param height the height of the doctor
     */
    public DoctorBeastMan(String name, boolean isMale, int age, float weight, float height) {
        super(name, isMale, age, weight, height);
    }

    /**
     * Constructs a `DoctorBeastMan` with specified attributes and default weight and height.
     * @param name the name of the doctor
     * @param isMale the sex of the doctor
     * @param age the age of the doctor
     */
    public DoctorBeastMan(String name, boolean isMale, int age) {
        super(name, isMale, age);
    }
}