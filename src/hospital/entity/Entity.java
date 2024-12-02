package hospital.entity;

import java.util.Objects;

/**
 * The Entity interface
 */
public interface Entity {
    /**
     * The name of the entity
     * @return the name of the entity
     */
    String getName();

    /**
     * Set the name of the entity
     * @param name the name of the entity
     */
    void setName(String name);

    /**
     * The sex of the entity
     * @return the sex of the entity
     */
    boolean isMale();

    /**
     * Set the sex of the entity
     * @param isMale the sex of the entity
     */
    void setMale(boolean isMale);

    /**
     * The age of the entity
     * @return the age of the entity
     */
    int getAge();

    /**
     * Set the age of the entity
     * @param age the age of the entity
     */
    void setAge(int age);

    /**
     * The weight of the entity
     * @return the weight of the entity
     */
    float getWeight();

    /**
     * Set the weight of the entity
     * @param weight the weight of the entity
     */
    void setWeight(float weight);

    /**
     * The height of the entity
     * @return the height of the entity
     */
    float getHeight();

    /**
     * Set the height of the entity
     * @param height the height of the entity
     */
    void setHeight(float height);

    /**
     * Return the string representation of the entity
     * @return the string representation of the entity
     */
    String toString();

    /**
     * Compare two entities
     *
     * @param entity the entity to compare
     * @return true if the entities are equal
     */
    default boolean equals(Entity entity) {
        return Objects.equals(this, entity);
    }
}
