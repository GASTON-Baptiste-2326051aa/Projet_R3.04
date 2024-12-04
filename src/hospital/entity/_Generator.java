package hospital.entity;

import hospital.entity.doctor.DoctorDwarf;
import hospital.entity.patient.PatientDwarf;
import hospital.entity.patient.PatientZombie;
import hospital.illness.Illness;
import hospital.illness.Illnesses;
import hospital.illness.SetIllness;

import java.util.Random;

/**
 * The `_Generator` class provides methods to generate random patients, doctors, and various attributes for them.
 */
public class _Generator {
    /**
     * Predefined list of names for random generation.
     */
    private static final String[] NAMES = {"Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Heidi", "Ivan", "Judy", "Kevin", "Linda", "Michael", "Nancy", "Oscar", "Peggy", "Quincy", "Rita", "Steve", "Tina", "Ursula", "Victor", "Wendy", "Xander", "Yvonne", "Zack"};

    /**
     * Random number generator.
     */
    protected static final Random random = new Random();

    /**
     * Generates a specific patient named Yousra Mehdi.
     * @return a `PatientDwarf` instance representing Yousra Mehdi.
     */
    public static Patient getYousraPatient() {
        return new PatientDwarf("Yousra Mehdi", false, 18, 1.53F, 45.0F, Patient.MORALE_MAX, new SetIllness(new Illness[]{new Illness(Illnesses.FOMO), new Illness(Illnesses.DRS)}));
    }

    /**
     * Generates a specific doctor named Yousra Mehdi.
     * @return a `DoctorDwarf` instance representing Yousra Mehdi.
     */
    public static Doctor getYousraDoctor() {
        return new DoctorDwarf("Yousra Mehdi", false, 18, 1.53F, 45.0F);
    }

    /**
     * Generates a specific patient named Cyril Tamine.
     * @return a `PatientZombie` instance representing Cyril Tamine.
     */
    public static Patient getCyrilPatient() {
        return new PatientZombie("Cyril Tamine", true, 19, 1.75F, 73.0F, Patient.MORALE_MAX, new SetIllness(new Illness[]{new Illness(Illnesses.DRS)}));
    }

    /**
     * Generates a random patient as an Easter egg.
     * @return a random `Patient` instance.
     */
    public static Patient getEasterEggPatient() {
        int rdm = random.nextInt(2);
        return switch (rdm) {
            case 0 -> getYousraPatient();
            case 1 -> getCyrilPatient();
            default -> throw new IllegalStateException("Unexpected value: " + rdm);
        };
    }

    /**
     * Generates a specific doctor as an Easter egg.
     * @return a `DoctorDwarf` instance representing Yousra Mehdi.
     */
    public static Doctor getEasterEggDoctor() {
        return getYousraDoctor();
    }

    /**
     * Generates a super random integer up to a specified maximum.
     * @param max the maximum value.
     * @return a random integer.
     */
    public static int generateSuperRandom(int max) {
        for (int i = 1; i < max; i++) {
            int rdm = random.nextInt(max + 1 - i);
            if (rdm == 0)
                return i;
        }
        return max;
    }

    /**
     * Generates a random name from a predefined list.
     * @return a random name.
     */
    public static String generateName() {
        return NAMES[random.nextInt(NAMES.length)];
    }

    /**
     * Generates a random sex.
     * @return a random boolean representing sex.
     */
    public static boolean generateSex() {
        return random.nextBoolean();
    }

    /**
     * Generates a random age.
     * @return a random age.
     */
    public static int generateAge() {
        return generateSuperRandom(100);
    }

    /**
     * Generates a random weight.
     * @return a random weight.
     */
    public static float generateWeight() {
        return 40 + random.nextFloat() * 60;
    }

    /**
     * Generates a random height.
     * @return a random height.
     */
    public static float generateHeight() {
        return 1.50F + random.nextFloat() * 0.50F;
    }

    /**
     * Generates a random morale value.
     * @return a random morale value.
     */
    public static int generateMorale() {
        return random.nextInt(Patient.MORALE_MIN, Patient.MORALE_MAX + 1);
    }

    /**
     * Generates a random set of illnesses.
     * @return a `SetIllness` instance with random illnesses.
     */
    public static SetIllness generateIllnesses() {
        int rdm = random.nextInt(Illnesses.values().length);
        Illnesses[] values = Illnesses.values().clone();
        SetIllness illnesses = new SetIllness();
        for (int i = 0; i < rdm; i++) {
            int ill = generateSuperRandom(values.length-1);
            if (values[ill] == null) {
                i--;
                continue;
            }
            illnesses.add(new Illness(values[ill]));
            values[ill] = null;
        }
        return illnesses;
    }

