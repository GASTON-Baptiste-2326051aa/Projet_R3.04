package pack;

public class Hurlement {
    private final Lycanthrope from;
    private final Lycanthrope to;
    private final Message message;
    private final long time;

    public Hurlement(Lycanthrope from, Message message) {
        this.from = from;
        this.to = null;
        this.message = message;
        this.time = System.currentTimeMillis();
    }

    public Hurlement(Lycanthrope from, Lycanthrope to, Message message) {
        this.from = from;
        this.to = to;
        this.message = message;
        this.time = System.currentTimeMillis();
    }

    public Lycanthrope getFrom() {
        return this.from;
    }

    public Lycanthrope getTo() {
        return this.to;
    }

    public Message getMessage() {
        return this.message;
    }

    public long getTime() {
        return time;
    }
}
