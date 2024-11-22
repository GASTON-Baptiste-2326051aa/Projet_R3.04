package pack;

public enum Message {
    LOVE("love"),
    HATE("hate"),
    FEAR("fear"),
    ANGER("anger"),
    HAPPINESS("happiness"),
    SADNESS("sadness");

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
