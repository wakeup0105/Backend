package hackerton.wakeup.chat.domain;

public enum Status {
    open("Open"),
    full("Full");
    private final String value;
    Status(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
