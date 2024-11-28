package pack;

public class Hurlement {
    private final Werewolf from;
    private final Werewolf to;
    private final Message message;
    private final long time;

    /**
     * Constructor of the Howling class
     * @param from
     * @param message
     */
    public Hurlement(Werewolf from, Message message) {
        this.from = from;
        this.to = null;
        this.message = message;
        this.time = System.currentTimeMillis();
    }

    public Hurlement(Werewolf from, Werewolf to, Message message) {
        this.from = from;
        this.to = to;
        this.message = message;
        this.time = System.currentTimeMillis();
    }

    public Werewolf getFrom() {
        return this.from;
    }

    public Werewolf getTo() {
        return this.to;
    }

    public Message getMessage() {
        return this.message;
    }

    public long getTime() {
        return time;
    }
}
