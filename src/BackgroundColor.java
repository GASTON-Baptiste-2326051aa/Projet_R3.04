/**
 * Enum for background color of text.
 */
public enum BackgroundColor {
    /**
     * Black background color.
     */
    BLACK("\u001B[40m"),
    /**
     * Red background color.
     */
    RED("\u001B[41m"),
    /**
     * Green background color.
     */
    GREEN("\u001B[42m"),
    /**
     * Yellow background color.
     */
    YELLOW("\u001B[43m"),
    /**
     * Blue background color.
     */
    BLUE("\u001B[44m"),
    /**
     * Purple background color.
     */
    PURPLE("\u001B[45m"),
    /**
     * Cyan background color.
     */
    CYAN("\u001B[46m"),
    /**
     * White background color.
     */
    WHITE("\u001B[47m"),
    /**
     * Reset background color.
     */
    RESET("\u001B[0m");

    /**
     * Color code.
     */
    private final String color;

    /**
     * Constructor for background color.
     * @param color color code
     */
    BackgroundColor(String color) {
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
     * Colorize the text with the background color.
     * @param text text to colorize
     * @return colorized text
     */
    public String colorize(String text) {
        return color + text + BackgroundColor.RESET.color;
    }
}