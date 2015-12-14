package exemplo;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author Julio
 */
public class Exemplo4 {

    public static void main(String[] args) {
        LocalTime agora = LocalTime.now();
        System.out.println(agora);
        System.out.println(agora.plusSeconds(5));
        LocalDateTime agoraHoje = LocalDateTime.now();
        System.out.println(agoraHoje);

    }
}
