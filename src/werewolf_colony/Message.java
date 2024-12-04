package werewolf_colony;

public enum Message {
    PACK("pack"),
    PACK_ANSWER("pack_answer"),
    DOMINATION("domination"),
    SUBMISSION("submission"),
    ANGRY("angry");

    private final String value;

    Message(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "Message: " + this.name();
    }
}
