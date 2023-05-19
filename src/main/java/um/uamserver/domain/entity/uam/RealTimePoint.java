package um.uamserver.domain.entity.uam;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class RealTimePoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    double altitude;
    double longitude;
    double latitude;
    LocalDateTime time;

    @JsonIgnore
    @ManyToOne
    @JoinColumn
    Uam uam;
}
