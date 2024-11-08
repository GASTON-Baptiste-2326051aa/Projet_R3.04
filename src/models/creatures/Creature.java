package models.creatures;

import models.Illness;
import models.services.Service;

import java.util.Arrays;

public abstract class Creature {

    private String name;
    private boolean is_male;
    private float weight;
    private float height;
    private int age;
    private int moral;
    private Illness[] illnesses;

    /**
     * Constructor of the Creature class
     * @param name the name of the creature
     * @param is_male the sexe of the creature
     * @param age the age of the creature
     * @param weight the weight of the creature
     * @param height the height of the creature
     * @param moral the moral of the creature
     * @param maladies the illnesses of the creature
     */
    public Creature(String name, boolean is_male,int age, float weight, float height, int moral, Illness[] maladies) {
        this.name = name;
        this.is_male = is_male;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.moral = moral;
        this.illnesses = maladies;
    }

    /**
     * Second constructor of the Creature class
     * @param name the name of the creature
     * @param is_male the sexe of the creature
     * @param weight the weight of the creature
     * @param height the height of the creature
     * @param age the age of the creature
     * @param maladies the illnesses of the creature
     */
    public Creature(String name, boolean is_male, float weight, float height, int age, Illness[] maladies) {
        this.name = name;
        this.is_male = is_male;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.moral = 100;
        this.illnesses = maladies;
    }

    /**
     * Third constructor, used for the Doctor class
     * @param name the name of the creature
     * @param is_male the sexe of the creature
     * @param age the age of the creature
     */
    public Creature(String name, boolean is_male, int age) {
        this.name = name;
        this.is_male = is_male;
        this.weight = 70.8F;
        this.height = 1.80F;
        this.age = age;
        this.moral = 100;
        this.illnesses = new Illness[0];
    }

    /**
     * Return the name of a creature
     * @return the name of the creature
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of a creature
     * @param name the name of the creature
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * return if the creature is a male or not
     * @return true if it's a male, false otherwise
     */
    public boolean isMale() {
        return is_male;
    }

    /**
     * Set the gender of a creature
     * @param is_male : if it is true, it is a male, otherwise it is a female
     */
    public void setIs_Male(boolean is_male) {
        this.is_male = is_male;
    }

    /**
     * Return the weight of a creature
     * @return the weight of the creature
     */
    public float getWeight() {
        return weight;
    }

    /**
     * Set the weight of a creature
     * @param weight the weight of the creature
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }

    /**
     * Return the height of a creature
     * @return the height of the creature
     */
    public float getHeight() {
        return height;
    }

    /**
     * Set the height of a creature
     * @param height the height of the creature
     */
    public void setHeight(float height) {
        this.height = height;
    }

    /**
     * Return the age of a creature
     * @return the age of the creature
     */
    public int getAge() {
        return age;
    }

    /**
     * Set the age of a creature
     * @param age the age of the creature
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Return the moral of a creature
     * @return the moral of the creature
     */
    public int getMoral() {
        return moral;
    }

    /**
     * Set the moral of a creature
     * @param moral the moral of the creature
     */
    public void setMoral(int moral) {
        this.moral = moral;
    }

    /**
     * Return the illnesses of a creature
     * @return the illnesses of the creature
     */
    public Illness[] getIllnesses() {
        return illnesses;
    }

    /**
     * Set the illnesses of a creature
     * @param illnesses the illnesses of the creature
     */
    public void setIllnesses(Illness[] illnesses) {
        this.illnesses = illnesses;
    }

    /**
     * Add an illness to a creature
     * @param illness the illness to add
     */
    public void cure(Illness illness) {
        for (Illness illnesses : this.illnesses) {
            if (illnesses.getName().equals(illness.getName())) {
                illnesses.decrease();
            }
        }
    }

    /**
     * the creature wait a time
     * @param service the service where the creature is
     */
    public void waitATime(Service service) {
        this.moral--;
        if (this.moral <= -3) {
            this.panic();
        } else if (this.moral == 0) {
            this.cry();
        } else {
            System.out.println(this.name + " wait");
        }
    }

    /**
     * the creature scream in pain
     */
    public void cry() {
        System.out.println(this.name + " scream in pain");
    }

    /**
     * the creature get carried away
     */
    public void panic() {
        System.out.println(this.name + " get carried away");
    }

    /**
     * the creature pass away
     * @param service the service where the creature is
     */
    public void passAway(Service service) {
        for (Illness illness : this.illnesses) {
            if (illness.is_mortal()) {
                System.out.println(this.name + " pass away");
                service.removeCreature(this);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "models.creatures.Creature{" +
                "name='" + name + '\'' +
                ", is_male=" + is_male +
                ", weight=" + weight +
                ", height=" + height +
                ", age=" + age +
                ", moral=" + moral +
                ", illnesses=" + Arrays.toString(illnesses) +
                '}';
    }
}
