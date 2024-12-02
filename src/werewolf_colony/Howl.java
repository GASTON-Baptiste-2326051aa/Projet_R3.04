package werewolf_colony;

public class Howl {
    private final Werewolf from;
    private final Message message;
    private final long time;

    /**
     * Constructor of the Howling class
     * @param from
     * @param message
     */
    public Howl(Werewolf from, Message message) {
        this.from = from;
        this.message = message;
        this.time = System.currentTimeMillis();
    }

    public Howl(Werewolf from, Werewolf to, Message message) {
        this.from = from;
        this.message = message;
        this.time = System.currentTimeMillis();
    }

    public Werewolf getFrom() {
        return this.from;
    }

    public Message getMessage() {
        return this.message;
    }

    public long getTime() {
        return time;
    }
}