    /**
     * Generates a random age for a BeastMan.
     * @return a random age.
     */
    public static int generateAgeBeastMan() {
        return generateSuperRandom(80);
    }

    /**
     * Generates a random age for a Dwarf.
     * @return a random age.
     */
    public static int generateAgeDwarf() {
        return generateSuperRandom(90);
    }

    /**
     * Generates a random age for an Elf.
     * @return a random age.
     */
    public static int generateAgeElf() {
        return generateSuperRandom(150);
    }

    /**
     * Generates a random age for an Orc.
     * @return a random age.
     */
    public static int generateAgeOrc() {
        return generateSuperRandom(80);
    }

    /**
     * Generates a random age for a Reptilian.
     * @return a random age.
     */
    public static int generateAgeReptilian() {
        return generateSuperRandom(100);
    }

    /**
     * Generates a random age for a Vampire.
     * @return a random age.
     */
    public static int generateAgeVampire() {
        return generateSuperRandom(1500);
    }

    /**
     * Generates a random age for a Werewolf.
     * @return a random age.
     */
    public static int generateAgeWerewolf() {
        return generateSuperRandom(200);
    }

    /**
     * Generates a random age for a Zombie.
     * @return a random age.
     */
    public static int generateAgeZombie() {
        return generateSuperRandom(1000000);
    }

    /**
     * Generates a random weight for a BeastMan.
     * @return a random weight.
     */
    public static float generateWeightBeastMan() {
        return 50 + random.nextFloat() * 350;
    }

    /**
     * Generates a random weight for a Dwarf.
     * @return a random weight.
     */
    public static float generateWeightDwarf() {
        return 25 + random.nextFloat() * 75;
    }

    /**
     * Generates a random weight for an Elf.
     * @return a random weight.
     */
    public static float generateWeightElf() {
        return 20 + random.nextFloat() * 30;
    }

    /**
     * Generates a random weight for an Orc.
     * @return a random weight.
     */
    public static float generateWeightOrc() {
        return 250 + random.nextFloat() * 750;
    }

    /**
     * Generates a random weight for a Reptilian.
     * @return a random weight.
     */
    public static float generateWeightReptilian() {
        return 35 + random.nextFloat() * 110;
    }

    /**
     * Generates a random weight for a Vampire.
     * @return a random weight.
     */
    public static float generateWeightVampire() {
        return 35 + random.nextFloat() * 85;
    }

    /**
     * Generates a random weight for a Werewolf.
     * @return a random weight.
     */
    public static float generateWeightWerewolf() {
        return 100 + random.nextFloat() * 50;
    }

    /**
     * Generates a random weight for a Zombie.
     * @return a random weight.
     */
    public static float generateWeightZombie() {
        return 15 + random.nextFloat() * 60;
    }

    /**
     * Generates a random height for a BeastMan.
     * @return a random height.
     */
    public static float generateHeightBeastMan() {
        return 1.0F + random.nextFloat() * 2.0F;
    }

    /**
     * Generates a random height for a Dwarf.
     * @return a random height.
     */
    public static float generateHeightDwarf() {
        return 0.5F + random.nextFloat() * 0.9F;
    }

    /**
     * Generates a random height for an Elf.
     * @return a random height.
     */
    public static float generateHeightElf() {
        return 0.5F + random.nextFloat() * 0.9F;
    }

    /**
     * Generates a random height for an Orc.
     * @return a random height.
     */
    public static float generateHeightOrc() {
        return 2.0F + random.nextFloat() * 3.0F;
    }

    /**
     * Generates a random height for a Reptilian.
     * @return a random height.
     */
    public static float generateHeightReptilian() {
        return 1.0F + random.nextFloat();
    }

    /**
     * Generates a random height for a Vampire.
     * @return a random height.
     */
    public static float generateHeightVampire() {
        return 1.0F + random.nextFloat() * 2.0F;
    }

    /**
     * Generates a random height for a Werewolf.
     * @return a random height.
     */
    public static float generateHeightWerewolf() {
        return 1.3F + random.nextFloat() * 0.8F;
    }

    /**
     * Generates a random height for a Zombie.
     * @return a random height.
     */
    public static float generateHeightZombie() {
        return 1.5F + random.nextFloat() * 0.4F;
    }
}