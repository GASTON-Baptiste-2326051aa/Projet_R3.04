package hospital.entity.doctor;

import hospital.entity.Doctor;
import hospital.entity._Generator;
import hospital.race.Race;

public class _DoctorGenerator extends _Generator {
    public static Doctor generateDoctor(int race, String name, boolean isMale, int age, float weight, float height) {
        return switch (race) {
            case 0 -> new DoctorBeastMan(name, isMale, age, weight, height);
            case 1 -> new DoctorDwarf(name, isMale, age, weight, height);
            case 2 -> new DoctorElf(name, isMale, age, weight, height);
            case 3 -> new DoctorOrc(name, isMale, age, weight, height);
            case 4 -> new DoctorReptilian(name, isMale, age, weight, height);
            case 5 -> new DoctorVampire(name, isMale, age, weight, height);
            case 6 -> new DoctorWerewolf(name, isMale, age, weight, height);
            case 7 -> new DoctorZombie(name, isMale, age, weight, height);
            default -> getEasterEggDoctor();
        };
    }

    public static Doctor generateDoctor(int race) {
        int rdm = race;
        if (race == -1) rdm = random.nextInt(Race.RACES);
        return switch (rdm) {
            case 0 ->
                    new DoctorBeastMan(generateName(), generateSex(), generateAgeBeastMan(), generateWeightBeastMan(), generateHeightBeastMan());
            case 1 ->
                    new DoctorDwarf(generateName(), generateSex(), generateAgeDwarf(), generateWeightDwarf(), generateHeightDwarf());
            case 2 ->
                    new DoctorElf(generateName(), generateSex(), generateAgeElf(), generateWeightElf(), generateHeightElf());
            case 3 ->
                    new DoctorOrc(generateName(), generateSex(), generateAgeOrc(), generateWeightOrc(), generateHeightOrc());
            case 4 ->
                    new DoctorReptilian(generateName(), generateSex(), generateAgeReptilian(), generateWeightReptilian(), generateHeightReptilian());
            case 5 ->
                    new DoctorVampire(generateName(), generateSex(), generateAgeVampire(), generateWeightVampire(), generateHeightVampire());
            case 6 ->
                    new DoctorWerewolf(generateName(), generateSex(), generateAgeWerewolf(), generateWeightWerewolf(), generateHeightWerewolf());
            case 7 ->
                    new DoctorZombie(generateName(), generateSex(), generateAgeZombie(), generateWeightZombie(), generateHeightZombie());
            default -> getEasterEggDoctor();
        };
    }

    public static Doctor generateDoctor() {
        return generateDoctor(random.nextInt(Race.RACES));
    }

    public static Doctor[] generateDoctors(int max) {
        int rdm = random.nextInt(max + 1);
        Doctor[] doctors = new Doctor[rdm];
        for (int i = 0; i < rdm; i++) {
            doctors[i] = generateDoctor();
        }
        return doctors;
    }
}
