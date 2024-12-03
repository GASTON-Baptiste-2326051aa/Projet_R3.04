package hospital.entity.doctor;

import hospital.entity.Creature;
import hospital.entity.Doctor;

/**
 * The `DoctorElf` class represents a doctor of the Elf race.
 */
public class DoctorElf extends Creature implements Doctor {
    /**
     * Constructs a `DoctorElf` with specified attributes.
     * @param name the name of the doctor
     * @param isMale the sex of the doctor
     * @param age the age of the doctor
     * @param weight the weight of the doctor
     * @param height the height of the doctor
     */
    public DoctorElf(String name, boolean isMale, int age, float weight, float height) {
        super(name, isMale, age, weight, height);
    }

    /**
     * Constructs a `DoctorElf` with specified attributes and default weight and height.
     * @param name the name of the doctor
     * @param isMale the sex of the doctor
     * @param age the age of the doctor
     */
    public DoctorElf(String name, boolean isMale, int age) {
        super(name, isMale, age);
    }
}