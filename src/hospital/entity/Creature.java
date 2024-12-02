package hospital.entity;

import java.util.Random;

/**
 * The Creature class
 */
public abstract class Creature implements Entity {
    /**
     * The default weight and height of a creature
     */
    protected static final float DEFAULT_WEIGHT = 70.8F;
    protected static final float DEFAULT_HEIGHT = 1.80F;

    /**
     * The Random object
     */
    protected final Random random = new Random();

    /**
     * The name of the creature
     */
    private String name;
    /**
     * The sex of the creature
     */
    private boolean isMale;
    /**
     * The weight of the creature
     */
    private float weight;
    /**
     * The height of the creature
     */
    private float height;
    /**
     * The age of the creature
     */
    private int age;

    /**
     * Constructor of the Creature class
     *
     * @param name   the name of the creature
     * @param isMale the sex of the creature
     * @param age    the age of the creature
     * @param weight the weight of the creature
     * @param height the height of the creature
     */
    public Creature(String name, boolean isMale, int age, float weight, float height) {
        this.name = name;
        this.isMale = isMale;
        this.weight = weight;
        this.height = height;
        this.age = age;
    }

    /**
     * Second constructor of the Creature class
     *
     * @param name   the name of the creature
     * @param isMale the sex of the creature
     * @param age    the age of the creature
     */
    public Creature(String name, boolean isMale, int age) {
        this.name = name;
        this.isMale = isMale;
        this.weight = DEFAULT_WEIGHT;
        this.height = DEFAULT_HEIGHT;
        this.age = age;
    }

    /**
     * The name of the entity
     * @return the name of the entity
     */
    @Override
    public String getName(){
        return this.name;
    }

    /**
     * Set the name of the entity
     * @param name the name of the entity
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The sex of the entity
     * @return the sex of the entity
     */
    @Override
    public boolean isMale() {
        return this.isMale;
    }

    /**
     * Set the sex of the entity
     * @param isMale the sex of the entity
     */
    @Override
    public void setMale(boolean isMale) {
        this.isMale = isMale;
    }

    /**
     * The age of the entity
     * @return the age of the entity
     */
    @Override
    public int getAge() {
        return this.age;
    }

    /**
     * Set the age of the entity
     * @param age the age of the entity
     */
    @Override
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * The weight of the entity
     * @return the weight of the entity
     */
    @Override
    public float getWeight() {
        return this.weight;
    }

    /**
     * Set the weight of the entity
     * @param weight the weight of the entity
     */
    @Override
    public void setWeight(float weight) {
        this.weight = weight;
    }

    /**
     * The height of the entity
     * @return the height of the entity
     */
    @Override
    public float getHeight() {
        return this.height;
    }

    /**
     * Set the height of the entity
     * @param height the height of the entity
     */
    @Override
    public void setHeight(float height) {
        this.height = height;
    }

    /**
     * Return the string representation of the creature
     * @return the string representation of the creature
     */
    @Override
    public String toString() {
        return "Creature{" +
                "name='" + name + '\'' +
                ", isMale=" + isMale +
                ", weight=" + weight +
                ", height=" + height +
                ", age=" + age +
                '}';
    }
}