package exemplo;

import java.time.*;

/**
 *
 * @author Julio
 */
public interface TimeClient {
    void setTime(int hour, int minute, int second);
    void setDate(int day, int month, int year);
    void setDateAndTime(int day, int month, int year, int hour, int minute, int second);
    LocalDateTime getLocalDateTime();
    
    static ZoneId getZoneId (String zoneString) {
        try {
            return ZoneId.of(zoneString);
        } catch (DateTimeException e) {
            System.err.println("Invalid time zone: " + zoneString +
                "; using default time zone instead.");
            return ZoneId.systemDefault();
        }
    }
        
    default ZonedDateTime getZonedDateTime(String zoneString) {
        //Observem a forma como podemos usar o estado de um objeto
        //O método getLocalDateTime() é abstrato e será implementado futuramente
        //É um padrão de projeto: TemplateMethod
        return ZonedDateTime.of(getLocalDateTime(), getZoneId(zoneString));
    }
}
