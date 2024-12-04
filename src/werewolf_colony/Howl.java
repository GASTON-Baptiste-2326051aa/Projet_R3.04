package werewolf_colony;

/**
 * The `Howl` class represents a howl made by a werewolf.
 */
public class Howl {
    /**
     * The werewolf that made the howl.
     */
    private final Werewolf from;

    /**
     * The message of the howl.
     */
    private final Message message;

    /**
     * The time the howl was made.
     */
    private final long time;

    /**
     * Constructor of the Howl class.
     * @param from the werewolf that made the howl
     * @param message the message of the howl
     */
    public Howl(Werewolf from, Message message) {
        this.from = from;
        this.message = message;
        this.time = System.currentTimeMillis();
    }

    /**
     * Constructor of the Howl class.
     * @param from the werewolf that made the howl
     * @param to the werewolf the howl is directed to
     * @param message the message of the howl
     */
    public Howl(Werewolf from, Werewolf to, Message message) {
        this.from = from;
        this.message = message;
        this.time = System.currentTimeMillis();
    }

    /**
     * Returns the werewolf that made the howl.
     * @return the werewolf that made the howl
     */
    public Werewolf getFrom() {
        return this.from;
    }

    /**
     * Returns the message of the howl.
     * @return the message of the howl
     */
    public Message getMessage() {
        return this.message;
    }

    /**
     * Returns the time the howl was made.
     * @return the time the howl was made
     */
    public long getTime() {
        return time;
    }

    /**
     * Returns the string representation of the howl.
     * @return the string representation of the howl
     */
    @Override
    public String toString() {
        return "Howl{" +
                "from=" + from +
                ", message=" + message +
                ", time=" + time +
                '}';
    }
}