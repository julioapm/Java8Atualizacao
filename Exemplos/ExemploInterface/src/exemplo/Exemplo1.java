package exemplo;

/**
 *
 * @author Julio
 */
public class Exemplo1 {
    public static void main(String[] args) {
        TimeClient myTimeClient = new SimpleTimeClient();
        System.out.println(myTimeClient.toString());
        System.out.println("Time in São Paulo: " + myTimeClient.getZonedDateTime("Blah blah").toString());
    }
}
