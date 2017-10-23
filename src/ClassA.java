import java.lang.reflect.*;

/**
 * Encapsulates two field
 */
public class ClassA {
    private String text;
    private int number;

    /**
     * Output object's field on console
     *
     * @param text any String text
     * @param i    any int number
     */
    private String run(String text, Integer i) {
        return (text + " " + i);
    }

    public String getText() {
        return text;
    }

    public int getNumber() {
        return number;
    }
}
