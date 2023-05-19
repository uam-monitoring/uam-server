package um.uamserver.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import um.uamserver.domain.entity.flight_schedule.FlightSchedule;
import um.uamserver.domain.entity.vertiport.Vertiport;
import um.uamserver.domain.entity.vertiport.VertiportType;

import java.util.List;
import java.util.Map;

@Getter
@NoArgsConstructor
public class FlightScheduleDto {
    private VertiportDto departurePort;
    private VertiportDto arrivalPort;
    private List<WayPointDto> wayPoints;

    public FlightScheduleDto(FlightSchedule flightSchedule){
        Map<VertiportType, Vertiport> vertiports = flightSchedule.getVertiports();
        VertiportDto departure = new VertiportDto(vertiports.get(VertiportType.DEPARTURE));
        VertiportDto arrival = new VertiportDto(vertiports.get(VertiportType.ARRIVAL));
        List<WayPointDto> points = flightSchedule.getRoute().stream()
                .map(WayPointDto::new)
                .toList();
        this.departurePort = departure;
        this.arrivalPort = arrival;
        this.wayPoints = points;
    }

}
