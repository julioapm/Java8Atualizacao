package exemplo;

import java.time.ZonedDateTime;

/**
 *
 * @author Julio
 */
public interface AbstractZoneTimeClient extends TimeClient{
    @Override
    ZonedDateTime getZonedDateTime(String zoneString);
}
