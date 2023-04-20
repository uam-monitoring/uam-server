package um.uamserver.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString
public class RealTimePoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    double altitude;
    double longitude;
    double latitude;
    double velocity;
    LocalDateTime time;

    @ManyToOne
    @JoinColumn
    Uam uam;
}
