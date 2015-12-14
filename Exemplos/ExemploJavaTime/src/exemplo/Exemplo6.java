package exemplo;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

/**
 *
 * @author Julio
 */
public class Exemplo6 {
    public static void main(String[] args) {
        Instant t1 = Instant.now();
        Instant t2 = t1.plusSeconds(3);
        long ns = Duration.between(t1, t2).toNanos();
        System.out.println(ns);
        
        LocalDate d1 = LocalDate.of(1975, Month.MARCH, 15);
        LocalDate d2 = LocalDate.now();
        Period p = Period.between(d1, d2);
        System.out.println(p.getYears());
        System.out.println(p.getMonths());
        System.out.println(p.getDays());
    }
}
