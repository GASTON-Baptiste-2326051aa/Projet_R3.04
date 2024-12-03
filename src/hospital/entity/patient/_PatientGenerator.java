package hospital.entity.patient;

import hospital.entity.Patient;
import hospital.entity._Generator;
import hospital.race.Race;

/**
 * The `_PatientGenerator` class provides methods to generate patients of various races with random or specified attributes.
 */
public class _PatientGenerator extends _Generator {

    /**
     * Generates a patient with specified attributes.
     * @param race the race of the patient
     * @param name the name of the patient
     * @param isMale the sex of the patient
     * @param age the age of the patient
     * @param weight the weight of the patient
     * @param height the height of the patient
     * @return a `Patient` instance with the specified attributes
     */
    public Patient generatePatient(int race, String name, boolean isMale, int age, float weight, float height) {
        return switch (race) {
            case 0 -> new PatientBeastMan(name, isMale, age, weight, height, Patient.MORALE_MAX, generateIllnesses());
            case 1 -> new PatientDwarf(name, isMale, age, weight, height, Patient.MORALE_MAX, generateIllnesses());
            case 2 -> new PatientElf(name, isMale, age, weight, height, Patient.MORALE_MAX, generateIllnesses());
            case 3 -> new PatientOrc(name, isMale, age, weight, height, Patient.MORALE_MAX, generateIllnesses());
            case 4 -> new PatientReptilian(name, isMale, age, weight, height, Patient.MORALE_MAX, generateIllnesses());
            case 5 -> new PatientVampire(name, isMale, age, weight, height, Patient.MORALE_MAX, generateIllnesses());
            case 6 -> new PatientWerewolf(name, isMale, age, weight, height, Patient.MORALE_MAX, generateIllnesses());
            case 7 -> new PatientZombie(name, isMale, age, weight, height, Patient.MORALE_MAX, generateIllnesses());
            default -> getEasterEggPatient();
        };
    }

    /**
     * Generates a patient with random attributes for a specified race.
     * @param race the race of the patient
     * @return a `Patient` instance with random attributes
     */
    public Patient generatePatient(int race) {
        int rdm = race;
        if (race == -1) rdm = random.nextInt(Race.RACES);
        return switch (rdm) {
            case 0 -> new PatientBeastMan(generateName(), generateSex(), generateAgeBeastMan(), generateWeightBeastMan(), generateHeightBeastMan(), Patient.MORALE_MAX, generateIllnesses());
            case 1 -> new PatientDwarf(generateName(), generateSex(), generateAgeDwarf(), generateWeightDwarf(), generateHeightDwarf(), Patient.MORALE_MAX, generateIllnesses());
            case 2 -> new PatientElf(generateName(), generateSex(), generateAgeElf(), generateWeightElf(), generateHeightElf(), Patient.MORALE_MAX, generateIllnesses());
            case 3 -> new PatientOrc(generateName(), generateSex(), generateAgeOrc(), generateWeightOrc(), generateHeightOrc(), Patient.MORALE_MAX, generateIllnesses());
            case 4 -> new PatientReptilian(generateName(), generateSex(), generateAgeReptilian(), generateWeightReptilian(), generateHeightReptilian(), Patient.MORALE_MAX, generateIllnesses());
            case 5 -> new PatientVampire(generateName(), generateSex(), generateAgeVampire(), generateWeightVampire(), generateHeightVampire(), Patient.MORALE_MAX, generateIllnesses());
            case 6 -> new PatientWerewolf(generateName(), generateSex(), generateAgeWerewolf(), generateWeightWerewolf(), generateHeightWerewolf(), Patient.MORALE_MAX, generateIllnesses());
            case 7 -> new PatientZombie(generateName(), generateSex(), generateAgeZombie(), generateWeightZombie(), generateHeightZombie(), Patient.MORALE_MAX, generateIllnesses());
            default -> getEasterEggPatient();
        };
    }

    /**
     * Generates a patient with random attributes and race.
     * @return a `Patient` instance with random attributes and race
     */
    public Patient generatePatient() {
        return generatePatient(random.nextInt(Race.RACES));
    }

    /**
     * Generates an array of patients with random attributes and race.
     * @param max the maximum number of patients to generate
     * @return an array of `Patient` instances
     */
    public Patient[] generatePatients(int max) {
        int rdm = random.nextInt(max + 1);
        Patient[] patients = new Patient[rdm];
        for (int i = 0; i < rdm; i++) {
            patients[i] = generatePatient();
        }
        return patients;
    }
}