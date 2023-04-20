package um.uamserver.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import um.uamserver.domain.entity.RealTimePoint;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@ToString
public class DataFormat {
    private Long uamId;
    double altitude;
    double longitude;
    double latitude;
    double velocity;
    LocalDateTime time;

    public DataFormat(RealTimePoint point){
        this.uamId = point.getUam().getId();
        this.altitude = point.getAltitude();
        this.latitude = point.getLatitude();
        this.velocity = point.getVelocity();
        this.time = point.getTime();
    }
}
