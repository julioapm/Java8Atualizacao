package exemplo;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;

/**
 *
 * @author Julio
 */
public class Exemplo3 {

    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);
        System.out.println(hoje.plusDays(30));
        MonthDay natal = MonthDay.of(Month.DECEMBER, 25);
        System.out.println(natal);
    }
}
