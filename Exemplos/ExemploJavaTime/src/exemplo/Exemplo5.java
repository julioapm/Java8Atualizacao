package exemplo;

import java.time.Instant;

/**
 *
 * @author Julio
 */
public class Exemplo5 {
    public static void main(String[] args) {
        Instant timestamp = Instant.now();
        System.out.println(timestamp);
        System.out.println(timestamp.getNano());
    }
}
