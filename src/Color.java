/**
 * Enum for color of text.
 */
public enum Color {
    /**
     * Black color.
     */
    BLACK("\u001B[30m"),
    /**
     * Red color.
     */
    RED("\u001B[31m"),
    /**
     * Green color.
     */
    GREEN("\u001B[32m"),
    /**
     * Yellow color.
     */
    YELLOW("\u001B[33m"),
    /**
     * Blue color.
     */
    BLUE("\u001B[34m"),
    /**
     * Purple color.
     */
    PURPLE("\u001B[35m"),
    /**
     * Cyan color.
     */
    CYAN("\u001B[36m"),
    /**
     * White color.
     */
    WHITE("\u001B[37m"),
    /**
     * Reset color.
     */
    RESET("\u001B[0m");

    /**
     * Color code.
     */
    private final String color;

    /**
     * Constructor for color.
     * @param color color code
     */
    Color(String color) {
        this.color = color;
    }

    /**
     * return the color code.
     * @return the color code
     */
    public String getColor() {
        return color;
    }

    /**
     * Colorize the text.
     * @param text text to colorize
     * @return colorized text
     */
    public String colorize(String text) {
        return color + text + Color.RESET.color;
    }
}