package um.uamserver.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FlightScheduleDto {
    private VertiportDto departurePort;
    private VertiportDto arrivalPort;
    private List<WayPointDto> wayPoints;
}
