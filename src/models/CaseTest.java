package models;

import models.creatures.*;
import models.services.Crypt;
import models.services.QuarantineCenter;
import models.services.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CaseTest {

    private Hospital hospital;
    private Service service;
    private Crypt crypt;
    private QuarantineCenter quarantineCenter;
    private BeastMan beastMan;
    private Dwarf dwarf;
    private Elf elf;
    private Lycanthrope lycanthrope;
    private Orc orc;
    private Vampire vampire;
    private Zombie zombie;
    private Doctor doctor;
    private Illness illness;
    private Illness[] illnesses;

    @BeforeEach
    public void setUp() {
        illness = new Illness(Illnesses.DRS);
        illnesses = new Illness[]{new Illness(Illnesses.DRS), new Illness(Illnesses.MDC), new Illness(Illnesses.PEC), new Illness(Illnesses.FOMO), new Illness(Illnesses.ZPL), new Illness(Illnesses.NDMAD)};
        doctor = new Doctor("John Doe", true, 34);
        zombie = new Zombie("Zombie", false, 86, 43.5F, 1.73F, illnesses.clone());
        vampire = new Vampire("Vampire", true, 121, 67.5F, 2.04F, illnesses.clone());
        orc = new Orc("Orc", false, 45, 78.5F, 1.85F, illnesses.clone());
        lycanthrope = new Lycanthrope("Lycanthrope", false, 32, 65.5F, 1.75F, illnesses.clone());
        elf = new Elf("Elf", true, 234, 56.5F, 1.65F, illnesses.clone());
        dwarf = new Dwarf("Dwarf", false, 56, 45.5F, 1.55F, illnesses.clone());
        beastMan = new BeastMan("BeastMan", false, 78, 89.5F, 1.95F, illnesses.clone());
        service = new Service("Service", 100.0F, 10, 3, new Creature[]{orc, lycanthrope, beastMan}, 2);
        crypt = new Crypt("Crypt", 50.0F, 5, 2, new Creature[]{vampire, zombie}, 0);
        quarantineCenter = new QuarantineCenter("Quarantine Center", 150.0F, 15, 2, new Creature[]{elf, dwarf}, 1);
        hospital = new Hospital("Hospital", 5, new Service[]{service, crypt, quarantineCenter}, new Doctor[]{doctor});
    }

    // illness tests

    @Test
    public void testIllnessConstructor() {
        assertEquals("DRS", illness.getName());
        assertEquals("Dépendance aux réseaux sociaux", illness.getFullName());
        assertEquals(0, illness.getLvl());
        assertEquals(6, illness.getLvlMax());
    }

    @Test
    public void testIllnessGetFullName() {
        assertEquals("Dépendance aux réseaux sociaux", illness.getFullName());
    }

    @Test
    public void testIllnessGetName() {
        assertEquals("DRS", illness.getName());
    }

    @Test
    public void testIllnessGetLvl() {
        assertEquals(0, illness.getLvl());
    }

    @Test
    public void testIllnessSetLvl() {
        illness.setLvl(3);
        assertEquals(3, illness.getLvl());
    }

    @Test
    public void testIllnessGetLvlMax() {
        assertEquals(6, illness.getLvlMax());
    }

    @Test
    public void testIncreaseLvl() {
        illness.increase();
        assertEquals(1, illness.getLvl());
    }

    @Test
    public void testDecreaseLvl() {
        illness.increase();
        illness.decrease();
        assertEquals(0, illness.getLvl());
    }

    // doctor tests

    @Test
    public void testDoctorConstructor() {
        assertEquals("John Doe", doctor.getName());
        assertTrue(doctor.isMale());
        assertEquals(34, doctor.getAge());
    }

    @Test
    public void testDoctorGetName() {
        assertEquals("John Doe", doctor.getName());
    }

    @Test
    public void testDoctorIsMale() {
        assertTrue(doctor.isMale());
    }

    @Test
    public void testDoctorGetAge() {
        assertEquals(34, doctor.getAge());
    }

    @Test
    public void testDoctorSetAge() {
        doctor.setAge(45);
        assertEquals(45, doctor.getAge());
    }

    @Test
    public void testDoctorSetMale() {
        doctor.setMale(false);
        assertFalse(doctor.isMale());
    }

    @Test
    public void testDoctorSetName() {
        doctor.setName("Jane Doe");
        assertEquals("Jane Doe", doctor.getName());
    }

    // zombie tests

    @Test
    public void testZombieConstructor() {
        assertEquals("Zombie", zombie.getName());
        assertFalse(zombie.isMale());
        assertEquals(86, zombie.getAge());
        assertEquals(43.5F, zombie.getWeight());
        assertEquals(1.73F, zombie.getHeight());
        assertArrayEquals(illnesses, zombie.getIllnesses());
    }

    @Test
    public void testZombieGetName() {
        assertEquals("Zombie", zombie.getName());
    }

    @Test
    public void testZombieIsMale() {
        assertFalse(zombie.isMale());
    }

    @Test
    public void testZombieGetAge() {
        assertEquals(86, zombie.getAge());
    }

    @Test
    public void testZombieGetWeight() {
        assertEquals(43.5F, zombie.getWeight());
    }

    @Test
    public void testZombieGetHeight() {
        assertEquals(1.73F, zombie.getHeight());
    }

    @Test
    public void testZombieGetIllnesses() {
        assertArrayEquals(illnesses, zombie.getIllnesses());
    }

    @Test
    public void testZombieSetAge() {
        zombie.setAge(45);
        assertEquals(45, zombie.getAge());
    }

    @Test
    public void testZombieSetWeight() {
        zombie.setWeight(65.5F);
        assertEquals(65.5F, zombie.getWeight());
    }

    @Test
    public void testZombieSetHeight() {
        zombie.setHeight(1.75F);
        assertEquals(1.75F, zombie.getHeight());
    }

    @Test
    public void testZombieSetMale() {
        zombie.setMale(true);
        assertTrue(zombie.isMale());
    }

    @Test
    public void testZombieSetName() {
        zombie.setName("Zombie2");
        assertEquals("Zombie2", zombie.getName());
    }

    @Test
    public void testZombieSetIllnesses() {
        Illness[] illnesses2 = new Illness[]{new Illness(Illnesses.DRS), new Illness(Illnesses.MDC)};
        zombie.setIllnesses(illnesses2);
        assertArrayEquals(illnesses2, zombie.getIllnesses());
    }

    // vampire tests

    @Test
    public void testVampireConstructor() {
        assertEquals("Vampire", vampire.getName());
        assertTrue(vampire.isMale());
        assertEquals(121, vampire.getAge());
        assertEquals(67.5F, vampire.getWeight());
        assertEquals(2.04F, vampire.getHeight());
        assertArrayEquals(illnesses, vampire.getIllnesses());
    }

    @Test
    public void testVampireGetName() {
        assertEquals("Vampire", vampire.getName());
    }

    @Test
    public void testVampireIsMale() {
        assertTrue(vampire.isMale());
    }

    @Test
    public void testVampireGetAge() {
        assertEquals(121, vampire.getAge());
    }

    @Test
    public void testVampireGetWeight() {
        assertEquals(67.5F, vampire.getWeight());
    }

    @Test
    public void testVampireGetHeight() {
        assertEquals(2.04F, vampire.getHeight());
    }

    @Test
    public void testVampireGetIllnesses() {
        assertArrayEquals(illnesses, vampire.getIllnesses());
    }

    @Test
    public void testVampireSetAge() {
        vampire.setAge(45);
        assertEquals(45, vampire.getAge());
    }

    @Test
    public void testVampireSetWeight() {
        vampire.setWeight(65.5F);
        assertEquals(65.5F, vampire.getWeight());
    }

    @Test
    public void testVampireSetHeight() {
        vampire.setHeight(1.75F);
        assertEquals(1.75F, vampire.getHeight());
    }

    @Test
    public void testVampireSetMale() {
        vampire.setMale(false);
        assertFalse(vampire.isMale());
    }

    @Test
    public void testVampireSetName() {
        vampire.setName("Vampire2");
        assertEquals("Vampire2", vampire.getName());
    }

    @Test
    public void testVampireSetIllnesses() {
        Illness[] illnesses2 = new Illness[]{new Illness(Illnesses.DRS), new Illness(Illnesses.MDC)};
        vampire.setIllnesses(illnesses2);
        assertArrayEquals(illnesses2, vampire.getIllnesses());
    }

    // orc tests

    @Test
    public void testOrcConstructor() {
        assertEquals("Orc", orc.getName());
        assertFalse(orc.isMale());
        assertEquals(45, orc.getAge());
        assertEquals(78.5F, orc.getWeight());
        assertEquals(1.85F, orc.getHeight());
        assertArrayEquals(illnesses, orc.getIllnesses());
    }

    @Test
    public void testOrcGetName() {
        assertEquals("Orc", orc.getName());
    }

    @Test
    public void testOrcIsMale() {
        assertFalse(orc.isMale());
    }

    @Test
    public void testOrcGetAge() {
        assertEquals(45, orc.getAge());
    }

    @Test
    public void testOrcGetWeight() {
        assertEquals(78.5F, orc.getWeight());
    }

    @Test
    public void testOrcGetHeight() {
        assertEquals(1.85F, orc.getHeight());
    }

    @Test
    public void testOrcGetIllnesses() {
        assertArrayEquals(illnesses, orc.getIllnesses());
    }

    @Test
    public void testOrcSetAge() {
        orc.setAge(56);
        assertEquals(56, orc.getAge());
    }

    @Test
    public void testOrcSetWeight() {
        orc.setWeight(65.5F);
        assertEquals(65.5F, orc.getWeight());
    }

    @Test
    public void testOrcSetHeight() {
        orc.setHeight(1.75F);
        assertEquals(1.75F, orc.getHeight());
    }

    @Test
    public void testOrcSetMale() {
        orc.setMale(true);
        assertTrue(orc.isMale());
    }

    @Test
    public void testOrcSetName() {
        orc.setName("Orc2");
        assertEquals("Orc2", orc.getName());
    }

    @Test
    public void testOrcSetIllnesses() {
        Illness[] illnesses2 = new Illness[]{new Illness(Illnesses.DRS), new Illness(Illnesses.MDC)};
        orc.setIllnesses(illnesses2);
        assertArrayEquals(illnesses2, orc.getIllnesses());
    }

    // lycanthrope tests

    @Test
    public void testLycanthropeConstructor() {
        assertEquals("Lycanthrope", lycanthrope.getName());
        assertFalse(lycanthrope.isMale());
        assertEquals(32, lycanthrope.getAge());
        assertEquals(65.5F, lycanthrope.getWeight());
        assertEquals(1.75F, lycanthrope.getHeight());
        assertArrayEquals(illnesses, lycanthrope.getIllnesses());
    }

    @Test
    public void testLycanthropeGetName() {
        assertEquals("Lycanthrope", lycanthrope.getName());
    }

    @Test
    public void testLycanthropeIsMale() {
        assertFalse(lycanthrope.isMale());
    }

    @Test
    public void testLycanthropeGetAge() {
        assertEquals(32, lycanthrope.getAge());
    }

    @Test
    public void testLycanthropeGetWeight() {
        assertEquals(65.5F, lycanthrope.getWeight());
    }

    @Test
    public void testLycanthropeGetHeight() {
        assertEquals(1.75F, lycanthrope.getHeight());
    }

    @Test
    public void testLycanthropeGetIllnesses() {
        assertArrayEquals(illnesses, lycanthrope.getIllnesses());
    }

    @Test
    public void testLycanthropeSetAge() {
        lycanthrope.setAge(45);
        assertEquals(45, lycanthrope.getAge());
    }

    @Test
    public void testLycanthropeSetWeight() {
        lycanthrope.setWeight(65.5F);
        assertEquals(65.5F, lycanthrope.getWeight());
    }

    @Test
    public void testLycanthropeSetHeight() {
        lycanthrope.setHeight(1.75F);
        assertEquals(1.75F, lycanthrope.getHeight());
    }

    @Test
    public void testLycanthropeSetMale() {
        lycanthrope.setMale(true);
        assertTrue(lycanthrope.isMale());
    }

    @Test
    public void testLycanthropeSetName() {
        lycanthrope.setName("Lycanthrope2");
        assertEquals("Lycanthrope2", lycanthrope.getName());
    }

    @Test
    public void testLycanthropeSetIllnesses() {
        Illness[] illnesses2 = new Illness[]{new Illness(Illnesses.DRS), new Illness(Illnesses.MDC)};
        lycanthrope.setIllnesses(illnesses2);
        assertArrayEquals(illnesses2, lycanthrope.getIllnesses());
    }

    // elf tests

    @Test
    public void testElfConstructor() {
        assertEquals("Elf", elf.getName());
        assertTrue(elf.isMale());
        assertEquals(234, elf.getAge());
        assertEquals(56.5F, elf.getWeight());
        assertEquals(1.65F, elf.getHeight());
        assertArrayEquals(illnesses, elf.getIllnesses());
    }

    @Test
    public void testElfGetName() {
        assertEquals("Elf", elf.getName());
    }

    @Test
    public void testElfIsMale() {
        assertTrue(elf.isMale());
    }

    @Test
    public void testElfGetAge() {
        assertEquals(234, elf.getAge());
    }

    @Test
    public void testElfGetWeight() {
        assertEquals(56.5F, elf.getWeight());
    }

    @Test
    public void testElfGetHeight() {
        assertEquals(1.65F, elf.getHeight());
    }

    @Test
    public void testElfGetIllnesses() {
        assertArrayEquals(illnesses, elf.getIllnesses());
    }

    @Test
    public void testElfSetAge() {
        elf.setAge(45);
        assertEquals(45, elf.getAge());
    }

    @Test
    public void testElfSetWeight() {
        elf.setWeight(65.5F);
        assertEquals(65.5F, elf.getWeight());
    }

    @Test
    public void testElfSetHeight() {
        elf.setHeight(1.75F);
        assertEquals(1.75F, elf.getHeight());
    }

    @Test
    public void testElfSetMale() {
        elf.setMale(false);
        assertFalse(elf.isMale());
    }

    @Test
    public void testElfSetName() {
        elf.setName("Elf2");
        assertEquals("Elf2", elf.getName());
    }

    @Test
    public void testElfSetIllnesses() {
        Illness[] illnesses2 = new Illness[]{new Illness(Illnesses.DRS), new Illness(Illnesses.MDC)};
        elf.setIllnesses(illnesses2);
        assertArrayEquals(illnesses2, elf.getIllnesses());
    }

    // dwarf tests

    @Test
    public void testDwarfConstructor() {
        assertEquals("Dwarf", dwarf.getName());
        assertFalse(dwarf.isMale());
        assertEquals(56, dwarf.getAge());
        assertEquals(45.5F, dwarf.getWeight());
        assertEquals(1.55F, dwarf.getHeight());
        assertArrayEquals(illnesses, dwarf.getIllnesses());
    }

    @Test
    public void testDwarfGetName() {
        assertEquals("Dwarf", dwarf.getName());
    }

    @Test
    public void testDwarfIsMale() {
        assertFalse(dwarf.isMale());
    }

    @Test
    public void testDwarfGetAge() {
        assertEquals(56, dwarf.getAge());
    }

    @Test
    public void testDwarfGetWeight() {
        assertEquals(45.5F, dwarf.getWeight());
    }

    @Test
    public void testDwarfGetHeight() {
        assertEquals(1.55F, dwarf.getHeight());
    }

    @Test
    public void testDwarfGetIllnesses() {
        assertArrayEquals(illnesses, dwarf.getIllnesses());
    }

    @Test
    public void testDwarfSetAge() {
        dwarf.setAge(45);
        assertEquals(45, dwarf.getAge());
    }

    @Test
    public void testDwarfSetWeight() {
        dwarf.setWeight(65.5F);
        assertEquals(65.5F, dwarf.getWeight());
    }

    @Test
    public void testDwarfSetHeight() {
        dwarf.setHeight(1.75F);
        assertEquals(1.75F, dwarf.getHeight());
    }

    @Test
    public void testDwarfSetMale() {
        dwarf.setMale(true);
        assertTrue(dwarf.isMale());
    }

    @Test
    public void testDwarfSetName() {
        dwarf.setName("Dwarf2");
        assertEquals("Dwarf2", dwarf.getName());
    }

    @Test
    public void testDwarfSetIllnesses() {
        Illness[] illnesses2 = new Illness[]{new Illness(Illnesses.DRS), new Illness(Illnesses.MDC)};
        dwarf.setIllnesses(illnesses2);
        assertArrayEquals(illnesses2, dwarf.getIllnesses());
    }

    // beastMan tests

    @Test
    public void testBeastManConstructor() {
        assertEquals("BeastMan", beastMan.getName());
        assertFalse(beastMan.isMale());
        assertEquals(78, beastMan.getAge());
        assertEquals(89.5F, beastMan.getWeight());
        assertEquals(1.95F, beastMan.getHeight());
        assertArrayEquals(illnesses, beastMan.getIllnesses());
    }

    @Test
    public void testBeastManGetName() {
        assertEquals("BeastMan", beastMan.getName());
    }

    @Test
    public void testBeastManIsMale() {
        assertFalse(beastMan.isMale());
    }

    @Test
    public void testBeastManGetAge() {
        assertEquals(78, beastMan.getAge());
    }

    @Test
    public void testBeastManGetWeight() {
        assertEquals(89.5F, beastMan.getWeight());
    }

    @Test
    public void testBeastManGetHeight() {
        assertEquals(1.95F, beastMan.getHeight());
    }

    @Test
    public void testBeastManGetIllnesses() {
        assertArrayEquals(illnesses, beastMan.getIllnesses());
    }

    @Test
    public void testBeastManSetAge() {
        beastMan.setAge(45);
        assertEquals(45, beastMan.getAge());
    }

    @Test
    public void testBeastManSetWeight() {
        beastMan.setWeight(65.5F);
        assertEquals(65.5F, beastMan.getWeight());
    }

    @Test
    public void testBeastManSetHeight() {
        beastMan.setHeight(1.75F);
        assertEquals(1.75F, beastMan.getHeight());
    }

    @Test
    public void testBeastManSetMale() {
        beastMan.setMale(true);
        assertTrue(beastMan.isMale());
    }

    @Test
    public void testBeastManSetName() {
        beastMan.setName("BeastMan2");
        assertEquals("BeastMan2", beastMan.getName());
    }

    @Test
    public void testBeastManSetIllnesses() {
        Illness[] illnesses2 = new Illness[]{new Illness(Illnesses.DRS), new Illness(Illnesses.MDC)};
        beastMan.setIllnesses(illnesses2);
        assertArrayEquals(illnesses2, beastMan.getIllnesses());
    }

    // service tests

    @Test
    public void testServiceConstructor() {
        assertEquals("Service", service.getName());
        assertEquals(100.0F, service.getSurface());
        assertEquals(10, service.getCreatureMax());
        assertEquals(3, service.getCreatureNow());
        assertArrayEquals(new Creature[]{orc, lycanthrope, beastMan}, service.getCreatures());
        assertEquals(2, service.getBudget());
    }

    @Test
    public void testServiceGetName() {
        assertEquals("Service", service.getName());
    }

    @Test
    public void testServiceSetName() {
        service.setName("Service2");
        assertEquals("Service2", service.getName());
    }

    @Test
    public void testServiceGetSurface() {
        assertEquals(100.0F, service.getSurface());
    }

    @Test
    public void testServiceSetSurface() {
        service.setSurface(150.0F);
        assertEquals(150.0F, service.getSurface());
    }

    @Test
    public void testServiceGetCreatureMax() {
        assertEquals(10, service.getCreatureMax());
    }

    @Test
    public void testServiceGetCreatureNow() {
        assertEquals(3, service.getCreatureNow());
    }

    @Test
    public void testServiceGetCreatures() {
        assertArrayEquals(new Creature[]{orc, lycanthrope, beastMan}, service.getCreatures());
    }

    @Test
    public void testServiceGetBudget() {
        assertEquals(2, service.getBudget());
    }

    @Test
    public void testServiceSetBudget() {
        service.setBudget(3);
        assertEquals(3, service.getBudget());
    }

    // crypt tests

    @Test
    public void testCryptConstructor() {
        assertEquals("Crypt", crypt.getName());
        assertEquals(50.0F, crypt.getSurface());
        assertEquals(5, crypt.getCreatureMax());
        assertEquals(2, crypt.getCreatureNow());
        assertArrayEquals(new Creature[]{vampire, zombie}, crypt.getCreatures());
        assertEquals(0, crypt.getBudget());
    }

    @Test
    public void testCryptGetName() {
        assertEquals("Crypt", crypt.getName());
    }

    @Test
    public void testCryptSetName() {
        crypt.setName("Crypt2");
        assertEquals("Crypt2", crypt.getName());
    }

    @Test
    public void testCryptGetSurface() {
        assertEquals(50.0F, crypt.getSurface());
    }

    @Test
    public void testCryptSetSurface() {
        crypt.setSurface(150.0F);
        assertEquals(150.0F, crypt.getSurface());
    }

    @Test
    public void testCryptGetCreatureMax() {
        assertEquals(5, crypt.getCreatureMax());
    }

    @Test
    public void testCryptGetCreatureNow() {
        assertEquals(2, crypt.getCreatureNow());
    }

    @Test
    public void testCryptGetCreatures() {
        assertArrayEquals(new Creature[]{vampire, zombie}, crypt.getCreatures());
    }

    @Test
    public void testCryptGetBudget() {
        assertEquals(0, crypt.getBudget());
    }

    @Test
    public void testCryptSetBudget() {
        crypt.setBudget(3);
        assertEquals(3, crypt.getBudget());
    }

    // quarantine center tests

    @Test
    public void testQuarantineCenterConstructor() {
        assertEquals("Quarantine Center", quarantineCenter.getName());
        assertEquals(150.0F, quarantineCenter.getSurface());
        assertEquals(15, quarantineCenter.getCreatureMax());
        assertEquals(2, quarantineCenter.getCreatureNow());
        assertArrayEquals(new Creature[]{elf, dwarf}, quarantineCenter.getCreatures());
        assertEquals(1, quarantineCenter.getBudget());
    }

    @Test
    public void testQuarantineCenterGetName() {
        assertEquals("Quarantine Center", quarantineCenter.getName());
    }

    @Test
    public void testQuarantineCenterSetName() {
        quarantineCenter.setName("Quarantine Center2");
        assertEquals("Quarantine Center2", quarantineCenter.getName());
    }

    @Test
    public void testQuarantineCenterGetSurface() {
        assertEquals(150.0F, quarantineCenter.getSurface());
    }

    @Test
    public void testQuarantineCenterSetSurface() {
        quarantineCenter.setSurface(200.0F);
        assertEquals(200.0F, quarantineCenter.getSurface());
    }

    @Test
    public void testQuarantineCenterGetCreatureMax() {
        assertEquals(15, quarantineCenter.getCreatureMax());
    }

    @Test
    public void testQuarantineCenterGetCreatureNow() {
        assertEquals(2, quarantineCenter.getCreatureNow());
    }

    @Test
    public void testQuarantineCenterGetCreatures() {
        assertArrayEquals(new Creature[]{elf, dwarf}, quarantineCenter.getCreatures());
    }

    @Test
    public void testQuarantineCenterGetBudget() {
        assertEquals(1, quarantineCenter.getBudget());
    }

    @Test
    public void testQuarantineCenterSetBudget() {
        quarantineCenter.setBudget(3);
        assertEquals(3, quarantineCenter.getBudget());
    }

    // hospital tests

    @Test
    public void testHospitalConstructor() {
        assertEquals("Hospital", hospital.getName());
        assertEquals(3, hospital.getServices().length);
        assertArrayEquals(new Service[]{service, crypt, quarantineCenter}, hospital.getServices());
        assertArrayEquals(new Doctor[]{doctor}, hospital.getDoctors());
    }

    @Test
    public void testHospitalGetName() {
        assertEquals("Hospital", hospital.getName());
    }

    @Test
    public void testHospitalSetName() {
        hospital.setName("Hospital2");
        assertEquals("Hospital2", hospital.getName());
    }

    @Test
    public void testHospitalGetServices() {
        assertArrayEquals(new Service[]{service, crypt, quarantineCenter}, hospital.getServices());
    }

    @Test
    public void testHospitalGetDoctors() {
        assertArrayEquals(new Doctor[]{doctor}, hospital.getDoctors());
    }

    @Test
    public void testHospitalSetServices() {
        Service[] services = new Service[]{service, crypt, quarantineCenter, new Service("Service2", 100.0F, 10, 5, new Creature[]{orc, lycanthrope, beastMan}, 2)};
        hospital.setServices(services);
        assertArrayEquals(services, hospital.getServices());
    }

    @Test
    public void testHospitalSetDoctors() {
        Doctor[] doctors = new Doctor[]{doctor, new Doctor("Jane Doe", false, 45)};
        hospital.setDoctors(doctors);
        assertArrayEquals(doctors, hospital.getDoctors());
    }

    @Test
    public void testHospitalGetServiceMax() {
        assertEquals(5, hospital.getServiceMax());
    }

    @Test
    public void testHospitalGetCreatures() {
        Creature[] creatures = hospital.getCreatures();
        assertArrayEquals(new Creature[]{orc, lycanthrope, beastMan, vampire, zombie, elf, dwarf}, creatures);
    }

    @Test
    public void testHospitalGetCreatureNow() {
        assertEquals(7, hospital.getCreatureNow());
    }
}
