package exemplo;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 *
 * @author Julio
 */
public class Exemplo1 {

    public static void main(String[] args) {
        DayOfWeek ds = DayOfWeek.MONDAY;
        System.out.println(ds);
        System.out.println(ds.plus(2));
        System.out.println(ds.getDisplayName(TextStyle.FULL, Locale.getDefault()));
        System.out.println(ds.getDisplayName(TextStyle.NARROW, Locale.getDefault()));
        System.out.println(ds.getDisplayName(TextStyle.SHORT, Locale.getDefault()));
    }
}
