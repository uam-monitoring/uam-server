package um.uamserver.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import um.uamserver.domain.entity.flight_schedule.WayPoint;

@Getter
@NoArgsConstructor
public class WayPointDto {
    private double altitude;
    private double longitude;
    private double latitude;

    public WayPointDto(WayPoint wayPoint) {
        this.altitude = wayPoint.getAltitude();
        this.longitude = wayPoint.getLongitude();
        this.latitude = wayPoint.getLatitude();
    }
}
