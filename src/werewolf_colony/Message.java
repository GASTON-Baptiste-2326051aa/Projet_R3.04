package werewolf_colony;

/**
 * The `Message` enum represents different types of messages that can be used by werewolves.
 */
public enum Message {
    /**
     * Message indicating a pack.
     */
    PACK("werewolf_colony"),

    /**
     * Message indicating a response to a pack.
     */
    PACK_ANSWER("pack_answer"),

    /**
     * Message indicating domination.
     */
    DOMINATION("domination"),

    /**
     * Message indicating submission.
     */
    SUBMISSION("submission"),

    /**
     * Message indicating anger.
     */
    ANGRY("angry");

    /**
     * The value of the message.
     */
    private final String value;

    /**
     * Constructor for the `Message` enum.
     * @param value the value of the message
     */
    Message(String value) {
        this.value = value;
    }

    /**
     * Returns the value of the message.
     * @return the value of the message
     */
    public String getValue() {
        return this.value;
    }

    /**
     * Returns the string representation of the message.
     * @return the string representation of the message
     */
    @Override
    public String toString() {
        return "Message: " + this.name();
    }
}