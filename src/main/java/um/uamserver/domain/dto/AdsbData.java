package um.uamserver.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import um.uamserver.domain.entity.uam.RealTimePoint;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor
@ToString
public class AdsbData {
    FlightIdentifier flightIdentifier;
    CurrentTime currentTime;
    CurrentPosition currentPosition;

    public AdsbData(RealTimePoint point){
        LocalDateTime time = point.getTime();
        this.flightIdentifier = new FlightIdentifier(point.getId());
        this.currentTime = new CurrentTime(time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), time.format(DateTimeFormatter.ofPattern("HH:mm:ss")), "UTC");
        this.currentPosition = new CurrentPosition(point.getAltitude(), point.getLatitude(), point.getLongitude());
    }
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    static class FlightIdentifier{
        Long uamIdentification;
    }
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    static class CurrentTime{
        String date;
        String time;
        String timeReference;
    }
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    static class CurrentPosition{
        double altitude;
        double longitude;
        double latitude;
    }
}
