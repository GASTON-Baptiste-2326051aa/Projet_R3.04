package hospital.race;

import hospital.illness.Illness;
import hospital.services.Service;

import java.util.Arrays;
import java.util.Random;

public abstract class Creature {
    /**
     * The maximum and minimum moral of a creature
     */
    protected static final int MORAL_MAX = 100;
    protected static final int MORAL_MIN = -5;

    /**
     * The default weight and height of a creature
     */
    protected static final float DEFAULT_WEIGHT = 70.8F;
    protected static final float DEFAULT_HEIGHT = 1.80F;

    /**
     * The decrease of the moral of the creatures inside the service
     */
    protected static final int DEMORALIZE_DECREASE = 5;

    /**
     * The random object
     */
    protected final Random random = new Random();

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
     * @param illnesses the illnesses of the creature
     */
    public Creature(String name, boolean is_male, int age, float weight, float height, int morale, Illness[] illnesses) {
        this.name = name;
        this.is_male = is_male;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.morale = morale;
        this.illnesses = illnesses;
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
        this.morale = MORAL_MAX;
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
        this.morale = MORAL_MAX;
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
    public void setMale(boolean is_male) {
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
    public void setMorale(int morale) {
        if (morale > MORAL_MAX) {
            this.morale = MORAL_MAX;
        } else this.morale = Math.max(morale, MORAL_MIN);
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
    public void increaseAllIllness() {
        for (Illness illness : this.illnesses) {
            illness.increase();
            this.morale -= 10;
        }
    }

    /**
     * Increase an illness to a creature
     * @param illness the illness to increase
     */
    public void increaseIllness(Illness illness) {
        for (Illness illnesses : this.illnesses) {
            if (illnesses.getName().equals(illness.getName())) {
                illnesses.increase();
                this.morale -= 10;
            }
        }
    }

    /**
     * Cure all the illnesses of a creature
     */
    public void cureAllIllness() {
        for (Illness illness : this.illnesses) {
            illness.decrease();
            this.morale += 10;
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
                this.morale += 10;
            }
            this.morale += 20; // Since the creature is being cured, his moral increased
        }
    }

    /**
     * The creature wait
     * @param service the service where the creature is
     */
    public void waitATime(Service service) throws InterruptedException {
        this.morale--;
        wait(10000);
        if (this.morale <= MORAL_MIN) {
            this.carriedAway();
        } else if (this.morale <= 0) {
            this.scream();
        } else {
            System.out.println(this.name + " wait a time");

        }
    }

    /**
     * The creature scream in pain if it's moral is at it's lowest
     */
    public void scream() {
        System.out.println(this.name + " scream in pain ! ");
    }

    /**
     * The creature gets carried away if it screams too many times
     */
    public void carriedAway() {
        System.out.println(this.name + " get carried away ! ");
        for (int i = 0; i < 6; ++i){
            scream();
        }
    }

    /**
     * The creature passes away
     * @param service the service where the creature is
     * A FINALISER
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
            System.out.println(this.name + " passes away.");
        }
        return isDead;
    }

    /**
     * get all the mortal illnesses of the creature
     *
     * @return an array of mortal illnesses
     */
    public Illness[] getMortalIllnesses() {
        Illness[] mortalIllnesses = new Illness[getIllnesses().length];
        int i = 0;
        for (Illness illness : this.getIllnesses()) {
            if (illness.is_mortal()) {
                mortalIllnesses[i++] = illness;
            }
        }
        return mortalIllnesses;
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
