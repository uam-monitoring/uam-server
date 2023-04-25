package um.uamserver.domain.entity.flight_schedule;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class WayPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    double altitude;
    double longitude;
    double latitude;

    @ManyToOne
    @JoinColumn
    FlightSchedule flightSchedule;
}
