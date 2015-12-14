package exemplo;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 *
 * @author Julio
 */
public class Exemplo2 {

    public static void main(String[] args) {
        Month mes = Month.JANUARY;
        System.out.println(mes);
        System.out.println(mes.maxLength());
        System.out.println(mes.minus(2));
        System.out.println(mes.getDisplayName(TextStyle.FULL, Locale.getDefault()));
        System.out.println(mes.getDisplayName(TextStyle.NARROW, Locale.getDefault()));
        System.out.println(mes.getDisplayName(TextStyle.SHORT, Locale.getDefault()));
    }
}
