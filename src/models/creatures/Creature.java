package models.creatures;

import models.Illness;
import models.services.Service;

import java.util.Arrays;
import java.util.Random;

public abstract class Creature {
    /**
     * The maximum and minimum moral of a creature
     */
    private static final int MORAL_MAX = 100;
    private static final int MORAL_MIN = -5;

    /**
     * The default weight and height of a creature
     */
    private static final float DEFAULT_WEIGHT = 70.8F;
    private static final float DEFAULT_HEIGHT = 1.80F;

    private String name;
    private boolean is_male;
    private float weight;
    private float height;
    private int age;
    private int morale;
    private Illness[] illnesses;

    /**
     * Constructor of the Creature class
     * @param name the name of the creature
     * @param is_male the sexe of the creature
     * @param age the age of the creature
     * @param weight the weight of the creature
     * @param height the height of the creature
     * @param morale the moral of the creature
     * @param maladies the illnesses of the creature
     */

    public Creature(String name, boolean is_male, int age, float weight, float height, int morale, Illness[] illnesses) {
        this.name = name;
        this.is_male = is_male;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.morale = morale;
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
        this.moral = MORAL_MAX;
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
        this.weight = DEFAULT_WEIGHT;
        this.height = DEFAULT_HEIGHT;
        this.age = age;
        this.moral = MORAL_MAX;
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
    public int getMorale() {
        return morale;
    }

    /**
     * Set the moral of a creature
     * @param morale the moral of the creature
     */
    public void setMoral(int moral) {
        if (moral > MORAL_MAX) {
            this.moral = MORAL_MAX;
        } else this.moral = Math.max(moral, MORAL_MIN);
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
     * Cure an illness of a creature
     * @param illness the illness to cure
     */
    public void addIllness(Illness illness) {
        for (Illness illnesses : this.illnesses) {
            if (illnesses.getName().equals(illness.getName())) {
                illnesses.increase();
                return;
            }
        }
        Illness[] newIllnesses = new Illness[this.illnesses.length + 1];
        System.arraycopy(this.illnesses, 0, newIllnesses, 0, this.illnesses.length);
        newIllnesses[this.illnesses.length] = illness;
        this.illnesses = newIllnesses;
    }

    /**
     * Increase all the illnesses of a creature
     */
    public void worseAllIllness() {
        for (Illness illness : this.illnesses) {
            illness.increase();
            this.moral -= 10;
        }
    }

    /**
     * Increase an illness to a creature
     * @param illness the illness to increase
     */
    public void worseIllness(Illness illness) {
        for (Illness illnesses : this.illnesses) {
            if (illnesses.getName().equals(illness.getName())) {
                illnesses.increase();
                this.moral -= 10;
            }
        }
    }

    /**
     * Cure all the illnesses of a creature
     */
    public void cureAllIllness() {
        for (Illness illness : this.illnesses) {
            illness.decrease();
            this.moral += 10;
        }
    }

    /**
     * Cure an illness to a creature
     * @param illness the illness to cureIllness
     */
    public void cureIllness(Illness illness) {
        for (Illness illnesses : this.illnesses) {
            if (illnesses.getName().equals(illness.getName())) {
                illnesses.decrease();
                this.moral += 10;
            }
            this.morale += 20; // Since the creature is being cured, his morale increased
        }
    }

    public void addIllness(Illness illness) {

    }

    /**
     * The creature wait
     * @param service the service where the creature is
     */
    public void waitATime(Service service) {
        this.moral--;
        if (this.moral <= MORAL_MIN) {
            this.panic();
        } else if (this.moral == 0) {
            this.cry();
        } else {
            System.out.println(this.name + " wait a time");
        }
    }

    /**
     * The creature scream in pain if it's morale is at it's lowest
     */
    public void scream() {
        System.out.println(this.name + " scream in pain");
    }

    /**
     * The creature gets carried away if it screams too many times
     */
    public void carriedAway() {

        System.out.println(this.name + " get carried away");
    }

    /**
     * The creature passes away
     * @param service the service where the creature is
     */
    public boolean passAway(Service service) {
        boolean isDead = false;
        Random random = new Random();
        for (Illness illness : this.illnesses) {
            if (!isDead && illness.is_mortal()) {
                random.nextInt(1, illness.getLvlMax());
                if (random.nextInt() == 1) {
                    isDead = true;
                }
            }
        }
        if (isDead) {
            System.out.println(this.name + " pass away");
        }
        return isDead;
    }

    // TODO
    // Déclarer ces fonctions ici puis utiliser un OVERRIDE ?
    public void contaminate(Service service){

    }
    public void revive(Service service){

    }
    public void demoralize(Service service){
      
    }

    @Override
    public String toString() {
        return "Creature{" +
                "name='" + name + '\'' +
                ", is_male=" + is_male +
                ", weight=" + weight +
                ", height=" + height +
                ", age=" + age +
                ", moral=" + morale +
                ", illnesses=" + Arrays.toString(illnesses) +
                '}';
    }
}
