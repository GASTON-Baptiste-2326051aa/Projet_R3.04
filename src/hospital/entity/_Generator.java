package hospital.entity;

import hospital.entity.doctor.DoctorDwarf;
import hospital.entity.patient.PatientDwarf;
import hospital.entity.patient.PatientZombie;
import hospital.illness.Illness;
import hospital.illness.Illnesses;
import hospital.illness.SetIllness;

import java.util.Random;

public class _Generator {
    private static final String[] NAMES = {"Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Heidi", "Ivan", "Judy", "Kevin", "Linda", "Michael", "Nancy", "Oscar", "Peggy", "Quincy", "Rita", "Steve", "Tina", "Ursula", "Victor", "Wendy", "Xander", "Yvonne", "Zack"};
    protected final Random random = new Random();

    public Patient getYousraPatient() {
        return new PatientDwarf("Yousra Mehdi", false, 18, 1.53F, 45.0F, Patient.MORALE_MAX, new SetIllness(new Illness[]{new Illness(Illnesses.FOMO), new Illness(Illnesses.DRS)}));
    }

    public Doctor getYousraDoctor() {
        return new DoctorDwarf("Yousra Mehdi", false, 18, 1.53F, 45.0F);
    }

    public Patient getCyrilPatient() {
        return new PatientZombie("Cyril Tamine", true, 19, 1.75F, 73.0F, Patient.MORALE_MAX, new SetIllness(new Illness[]{new Illness(Illnesses.DRS)}));
    }

    public Patient getEasterEggPatient() {
        int rdm = random.nextInt(2);
        return switch (rdm) {
            case 0 -> getYousraPatient();
            case 1 -> getCyrilPatient();
            default -> throw new IllegalStateException("Unexpected value: " + rdm);
        };
    }

    public Doctor getEasterEggDoctor() {
        return getYousraDoctor();
    }

    public int generateSuperRandom(int max) {
        for (int i = 1; i < max; i++) {
            int rdm = random.nextInt(max + 1 - i);
            if (rdm == 0)
                return i;
        }
        return max;
    }

    public String generateName() {
        return NAMES[random.nextInt(NAMES.length)];
    }

    public boolean generateSex() {
        return random.nextBoolean();
    }

    public int generateAge() {
        return generateSuperRandom(100);
    }

    public float generateWeight() {
        return 40 + random.nextFloat() * 60;
    }

    public float generateHeight() {
        return 1.50F + random.nextFloat() * 0.50F;
    }

    public int generateMorale() {
        return random.nextInt(Patient.MORALE_MIN, Patient.MORALE_MAX + 1);
    }

    public SetIllness generateIllnesses() {
        int rdm = random.nextInt(Illnesses.values().length);
        Illnesses[] values = Illnesses.values().clone();
        SetIllness illnesses = new SetIllness();
        for (int i = 0; i < rdm; i++) {
            int ill = generateSuperRandom(values.length);
            if (values[ill] == null) {
                i--;
                continue;
            }
            illnesses.add(new Illness(values[ill]));
            values[ill] = null;
        }
        return illnesses;
    }

    public int generateAgeBeastMan() {
        return generateSuperRandom(80);
    }

    public int generateAgeDwarf() {
        return generateSuperRandom(90);
    }

    public int generateAgeElf() {
        return generateSuperRandom(150);
    }

    public int generateAgeOrc() {
        return generateSuperRandom(80);
    }

    public int generateAgeReptilian() {
        return generateSuperRandom(100);
    }

    public int generateAgeVampire() {
        return generateSuperRandom(1500);
    }

    public int generateAgeWerewolf() {
        return generateSuperRandom(200);
    }

    public int generateAgeZombie() {
        return generateSuperRandom(1000000);
    }

    public float generateWeightBeastMan() {
        return 50 + random.nextFloat() * 350;
    }

    public float generateWeightDwarf() {
        return 25 + random.nextFloat() * 75;
    }

    public float generateWeightElf() {
        return 20 + random.nextFloat() * 30;
    }

    public float generateWeightOrc() {
        return 250 + random.nextFloat() * 750;
    }

    public float generateWeightReptilian() {
        return 35 + random.nextFloat() * 110;
    }

    public float generateWeightVampire() {
        return 35 + random.nextFloat() * 85;
    }

    public float generateWeightWerewolf() {
        return 100 + random.nextFloat() * 50;
    }

    public float generateWeightZombie() {
        return 15 + random.nextFloat() * 60;
    }

    public float generateHeightBeastMan() {
        return 1.0F + random.nextFloat() * 2.0F;
    }

    public float generateHeightDwarf() {
        return 0.5F + random.nextFloat() * 0.9F;
    }

    public float generateHeightElf() {
        return 0.5F + random.nextFloat() * 0.9F;
    }

    public float generateHeightOrc() {
        return 2.0F + random.nextFloat() * 3.0F;
    }

    public float generateHeightReptilian() {
        return 1.0F + random.nextFloat();
    }

    public float generateHeightVampire() {
        return 1.0F + random.nextFloat() * 2.0F;
    }

    public float generateHeightWerewolf() {
        return 1.3F + random.nextFloat() * 0.8F;
    }

    public float generateHeightZombie() {
        return 1.5F + random.nextFloat() * 0.4F;
    }
}
