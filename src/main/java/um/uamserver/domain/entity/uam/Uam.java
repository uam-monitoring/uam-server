package um.uamserver.domain.entity.uam;

import jakarta.persistence.*;
import lombok.*;
import um.uamserver.domain.entity.flight_schedule.FlightSchedule;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Uam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "uam", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RealTimePoint> route;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private FlightSchedule flightSchedule;
}
