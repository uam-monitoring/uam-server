package um.uamserver.domain.entity.vertiport;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import um.uamserver.domain.entity.flight_schedule.FlightSchedule;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Vertiport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double latitude;
    private double longitude;
    @ManyToOne
    @JoinColumn
    FlightSchedule flightSchedule;
}
