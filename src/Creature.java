import java.util.Arrays;

public abstract class Creature {
    private String name;
    private boolean is_male;
    private float weight;
    private float height;
    private int age;
    private int moral;
    private Illness[] illnesses;

    public Creature(String name, boolean is_male, float weight, float height, int age, int moral, Illness[] maladies) {
        this.name = name;
        this.is_male = is_male;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.moral = moral;
        this.illnesses = maladies;
    }

    public Creature(String name, boolean is_male, float weight, float height, int age, Illness[] maladies) {
        this.name = name;
        this.is_male = is_male;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.moral = 100;
        this.illnesses = maladies;
    }

    public Creature(String name, boolean is_male, int age) {
        this.name = name;
        this.is_male = is_male;
        this.weight = 70.8F;
        this.height = 1.80F;
        this.age = age;
        this.moral = 100;
        this.illnesses = new Illness[0];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIs_male() {
        return is_male;
    }

    public void setIs_male(boolean is_male) {
        this.is_male = is_male;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMoral() {
        return moral;
    }

    public void setMoral(int moral) {
        this.moral = moral;
    }

    public Illness[] getIllnesses() {
        return illnesses;
    }

    public void setIllnesses(Illness[] illnesses) {
        this.illnesses = illnesses;
    }

    public void cure(Illness maladie) {
        for (Illness illness : this.illnesses) {
            if (illness.getName().equals(maladie.getName())) {
                illness.downgrade();
            }
        }
    }

    public void waitATime(Service service) {
        this.moral--;
        if (this.moral <= -3) {
            this.panic();
        } else if (this.moral == 0) {
            this.cry();
        } else {
            System.out.println(this.name + " attend");
        }
    }

    public void cry() {
        System.out.println(this.name + " hurle de douleur");
    }

    public void panic() {
        System.out.println(this.name + " s'emporte");
    }

    public void passAway(Service service) {
        for (Illness illness : this.illnesses) {
            if (illness.is_mortal()) {
                System.out.println(this.name + " trepasse");
                service.removeCreature(this);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Creature{" +
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
